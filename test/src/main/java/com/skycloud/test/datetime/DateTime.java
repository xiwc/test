package com.skycloud.test.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Calendar now = Calendar.getInstance();

		now.set(2014, 1, 2);

		System.out.println(dateFormat.format(now.getTime()));

		now.add(Calendar.DATE, -280);


		System.out.println(dateFormat.format(now.getTime()));
	}
}
