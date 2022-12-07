package com.valya.homework.CodingExerciseHospital;

import com.valya.homework.CodingExerciseHospital.Insurance.BlueCrossBlueShield;
import com.valya.homework.CodingExerciseHospital.Insurance.GoldPlan;
import com.valya.homework.CodingExerciseHospital.Insurance.HealthInsurancePlan;
import com.valya.homework.CodingExerciseHospital.Insurance.InsuranceBrand;
import com.valya.homework.CodingExerciseHospital.Insurance.PlatinumPlan;
import com.valya.homework.CodingExerciseHospital.Insurance.SilverPlan;

public class Billing {

    public static void main(String[] args) {

//        Patient patient = new Patient();
//        HealthInsurancePlan insurancePlan = new PlatinumPlan();
//        patient.setInsurancePlan(insurancePlan);
//
//        double[] paymentsArray = Billing.computePaymentAmount(patient, 1000.0);
//        System.out.println(Arrays.toString(paymentsArray));


        User BobKelso = new User();
        InsuranceBrand insuranceBrandNew = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlanNew = new PlatinumPlan();

        insurancePlanNew.setOfferedBy(insuranceBrandNew);
        BobKelso.setInsurancePlan(insurancePlanNew);
        double premiumBobKeslo = insurancePlanNew.computeMonthlyPremium(5000, 56, true);

        System.out.println("Bob Keslo's premium: " + premiumBobKeslo);


        User Elliot = new User();
        InsuranceBrand insuranceBrandNew2 = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlanNew2 = new SilverPlan();

        insurancePlanNew2.setOfferedBy(insuranceBrandNew2);
        Elliot.setInsurancePlan(insurancePlanNew2);
        double premiumElloit = insurancePlanNew2.computeMonthlyPremium(2000, 26, true);

        System.out.println("Elliot's premium: " + premiumElloit);

        User JohnDorian = new User();
        InsuranceBrand insuranceBrandNew3 = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlanNew3 = new GoldPlan();

        insurancePlanNew3.setOfferedBy(insuranceBrandNew3);
        JohnDorian.setInsurancePlan(insurancePlanNew3);
        double premiumJohnDorian = insurancePlanNew3.computeMonthlyPremium(2000, 28, false);

        System.out.println("John Dorian's premium: " + premiumJohnDorian);

    }

    final static double COMMON_DISCOUNT = 20;
    final static int AMOUNT_ELEMENTS = 2;


    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[AMOUNT_ELEMENTS];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan == null) {
            payments[1] = amount - COMMON_DISCOUNT;
        } else {
            payments[0] = amount * patientInsurancePlan.getCoverage();
            payments[1] = amount - amount * patientInsurancePlan.getCoverage() - patientInsurancePlan.getDiscount();
        }
        return payments;
    }
}
