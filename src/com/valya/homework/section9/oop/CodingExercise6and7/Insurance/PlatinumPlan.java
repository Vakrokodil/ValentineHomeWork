package com.valya.homework.section9.oop.CodingExercise6and7.Insurance;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        setCoverage(getCoverage() + 0.9);
    }

    @Override
    public String toString() {
        return "Insurance plan is Platinum";
    }
}
