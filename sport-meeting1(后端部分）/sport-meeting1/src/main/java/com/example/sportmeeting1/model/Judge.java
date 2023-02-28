package com.example.sportmeeting1.model;

public class Judge {
    private Integer judgeId;
    private String judgename;
    private Integer sex;
    private Integer tel;
    private String teamId;
    private String password;

    public Judge() {
    }

    public Integer getJudgeId() {
        return this.judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgename() {
        return this.judgename;
    }

    public void setJudgename(String judgename) {
        this.judgename = judgename;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getTel() {
        return this.tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}