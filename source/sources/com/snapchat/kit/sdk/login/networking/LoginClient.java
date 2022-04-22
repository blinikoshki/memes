package com.snapchat.kit.sdk.login.networking;

import com.snapchat.kit.sdk.login.models.ExternalUsersData;
import com.snapchat.kit.sdk.login.models.GraphQLResponse;
import com.snapchat.kit.sdk.login.models.MePayload;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginClient {
    @POST("/v1/me")
    Call<GraphQLResponse<ExternalUsersData>> fetchExternalUsersData(@Body MePayload mePayload);

    @POST("/v1/me")
    Call<UserDataResponse> fetchMeData(@Body MePayload mePayload);
}
