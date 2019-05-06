package com.oridway.www.uiframe.bean;

public class ClsAttachMent {

    private String filename;
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
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", fileLog='" + fileLog + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
