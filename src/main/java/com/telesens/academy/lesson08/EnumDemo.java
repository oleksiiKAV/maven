package com.telesens.academy.lesson08;

import java.util.Scanner;

import static com.telesens.academy.lesson08.Days.*;
import static com.telesens.academy.lesson08.Days.MONDAY;
import static com.telesens.academy.lesson08.Season.*;


public class EnumDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Plus or minus day(s) (2, or -4) and press Enter:");
        int n1 = scan.nextInt();

        Season season = AUTUMN;
        Days days = MONDAY;

        System.out.println(season);
        System.out.println(season.next());

        Season nextSeason = season.next();
        assert nextSeason == WINTER;

        System.out.println(days);
        System.out.println(days.dayNeed(n1));

        //assert для универслаизма что-то сложный придумывается )))


    }
}
