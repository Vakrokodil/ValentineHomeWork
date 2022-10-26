package com.valya.homework.section9.oop.CodingExercise6and7.Insurance;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan() {
        setCoverage(getCoverage() + 0.8);
    }

    @Override
    public String toString() {
        return "Insurance plan is Gold";
    }
}
