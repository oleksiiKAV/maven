package com.telesens.academy.lesson08Polymorph;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Component component = new Component();
        component.draw();
/*
        Component component2 = new Button();
        component2.draw();
        component2 = new CheckBox();
        component2.draw();
        if (component2 instanceof  CheckBox)
            ((CheckBox)component2).check();
        else if (component2 instanceof  Button)
            ((Button)component2).click();
*/
        Component[] components = {
                new Component(),
                new Label(),
                new Button(),
                new CheckBox(),
                new Button(),
                new Label(),
                new Button(),
                new CheckBox(),
                new Button(),
                new Component(),
        };

        System.out.println("Components array");

        for (int i=0; i<components.length;i++) {
            System.out.printf("Components index is: %s\t", i);
            components[i].draw();
        }
        System.out.println("Only Button and children");
        for (int i=0; i<components.length;i++) {
            if (components[i] instanceof Button) {
                System.out.printf("Components index is: %s\t", i);
                components[i].draw();
            }
        }

    }
}