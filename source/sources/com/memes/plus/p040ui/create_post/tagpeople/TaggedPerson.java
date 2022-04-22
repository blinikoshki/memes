package com.memes.plus.p040ui.create_post.tagpeople;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003Jk\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%HÖ\u0001R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u00060"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TaggedPerson;", "Landroid/os/Parcelable;", "profilePicUrl", "", "name", "userName", "user_id", "isProUser", "", "x", "", "y", "w", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFFFF)V", "getH", "()F", "()Z", "getName", "()Ljava/lang/String;", "getProfilePicUrl", "getUserName", "getUser_id", "getW", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TaggedPerson */
/* compiled from: TaggedPerson.kt */
public final class TaggedPerson implements Parcelable {
    public static final Parcelable.Creator<TaggedPerson> CREATOR = new Creator();

    /* renamed from: h */
    private final float f1025h;
    private final boolean isProUser;
    private final String name;
    private final String profilePicUrl;
    private final String userName;
    private final String user_id;

    /* renamed from: w */
    private final float f1026w;

    /* renamed from: x */
    private final float f1027x;

    /* renamed from: y */
    private final float f1028y;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.tagpeople.TaggedPerson$Creator */
    public static class Creator implements Parcelable.Creator<TaggedPerson> {
        public final TaggedPerson createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TaggedPerson(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        public final TaggedPerson[] newArray(int i) {
            return new TaggedPerson[i];
        }
    }

    public static /* synthetic */ TaggedPerson copy$default(TaggedPerson taggedPerson, String str, String str2, String str3, String str4, boolean z, float f, float f2, float f3, float f4, int i, Object obj) {
        TaggedPerson taggedPerson2 = taggedPerson;
        int i2 = i;
        return taggedPerson.copy((i2 & 1) != 0 ? taggedPerson2.profilePicUrl : str, (i2 & 2) != 0 ? taggedPerson2.name : str2, (i2 & 4) != 0 ? taggedPerson2.userName : str3, (i2 & 8) != 0 ? taggedPerson2.user_id : str4, (i2 & 16) != 0 ? taggedPerson2.isProUser : z, (i2 & 32) != 0 ? taggedPerson2.f1027x : f, (i2 & 64) != 0 ? taggedPerson2.f1028y : f2, (i2 & 128) != 0 ? taggedPerson2.f1026w : f3, (i2 & 256) != 0 ? taggedPerson2.f1025h : f4);
    }

    public final String component1() {
        return this.profilePicUrl;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.user_id;
    }

    public final boolean component5() {
        return this.isProUser;
    }

    public final float component6() {
        return this.f1027x;
    }

    public final float component7() {
        return this.f1028y;
    }

    public final float component8() {
        return this.f1026w;
    }

    public final float component9() {
        return this.f1025h;
    }

    public final TaggedPerson copy(String str, String str2, String str3, String str4, boolean z, float f, float f2, float f3, float f4) {
        return new TaggedPerson(str, str2, str3, str4, z, f, f2, f3, f4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaggedPerson)) {
            return false;
        }
        TaggedPerson taggedPerson = (TaggedPerson) obj;
        return Intrinsics.areEqual((Object) this.profilePicUrl, (Object) taggedPerson.profilePicUrl) && Intrinsics.areEqual((Object) this.name, (Object) taggedPerson.name) && Intrinsics.areEqual((Object) this.userName, (Object) taggedPerson.userName) && Intrinsics.areEqual((Object) this.user_id, (Object) taggedPerson.user_id) && this.isProUser == taggedPerson.isProUser && Float.compare(this.f1027x, taggedPerson.f1027x) == 0 && Float.compare(this.f1028y, taggedPerson.f1028y) == 0 && Float.compare(this.f1026w, taggedPerson.f1026w) == 0 && Float.compare(this.f1025h, taggedPerson.f1025h) == 0;
    }

    public int hashCode() {
        String str = this.profilePicUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.user_id;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.isProUser;
        if (z) {
            z = true;
        }
        return ((((((((i2 + (z ? 1 : 0)) * 31) + Float.floatToIntBits(this.f1027x)) * 31) + Float.floatToIntBits(this.f1028y)) * 31) + Float.floatToIntBits(this.f1026w)) * 31) + Float.floatToIntBits(this.f1025h);
    }

    public String toString() {
        return "TaggedPerson(profilePicUrl=" + this.profilePicUrl + ", name=" + this.name + ", userName=" + this.userName + ", user_id=" + this.user_id + ", isProUser=" + this.isProUser + ", x=" + this.f1027x + ", y=" + this.f1028y + ", w=" + this.f1026w + ", h=" + this.f1025h + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.profilePicUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.userName);
        parcel.writeString(this.user_id);
        parcel.writeInt(this.isProUser ? 1 : 0);
        parcel.writeFloat(this.f1027x);
        parcel.writeFloat(this.f1028y);
        parcel.writeFloat(this.f1026w);
        parcel.writeFloat(this.f1025h);
    }

    public TaggedPerson(String str, String str2, String str3, String str4, boolean z, float f, float f2, float f3, float f4) {
        this.profilePicUrl = str;
        this.name = str2;
        this.userName = str3;
        this.user_id = str4;
        this.isProUser = z;
        this.f1027x = f;
        this.f1028y = f2;
        this.f1026w = f3;
        this.f1025h = f4;
    }

    public final String getProfilePicUrl() {
        return this.profilePicUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final float getX() {
        return this.f1027x;
    }

    public final float getY() {
        return this.f1028y;
    }

    public final float getW() {
        return this.f1026w;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TaggedPerson(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, float r18, float r19, float r20, float r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r7 = 0
            goto L_0x000b
        L_0x0009:
            r7 = r17
        L_0x000b:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r8 = 0
            goto L_0x0014
        L_0x0012:
            r8 = r18
        L_0x0014:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001a
            r9 = 0
            goto L_0x001c
        L_0x001a:
            r9 = r19
        L_0x001c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0022
            r10 = 0
            goto L_0x0024
        L_0x0022:
            r10 = r20
        L_0x0024:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002a
            r11 = 0
            goto L_0x002c
        L_0x002a:
            r11 = r21
        L_0x002c:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.create_post.tagpeople.TaggedPerson.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final float getH() {
        return this.f1025h;
    }
}
