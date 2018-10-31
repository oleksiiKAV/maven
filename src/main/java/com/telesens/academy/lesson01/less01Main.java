package com.telesens.academy.lesson01;

public class less01Main {
    public static void main(String[] args) {
        String txt="*";
        while (txt.length()<7) {
            System.out.println(txt);
            txt = txt + "*";
        }
    }
}
