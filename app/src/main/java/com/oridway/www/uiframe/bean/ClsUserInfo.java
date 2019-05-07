package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsUserInfo implements Parcelable {

    private String userID;
    private String workNumber;
    private String userType;
    private String userTypeDesc;
    private String cName;
    private String inputCode;
    private String sex;
    private String sexDesc;
    private String birthDay;
    private String orgID;
    private String orgName;
    private String workPosID;
    private String workPos;
    private String officeTel;
    private String mobile;
    private String e_mail;
    private String sysUserName;
    private String sysUserDesc;
    private String sysPassword;
    private String pswProtectQuestion;
    private String pswProtectAnswer;
    private String userRolesDesc;
    private String isOff;
    private String setOffDate;
    private String createrID;
    private String creater;
    private String createDate;
    private String modiManID;
    private String modiManName;
    private String modiTime;

    public ClsUserInfo() {
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

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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

    public String getWorkPosID() {
        return workPosID;
    }

    public void setWorkPosID(String workPosID) {
        this.workPosID = workPosID;
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

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserDesc() {
        return sysUserDesc;
    }

    public void setSysUserDesc(String sysUserDesc) {
        this.sysUserDesc = sysUserDesc;
    }

    public String getSysPassword() {
        return sysPassword;
    }

    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword;
    }

    public String getPswProtectQuestion() {
        return pswProtectQuestion;
    }

    public void setPswProtectQuestion(String pswProtectQuestion) {
        this.pswProtectQuestion = pswProtectQuestion;
    }

    public String getPswProtectAnswer() {
        return pswProtectAnswer;
    }

    public void setPswProtectAnswer(String pswProtectAnswer) {
        this.pswProtectAnswer = pswProtectAnswer;
    }

    public String getUserRolesDesc() {
        return userRolesDesc;
    }

    public void setUserRolesDesc(String userRolesDesc) {
        this.userRolesDesc = userRolesDesc;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    @Override
    public String toString() {
        return "ClsUserInfo{" +
                "userID='" + userID + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", userType='" + userType + '\'' +
                ", userTypeDesc='" + userTypeDesc + '\'' +
                ", cName='" + cName + '\'' +
                ", inputCode='" + inputCode + '\'' +
                ", sex='" + sex + '\'' +
                ", sexDesc='" + sexDesc + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", orgID='" + orgID + '\'' +
                ", orgName='" + orgName + '\'' +
                ", workPosID='" + workPosID + '\'' +
                ", workPos='" + workPos + '\'' +
                ", officeTel='" + officeTel + '\'' +
                ", mobile='" + mobile + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", sysUserName='" + sysUserName + '\'' +
                ", sysUserDesc='" + sysUserDesc + '\'' +
                ", sysPassword='" + sysPassword + '\'' +
                ", pswProtectQuestion='" + pswProtectQuestion + '\'' +
                ", pswProtectAnswer='" + pswProtectAnswer + '\'' +
                ", userRolesDesc='" + userRolesDesc + '\'' +
                ", isOff='" + isOff + '\'' +
                ", setOffDate='" + setOffDate + '\'' +
                ", createrID='" + createrID + '\'' +
                ", creater='" + creater + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modiManID='" + modiManID + '\'' +
                ", modiManName='" + modiManName + '\'' +
                ", modiTime='" + modiTime + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userID);
        dest.writeString(this.workNumber);
        dest.writeString(this.userType);
        dest.writeString(this.userTypeDesc);
        dest.writeString(this.cName);
        dest.writeString(this.inputCode);
        dest.writeString(this.sex);
        dest.writeString(this.sexDesc);
        dest.writeString(this.birthDay);
        dest.writeString(this.orgID);
        dest.writeString(this.orgName);
        dest.writeString(this.workPosID);
        dest.writeString(this.workPos);
        dest.writeString(this.officeTel);
        dest.writeString(this.mobile);
        dest.writeString(this.e_mail);
        dest.writeString(this.sysUserName);
        dest.writeString(this.sysUserDesc);
        dest.writeString(this.sysPassword);
        dest.writeString(this.pswProtectQuestion);
        dest.writeString(this.pswProtectAnswer);
        dest.writeString(this.userRolesDesc);
        dest.writeString(this.isOff);
        dest.writeString(this.setOffDate);
        dest.writeString(this.createrID);
        dest.writeString(this.creater);
        dest.writeString(this.createDate);
        dest.writeString(this.modiManID);
        dest.writeString(this.modiManName);
        dest.writeString(this.modiTime);
    }

    protected ClsUserInfo(Parcel in) {
        this.userID = in.readString();
        this.workNumber = in.readString();
        this.userType = in.readString();
        this.userTypeDesc = in.readString();
        this.cName = in.readString();
        this.inputCode = in.readString();
        this.sex = in.readString();
        this.sexDesc = in.readString();
        this.birthDay = in.readString();
        this.orgID = in.readString();
        this.orgName = in.readString();
        this.workPosID = in.readString();
        this.workPos = in.readString();
        this.officeTel = in.readString();
        this.mobile = in.readString();
        this.e_mail = in.readString();
        this.sysUserName = in.readString();
        this.sysUserDesc = in.readString();
        this.sysPassword = in.readString();
        this.pswProtectQuestion = in.readString();
        this.pswProtectAnswer = in.readString();
        this.userRolesDesc = in.readString();
        this.isOff = in.readString();
        this.setOffDate = in.readString();
        this.createrID = in.readString();
        this.creater = in.readString();
        this.createDate = in.readString();
        this.modiManID = in.readString();
        this.modiManName = in.readString();
        this.modiTime = in.readString();
    }

    public static final Parcelable.Creator<ClsUserInfo> CREATOR = new Parcelable.Creator<ClsUserInfo>() {
        @Override
        public ClsUserInfo createFromParcel(Parcel source) {
            return new ClsUserInfo(source);
        }

        @Override
        public ClsUserInfo[] newArray(int size) {
            return new ClsUserInfo[size];
        }
    };
}
