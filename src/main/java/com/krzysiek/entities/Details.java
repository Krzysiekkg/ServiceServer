package com.krzysiek.entities;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailid")
    private Long detailId;
    @Column(name = "detaildescription")
    private String detailDescription;
    private int status;
   /* @Column(name = "pylon_id")
    private Long idPylon;*/

    @ManyToOne
    @JoinColumn(name = "pylon_id")
    private Pylon pylon;

    public Pylon getPylon() {
        return pylon;
    }

    public void setPylon(Pylon pylon) {
        this.pylon = pylon;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
