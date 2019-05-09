package com.oridway.www.uiframe.bean;

public class ClsReply  {

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
}