package com.mo1451.model;

public class Physical {
    private Integer id;

    private String txt1;

    private String txt2;

    private String txt3;

    private String txt4;

    private String txt5;

    private String txt6;

    private String space;

    private String tim;

    private String cond;

    private String whole;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1 == null ? null : txt1.trim();
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2 == null ? null : txt2.trim();
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3 == null ? null : txt3.trim();
    }

    public String getTxt4() {
        return txt4;
    }

    public void setTxt4(String txt4) {
        this.txt4 = txt4 == null ? null : txt4.trim();
    }

    public String getTxt5() {
        return txt5;
    }

    public void setTxt5(String txt5) {
        this.txt5 = txt5 == null ? null : txt5.trim();
    }

    public String getTxt6() {
        return txt6;
    }

    public void setTxt6(String txt6) {
        this.txt6 = txt6 == null ? null : txt6.trim();
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space == null ? null : space.trim();
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim == null ? null : tim.trim();
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond == null ? null : cond.trim();
    }

    public String getWhole() {
        return whole;
    }

    public void setWhole(String whole) {
        this.whole = whole == null ? null : whole.trim();
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}