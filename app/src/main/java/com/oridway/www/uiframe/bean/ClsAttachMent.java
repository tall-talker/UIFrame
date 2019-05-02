package com.oridway.www.uiframe.bean;

import android.net.Uri;

import java.io.File;

/**
 * 上传附件的实体类
 *
 * @author cgl
 * @version 1.1
 * @since 2019/3/11
 */

public class ClsAttachMent {

    private String filename;
    private String uid;
    private String title;
    private String size;
    private String type;
    private String fileLog;
    private String uri;

    public ClsAttachMent() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileLog() {
        return fileLog;
    }

    public void setFileLog(String fileLog) {
        this.fileLog = fileLog;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ClsAttachMent{" +
                "filename='" + filename + '\'' +
                ", uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", fileLog='" + fileLog + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
