package com.telesens.academy.lesson11;
//try to use BigDecimal
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class AppMain {
    public static void main(String[] args) {
        Random rand = new Random();
        double[] arrDbl = new double[15];
        BigDecimal [] arrBigDec = new BigDecimal[15];
        for (int i = 0; i <15; i++) {
            arrDbl[i] = (double) (rand.nextDouble());
        }
        for (int i = 0; i <15; i++) {
            arrBigDec[i]= (BigDecimal) BigDecimal.valueOf(arrDbl[i]).divide(BigDecimal.valueOf(1),3,BigDecimal.ROUND_CEILING);
        }
            System.out.println("Random array row:");
            System.out.println(Arrays.toString(arrDbl));
            System.out.println("BigDecimal Array is:");
            System.out.println(Arrays.toString(arrBigDec));
        }
}
