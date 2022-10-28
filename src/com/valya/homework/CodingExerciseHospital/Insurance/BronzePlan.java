package com.valya.homework.CodingExerciseHospital.Insurance;

public class BronzePlan extends HealthInsurancePlan {

    private final static double BRONZE_COVERAGE = 0.6;
    private final static double BRONZE_DISCOUNT = 25;
    private final static double BRONZE_MONTHLY_PREMIUM = 0.05;

    public BronzePlan() {
        setCoverage(BRONZE_COVERAGE);
        setDiscount(BRONZE_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return BRONZE_MONTHLY_PREMIUM * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    @Override
    public String toString() {
        return "Insurance plan is Bronze";
    }
}
