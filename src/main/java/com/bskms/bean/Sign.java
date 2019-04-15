package com.bskms.bean;

import java.util.Date;

public class Sign {
    private Integer id;

    private String kqrId;

    private Integer state;

    private String describe;

    private Integer type;

    private Integer kqrType;

    private Date signIn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKqrId() {
        return kqrId;
    }

    public void setKqrId(String kqrId) {
        this.kqrId = kqrId == null ? null : kqrId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getKqrType() {
        return kqrType;
    }

    public void setKqrType(Integer kqrType) {
        this.kqrType = kqrType;
    }

    public Date getSignIn() {
        return signIn;
    }

    public void setSignIn(Date signIn) {
        this.signIn = signIn;
    }
}