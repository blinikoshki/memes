package com.memes.plus.custom;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.plus.custom.UserAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo26107d2 = {"com/memes/plus/custom/UserAvatarView$SavedState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/memes/plus/custom/UserAvatarView$SavedState;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/memes/plus/custom/UserAvatarView$SavedState;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
public final class UserAvatarView$SavedState$Companion$CREATOR$1 implements Parcelable.Creator<UserAvatarView.SavedState> {
    UserAvatarView$SavedState$Companion$CREATOR$1() {
    }

    public UserAvatarView.SavedState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new UserAvatarView.SavedState(parcel, (DefaultConstructorMarker) null);
    }

    public UserAvatarView.SavedState[] newArray(int i) {
        return new UserAvatarView.SavedState[i];
    }
}
