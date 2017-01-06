package com.white.ssm.model;

import java.util.Date;

/**
 * 匹配数据库中工资表的字段
 * 方便查询，插入数据等
 */
public class Pay {
    private Integer pId;

    private Integer eId;

    private Double pBonus;

    private String pYear;

    private String pMounth;

    private Integer pStatus;

    private Date pTime;

    private Double pBasic;

    private Double pTitle;

    private Double pDuties;

    private Double pSkill;

    private Double pEducation;

    private Double pOvertime;

    private Double pWalfare;

    private Double iSocial;

    private Double iPension;

    private Double iMedical;

    private Double iUnemploy;

    private Double pHousing;

    private Double pAbsence;

    private Double pFineother;

    private Double pFinesum;

    private Double pShouldsum;

    private Double pRealsum;

    private Double pTax;

    public Pay() {
    }

    public Pay(Integer pId, Integer eId, Double pBonus, Date pTime, Double pBasic, Double pTitle, Double pDuties, Double pSkill, Double pEducation, Double pOvertime, Double pWalfare, Double iSocial, Double iPension, Double iMedical, Double iUnemploy, Double pHousing, Double pAbsence, Double pFineother, Double pFinesum, Double pShouldsum, Double pRealsum, Double pTax) {
        this.pId = pId;
        this.eId = eId;
        this.pBonus = pBonus;
        this.pTime = pTime;
        this.pBasic = pBasic;
        this.pTitle = pTitle;
        this.pDuties = pDuties;
        this.pSkill = pSkill;
        this.pEducation = pEducation;
        this.pOvertime = pOvertime;
        this.pWalfare = pWalfare;
        this.iSocial = iSocial;
        this.iPension = iPension;
        this.iMedical = iMedical;
        this.iUnemploy = iUnemploy;
        this.pHousing = pHousing;
        this.pAbsence = pAbsence;
        this.pFineother = pFineother;
        this.pFinesum = pFinesum;
        this.pShouldsum = pShouldsum;
        this.pRealsum = pRealsum;
        this.pTax = pTax;
    }

    public Pay(Integer eId, Double pBonus, Date pTime, Double pBasic, Double pTitle, Double pDuties, Double pSkill, Double pEducation, Double pOvertime, Double pWalfare, Double iSocial, Double iPension, Double iMedical, Double iUnemploy, Double pHousing, Double pAbsence, Double pFineother, Double pFinesum, Double pShouldsum, Double pRealsum, Double pTax) {
        this.eId = eId;
        this.pBonus = pBonus;
        this.pTime = pTime;
        this.pBasic = pBasic;
        this.pTitle = pTitle;
        this.pDuties = pDuties;
        this.pSkill = pSkill;
        this.pEducation = pEducation;
        this.pOvertime = pOvertime;
        this.pWalfare = pWalfare;
        this.iSocial = iSocial;
        this.iPension = iPension;
        this.iMedical = iMedical;
        this.iUnemploy = iUnemploy;
        this.pHousing = pHousing;
        this.pAbsence = pAbsence;
        this.pFineother = pFineother;
        this.pFinesum = pFinesum;
        this.pShouldsum = pShouldsum;
        this.pRealsum = pRealsum;
        this.pTax = pTax;
    }


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Double getpBonus() {
        return pBonus;
    }

    public void setpBonus(Double pBonus) {
        this.pBonus = pBonus;
    }

    public String getpYear() {
        return pYear;
    }

    public void setpYear(String pYear) {
        this.pYear = pYear == null ? null : pYear.trim();
    }

    public String getpMounth() {
        return pMounth;
    }

    public void setpMounth(String pMounth) {
        this.pMounth = pMounth == null ? null : pMounth.trim();
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public Double getpBasic() {
        return pBasic;
    }

    public void setpBasic(Double pBasic) {
        this.pBasic = pBasic;
    }

    public Double getpTitle() {
        return pTitle;
    }

    public void setpTitle(Double pTitle) {
        this.pTitle = pTitle;
    }

    public Double getpDuties() {
        return pDuties;
    }

    public void setpDuties(Double pDuties) {
        this.pDuties = pDuties;
    }

    public Double getpSkill() {
        return pSkill;
    }

    public void setpSkill(Double pSkill) {
        this.pSkill = pSkill;
    }

    public Double getpEducation() {
        return pEducation;
    }

    public void setpEducation(Double pEducation) {
        this.pEducation = pEducation;
    }

    public Double getpOvertime() {
        return pOvertime;
    }

    public void setpOvertime(Double pOvertime) {
        this.pOvertime = pOvertime;
    }

    public Double getpWalfare() {
        return pWalfare;
    }

    public void setpWalfare(Double pWalfare) {
        this.pWalfare = pWalfare;
    }

    public Double getiSocial() {
        return iSocial;
    }

    public void setiSocial(Double iSocial) {
        this.iSocial = iSocial;
    }

    public Double getiPension() {
        return iPension;
    }

    public void setiPension(Double iPension) {
        this.iPension = iPension;
    }

    public Double getiMedical() {
        return iMedical;
    }

    public void setiMedical(Double iMedical) {
        this.iMedical = iMedical;
    }

    public Double getiUnemploy() {
        return iUnemploy;
    }

    public void setiUnemploy(Double iUnemploy) {
        this.iUnemploy = iUnemploy;
    }

    public Double getpHousing() {
        return pHousing;
    }

    public void setpHousing(Double pHousing) {
        this.pHousing = pHousing;
    }

    public Double getpAbsence() {
        return pAbsence;
    }

    public void setpAbsence(Double pAbsence) {
        this.pAbsence = pAbsence;
    }

    public Double getpFineother() {
        return pFineother;
    }

    public void setpFineother(Double pFineother) {
        this.pFineother = pFineother;
    }

    public Double getpFinesum() {
        return pFinesum;
    }

    public void setpFinesum(Double pFinesum) {
        this.pFinesum = pFinesum;
    }

    public Double getpShouldsum() {
        return pShouldsum;
    }

    public void setpShouldsum(Double pShouldsum) {
        this.pShouldsum = pShouldsum;
    }

    public Double getpRealsum() {
        return pRealsum;
    }

    public void setpRealsum(Double pRealsum) {
        this.pRealsum = pRealsum;
    }

    public Double getpTax() {
        return pTax;
    }

    public void setpTax(Double pTax) {
        this.pTax = pTax;
    }
}