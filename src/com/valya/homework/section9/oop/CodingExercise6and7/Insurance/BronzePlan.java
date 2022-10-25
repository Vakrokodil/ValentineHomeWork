package com.valya.homework.section9.oop.CodingExercise6and7.Insurance;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        setCoverage(getCoverage() + 0.6);
    }
}
