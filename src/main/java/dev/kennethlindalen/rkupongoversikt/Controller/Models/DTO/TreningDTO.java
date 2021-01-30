package dev.kennethlindalen.rkupongoversikt.Controller.Models.DTO;

public class TreningDTO {

    String id;
    String dato;
    String stil;
    String tid;
    Boolean fullfort;
    Boolean planlagt;

    public TreningDTO() {
    }

    public TreningDTO(String id, String dato, String stil, String tid, Boolean fullfort, Boolean planlagt) {
        this.id = id;
        this.dato = dato;
        this.stil = stil;
        this.tid = tid;
        this.fullfort = fullfort;
        this.planlagt = planlagt;
    }

    public TreningDTO(String dato, String stil, String tid, Boolean fullfort, Boolean planlagt) {
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
}
