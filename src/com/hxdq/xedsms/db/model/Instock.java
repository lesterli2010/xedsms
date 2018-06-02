package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;
import java.util.Date;

public class Instock extends Entity {
    private Integer inId;

    private Date inTime;

    private String operator;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}