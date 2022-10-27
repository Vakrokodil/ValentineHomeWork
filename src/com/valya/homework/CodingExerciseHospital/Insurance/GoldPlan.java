package com.valya.homework.CodingExerciseHospital.Insurance;

public class GoldPlan extends HealthInsurancePlan {

    private final static double GOLD_COVERAGE = 0.8;
    private final static double GOLD_DISCOUNT = 40;
    private final static double GOLD_MONTHLY_PREMIUM = 0.07;

    public GoldPlan() {
        super();
        setCoverage(GOLD_COVERAGE);
        setDiscount(GOLD_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * GOLD_MONTHLY_PREMIUM;
    }

    @Override
    public String toString() {
        return "Insurance plan is Gold";
    }
}
