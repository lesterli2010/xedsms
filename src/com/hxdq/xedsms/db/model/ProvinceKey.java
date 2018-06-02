package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;

public class ProvinceKey extends Entity {
    private Integer provId;

    private String provName;

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
}