package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Entity;
import java.util.Date;

public class Stockstatus extends Entity {
    private Integer productId;

    private Integer incount;

    private Integer outcount;

    private Integer remaincount;

    private Date updatetime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getIncount() {
        return incount;
    }

    public void setIncount(Integer incount) {
        this.incount = incount;
    }

    public Integer getOutcount() {
        return outcount;
    }

    public void setOutcount(Integer outcount) {
        this.outcount = outcount;
    }

    public Integer getRemaincount() {
        return remaincount;
    }

    public void setRemaincount(Integer remaincount) {
        this.remaincount = remaincount;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}