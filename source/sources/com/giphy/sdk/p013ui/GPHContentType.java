package com.giphy.sdk.p013ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.core.models.enums.MediaType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0006\u001a\u00020\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005HÖ\u0001j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, mo26107d2 = {"Lcom/giphy/sdk/ui/GPHContentType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "getMediaType", "Lcom/giphy/sdk/core/models/enums/MediaType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "gif", "sticker", "text", "emoji", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.GPHContentType */
/* compiled from: GPHSettings.kt */
public enum GPHContentType implements Parcelable {
    gif,
    sticker,
    text,
    emoji;
    
    public static final Parcelable.Creator CREATOR = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.GPHContentType$Creator */
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return (GPHContentType) Enum.valueOf(GPHContentType.class, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new GPHContentType[i];
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.GPHContentType$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[GPHContentType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHContentType.gif.ordinal()] = 1;
            iArr[GPHContentType.sticker.ordinal()] = 2;
            iArr[GPHContentType.text.ordinal()] = 3;
            iArr[GPHContentType.emoji.ordinal()] = 4;
        }
    }

    static {
        CREATOR = new Creator();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(name());
    }

    public final MediaType getMediaType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return MediaType.gif;
        }
        if (i == 2) {
            return MediaType.sticker;
        }
        if (i == 3) {
            return MediaType.text;
        }
        if (i == 4) {
            return MediaType.gif;
        }
        throw new NoWhenBranchMatchedException();
    }
}
