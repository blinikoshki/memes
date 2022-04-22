package com.giphy.sdk.analytics.tracking;

import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.giphy.sdk.analytics.GiphyPingbacks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/tracking/AdsManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "cacheBusterForTag", "callTrackingUrl", "", "tag", "trackSeenMedia", "trackingTags", "", "urlRequestFromTag", "userOptOutForTag", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: AdsManager.kt */
public final class AdsManager {
    public static final AdsManager INSTANCE = new AdsManager();
    private static final String TAG = AdsManager.class.getSimpleName();

    private AdsManager() {
    }

    public final void trackSeenMedia(List<String> list) {
        if (list != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AdsManager$trackSeenMedia$1$1(list, (Continuation) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final String urlRequestFromTag(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "%%ADVERTISING_IDENTIFIER_PLAIN%%", GiphyPingbacks.INSTANCE.getAdId(), false, 4, (Object) null), "%%CACHEBUSTER%%", cacheBusterForTag(), false, 4, (Object) null), "%%UOO%%", userOptOutForTag(), false, 4, (Object) null);
    }

    private final String cacheBusterForTag() {
        return String.valueOf(System.currentTimeMillis());
    }

    private final String userOptOutForTag() {
        CharSequence adId = GiphyPingbacks.INSTANCE.getAdId();
        return adId == null || adId.length() == 0 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    /* access modifiers changed from: private */
    public final void callTrackingUrl(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 204) {
                    String str2 = TAG;
                    Log.e(str2, "failed to track tag code=" + httpURLConnection.getResponseCode() + " message=" + httpURLConnection.getResponseMessage());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (MalformedURLException e) {
            Log.e(TAG, e.getMessage());
        } catch (IOException e2) {
            Log.e(TAG, e2.getMessage());
        }
    }
}
