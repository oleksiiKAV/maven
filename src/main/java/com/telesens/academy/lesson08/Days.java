package com.telesens.academy.lesson08;

public enum Days {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String rusName;
    Days() {
    }

    Days(String rusName) {
        this.rusName = rusName;
    }

    @Override
    public String toString() {
        return rusName;
    }
    public Days dayNeed(int day) {
//        1)
        int indexCurrent = ordinal();
        Days[] arrayDays = values();
        switch (indexCurrent+day) {
            case -1: return arrayDays[6];
            case -2: return arrayDays[5];
            case -3: return arrayDays[4];
            case -4: return arrayDays[3];
            case -5: return arrayDays[2];
            case -6: return arrayDays[1];
            default:
                return arrayDays[indexCurrent + day];

        }
//        2)
        //if (ordinal() < values().length - day)
          //  return values()[ordinal() + day];
        //else
//            return values()[0];
        //return values()[(ordinal()+day)%values().length];
    }

}
