package com.telesens.academy.lesson09;



public class Button implements Component {
    @Override
    public void draw() {
        System.out.println("Button");
    }

    public void click() {
        System.out.println("Click");
    }
}
