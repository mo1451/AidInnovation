package com.mo1451.model;

public class Tech {
    private Integer id;

    private String a1;

    private String a2;

    private String b1;

    private String b2;

    private String c1;

    private String c2;

    private Integer techCon;

    private String com1;

    private String com2;

    private String com3;

    private Integer improve;

    private Integer worse;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1 == null ? null : a1.trim();
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1 == null ? null : b1.trim();
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2 == null ? null : b2.trim();
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public Integer getTechCon() {
        return techCon;
    }

    public void setTechCon(Integer techCon) {
        this.techCon = techCon;
    }

    public String getCom1() {
        return com1;
    }

    public void setCom1(String com1) {
        this.com1 = com1 == null ? null : com1.trim();
    }

    public String getCom2() {
        return com2;
    }

    public void setCom2(String com2) {
        this.com2 = com2 == null ? null : com2.trim();
    }

    public String getCom3() {
        return com3;
    }

    public void setCom3(String com3) {
        this.com3 = com3 == null ? null : com3.trim();
    }

    public Integer getImprove() {
        return improve;
    }

    public void setImprove(Integer improve) {
        this.improve = improve;
    }

    public Integer getWorse() {
        return worse;
    }

    public void setWorse(Integer worse) {
        this.worse = worse;
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}