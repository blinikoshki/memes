package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0019"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/Pagination;", "Landroid/os/Parcelable;", "totalCount", "", "count", "offset", "nextPage", "", "nextCursor", "(IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()I", "getNextCursor", "()Ljava/lang/String;", "getNextPage", "getOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalCount", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Pagination.kt */
public final class Pagination implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int count;
    @SerializedName("next_cursor")
    private final String nextCursor;
    @SerializedName("next_page")
    private final String nextPage;
    private final Integer offset;
    @SerializedName("total_count")
    private final int totalCount;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new Pagination(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Pagination[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.totalCount);
        parcel.writeInt(this.count);
        Integer num = this.offset;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.nextPage);
        parcel.writeString(this.nextCursor);
    }

    public Pagination(int i, int i2, Integer num, String str, String str2) {
        this.totalCount = i;
        this.count = i2;
        this.offset = num;
        this.nextPage = str;
        this.nextCursor = str2;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getCount() {
        return this.count;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Pagination(int i, int i2, Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, num, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2);
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }
}
