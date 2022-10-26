package com.valya.homework.section9.oop.CodingExercise6and7.Insurance;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan() {
        setCoverage(getCoverage() + 0.7);
    }

    @Override
    public String toString() {
        return "Insurance plan is Silver";
    }
}
