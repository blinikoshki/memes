package com.giphy.sdk.analytics.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dHÖ\u0001R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\""}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/Event;", "Landroid/os/Parcelable;", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "responseId", "", "referrer", "actions", "", "Lcom/giphy/sdk/analytics/models/Action;", "(Lcom/giphy/sdk/analytics/models/enums/EventType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getEventType", "()Lcom/giphy/sdk/analytics/models/enums/EventType;", "setEventType", "(Lcom/giphy/sdk/analytics/models/enums/EventType;)V", "getReferrer", "()Ljava/lang/String;", "setReferrer", "(Ljava/lang/String;)V", "getResponseId", "setResponseId", "addAction", "", "action", "describeContents", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Event.kt */
public final class Event implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private List<Action> actions;
    @SerializedName("event_type")
    private EventType eventType;
    private String referrer;
    @SerializedName("response_id")
    private String responseId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            EventType eventType = (EventType) Enum.valueOf(EventType.class, parcel.readString());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Action) Action.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new Event(eventType, readString, readString2, arrayList);
        }

        public final Object[] newArray(int i) {
            return new Event[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.eventType.name());
        parcel.writeString(this.responseId);
        parcel.writeString(this.referrer);
        List<Action> list = this.actions;
        parcel.writeInt(list.size());
        for (Action writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public Event(EventType eventType2, String str, String str2, List<Action> list) {
        Intrinsics.checkParameterIsNotNull(eventType2, "eventType");
        Intrinsics.checkParameterIsNotNull(str, "responseId");
        Intrinsics.checkParameterIsNotNull(list, "actions");
        this.eventType = eventType2;
        this.responseId = str;
        this.referrer = str2;
        this.actions = list;
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final void setEventType(EventType eventType2) {
        Intrinsics.checkParameterIsNotNull(eventType2, "<set-?>");
        this.eventType = eventType2;
    }

    public final String getResponseId() {
        return this.responseId;
    }

    public final void setResponseId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.responseId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Event(EventType eventType2, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? new ArrayList() : list);
    }

    public final String getReferrer() {
        return this.referrer;
    }

    public final void setReferrer(String str) {
        this.referrer = str;
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final void setActions(List<Action> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.actions = list;
    }

    public final void addAction(Action action) {
        Intrinsics.checkParameterIsNotNull(action, NativeProtocol.WEB_DIALOG_ACTION);
        this.actions.add(action);
    }
}
