package com.windranger.Greek.AuthTest;

public interface ApiAuthencator {
    void auth(String baseUrl);

    void auth(ApiRequest apiRequest);
}
