package com.valya.homework.CodingExerciseHospital.Insurance;

public class BlueCrossBlueShield implements InsuranceBrand {

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {

        return addForAge(insurancePlan, age) + addForSmoking(insurancePlan, smoking);

    }

    private double addForSmoking(HealthInsurancePlan insurancePlan, boolean smoking) {
        double PremiumSmoking = 0;
        if(smoking) {
            if(insurancePlan instanceof PlatinumPlan) {
                PremiumSmoking = PremiumSmoking + 100;
                return PremiumSmoking;
            }
            if(insurancePlan instanceof GoldPlan) {
                PremiumSmoking = PremiumSmoking + 90;
                return PremiumSmoking;
            }
            if(insurancePlan instanceof SilverPlan) {
                PremiumSmoking = PremiumSmoking + 80;
                return PremiumSmoking;
            }
            if(insurancePlan instanceof BronzePlan) {
                PremiumSmoking = PremiumSmoking + 70;
                return PremiumSmoking;
            }
        }
        return PremiumSmoking;
    }

    private double addForAge(HealthInsurancePlan insurancePlan, int age) {
        double PremiumAge = 0;
        if(age > 55) {
            if(insurancePlan instanceof PlatinumPlan) {
                PremiumAge = PremiumAge + 200;
                return PremiumAge;
            }
            if(insurancePlan instanceof GoldPlan) {
                PremiumAge = PremiumAge + 150;
                return PremiumAge;
            }
            if(insurancePlan instanceof SilverPlan) {
                PremiumAge = PremiumAge + 100;
                return PremiumAge;
            }
            if(insurancePlan instanceof BronzePlan) {
                PremiumAge = PremiumAge + 50;
                return PremiumAge;
            }
        }
        return PremiumAge;
    }
}
