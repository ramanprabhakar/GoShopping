package com.ramanprabhakar.goshopping.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 5/22/2016.
 */
public class Params implements Serializable {

    @SerializedName("q")
    String q;

    @SerializedName("fl")
    String fl;

    @SerializedName("start")
    String start;

    @SerializedName("fq")
    String fq;

    @SerializedName("rows")
    String rows;

    @SerializedName("wt")
    String wt;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFq() {
        return fq;
    }

    public void setFq(String fq) {
        this.fq = fq;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

}
