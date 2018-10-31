package com.telesens.academy.lesson05;
import java.util.regex.Pattern;

public class TestCurrencyFormatMain {
    public static void main(String[] args) {
	// write your code here
    /*
    Создать регулярное выражение для поиска несоответствия строки  шаблонy денежного формата:
			- цифры разделенные точкой или запятой
			- разделителя может не быть
			- после разделителя должна быть одна или две цифры
			- в конце должен находится литерал, обозначающий валюту из набора: грн руб $
			    0.50грн 	=> true
				0.5грн 		=> true
				12,45руб 	=> true
				15,45 руб 	=> false
				123$ 		=> true
				123.$		=> false
				123.00$		=> true
				a12грн 		=> false
				0.50грн.	=> false
				0.50грн 	=> false
    */
        String str = "";
        String [] strArr = {"0.50грн","0.5грн", "12,45руб","15,45 руб",
                "123$", "123.$", "123.00$", "a12грн", "0.50грн."
        };
        String regex = "\\b\\d{1,}([.,])?\\d{1,2}(грн|руб|\\$)";
        for (String s: strArr) {
            if (testCurrencyFormat(regex,s))
                System.out.println(s);
        }
    }
    private static boolean testCurrencyFormat(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
}
