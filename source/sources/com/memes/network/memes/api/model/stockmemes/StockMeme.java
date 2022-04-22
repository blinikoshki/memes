package com.memes.network.memes.api.model.stockmemes;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.network.memes.MemesProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010Jb\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u000bH\u0016J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\u0006\u0010+\u001a\u00020\u0006J\t\u0010,\u001a\u00020\u000bHÖ\u0001J\u0006\u0010-\u001a\u00020(J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\u0018\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u000bH\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u0010¨\u00063"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "keywords", "image", "thumb", "thumbWidth", "", "thumbHeight", "created", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCreated", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getImage", "getKeywords", "getThumb", "getThumbHeight", "getThumbWidth", "absoluteImageUrl", "absoluteThumbUrl", "aspectRatio", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "describeContents", "equals", "", "other", "", "getIdentifier", "hashCode", "isInvalid", "toString", "writeToParcel", "", "flags", "CREATOR", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StockMeme.kt */
public final class StockMeme implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    @SerializedName("created")
    @Expose
    private final Integer created;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private final String f993id;
    @SerializedName("image")
    @Expose
    private final String image;
    @SerializedName("keywords")
    @Expose
    private final String keywords;
    @SerializedName("thumb")
    @Expose
    private final String thumb;
    @SerializedName("thumb_height")
    @Expose
    private final Integer thumbHeight;
    @SerializedName("thumb_width")
    @Expose
    private final Integer thumbWidth;

    public StockMeme() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StockMeme copy$default(StockMeme stockMeme, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stockMeme.f993id;
        }
        if ((i & 2) != 0) {
            str2 = stockMeme.keywords;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = stockMeme.image;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = stockMeme.thumb;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = stockMeme.thumbWidth;
        }
        Integer num4 = num;
        if ((i & 32) != 0) {
            num2 = stockMeme.thumbHeight;
        }
        Integer num5 = num2;
        if ((i & 64) != 0) {
            num3 = stockMeme.created;
        }
        return stockMeme.copy(str, str5, str6, str7, num4, num5, num3);
    }

    public final String component1() {
        return this.f993id;
    }

    public final String component2() {
        return this.keywords;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.thumb;
    }

    public final Integer component5() {
        return this.thumbWidth;
    }

    public final Integer component6() {
        return this.thumbHeight;
    }

    public final Integer component7() {
        return this.created;
    }

    public final StockMeme copy(String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3) {
        return new StockMeme(str, str2, str3, str4, num, num2, num3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StockMeme)) {
            return false;
        }
        StockMeme stockMeme = (StockMeme) obj;
        return Intrinsics.areEqual((Object) this.f993id, (Object) stockMeme.f993id) && Intrinsics.areEqual((Object) this.keywords, (Object) stockMeme.keywords) && Intrinsics.areEqual((Object) this.image, (Object) stockMeme.image) && Intrinsics.areEqual((Object) this.thumb, (Object) stockMeme.thumb) && Intrinsics.areEqual((Object) this.thumbWidth, (Object) stockMeme.thumbWidth) && Intrinsics.areEqual((Object) this.thumbHeight, (Object) stockMeme.thumbHeight) && Intrinsics.areEqual((Object) this.created, (Object) stockMeme.created);
    }

    public int hashCode() {
        String str = this.f993id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.keywords;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.thumb;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.thumbWidth;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.thumbHeight;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.created;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "StockMeme(id=" + this.f993id + ", keywords=" + this.keywords + ", image=" + this.image + ", thumb=" + this.thumb + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", created=" + this.created + ")";
    }

    public StockMeme(String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3) {
        this.f993id = str;
        this.keywords = str2;
        this.image = str3;
        this.thumb = str4;
        this.thumbWidth = num;
        this.thumbHeight = num2;
        this.created = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StockMeme(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.Integer r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
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
            java.lang.Integer r10 = (java.lang.Integer) r10
        L_0x0027:
            r3 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x002f
            r11 = r0
            java.lang.Integer r11 = (java.lang.Integer) r11
        L_0x002f:
            r4 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0037
            r12 = r0
            java.lang.Integer r12 = (java.lang.Integer) r12
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
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.api.model.stockmemes.StockMeme.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.f993id;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final Integer getThumbWidth() {
        return this.thumbWidth;
    }

    public final Integer getThumbHeight() {
        return this.thumbHeight;
    }

    public final Integer getCreated() {
        return this.created;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StockMeme(android.os.Parcel r10) {
        /*
            r9 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            java.lang.String r5 = r10.readString()
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r10.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            r6 = 0
            if (r1 != 0) goto L_0x0025
            r0 = r6
        L_0x0025:
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r10.readValue(r1)
            boolean r7 = r1 instanceof java.lang.Integer
            if (r7 != 0) goto L_0x0036
            r1 = r6
        L_0x0036:
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r10 = r10.readValue(r1)
            boolean r1 = r10 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r6 = r10
        L_0x0049:
            r8 = r6
            java.lang.Integer r8 = (java.lang.Integer) r8
            r1 = r9
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.api.model.stockmemes.StockMeme.<init>(android.os.Parcel):void");
    }

    public final String getIdentifier() {
        String str = this.f993id;
        if (str == null) {
            str = absoluteImageUrl();
        }
        return str != null ? str : "-1";
    }

    public final String absoluteImageUrl() {
        if (this.image == null) {
            return absoluteThumbUrl();
        }
        return MemesProxy.INSTANCE.toAbsoluteCdnUrl(this.image);
    }

    public final String absoluteThumbUrl() {
        if (this.thumb == null) {
            return null;
        }
        return MemesProxy.INSTANCE.toAbsoluteCdnUrl(this.thumb);
    }

    public final float aspectRatio() {
        Integer num;
        if (this.thumbWidth == null || (num = this.thumbHeight) == null) {
            return 1.0f;
        }
        if (num != null && num.intValue() == 0) {
            return 1.0f;
        }
        return ((float) this.thumbWidth.intValue()) / ((float) this.thumbHeight.intValue());
    }

    public final boolean isInvalid() {
        CharSequence absoluteThumbUrl = absoluteThumbUrl();
        if (!(absoluteThumbUrl == null || StringsKt.isBlank(absoluteThumbUrl))) {
            CharSequence absoluteImageUrl = absoluteImageUrl();
            return absoluteImageUrl == null || StringsKt.isBlank(absoluteImageUrl);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f993id);
        parcel.writeString(this.keywords);
        parcel.writeString(this.image);
        parcel.writeString(this.thumb);
        parcel.writeValue(this.thumbWidth);
        parcel.writeValue(this.thumbHeight);
        parcel.writeValue(this.created);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/network/memes/api/model/stockmemes/StockMeme$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StockMeme.kt */
    public static final class CREATOR implements Parcelable.Creator<StockMeme> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public StockMeme createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StockMeme(parcel);
        }

        public StockMeme[] newArray(int i) {
            return new StockMeme[i];
        }
    }
}
