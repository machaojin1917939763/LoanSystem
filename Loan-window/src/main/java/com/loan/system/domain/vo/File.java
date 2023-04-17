package com.loan.system.domain.vo;

public class File {
    //{"name":"/profile/upload/2023/04/17/微信图片_20230411092207_20230417145416A003.jpg",
    // "url":"/profile/upload/2023/04/17/微信图片_20230411092207_20230417145416A003.jpg",
    // "uid":1681714457025,"status":"success"
    private String name;
    private String url;
    private String uid;
    private String status;

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", uid='" + uid + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
