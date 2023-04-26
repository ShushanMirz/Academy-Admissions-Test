package org.example;

public class Note {

    private String subject;
    private String applicant;
    private String text;
    private String courseTitle;

    public Note(String subject, String applicant, String text, String courseTitle) {
        super();
        this.subject = subject;
        this.applicant = applicant;
        this.text = text;
        this.courseTitle = courseTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

}
