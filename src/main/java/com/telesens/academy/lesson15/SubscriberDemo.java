package com.telesens.academy.lesson15;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.UUID;

public class SubscriberDemo {
    public static void main(String[] args) {
        //Supplier<Object> supplier = () -> new Object();
        Subscriber [] subsArrray = new Subscriber[100];
        for (int i=0;i<100; i++) {
            subsArrray[i]=genSub();
        }
        for(int i=0;i<100;i++){//break point

        }

    }

    public static String generateString() {
        int STR_LENGTH = 25;
        Random r = new Random();
        StringBuilder builder = new StringBuilder();
            for (int j = 0; j < STR_LENGTH; j++) {
                char code = (char) (r.nextInt(94) + 33);
                builder.append(Character.toString(code));
            }
            return builder.toString();
    }
    public static Subscriber genSub (){
            Subscriber subs = new Subscriber();
            subs.setId((long) new Random().nextInt(1000));
            subs.setFirstName(generateString());
            subs.setLastName(generateString());
            subs.setAge(18+(new Random().nextInt(60-18+1)));
            subs.setPhoneNumber(generatePhone());

        return subs;
    }

    private static String generatePhone() {
        String str = new String();
        String regex = "999{1}\\d{5}\\d[0,5]";
        Pattern pattern = Pattern.compile(regex);

        //str = Long.toString(new Random().nextLong()).substring(0,10);
        boolean boolTemp=false;
        while(!boolTemp){
            str = Long.toString(new Random().nextLong()).substring(0,10);
            boolTemp=pattern.matcher(str).matches();
        }
        return str;
    }
}
