package com.telesens.academy.lesson09;

public class CheckBox implements Component {
    @Override
    public void draw() {
        System.out.println("CheckBox");
    }

    public void check() {
        System.out.println("Check");
    }
}
