package com.memes.eventtracker.specialevents;

import com.memes.eventtracker.tracking.TrackableEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/eventtracker/specialevents/SpecialEvent;", "", "()V", "appsFlyerEvent", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "facebookEvent", "firebaseEvent", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SpecialEvent.kt */
public abstract class SpecialEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FB_EVENT_PARAM_PRICE = "fb_event_param_price";
    public static final String FB_EVENT_PURCHASE = "fb_event_purchase";

    public abstract TrackableEvent appsFlyerEvent();

    public abstract TrackableEvent facebookEvent();

    public abstract TrackableEvent firebaseEvent();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/eventtracker/specialevents/SpecialEvent$Companion;", "", "()V", "FB_EVENT_PARAM_PRICE", "", "FB_EVENT_PURCHASE", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: SpecialEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
