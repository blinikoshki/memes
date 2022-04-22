package com.memes.eventtracker.tracking;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J-\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/TrackableEvent;", "", "eventId", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getEventId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TrackableEvent.kt */
public final class TrackableEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TrackableEvent EMPTY = new TrackableEvent("nothing", (Map<String, String>) null);
    private final Map<String, String> data;
    private final String eventId;

    public static /* synthetic */ TrackableEvent copy$default(TrackableEvent trackableEvent, String str, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackableEvent.eventId;
        }
        if ((i & 2) != 0) {
            map = trackableEvent.data;
        }
        return trackableEvent.copy(str, map);
    }

    public final String component1() {
        return this.eventId;
    }

    public final Map<String, String> component2() {
        return this.data;
    }

    public final TrackableEvent copy(String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        return new TrackableEvent(str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackableEvent)) {
            return false;
        }
        TrackableEvent trackableEvent = (TrackableEvent) obj;
        return Intrinsics.areEqual((Object) this.eventId, (Object) trackableEvent.eventId) && Intrinsics.areEqual((Object) this.data, (Object) trackableEvent.data);
    }

    public int hashCode() {
        String str = this.eventId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.data;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TrackableEvent(eventId=" + this.eventId + ", data=" + this.data + ")";
    }

    public TrackableEvent(String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.eventId = str;
        this.data = map;
    }

    public final String getEventId() {
        return this.eventId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackableEvent(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map);
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/TrackableEvent$Companion;", "", "()V", "EMPTY", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "getEMPTY", "()Lcom/memes/eventtracker/tracking/TrackableEvent;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TrackableEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrackableEvent getEMPTY() {
            return TrackableEvent.EMPTY;
        }
    }
}
