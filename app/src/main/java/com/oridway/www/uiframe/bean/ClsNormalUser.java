package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsNormalUser implements Parcelable {

    private String RowID;
    private String userID;
    private String workNumber;
    private String userType;
    private String orgName;
    private String cName;
    private String sysUserName;
    private String orgID;
    private String workPos;
    private String officeTel;
    private String mobile;
    private String e_mail;
    private String isOff;
    private String setOffDate;
    private String sysUserDesc;
    private String cmdEnable;
    private String modiManID;
    private String modiManName;
    private String modiTime;
    private boolean isCheckBoxVisible;
    private boolean isChecked;

    public ClsNormalUser() {
    }

    public String getCName() {
        return this.cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getRowID() {
        return RowID;
    }

    public void setRowID(String rowID) {
        RowID = rowID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getWorkPos() {
        return workPos;
    }

    public void setWorkPos(String workPos) {
        this.workPos = workPos;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getIsOff() {
        return isOff;
    }

    public void setIsOff(String isOff) {
        this.isOff = isOff;
    }

    public String getSetOffDate() {
        return setOffDate;
    }

    public void setSetOffDate(String setOffDate) {
        this.setOffDate = setOffDate;
    }

    public String getSysUserDesc() {
        return sysUserDesc;
    }

    public void setSysUserDesc(String sysUserDesc) {
        this.sysUserDesc = sysUserDesc;
    }

    public String getCmdEnable() {
        return cmdEnable;
    }

    public void setCmdEnable(String cmdEnable) {
        this.cmdEnable = cmdEnable;
    }

    public String getModiManID() {
        return modiManID;
    }

    public void setModiManID(String modiManID) {
        this.modiManID = modiManID;
    }

    public String getModiManName() {
        return modiManName;
    }

    public void setModiManName(String modiManName) {
        this.modiManName = modiManName;
    }

    public String getModiTime() {
        return modiTime;
    }

    public void setModiTime(String modiTime) {
        this.modiTime = modiTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public boolean getIsCheckBoxVisible() {
        return isCheckBoxVisible;
    }

    public void setIsCheckBoxVisible(boolean checkBoxVisible) {
        isCheckBoxVisible = checkBoxVisible;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    @Override
    public String toString() {
        return "ClsNormalUser{" +
                "RowID='" + RowID + '\'' +
                ", userID='" + userID + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", userType='" + userType + '\'' +
                ", cName='" + cName + '\'' +
                ", sysUserName='" + sysUserName + '\'' +
                ", orgID='" + orgID + '\'' +
                ", workPos='" + workPos + '\'' +
                ", officeTel='" + officeTel + '\'' +
                ", mobile='" + mobile + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", isOff='" + isOff + '\'' +
                ", setOffDate='" + setOffDate + '\'' +
                ", sysUserDesc='" + sysUserDesc + '\'' +
                ", cmdEnable='" + cmdEnable + '\'' +
                ", modiManID='" + modiManID + '\'' +
                ", modiManName='" + modiManName + '\'' +
                ", modiTime='" + modiTime + '\'' +
                ", isCheckBoxVisible=" + isCheckBoxVisible +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.RowID);
        dest.writeString(this.userID);
        dest.writeString(this.workNumber);
        dest.writeString(this.userType);
        dest.writeString(this.orgName);
        dest.writeString(this.cName);
        dest.writeString(this.sysUserName);
        dest.writeString(this.orgID);
        dest.writeString(this.workPos);
        dest.writeString(this.officeTel);
        dest.writeString(this.mobile);
        dest.writeString(this.e_mail);
        dest.writeString(this.isOff);
        dest.writeString(this.setOffDate);
        dest.writeString(this.sysUserDesc);
        dest.writeString(this.cmdEnable);
        dest.writeString(this.modiManID);
        dest.writeString(this.modiManName);
        dest.writeString(this.modiTime);
    }

    protected ClsNormalUser(Parcel in) {
        this.RowID = in.readString();
        this.userID = in.readString();
        this.workNumber = in.readString();
        this.userType = in.readString();
        this.orgName = in.readString();
        this.cName = in.readString();
        this.sysUserName = in.readString();
        this.orgID = in.readString();
        this.workPos = in.readString();
        this.officeTel = in.readString();
        this.mobile = in.readString();
        this.e_mail = in.readString();
        this.isOff = in.readString();
        this.setOffDate = in.readString();
        this.sysUserDesc = in.readString();
        this.cmdEnable = in.readString();
        this.modiManID = in.readString();
        this.modiManName = in.readString();
        this.modiTime = in.readString();
    }

    public static final Parcelable.Creator<ClsNormalUser> CREATOR = new Parcelable.Creator<ClsNormalUser>() {
        @Override
        public ClsNormalUser createFromParcel(Parcel source) {
            return new ClsNormalUser(source);
        }

        @Override
        public ClsNormalUser[] newArray(int size) {
            return new ClsNormalUser[size];
        }
    };
}
