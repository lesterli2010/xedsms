package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;

public class Dkspecinfo extends Entity {
    private Integer dkspecId;

    private String dkspecName;

    public Integer getDkspecId() {
        return dkspecId;
    }

    public void setDkspecId(Integer dkspecId) {
        this.dkspecId = dkspecId;
    }

    public String getDkspecName() {
        return dkspecName;
    }

    public void setDkspecName(String dkspecName) {
        this.dkspecName = dkspecName;
    }
}