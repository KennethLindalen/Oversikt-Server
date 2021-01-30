package dev.kennethlindalen.rkupongoversikt.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trening {

    @Id
    String id;
    String dato;
    String stil;
    String tid;
    Boolean fullfort;
    Boolean planlagt;


    public Trening(String dato, String stil, String tid, Boolean fullfort, Boolean planlagt) {
        this.dato = dato;
        this.stil = stil;
        this.tid = tid;
        this.fullfort = fullfort;
        this.planlagt = planlagt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Boolean getFullfort() {
        return fullfort;
    }

    public void setFullfort(Boolean fullfort) {
        this.fullfort = fullfort;
    }

    public Boolean getPlanlagt() {
        return planlagt;
    }

    public void setPlanlagt(Boolean planlagt) {
        this.planlagt = planlagt;
    }

    @Override
    public String toString() {
        return "Trening{" +
                "id='" + id + '\'' +
                ", dato=" + dato +
                ", stil='" + stil + '\'' +
                ", tid='" + tid + '\'' +
                ", fullfort=" + fullfort +
                ", planlagt=" + planlagt +
                '}';
    }
}
