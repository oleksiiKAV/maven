package com.telesens.academy.lesson02;
import java.util.Scanner;

public class Less02CountAndSum {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please, input integer number and press Enter:");
    int n = scan.nextInt();
    int sum = 0, count=0;
    String txt="Entering number includes this chars: ";

        while(n!=0){
        sum+=n%10; //sum=n%10 + sum; take last char - from 456 only 6 ...
        txt+=n%10 + " "; //to string add char
        count++; //increment count of chars
        n=n/10; //un-remember last char - was 456, is 45 ...
    }
        System.out.println(txt);
        System.out.printf("Count of Numbers is: %d\n", count);
        System.out.println("Sum of Numbers is: " + sum);
}
}
