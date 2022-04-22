package com.giphy.sdk.tracking;

import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.iab.omid.library.giphy.adsession.AdSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, mo26107d2 = {"Lcom/giphy/sdk/tracking/GPHAdSession;", "", "omSession", "Lcom/iab/omid/library/giphy/adsession/AdSession;", "gphSessionId", "", "(Lcom/iab/omid/library/giphy/adsession/AdSession;Ljava/lang/String;)V", "getGphSessionId", "()Ljava/lang/String;", "isStarted", "", "isTracked", "getOmSession", "()Lcom/iab/omid/library/giphy/adsession/AdSession;", "finish", "", "registerView", "view", "Landroid/view/View;", "start", "trackImpression", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GPHAdSession.kt */
public final class GPHAdSession {
    private final String gphSessionId;
    private boolean isStarted;
    private boolean isTracked;
    private final AdSession omSession;

    public GPHAdSession(AdSession adSession, String str) {
        Intrinsics.checkParameterIsNotNull(adSession, "omSession");
        Intrinsics.checkParameterIsNotNull(str, "gphSessionId");
        this.omSession = adSession;
        this.gphSessionId = str;
    }

    public final String getGphSessionId() {
        return this.gphSessionId;
    }

    public final AdSession getOmSession() {
        return this.omSession;
    }

    public final void trackImpression() {
        if (!this.isTracked) {
            OMTracking.INSTANCE.trackImpression(this.omSession);
            this.isTracked = true;
        }
    }

    public final synchronized void start() {
        if (!this.isStarted) {
            String tag = OMTracking.INSTANCE.getTAG();
            Log.d(tag, "[OM] session started " + this.gphSessionId);
            this.omSession.start();
            this.isStarted = true;
        }
    }

    public final void finish() {
        String tag = OMTracking.INSTANCE.getTAG();
        Log.d(tag, "[OM] session finished " + this.gphSessionId);
        this.omSession.finish();
    }

    public final void registerView(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        this.omSession.registerAdView(view);
    }
}
