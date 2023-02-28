package com.example.sportmeeting1.model;

public class Athlete {
    private Integer id;

    private String athleteName;

    private Integer athleteSex;

    private Integer athleteAge;

    private Integer athleteNumber;

    private String teamName;

    private String teamId;

    private String athleteTel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public Integer getAthleteSex() {
        return athleteSex;
    }

    public void setAthleteSex(Integer athleteSex) {
        this.athleteSex = athleteSex;
    }

    public Integer getAthleteAge() {
        return athleteAge;
    }

    public void setAthleteAge(Integer athleteAge) {
        this.athleteAge = athleteAge;
    }

    public Integer getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(Integer athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAthleteTel() {
        return athleteTel;
    }

    public void setAthleteTel(String athleteTel) {
        this.athleteTel = athleteTel;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}