package com.memes.eventtracker.tracking;

import com.memes.eventtracker.tracking.EventTracking;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EventTracking.kt */
final /* synthetic */ class EventTracking$Companion$trackingManager$1 extends MutablePropertyReference0Impl {
    EventTracking$Companion$trackingManager$1(EventTracking.Companion companion) {
        super(companion, EventTracking.Companion.class, "eventTrackingManager", "getEventTrackingManager()Lcom/memes/eventtracker/tracking/EventTrackingManager;", 0);
    }

    public Object get() {
        EventTracking.Companion companion = (EventTracking.Companion) this.receiver;
        EventTrackingManager access$getEventTrackingManager$cp = EventTracking.eventTrackingManager;
        if (access$getEventTrackingManager$cp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTrackingManager");
        }
        return access$getEventTrackingManager$cp;
    }

    public void set(Object obj) {
        EventTracking.Companion companion = (EventTracking.Companion) this.receiver;
        EventTracking.eventTrackingManager = (EventTrackingManager) obj;
    }
}
