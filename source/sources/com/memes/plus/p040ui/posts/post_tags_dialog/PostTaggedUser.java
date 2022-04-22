package com.memes.plus.p040ui.posts.post_tags_dialog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TaggedPerson;
import com.memes.plus.util.BooleanIntPropertyConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003Je\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0006\u0010'\u001a\u00020(R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006)"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "", "fullName", "", "userName", "profileImageUrl", "profileImageThumbUrl", "userId", "postId", "isProUser", "", "tagAccepted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getFullName", "()Ljava/lang/String;", "()Z", "getPostId", "getProfileImageThumbUrl", "getProfileImageUrl", "getTagAccepted", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "requirePostId", "requireUserId", "requireUserName", "toString", "toTaggedPerson", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPerson;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUser */
/* compiled from: PostTaggedUser.kt */
public final class PostTaggedUser {
    @SerializedName("full_name")
    @Expose
    private final String fullName;
    @SerializedName("pro_user")
    @Expose
    private final boolean isProUser;
    @SerializedName("post_id")
    @Expose
    private final String postId;
    @SerializedName("profileImageThumb")
    @Expose
    private final String profileImageThumbUrl;
    @SerializedName("profileImage")
    @Expose
    private final String profileImageUrl;
    @SerializedName("tag_accepted")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private final boolean tagAccepted;
    @SerializedName("user_id")
    @Expose
    private final String userId;
    @SerializedName("username")
    @Expose
    private final String userName;

    public static /* synthetic */ PostTaggedUser copy$default(PostTaggedUser postTaggedUser, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, int i, Object obj) {
        PostTaggedUser postTaggedUser2 = postTaggedUser;
        int i2 = i;
        return postTaggedUser.copy((i2 & 1) != 0 ? postTaggedUser2.fullName : str, (i2 & 2) != 0 ? postTaggedUser2.userName : str2, (i2 & 4) != 0 ? postTaggedUser2.profileImageUrl : str3, (i2 & 8) != 0 ? postTaggedUser2.profileImageThumbUrl : str4, (i2 & 16) != 0 ? postTaggedUser2.userId : str5, (i2 & 32) != 0 ? postTaggedUser2.postId : str6, (i2 & 64) != 0 ? postTaggedUser2.isProUser : z, (i2 & 128) != 0 ? postTaggedUser2.tagAccepted : z2);
    }

    public final String component1() {
        return this.fullName;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.profileImageUrl;
    }

    public final String component4() {
        return this.profileImageThumbUrl;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.postId;
    }

    public final boolean component7() {
        return this.isProUser;
    }

    public final boolean component8() {
        return this.tagAccepted;
    }

    public final PostTaggedUser copy(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        return new PostTaggedUser(str, str2, str3, str4, str5, str6, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostTaggedUser)) {
            return false;
        }
        PostTaggedUser postTaggedUser = (PostTaggedUser) obj;
        return Intrinsics.areEqual((Object) this.fullName, (Object) postTaggedUser.fullName) && Intrinsics.areEqual((Object) this.userName, (Object) postTaggedUser.userName) && Intrinsics.areEqual((Object) this.profileImageUrl, (Object) postTaggedUser.profileImageUrl) && Intrinsics.areEqual((Object) this.profileImageThumbUrl, (Object) postTaggedUser.profileImageThumbUrl) && Intrinsics.areEqual((Object) this.userId, (Object) postTaggedUser.userId) && Intrinsics.areEqual((Object) this.postId, (Object) postTaggedUser.postId) && this.isProUser == postTaggedUser.isProUser && this.tagAccepted == postTaggedUser.tagAccepted;
    }

    public int hashCode() {
        String str = this.fullName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.profileImageUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.profileImageThumbUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.userId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.postId;
        if (str6 != null) {
            i = str6.hashCode();
        }
        int i2 = (hashCode5 + i) * 31;
        boolean z = this.isProUser;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.tagAccepted;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "PostTaggedUser(fullName=" + this.fullName + ", userName=" + this.userName + ", profileImageUrl=" + this.profileImageUrl + ", profileImageThumbUrl=" + this.profileImageThumbUrl + ", userId=" + this.userId + ", postId=" + this.postId + ", isProUser=" + this.isProUser + ", tagAccepted=" + this.tagAccepted + ")";
    }

    public PostTaggedUser(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        this.fullName = str;
        this.userName = str2;
        this.profileImageUrl = str3;
        this.profileImageThumbUrl = str4;
        this.userId = str5;
        this.postId = str6;
        this.isProUser = z;
        this.tagAccepted = z2;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final String getProfileImageThumbUrl() {
        return this.profileImageThumbUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PostTaggedUser(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r10 = 0
            goto L_0x000b
        L_0x0009:
            r10 = r19
        L_0x000b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0011
            r11 = 0
            goto L_0x0013
        L_0x0011:
            r11 = r20
        L_0x0013:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getTagAccepted() {
        return this.tagAccepted;
    }

    public final String requireUserId() {
        String str = this.userId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requireUserName() {
        String str = this.userName;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requirePostId() {
        String str = this.postId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final TaggedPerson toTaggedPerson() {
        return new TaggedPerson(this.profileImageUrl, this.fullName, this.userName, this.userId, this.isProUser, 0.0f, 0.0f, 0.0f, 0.0f, DimensionsKt.XXHDPI, (DefaultConstructorMarker) null);
    }
}
