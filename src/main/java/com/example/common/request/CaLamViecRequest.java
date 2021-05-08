package com.example.common.request;

public class CaLamViecRequest {
    private int id;
    private String caLam;

    public CaLamViecRequest() {
    }

    public CaLamViecRequest(int id, String caLam) {
        this.id = id;
        this.caLam = caLam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }
}
