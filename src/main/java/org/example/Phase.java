package org.example;
public class Phase {

    private String type;
    private String title;
    private String description;
    private String body;
    private String start;
    private String end;
    private String test;
    private String event;
    private Boolean emailOnStart;
    private Boolean smsOnStart;
    private Boolean emailOnSuccess;
    private Boolean smsOnSuccess;
    private Boolean emailOnRejection;
    private Boolean smsOnRejection;
    private String course;



    public Phase(String type, String title, String description, String body, String start, String end, String test, String event, Boolean emailOnStart, Boolean smsOnStart, Boolean emailOnSuccess, Boolean smsOnSuccess, Boolean emailOnRejection, Boolean smsOnRejection, String course) {
        super();
        this.type = type;
        this.title = title;
        this.description = description;
        this.body = body;
        this.start = start;
        this.end = end;
        this.test = test;
        this.event = event;
        this.emailOnStart = emailOnStart;
        this.smsOnStart = smsOnStart;
        this.emailOnSuccess = emailOnSuccess;
        this.smsOnSuccess = smsOnSuccess;
        this.emailOnRejection = emailOnRejection;
        this.smsOnRejection = smsOnRejection;
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Boolean getEmailOnStart() {
        return emailOnStart;
    }

    public void setEmailOnStart(Boolean emailOnStart) {
        this.emailOnStart = emailOnStart;
    }

    public Boolean getSmsOnStart() {
        return smsOnStart;
    }

    public void setSmsOnStart(Boolean smsOnStart) {
        this.smsOnStart = smsOnStart;
    }

    public Boolean getEmailOnSuccess() {
        return emailOnSuccess;
    }

    public void setEmailOnSuccess(Boolean emailOnSuccess) {
        this.emailOnSuccess = emailOnSuccess;
    }

    public Boolean getSmsOnSuccess() {
        return smsOnSuccess;
    }

    public void setSmsOnSuccess(Boolean smsOnSuccess) {
        this.smsOnSuccess = smsOnSuccess;
    }

    public Boolean getEmailOnRejection() {
        return emailOnRejection;
    }

    public void setEmailOnRejection(Boolean emailOnRejection) {
        this.emailOnRejection = emailOnRejection;
    }

    public Boolean getSmsOnRejection() {
        return smsOnRejection;
    }

    public void setSmsOnRejection(Boolean smsOnRejection) {
        this.smsOnRejection = smsOnRejection;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}