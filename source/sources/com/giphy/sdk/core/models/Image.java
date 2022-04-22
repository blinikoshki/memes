package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014¨\u0006/"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/Image;", "Landroid/os/Parcelable;", "gifUrl", "", "width", "", "height", "gifSize", "frames", "mp4Url", "mp4Size", "webPUrl", "webPSize", "mediaId", "renditionType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "(Ljava/lang/String;IIIILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "getFrames", "()I", "setFrames", "(I)V", "getGifSize", "getGifUrl", "()Ljava/lang/String;", "setGifUrl", "(Ljava/lang/String;)V", "getHeight", "setHeight", "getMediaId", "setMediaId", "getMp4Size", "getMp4Url", "setMp4Url", "getRenditionType", "()Lcom/giphy/sdk/core/models/enums/RenditionType;", "setRenditionType", "(Lcom/giphy/sdk/core/models/enums/RenditionType;)V", "getWebPSize", "getWebPUrl", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Image.kt */
public final class Image implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private int frames;
    @SerializedName("size")
    private final int gifSize;
    @SerializedName("url")
    private String gifUrl;
    private int height;
    private String mediaId;
    @SerializedName("mp4_size")
    private final int mp4Size;
    @SerializedName("mp4")
    private String mp4Url;
    private RenditionType renditionType;
    @SerializedName("webp_size")
    private final int webPSize;
    @SerializedName("webp")
    private final String webPUrl;
    private int width;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            RenditionType renditionType;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            String readString2 = parcel.readString();
            int readInt5 = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt6 = parcel.readInt();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                renditionType = (RenditionType) Enum.valueOf(RenditionType.class, parcel.readString());
            } else {
                renditionType = null;
            }
            return new Image(readString, readInt, readInt2, readInt3, readInt4, readString2, readInt5, readString3, readInt6, readString4, renditionType);
        }

        public final Object[] newArray(int i) {
            return new Image[i];
        }
    }

    public Image() {
        this((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.gifUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.gifSize);
        parcel.writeInt(this.frames);
        parcel.writeString(this.mp4Url);
        parcel.writeInt(this.mp4Size);
        parcel.writeString(this.webPUrl);
        parcel.writeInt(this.webPSize);
        parcel.writeString(this.mediaId);
        RenditionType renditionType2 = this.renditionType;
        if (renditionType2 != null) {
            parcel.writeInt(1);
            parcel.writeString(renditionType2.name());
            return;
        }
        parcel.writeInt(0);
    }

    public Image(String str, int i, int i2, int i3, int i4, String str2, int i5, String str3, int i6, String str4, RenditionType renditionType2) {
        this.gifUrl = str;
        this.width = i;
        this.height = i2;
        this.gifSize = i3;
        this.frames = i4;
        this.mp4Url = str2;
        this.mp4Size = i5;
        this.webPUrl = str3;
        this.webPSize = i6;
        this.mediaId = str4;
        this.renditionType = renditionType2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Image(java.lang.String r13, int r14, int r15, int r16, int r17, java.lang.String r18, int r19, java.lang.String r20, int r21, java.lang.String r22, com.giphy.sdk.core.models.enums.RenditionType r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000c
        L_0x000b:
            r1 = r13
        L_0x000c:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0014
        L_0x0013:
            r3 = r14
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = 0
            goto L_0x001b
        L_0x001a:
            r5 = r15
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r16
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r17
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0035
        L_0x0033:
            r8 = r18
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = 0
            goto L_0x003d
        L_0x003b:
            r9 = r19
        L_0x003d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r4 = r21
        L_0x004e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0056
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0058
        L_0x0056:
            r11 = r22
        L_0x0058:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0060
            r0 = r2
            com.giphy.sdk.core.models.enums.RenditionType r0 = (com.giphy.sdk.core.models.enums.RenditionType) r0
            goto L_0x0062
        L_0x0060:
            r0 = r23
        L_0x0062:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r11
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.Image.<init>(java.lang.String, int, int, int, int, java.lang.String, int, java.lang.String, int, java.lang.String, com.giphy.sdk.core.models.enums.RenditionType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getGifSize() {
        return this.gifSize;
    }

    public final int getFrames() {
        return this.frames;
    }

    public final void setFrames(int i) {
        this.frames = i;
    }

    public final String getMp4Url() {
        return this.mp4Url;
    }

    public final void setMp4Url(String str) {
        this.mp4Url = str;
    }

    public final int getMp4Size() {
        return this.mp4Size;
    }

    public final String getWebPUrl() {
        return this.webPUrl;
    }

    public final int getWebPSize() {
        return this.webPSize;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final void setMediaId(String str) {
        this.mediaId = str;
    }

    public final RenditionType getRenditionType() {
        return this.renditionType;
    }

    public final void setRenditionType(RenditionType renditionType2) {
        this.renditionType = renditionType2;
    }
}
