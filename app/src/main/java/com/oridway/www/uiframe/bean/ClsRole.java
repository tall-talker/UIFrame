package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsRole implements Parcelable {

    private String RowID;
    private String sysRoleID;
    private String sysRoleName;
    private String sysRoleDesc;
    private String sysRoleType;
    private String sysRoleTypeName;
    private String orgID;
    private String orgName;
    private String isOff;
    private String setOffDate;
    private String createrID;
    private String creater;
    private String modiManID;
    private String modiManName;

    private boolean isCheckBoxVisible;
    private boolean isChecked;

    public ClsRole() {
    }

    public String getRowID() {
        return RowID;
    }

    public void setRowID(String rowID) {
        RowID = rowID;
    }

    public String getSysRoleID() {
        return sysRoleID;
    }

    public void setSysRoleID(String sysRoleID) {
        this.sysRoleID = sysRoleID;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public String getSysRoleDesc() {
        return sysRoleDesc;
    }

    public void setSysRoleDesc(String sysRoleDesc) {
        this.sysRoleDesc = sysRoleDesc;
    }

    public String getSysRoleType() {
        return sysRoleType;
    }

    public void setSysRoleType(String sysRoleType) {
        this.sysRoleType = sysRoleType;
    }

    public String getSysRoleTypeName() {
        return sysRoleTypeName;
    }

    public void setSysRoleTypeName(String sysRoleTypeName) {
        this.sysRoleTypeName = sysRoleTypeName;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getCreaterID() {
        return createrID;
    }

    public void setCreaterID(String createrID) {
        this.createrID = createrID;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
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
        return "ClsRole{" +
                "sysRoleID='" + sysRoleID + '\'' +
                ", sysRoleName='" + sysRoleName + '\'' +
                ", sysRoleDesc='" + sysRoleDesc + '\'' +
                ", sysRoleType='" + sysRoleType + '\'' +
                ", sysRoleTypeName='" + sysRoleTypeName + '\'' +
                ", orgID='" + orgID + '\'' +
                ", orgName='" + orgName + '\'' +
                ", isOff='" + isOff + '\'' +
                ", setOffDate='" + setOffDate + '\'' +
                ", createrID='" + createrID + '\'' +
                ", creater='" + creater + '\'' +
                ", modiManID='" + modiManID + '\'' +
                ", modiManName='" + modiManName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.RowID);
        dest.writeString(this.sysRoleID);
        dest.writeString(this.sysRoleName);
        dest.writeString(this.sysRoleDesc);
        dest.writeString(this.sysRoleType);
        dest.writeString(this.sysRoleTypeName);
        dest.writeString(this.orgID);
        dest.writeString(this.orgName);
        dest.writeString(this.isOff);
        dest.writeString(this.setOffDate);
        dest.writeString(this.createrID);
        dest.writeString(this.creater);
        dest.writeString(this.modiManID);
        dest.writeString(this.modiManName);
    }

    protected ClsRole(Parcel in) {
        this.RowID = in.readString();
        this.sysRoleID = in.readString();
        this.sysRoleName = in.readString();
        this.sysRoleDesc = in.readString();
        this.sysRoleType = in.readString();
        this.sysRoleTypeName = in.readString();
        this.orgID = in.readString();
        this.orgName = in.readString();
        this.isOff = in.readString();
        this.setOffDate = in.readString();
        this.createrID = in.readString();
        this.creater = in.readString();
        this.modiManID = in.readString();
        this.modiManName = in.readString();
    }

    public static final Parcelable.Creator<ClsRole> CREATOR = new Parcelable.Creator<ClsRole>() {
        @Override
        public ClsRole createFromParcel(Parcel source) {
            return new ClsRole(source);
        }

        @Override
        public ClsRole[] newArray(int size) {
            return new ClsRole[size];
        }
    };
}
