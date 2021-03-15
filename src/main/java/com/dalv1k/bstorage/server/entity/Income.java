package com.dalv1k.bstorage.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Primary;
import org.springframework.core.SpringVersion;

import javax.jws.WebParam;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Entity
@Table(name = "income")
public class Income {

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

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "price")
    private Integer price;
    @Column(name = "amount")
    private Integer amount;

    @JsonFormat(pattern="dd.MM.yyyy")
    @Column(name = "date")
    private Date date;

    public Income() {
    }

    public Income(Income income){
        this.id=income.getId();
        this.type=income.getType();
        this.brand=income.getBrand();
        this.model=income.getModel();
        this.price=income.getPrice();
        this.amount=income.getAmount();
        this.supplier=income.getSupplier();
        this.date=income.getDate();
    }

    @Override
    public String toString() {
        return "IncomeGoods{" +
                "id=" + id +
                ", type=" + type +
                ", brand=" + brand +
                ", model=" + model +
                ", supplier=" + supplier +
                ", price=" + price +
                ", amount=" + amount +
                ", date=" + date +
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
