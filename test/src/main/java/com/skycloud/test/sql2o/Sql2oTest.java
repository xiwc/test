package com.skycloud.test.sql2o;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.sql2o.Connection;
//import org.sql2o.Query;
//import org.sql2o.Sql2o;
//import org.sql2o.StatementRunnable;

public class Sql2oTest {

//	static Sql2o sql2o;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		sql2o = new Sql2o("jdbc:mysql://localhost:3306/test", "root", "skycloud");
//
//		Map<String, String> colMaps = new HashMap<String, String>();
//		colMaps.put("DUE_DATE", "dueDate");
//		colMaps.put("DESC", "description");
//		colMaps.put("E_MAIL", "email");
//		colMaps.put("SHORT_DESC", "shortDescription");
//
//		sql2o.setDefaultColumnMappings(colMaps);
//	}
//
//	@Test
//	public void test01() {
//		List<Task> allTasks = getAllTasks();
//
//		System.out.println(allTasks);
//	}
//
//	@Test
//	public void test02() {
//		Date fromDate = new DateTime().minusDays(10).toDate();
//		Date toDate = new DateTime().plusDays(10).toDate();
//		List<Task> tasksBetweenDates = getTasksBetweenDates(fromDate, toDate);
//
//		System.out.println(tasksBetweenDates);
//	}
//
//	public List<Task> getAllTasks() {
//		String sql = "SELECT id, description, duedate " + "FROM tasks";
//
//		return sql2o.createQuery(sql).executeAndFetch(Task.class);
//	}
//
//	public List<Task> getTasksBetweenDates(Date fromDate, Date toDate) {
//		String sql = "SELECT id, description, duedate " + "FROM tasks "
//				+ "WHERE duedate >= :fromDate AND duedate < :toDate";
//
//		Query query = sql2o.createQuery(sql);
//
//		query.addParameter("fromDate", fromDate);
//		query.addParameter("toDate", toDate);
//
//		return query.executeAndFetch(Task.class);
//	}
//
//	String sql1 = "INSERT INTO SomeTable(id, value) VALUES (:id, :value)";
//	String sql2 = "UPDATE SomeOtherTable SET value = :val WHERE id = :id";
//
//	public void test03() {
//		Connection connection = null;
//		try {
//			connection = sql2o.beginTransaction();
//			connection.createQuery(sql1).addParameter("id", "1").addParameter("val", "2").executeUpdate();
//			connection.createQuery(sql2).addParameter("id", "2").addParameter("val", "3").executeUpdate();
//			connection.commit();
//		} catch (Throwable t) {
//			if (connection != null) {
//				connection.rollback();
//			}
//			throw t;
//		}
//	}
//
//	public void insertABunchOfRows() {
//		final String sql = "INSERT INTO SomeTable(id, value) VALUES (:id, :value)";
//
//		sql2o.runInTransaction(new StatementRunnable() {
//			public void run(Connection connection, Object argument) throws Throwable {
//				Query query = connection.createQuery(sql);
//
//				for (int i = 0; i < 100; i++) {
//					query.addParameter("id", i).addParameter("value", "foo" + i).addToBatch();
//				}
//
//				query.executeBatch();
//			}
//		});
//	}
//
//	public List<Task> getTasksBetweenDates2(Date fromDate, Date toDate) {
//		String sql = "SELECT id, description, due_date " + "FROM tasks "
//				+ "WHERE due_date > :fromDate AND due_date < :toDate";
//
//		return sql2o.createQuery(sql).addParameter("fromDate", fromDate).addParameter("toDate", toDate)
//				.addColumnMapping("DUE_DATE", "dueDate").executeAndFetch(Task.class);
//	}
}
