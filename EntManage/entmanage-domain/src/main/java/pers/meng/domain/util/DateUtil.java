package pers.meng.domain.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	/**
	 * 按格式返回当前系统时间
	 * @param format 时间格式
	 * @return
	 */ 
	public static String getCurrentTime(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * 按格式返回固定时间
	 * @param date
	 * @param format时间格式
	 * @return
	 */
	public static String getCurrentTime(Date date,String format) {
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 转换字符串为日期
	 * @param date 日期字符串
	 * @param format 日期格式
	 * @return 转换失败返回null
	 */
	public static Date parseDate(String date,String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 按格式返回当前时间一定天数后的时间
	 * @param days 天数
	 * @param format 时间格式
	 * @return
	 */
	public static String addDays(int days,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	public static Date addDays(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
	
	/**
	 * 按格式返回指定时间一定天数后的时间
	 * @param startDate 指定时间
	 * @param days 天数
	 * @param format 时间格式
	 * @return
	 */
	public static String addDays(Date startDate,int days,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回当前时间一定月数后的时间
	 * @param months 月数
	 * @param format 时间格式
	 * @return
	 */
	public static String addMonths(int months,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, months);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回指定时间一定月数后的时间
	 * @param startDate 指定时间
	 * @param months 月份
	 * @param format 时间格式
	 * @return
	 */
	public static String addMonths(Date startDate,int months,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.MONTH, months);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回当前时间一定年数后的时间
	 * @param years 年数
	 * @param format 时间格式
	 * @return
	 */
	public static String addYears(int years,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, years);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回指定时间一定年数后的时间
	 * @param startDate 指定日期
	 * @param years 年数
	 * @param format 时间格式
	 * @return
	 */
	public static String addYears(Date startDate,int years,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.YEAR, years);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回当前时间一定秒数后的时间
	 * @param seconds 秒数
	 * @param format 时间格式
	 * @return
	 */
	public static String addSeconds(int seconds,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, seconds);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回指定时间一定秒数后的时间
	 * @param startDate 指定时间
	 * @param seconds 秒数
	 * @param format 时间格式
	 * @return
	 */
	public static String addSeconds(Date startDate,int seconds,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.SECOND, seconds);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回当前时间一定分数后的时间
	 * @param minutes 分数
	 * @param format 时间格式
	 * @return
	 */
	public static String addMinutes(int minutes,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回指定时间一定分数后的时间
	 * @param startDate 指定时间
	 * @param minutes 分数
	 * @param format 时间格式
	 * @return
	 */
	public static String addMinutes(Date startDate,int minutes,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.MINUTE, minutes);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回当前时间一定小时数后的时间
	 * @param hours 小时数
	 * @param format 时间格式
	 * @return
	 */
	public static String addHours(int hours,String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, hours);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 按格式返回指定时间一定小时数后的时间
	 * @param startDate 指定时间
	 * @param hours 小时数
	 * @param format 时间格式
	 * @return
	 */
	public static String addHours(Date startDate,int hours,String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.HOUR, hours);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	/**
	 * 校验日期字符串是否符合指定日期格式
	 * @param date 日期字符串，为空对象或空字符串时返回false
	 * @param format 日期格式
	 * @param formatForce 是否强制要求日期格式而不自动进位转化。true表示严格要求格式
	 * @return
	 */
	public static boolean validateDate(String date,String format,boolean formatForce) {
		if(date == null || "".equals(date.trim())) {
			return false;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(formatForce);
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	


    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getFirstDayOfWeek(int year, int week,String format) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);
        
        return new SimpleDateFormat(format).format(getFirstDayOfWeek(cal.getTime()));
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getLastDayOfWeek(int year, int week,String format) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return new SimpleDateFormat(format).format(getLastDayOfWeek(cal.getTime()));
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

/* /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     *//*
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }*/

    /**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                                    getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                                       getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    /**
     * 获取当前为第几周
     * @param 
     * * @return 
     */
    public static int getNowWeek() {
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    /**
     * 获取指定日期属于那一周
     * @param date
     * @return
     */
    public static int getWeek(String date)
    {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	try {
			Date DateObj = dateFormat.parse(date);
			c.setTime(DateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return c.get(Calendar.WEEK_OF_YEAR);
    }
    public static void main(String[] args) {
    	
		String beginDate=DateUtil.getFirstDayOfWeek(2009,54,"yyyy-MM-dd");
		System.out.println(beginDate);
    }
}
