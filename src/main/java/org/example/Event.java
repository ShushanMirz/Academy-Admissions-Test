package org.example;

import java.util.List;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;



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


        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("start")
        public String getStart() {
            return start;
        }

        @JsonProperty("start")
        public void setStart(String start) {
            this.start = start;
        }

        @JsonProperty("end")
        public String getEnd() {
            return end;
        }

        @JsonProperty("end")
        public void setEnd(String end) {
            this.end = end;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("smsReminder")
        public String getSmsReminder() {
            return smsReminder;
        }

        @JsonProperty("smsReminder")
        public void setSmsReminder(String smsReminder) {
            this.smsReminder = smsReminder;
        }

        @JsonProperty("emailReminder")
        public String getEmailReminder() {
            return emailReminder;
        }

        @JsonProperty("emailReminder")
        public void setEmailReminder(String emailReminder) {
            this.emailReminder = emailReminder;
        }

        @JsonProperty("duration")
        public Integer getDuration() {
            return duration;
        }

        @JsonProperty("duration")
        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        @JsonProperty("interviewers")
        public List<Interviewer> getInterviewers() {
            return interviewers;
        }

        @JsonProperty("interviewers")
        public void setInterviewers(List<Interviewer> interviewers) {
            this.interviewers = interviewers;
        }


    public class Interval {

        @JsonProperty("start")
        private String start;
        @JsonProperty("end")
        private String end;

        @JsonProperty("start")
        public String getStart() {
            return start;
        }

        @JsonProperty("start")
        public void setStart(String start) {
            this.start = start;
        }

        @JsonProperty("end")
        public String getEnd() {
            return end;
        }

        @JsonProperty("end")
        public void setEnd(String end) {
            this.end = end;
        }

    }


    public class Interviewer {

        private String interviewer;
        private List<Schedule> schedule;

        @JsonProperty("interviewer")
        public String getInterviewer() {
            return interviewer;
        }

        @JsonProperty("interviewer")
        public void setInterviewer(String interviewer) {
            this.interviewer = interviewer;
        }

        @JsonProperty("schedule")
        public List<Schedule> getSchedule() {
            return schedule;
        }

        @JsonProperty("schedule")
        public void setSchedule(List<Schedule> schedule) {
            this.schedule = schedule;
        }


    }



    @Generated("jsonschema2pojo")
    public class Schedule {

        @JsonProperty("date")
        private String date;
        @JsonProperty("intervals")
        private List<Interval> intervals;

        @JsonProperty("date")
        public String getDate() {
            return date;
        }

        @JsonProperty("date")
        public void setDate(String date) {
            this.date = date;
        }

        @JsonProperty("intervals")
        public List<Interval> getIntervals() {
            return intervals;
        }

        @JsonProperty("intervals")
        public void setIntervals(List<Interval> intervals) {
            this.intervals = intervals;
        }


    }
}
