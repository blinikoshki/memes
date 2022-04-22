package top.defaults.drawabletoolbox;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo26107d2 = {"top/defaults/drawabletoolbox/DrawableProperties$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Ltop/defaults/drawabletoolbox/DrawableProperties;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltop/defaults/drawabletoolbox/DrawableProperties;", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: DrawableProperties.kt */
public final class DrawableProperties$Companion$CREATOR$1 implements Parcelable.Creator<DrawableProperties> {
    DrawableProperties$Companion$CREATOR$1() {
    }

    public DrawableProperties createFromParcel(Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        return new DrawableProperties(parcel);
    }

    public DrawableProperties[] newArray(int i) {
        return new DrawableProperties[i];
    }
}
