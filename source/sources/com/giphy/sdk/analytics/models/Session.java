package com.giphy.sdk.analytics.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\u0012\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u0005H\u0002J\"\u0010(\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u0019\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bHÖ\u0001R \u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/Session;", "Landroid/os/Parcelable;", "user", "Lcom/giphy/sdk/analytics/models/User;", "sessionId", "", "events", "", "Lcom/giphy/sdk/analytics/models/Event;", "(Lcom/giphy/sdk/analytics/models/User;Ljava/lang/String;Ljava/util/List;)V", "actionCount", "", "actionCount$annotations", "()V", "getActionCount", "()I", "setActionCount", "(I)V", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getUser", "()Lcom/giphy/sdk/analytics/models/User;", "setUser", "(Lcom/giphy/sdk/analytics/models/User;)V", "addAction", "", "responseId", "referrer", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "action", "Lcom/giphy/sdk/analytics/models/Action;", "describeContents", "findEvent", "getOrCreateEvent", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Session.kt */
public final class Session implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private transient int actionCount;
    private List<Event> events;
    @SerializedName("session_id")
    private String sessionId;
    private User user;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            User user = (User) User.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Event) Event.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new Session(user, readString, arrayList);
        }

        public final Object[] newArray(int i) {
            return new Session[i];
        }
    }

    public static /* synthetic */ void actionCount$annotations() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.user.writeToParcel(parcel, 0);
        parcel.writeString(this.sessionId);
        List<Event> list = this.events;
        parcel.writeInt(list.size());
        for (Event writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public Session(User user2, String str, List<Event> list) {
        Intrinsics.checkParameterIsNotNull(user2, "user");
        Intrinsics.checkParameterIsNotNull(list, "events");
        this.user = user2;
        this.sessionId = str;
        this.events = list;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        Intrinsics.checkParameterIsNotNull(user2, "<set-?>");
        this.user = user2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Session(User user2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ArrayList() : list);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final List<Event> getEvents() {
        return this.events;
    }

    public final void setEvents(List<Event> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.events = list;
    }

    public final int getActionCount() {
        return this.actionCount;
    }

    public final void setActionCount(int i) {
        this.actionCount = i;
    }

    public final void addAction(String str, String str2, EventType eventType, Action action) {
        Intrinsics.checkParameterIsNotNull(str, "responseId");
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(action, NativeProtocol.WEB_DIALOG_ACTION);
        getOrCreateEvent(str, str2, eventType).addAction(action);
        this.actionCount++;
    }

    private final Event getOrCreateEvent(String str, String str2, EventType eventType) {
        Event findEvent = findEvent(str);
        if (findEvent != null) {
            if (findEvent.getEventType() != eventType) {
                Log.d("PINGBACK", "Warning! Event types for the same response id don't match");
            }
            if (str2 != null && (!Intrinsics.areEqual((Object) str2, (Object) findEvent.getReferrer()))) {
                Log.d("PINGBACK", "Warning! Referrer for the same response id don't match");
            }
            return findEvent;
        }
        Event event = new Event(eventType, str, str2, (List) null, 8, (DefaultConstructorMarker) null);
        this.events.add(event);
        return event;
    }

    private final Event findEvent(String str) {
        for (Event next : this.events) {
            if (Intrinsics.areEqual((Object) str, (Object) next.getResponseId())) {
                return next;
            }
        }
        return null;
    }
}
