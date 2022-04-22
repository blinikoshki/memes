package com.memes.plus.p040ui.user_listing;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingTarget;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Followers", "Followings", "Likes", "Suggestions", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingTarget */
/* compiled from: UserListingTarget.kt */
public class UserListingTarget implements Parcelable {
    public static final Parcelable.Creator<UserListingTarget> CREATOR = new Creator();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Creator */
    public static class Creator implements Parcelable.Creator<UserListingTarget> {
        public final UserListingTarget createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                return new UserListingTarget();
            }
            return null;
        }

        public final UserListingTarget[] newArray(int i) {
            return new UserListingTarget[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(1);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingTarget$Likes;", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "Landroid/os/Parcelable;", "postId", "", "(Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Likes */
    /* compiled from: UserListingTarget.kt */
    public static final class Likes extends UserListingTarget implements Parcelable {
        public static final Parcelable.Creator<Likes> CREATOR = new Creator();
        private final String postId;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Likes$Creator */
        public static class Creator implements Parcelable.Creator<Likes> {
            public final Likes createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Likes(parcel.readString());
            }

            public final Likes[] newArray(int i) {
                return new Likes[i];
            }
        }

        public static /* synthetic */ Likes copy$default(Likes likes, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = likes.postId;
            }
            return likes.copy(str);
        }

        public final String component1() {
            return this.postId;
        }

        public final Likes copy(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
            return new Likes(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Likes) && Intrinsics.areEqual((Object) this.postId, (Object) ((Likes) obj).postId);
            }
            return true;
        }

        public int hashCode() {
            String str = this.postId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Likes(postId=" + this.postId + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.postId);
        }

        public final String getPostId() {
            return this.postId;
        }

        public Likes(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
            this.postId = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingTarget$Followers;", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "Landroid/os/Parcelable;", "targetUserId", "", "(Ljava/lang/String;)V", "getTargetUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Followers */
    /* compiled from: UserListingTarget.kt */
    public static final class Followers extends UserListingTarget implements Parcelable {
        public static final Parcelable.Creator<Followers> CREATOR = new Creator();
        private final String targetUserId;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Followers$Creator */
        public static class Creator implements Parcelable.Creator<Followers> {
            public final Followers createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Followers(parcel.readString());
            }

            public final Followers[] newArray(int i) {
                return new Followers[i];
            }
        }

        public static /* synthetic */ Followers copy$default(Followers followers, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = followers.targetUserId;
            }
            return followers.copy(str);
        }

        public final String component1() {
            return this.targetUserId;
        }

        public final Followers copy(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            return new Followers(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Followers) && Intrinsics.areEqual((Object) this.targetUserId, (Object) ((Followers) obj).targetUserId);
            }
            return true;
        }

        public int hashCode() {
            String str = this.targetUserId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Followers(targetUserId=" + this.targetUserId + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.targetUserId);
        }

        public final String getTargetUserId() {
            return this.targetUserId;
        }

        public Followers(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            this.targetUserId = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingTarget$Followings;", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "Landroid/os/Parcelable;", "targetUserId", "", "(Ljava/lang/String;)V", "getTargetUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Followings */
    /* compiled from: UserListingTarget.kt */
    public static final class Followings extends UserListingTarget implements Parcelable {
        public static final Parcelable.Creator<Followings> CREATOR = new Creator();
        private final String targetUserId;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Followings$Creator */
        public static class Creator implements Parcelable.Creator<Followings> {
            public final Followings createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Followings(parcel.readString());
            }

            public final Followings[] newArray(int i) {
                return new Followings[i];
            }
        }

        public static /* synthetic */ Followings copy$default(Followings followings, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = followings.targetUserId;
            }
            return followings.copy(str);
        }

        public final String component1() {
            return this.targetUserId;
        }

        public final Followings copy(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            return new Followings(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Followings) && Intrinsics.areEqual((Object) this.targetUserId, (Object) ((Followings) obj).targetUserId);
            }
            return true;
        }

        public int hashCode() {
            String str = this.targetUserId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Followings(targetUserId=" + this.targetUserId + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.targetUserId);
        }

        public final String getTargetUserId() {
            return this.targetUserId;
        }

        public Followings(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            this.targetUserId = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tHÖ\u0001¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingTarget$Suggestions;", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "Landroid/os/Parcelable;", "()V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Suggestions */
    /* compiled from: UserListingTarget.kt */
    public static final class Suggestions extends UserListingTarget implements Parcelable {
        public static final Parcelable.Creator<Suggestions> CREATOR = new Creator();
        public static final Suggestions INSTANCE = new Suggestions();

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.user_listing.UserListingTarget$Suggestions$Creator */
        public static class Creator implements Parcelable.Creator<Suggestions> {
            public final Suggestions createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return Suggestions.INSTANCE;
                }
                return null;
            }

            public final Suggestions[] newArray(int i) {
                return new Suggestions[i];
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }

        private Suggestions() {
        }
    }
}
