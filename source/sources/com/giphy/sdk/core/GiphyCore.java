package com.giphy.sdk.core;

import android.content.Context;
import com.giphy.sdk.analytics.GiphyPingbacks;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.engine.NetworkSession;
import com.giphy.sdk.tracking.OMTracking;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006$"}, mo26107d2 = {"Lcom/giphy/sdk/core/GiphyCore;", "", "()V", "additionalHeaders", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAdditionalHeaders", "()Ljava/util/HashMap;", "setAdditionalHeaders", "(Ljava/util/HashMap;)V", "apiClient", "Lcom/giphy/sdk/core/network/api/GPHApiClient;", "getApiClient", "()Lcom/giphy/sdk/core/network/api/GPHApiClient;", "setApiClient", "(Lcom/giphy/sdk/core/network/api/GPHApiClient;)V", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "trackOpenMeasurement", "", "getTrackOpenMeasurement", "()Z", "setTrackOpenMeasurement", "(Z)V", "versionName", "getVersionName", "setVersionName", "configure", "", "context", "Landroid/content/Context;", "apiKey", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GiphyCore.kt */
public final class GiphyCore {
    public static final GiphyCore INSTANCE = new GiphyCore();
    private static HashMap<String, String> additionalHeaders = new HashMap<>();
    public static GPHApiClient apiClient;
    private static String name = "CoreSDK";
    private static boolean trackOpenMeasurement;
    private static String versionName = BuildConfig.VERSION_NAME;

    private GiphyCore() {
    }

    public final GPHApiClient getApiClient() {
        GPHApiClient gPHApiClient = apiClient;
        if (gPHApiClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiClient");
        }
        return gPHApiClient;
    }

    public final void setApiClient(GPHApiClient gPHApiClient) {
        Intrinsics.checkParameterIsNotNull(gPHApiClient, "<set-?>");
        apiClient = gPHApiClient;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        name = str;
    }

    public final String getVersionName() {
        return versionName;
    }

    public final void setVersionName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        versionName = str;
    }

    public final HashMap<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public final void setAdditionalHeaders(HashMap<String, String> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        additionalHeaders = hashMap;
    }

    public final boolean getTrackOpenMeasurement() {
        return trackOpenMeasurement;
    }

    public final void setTrackOpenMeasurement(boolean z) {
        trackOpenMeasurement = z;
    }

    public static /* synthetic */ void configure$default(GiphyCore giphyCore, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        giphyCore.configure(context, str, z);
    }

    public final void configure(Context context, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        apiClient = new GPHApiClient(str, (NetworkSession) null, 2, (DefaultConstructorMarker) null);
        trackOpenMeasurement = z;
        additionalHeaders = MapsKt.hashMapOf(TuplesKt.m181to("X-GIPHY-SDK-VERSION", versionName), TuplesKt.m181to("X-GIPHY-SDK-NAME", name), TuplesKt.m181to("X-GIPHY-SDK-PLATFORM", "Android"));
        GiphyPingbacks.INSTANCE.setAdditionalHeaders(additionalHeaders);
        GiphyPingbacks giphyPingbacks = GiphyPingbacks.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        giphyPingbacks.configure(applicationContext, str);
        if (trackOpenMeasurement) {
            OMTracking oMTracking = OMTracking.INSTANCE;
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "context.applicationContext");
            oMTracking.configure(applicationContext2);
        }
    }
}
