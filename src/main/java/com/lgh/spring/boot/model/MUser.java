package com.lgh.spring.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/3.
 * 用户
 */
@Entity
@Table(name = "user")
public class MUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "uuid")
    private String id;
    private String name;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Set<MCalender> calenders = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MCalender> getCalenders() {
        return calenders;
    }

    public void setCalenders(Set<MCalender> calenders) {
        this.calenders = calenders;
    }
}
