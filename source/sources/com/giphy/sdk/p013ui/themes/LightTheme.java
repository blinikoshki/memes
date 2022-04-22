package com.giphy.sdk.p013ui.themes;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0018"}, mo26107d2 = {"Lcom/giphy/sdk/ui/themes/LightTheme;", "Lcom/giphy/sdk/ui/themes/Theme;", "Landroid/os/Parcelable;", "()V", "activeTextColor", "", "getActiveTextColor", "()I", "backgroundColor", "getBackgroundColor", "channelColor", "getChannelColor", "dimOverlayColor", "getDimOverlayColor", "handleBarColor", "getHandleBarColor", "textColor", "getTextColor", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.themes.LightTheme */
/* compiled from: LightTheme.kt */
public final class LightTheme extends Theme implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final LightTheme INSTANCE = new LightTheme();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.themes.LightTheme$Creator */
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            if (parcel.readInt() != 0) {
                return LightTheme.INSTANCE;
            }
            return null;
        }

        public final Object[] newArray(int i) {
            return new LightTheme[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getActiveTextColor() {
        return (int) 4278190080L;
    }

    public int getBackgroundColor() {
        return (int) 4294046193L;
    }

    public int getChannelColor() {
        return (int) 4283321934L;
    }

    public int getDimOverlayColor() {
        return 1291845632;
    }

    public int getHandleBarColor() {
        return (int) 4287137928L;
    }

    public int getTextColor() {
        return (int) 4289111718L;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(1);
    }

    private LightTheme() {
    }
}
