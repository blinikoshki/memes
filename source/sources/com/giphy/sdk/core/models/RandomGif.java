package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001eJ\t\u0010;\u001a\u00020\u000bHÖ\u0001J\u0006\u0010<\u001a\u00020=J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0016\u0010\u000f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0016\u0010\u0017\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0016\u0010\u0016\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0016\u0010\u0013\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0016\u0010\u0012\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0016\u0010\u001b\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u001a\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 ¨\u0006C"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/RandomGif;", "Landroid/os/Parcelable;", "type", "Lcom/giphy/sdk/core/models/enums/MediaType;", "id", "", "url", "imageOriginalUrl", "imageUrl", "imageMp4Url", "imageFrames", "", "imageWidth", "imageHeight", "fixedHeightDownsampledUrl", "fixedHeightDownsampledWidth", "fixedHeightDownsampledHeight", "fixedWidthDownsampledUrl", "fixedWidthDownsampledWidth", "fixedWidthDownsampledHeight", "fixedHeightSmallUrl", "fixedHeightSmallStillUrl", "fixedHeightSmallWidth", "fixedHeightSmallHeight", "fixedWidthSmallUrl", "fixedWidthSmallStillUrl", "fixedWidthSmallWidth", "fixedWidthSmallHeight", "username", "caption", "(Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IILjava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "getFixedHeightDownsampledHeight", "()I", "getFixedHeightDownsampledUrl", "getFixedHeightDownsampledWidth", "getFixedHeightSmallHeight", "getFixedHeightSmallStillUrl", "getFixedHeightSmallUrl", "getFixedHeightSmallWidth", "getFixedWidthDownsampledHeight", "getFixedWidthDownsampledUrl", "getFixedWidthDownsampledWidth", "getFixedWidthSmallHeight", "getFixedWidthSmallStillUrl", "getFixedWidthSmallUrl", "getFixedWidthSmallWidth", "getId", "getImageFrames", "getImageHeight", "getImageMp4Url", "getImageOriginalUrl", "getImageUrl", "getImageWidth", "getType", "()Lcom/giphy/sdk/core/models/enums/MediaType;", "getUrl", "getUsername", "describeContents", "toGif", "Lcom/giphy/sdk/core/models/Media;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: RandomGif.kt */
public final class RandomGif implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String caption;
    @SerializedName("fixed_height_downsampled_height")
    private final int fixedHeightDownsampledHeight;
    @SerializedName("fixed_height_downsampled_url")
    private final String fixedHeightDownsampledUrl;
    @SerializedName("fixed_height_downsampled_width")
    private final int fixedHeightDownsampledWidth;
    @SerializedName("fixed_height_small_height")
    private final int fixedHeightSmallHeight;
    @SerializedName("fixed_height_small_still_url")
    private final String fixedHeightSmallStillUrl;
    @SerializedName("fixed_height_small_url")
    private final String fixedHeightSmallUrl;
    @SerializedName("fixed_height_small_width")
    private final int fixedHeightSmallWidth;
    @SerializedName("fixed_width_downsampled_height")
    private final int fixedWidthDownsampledHeight;
    @SerializedName("fixed_width_downsampled_url")
    private final String fixedWidthDownsampledUrl;
    @SerializedName("fixed_width_downsampled_width")
    private final int fixedWidthDownsampledWidth;
    @SerializedName("fixed_width_small_height")
    private final int fixedWidthSmallHeight;
    @SerializedName("fixed_width_small_still_url")
    private final String fixedWidthSmallStillUrl;
    @SerializedName("fixed_width_small_url")
    private final String fixedWidthSmallUrl;
    @SerializedName("fixed_width_small_width")
    private final int fixedWidthSmallWidth;

    /* renamed from: id */
    private final String f177id;
    @SerializedName("image_frames")
    private final int imageFrames;
    @SerializedName("image_height")
    private final int imageHeight;
    @SerializedName("image_mp4_url")
    private final String imageMp4Url;
    @SerializedName("image_original_url")
    private final String imageOriginalUrl;
    @SerializedName("image_url")
    private final String imageUrl;
    @SerializedName("image_width")
    private final int imageWidth;
    private final MediaType type;
    private final String url;
    private final String username;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            MediaType mediaType;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            if (parcel.readInt() != 0) {
                mediaType = (MediaType) Enum.valueOf(MediaType.class, parcel.readString());
            } else {
                mediaType = null;
            }
            return new RandomGif(mediaType, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new RandomGif[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        MediaType mediaType = this.type;
        if (mediaType != null) {
            parcel.writeInt(1);
            parcel.writeString(mediaType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.f177id);
        parcel.writeString(this.url);
        parcel.writeString(this.imageOriginalUrl);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.imageMp4Url);
        parcel.writeInt(this.imageFrames);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeString(this.fixedHeightDownsampledUrl);
        parcel.writeInt(this.fixedHeightDownsampledWidth);
        parcel.writeInt(this.fixedHeightDownsampledHeight);
        parcel.writeString(this.fixedWidthDownsampledUrl);
        parcel.writeInt(this.fixedWidthDownsampledWidth);
        parcel.writeInt(this.fixedWidthDownsampledHeight);
        parcel.writeString(this.fixedHeightSmallUrl);
        parcel.writeString(this.fixedHeightSmallStillUrl);
        parcel.writeInt(this.fixedHeightSmallWidth);
        parcel.writeInt(this.fixedHeightSmallHeight);
        parcel.writeString(this.fixedWidthSmallUrl);
        parcel.writeString(this.fixedWidthSmallStillUrl);
        parcel.writeInt(this.fixedWidthSmallWidth);
        parcel.writeInt(this.fixedWidthSmallHeight);
        parcel.writeString(this.username);
        parcel.writeString(this.caption);
    }

    public RandomGif(MediaType mediaType, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, int i4, int i5, String str7, int i6, int i7, String str8, String str9, int i8, int i9, String str10, String str11, int i10, int i11, String str12, String str13) {
        String str14 = str12;
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str14, "username");
        this.type = mediaType;
        this.f177id = str;
        this.url = str2;
        this.imageOriginalUrl = str3;
        this.imageUrl = str4;
        this.imageMp4Url = str5;
        this.imageFrames = i;
        this.imageWidth = i2;
        this.imageHeight = i3;
        this.fixedHeightDownsampledUrl = str6;
        this.fixedHeightDownsampledWidth = i4;
        this.fixedHeightDownsampledHeight = i5;
        this.fixedWidthDownsampledUrl = str7;
        this.fixedWidthDownsampledWidth = i6;
        this.fixedWidthDownsampledHeight = i7;
        this.fixedHeightSmallUrl = str8;
        this.fixedHeightSmallStillUrl = str9;
        this.fixedHeightSmallWidth = i8;
        this.fixedHeightSmallHeight = i9;
        this.fixedWidthSmallUrl = str10;
        this.fixedWidthSmallStillUrl = str11;
        this.fixedWidthSmallWidth = i10;
        this.fixedWidthSmallHeight = i11;
        this.username = str14;
        this.caption = str13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RandomGif(com.giphy.sdk.core.models.enums.MediaType r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, int r37, int r38, java.lang.String r39, int r40, int r41, java.lang.String r42, int r43, int r44, java.lang.String r45, java.lang.String r46, int r47, int r48, java.lang.String r49, java.lang.String r50, int r51, int r52, java.lang.String r53, java.lang.String r54, int r55, kotlin.jvm.internal.DefaultConstructorMarker r56) {
        /*
            r29 = this;
            r0 = r55
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            com.giphy.sdk.core.models.enums.MediaType r1 = (com.giphy.sdk.core.models.enums.MediaType) r1
            r4 = r1
            goto L_0x000e
        L_0x000c:
            r4 = r30
        L_0x000e:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r6 = r1
            goto L_0x0019
        L_0x0017:
            r6 = r32
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0022
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x0024
        L_0x0022:
            r7 = r33
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002d
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r8 = r1
            goto L_0x002f
        L_0x002d:
            r8 = r34
        L_0x002f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0038
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            goto L_0x003a
        L_0x0038:
            r9 = r35
        L_0x003a:
            r1 = r0 & 64
            r3 = 0
            if (r1 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r36
        L_0x0043:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0049
            r11 = 0
            goto L_0x004b
        L_0x0049:
            r11 = r37
        L_0x004b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0051
            r12 = 0
            goto L_0x0053
        L_0x0051:
            r12 = r38
        L_0x0053:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x005c
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r13 = r1
            goto L_0x005e
        L_0x005c:
            r13 = r39
        L_0x005e:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0064
            r14 = 0
            goto L_0x0066
        L_0x0064:
            r14 = r40
        L_0x0066:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006c
            r15 = 0
            goto L_0x006e
        L_0x006c:
            r15 = r41
        L_0x006e:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0078
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r16 = r1
            goto L_0x007a
        L_0x0078:
            r16 = r42
        L_0x007a:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0081
            r17 = 0
            goto L_0x0083
        L_0x0081:
            r17 = r43
        L_0x0083:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x008a
            r18 = 0
            goto L_0x008c
        L_0x008a:
            r18 = r44
        L_0x008c:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0098
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r19 = r1
            goto L_0x009a
        L_0x0098:
            r19 = r45
        L_0x009a:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a5
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r20 = r1
            goto L_0x00a7
        L_0x00a5:
            r20 = r46
        L_0x00a7:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00af
            r21 = 0
            goto L_0x00b1
        L_0x00af:
            r21 = r47
        L_0x00b1:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b9
            r22 = 0
            goto L_0x00bb
        L_0x00b9:
            r22 = r48
        L_0x00bb:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c6
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r23 = r1
            goto L_0x00c8
        L_0x00c6:
            r23 = r49
        L_0x00c8:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d3
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r24 = r1
            goto L_0x00d5
        L_0x00d3:
            r24 = r50
        L_0x00d5:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00dd
            r25 = 0
            goto L_0x00df
        L_0x00dd:
            r25 = r51
        L_0x00df:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e7
            r26 = 0
            goto L_0x00e9
        L_0x00e7:
            r26 = r52
        L_0x00e9:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00f4
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            r28 = r0
            goto L_0x00f6
        L_0x00f4:
            r28 = r54
        L_0x00f6:
            r3 = r29
            r5 = r31
            r27 = r53
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.RandomGif.<init>(com.giphy.sdk.core.models.enums.MediaType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, java.lang.String, int, int, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MediaType getType() {
        return this.type;
    }

    public final String getId() {
        return this.f177id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getImageOriginalUrl() {
        return this.imageOriginalUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImageMp4Url() {
        return this.imageMp4Url;
    }

    public final int getImageFrames() {
        return this.imageFrames;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final String getFixedHeightDownsampledUrl() {
        return this.fixedHeightDownsampledUrl;
    }

    public final int getFixedHeightDownsampledWidth() {
        return this.fixedHeightDownsampledWidth;
    }

    public final int getFixedHeightDownsampledHeight() {
        return this.fixedHeightDownsampledHeight;
    }

    public final String getFixedWidthDownsampledUrl() {
        return this.fixedWidthDownsampledUrl;
    }

    public final int getFixedWidthDownsampledWidth() {
        return this.fixedWidthDownsampledWidth;
    }

    public final int getFixedWidthDownsampledHeight() {
        return this.fixedWidthDownsampledHeight;
    }

    public final String getFixedHeightSmallUrl() {
        return this.fixedHeightSmallUrl;
    }

    public final String getFixedHeightSmallStillUrl() {
        return this.fixedHeightSmallStillUrl;
    }

    public final int getFixedHeightSmallWidth() {
        return this.fixedHeightSmallWidth;
    }

    public final int getFixedHeightSmallHeight() {
        return this.fixedHeightSmallHeight;
    }

    public final String getFixedWidthSmallUrl() {
        return this.fixedWidthSmallUrl;
    }

    public final String getFixedWidthSmallStillUrl() {
        return this.fixedWidthSmallStillUrl;
    }

    public final int getFixedWidthSmallWidth() {
        return this.fixedWidthSmallWidth;
    }

    public final int getFixedWidthSmallHeight() {
        return this.fixedWidthSmallHeight;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Media toGif() {
        String str = this.f177id;
        Images images = r17;
        Images images2 = new Images((Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (String) null, 1048575, (DefaultConstructorMarker) null);
        Media media = r1;
        Media media2 = new Media(str, (MediaType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (RatingType) null, (String) null, (List) null, (List) null, (User) null, images, (String) null, (String) null, (Date) null, (Date) null, (Date) null, (Date) null, false, false, false, false, false, false, false, false, (BottleData) null, (HashMap) null, 2147467262, (DefaultConstructorMarker) null);
        Media media3 = media;
        media3.setType(this.type);
        media3.setUrl(this.url);
        media3.setUser(new User((String) null, (String) null, (String) null, (String) null, this.username, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, false, 524271, (DefaultConstructorMarker) null));
        Images images3 = media3.getImages();
        Image image = r3;
        Image image2 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images3.setOriginal(image);
        Image original = media3.getImages().getOriginal();
        if (original == null) {
            Intrinsics.throwNpe();
        }
        original.setGifUrl(this.imageOriginalUrl);
        Image original2 = media3.getImages().getOriginal();
        if (original2 == null) {
            Intrinsics.throwNpe();
        }
        original2.setMp4Url(this.imageMp4Url);
        Image original3 = media3.getImages().getOriginal();
        if (original3 == null) {
            Intrinsics.throwNpe();
        }
        original3.setFrames(this.imageFrames);
        Image original4 = media3.getImages().getOriginal();
        if (original4 == null) {
            Intrinsics.throwNpe();
        }
        original4.setWidth(this.imageWidth);
        Image original5 = media3.getImages().getOriginal();
        if (original5 == null) {
            Intrinsics.throwNpe();
        }
        original5.setHeight(this.imageHeight);
        Images images4 = media3.getImages();
        Image image3 = r3;
        Image image4 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images4.setFixedHeightDownsampled(image3);
        Image fixedHeightDownsampled = media3.getImages().getFixedHeightDownsampled();
        if (fixedHeightDownsampled == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightDownsampled.setGifUrl(this.fixedHeightDownsampledUrl);
        Image fixedHeightDownsampled2 = media3.getImages().getFixedHeightDownsampled();
        if (fixedHeightDownsampled2 == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightDownsampled2.setWidth(this.fixedHeightDownsampledWidth);
        Image fixedHeightDownsampled3 = media3.getImages().getFixedHeightDownsampled();
        if (fixedHeightDownsampled3 == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightDownsampled3.setHeight(this.fixedHeightDownsampledHeight);
        Images images5 = media3.getImages();
        Image image5 = r3;
        Image image6 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images5.setFixedWidthDownsampled(image5);
        Image fixedWidthDownsampled = media3.getImages().getFixedWidthDownsampled();
        if (fixedWidthDownsampled == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthDownsampled.setGifUrl(this.fixedWidthDownsampledUrl);
        Image fixedWidthDownsampled2 = media3.getImages().getFixedWidthDownsampled();
        if (fixedWidthDownsampled2 == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthDownsampled2.setWidth(this.fixedWidthDownsampledWidth);
        Image fixedWidthDownsampled3 = media3.getImages().getFixedWidthDownsampled();
        if (fixedWidthDownsampled3 == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthDownsampled3.setHeight(this.fixedWidthDownsampledHeight);
        Images images6 = media3.getImages();
        Image image7 = r3;
        Image image8 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images6.setFixedHeightSmall(image7);
        Image fixedHeightSmall = media3.getImages().getFixedHeightSmall();
        if (fixedHeightSmall == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightSmall.setGifUrl(this.fixedHeightSmallUrl);
        Image fixedHeightSmall2 = media3.getImages().getFixedHeightSmall();
        if (fixedHeightSmall2 == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightSmall2.setWidth(this.fixedHeightSmallWidth);
        Image fixedHeightSmall3 = media3.getImages().getFixedHeightSmall();
        if (fixedHeightSmall3 == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightSmall3.setHeight(this.fixedHeightSmallHeight);
        Images images7 = media3.getImages();
        Image image9 = r3;
        Image image10 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images7.setFixedWidthSmall(image9);
        Image fixedWidthSmall = media3.getImages().getFixedWidthSmall();
        if (fixedWidthSmall == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthSmall.setGifUrl(this.fixedWidthSmallUrl);
        Image fixedWidthSmall2 = media3.getImages().getFixedWidthSmall();
        if (fixedWidthSmall2 == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthSmall2.setWidth(this.fixedWidthSmallWidth);
        Image fixedWidthSmall3 = media3.getImages().getFixedWidthSmall();
        if (fixedWidthSmall3 == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthSmall3.setHeight(this.fixedWidthSmallHeight);
        Images images8 = media3.getImages();
        Image image11 = r3;
        Image image12 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images8.setFixedHeightSmallStill(image11);
        Image fixedHeightSmallStill = media3.getImages().getFixedHeightSmallStill();
        if (fixedHeightSmallStill == null) {
            Intrinsics.throwNpe();
        }
        fixedHeightSmallStill.setGifUrl(this.fixedHeightSmallStillUrl);
        Images images9 = media3.getImages();
        Image image13 = r3;
        Image image14 = new Image((String) null, 0, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, (RenditionType) null, 2047, (DefaultConstructorMarker) null);
        images9.setFixedWidthSmallStill(image13);
        Image fixedWidthSmallStill = media3.getImages().getFixedWidthSmallStill();
        if (fixedWidthSmallStill == null) {
            Intrinsics.throwNpe();
        }
        fixedWidthSmallStill.setGifUrl(this.fixedWidthSmallStillUrl);
        return media3;
    }
}
