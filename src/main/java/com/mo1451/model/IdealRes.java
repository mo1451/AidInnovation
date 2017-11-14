package com.mo1451.model;

public class IdealRes {
    private Integer id;

    private String aim;

    private String result;

    private String obstacle;

    private String obsRes;

    private String cond;

    private String resource;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim == null ? null : aim.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle == null ? null : obstacle.trim();
    }

    public String getObsRes() {
        return obsRes;
    }

    public void setObsRes(String obsRes) {
        this.obsRes = obsRes == null ? null : obsRes.trim();
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond == null ? null : cond.trim();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}