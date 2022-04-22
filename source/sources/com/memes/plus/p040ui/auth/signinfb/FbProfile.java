package com.memes.plus.p040ui.auth.signinfb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbProfile;", "", "()V", "email", "", "getEmail", "()Ljava/lang/String;", "localUserId", "getLocalUserId", "name", "getName", "picture", "Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture;", "hasProfilePic", "", "requireProfilePicUrl", "FbPicture", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbProfile */
/* compiled from: FbProfile.kt */
public final class FbProfile {
    @SerializedName("email")
    @Expose
    private final String email;
    @SerializedName("id")
    @Expose
    private final String localUserId;
    @SerializedName("name")
    @Expose
    private final String name;
    @SerializedName("picture")
    @Expose
    private final FbPicture picture;

    public final String getLocalUserId() {
        return this.localUserId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture;", "", "pictureData", "Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture$FbPictureData;", "(Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture$FbPictureData;)V", "getPictureData", "()Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture$FbPictureData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "FbPictureData", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signinfb.FbProfile$FbPicture */
    /* compiled from: FbProfile.kt */
    public static final class FbPicture {
        @SerializedName("data")
        @Expose
        private final FbPictureData pictureData;

        public FbPicture() {
            this((FbPictureData) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ FbPicture copy$default(FbPicture fbPicture, FbPictureData fbPictureData, int i, Object obj) {
            if ((i & 1) != 0) {
                fbPictureData = fbPicture.pictureData;
            }
            return fbPicture.copy(fbPictureData);
        }

        public final FbPictureData component1() {
            return this.pictureData;
        }

        public final FbPicture copy(FbPictureData fbPictureData) {
            return new FbPicture(fbPictureData);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof FbPicture) && Intrinsics.areEqual((Object) this.pictureData, (Object) ((FbPicture) obj).pictureData);
            }
            return true;
        }

        public int hashCode() {
            FbPictureData fbPictureData = this.pictureData;
            if (fbPictureData != null) {
                return fbPictureData.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "FbPicture(pictureData=" + this.pictureData + ")";
        }

        public FbPicture(FbPictureData fbPictureData) {
            this.pictureData = fbPictureData;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FbPicture(FbPictureData fbPictureData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fbPictureData);
        }

        public final FbPictureData getPictureData() {
            return this.pictureData;
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006#"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture$FbPictureData;", "", "height", "", "isSilhouette", "", "url", "", "width", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setSilhouette", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/memes/plus/ui/auth/signinfb/FbProfile$FbPicture$FbPictureData;", "equals", "other", "hashCode", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.auth.signinfb.FbProfile$FbPicture$FbPictureData */
        /* compiled from: FbProfile.kt */
        public static final class FbPictureData {
            @SerializedName("height")
            @Expose
            private Integer height;
            @SerializedName("is_silhouette")
            @Expose
            private Boolean isSilhouette;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("width")
            @Expose
            private Integer width;

            public FbPictureData() {
                this((Integer) null, (Boolean) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ FbPictureData copy$default(FbPictureData fbPictureData, Integer num, Boolean bool, String str, Integer num2, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = fbPictureData.height;
                }
                if ((i & 2) != 0) {
                    bool = fbPictureData.isSilhouette;
                }
                if ((i & 4) != 0) {
                    str = fbPictureData.url;
                }
                if ((i & 8) != 0) {
                    num2 = fbPictureData.width;
                }
                return fbPictureData.copy(num, bool, str, num2);
            }

            public final Integer component1() {
                return this.height;
            }

            public final Boolean component2() {
                return this.isSilhouette;
            }

            public final String component3() {
                return this.url;
            }

            public final Integer component4() {
                return this.width;
            }

            public final FbPictureData copy(Integer num, Boolean bool, String str, Integer num2) {
                return new FbPictureData(num, bool, str, num2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FbPictureData)) {
                    return false;
                }
                FbPictureData fbPictureData = (FbPictureData) obj;
                return Intrinsics.areEqual((Object) this.height, (Object) fbPictureData.height) && Intrinsics.areEqual((Object) this.isSilhouette, (Object) fbPictureData.isSilhouette) && Intrinsics.areEqual((Object) this.url, (Object) fbPictureData.url) && Intrinsics.areEqual((Object) this.width, (Object) fbPictureData.width);
            }

            public int hashCode() {
                Integer num = this.height;
                int i = 0;
                int hashCode = (num != null ? num.hashCode() : 0) * 31;
                Boolean bool = this.isSilhouette;
                int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
                String str = this.url;
                int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Integer num2 = this.width;
                if (num2 != null) {
                    i = num2.hashCode();
                }
                return hashCode3 + i;
            }

            public String toString() {
                return "FbPictureData(height=" + this.height + ", isSilhouette=" + this.isSilhouette + ", url=" + this.url + ", width=" + this.width + ")";
            }

            public FbPictureData(Integer num, Boolean bool, String str, Integer num2) {
                this.height = num;
                this.isSilhouette = bool;
                this.url = str;
                this.width = num2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ FbPictureData(Integer num, Boolean bool, String str, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num2);
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final void setHeight(Integer num) {
                this.height = num;
            }

            public final Boolean isSilhouette() {
                return this.isSilhouette;
            }

            public final void setSilhouette(Boolean bool) {
                this.isSilhouette = bool;
            }

            public final String getUrl() {
                return this.url;
            }

            public final void setUrl(String str) {
                this.url = str;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public final void setWidth(Integer num) {
                this.width = num;
            }
        }
    }

    public final boolean hasProfilePic() {
        FbPicture fbPicture = this.picture;
        if (fbPicture == null || fbPicture.getPictureData() == null || (!Intrinsics.areEqual((Object) this.picture.getPictureData().isSilhouette(), (Object) false))) {
            return false;
        }
        CharSequence url = this.picture.getPictureData().getUrl();
        if (url == null || StringsKt.isBlank(url)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPictureData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String requireProfilePicUrl() {
        /*
            r2 = this;
            com.memes.plus.ui.auth.signinfb.FbProfile$FbPicture r0 = r2.picture
            if (r0 == 0) goto L_0x000f
            com.memes.plus.ui.auth.signinfb.FbProfile$FbPicture$FbPictureData r0 = r0.getPictureData()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getUrl()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Required value was null."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.signinfb.FbProfile.requireProfilePicUrl():java.lang.String");
    }
}
