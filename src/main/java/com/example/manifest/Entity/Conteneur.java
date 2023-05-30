package com.example.manifest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conteneur {
    @Id
    private Long id;
    private String type;
    private String scalle;
    private String remp;
    private String marque;
    private String resp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScalle() {
        return scalle;
    }

    public void setScalle(String scalle) {
        this.scalle = scalle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getRemp() {
        return remp;
    }

    public void setRemp(String remp) {
        this.remp = remp;
    }
}
