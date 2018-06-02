package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;

public class Productinfo extends Entity {
    private Integer productId;

    private String name;

    private Integer dkspecId;

    private Integer specId;

    private Integer temp;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDkspecId() {
        return dkspecId;
    }

    public void setDkspecId(Integer dkspecId) {
        this.dkspecId = dkspecId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}