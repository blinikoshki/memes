package com.memes.eventtracker.trackers.facebook;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.eventtracker.specialevents.SpecialEvent;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.tracking.TrackableEvent;
import com.memes.eventtracker.tracking.TrackingPageInfo;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/facebook/FacebookEventTracker;", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "defaultLogger", "Lcom/facebook/appevents/AppEventsLogger;", "kotlin.jvm.PlatformType", "getDefaultLogger", "()Lcom/facebook/appevents/AppEventsLogger;", "defaultLogger$delegate", "Lkotlin/Lazy;", "isEnabled", "", "isInitialized", "disable", "", "enable", "init", "send", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "sendPurchaseEvent", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FacebookEventTracker.kt */
public final class FacebookEventTracker implements EventTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FacebookEventTracker";
    /* access modifiers changed from: private */
    public final Application application;
    private final Lazy defaultLogger$delegate;
    private boolean isEnabled;
    private boolean isInitialized;

    private final AppEventsLogger getDefaultLogger() {
        return (AppEventsLogger) this.defaultLogger$delegate.getValue();
    }

    public void setPageInfo(TrackingPageInfo trackingPageInfo) {
        Intrinsics.checkNotNullParameter(trackingPageInfo, "pageInfo");
    }

    private FacebookEventTracker(Application application2) {
        this.application = application2;
        this.defaultLogger$delegate = LazyKt.lazy(new FacebookEventTracker$defaultLogger$2(this));
    }

    public /* synthetic */ FacebookEventTracker(Application application2, DefaultConstructorMarker defaultConstructorMarker) {
        this(application2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/facebook/FacebookEventTracker$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/memes/eventtracker/trackers/EventTracker;", "application", "Landroid/app/Application;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FacebookEventTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTracker getInstance(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            return new FacebookEventTracker(application, (DefaultConstructorMarker) null);
        }
    }

    public void init() {
        FacebookSdk.setAutoInitEnabled(true);
        AppEventsLogger.activateApp(this.application);
        this.isInitialized = true;
    }

    public void enable() {
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        this.isEnabled = true;
    }

    public void disable() {
        FacebookSdk.setAutoLogAppEventsEnabled(false);
        FacebookSdk.setAdvertiserIDCollectionEnabled(false);
        this.isEnabled = false;
    }

    public void send(TrackableEvent trackableEvent) {
        Intrinsics.checkNotNullParameter(trackableEvent, "event");
        if (!this.isInitialized || !this.isEnabled) {
            return;
        }
        if (Intrinsics.areEqual((Object) trackableEvent.getEventId(), (Object) SpecialEvent.FB_EVENT_PURCHASE)) {
            sendPurchaseEvent(trackableEvent);
            return;
        }
        Double d = null;
        Bundle bundle = new Bundle();
        Map<String, String> data = trackableEvent.getData();
        if (data != null && (!data.isEmpty())) {
            for (Map.Entry next : data.entrySet()) {
                if (Intrinsics.areEqual((Object) (String) next.getKey(), (Object) SpecialEvent.FB_EVENT_PARAM_PRICE)) {
                    String str = (String) next.getValue();
                    d = str != null ? StringsKt.toDoubleOrNull(str) : null;
                } else {
                    bundle.putString((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        Log.d(TAG, "Logging Facebook Event.. [" + trackableEvent.getEventId() + ']');
        if (d != null) {
            getDefaultLogger().logEvent(trackableEvent.getEventId(), d.doubleValue(), bundle);
        } else {
            getDefaultLogger().logEvent(trackableEvent.getEventId(), bundle);
        }
    }

    private final void sendPurchaseEvent(TrackableEvent trackableEvent) {
        Currency currency;
        Double d = null;
        Currency currency2 = null;
        Bundle bundle = new Bundle();
        Map<String, String> data = trackableEvent.getData();
        if (data != null && (!data.isEmpty())) {
            Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
            loop0:
            while (true) {
                currency = currency2;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    Map.Entry next = it.next();
                    if (Intrinsics.areEqual((Object) (String) next.getKey(), (Object) SpecialEvent.FB_EVENT_PARAM_PRICE)) {
                        String str = (String) next.getValue();
                        d = str != null ? StringsKt.toDoubleOrNull(str) : null;
                    } else if (Intrinsics.areEqual((Object) (String) next.getKey(), (Object) AppEventsConstants.EVENT_PARAM_CURRENCY)) {
                        CharSequence charSequence = (CharSequence) next.getValue();
                        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                            currency = Currency.getInstance((String) next.getValue());
                        }
                    } else {
                        bundle.putString((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            currency2 = currency;
        }
        Log.d(TAG, "Logging Facebook Purchase Event.. price=" + d + " currency=" + currency2);
        if (d == null) {
            bundle.putString("manual_price", "NA");
            getDefaultLogger().logEvent(trackableEvent.getEventId(), bundle);
        } else if (currency2 == null) {
            getDefaultLogger().logEvent(trackableEvent.getEventId(), d.doubleValue(), bundle);
        } else {
            getDefaultLogger().logPurchase(BigDecimal.valueOf(d.doubleValue()), currency2, bundle);
        }
    }
}
