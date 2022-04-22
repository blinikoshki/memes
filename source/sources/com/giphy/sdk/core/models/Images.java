package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u00109\u001a\u00020:HÖ\u0001J\u0006\u0010;\u001a\u00020<J\u0019\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020:HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\"R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\"R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\"R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\"R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001aR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001a¨\u0006A"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/Images;", "Landroid/os/Parcelable;", "fixedHeight", "Lcom/giphy/sdk/core/models/Image;", "fixedHeightStill", "fixedHeightDownsampled", "fixedWidth", "fixedWidthStill", "fixedWidthDownsampled", "fixedHeightSmall", "fixedHeightSmallStill", "fixedWidthSmall", "fixedWidthSmallStill", "downsized", "downsizedStill", "downsizedLarge", "downsizedMedium", "original", "originalStill", "looping", "preview", "downsizedSmall", "mediaId", "", "(Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Lcom/giphy/sdk/core/models/Image;Ljava/lang/String;)V", "getDownsized", "()Lcom/giphy/sdk/core/models/Image;", "getDownsizedLarge", "getDownsizedMedium", "getDownsizedSmall", "getDownsizedStill", "getFixedHeight", "getFixedHeightDownsampled", "setFixedHeightDownsampled", "(Lcom/giphy/sdk/core/models/Image;)V", "getFixedHeightSmall", "setFixedHeightSmall", "getFixedHeightSmallStill", "setFixedHeightSmallStill", "getFixedHeightStill", "getFixedWidth", "getFixedWidthDownsampled", "setFixedWidthDownsampled", "getFixedWidthSmall", "setFixedWidthSmall", "getFixedWidthSmallStill", "setFixedWidthSmallStill", "getFixedWidthStill", "getLooping", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "getOriginal", "setOriginal", "getOriginalStill", "getPreview", "describeContents", "", "postProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Images.kt */
public final class Images implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Image downsized;
    @SerializedName("downsized_large")
    private final Image downsizedLarge;
    @SerializedName("downsized_medium")
    private final Image downsizedMedium;
    @SerializedName("downsized_small")
    private final Image downsizedSmall;
    @SerializedName("downsized_still")
    private final Image downsizedStill;
    @SerializedName("fixed_height")
    private final Image fixedHeight;
    @SerializedName("fixed_height_downsampled")
    private Image fixedHeightDownsampled;
    @SerializedName("fixed_height_small")
    private Image fixedHeightSmall;
    @SerializedName("fixed_height_small_still")
    private Image fixedHeightSmallStill;
    @SerializedName("fixed_height_still")
    private final Image fixedHeightStill;
    @SerializedName("fixed_width")
    private final Image fixedWidth;
    @SerializedName("fixed_width_downsampled")
    private Image fixedWidthDownsampled;
    @SerializedName("fixed_width_small")
    private Image fixedWidthSmall;
    @SerializedName("fixed_width_small_still")
    private Image fixedWidthSmallStill;
    @SerializedName("fixed_width_still")
    private final Image fixedWidthStill;
    private final Image looping;
    private String mediaId;
    private Image original;
    @SerializedName("original_still")
    private final Image originalStill;
    private final Image preview;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkParameterIsNotNull(parcel2, "in");
            return new Images(parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readInt() != 0 ? (Image) Image.CREATOR.createFromParcel(parcel2) : null, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Images[i];
        }
    }

    public Images() {
        this((Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (Image) null, (String) null, 1048575, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Image image = this.fixedHeight;
        if (image != null) {
            parcel.writeInt(1);
            image.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image2 = this.fixedHeightStill;
        if (image2 != null) {
            parcel.writeInt(1);
            image2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image3 = this.fixedHeightDownsampled;
        if (image3 != null) {
            parcel.writeInt(1);
            image3.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image4 = this.fixedWidth;
        if (image4 != null) {
            parcel.writeInt(1);
            image4.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image5 = this.fixedWidthStill;
        if (image5 != null) {
            parcel.writeInt(1);
            image5.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image6 = this.fixedWidthDownsampled;
        if (image6 != null) {
            parcel.writeInt(1);
            image6.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image7 = this.fixedHeightSmall;
        if (image7 != null) {
            parcel.writeInt(1);
            image7.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image8 = this.fixedHeightSmallStill;
        if (image8 != null) {
            parcel.writeInt(1);
            image8.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image9 = this.fixedWidthSmall;
        if (image9 != null) {
            parcel.writeInt(1);
            image9.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image10 = this.fixedWidthSmallStill;
        if (image10 != null) {
            parcel.writeInt(1);
            image10.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image11 = this.downsized;
        if (image11 != null) {
            parcel.writeInt(1);
            image11.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image12 = this.downsizedStill;
        if (image12 != null) {
            parcel.writeInt(1);
            image12.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image13 = this.downsizedLarge;
        if (image13 != null) {
            parcel.writeInt(1);
            image13.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image14 = this.downsizedMedium;
        if (image14 != null) {
            parcel.writeInt(1);
            image14.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image15 = this.original;
        if (image15 != null) {
            parcel.writeInt(1);
            image15.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image16 = this.originalStill;
        if (image16 != null) {
            parcel.writeInt(1);
            image16.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image17 = this.looping;
        if (image17 != null) {
            parcel.writeInt(1);
            image17.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image18 = this.preview;
        if (image18 != null) {
            parcel.writeInt(1);
            image18.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Image image19 = this.downsizedSmall;
        if (image19 != null) {
            parcel.writeInt(1);
            image19.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.mediaId);
    }

    public Images(Image image, Image image2, Image image3, Image image4, Image image5, Image image6, Image image7, Image image8, Image image9, Image image10, Image image11, Image image12, Image image13, Image image14, Image image15, Image image16, Image image17, Image image18, Image image19, String str) {
        this.fixedHeight = image;
        this.fixedHeightStill = image2;
        this.fixedHeightDownsampled = image3;
        this.fixedWidth = image4;
        this.fixedWidthStill = image5;
        this.fixedWidthDownsampled = image6;
        this.fixedHeightSmall = image7;
        this.fixedHeightSmallStill = image8;
        this.fixedWidthSmall = image9;
        this.fixedWidthSmallStill = image10;
        this.downsized = image11;
        this.downsizedStill = image12;
        this.downsizedLarge = image13;
        this.downsizedMedium = image14;
        this.original = image15;
        this.originalStill = image16;
        this.looping = image17;
        this.preview = image18;
        this.downsizedSmall = image19;
        this.mediaId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Images(com.giphy.sdk.core.models.Image r22, com.giphy.sdk.core.models.Image r23, com.giphy.sdk.core.models.Image r24, com.giphy.sdk.core.models.Image r25, com.giphy.sdk.core.models.Image r26, com.giphy.sdk.core.models.Image r27, com.giphy.sdk.core.models.Image r28, com.giphy.sdk.core.models.Image r29, com.giphy.sdk.core.models.Image r30, com.giphy.sdk.core.models.Image r31, com.giphy.sdk.core.models.Image r32, com.giphy.sdk.core.models.Image r33, com.giphy.sdk.core.models.Image r34, com.giphy.sdk.core.models.Image r35, com.giphy.sdk.core.models.Image r36, com.giphy.sdk.core.models.Image r37, com.giphy.sdk.core.models.Image r38, com.giphy.sdk.core.models.Image r39, com.giphy.sdk.core.models.Image r40, java.lang.String r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            com.giphy.sdk.core.models.Image r1 = (com.giphy.sdk.core.models.Image) r1
            goto L_0x000d
        L_0x000b:
            r1 = r22
        L_0x000d:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            r3 = r2
            com.giphy.sdk.core.models.Image r3 = (com.giphy.sdk.core.models.Image) r3
            goto L_0x0017
        L_0x0015:
            r3 = r23
        L_0x0017:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001f
            r4 = r2
            com.giphy.sdk.core.models.Image r4 = (com.giphy.sdk.core.models.Image) r4
            goto L_0x0021
        L_0x001f:
            r4 = r24
        L_0x0021:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0029
            r5 = r2
            com.giphy.sdk.core.models.Image r5 = (com.giphy.sdk.core.models.Image) r5
            goto L_0x002b
        L_0x0029:
            r5 = r25
        L_0x002b:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0033
            r6 = r2
            com.giphy.sdk.core.models.Image r6 = (com.giphy.sdk.core.models.Image) r6
            goto L_0x0035
        L_0x0033:
            r6 = r26
        L_0x0035:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003d
            r7 = r2
            com.giphy.sdk.core.models.Image r7 = (com.giphy.sdk.core.models.Image) r7
            goto L_0x003f
        L_0x003d:
            r7 = r27
        L_0x003f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0047
            r8 = r2
            com.giphy.sdk.core.models.Image r8 = (com.giphy.sdk.core.models.Image) r8
            goto L_0x0049
        L_0x0047:
            r8 = r28
        L_0x0049:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0051
            r9 = r2
            com.giphy.sdk.core.models.Image r9 = (com.giphy.sdk.core.models.Image) r9
            goto L_0x0053
        L_0x0051:
            r9 = r29
        L_0x0053:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x005b
            r10 = r2
            com.giphy.sdk.core.models.Image r10 = (com.giphy.sdk.core.models.Image) r10
            goto L_0x005d
        L_0x005b:
            r10 = r30
        L_0x005d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0065
            r11 = r2
            com.giphy.sdk.core.models.Image r11 = (com.giphy.sdk.core.models.Image) r11
            goto L_0x0067
        L_0x0065:
            r11 = r31
        L_0x0067:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006f
            r12 = r2
            com.giphy.sdk.core.models.Image r12 = (com.giphy.sdk.core.models.Image) r12
            goto L_0x0071
        L_0x006f:
            r12 = r32
        L_0x0071:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0079
            r13 = r2
            com.giphy.sdk.core.models.Image r13 = (com.giphy.sdk.core.models.Image) r13
            goto L_0x007b
        L_0x0079:
            r13 = r33
        L_0x007b:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0083
            r14 = r2
            com.giphy.sdk.core.models.Image r14 = (com.giphy.sdk.core.models.Image) r14
            goto L_0x0085
        L_0x0083:
            r14 = r34
        L_0x0085:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x008d
            r15 = r2
            com.giphy.sdk.core.models.Image r15 = (com.giphy.sdk.core.models.Image) r15
            goto L_0x008f
        L_0x008d:
            r15 = r35
        L_0x008f:
            r43 = r15
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0099
            r15 = r2
            com.giphy.sdk.core.models.Image r15 = (com.giphy.sdk.core.models.Image) r15
            goto L_0x009b
        L_0x0099:
            r15 = r36
        L_0x009b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00a7
            r16 = r2
            com.giphy.sdk.core.models.Image r16 = (com.giphy.sdk.core.models.Image) r16
            goto L_0x00a9
        L_0x00a7:
            r16 = r37
        L_0x00a9:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00b4
            r17 = r2
            com.giphy.sdk.core.models.Image r17 = (com.giphy.sdk.core.models.Image) r17
            goto L_0x00b6
        L_0x00b4:
            r17 = r38
        L_0x00b6:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00c1
            r18 = r2
            com.giphy.sdk.core.models.Image r18 = (com.giphy.sdk.core.models.Image) r18
            goto L_0x00c3
        L_0x00c1:
            r18 = r39
        L_0x00c3:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00ce
            r19 = r2
            com.giphy.sdk.core.models.Image r19 = (com.giphy.sdk.core.models.Image) r19
            goto L_0x00d0
        L_0x00ce:
            r19 = r40
        L_0x00d0:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00da
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00dc
        L_0x00da:
            r0 = r41
        L_0x00dc:
            r22 = r21
            r23 = r1
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r43
            r37 = r15
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.Images.<init>(com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, com.giphy.sdk.core.models.Image, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Image getFixedHeight() {
        return this.fixedHeight;
    }

    public final Image getFixedHeightStill() {
        return this.fixedHeightStill;
    }

    public final Image getFixedHeightDownsampled() {
        return this.fixedHeightDownsampled;
    }

    public final void setFixedHeightDownsampled(Image image) {
        this.fixedHeightDownsampled = image;
    }

    public final Image getFixedWidth() {
        return this.fixedWidth;
    }

    public final Image getFixedWidthStill() {
        return this.fixedWidthStill;
    }

    public final Image getFixedWidthDownsampled() {
        return this.fixedWidthDownsampled;
    }

    public final void setFixedWidthDownsampled(Image image) {
        this.fixedWidthDownsampled = image;
    }

    public final Image getFixedHeightSmall() {
        return this.fixedHeightSmall;
    }

    public final void setFixedHeightSmall(Image image) {
        this.fixedHeightSmall = image;
    }

    public final Image getFixedHeightSmallStill() {
        return this.fixedHeightSmallStill;
    }

    public final void setFixedHeightSmallStill(Image image) {
        this.fixedHeightSmallStill = image;
    }

    public final Image getFixedWidthSmall() {
        return this.fixedWidthSmall;
    }

    public final void setFixedWidthSmall(Image image) {
        this.fixedWidthSmall = image;
    }

    public final Image getFixedWidthSmallStill() {
        return this.fixedWidthSmallStill;
    }

    public final void setFixedWidthSmallStill(Image image) {
        this.fixedWidthSmallStill = image;
    }

    public final Image getDownsized() {
        return this.downsized;
    }

    public final Image getDownsizedStill() {
        return this.downsizedStill;
    }

    public final Image getDownsizedLarge() {
        return this.downsizedLarge;
    }

    public final Image getDownsizedMedium() {
        return this.downsizedMedium;
    }

    public final Image getOriginal() {
        return this.original;
    }

    public final void setOriginal(Image image) {
        this.original = image;
    }

    public final Image getOriginalStill() {
        return this.originalStill;
    }

    public final Image getLooping() {
        return this.looping;
    }

    public final Image getPreview() {
        return this.preview;
    }

    public final Image getDownsizedSmall() {
        return this.downsizedSmall;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final void setMediaId(String str) {
        this.mediaId = str;
    }

    public final void postProcess() {
        Image image = this.original;
        if (image != null) {
            if (image == null) {
                Intrinsics.throwNpe();
            }
            image.setMediaId(this.mediaId);
            Image image2 = this.original;
            if (image2 == null) {
                Intrinsics.throwNpe();
            }
            image2.setRenditionType(RenditionType.original);
        }
        Image image3 = this.originalStill;
        if (image3 != null) {
            image3.setMediaId(this.mediaId);
            this.originalStill.setRenditionType(RenditionType.originalStill);
        }
        Image image4 = this.fixedHeight;
        if (image4 != null) {
            image4.setMediaId(this.mediaId);
            this.fixedHeight.setRenditionType(RenditionType.fixedHeight);
        }
        Image image5 = this.fixedHeightStill;
        if (image5 != null) {
            image5.setMediaId(this.mediaId);
            this.fixedHeightStill.setRenditionType(RenditionType.fixedHeightStill);
        }
        Image image6 = this.fixedHeightDownsampled;
        if (image6 != null) {
            if (image6 == null) {
                Intrinsics.throwNpe();
            }
            image6.setMediaId(this.mediaId);
            Image image7 = this.fixedHeightDownsampled;
            if (image7 == null) {
                Intrinsics.throwNpe();
            }
            image7.setRenditionType(RenditionType.fixedHeightDownsampled);
        }
        Image image8 = this.fixedWidth;
        if (image8 != null) {
            image8.setMediaId(this.mediaId);
            this.fixedWidth.setRenditionType(RenditionType.fixedWidth);
        }
        Image image9 = this.fixedWidthStill;
        if (image9 != null) {
            image9.setMediaId(this.mediaId);
            this.fixedWidthStill.setRenditionType(RenditionType.fixedWidthStill);
        }
        Image image10 = this.fixedWidthDownsampled;
        if (image10 != null) {
            if (image10 == null) {
                Intrinsics.throwNpe();
            }
            image10.setMediaId(this.mediaId);
            Image image11 = this.fixedWidthDownsampled;
            if (image11 == null) {
                Intrinsics.throwNpe();
            }
            image11.setRenditionType(RenditionType.fixedWidthDownsampled);
        }
        Image image12 = this.fixedHeightSmall;
        if (image12 != null) {
            if (image12 == null) {
                Intrinsics.throwNpe();
            }
            image12.setMediaId(this.mediaId);
            Image image13 = this.fixedHeightSmall;
            if (image13 == null) {
                Intrinsics.throwNpe();
            }
            image13.setRenditionType(RenditionType.fixedHeightSmall);
        }
        Image image14 = this.fixedHeightSmallStill;
        if (image14 != null) {
            if (image14 == null) {
                Intrinsics.throwNpe();
            }
            image14.setMediaId(this.mediaId);
            Image image15 = this.fixedHeightSmallStill;
            if (image15 == null) {
                Intrinsics.throwNpe();
            }
            image15.setRenditionType(RenditionType.fixedHeightSmallStill);
        }
        Image image16 = this.fixedWidthSmall;
        if (image16 != null) {
            if (image16 == null) {
                Intrinsics.throwNpe();
            }
            image16.setMediaId(this.mediaId);
            Image image17 = this.fixedWidthSmall;
            if (image17 == null) {
                Intrinsics.throwNpe();
            }
            image17.setRenditionType(RenditionType.fixedWidthSmall);
        }
        Image image18 = this.fixedWidthSmallStill;
        if (image18 != null) {
            if (image18 == null) {
                Intrinsics.throwNpe();
            }
            image18.setMediaId(this.mediaId);
            Image image19 = this.fixedWidthSmallStill;
            if (image19 == null) {
                Intrinsics.throwNpe();
            }
            image19.setRenditionType(RenditionType.fixedWidthSmallStill);
        }
        Image image20 = this.downsized;
        if (image20 != null) {
            image20.setMediaId(this.mediaId);
            this.downsized.setRenditionType(RenditionType.downsized);
        }
        Image image21 = this.downsizedStill;
        if (image21 != null) {
            image21.setMediaId(this.mediaId);
            this.downsizedStill.setRenditionType(RenditionType.downsizedStill);
        }
        Image image22 = this.downsizedLarge;
        if (image22 != null) {
            image22.setMediaId(this.mediaId);
            this.downsizedLarge.setRenditionType(RenditionType.downsizedLarge);
        }
        Image image23 = this.downsizedMedium;
        if (image23 != null) {
            image23.setMediaId(this.mediaId);
            this.downsizedMedium.setRenditionType(RenditionType.downsizedMedium);
        }
        Image image24 = this.looping;
        if (image24 != null) {
            image24.setMediaId(this.mediaId);
            this.looping.setRenditionType(RenditionType.looping);
        }
        Image image25 = this.preview;
        if (image25 != null) {
            image25.setMediaId(this.mediaId);
            this.preview.setRenditionType(RenditionType.preview);
        }
        Image image26 = this.downsizedSmall;
        if (image26 != null) {
            image26.setMediaId(this.mediaId);
            this.downsizedSmall.setRenditionType(RenditionType.downsizedSmall);
        }
    }
}
