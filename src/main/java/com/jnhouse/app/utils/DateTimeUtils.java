package com.jnhouse.app.utils;


import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeUtils
{
  private static GregorianCalendar calendar = new GregorianCalendar();
  public static final String KEY_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
  public static final String KEY_FORMAT2 = "yyyy-MM-dd";
  public static final String KEY_FORMAT3 = "yyyy/MM/dd";
  public static final long DAY = 86400000L;
  public static final long HOUR = 3600000L;
  public static final long MINUTE = 60000L;
  public static final long SECOND = 1000L;
  private static String[] weekString = { "空", "星期一", "星期二", 
    "星期三", "星期四", "星期五", "星期六", "星期日" };

  public static long getNowMillis()
  {
    GregorianCalendar now = new GregorianCalendar();
    return now.getTimeInMillis();
  }

  public static String getNow()
  {
    GregorianCalendar now = new GregorianCalendar();
    return getDateTime(now.getTimeInMillis());
  }

  public static long getCurDateMillis()
  {
    GregorianCalendar now = new GregorianCalendar();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String sDate = df.format(now.getTime());
    return getDateMillis(sDate);
  }

  public static String getCurDate()
  {
    GregorianCalendar now = new GregorianCalendar();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String sDate = df.format(now.getTime());
    return sDate;
  }

  public static long getDateMillis(String dateString)
  {
    String[] date = dateString.split("-");
    long dateMillis = 0L;
    try {
      dateMillis = getDateMillis(Integer.parseInt(date[0]), 
        Integer.parseInt(date[1]), Integer.parseInt(date[2]));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.print("输入的日期格式不正确！");
    }
    return dateMillis;
  }

  public static long getTimeMillis(String timeString)
  {
    long lTimeMillis = 0L;
    try {
      int temp = 0;
      String tempStr = timeString.replace('.', ':');
      String[] time = tempStr.split(":");
      temp = Integer.parseInt(time[0]);
      lTimeMillis += temp * 3600000L;
      temp = Integer.parseInt(time[1]);
      lTimeMillis += temp * 60000L;
      temp = Integer.parseInt(time[2]);
      lTimeMillis += temp * 1000L;
      if (time.length > 3) {
        temp = Integer.parseInt(time[3]);
        lTimeMillis += temp;
      }
    } catch (Exception localException) {
    }
    return lTimeMillis;
  }

  public static long getDateTimeMillis(String dateTimeString)
  {
    String[] date = dateTimeString.split(" ");
    if (date.length < 2) {
      return 0L;
    }
    if (date.length > 2) {
      date[1] = date[(date.length - 1)];
    }

    long dateL = getDateMillis(date[0]);
    long timeL = getTimeMillis(date[1]);
    return dateL + timeL;
  }

  public static String showDateRank(String timeString, String targetTime)
  {
    long stringLong = getDateTimeMillis(timeString);
    long targetLong = getDateTimeMillis(targetTime);
    long timeLong;

    if (stringLong > targetLong)
      timeLong = stringLong - targetLong;
    else {
      timeLong = targetLong - stringLong;
    }
    int min = (int)(timeLong / 60000L);
    if (min < 1) {
      return "刚刚";
    }
    if (min < 60) {
      return min + "分钟";
    }
    min = (int)(timeLong / 3600000L);
    if (min < 24) {
      return min + "小时";
    }
    min = (int)(timeLong / 86400000L);
    if (min < 5) {
      return min + "天";
    }
    return targetTime.substring(0, 10);
  }

  public static long getDateMillis(int year, int month, int day)
  {
    GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
    return calendar.getTimeInMillis();
  }

  public static String getDate(long millis)
  {
    String sDate = getYear(millis) + "-";
    String month = String.valueOf(getMonth(millis));
    String day = String.valueOf(getDay(millis));
    if (month.length() == 1) {
      month = "0" + month;
    }
    if (day.length() == 1) {
      day = "0" + day;
    }
    sDate = sDate + month + "-";
    sDate = sDate + day;
    return sDate;
  }

  public static String getMonthAndDay(long millis)
  {
    String sDate = String.valueOf(getMonth(millis));
    String day = String.valueOf(getDay(millis));
    if (sDate.length() == 1) {
      sDate = "0" + sDate;
    }
    if (day.length() == 1) {
      day = "0" + day;
    }
    return sDate + "-" + day;
  }

  public static String getTime(long millis)
  {
    calendar.setTimeInMillis(millis);
    String sTime = "";
    sTime = sTime + getHour(millis) + ":";
    sTime = sTime + getMinute(millis) + ":";
    sTime = sTime + getSecond(millis) + ".";
    String strMillSec = String.valueOf(getMillSecond(millis));
    		
    if (strMillSec.length() == 1)
      strMillSec = "00" + strMillSec;
    else if (strMillSec.length() == 2) {
      strMillSec = "0" + strMillSec;
    }
    sTime = sTime + strMillSec;
    return sTime;
  }

  public static String getDateTime(long millis)
  {
    calendar.setTimeInMillis(millis);
    String sDate = getDate(millis);
    String sTime = getTime(millis);
    return sDate + " " + sTime;
  }

  public static int getYear(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(1);
  }

  public static int getMonth(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(2) + 1;
  }

  public static int getDay(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(5);
  }

  public static int getHour(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(11);
  }

  public static int getMinute(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(12);
  }

  public static int getSecond(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(13);
  }

  public static int getMillSecond(long millis)
  {
    calendar.setTimeInMillis(millis);
    return calendar.get(14);
  }

  public static String getWeekDay(String dateString)
  {
    String weekDay = "";
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date givedDate = dateFormatter.parse(dateString);
      SimpleDateFormat weekFormatter = new SimpleDateFormat("E", 
        Locale.CHINESE);
      weekDay = weekFormatter.format(givedDate);
    } catch (ParseException ee) {
      ee.printStackTrace();
      return weekDay;
    }
    return weekDay;
  }

  public static String getWeekDay(long date)
  {
    String weekDay = "";
    String dateString = getDate(date);
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date givedDate = dateFormatter.parse(dateString);
      SimpleDateFormat weekFormatter = new SimpleDateFormat("E", 
        Locale.CHINESE);
      weekDay = weekFormatter.format(givedDate);
    } catch (ParseException ee) {
      ee.printStackTrace();
      return weekDay;
    }
    return weekDay;
  }

  public static int getIntWeekDay(String dateString)
  {
    String sWeekDay = getWeekDay(dateString);
    int iWeekDay = 0;
    for (int i = 1; i <= 7; i++) {
      if (weekString[i].equals(sWeekDay)) {
        iWeekDay = i;
        break;
      }
    }
    return iWeekDay;
  }

  public static int getIntWeekDay(long date)
  {
    String sWeekDay = getWeekDay(date);
    int iWeekDay = 0;
    for (int i = 1; i <= 7; i++) {
      if (weekString[i].equals(sWeekDay)) {
        iWeekDay = i;
        break;
      }
    }
    return iWeekDay;
  }

  public static String getDateStringByDateAndWeekday(String startDate, String weekday)
  {
    long datemillis = getDateMillis(startDate);
    String sWeekday = getWeekDay(datemillis);
    while (!sWeekday.equals(weekday)) {
      datemillis += 86400000L;
      sWeekday = getWeekDay(datemillis);
    }
    return getDate(datemillis);
  }

  public static long getDateMillisByDateAndWeekday(String startDate, String weekday)
  {
    long datemillis = getDateMillis(startDate);
    String sWeekday = getWeekDay(datemillis);
    while (!sWeekday.equals(weekday)) {
      datemillis += 86400000L;
      sWeekday = getWeekDay(datemillis);
    }
    return datemillis;
  }


  public static Date getNowTime(String format)
  {
    SimpleDateFormat sdFormat = new SimpleDateFormat(format);
    GregorianCalendar gc = new GregorianCalendar();
    try {
      return sdFormat.parse(sdFormat.format(gc.getTime()));
    }
    catch (ParseException e) {
      e.printStackTrace();
    }return null;
  }

  public static String getNowTimeStr(String format)
  {
    SimpleDateFormat sdFormat = new SimpleDateFormat(format);
    GregorianCalendar gc = new GregorianCalendar();

    return sdFormat.format(gc.getTime());
  }

  public static Date getNowTime()
  {
    return getNowTime("yyyy-MM-dd HH:mm:ss");
  }

  public static Date formatDateTime(String timeSrc, String f)
  {
    SimpleDateFormat sdFormat = new SimpleDateFormat(f);
    try {
      if ((timeSrc == null) || (timeSrc.trim().equals(""))) {
        return null;
      }
      return sdFormat.parse(timeSrc);
    }
    catch (ParseException e)
    {
    }
    return null;
  }

  public static String parseDateTime(String endDate, String f)
  {
    SimpleDateFormat sdFormat = new SimpleDateFormat(f);
    if (endDate == null)
      return null;
    return sdFormat.format(endDate);
  }

  public static String getTimeStr(Date srcDate, String format)
  {
    SimpleDateFormat sdFormat = new SimpleDateFormat(format);
    if (srcDate == null) {
      return "";
    }
    return sdFormat.format(srcDate);
  }

  public static Date getLastMonthDate(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, -1);
    Date lastDate = c.getTime();
    return lastDate;
  }

  public static Date getLastDayDate(Date date, int count)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(5, count);
    Date lastDate = calendar.getTime();
    return lastDate;
  }

  public static String parseDateTime(Date timeSrc, String f) {
    SimpleDateFormat sdFormat = new SimpleDateFormat(f);
    if (timeSrc == null)
      return null;
    try {
      return sdFormat.format(timeSrc);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getLastMothFirstDay(String dateStr)
  {
    if (StringUtils.isSpace(dateStr))
      return null;
    Date date = formatDateTime(dateStr, "yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, -1);
    int MaxDay = c.getActualMaximum(5);
    c.set(c.get(1), c.get(2), 1, 23, 59, 59);
    return getTimeStr(c.getTime(), "yyyy-MM") + "-01";
  }

  public static String getLastMothDay(String dateStr)
  {
    if (StringUtils.isSpace(dateStr))
      return null;
    Date date = formatDateTime(dateStr, "yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, -1);
    int MaxDay = c.getActualMaximum(5);
    c.set(c.get(1), c.get(2), MaxDay);
    return getTimeStr(c.getTime(), "yyyy-MM-dd");
  }

  public static String getLastYearNowTime(String dateStr)
  {
    if (StringUtils.isSpace(dateStr)) {
      return null;
    }
    Date date = formatDateTime(dateStr, "yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(1, -1);
    return getTimeStr(c.getTime(), "yyyy-MM-dd");
  }

  public static String getBeginOfYear(String dateStr)
  {
    if ((dateStr != null) && (dateStr.length() > 0)) {
      return dateStr.substring(0, 3) + "-01-01";
    }
    return null;
  }

  public static String getLastOfYear(String dateStr)
  {
    if ((dateStr != null) && (dateStr.length() > 0)) {
      int year = Integer.valueOf(dateStr.substring(0, 4)).intValue() - 1;
      return String.valueOf(year) + "-12-31";
    }
    return null;
  }

  public static Long getDaysBetween(Date startDate, Date endDate)
  {
    Calendar fromCalendar = Calendar.getInstance();
    fromCalendar.setTime(startDate);
    fromCalendar.set(11, 0);
    fromCalendar.set(12, 0);
    fromCalendar.set(13, 0);
    fromCalendar.set(14, 0);

    Calendar toCalendar = Calendar.getInstance();
    toCalendar.setTime(endDate);
    toCalendar.set(11, 0);
    toCalendar.set(12, 0);
    toCalendar.set(13, 0);
    toCalendar.set(14, 0);

    return Long.valueOf((toCalendar.getTime().getTime() - fromCalendar.getTime()
      .getTime()) / 86400000L);
  }

  public static int getMonthLastDay(int year, int month) {
    Calendar a = Calendar.getInstance();
    a.set(1, year);
    a.set(2, month - 1);
    a.set(5, 1);
    a.roll(5, -1);
    int maxDate = a.get(5);
    return maxDate;
  }

  public static String getYearsLaterNowTime(String dateStr, Integer years) {
    if (StringUtils.isSpace(dateStr)) {
      return null;
    }
    Date date = formatDateTime(dateStr, "yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(1, years.intValue());
    return getTimeStr(c.getTime(), "yyyy-MM-dd");
  }

  public static String getLaterMonthTime(String dateStr, int month) {
    if (StringUtils.isSpace(dateStr)) {
      return null;
    }
    Date date = formatDateTime(dateStr, "yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, month);
    return getTimeStr(c.getTime(), "yyyy-MM-dd");
  }

  public static Date getTime_month(Date date, int month)
  {
    if (date == null) {
      return null;
    }
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, month);
    return c.getTime();
  }

  public static Date getTime_year(Date date, Integer years)
  {
    if (date == null) {
      return null;
    }
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(1, years.intValue());
    return c.getTime();
  }

  public static String getDateMinShift(String date, int shift)
  {
    long datemillis = getDateTimeMillis(date);
    datemillis += shift * 60000L;
    return getDateTime(datemillis);
  }

  public static String getDateStringShift(String date, int shift)
  {
    long datemillis = getDateMillis(date);
    datemillis += shift * 86400000L;
    return getDate(datemillis);
  }

  

  
  public static Date getDateShift(String date, int shift)
  {
    long datemillis = getDateMillis(date);
    datemillis += shift * 86400000L;
    return formatDateTime(getDate(datemillis), "yyyy-MM-dd");
  }

  public static Date getDateHourShift(String date, int shift)
  {
    long datemillis = getDateTimeMillis(date);
    datemillis += shift * 3600000L;
    return formatDateTime(getDateTime(datemillis), "yyyy-MM-dd HH:mm:ss");
  }

  public static Date getDateMinShift1(String date, int shift)
  {
    long datemillis = getDateTimeMillis(date);
    datemillis += shift * 60000L;
    return formatDateTime(getDateTime(datemillis), "yyyy-MM-dd HH:mm:ss");
  }

  public static long getDateMillisShift(String date, int shift)
  {
    long datemillis = getDateMillis(date);
    datemillis += shift * 86400000L;
    return datemillis;
  }

  public static int calcDays(Date fromDate, Date toDate, boolean blnAbs)
  {
    long miliSeconds1 = fromDate.getTime();
    long miliSeconds2 = toDate.getTime();

    if (!blnAbs)
    {
      return (int)((miliSeconds2 - miliSeconds1) / 86400000L);
    }

    return (int)(Math.abs(miliSeconds2 - miliSeconds1 - 1L) / 86400000L) + 1;
  }

  public static int calcSeconds(Date fromDate, Date toDate)
  {
    long miliSeconds1 = fromDate.getTime();
    long miliSeconds2 = toDate.getTime();
    if (miliSeconds2 < miliSeconds1) {
      return -1;
    }
    return (int)((miliSeconds2 - miliSeconds1) / 1000L);
  }

  public static boolean isLeapYear(int year)
  {
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
      return true;
    return false;
  }



 

  public static String getFirstDay(Date theDate) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    GregorianCalendar gcLast = (GregorianCalendar)Calendar.getInstance();
    gcLast.setTime(theDate);
    gcLast.set(5, 1);
    String day_first = df.format(gcLast.getTime());
    StringBuffer str = new StringBuffer().append(day_first).append(
      " 00:00:00");
    return str.toString();
  }

  public static String getLastDay(Date theDate)
  {
    if (theDate == null)
      return null;
    Calendar c = Calendar.getInstance();
    c.setTime(theDate);
    int MaxDay = c.getActualMaximum(5);
    c.set(c.get(1), c.get(2), MaxDay);
    return getTimeStr(c.getTime(), "yyyy-MM-dd");
  }

  public static boolean compareDate(Date d1, Date d2)
  {
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(d1);
    c2.setTime(d2);

    int result = c1.compareTo(c2);
    if (result >= 0) {
      return true;
    }
    return false;
  }

  public static int getMonths(Date date1, Date date2)
  {
    int iMonth = 0;
    try {
      Calendar objCalendarDate1 = Calendar.getInstance();
      objCalendarDate1.setTime(date1);
      Calendar objCalendarDate2 = Calendar.getInstance();
      objCalendarDate2.setTime(date2);
      if (objCalendarDate2.equals(objCalendarDate1))
        return 0;
      if (objCalendarDate1.after(objCalendarDate2)) {
        Calendar temp = objCalendarDate1;
        objCalendarDate1 = objCalendarDate2;
        objCalendarDate2 = temp;
      }

      if (objCalendarDate2.get(1) > objCalendarDate1
        .get(1))
        iMonth = (objCalendarDate2.get(1) - objCalendarDate1
          .get(1)) * 
          12 + 
          objCalendarDate2.get(2) - 
          objCalendarDate1.get(2);
      else
        iMonth = objCalendarDate2.get(2) - 
          objCalendarDate1.get(2);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return iMonth;
  }


	public static File getYearAndMonthAndToday(String rootDir) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date currTime = new Date();
		String curTime = formatter.format(currTime);
		File file = new File(rootDir +curTime);
		System.out.println("--------------"+file.getAbsolutePath());
		if (!file.exists()) {// 目录不存在则直接创建
			file.mkdirs();
		}
		return file;

	}
  public static File timeFile(String rootDir){
	  Calendar date = Calendar.getInstance();
      File file = new File(rootDir + File.separator + date.get(Calendar.YEAR)
              + File.separator + (date.get(Calendar.MONTH)+1) + File.separator
              + date.get(Calendar.DAY_OF_MONTH));
      System.out.println("---------------"+file.getAbsolutePath());
      if(!file.exists()){//目录不存在则直接创建
          file.mkdirs();
      }
      return file;
  }
  
 //
  public static Date stringToDate(String s){
		
		Date date=null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    date = sdf.parse(s);  
		}  
		catch (ParseException e)  
		{  
		    e.printStackTrace();
		}
		
		
		return date;
	}
}