package com.memes.network.memes.source.remote.model.usersearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.network.memes.MemesProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006!"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "", "id", "", "newId", "profileImageUrl", "profileImageThumbUrl", "userName", "fullName", "followersCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFollowersCount", "()Ljava/lang/String;", "getFullName", "getUserName", "chatUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getProfileImageThumbUrl", "getProfileImageUrl", "hashCode", "", "oldUserId", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserSearchResult.kt */
public final class UserSearchResult {
    @SerializedName("followers")
    @Expose
    private final String followersCount;
    @SerializedName("full_name")
    @Expose
    private final String fullName;
    @SerializedName("user_id")
    @Expose

    /* renamed from: id */
    private final String f994id;
    @SerializedName("id")
    @Expose
    private final String newId;
    @SerializedName("profileImageThumb")
    @Expose
    private final String profileImageThumbUrl;
    @SerializedName("profileImage")
    @Expose
    private final String profileImageUrl;
    @SerializedName("username")
    @Expose
    private final String userName;

    public UserSearchResult() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    private final String component1() {
        return this.f994id;
    }

    private final String component2() {
        return this.newId;
    }

    private final String component3() {
        return this.profileImageUrl;
    }

    private final String component4() {
        return this.profileImageThumbUrl;
    }

    public static /* synthetic */ UserSearchResult copy$default(UserSearchResult userSearchResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userSearchResult.f994id;
        }
        if ((i & 2) != 0) {
            str2 = userSearchResult.newId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = userSearchResult.profileImageUrl;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = userSearchResult.profileImageThumbUrl;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = userSearchResult.userName;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = userSearchResult.fullName;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = userSearchResult.followersCount;
        }
        return userSearchResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.fullName;
    }

    public final String component7() {
        return this.followersCount;
    }

    public final UserSearchResult copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new UserSearchResult(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSearchResult)) {
            return false;
        }
        UserSearchResult userSearchResult = (UserSearchResult) obj;
        return Intrinsics.areEqual((Object) this.f994id, (Object) userSearchResult.f994id) && Intrinsics.areEqual((Object) this.newId, (Object) userSearchResult.newId) && Intrinsics.areEqual((Object) this.profileImageUrl, (Object) userSearchResult.profileImageUrl) && Intrinsics.areEqual((Object) this.profileImageThumbUrl, (Object) userSearchResult.profileImageThumbUrl) && Intrinsics.areEqual((Object) this.userName, (Object) userSearchResult.userName) && Intrinsics.areEqual((Object) this.fullName, (Object) userSearchResult.fullName) && Intrinsics.areEqual((Object) this.followersCount, (Object) userSearchResult.followersCount);
    }

    public int hashCode() {
        String str = this.f994id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.newId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.profileImageUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.profileImageThumbUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.userName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.fullName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.followersCount;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "UserSearchResult(id=" + this.f994id + ", newId=" + this.newId + ", profileImageUrl=" + this.profileImageUrl + ", profileImageThumbUrl=" + this.profileImageThumbUrl + ", userName=" + this.userName + ", fullName=" + this.fullName + ", followersCount=" + this.followersCount + ")";
    }

    public UserSearchResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f994id = str;
        this.newId = str2;
        this.profileImageUrl = str3;
        this.profileImageThumbUrl = str4;
        this.userName = str5;
        this.fullName = str6;
        this.followersCount = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserSearchResult(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0008
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
        L_0x0008:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000f
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
        L_0x000f:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0017
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
        L_0x0017:
            r1 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001f
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
        L_0x001f:
            r2 = r9
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0027
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
        L_0x0027:
            r3 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x002f
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11
        L_0x002f:
            r4 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0037
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
        L_0x0037:
            r0 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.model.usersearch.UserSearchResult.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getFollowersCount() {
        return this.followersCount;
    }

    public final String oldUserId() {
        return this.f994id;
    }

    public final String chatUserId() {
        return this.newId;
    }

    public final String getProfileImageUrl() {
        if (MemesProxy.INSTANCE.isJustCdnPath(this.profileImageUrl)) {
            return null;
        }
        return this.profileImageUrl;
    }

    public final String getProfileImageThumbUrl() {
        if (MemesProxy.INSTANCE.isJustCdnPath(this.profileImageThumbUrl)) {
            return null;
        }
        return this.profileImageThumbUrl;
    }
}
