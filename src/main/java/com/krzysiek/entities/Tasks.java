package com.krzysiek.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Tasks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private Long taskid;

    @Column(name = "team")
    private String team;

    @Column(name = "relation")
    private String relation;

/*
    @Column(name = "user_id")
    private String userId;*/
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private Set<Pylon> pylons;

    public Set<Pylon> getPylons() {
        return pylons;
    }

    public void setPylons(Set<Pylon> pylons) {
        this.pylons = pylons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

}
