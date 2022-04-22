package com.giphy.sdk.analytics.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.analytics.models.enums.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/Attribute;", "Landroid/os/Parcelable;", "key", "Lcom/giphy/sdk/analytics/models/enums/AttributeKey;", "value", "", "(Lcom/giphy/sdk/analytics/models/enums/AttributeKey;Ljava/lang/String;)V", "getKey", "()Lcom/giphy/sdk/analytics/models/enums/AttributeKey;", "setKey", "(Lcom/giphy/sdk/analytics/models/enums/AttributeKey;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Attribute.kt */
public final class Attribute implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String LAYOUT_TYPE_CAROUSEL = "CAROUSEL";
    /* access modifiers changed from: private */
    public static String LAYOUT_TYPE_GRID = "GRID";
    private AttributeKey key;
    private String value;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            AttributeKey attributeKey;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            if (parcel.readInt() != 0) {
                attributeKey = (AttributeKey) Enum.valueOf(AttributeKey.class, parcel.readString());
            } else {
                attributeKey = null;
            }
            return new Attribute(attributeKey, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Attribute[i];
        }
    }

    public Attribute() {
        this((AttributeKey) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        AttributeKey attributeKey = this.key;
        if (attributeKey != null) {
            parcel.writeInt(1);
            parcel.writeString(attributeKey.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.value);
    }

    public Attribute(AttributeKey attributeKey, String str) {
        this.key = attributeKey;
        this.value = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Attribute(AttributeKey attributeKey, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : attributeKey, (i & 2) != 0 ? null : str);
    }

    public final AttributeKey getKey() {
        return this.key;
    }

    public final void setKey(AttributeKey attributeKey) {
        this.key = attributeKey;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/Attribute$Companion;", "", "()V", "LAYOUT_TYPE_CAROUSEL", "", "getLAYOUT_TYPE_CAROUSEL", "()Ljava/lang/String;", "setLAYOUT_TYPE_CAROUSEL", "(Ljava/lang/String;)V", "LAYOUT_TYPE_GRID", "getLAYOUT_TYPE_GRID", "setLAYOUT_TYPE_GRID", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: Attribute.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getLAYOUT_TYPE_CAROUSEL() {
            return Attribute.LAYOUT_TYPE_CAROUSEL;
        }

        public final void setLAYOUT_TYPE_CAROUSEL(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            Attribute.LAYOUT_TYPE_CAROUSEL = str;
        }

        public final String getLAYOUT_TYPE_GRID() {
            return Attribute.LAYOUT_TYPE_GRID;
        }

        public final void setLAYOUT_TYPE_GRID(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            Attribute.LAYOUT_TYPE_GRID = str;
        }
    }
}
