package com.example.sportmeeting1.model;


public class Coach {
    private String coachName;
    private String coachId;
    private String coachTel;
    private String teamId;
    private String coachSex;

    public String getCoachName() {
        return coachName;
    }

    public String getCoachId() {
        return coachId;
    }

    public String getCoachTel() {
        return coachTel;
    }


    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public void setCoachTel(String coachTel) {
        this.coachTel = coachTel;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(String coachSex) {
        this.coachSex = coachSex;
    }
}
