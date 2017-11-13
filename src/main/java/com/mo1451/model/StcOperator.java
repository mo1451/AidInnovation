package com.mo1451.model;

public class StcOperator {
    private Integer id;

    private String big;

    private String small;

    private String shortTime;

    private String longTime;

    private String expensive;

    private String chip;

    private Integer wordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big == null ? null : big.trim();
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small == null ? null : small.trim();
    }

    public String getShortTime() {
        return shortTime;
    }

    public void setShortTime(String shortTime) {
        this.shortTime = shortTime == null ? null : shortTime.trim();
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime == null ? null : longTime.trim();
    }

    public String getExpensive() {
        return expensive;
    }

    public void setExpensive(String expensive) {
        this.expensive = expensive == null ? null : expensive.trim();
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip == null ? null : chip.trim();
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }
}