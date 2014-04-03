import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecMain {

	static DecimalFormat format = new DecimalFormat("0.00");

	public static void main(String[] args) {

		System.out.println(15473746944D / 103570056192D);

		System.out.println("net.if.in[{#IFNAME}]".matches("^(net\\.if\\.in)\\[.*\\]$"));
		System.out.println("net.if.out[{#IFNAME}]".matches("^(net\\.if\\.out)\\[.*\\]$"));
		System.out.println("vfs.fs.size[{#FSNAME},used]".matches("^(vfs\\.fs\\.size)\\[.*,used\\]$"));
		System.out.println("vfs.fs.size[{#FSNAME},total]".matches("^(vfs\\.fs\\.size)\\[.*,total\\]$"));

		try {

			String[] cmd = new String[] { "/bin/sh", "-c",
					" /opt/allmoni/bin/GetData.py -h 'AllmoniDB_35.76' -t AGENT " };

			Process ps = Runtime.getRuntime().exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			String line = null;

			Map<String, String> map = new HashMap<String, String>();

			while ((line = br.readLine()) != null) {
				String[] kv = line.split(" ");
				if (kv.length > 1) {
					map.put(kv[0].trim(), kv[1].trim());
				}
			}

			List<Double> netIfInList = new ArrayList<>();
			List<Double> netIfOutList = new ArrayList<>();

			List<BigDecimal> fsUsedList = new ArrayList<>();
			List<BigDecimal> fsTotalList = new ArrayList<>();

			double cpu = 0;
			double cpu2 = 0;
			double mem = 0;
			double netIfIn = 0;
			double netIfOut = 0;
			BigDecimal fsUsed = BigDecimal.ZERO;
			BigDecimal fsTotal = BigDecimal.ZERO;

			for (String k : map.keySet()) {

				if ("system.cpu.util[,idle]".equals(k)) {
					cpu = 100 - Double.valueOf(map.get(k));
				}

				if ("AvgUsage".equals(k)) {
					cpu2 = Double.valueOf(map.get(k));
				}

				if ("vm.memory.size[pavailable]".equals(k)) {
					mem = 100 - Double.valueOf(map.get(k));
				}

				if (k.matches("^(net\\.if\\.out)\\[.*\\]$")) {
					netIfOutList.add(Double.valueOf(map.get(k)));
				}

				if (k.matches("^(net\\.if\\.in)\\[.*\\]$")) {
					netIfInList.add(Double.valueOf(map.get(k)));
				}

				if (k.matches("^(vfs\\.fs\\.size)\\[.*,used\\]$")) {
					fsUsedList.add(new BigDecimal(map.get(k)));
				}

				if (k.matches("^(vfs\\.fs\\.size)\\[.*,total\\]$")) {
					fsTotalList.add(new BigDecimal(map.get(k)));
				}

			}

			for (Double val : netIfInList) {
				netIfIn += val;
			}

			netIfIn = netIfIn / netIfInList.size() / 1000;

			for (Double val : netIfOutList) {
				netIfOut += val;
			}

			netIfOut = netIfOut / netIfOutList.size() / 1000;

			for (BigDecimal val : fsUsedList) {
				fsUsed = fsUsed.add(val);
			}
			System.out.println(fsUsed);

			for (BigDecimal val : fsTotalList) {
				fsTotal = fsTotal.add(val);
			}
			System.out.println(fsTotal);

			cpu = cpu == 0 ? cpu2 : cpu;

			System.out.println("cpu使用率的实时监控值(%)");
			System.out.println(format.format(cpu));

			System.out.println("内存使用率的实时监控值(%)");
			System.out.println(format.format(mem));

			System.out.println("流入流量的实时监控值(Kbps)");
			System.out.println(format.format(netIfIn));

			System.out.println("流出流量的实时监控值(Kbps)");
			System.out.println(format.format(netIfOut));

			System.out.println("磁盘使用率的实时监控值(%)");
			System.out.println(format.format((fsUsed.doubleValue() * 100 / fsTotal.doubleValue())));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
