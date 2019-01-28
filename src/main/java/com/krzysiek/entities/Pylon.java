package com.krzysiek.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pylons")
public class Pylon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pylonid")
    private Long pylonId;
    private String description;
    private String longitude;
    private String latitude;
    //istnienie tego jeszcze trzeba przemyśleć
    private String done;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Tasks tasks;
    @JsonBackReference
    @OneToMany(mappedBy = "pylon", cascade = CascadeType.ALL)
    private Set<Details> detailsSet;


    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Set<Details> getDetailsSet() {
        return detailsSet;
    }

    public void setDetailsSet(Set<Details> detailsSet) {
        this.detailsSet = detailsSet;
    }


    public Long getPylonId() {
        return pylonId;
    }

    public void setPylonId(Long pylonId) {
        this.pylonId = pylonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

}
