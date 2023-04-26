package org.example;

import java.util.List;

public class Event {

    private String name;
    private String type;
    private String start;
    private String end;
    private String description;
    private String smsReminder;
    private String emailReminder;
    private Integer duration;
    private List<Interviewer> interviewers;

    public Event(String name, String type, String start, String end, String description, String smsReminder, String emailReminder, Integer duration, List<Interviewer> interviewers) {
        super();
        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
        this.description = description;
        this.smsReminder = smsReminder;
        this.emailReminder = emailReminder;
        this.duration = duration;
        this.interviewers = interviewers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmsReminder() {
        return smsReminder;
    }

    public void setSmsReminder(String smsReminder) {
        this.smsReminder = smsReminder;
    }

    public String getEmailReminder() {
        return emailReminder;
    }

    public void setEmailReminder(String emailReminder) {
        this.emailReminder = emailReminder;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }

}








