package com.mo1451.model;

public class WordWithBLOBs extends Word {
    private String causalsol;

    private String ninesol;

    private String lifesol;

    private String resourcesol;

    private String functionsol;

    private String idealsol;

    private String techsol;

    private String physol;

    private String objsol;

    private String finalsol;

    public String getCausalsol() {
        return causalsol;
    }

    public void setCausalsol(String causalsol) {
        this.causalsol = causalsol == null ? null : causalsol.trim();
    }

    public String getNinesol() {
        return ninesol;
    }

    public void setNinesol(String ninesol) {
        this.ninesol = ninesol == null ? null : ninesol.trim();
    }

    public String getLifesol() {
        return lifesol;
    }

    public void setLifesol(String lifesol) {
        this.lifesol = lifesol == null ? null : lifesol.trim();
    }

    public String getResourcesol() {
        return resourcesol;
    }

    public void setResourcesol(String resourcesol) {
        this.resourcesol = resourcesol == null ? null : resourcesol.trim();
    }

    public String getFunctionsol() {
        return functionsol;
    }

    public void setFunctionsol(String functionsol) {
        this.functionsol = functionsol == null ? null : functionsol.trim();
    }

    public String getIdealsol() {
        return idealsol;
    }

    public void setIdealsol(String idealsol) {
        this.idealsol = idealsol == null ? null : idealsol.trim();
    }

    public String getTechsol() {
        return techsol;
    }

    public void setTechsol(String techsol) {
        this.techsol = techsol == null ? null : techsol.trim();
    }

    public String getPhysol() {
        return physol;
    }

    public void setPhysol(String physol) {
        this.physol = physol == null ? null : physol.trim();
    }

    public String getObjsol() {
        return objsol;
    }

    public void setObjsol(String objsol) {
        this.objsol = objsol == null ? null : objsol.trim();
    }

    public String getFinalsol() {
        return finalsol;
    }

    public void setFinalsol(String finalsol) {
        this.finalsol = finalsol == null ? null : finalsol.trim();
    }
}