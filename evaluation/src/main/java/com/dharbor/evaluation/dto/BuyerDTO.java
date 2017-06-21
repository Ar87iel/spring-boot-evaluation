package com.dharbor.evaluation.dto;

/**
 * Created by lito on 21/6/17.
 */
public class BuyerDTO {
    private Long id;
    private String name;
    private String professiom;
    private long ci;
    private long cel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessiom() {
        return professiom;
    }

    public void setProfessiom(String professiom) {
        this.professiom = professiom;
    }

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public long getCel() {
        return cel;
    }

    public void setCel(long cel) {
        this.cel = cel;
    }
}
