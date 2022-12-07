package com.valya.homework.CodingExerciseHospital.Insurance;

public class PlatinumPlan extends HealthInsurancePlan {

    private final static double PLATINUM_COVERAGE = 0.9;
    private final static double PLATINUM_DISCOUNT = 50;
    private final static double PLATINUM_MONTHLY_PREMIUM = 0.08;

    public PlatinumPlan() {
        super();
        setCoverage(PLATINUM_COVERAGE);
        setDiscount(PLATINUM_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return PLATINUM_MONTHLY_PREMIUM * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    @Override
    public String toString() {
        return "Insurance plan is Platinum";
    }
}
