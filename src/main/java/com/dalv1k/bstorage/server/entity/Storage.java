package com.dalv1k.bstorage.server.entity;

import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Primary;
import org.springframework.core.SpringVersion;

import javax.jws.WebParam;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "type_id")
    private Type type;


    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "model_id")
    private Model model;


    @Column(name = "last_price")
    private Integer lastPrice;
    @Column(name = "amount")
    private Integer amount;


    public Storage() {
    }

    public Storage(Type type, Brand brand, Model model, Integer lastPrice, Integer amount){
        this.type=type;
        this.brand=brand;
        this.model=model;
        this.lastPrice=lastPrice;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", type=" + type +
                ", brand=" + brand +
                ", model=" + model +
                ", lastPrice=" + lastPrice +
                ", amount=" + amount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
