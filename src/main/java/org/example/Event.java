package org.example;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Event {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    private String name;
    private String type;
    private String description;
    private Schedule schedule;
    private Reminder smsReminder;
    private Reminder emailReminder;
    private String color;
    private List<String> interviewers;

    public static class Schedule {
        private OffsetDateTime start;
        private OffsetDateTime end;

        public OffsetDateTime getStart() {
            return start;
        }

        public void setStart(OffsetDateTime start) {
            this.start = start;
        }

        public OffsetDateTime getEnd() {
            return end;
        }

        public void setEnd(OffsetDateTime end) {
            this.end = end;
        }
    }

    public static class Reminder {
        private OffsetDateTime date;
        private String template;

        public OffsetDateTime getDate() {
            return date;
        }

        public void setDate(OffsetDateTime date) {
            this.date = date;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Reminder getSmsReminder() {
        return smsReminder;
    }

    public void setSmsReminder(Reminder smsReminder) {
        this.smsReminder = smsReminder;
    }

    public Reminder getEmailReminder() {
        return emailReminder;
    }

    public void setEmailReminder(Reminder emailReminder) {
        this.emailReminder = emailReminder;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<String> interviewers) {
        this.interviewers = interviewers;
    }

    public Event(String name, String type, String description, Schedule schedule, Reminder smsReminder, Reminder emailReminder, String color, List<String> interviewers) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.schedule = schedule;
        this.smsReminder = smsReminder;
        this.emailReminder = emailReminder;
        this.color = color;
        this.interviewers = interviewers;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("name: ").append(name).append("\n");
        builder.append("type: ").append(type).append("\n");
        builder.append("description: ").append(description).append("\n");
        builder.append("schedule:\n");
        builder.append("  start: ").append(schedule.getStart().format(DATE_TIME_FORMATTER)).append("\n");
        builder.append("  end: ").append(schedule.getEnd().format(DATE_TIME_FORMATTER)).append("\n");
        builder.append("smsReminder:\n");
        builder.append("  date: ").append(smsReminder.getDate().format(DATE_TIME_FORMATTER)).append("\n");
        builder.append("  smsTemplate: ").append(smsReminder.getTemplate()).append("\n");
        builder.append("emailReminder:\n");
        builder.append("  date: ").append(emailReminder.getDate().format(DATE_TIME_FORMATTER)).append("\n");
        builder.append("  emailTemplate: ").append(emailReminder.getTemplate()).append("\n");
        builder.append("color: ").append(color).append("\n");
        builder.append("interviewers: ").append(interviewers.stream().collect(Collectors.joining(", "))).append("\n");
        return builder.toString();
    }

}


