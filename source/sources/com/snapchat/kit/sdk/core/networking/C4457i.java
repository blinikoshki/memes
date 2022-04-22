package com.snapchat.kit.sdk.core.networking;

import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import editor.editor.equipment.core.CoreConfig;
import java.io.IOException;
import java.util.UUID;
import javax.inject.Named;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.networking.i */
abstract class C4457i implements Interceptor {

    /* renamed from: a */
    private final String f1267a;

    C4457i(@Named("client_id") String str) {
        this.f1267a = str;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(mo61726a(chain).build());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request.Builder mo61726a(Interceptor.Chain chain) {
        return chain.request().newBuilder().header("User-Agent", C4451d.f1257a).header("X-Snap-SDK-OAuth-Client-Id", this.f1267a).header("X-Cloud-Trace-Context", String.format("%s/0;o=1", new Object[]{m916a()})).header("X-SnapKit-Core-Version", "1.6.8");
    }

    /* renamed from: a */
    private synchronized String m916a() {
        return UUID.randomUUID().toString().replaceAll(CoreConfig.ENTITY_TOKEN_PREFIX, "");
    }
}
