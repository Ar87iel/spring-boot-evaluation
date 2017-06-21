package com.dharbor.evaluation.dto;

/**
 * Created by lito on 21/6/17.
 */
public class SellerDTO {
    private String name;
    private Integer age;
    private long ci;
    private Integer numCar;
    private Long id;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public Integer getNumCar() {
        return numCar;
    }

    public void setNumCar(Integer numCar) {
        this.numCar = numCar;
    }
}
