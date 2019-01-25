package com.krzysiek.entities;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column(name = "user_id")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
