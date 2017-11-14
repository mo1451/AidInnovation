package com.mo1451.model;

public class ProblemDescrWithBLOBs extends ProblemDescr {
    private String source;

    private String descr;

    private String principle;

    private String exist;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle == null ? null : principle.trim();
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist == null ? null : exist.trim();
    }
}