package com.mo1451.model;

public class ObjFieldWithBLOBs extends ObjField {
    private String explain1;

    private String explain2;

    private String explain3;

    public String getExplain1() {
        return explain1;
    }

    public void setExplain1(String explain1) {
        this.explain1 = explain1 == null ? null : explain1.trim();
    }

    public String getExplain2() {
        return explain2;
    }

    public void setExplain2(String explain2) {
        this.explain2 = explain2 == null ? null : explain2.trim();
    }

    public String getExplain3() {
        return explain3;
    }

    public void setExplain3(String explain3) {
        this.explain3 = explain3 == null ? null : explain3.trim();
    }
}