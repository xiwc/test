package com.skycloud.test.datetime;

import hirondelle.date4j.DateTime;

public class Date4JTest {

	public static void main(String[] args) {

		DateTime dateTime = new DateTime("2013-05-08");
		dateTime = dateTime.plusDays(280);

		System.out.println(dateTime.toString());

		dateTime = new DateTime("2014-02-02");
		dateTime = dateTime.plusDays(-280);

		System.out.println(dateTime.toString());
	}

}
