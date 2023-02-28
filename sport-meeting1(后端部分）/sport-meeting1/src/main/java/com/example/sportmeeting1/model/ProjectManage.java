package com.example.sportmeeting1.model;

import java.util.List;

public class ProjectManage {
    Integer projectNumber;
    Integer groupNumber;
    List<Integer> judgeIds;

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Integer> getJudgeIds() {
        return judgeIds;
    }

    public void addJudgeIds(Judge judge) {
        this.judgeIds.add(judge.getJudgeId());
    }
    public void setJudgeIds( List<Integer> judgeIds) {
        this.judgeIds=judgeIds;
    }
}
