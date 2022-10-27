package com.valya.homework.CodingExerciseHospital;

import com.valya.homework.CodingExerciseHospital.Insurance.BronzePlan;
import com.valya.homework.CodingExerciseHospital.Insurance.HealthInsurancePlan;
import com.valya.homework.CodingExerciseHospital.Insurance.PlatinumPlan;

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

    final static double COMMON_DISCOUNT = 20;
    final static int AMOUNT_ELEMENTS = 2;


    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[AMOUNT_ELEMENTS];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan == null) {
            //payments[0] = 0;
            payments[1] = amount - COMMON_DISCOUNT;
        } else {
            payments[0] = amount * patientInsurancePlan.getCoverage();
            payments[1] = amount - amount * patientInsurancePlan.getCoverage() - patientInsurancePlan.getDiscount();
        }
        return payments;
    }
}
