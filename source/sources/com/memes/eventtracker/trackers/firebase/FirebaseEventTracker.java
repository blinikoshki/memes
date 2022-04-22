package com.memes.eventtracker.trackers.firebase;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.tracking.EventReservedParamId;
import com.memes.eventtracker.tracking.TrackableEvent;
import com.memes.eventtracker.tracking.TrackingPageInfo;
import com.memes.eventtracker.util.Util;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/firebase/FirebaseEventTracker;", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "defaultLogger", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getDefaultLogger", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "defaultLogger$delegate", "Lkotlin/Lazy;", "isEnabled", "", "isInitialized", "disable", "", "enable", "init", "send", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "eventId", "", "bundle", "Landroid/os/Bundle;", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseEventTracker.kt */
public final class FirebaseEventTracker implements EventTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FirebaseEventTracker";
    private final Lazy defaultLogger$delegate;
    private boolean isEnabled;
    private boolean isInitialized;

    private final FirebaseAnalytics getDefaultLogger() {
        return (FirebaseAnalytics) this.defaultLogger$delegate.getValue();
    }

    private FirebaseEventTracker(Application application) {
        this.defaultLogger$delegate = LazyKt.lazy(new FirebaseEventTracker$defaultLogger$2(application));
    }

    public /* synthetic */ FirebaseEventTracker(Application application, DefaultConstructorMarker defaultConstructorMarker) {
        this(application);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/firebase/FirebaseEventTracker$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FirebaseEventTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTracker getInstance(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            return new FirebaseEventTracker(application, (DefaultConstructorMarker) null);
        }
    }

    public void init() {
        this.isInitialized = true;
    }

    public void setPageInfo(TrackingPageInfo trackingPageInfo) {
        Intrinsics.checkNotNullParameter(trackingPageInfo, "pageInfo");
        Activity activity = trackingPageInfo.getActivity();
        if (activity != null) {
            int length = trackingPageInfo.getTitle().length();
            getDefaultLogger().setCurrentScreen(activity, (1 <= length && 36 >= length) ? trackingPageInfo.getTitle() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, (String) null);
        }
    }

    public void enable() {
        getDefaultLogger().setAnalyticsCollectionEnabled(true);
        this.isEnabled = true;
    }

    public void disable() {
        getDefaultLogger().setAnalyticsCollectionEnabled(false);
        this.isEnabled = false;
    }

    public void send(TrackableEvent trackableEvent) {
        Intrinsics.checkNotNullParameter(trackableEvent, "event");
        if (this.isInitialized && this.isEnabled) {
            Bundle bundle = new Bundle();
            Map<String, String> data = trackableEvent.getData();
            if (data != null && (!data.isEmpty())) {
                for (Map.Entry next : data.entrySet()) {
                    if (Intrinsics.areEqual((Object) EventReservedParamId.PARAM_USER_ID, (Object) (String) next.getKey())) {
                        getDefaultLogger().setUserId((String) next.getValue());
                    }
                    bundle.putString((String) next.getKey(), (String) next.getValue());
                }
            }
            if (StringsKt.contains$default((CharSequence) trackableEvent.getEventId(), (CharSequence) Util.EVENT_ID_SEPARATOR, false, 2, (Object) null)) {
                for (String str : StringsKt.split$default((CharSequence) trackableEvent.getEventId(), new String[]{Util.EVENT_ID_SEPARATOR}, false, 0, 6, (Object) null)) {
                    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                    send(StringsKt.trim((CharSequence) str).toString(), bundle);
                }
                return;
            }
            send(trackableEvent.getEventId(), bundle);
        }
    }

    private final void send(String str, Bundle bundle) {
        if (str.length() >= 40) {
            str = StringsKt.substring(str, RangesKt.until(0, 40));
        }
        Log.d(TAG, "Logging Firebase Event.. [" + str + ']');
        getDefaultLogger().logEvent(str, bundle);
    }
}
