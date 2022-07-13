package br.com.application.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class DateUtil {

	public static Date getDataToday() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date today = new Date();
		dateFormat.format(today);
		return today;
	}

	public static Calendar getData() {

		Calendar calendar = new GregorianCalendar();
		Date dataTime = new Date();
		calendar.setTime(dataTime);
		return calendar;

	}

	public static String getDataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DateUtil today = new DateUtil();
		return dateFormat.format(today).toString();
	}
	
	public static String converterCalendarToString(Calendar calendar) throws Exception {
		String dataResponse = calendar.DAY_OF_MONTH + "/" + calendar.MONTH + "/" + calendar.YEAR;
		return dataResponse;
	}

	public static Calendar converterStringToCalendar(String data) throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		calendar.setTime(dateFormat.parse(data));
		return calendar;
	}
	
	public static void teste() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2000);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.MINUTE, 1);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}
    

	public static java.sql.Date converterCalendarToDate(Calendar calendario) throws Exception {
		java.sql.Date data = new java.sql.Date(calendario.getInstance().getTimeInMillis());
		return data;
	}

}
