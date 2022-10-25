package com.valya.homework.section9.oop.CodingExercise6and7;

import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.GoldPlan;
import com.valya.homework.section9.oop.CodingExercise6and7.Insurance.HealthInsurancePlan;

public class Billing {

    public static void main(String[] args) {

        HealthInsurancePlan insurancePlan = new GoldPlan();
        Patient patient = new Patient();

        System.out.println(insurancePlan.getCoverage());
        //patient.setInsurancePlan(insurancePlan);
    }

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        //HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        // your logic

        return payments;
    }
}
