package com.mo1451.model;

public class ComFun {
    private Integer id;

    private String prename;

    private String function;

    private String aftername;

    private String para;

    private Integer type;

    private Integer level;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename == null ? null : prename.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getAftername() {
        return aftername;
    }

    public void setAftername(String aftername) {
        this.aftername = aftername == null ? null : aftername.trim();
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para == null ? null : para.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}