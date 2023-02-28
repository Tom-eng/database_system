package com.example.sportmeeting1.model;

public class Doctor {
    String doctorName;
    String doctorTel;
    String doctorId;
    String teamId;

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorTel() {
        return doctorTel;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorTel(String doctorTel) {
        this.doctorTel = doctorTel;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
