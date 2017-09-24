package com.social.entities;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class Bike {

    private long id;

    private String model;

    private int gears;

    private boolean isSold;

    public Bike() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGears() {
        return this.gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public boolean isSold() {
        return this.isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
