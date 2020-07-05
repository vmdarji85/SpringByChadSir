package com.vivek.hibernate.demo;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
	// The date formatter
	// - dd: day in month (number)
	// - MM: month in year (number)
	// - yyyy: year
	//
	// See this link for details:
	// https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	
	public static SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
	
	public static Date parseDate(String dateStr) throws ParseException {
			Date theDate = formatter.parse(dateStr);
			return theDate;
	}
	
	public static String formateDate(Date theDate) {
		String result = null;
		if(theDate != null) {
			result = formatter.format(theDate);
			
		}
		
		return result;
	}
    

}
