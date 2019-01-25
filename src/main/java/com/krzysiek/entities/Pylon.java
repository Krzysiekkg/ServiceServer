package com.krzysiek.entities;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "task_id")
    private Long idTask;

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

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }
}
