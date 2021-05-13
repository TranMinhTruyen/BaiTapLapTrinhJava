package com.example.common.request;

import com.example.common.response.CaLamViecResponse;

public class CaLamViecRequest extends CaLamViecResponse {
    public CaLamViecRequest() {
    }

    public CaLamViecRequest(int id, String caLam) {
        super(id, caLam);
    }
}
