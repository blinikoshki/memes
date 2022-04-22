package com.memes.network.memes.api.model.auth;

import androidx.core.app.FrameMetricsAggregator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/FbSignInRequest;", "", "email", "", "firebaseToken", "facebookId", "name", "userName", "profileImage", "country", "location", "age", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "getCountry", "getEmail", "getFacebookId", "getFirebaseToken", "getLocation", "getName", "getProfileImage", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FbSignInRequest.kt */
public final class FbSignInRequest {
    @SerializedName("age")
    @Expose
    private final String age;
    @SerializedName("country")
    @Expose
    private final String country;
    @SerializedName("email")
    @Expose
    private final String email;
    @SerializedName("facebook_id")
    @Expose
    private final String facebookId;
    @SerializedName("device_token")
    @Expose
    private final String firebaseToken;
    @SerializedName("location")
    @Expose
    private final String location;
    @SerializedName("name")
    @Expose
    private final String name;
    @SerializedName("profileImage")
    @Expose
    private final String profileImage;
    @SerializedName("username")
    @Expose
    private final String userName;

    public FbSignInRequest() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FbSignInRequest copy$default(FbSignInRequest fbSignInRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        FbSignInRequest fbSignInRequest2 = fbSignInRequest;
        int i2 = i;
        return fbSignInRequest.copy((i2 & 1) != 0 ? fbSignInRequest2.email : str, (i2 & 2) != 0 ? fbSignInRequest2.firebaseToken : str2, (i2 & 4) != 0 ? fbSignInRequest2.facebookId : str3, (i2 & 8) != 0 ? fbSignInRequest2.name : str4, (i2 & 16) != 0 ? fbSignInRequest2.userName : str5, (i2 & 32) != 0 ? fbSignInRequest2.profileImage : str6, (i2 & 64) != 0 ? fbSignInRequest2.country : str7, (i2 & 128) != 0 ? fbSignInRequest2.location : str8, (i2 & 256) != 0 ? fbSignInRequest2.age : str9);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.firebaseToken;
    }

    public final String component3() {
        return this.facebookId;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.profileImage;
    }

    public final String component7() {
        return this.country;
    }

    public final String component8() {
        return this.location;
    }

    public final String component9() {
        return this.age;
    }

    public final FbSignInRequest copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new FbSignInRequest(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FbSignInRequest)) {
            return false;
        }
        FbSignInRequest fbSignInRequest = (FbSignInRequest) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) fbSignInRequest.email) && Intrinsics.areEqual((Object) this.firebaseToken, (Object) fbSignInRequest.firebaseToken) && Intrinsics.areEqual((Object) this.facebookId, (Object) fbSignInRequest.facebookId) && Intrinsics.areEqual((Object) this.name, (Object) fbSignInRequest.name) && Intrinsics.areEqual((Object) this.userName, (Object) fbSignInRequest.userName) && Intrinsics.areEqual((Object) this.profileImage, (Object) fbSignInRequest.profileImage) && Intrinsics.areEqual((Object) this.country, (Object) fbSignInRequest.country) && Intrinsics.areEqual((Object) this.location, (Object) fbSignInRequest.location) && Intrinsics.areEqual((Object) this.age, (Object) fbSignInRequest.age);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firebaseToken;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.facebookId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.userName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.profileImage;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.country;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.location;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.age;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "FbSignInRequest(email=" + this.email + ", firebaseToken=" + this.firebaseToken + ", facebookId=" + this.facebookId + ", name=" + this.name + ", userName=" + this.userName + ", profileImage=" + this.profileImage + ", country=" + this.country + ", location=" + this.location + ", age=" + this.age + ")";
    }

    public FbSignInRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.email = str;
        this.firebaseToken = str2;
        this.facebookId = str3;
        this.name = str4;
        this.userName = str5;
        this.profileImage = str6;
        this.country = str7;
        this.location = str8;
        this.age = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FbSignInRequest(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000c
        L_0x000b:
            r1 = r11
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0014
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0015
        L_0x0014:
            r3 = r12
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001d
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x001e
        L_0x001d:
            r4 = r13
        L_0x001e:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0027
        L_0x0026:
            r5 = r14
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002f
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0030
        L_0x002f:
            r6 = r15
        L_0x0030:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0038
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x003a
        L_0x0038:
            r7 = r16
        L_0x003a:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0042
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0044
        L_0x0042:
            r8 = r17
        L_0x0044:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004c
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x004e
        L_0x004c:
            r9 = r18
        L_0x004e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0056
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0058
        L_0x0056:
            r0 = r19
        L_0x0058:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.api.model.auth.FbSignInRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirebaseToken() {
        return this.firebaseToken;
    }

    public final String getFacebookId() {
        return this.facebookId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getAge() {
        return this.age;
    }
}
