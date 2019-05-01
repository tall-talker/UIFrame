package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsReply implements Parcelable {

    private String rowNum;
    private String topicID;
    private String replyID;
    private String replyContent;
    private String replyTime;
    private String replyBoutiqueNum;
    private String replyTopicNum;
    private String replyManID;
    private String replyManName;
    private boolean isChecked;
    private boolean isCheckBoxVisible;

    public ClsReply() {
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getReplyID() {
        return replyID;
    }

    public void setReplyID(String replyID) {
        this.replyID = replyID;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyBoutiqueNum() {
        return replyBoutiqueNum;
    }

    public void setReplyBoutiqueNum(String replyBoutiqueNum) {
        this.replyBoutiqueNum = replyBoutiqueNum;
    }

    public String getReplyTopicNum() {
        return replyTopicNum;
    }

    public void setReplyTopicNum(String replyTopicNum) {
        this.replyTopicNum = replyTopicNum;
    }

    public String getReplyManID() {
        return replyManID;
    }

    public void setReplyManID(String replyManID) {
        this.replyManID = replyManID;
    }

    public String getReplyManName() {
        return replyManName;
    }

    public void setReplyManName(String replyManName) {
        this.replyManName = replyManName;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean getIsCheckBoxVisible() {
        return isCheckBoxVisible;
    }

    public void setIsCheckBoxVisible(boolean checkBoxVisible) {
        isCheckBoxVisible = checkBoxVisible;
    }

    @Override
    public String toString() {
        return "ClsReply{" +
                "rowNum='" + rowNum + '\'' +
                ", topicID='" + topicID + '\'' +
                ", replyID='" + replyID + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", replyBoutiqueNum='" + replyBoutiqueNum + '\'' +
                ", replyTopicNum='" + replyTopicNum + '\'' +
                ", replyManID='" + replyManID + '\'' +
                ", replyManName='" + replyManName + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.rowNum);
        dest.writeString(this.topicID);
        dest.writeString(this.replyID);
        dest.writeString(this.replyContent);
        dest.writeString(this.replyTime);
        dest.writeString(this.replyBoutiqueNum);
        dest.writeString(this.replyTopicNum);
        dest.writeString(this.replyManID);
        dest.writeString(this.replyManName);
    }

    protected ClsReply(Parcel in) {
        this.rowNum = in.readString();
        this.topicID = in.readString();
        this.replyID = in.readString();
        this.replyContent = in.readString();
        this.replyTime = in.readString();
        this.replyBoutiqueNum = in.readString();
        this.replyTopicNum = in.readString();
        this.replyManID = in.readString();
        this.replyManName = in.readString();
    }

    public static final Parcelable.Creator<ClsReply> CREATOR = new Parcelable.Creator<ClsReply>() {
        @Override
        public ClsReply createFromParcel(Parcel source) {
            return new ClsReply(source);
        }

        @Override
        public ClsReply[] newArray(int size) {
            return new ClsReply[size];
        }
    };
}