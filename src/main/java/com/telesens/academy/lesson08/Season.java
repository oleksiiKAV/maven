package com.telesens.academy.lesson08;

public enum Season {
    WINTER("Зима"),
    SPRING("Весна"),
    SUMMER,
    AUTUMN("Осень");

    private String ruName;

    Season() {

    }

    Season(String ruName) {
        this.ruName = ruName;
    }

    @Override
    public String toString() {
        return ruName;
    }

    public Season next() {
//        1)
//        int indexCurrent = ordinal();
//        Season[] arraySeasons = values();
//        return arraySeasons[indexCurrent+1];

//        2)
        if (ordinal() < values().length - 1)
            return values()[ordinal() + 1];
        else
            return values()[0];


//        3)
//        return values()[(ordinal()+1)%values().length];
    }
}
