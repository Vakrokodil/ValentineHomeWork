package com.valya.homework.CodingExerciseHospital.Insurance;

public abstract class HealthInsurancePlan {
    private double coverage;
    private double discount;

    public HealthInsurancePlan() {
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public abstract double computeMonthlyPremium(double salary);

    // Don't worry about the below code and also the InsuranceBrand class
    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

}
