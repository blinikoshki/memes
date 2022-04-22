package com.memes.eventtracker.trackers.appsflyer;

import android.app.Application;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.tracking.TrackableEvent;
import com.memes.eventtracker.tracking.TrackingPageInfo;
import com.memes.eventtracker.util.Util;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/appsflyer/AppsFlyerEventTracker;", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "conversionListener", "Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerConversionListener;", "getConversionListener", "()Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerConversionListener;", "conversionListener$delegate", "Lkotlin/Lazy;", "isEnabled", "", "isInitialized", "trackingRequestListener", "Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerTrackingRequestListener;", "getTrackingRequestListener", "()Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerTrackingRequestListener;", "trackingRequestListener$delegate", "disable", "", "enable", "init", "send", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "eventId", "", "eventData", "", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AppsFlyerEventTracker.kt */
public final class AppsFlyerEventTracker implements EventTracker {
    private static final String ACCESS_KEY = "RVezf9PanSMoYcySnoM5XF";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AppsFlyerEventTracker";
    private final Application application;
    private final Lazy conversionListener$delegate;
    private boolean isEnabled;
    private boolean isInitialized;
    private final Lazy trackingRequestListener$delegate;

    private final DefaultAppsFlyerConversionListener getConversionListener() {
        return (DefaultAppsFlyerConversionListener) this.conversionListener$delegate.getValue();
    }

    private final DefaultAppsFlyerTrackingRequestListener getTrackingRequestListener() {
        return (DefaultAppsFlyerTrackingRequestListener) this.trackingRequestListener$delegate.getValue();
    }

    public void setPageInfo(TrackingPageInfo trackingPageInfo) {
        Intrinsics.checkNotNullParameter(trackingPageInfo, "pageInfo");
    }

    private AppsFlyerEventTracker(Application application2) {
        this.application = application2;
        this.conversionListener$delegate = LazyKt.lazy(AppsFlyerEventTracker$conversionListener$2.INSTANCE);
        this.trackingRequestListener$delegate = LazyKt.lazy(AppsFlyerEventTracker$trackingRequestListener$2.INSTANCE);
    }

    public /* synthetic */ AppsFlyerEventTracker(Application application2, DefaultConstructorMarker defaultConstructorMarker) {
        this(application2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/appsflyer/AppsFlyerEventTracker$Companion;", "", "()V", "ACCESS_KEY", "", "TAG", "getInstance", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AppsFlyerEventTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTracker getInstance(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            return new AppsFlyerEventTracker(application, (DefaultConstructorMarker) null);
        }
    }

    public void init() {
        AppsFlyerLib.getInstance().init(ACCESS_KEY, getConversionListener(), this.application);
        AppsFlyerLib.getInstance().start(this.application);
        AppsFlyerLib.getInstance().setDebugLog(false);
        this.isInitialized = true;
    }

    public void enable() {
        this.isEnabled = true;
    }

    public void disable() {
        this.isEnabled = false;
    }

    public void send(TrackableEvent trackableEvent) {
        Intrinsics.checkNotNullParameter(trackableEvent, "event");
        if (!this.isInitialized || !this.isEnabled) {
            return;
        }
        if (StringsKt.contains$default((CharSequence) trackableEvent.getEventId(), (CharSequence) Util.EVENT_ID_SEPARATOR, false, 2, (Object) null)) {
            for (String str : StringsKt.split$default((CharSequence) trackableEvent.getEventId(), new String[]{Util.EVENT_ID_SEPARATOR}, false, 0, 6, (Object) null)) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                send(StringsKt.trim((CharSequence) str).toString(), trackableEvent.getData());
            }
            return;
        }
        send(trackableEvent.getEventId(), trackableEvent.getData());
    }

    static /* synthetic */ void send$default(AppsFlyerEventTracker appsFlyerEventTracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        appsFlyerEventTracker.send(str, map);
    }

    private final void send(String str, Map<String, String> map) {
        Log.d(TAG, "Logging AppsFlyer Event.. [" + str + ']');
        AppsFlyerLib.getInstance().logEvent(this.application, str, map, getTrackingRequestListener());
    }
}
