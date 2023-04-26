package org.example;

import java.util.List;

public class Calendar {

    private String date;
    private String start;
    private String end;
    private String applicant;
    private String event;
    private String phase;
    private List<Interviewer> interviewers;


    public Calendar(String date, String start, String end, String applicant, String event, String phase, List<Interviewer> interviewers) {
        super();
        this.date = date;
        this.start = start;
        this.end = end;
        this.applicant = applicant;
        this.event = event;
        this.phase = phase;
        this.interviewers = interviewers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }

}
