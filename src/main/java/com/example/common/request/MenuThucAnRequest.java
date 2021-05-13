package com.example.common.request;

import com.example.common.response.MenuThucAnResponse;

public class MenuThucAnRequest extends MenuThucAnResponse {
    public MenuThucAnRequest(Long idMenu, Integer idThucAn) {
        super(idMenu, idThucAn);
    }

    public MenuThucAnRequest() {
    }
}
