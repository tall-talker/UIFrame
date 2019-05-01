package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsOnlineReport implements Parcelable {

    private String bulletinID;
    private String bulletinTime;
    private String bulletinTitle;
    private String isActive;
    private String activeDate;
    private String autoCloseDate;
    private String modiManID;
    private String modiManName;
    private String orderNum;
    private String onTop;
    private String createrID;
    private String creater;
    private boolean isChecked;
    private boolean isCheckBoxVisible;

    public ClsOnlineReport() {
    }

    public String getBulletinID() {
        return bulletinID;
    }

    public void setBulletinID(String bulletinID) {
        this.bulletinID = bulletinID;
    }

    public String getBulletinTime() {
        return bulletinTime;
    }

    public void setBulletinTime(String bulletinTime) {
        this.bulletinTime = bulletinTime;
    }

    public String getBulletinTitle() {
        return bulletinTitle;
    }

    public void setBulletinTitle(String bulletinTitle) {
        this.bulletinTitle = bulletinTitle;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getAutoCloseDate() {
        return autoCloseDate;
    }

    public void setAutoCloseDate(String autoCloseDate) {
        this.autoCloseDate = autoCloseDate;
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOnTop() {
        return onTop;
    }

    public void setOnTop(String onTop) {
        this.onTop = onTop;
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

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean getIsCheckBoxVisible() {
        return isCheckBoxVisible;
    }

    public void setIsCheckBoxVisible(boolean isCheckBoxVisible) {
        this.isCheckBoxVisible = isCheckBoxVisible;
    }



    @Override
    public String toString() {
        return "ClsOnlineReport{" +
                ", bulletinID='" + bulletinID + '\'' +
                ", bulletinTime='" + bulletinTime + '\'' +
                ", bulletinTitle='" + bulletinTitle + '\'' +
                ", isActive='" + isActive + '\'' +
                ", activeDate='" + activeDate + '\'' +
                ", autoCloseDate='" + autoCloseDate + '\'' +
                ", modiManID='" + modiManID + '\'' +
                ", modiManName='" + modiManName + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", onTop='" + onTop + '\'' +
                ", createrID='" + createrID + '\'' +
                ", creater='" + creater + '\'' +
                ", isChecked=" + isChecked +
                ", isCheckBoxVisible=" + isCheckBoxVisible +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bulletinID);
        dest.writeString(this.bulletinTime);
        dest.writeString(this.bulletinTitle);
        dest.writeString(this.isActive);
        dest.writeString(this.activeDate);
        dest.writeString(this.autoCloseDate);
        dest.writeString(this.modiManID);
        dest.writeString(this.modiManName);
        dest.writeString(this.orderNum);
        dest.writeString(this.onTop);
        dest.writeString(this.createrID);
        dest.writeString(this.creater);
    }

    protected ClsOnlineReport(Parcel in) {
        this.bulletinID = in.readString();
        this.bulletinTime = in.readString();
        this.bulletinTitle = in.readString();
        this.isActive = in.readString();
        this.activeDate = in.readString();
        this.autoCloseDate = in.readString();
        this.modiManID = in.readString();
        this.modiManName = in.readString();
        this.orderNum = in.readString();
        this.onTop = in.readString();
        this.createrID = in.readString();
        this.creater = in.readString();
    }

    public static final Parcelable.Creator<ClsOnlineReport> CREATOR = new Parcelable.Creator<ClsOnlineReport>() {
        @Override
        public ClsOnlineReport createFromParcel(Parcel source) {
            return new ClsOnlineReport(source);
        }

        @Override
        public ClsOnlineReport[] newArray(int size) {
            return new ClsOnlineReport[size];
        }
    };
}