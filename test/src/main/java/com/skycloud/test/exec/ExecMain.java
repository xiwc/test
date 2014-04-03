package com.skycloud.test.exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecMain {

	public static void main(String[] args) {
		try {
			// String[] cmd = new String[] { "/bin/sh", "-c", " ls " };

			String[] cmd = new String[] { "/bin/sh", "-c",
					" /opt/allmoni/bin/GetData.py -h 'AllmoniDB_35.76' -t AGENT " };

			Process ps = Runtime.getRuntime().exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String result = sb.toString();

			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
