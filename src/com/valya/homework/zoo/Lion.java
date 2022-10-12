package com.valya.homework.zoo;

import java.time.LocalDate;

class Lion extends Animal {

    private final static int amountMeat = 8;

    public Lion(String name, int age, String sex, double weight) {
        super(name, age, sex, weight);
    }

    public static int getAmountMeat() {
        return amountMeat;
    }

    /*The method counts the portion per day*/
    public double countMeetPortion(boolean baby) {

        if((baby && sex.equals("female")) || LocalDate.now().getMonthValue() == 12 || LocalDate.now().getMonthValue() == 1) {
            return amountMeat * 1.2;
        }
        if((weight > 230 && sex.equals("male") )|| (weight > 210 && sex.equals("female") && !baby)) {
            return amountMeat * 0.9;
        }
        return amountMeat;
    }

    @Override
    public void goSleep() {
        System.out.println("pur-pur-pur");
    }

}
