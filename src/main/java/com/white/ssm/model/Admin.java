package com.white.ssm.model;

public class Admin {
    private Integer aId;

    private String aPass;

    private String aPhone;

    private String aName;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaPass() {
        return aPass;
    }

    public void setaPass(String aPass) {
        this.aPass = aPass == null ? null : aPass.trim();
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone == null ? null : aPhone.trim();
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }
}