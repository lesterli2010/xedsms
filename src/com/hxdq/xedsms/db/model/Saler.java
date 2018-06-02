package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;

public class Saler extends Entity {
    private Integer salerId;

    private String name;

    private String phone;

    private String position;

    public Integer getSalerId() {
        return salerId;
    }

    public void setSalerId(Integer salerId) {
        this.salerId = salerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}