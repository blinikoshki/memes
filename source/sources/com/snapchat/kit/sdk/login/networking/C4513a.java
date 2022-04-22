package com.snapchat.kit.sdk.login.networking;

import com.snapchat.kit.sdk.login.dagger.scope.LoginScope;
import com.snapchat.kit.sdk.login.models.MePayload;
import com.snapchat.kit.sdk.login.models.UserDataResponse;
import com.snapchat.kit.sdk.login.p046a.C4507a;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@LoginScope
/* renamed from: com.snapchat.kit.sdk.login.networking.a */
public final class C4513a {

    /* renamed from: a */
    private final LoginClient f1390a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C4507a f1391b;

    @Inject
    C4513a(LoginClient loginClient, C4507a aVar) {
        this.f1390a = loginClient;
        this.f1391b = aVar;
    }

    /* renamed from: a */
    public final void mo61834a(String str, Map<String, Object> map, final FetchUserDataCallback fetchUserDataCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f1391b.mo61811a("fetchMeData");
        this.f1390a.fetchMeData(new MePayload(str, map)).enqueue(new Callback<UserDataResponse>() {
            public final void onResponse(Call<UserDataResponse> call, Response<UserDataResponse> response) {
                if (response.isSuccessful()) {
                    C4513a.this.f1391b.mo61812a("fetchUserDataLatency", System.currentTimeMillis() - currentTimeMillis);
                    fetchUserDataCallback.onSuccess(response.body());
                    return;
                }
                m988a(false, response.code());
            }

            public final void onFailure(Call<UserDataResponse> call, Throwable th) {
                m988a(th instanceof IOException, -1);
            }

            /* renamed from: a */
            private void m988a(boolean z, int i) {
                C4513a.this.f1391b.mo61811a("fetchUserDataFailure");
                fetchUserDataCallback.onFailure(z, i);
            }
        });
    }
}
