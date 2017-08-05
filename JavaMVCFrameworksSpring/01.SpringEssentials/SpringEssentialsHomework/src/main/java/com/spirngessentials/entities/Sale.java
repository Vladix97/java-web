package com.spirngessentials.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sales")
public class Sale implements Serializable {

    private Long id;

    private Float discount;

    private Car car;

    private Customer customer;

    public Sale() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "discount")
    public Float getDiscount() {
        return this.discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
