package com.telesens.academy.lesson06;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DateLesson06 {
    private int day;
    private int month;
    private int year;
//GetSet start
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
//GetSet End
    public String inputDate (){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public int[] getData(String strDate){

        Pattern pattern = Pattern.compile("\\d{2}:\\d{2}:\\d{4}");
        int [] arrDate = new int [3];
        Matcher matcher = pattern.matcher(strDate);
        if (matcher.matches()) {
            System.out.println("Date Format is valid");
        }
        else
        {
            System.out.println("Date Format must be in the format dd:mm:yyyy");
            assert matcher.matches();
        }
        String [] st = strDate.split(":");
        for (int i = 0; i<st.length; i++)
        {
            arrDate[i] = Integer.parseInt(st[i]);
        }
        return arrDate;
    }
    public boolean checkData(int day, int month, int year){
        return (day >= 1 && day <= 31) && (month >= 1 && month <= 12) && (year >= 1 && year <= 2300);
    }

    public void setData(int[] arrDate){
        setDay(arrDate[0]);
        setMonth(arrDate[1]);
        setYear(arrDate[2]);

    }
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:mm:yyyy");
    public long differenceIdDays(int day, int month, int year){
        String stDate= Integer.toString(day)+":"+Integer.toString(month)+":"+Integer.toString(year);
        return getDayCount(stDate);
    }
    public static long getDayCount(String daysInDate) {
        long diff = -1;
        try {
            java.util.Date dateStr = simpleDateFormat.parse(daysInDate);
            //java.util.Date dateEnd = simpleDateFormat.parse(end);

            //time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to summer time as well as the extra hour in the other direction
            diff = Math.round((dateStr.getTime()) / (double) 86400000);
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        return diff;
    }

    public DateLesson06() {
    }

    public DateLesson06(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }
}
