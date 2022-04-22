package tools.targetednavigation;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.gaelmarhic.quadrant.QuadrantConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Ltools/targetednavigation/TargetedNavigation;", "", "()V", "EXTRA_TARGET_PARCEL", "", "createLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "request", "Landroid/os/Parcelable;", "launch", "", "HashTagPageRequest", "ProfilePageRequest", "activityproxy_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TargetedNavigation.kt */
public final class TargetedNavigation {
    public static final String EXTRA_TARGET_PARCEL = "intent_extra_target_parcel";
    public static final TargetedNavigation INSTANCE = new TargetedNavigation();

    private TargetedNavigation() {
    }

    public final Intent createLaunchIntent(Context context, Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parcelable, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intent intent = new Intent(context, Class.forName(QuadrantConstants.TARGETED_NAVIGATION_ACTIVITY));
        intent.putExtra(EXTRA_TARGET_PARCEL, parcelable);
        return intent;
    }

    public final void launch(Context context, Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parcelable, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        context.startActivity(createLaunchIntent(context, parcelable));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0010"}, mo26107d2 = {"Ltools/targetednavigation/TargetedNavigation$ProfilePageRequest;", "Landroid/os/Parcelable;", "targetUserId", "", "targetUserName", "(Ljava/lang/String;Ljava/lang/String;)V", "getTargetUserId", "()Ljava/lang/String;", "getTargetUserName", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "activityproxy_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TargetedNavigation.kt */
    public static final class ProfilePageRequest implements Parcelable {
        public static final Parcelable.Creator<ProfilePageRequest> CREATOR = new Creator();
        private final String targetUserId;
        private final String targetUserName;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ProfilePageRequest> {
            public final ProfilePageRequest createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ProfilePageRequest(parcel.readString(), parcel.readString());
            }

            public final ProfilePageRequest[] newArray(int i) {
                return new ProfilePageRequest[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.targetUserId);
            parcel.writeString(this.targetUserName);
        }

        public ProfilePageRequest(String str, String str2) {
            this.targetUserId = str;
            this.targetUserName = str2;
        }

        public final String getTargetUserId() {
            return this.targetUserId;
        }

        public final String getTargetUserName() {
            return this.targetUserName;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo26107d2 = {"Ltools/targetednavigation/TargetedNavigation$HashTagPageRequest;", "Landroid/os/Parcelable;", "hashTag", "", "(Ljava/lang/String;)V", "getHashTag", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "activityproxy_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TargetedNavigation.kt */
    public static final class HashTagPageRequest implements Parcelable {
        public static final Parcelable.Creator<HashTagPageRequest> CREATOR = new Creator();
        private final String hashTag;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<HashTagPageRequest> {
            public final HashTagPageRequest createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new HashTagPageRequest(parcel.readString());
            }

            public final HashTagPageRequest[] newArray(int i) {
                return new HashTagPageRequest[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.hashTag);
        }

        public HashTagPageRequest(String str) {
            Intrinsics.checkNotNullParameter(str, "hashTag");
            this.hashTag = str;
        }

        public final String getHashTag() {
            return this.hashTag;
        }
    }
}
