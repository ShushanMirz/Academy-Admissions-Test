package org.example;

import java.util.List;

public class Schedule {
    private String weekDay;
    private List<Interval> intervals;
    public Schedule(String weekDay, List<Interval> intervals) {
        super();
        this.weekDay = weekDay;
        this.intervals = intervals;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }
}
