package com.memes.eventtracker.trackers;

import com.memes.eventtracker.tracking.TrackableEvent;
import com.memes.eventtracker.tracking.TrackingPageInfo;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/EventTracker;", "", "disable", "", "enable", "init", "send", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventTracker.kt */
public interface EventTracker {
    void disable();

    void enable();

    void init();

    void send(TrackableEvent trackableEvent);

    void setPageInfo(TrackingPageInfo trackingPageInfo);
}
