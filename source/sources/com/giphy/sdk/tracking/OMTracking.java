package com.giphy.sdk.tracking;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.giphy.sdk.core.models.BottleData;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.OMData;
import com.giphy.sdk.core.models.TrackingData;
import com.giphy.sdk.core.network.api.Constants;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.engine.DefaultNetworkSession;
import com.iab.omid.library.giphy.Omid;
import com.iab.omid.library.giphy.adsession.AdEvents;
import com.iab.omid.library.giphy.adsession.AdSession;
import com.iab.omid.library.giphy.adsession.AdSessionConfiguration;
import com.iab.omid.library.giphy.adsession.AdSessionContext;
import com.iab.omid.library.giphy.adsession.Owner;
import com.iab.omid.library.giphy.adsession.Partner;
import com.iab.omid.library.giphy.adsession.VerificationScriptResource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, mo26107d2 = {"Lcom/giphy/sdk/tracking/OMTracking;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "networkSession", "Lcom/giphy/sdk/core/network/engine/DefaultNetworkSession;", "partner", "Lcom/iab/omid/library/giphy/adsession/Partner;", "sessions", "Ljava/util/HashMap;", "Lcom/giphy/sdk/tracking/GPHAdSession;", "Lkotlin/collections/HashMap;", "verificationScript", "getVerificationScript", "setVerificationScript", "(Ljava/lang/String;)V", "configure", "", "context", "Landroid/content/Context;", "getSession", "media", "Lcom/giphy/sdk/core/models/Media;", "gphSessionId", "loadLibrary", "prepareAdSession", "reset", "trackImpression", "session", "Lcom/iab/omid/library/giphy/adsession/AdSession;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: OMTracking.kt */
public final class OMTracking {
    public static final OMTracking INSTANCE = new OMTracking();
    private static final String TAG = OMTracking.class.getSimpleName();
    private static DefaultNetworkSession networkSession = new DefaultNetworkSession();
    private static Partner partner;
    private static final HashMap<String, GPHAdSession> sessions = new HashMap<>();
    private static String verificationScript;

    private OMTracking() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getVerificationScript() {
        return verificationScript;
    }

    public final void setVerificationScript(String str) {
        verificationScript = str;
    }

    public final void configure(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            String str = TAG;
            Log.d(str, "configure");
            if (!Omid.activateWithOmidApiVersion(Omid.getVersion(), context.getApplicationContext())) {
                Log.e(str, "failed to init OM SDK");
            } else {
                loadLibrary();
            }
        } catch (Exception e) {
            Log.e(TAG, "The OMID SDK crashed");
            e.printStackTrace();
        }
    }

    private final void loadLibrary() {
        Log.d(TAG, "loadLibrary");
        DefaultNetworkSession defaultNetworkSession = networkSession;
        Uri parse = Uri.parse(Constants.INSTANCE.getOM_API_URL());
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(OM_API_URL)");
        defaultNetworkSession.queryStringConnection(parse, (String) null, GPHApiClient.HTTPMethod.GET, String.class, (Map<String, String>) null, (Map<String, String>) null).executeAsyncTask(new OMTracking$loadLibrary$1());
        try {
            partner = Partner.createPartner(Constants.INSTANCE.getOM_PARTNER_NAME(), Constants.INSTANCE.getOM_VERSION());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.giphy.sdk.tracking.GPHAdSession getSession(com.giphy.sdk.core.models.Media r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "media"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = r4.getTid()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r1.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "[OM] get session "
            r1.append(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = com.giphy.sdk.tracking.MediaExtensionKt.getGphSessionId(r4)     // Catch:{ all -> 0x0048 }
            r1.append(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0048 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0048 }
            java.util.HashMap<java.lang.String, com.giphy.sdk.tracking.GPHAdSession> r0 = sessions     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = com.giphy.sdk.tracking.MediaExtensionKt.getGphSessionId(r4)     // Catch:{ all -> 0x0048 }
            boolean r1 = r0.containsKey(r1)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x003d
            java.lang.String r4 = com.giphy.sdk.tracking.MediaExtensionKt.getGphSessionId(r4)     // Catch:{ all -> 0x0048 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0048 }
            com.giphy.sdk.tracking.GPHAdSession r4 = (com.giphy.sdk.tracking.GPHAdSession) r4     // Catch:{ all -> 0x0048 }
            goto L_0x0043
        L_0x003d:
            com.giphy.sdk.tracking.OMTracking r0 = INSTANCE     // Catch:{ all -> 0x0048 }
            com.giphy.sdk.tracking.GPHAdSession r4 = r0.prepareAdSession(r4)     // Catch:{ all -> 0x0048 }
        L_0x0043:
            monitor-exit(r3)
            return r4
        L_0x0045:
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0048:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.tracking.OMTracking.getSession(com.giphy.sdk.core.models.Media):com.giphy.sdk.tracking.GPHAdSession");
    }

    public final GPHAdSession getSession(String str) {
        Intrinsics.checkParameterIsNotNull(str, "gphSessionId");
        return sessions.get(str);
    }

    public final synchronized void trackImpression(AdSession adSession) {
        Intrinsics.checkParameterIsNotNull(adSession, "session");
        AdEvents createAdEvents = AdEvents.createAdEvents(adSession);
        try {
            String str = TAG;
            Log.d(str, "[OM] track impression " + adSession.getAdSessionId());
            if (createAdEvents != null) {
                createAdEvents.impressionOccurred();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public final synchronized GPHAdSession prepareAdSession(Media media) {
        String str;
        TrackingData tdata;
        TrackingData tdata2;
        List<OMData> om;
        Intrinsics.checkParameterIsNotNull(media, "media");
        Log.d(TAG, "[OM] prepareAdSession " + MediaExtensionKt.getGphSessionId(media));
        ArrayList arrayList = new ArrayList();
        BottleData bottleData = media.getBottleData();
        if (!(bottleData == null || (tdata2 = bottleData.getTdata()) == null || (om = tdata2.getOm()) == null)) {
            for (OMData oMData : om) {
                if (oMData.isValid()) {
                    try {
                        arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(oMData.getVendorKey(), new URL(oMData.getJavascriptResourceUrl()), oMData.getVerificationParameters()));
                    } catch (MalformedURLException unused) {
                        return null;
                    }
                }
            }
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("bottleData = ");
        BottleData bottleData2 = media.getBottleData();
        sb.append(bottleData2 != null ? bottleData2.getTid() : null);
        Log.d(str2, sb.toString());
        if (!(partner == null || verificationScript == null)) {
            BottleData bottleData3 = media.getBottleData();
            if (((bottleData3 == null || (tdata = bottleData3.getTdata()) == null) ? null : tdata.getOm()) != null) {
                AdSessionContext adSessionContext = null;
                BottleData bottleData4 = media.getBottleData();
                if (bottleData4 == null || (str = bottleData4.getTid()) == null) {
                    str = "";
                }
                try {
                    adSessionContext = AdSessionContext.createNativeAdSessionContext(partner, verificationScript, arrayList, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (adSessionContext == null) {
                    return null;
                }
                AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(Owner.NATIVE, Owner.NATIVE, false), adSessionContext);
                Intrinsics.checkExpressionValueIsNotNull(createAdSession, "session");
                GPHAdSession gPHAdSession = new GPHAdSession(createAdSession, MediaExtensionKt.getGphSessionId(media));
                sessions.put(gPHAdSession.getGphSessionId(), gPHAdSession);
                Log.d(TAG, "[OM] session created gphId " + gPHAdSession.getGphSessionId() + " - omId " + createAdSession.getAdSessionId());
                return gPHAdSession;
            }
        }
        Log.e(str2, "failed to create OM session. Partner or verification script is null");
        return null;
    }

    public final void reset() {
        for (Map.Entry entry : sessions.entrySet()) {
            String str = TAG;
            Log.d(str, "[OM] session finished " + ((GPHAdSession) entry.getValue()).getGphSessionId());
            ((GPHAdSession) entry.getValue()).finish();
        }
        sessions.clear();
    }
}
