package com.snapchat.kit.sdk.core.networking;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.snapchat.kit.sdk.C4475d;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.models.TokenErrorResponse;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.snapchat.kit.sdk.core.networking.e */
public class C4452e extends C4457i {

    /* renamed from: a */
    private final C4475d f1258a;

    /* renamed from: b */
    private final C4396a f1259b;

    @Inject
    C4452e(C4475d dVar, C4396a aVar, @Named("client_id") String str) {
        super(str);
        this.f1258a = dVar;
        this.f1259b = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request.Builder mo61726a(Interceptor.Chain chain) {
        this.f1258a.mo61789b();
        Request.Builder a = super.mo61726a(chain);
        a.header("authorization", "Bearer " + this.f1258a.mo61785a());
        return a;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response intercept = super.intercept(chain);
        if (!(intercept == null || intercept.body() == null || intercept.code() != 401)) {
            TokenErrorResponse tokenErrorResponse = null;
            try {
                tokenErrorResponse = (TokenErrorResponse) new Gson().fromJson(intercept.body().charStream(), TokenErrorResponse.class);
            } catch (JsonParseException unused) {
            }
            boolean z = false;
            if (tokenErrorResponse != null && !TextUtils.isEmpty(tokenErrorResponse.getError()) && TextUtils.equals(tokenErrorResponse.getError().toLowerCase(), "invalid_token")) {
                int i = C44531.f1260a[this.f1258a.mo61790c() - 1];
                if (i == 2 || i == 3) {
                    this.f1258a.clearToken();
                    this.f1259b.mo61315a();
                }
            } else {
                if (tokenErrorResponse != null && !TextUtils.isEmpty(tokenErrorResponse.getError()) && TextUtils.equals(tokenErrorResponse.getError().toLowerCase(), "force_logout")) {
                    z = true;
                }
                if (z) {
                    this.f1258a.clearToken();
                    this.f1259b.mo61315a();
                }
            }
        }
        return intercept;
    }

    /* renamed from: com.snapchat.kit.sdk.core.networking.e$1 */
    static /* synthetic */ class C44531 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1260a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0027 */
        static {
            /*
                int[] r0 = com.snapchat.kit.sdk.C4475d.C4485c.m948a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1260a = r0
                r1 = 1
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1335e     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f1260a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1331a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = f1260a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1332b     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1260a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1333c     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = f1260a     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1334d     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = r2 - r1
                r1 = 5
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.core.networking.C4452e.C44531.<clinit>():void");
        }
    }
}
