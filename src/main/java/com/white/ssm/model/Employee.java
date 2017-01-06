package com.white.ssm.model;

public class Employee {
    private Integer eId;

    private String eName;

    private String eSex;

    private String eTitle;

    private Integer orderBy;

    private String ePass;

    private String eDepart;

    private String eImg;

    private String eIntro;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle == null ? null : eTitle.trim();
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getePass() {
        return ePass;
    }

    public void setePass(String ePass) {
        this.ePass = ePass == null ? null : ePass.trim();
    }

    public String geteDepart() {
        return eDepart;
    }

    public void seteDepart(String eDepart) {
        this.eDepart = eDepart == null ? null : eDepart.trim();
    }

    public String geteImg() {
        return eImg;
    }

    public void seteImg(String eImg) {
        this.eImg = eImg == null ? null : eImg.trim();
    }

    public String geteIntro() {
        return eIntro;
    }

    public void seteIntro(String eIntro) {
        this.eIntro = eIntro == null ? null : eIntro.trim();
    }
}