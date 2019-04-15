package com.bskms.bean;

public class ClaTea {
    private Integer id;

    private Integer classId;

    private String tecId;

    private String subject;

    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getTecId() {
        return tecId;
    }

    public void setTecId(String tecId) {
        this.tecId = tecId == null ? null : tecId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}