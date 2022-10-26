package com.valya.homework.section9.oop.CodingExercise6and7;

import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.BronzePlan;
import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.GoldPlan;
import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.HealthInsurancePlan;
import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.PlatinumPlan;
import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.SilverPlan;

import java.util.Arrays;

public class Billing {

    public static void main(String[] args) {

        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        HealthInsurancePlan insurancePlan2 = new BronzePlan();

        Patient patient = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();

        patient.setInsurancePlan(insurancePlan);
        patient3.setInsurancePlan(insurancePlan2);

        double[] paymentsArray = Billing.computePaymentAmount(patient, 1000.0);
        System.out.println(Arrays.toString(paymentsArray));

        double[] paymentsArray2 = Billing.computePaymentAmount(patient2, 500.0);
        System.out.println(Arrays.toString(paymentsArray2));

        double[] paymentsArray3 = Billing.computePaymentAmount(patient3, 600.0);
        System.out.println(Arrays.toString(paymentsArray3));

    }

    final static double PLATINUM_DISCOUNT = 50;
    final static double GOLDEN_DISCOUNT = 40;
    final static double SILVER_DISCOUNT = 30;
    final static double BRONZE_DISCOUNT = 25;
    final static double COMMON_DISCOUNT = 20;


    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan == null) {
            payments[0] = 0;
            payments[1] = amount - COMMON_DISCOUNT;
        } else {
            payments[0] = amount * patientInsurancePlan.getCoverage();

            if (patientInsurancePlan instanceof PlatinumPlan) {
                payments[1] = amount - amount * patientInsurancePlan.getCoverage() - PLATINUM_DISCOUNT;
                return payments;
            }
            if (patientInsurancePlan instanceof GoldPlan) {
                payments[1] = amount - amount * patientInsurancePlan.getCoverage() - GOLDEN_DISCOUNT;
                return payments;
            }
            if (patientInsurancePlan instanceof SilverPlan) {
                payments[1] = amount - amount * patientInsurancePlan.getCoverage() - SILVER_DISCOUNT;
                return payments;
            }
            if (patientInsurancePlan instanceof BronzePlan) {
                payments[1] = amount - amount * patientInsurancePlan.getCoverage() - BRONZE_DISCOUNT;
                return payments;
            }
        }

        return payments;
    }
}
