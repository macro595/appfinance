package com.xp.app.appfinance.util;

import java.util.Calendar;
import java.util.Date;

import com.yuanxin.framework.util.DateTimeUtils;

public class DateUtil {

	/**
	 *  取得两个日期之间的相差多少天
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static long getDaysBetween(Date date0, Date date1) {
		long daysBetween = (date0.getTime() - date1.getTime() + 1000000) / 86400000;// 86400000=3600*24*1000
																					// 用立即数，减少乘法计算的开销
		return daysBetween;
	}

	/**
	 *  取得某个月有多少天
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int days_of_month = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days_of_month;
	}

	/**
	 *  取得日期是某年的第几周
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
		return week_of_year;
	}

	/**
	 * 根据日期取得星期几
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * 某天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		date = calendar.getTime();
		date = DateTimeUtils.parseStrToDate(DateTimeUtils.formateDateToStr(date, DateTimeUtils.FORMAT_YMD),
				DateTimeUtils.FORMAT_YMD);
		return date;
	}

	/**
	 * 后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		date = DateTimeUtils.parseStrToDate(DateTimeUtils.formateDateToStr(date, DateTimeUtils.FORMAT_YMD),
				DateTimeUtils.FORMAT_YMD);
		return date;
	}

	/**
	 * 前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		date = DateTimeUtils.parseStrToDate(DateTimeUtils.formateDateToStr(date, DateTimeUtils.FORMAT_YMD),
				DateTimeUtils.FORMAT_YMD);
		return date;
	}

	public static void main(String[] args) {
		String startDate = String.valueOf(System.currentTimeMillis());
		String endDate = String.valueOf(System.currentTimeMillis());
		Date sd = new Date(Long.parseLong(startDate));
		Date ed = new Date(Long.parseLong(endDate));

		System.out.println(DateUtil.getPreDay(sd).getTime());
		System.out.println(DateUtil.getDay(sd));
		System.out.println(DateUtil.getNextDay(sd));
	}

}
