package com.telesens.academy.lesson13;

import com.telesens.academy.automationpractice.model.EntityDress;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add(0, "zero");
        System.out.println(list);
        System.out.println(list.get(1));
    }
}