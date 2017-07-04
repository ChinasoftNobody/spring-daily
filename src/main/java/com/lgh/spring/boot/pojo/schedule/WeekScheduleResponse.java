package com.lgh.spring.boot.pojo.schedule;

import com.lgh.spring.boot.model.MEvent;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */
public class WeekScheduleResponse {
    private String weekNumber;
    private List<MEvent> events;

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public List<MEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MEvent> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekScheduleResponse that = (WeekScheduleResponse) o;

        return weekNumber != null ? weekNumber.equals(that.weekNumber) : that.weekNumber == null;
    }

    @Override
    public int hashCode() {
        return weekNumber != null ? weekNumber.hashCode() : 0;
    }
}
