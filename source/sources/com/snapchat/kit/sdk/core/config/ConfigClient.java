package com.snapchat.kit.sdk.core.config;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ConfigClient {
    @POST("/v1/config")
    Call<C4389d<C4387b>> fetchConfig(@Body C4386a aVar);
}
