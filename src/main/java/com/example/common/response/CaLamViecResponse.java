package com.example.common.response;

public class CaLamViecResponse {
    private int id;
    private String caLam;

    public CaLamViecResponse() {
    }

    public CaLamViecResponse(int id, String caLam) {
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
