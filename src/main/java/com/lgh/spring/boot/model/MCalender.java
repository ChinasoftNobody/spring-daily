package com.lgh.spring.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/3.
 * 日历信息
 */
@Entity
@Table(name = "calender")
public class MCalender {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "uuid")
    private String id;
    private String date;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_calender",
            joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "calenderId", referencedColumnName = "id") })
    private Set<MUser> users = new HashSet<>();

    @ManyToMany(mappedBy = "calenders",cascade = CascadeType.PERSIST)
    private Set<MSchedule> schedules = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<MUser> getUsers() {
        return users;
    }

    public void setUsers(Set<MUser> users) {
        this.users = users;
    }

    public Set<MSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<MSchedule> schedules) {
        this.schedules = schedules;
    }
}
