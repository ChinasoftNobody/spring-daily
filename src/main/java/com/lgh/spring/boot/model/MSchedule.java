package com.lgh.spring.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/3.
 * 日程信息表
 */
@Entity
@Table(name = "schedule")
public class MSchedule {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "uuid")
    private String id;
    private String timeFrom;
    private String timeTo;
    private String goal;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "calender_schedule",
            joinColumns = { @JoinColumn(name = "calenderId", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "schedule", referencedColumnName = "id") })
    private Set<MCalender> calenders = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Set<MCalender> getCalenders() {
        return calenders;
    }

    public void setCalenders(Set<MCalender> calenders) {
        this.calenders = calenders;
    }
}
