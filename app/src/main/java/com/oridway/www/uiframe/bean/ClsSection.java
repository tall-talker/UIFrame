package com.oridway.www.uiframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClsSection implements Parcelable {

    private String isClosed;
    private String closeDate;
    private String sectionID;
    private String sectionName;
    private String sectionType;
    private String sectionDesc;
    private String sectionLogo;
    private String sectionManagerID;
    private String sectionManager;
    private String createDate;
    private String topics;
    private String replys;
    private String topicID;
    private String replyID;
    private String replyContent;
    private String replyTime;
    private String authorID;
    private String authorName;
    private String dCount;
    private boolean isChecked;
    private boolean isCheckBoxVisible;

    public ClsSection() {
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
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

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public String getSectionDesc() {
        return sectionDesc;
    }

    public void setSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
    }

    public String getSectionLogo() {
        return sectionLogo;
    }

    public void setSectionLogo(String sectionLogo) {
        this.sectionLogo = sectionLogo;
    }

    public String getSectionManagerID() {
        return sectionManagerID;
    }

    public void setSectionManagerID(String sectionManagerID) {
        this.sectionManagerID = sectionManagerID;
    }

    public String getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(String sectionManager) {
        this.sectionManager = sectionManager;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getReplys() {
        return replys;
    }

    public void setReplys(String replys) {
        this.replys = replys;
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

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    protected ClsSection(Parcel in) {
        isClosed = in.readString();
        closeDate = in.readString();
        sectionID = in.readString();
        sectionName = in.readString();
        sectionType = in.readString();
        sectionDesc = in.readString();
        sectionLogo = in.readString();
        sectionManagerID = in.readString();
        sectionManager = in.readString();
        createDate = in.readString();
        topics = in.readString();
        replys = in.readString();
        topicID = in.readString();
        replyID = in.readString();
        replyContent = in.readString();
        replyTime = in.readString();
        authorID = in.readString();
        authorName = in.readString();
        dCount = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isClosed);
        dest.writeString(closeDate);
        dest.writeString(sectionID);
        dest.writeString(sectionName);
        dest.writeString(sectionType);
        dest.writeString(sectionDesc);
        dest.writeString(sectionLogo);
        dest.writeString(sectionManagerID);
        dest.writeString(sectionManager);
        dest.writeString(createDate);
        dest.writeString(topics);
        dest.writeString(replys);
        dest.writeString(topicID);
        dest.writeString(replyID);
        dest.writeString(replyContent);
        dest.writeString(replyTime);
        dest.writeString(authorID);
        dest.writeString(authorName);
        dest.writeString(dCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClsSection> CREATOR = new Creator<ClsSection>() {
        @Override
        public ClsSection createFromParcel(Parcel in) {
            return new ClsSection(in);
        }

        @Override
        public ClsSection[] newArray(int size) {
            return new ClsSection[size];
        }
    };
}
