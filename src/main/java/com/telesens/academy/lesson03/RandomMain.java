package com.telesens.academy.lesson03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomMain {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Generate random array:");
        task_random();
        System.out.println("Generate random array and sort it.");
        task_sort_array();

    }

    private static void task_sort_array() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input numbers of cells and press Enter:");
        int cells = scan.nextInt();
        System.out.println("Please, input numbers of rows and press Enter:");
        int rows = scan.nextInt();

        float[][] arrFloat = new float[cells][rows];
        fillArr(arrFloat,cells,rows);
    }

    private static void task_random() {
        int[] arr = new int[10];

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); // random from 0 to 10
        }

        System.out.println("Random array: " + Arrays.toString(arr));
        Arrays.sort(arr);//sort array
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }

    private static void fillArr(float[][] arrFloat, int cells, int rows) {
        Random rand = new Random();
        float min= (float) 0.00, max= (float) 0.00,sumMin= (float) 0.00, sumMax= (float) 0.00, summF= (float) 0.00;

        float[] summ = new float[cells];
        for (int i = 0; i <cells; i++) {
            for (int j = 0; j < rows; j++) {
                arrFloat[i][j]= (float) (rand.nextInt(100)/100.00);
                summF+=arrFloat[i][j]*100/100.00;
            }
            summ[i]=summF;
            System.out.printf("Random array row %d:\n", i);
            System.out.print(Arrays.toString(arrFloat[i]));
            System.out.println(" Sum is: " + Float.toString(summ[i]));
        }
        for (int i = 0; i <cells; i++) {
            Arrays.sort(arrFloat[i]);//it is important
            min=arrFloat[i][0];//it is important
            sumMin=summ[0];//it is important
            for (int j = 0; j < rows; j++) {
                if (arrFloat[i][j]>max) {max = arrFloat[i][j];}
                if (arrFloat[i][j]<min) {min = arrFloat[i][j];}
            }
            if (summ[i]>sumMax) {sumMax = summ[i];}
            if (summ[i]<sumMin) {sumMin = summ[i];}
        }
        System.out.printf("MIN value of array is: %.2f:\n", min);
        System.out.printf("MAX value of array is: %.2f:\n", max);
        System.out.printf("MIN SUM cells of array is: %.2f:\n", sumMin);
        System.out.printf("MAX SUM cells of array is: %.2f:\n", sumMax);

        return;
    }
}
