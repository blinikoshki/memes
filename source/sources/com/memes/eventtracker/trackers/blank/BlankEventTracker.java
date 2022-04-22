package com.memes.eventtracker.trackers.blank;

import android.util.Log;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.tracking.TrackableEvent;
import com.memes.eventtracker.tracking.TrackingPageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/blank/BlankEventTracker;", "Lcom/memes/eventtracker/trackers/EventTracker;", "()V", "isEnabled", "", "isInitialized", "disable", "", "enable", "init", "send", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BlankEventTracker.kt */
public final class BlankEventTracker implements EventTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BlankEventTracker";
    private boolean isEnabled;
    private boolean isInitialized;

    public void setPageInfo(TrackingPageInfo trackingPageInfo) {
        Intrinsics.checkNotNullParameter(trackingPageInfo, "pageInfo");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/blank/BlankEventTracker$Companion;", "", "()V", "TAG", "", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BlankEventTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void init() {
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
        if (this.isInitialized && this.isEnabled) {
            Log.d(TAG, "Logging Blank event.. [" + trackableEvent.getEventId() + ']');
        }
    }
}
