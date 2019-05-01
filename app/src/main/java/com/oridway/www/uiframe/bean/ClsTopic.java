package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsTopic implements Parcelable {

    private String rowNum;
    private String sectionID;
    private String sectionName;
    private String sectionManager;
    private String topicID;
    private String title;
    private String topicDesc;
    private String createDate;
    private String authorID;
    private String author;
    private String viewNum;
    private String replyNum;
    private String isBoutique;
    private String sequence;
    private String isTop;
    private String isRecommend;
    private String replyID;
    private String replyContent;
    private String replyTime;
    private String replyAuthorID;
    private String replyAuthorName;
    private String dCount;
    private boolean isChecked;
    private boolean isCheckBoxVisible;

    public ClsTopic() {
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getSectionID() {
        return sectionID;
    }

    public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(String sectionManager) {
        this.sectionManager = sectionManager;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getViewNum() {
        return viewNum;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
    }

    public String getIsBoutique() {
        return isBoutique;
    }

    public void setIsBoutique(String isBoutique) {
        this.isBoutique = isBoutique;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
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

    public String getReplyAuthorID() {
        return replyAuthorID;
    }

    public void setReplyAuthorID(String replyAuthorID) {
        this.replyAuthorID = replyAuthorID;
    }

    public String getReplyAuthorName() {
        return replyAuthorName;
    }

    public void setReplyAuthorName(String replyAuthorName) {
        this.replyAuthorName = replyAuthorName;
    }

    public String getdCount() {
        return dCount;
    }

    public void setdCount(String dCount) {
        this.dCount = dCount;
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
        return "ClsSection{" +
                "rowNum='" + rowNum + '\'' +
                ", sectionID='" + sectionID + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", sectionManager='" + sectionManager + '\'' +
                ", topicID='" + topicID + '\'' +
                ", title='" + title + '\'' +
                ", topicDesc='" + topicDesc + '\'' +
                ", createDate='" + createDate + '\'' +
                ", authorID='" + authorID + '\'' +
                ", author='" + author + '\'' +
                ", viewNum='" + viewNum + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", isBoutique='" + isBoutique + '\'' +
                ", sequence='" + sequence + '\'' +
                ", isTop='" + isTop + '\'' +
                ", isRecommend='" + isRecommend + '\'' +
                ", replyID='" + replyID + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", replyAuthorID='" + replyAuthorID + '\'' +
                ", replyAuthorName='" + replyAuthorName + '\'' +
                ", dCount='" + dCount + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.rowNum);
        dest.writeString(this.sectionID);
        dest.writeString(this.sectionName);
        dest.writeString(this.sectionManager);
        dest.writeString(this.topicID);
        dest.writeString(this.title);
        dest.writeString(this.topicDesc);
        dest.writeString(this.createDate);
        dest.writeString(this.authorID);
        dest.writeString(this.author);
        dest.writeString(this.viewNum);
        dest.writeString(this.replyNum);
        dest.writeString(this.isBoutique);
        dest.writeString(this.sequence);
        dest.writeString(this.isTop);
        dest.writeString(this.isRecommend);
        dest.writeString(this.replyID);
        dest.writeString(this.replyContent);
        dest.writeString(this.replyTime);
        dest.writeString(this.replyAuthorID);
        dest.writeString(this.replyAuthorName);
        dest.writeString(this.dCount);
    }

    protected ClsTopic(Parcel in) {
        this.rowNum = in.readString();
        this.sectionID = in.readString();
        this.sectionName = in.readString();
        this.sectionManager = in.readString();
        this.topicID = in.readString();
        this.title = in.readString();
        this.topicDesc = in.readString();
        this.createDate = in.readString();
        this.authorID = in.readString();
        this.author = in.readString();
        this.viewNum = in.readString();
        this.replyNum = in.readString();
        this.isBoutique = in.readString();
        this.sequence = in.readString();
        this.isTop = in.readString();
        this.isRecommend = in.readString();
        this.replyID = in.readString();
        this.replyContent = in.readString();
        this.replyTime = in.readString();
        this.replyAuthorID = in.readString();
        this.replyAuthorName = in.readString();
        this.dCount = in.readString();
    }

    public static final Parcelable.Creator<ClsTopic> CREATOR = new Parcelable.Creator<ClsTopic>() {
        @Override
        public ClsTopic createFromParcel(Parcel source) {
            return new ClsTopic(source);
        }

        @Override
        public ClsTopic[] newArray(int size) {
            return new ClsTopic[size];
        }
    };
}