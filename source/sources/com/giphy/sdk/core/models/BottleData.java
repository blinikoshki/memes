package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/BottleData;", "Landroid/os/Parcelable;", "tid", "", "tags", "", "tdata", "Lcom/giphy/sdk/core/models/TrackingData;", "(Ljava/lang/String;Ljava/util/List;Lcom/giphy/sdk/core/models/TrackingData;)V", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTdata", "()Lcom/giphy/sdk/core/models/TrackingData;", "getTid", "()Ljava/lang/String;", "setTid", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: BottleData.kt */
public final class BottleData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private List<String> tags;
    private final TrackingData tdata;
    private String tid;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new BottleData(parcel.readString(), parcel.createStringArrayList(), parcel.readInt() != 0 ? (TrackingData) TrackingData.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new BottleData[i];
        }
    }

    public BottleData() {
        this((String) null, (List) null, (TrackingData) null, 7, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.tid);
        parcel.writeStringList(this.tags);
        TrackingData trackingData = this.tdata;
        if (trackingData != null) {
            parcel.writeInt(1);
            trackingData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public BottleData(String str, List<String> list, TrackingData trackingData) {
        this.tid = str;
        this.tags = list;
        this.tdata = trackingData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottleData(String str, List list, TrackingData trackingData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : trackingData);
    }

    public final String getTid() {
        return this.tid;
    }

    public final void setTid(String str) {
        this.tid = str;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final TrackingData getTdata() {
        return this.tdata;
    }
}
