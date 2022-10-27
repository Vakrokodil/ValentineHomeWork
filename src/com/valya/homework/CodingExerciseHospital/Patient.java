package com.valya.homework.CodingExerciseHospital;

import com.valya.homework.CodingExerciseHospital.Insurance.HealthInsurancePlan;

public class Patient extends User {
    private long patientId;

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

}
