package com.dharbor.evaluation.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lito on 21/6/17.
 */
@Entity
public class RegistryCarSold {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date sellingDate;
    @OneToOne
    private Car car;
    @OneToOne
    private Seller seller;
    @OneToOne
    private Buyer buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
