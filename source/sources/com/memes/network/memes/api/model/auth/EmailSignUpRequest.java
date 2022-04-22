package com.memes.network.memes.api.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u0010¨\u0006)"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;", "", "email", "", "userName", "password", "fullName", "gender", "birthday", "profilePic", "firebaseToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/String;", "getEmail", "setEmail", "(Ljava/lang/String;)V", "getFirebaseToken", "setFirebaseToken", "getFullName", "getGender", "getPassword", "setPassword", "getProfilePic", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EmailSignUpRequest.kt */
public final class EmailSignUpRequest {
    @SerializedName("birthday")
    @Expose
    private final String birthday;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("device_token")
    @Expose
    private String firebaseToken;
    @SerializedName("full_name")
    @Expose
    private final String fullName;
    @SerializedName("gender")
    @Expose
    private final String gender;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("profileImage")
    @Expose
    private final String profilePic;
    @SerializedName("username")
    @Expose
    private String userName;

    public static /* synthetic */ EmailSignUpRequest copy$default(EmailSignUpRequest emailSignUpRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        EmailSignUpRequest emailSignUpRequest2 = emailSignUpRequest;
        int i2 = i;
        return emailSignUpRequest.copy((i2 & 1) != 0 ? emailSignUpRequest2.email : str, (i2 & 2) != 0 ? emailSignUpRequest2.userName : str2, (i2 & 4) != 0 ? emailSignUpRequest2.password : str3, (i2 & 8) != 0 ? emailSignUpRequest2.fullName : str4, (i2 & 16) != 0 ? emailSignUpRequest2.gender : str5, (i2 & 32) != 0 ? emailSignUpRequest2.birthday : str6, (i2 & 64) != 0 ? emailSignUpRequest2.profilePic : str7, (i2 & 128) != 0 ? emailSignUpRequest2.firebaseToken : str8);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.password;
    }

    public final String component4() {
        return this.fullName;
    }

    public final String component5() {
        return this.gender;
    }

    public final String component6() {
        return this.birthday;
    }

    public final String component7() {
        return this.profilePic;
    }

    public final String component8() {
        return this.firebaseToken;
    }

    public final EmailSignUpRequest copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str4, TagPeopleActivity.FULL_NAME);
        return new EmailSignUpRequest(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailSignUpRequest)) {
            return false;
        }
        EmailSignUpRequest emailSignUpRequest = (EmailSignUpRequest) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) emailSignUpRequest.email) && Intrinsics.areEqual((Object) this.userName, (Object) emailSignUpRequest.userName) && Intrinsics.areEqual((Object) this.password, (Object) emailSignUpRequest.password) && Intrinsics.areEqual((Object) this.fullName, (Object) emailSignUpRequest.fullName) && Intrinsics.areEqual((Object) this.gender, (Object) emailSignUpRequest.gender) && Intrinsics.areEqual((Object) this.birthday, (Object) emailSignUpRequest.birthday) && Intrinsics.areEqual((Object) this.profilePic, (Object) emailSignUpRequest.profilePic) && Intrinsics.areEqual((Object) this.firebaseToken, (Object) emailSignUpRequest.firebaseToken);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.password;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fullName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.gender;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.birthday;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.profilePic;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.firebaseToken;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "EmailSignUpRequest(email=" + this.email + ", userName=" + this.userName + ", password=" + this.password + ", fullName=" + this.fullName + ", gender=" + this.gender + ", birthday=" + this.birthday + ", profilePic=" + this.profilePic + ", firebaseToken=" + this.firebaseToken + ")";
    }

    public EmailSignUpRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str4, TagPeopleActivity.FULL_NAME);
        this.email = str;
        this.userName = str2;
        this.password = str3;
        this.fullName = str4;
        this.gender = str5;
        this.birthday = str6;
        this.profilePic = str7;
        this.firebaseToken = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EmailSignUpRequest(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r4 = r1
            goto L_0x000d
        L_0x000c:
            r4 = r13
        L_0x000d:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0016
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r5 = r1
            goto L_0x0017
        L_0x0016:
            r5 = r14
        L_0x0017:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0020
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r6 = r1
            goto L_0x0021
        L_0x0020:
            r6 = r15
        L_0x0021:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002a
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            r11 = r0
            goto L_0x002c
        L_0x002a:
            r11 = r20
        L_0x002c:
            r3 = r12
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.api.model.auth.EmailSignUpRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getProfilePic() {
        return this.profilePic;
    }

    public final String getFirebaseToken() {
        return this.firebaseToken;
    }

    public final void setFirebaseToken(String str) {
        this.firebaseToken = str;
    }
}
