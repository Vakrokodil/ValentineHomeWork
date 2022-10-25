package com.valya.homework.section9.oop.CodingExercise6and7;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
