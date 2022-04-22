package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b¢\u0006\u0002\u0010\u0017J\t\u0010/\u001a\u000200HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000200HÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010!R\u0016\u0010\u0013\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010)R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019¨\u00066"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/User;", "Landroid/os/Parcelable;", "id", "", "avatarUrl", "bannerUrl", "profileUrl", "username", "displayName", "twitter", "isPublic", "", "attributionDisplayName", "name", "description", "facebookUrl", "twitterUrl", "instagramUrl", "tumblrUrl", "isSuppressChrome", "websiteUrl", "websiteDisplayUrl", "verified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "getAttributionDisplayName", "()Ljava/lang/String;", "getAvatarUrl", "getBannerUrl", "getDescription", "getDisplayName", "getFacebookUrl", "getId", "getInstagramUrl", "()Z", "getName", "getProfileUrl", "getTumblrUrl", "getTwitter", "getTwitterUrl", "getUsername", "setUsername", "(Ljava/lang/String;)V", "getVerified", "setVerified", "(Z)V", "getWebsiteDisplayUrl", "getWebsiteUrl", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: User.kt */
public final class User implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("attribution_display_name")
    private final String attributionDisplayName;
    @SerializedName("avatar_url")
    private final String avatarUrl;
    @SerializedName("banner_url")
    private final String bannerUrl;
    private final String description;
    @SerializedName("display_name")
    private final String displayName;
    @SerializedName("facebook_url")
    private final String facebookUrl;

    /* renamed from: id */
    private final String f179id;
    @SerializedName("instagram_url")
    private final String instagramUrl;
    @SerializedName("is_public")
    private final boolean isPublic;
    @SerializedName("suppress_chrome")
    private final boolean isSuppressChrome;
    private final String name;
    @SerializedName("profile_url")
    private final String profileUrl;
    @SerializedName("tumblr_url")
    private final String tumblrUrl;
    private final String twitter;
    @SerializedName("twitter_url")
    private final String twitterUrl;
    private String username;
    @SerializedName("is_verified")
    private boolean verified;
    @SerializedName("website_display_url")
    private final String websiteDisplayUrl;
    @SerializedName("website_url")
    private final String websiteUrl;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new User(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new User[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.f179id);
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.bannerUrl);
        parcel.writeString(this.profileUrl);
        parcel.writeString(this.username);
        parcel.writeString(this.displayName);
        parcel.writeString(this.twitter);
        parcel.writeInt(this.isPublic ? 1 : 0);
        parcel.writeString(this.attributionDisplayName);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.facebookUrl);
        parcel.writeString(this.twitterUrl);
        parcel.writeString(this.instagramUrl);
        parcel.writeString(this.tumblrUrl);
        parcel.writeInt(this.isSuppressChrome ? 1 : 0);
        parcel.writeString(this.websiteUrl);
        parcel.writeString(this.websiteDisplayUrl);
        parcel.writeInt(this.verified ? 1 : 0);
    }

    public User(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z2, String str15, String str16, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str5, "username");
        this.f179id = str;
        this.avatarUrl = str2;
        this.bannerUrl = str3;
        this.profileUrl = str4;
        this.username = str5;
        this.displayName = str6;
        this.twitter = str7;
        this.isPublic = z;
        this.attributionDisplayName = str8;
        this.name = str9;
        this.description = str10;
        this.facebookUrl = str11;
        this.twitterUrl = str12;
        this.instagramUrl = str13;
        this.tumblrUrl = str14;
        this.isSuppressChrome = z2;
        this.websiteUrl = str15;
        this.websiteDisplayUrl = str16;
        this.verified = z3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, boolean r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, boolean r39, java.lang.String r40, java.lang.String r41, boolean r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r4 = r1
            goto L_0x000e
        L_0x000c:
            r4 = r24
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0017
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r5 = r1
            goto L_0x0019
        L_0x0017:
            r5 = r25
        L_0x0019:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0022
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r6 = r1
            goto L_0x0024
        L_0x0022:
            r6 = r26
        L_0x0024:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x002d
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x002f
        L_0x002d:
            r7 = r27
        L_0x002f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0038
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            goto L_0x003a
        L_0x0038:
            r9 = r29
        L_0x003a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0043
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            goto L_0x0045
        L_0x0043:
            r10 = r30
        L_0x0045:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r3 = 0
            if (r1 == 0) goto L_0x004c
            r11 = 0
            goto L_0x004e
        L_0x004c:
            r11 = r31
        L_0x004e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0057
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r12 = r1
            goto L_0x0059
        L_0x0057:
            r12 = r32
        L_0x0059:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0062
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r13 = r1
            goto L_0x0064
        L_0x0062:
            r13 = r33
        L_0x0064:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x006d
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r14 = r1
            goto L_0x006f
        L_0x006d:
            r14 = r34
        L_0x006f:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0078
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r15 = r1
            goto L_0x007a
        L_0x0078:
            r15 = r35
        L_0x007a:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0084
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r16 = r1
            goto L_0x0086
        L_0x0084:
            r16 = r36
        L_0x0086:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0090
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r17 = r1
            goto L_0x0092
        L_0x0090:
            r17 = r37
        L_0x0092:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x009c
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r18 = r1
            goto L_0x009e
        L_0x009c:
            r18 = r38
        L_0x009e:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a7
            r19 = 0
            goto L_0x00a9
        L_0x00a7:
            r19 = r39
        L_0x00a9:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b4
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r20 = r1
            goto L_0x00b6
        L_0x00b4:
            r20 = r40
        L_0x00b6:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c1
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r21 = r1
            goto L_0x00c3
        L_0x00c1:
            r21 = r41
        L_0x00c3:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00cb
            r22 = 0
            goto L_0x00cd
        L_0x00cb:
            r22 = r42
        L_0x00cd:
            r3 = r23
            r8 = r28
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.User.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.f179id;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final String getProfileUrl() {
        return this.profileUrl;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.username = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getTwitter() {
        return this.twitter;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final String getAttributionDisplayName() {
        return this.attributionDisplayName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFacebookUrl() {
        return this.facebookUrl;
    }

    public final String getTwitterUrl() {
        return this.twitterUrl;
    }

    public final String getInstagramUrl() {
        return this.instagramUrl;
    }

    public final String getTumblrUrl() {
        return this.tumblrUrl;
    }

    public final boolean isSuppressChrome() {
        return this.isSuppressChrome;
    }

    public final String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public final String getWebsiteDisplayUrl() {
        return this.websiteDisplayUrl;
    }

    public final boolean getVerified() {
        return this.verified;
    }

    public final void setVerified(boolean z) {
        this.verified = z;
    }
}
