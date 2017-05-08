/**
 * Copyright (c) 2014 Far Eastone Telecommunications Co., Ltd.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of 
 * Far Eastone Telecommunications Co., Ltd. ("Confidential Information"). 
 * 
 * You shall not disclose such Confidential Information and shall use it 
 * only in accordance with the terms of license agreement you entered
 * into with Far Eastone Telecommunications Co., Ltd.
 */

package com.pmt.caa.core.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期處理工具.
 *
 * @author VJChou
 */
public class DateUtil {

	/**
	 * Get current date.
	 * 
	 * @return string
	 */
	public static String getDate() {
		return _datetime("yyyy-MM-dd");
	}

	/**
	 * Get current date/time.
	 * 
	 * @return string
	 */
	public static String getDatetime() {
		return _datetime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Get current date/time.
	 *
	 * @param date the date
	 * @return string
	 */
	public static String getDatetime(Date date) {
		return _datetime("yyyy-MM-dd HH:mm:ss", date);
	}

	/**
	 * Get current date/time.
	 *
	 * @param format the format
	 * @param date the date
	 * @return string
	 */
	public static String getDatetime(String format, Date date) {
		return _datetime(format, date);
	}

	/**
	 * Get current date/time (by Locale).
	 *
	 * @param format the format
	 * @param date the date
	 * @param locale the locale
	 * @return string
	 */
	public static String getDatetime(String format, Date date, Locale locale) {
		return _datetime(format, date, locale);
	}

	/**
	 * Get timestamp.
	 *
	 * @param format the format
	 * @return string
	 */
	public static String getTimestamp(String format) {
		return _datetime(format);
	}

	/**
	 * Assign return data format.
	 *
	 * @param format the format
	 * @return string
	 */
	private static String _datetime(String format) {
		return _datetime(format, new Date());
	}

	/**
	 * Transform date string to Date object.
	 *
	 * @param date the date
	 * @param date_format the date_format
	 * @return Date
	 */
	public static Date transDate(String date, String date_format) {
		try {
			Date s_date = new SimpleDateFormat(date_format).parse(date);
			return s_date;
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Assign return data format.
	 *
	 * @param format the format
	 * @param date the date
	 * @return string
	 */
	private static String _datetime(String format, Date date) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date).toString();
	}

	/**
	 * Assign return data format (by Locale).
	 *
	 * @param format the format
	 * @param date the date
	 * @param locale the locale
	 * @return string
	 */
	private static String _datetime(String format, Date date, Locale locale) {
		SimpleDateFormat formater = new SimpleDateFormat(format, locale);
		return formater.format(date).toString();
	}

	   /**
   	 * Transform date string to Date object + i.
   	 *
   	 * @param dateStr the date str
   	 * @param date_format the date_format
   	 * @param i the i
   	 * @return Date
   	 */
    public static Object transDateAddDate(String dateStr, String date_format, int i) {
        
        try {
            Calendar cal = Calendar.getInstance();

            Date pDate = new SimpleDateFormat(date_format).parse(dateStr);

            cal.setTime(pDate);
            cal.add(Calendar.DATE, +i);
            
            String toDay =new SimpleDateFormat(date_format).format(cal.getTime()) ;
            
            Date s_date = new SimpleDateFormat(date_format).parse(toDay);
           
            return s_date;
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Trans timestamp.
     *
     * @param date the date
     * @return the timestamp
     */
    public static Timestamp transTimestamp(Date date) {
    	return new Timestamp(date.getTime());
    }
    
    /**
     * Check between date range.
     *
     * @param fromDate the from date
     * @param endDate the end date
     * @return true, if successful
     */
    public static boolean checkDateRange(String fromDate, String endDate) {
    	long fromTime = transDate(fromDate, "yyyy-MM-dd").getTime();
    	long endTime = transDate(endDate, "yyyy-MM-dd").getTime();
    	long todayTime = transDate(getDate(), "yyyy-MM-dd").getTime();
    	
    	if(fromTime <= todayTime && todayTime <= endTime) {
    		return true;
    	}
    	return false;
    }
    
}
