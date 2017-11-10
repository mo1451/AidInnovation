package com.mo1451.model;

public class ProblemDescr {
    private Integer id;

    private String fun;

    private String component;

    private String problem;

    private String parameter;

    private String goal;

    private String lim;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun == null ? null : fun.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal == null ? null : goal.trim();
    }

    public String getLim() {
        return lim;
    }

    public void setLim(String lim) {
        this.lim = lim == null ? null : lim.trim();
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}