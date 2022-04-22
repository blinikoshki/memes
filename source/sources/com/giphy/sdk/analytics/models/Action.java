package com.giphy.sdk.analytics.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/Action;", "Landroid/os/Parcelable;", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "gifId", "", "tid", "ts", "", "attributes", "", "Lcom/giphy/sdk/analytics/models/Attribute;", "(Lcom/giphy/sdk/analytics/models/enums/ActionType;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getActionType", "()Lcom/giphy/sdk/analytics/models/enums/ActionType;", "setActionType", "(Lcom/giphy/sdk/analytics/models/enums/ActionType;)V", "getAttributes", "()Ljava/util/List;", "getGifId", "()Ljava/lang/String;", "setGifId", "(Ljava/lang/String;)V", "getTid", "setTid", "getTs", "()J", "setTs", "(J)V", "addAttribute", "", "attribute", "describeContents", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Action.kt */
public final class Action implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("action_type")
    private ActionType actionType;
    private final List<Attribute> attributes;
    @SerializedName("gif_id")
    private String gifId;
    private String tid;

    /* renamed from: ts */
    private long f172ts;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ActionType actionType;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            if (parcel.readInt() != 0) {
                actionType = (ActionType) Enum.valueOf(ActionType.class, parcel.readString());
            } else {
                actionType = null;
            }
            ActionType actionType2 = actionType;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Attribute) Attribute.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new Action(actionType2, readString, readString2, readLong, arrayList);
        }

        public final Object[] newArray(int i) {
            return new Action[i];
        }
    }

    public Action() {
        this((ActionType) null, (String) null, (String) null, 0, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        ActionType actionType2 = this.actionType;
        if (actionType2 != null) {
            parcel.writeInt(1);
            parcel.writeString(actionType2.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.gifId);
        parcel.writeString(this.tid);
        parcel.writeLong(this.f172ts);
        List<Attribute> list = this.attributes;
        parcel.writeInt(list.size());
        for (Attribute writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public Action(ActionType actionType2, String str, String str2, long j, List<Attribute> list) {
        Intrinsics.checkParameterIsNotNull(list, "attributes");
        this.actionType = actionType2;
        this.gifId = str;
        this.tid = str2;
        this.f172ts = j;
        this.attributes = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Action(com.giphy.sdk.analytics.models.enums.ActionType r5, java.lang.String r6, java.lang.String r7, long r8, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0008
            r5 = r0
            com.giphy.sdk.analytics.models.enums.ActionType r5 = (com.giphy.sdk.analytics.models.enums.ActionType) r5
        L_0x0008:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000f
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
        L_0x000f:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0017
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
        L_0x0017:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001e
            r8 = 0
        L_0x001e:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x002b
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r10 = r6
            java.util.List r10 = (java.util.List) r10
        L_0x002b:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.analytics.models.Action.<init>(com.giphy.sdk.analytics.models.enums.ActionType, java.lang.String, java.lang.String, long, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final void setActionType(ActionType actionType2) {
        this.actionType = actionType2;
    }

    public final String getGifId() {
        return this.gifId;
    }

    public final void setGifId(String str) {
        this.gifId = str;
    }

    public final String getTid() {
        return this.tid;
    }

    public final void setTid(String str) {
        this.tid = str;
    }

    public final long getTs() {
        return this.f172ts;
    }

    public final void setTs(long j) {
        this.f172ts = j;
    }

    public final List<Attribute> getAttributes() {
        return this.attributes;
    }

    public final void addAttribute(Attribute attribute) {
        Intrinsics.checkParameterIsNotNull(attribute, "attribute");
        this.attributes.add(attribute);
    }
}
