package com.telesens.academy.lesson06;

public class DateTrainMain {

    public static void main(String[] args) {
	// write your code here

        int [] arrDate, arrDate1 = new int[3];
        DateLesson06 myDate = new DateLesson06();
        String inputFirst, inputSecond;
        System.out.println("Input First Date in date format dd:mm:yyyy");
        inputFirst=myDate.inputDate();
        arrDate = myDate.getData(inputFirst);
        if (myDate.checkData(arrDate[0],arrDate[1],arrDate[2]))
            myDate.setData(arrDate);
        else
            System.out.println("Input First Date include incorrect number");

        System.out.println("Input Second Date in date format dd:mm:yyyy");
        inputSecond=myDate.inputDate();
        arrDate1 = myDate.getData(inputSecond);
        if (myDate.checkData(arrDate1[0],arrDate1[1],arrDate1[2]))
            myDate.setData(arrDate1);
        else
            System.out.println("Input Second Date include incorrect number");
        //System.out.println(" Second Date include incorrect number");
        long days = -1;
        days=myDate.differenceIdDays(arrDate1[0],arrDate1[1],arrDate1[2]) - myDate.getDayCount(inputFirst);
        System.out.printf("Difference in days: %d", Math.abs(days));

    }



}
