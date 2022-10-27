package com.valya.homework.CodingExerciseHospital.Insurance;

public class SilverPlan extends HealthInsurancePlan {

    private final static double SILVER_COVERAGE = 0.7;
    private final static double SILVER_DISCOUNT = 30;
    private final static double SILVER_MONTHLY_PREMIUM = 0.06;

    public SilverPlan() {
        super();
        setCoverage(SILVER_COVERAGE);
        setDiscount(SILVER_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * SILVER_MONTHLY_PREMIUM;
    }

    @Override
    public String toString() {
        return "Insurance plan is Silver";
    }
}
