package org.example;

import java.util.List;

public class Interviewer {
    private String interviewer;
    private List<Schedule> schedules;

    public Interviewer(String interviewer, List<Schedule> schedules) {
        super();
        this.interviewer = interviewer;
        this.schedules = schedules;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

}
