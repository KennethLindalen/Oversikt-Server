package dev.kennethlindalen.rkupongoversikt.Controller;

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
}
