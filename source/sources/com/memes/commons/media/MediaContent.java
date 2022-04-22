package com.memes.commons.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.aspectratio.AspectRatioCalculator;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0018J\u0006\u0010&\u001a\u00020\u0018J\u0006\u0010'\u001a\u00020\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0003J\u0019\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006-"}, mo26107d2 = {"Lcom/memes/commons/media/MediaContent;", "Landroid/os/Parcelable;", "source", "", "contentUrl", "", "width", "height", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContentUrl", "()Ljava/lang/String;", "setContentUrl", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "asFile", "Ljava/io/File;", "aspectRatio", "", "contentType", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/memes/commons/media/MediaContent;", "describeContents", "", "isGif", "", "isGifVideo", "isLocal", "isLocalGif", "isLocalGifVideo", "isLocalPhoto", "isLocalVideo", "isNetworkGif", "isNetworkGifVideo", "isNetworkPhoto", "isNetworkVideo", "isPhoto", "isPlayableVideo", "isRemote", "isVideo", "optimizeContentType", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaContent.kt */
public final class MediaContent implements Parcelable {
    public static final Parcelable.Creator<MediaContent> CREATOR = new Creator();
    private String contentUrl;
    private Integer height;
    private int source;
    private Integer width;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MediaContent> {
        public final MediaContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            Integer num = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new MediaContent(readInt, readString, valueOf, num);
        }

        public final MediaContent[] newArray(int i) {
            return new MediaContent[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.source);
        parcel.writeString(this.contentUrl);
        Integer num = this.width;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.height;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public MediaContent(int i, String str, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "contentUrl");
        this.source = i;
        this.contentUrl = str;
        this.width = num;
        this.height = num2;
        if (!(!StringsKt.isBlank(str))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final void setContentUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaContent(int i, String str, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? 200 : num, (i2 & 8) != 0 ? 200 : num2);
    }

    public final File asFile() {
        return new File(this.contentUrl);
    }

    public final boolean isPhoto() {
        return isLocalPhoto() || isNetworkPhoto();
    }

    public final boolean isLocalPhoto() {
        return this.source == 1231;
    }

    public final boolean isNetworkPhoto() {
        return this.source == 1233;
    }

    public final boolean isVideo() {
        return isLocalVideo() || isNetworkVideo();
    }

    public final boolean isLocalVideo() {
        return this.source == 1232;
    }

    public final boolean isNetworkVideo() {
        return this.source == 1234;
    }

    public final boolean isGifVideo() {
        return isLocalGifVideo() || isNetworkGifVideo();
    }

    public final boolean isLocalGifVideo() {
        return this.source == 1237;
    }

    public final boolean isNetworkGifVideo() {
        return this.source == 1238;
    }

    public final boolean isGif() {
        return isLocalGif() || isNetworkGif();
    }

    public final boolean isLocalGif() {
        return this.source == 1235;
    }

    public final boolean isNetworkGif() {
        return this.source == 1236;
    }

    public final boolean isPlayableVideo() {
        return isLocalVideo() || isLocalGifVideo();
    }

    public final boolean isLocal() {
        return isLocalPhoto() || isLocalGif() || isLocalVideo() || isLocalGifVideo();
    }

    public final boolean isRemote() {
        return isNetworkPhoto() || isNetworkGif() || isNetworkVideo() || isNetworkGifVideo();
    }

    public final int width() {
        Integer num = this.width;
        if (num != null) {
            return num.intValue();
        }
        return 200;
    }

    public final void width(int i) {
        this.width = Integer.valueOf(i);
    }

    public final int height() {
        Integer num = this.height;
        if (num != null) {
            return num.intValue();
        }
        return 200;
    }

    public final void height(int i) {
        this.height = Integer.valueOf(i);
    }

    public final int contentType() {
        return this.source;
    }

    public final void optimizeContentType() {
        int i;
        if (isPhoto()) {
            i = MediaType.PHOTO;
        } else if (isGif()) {
            i = MediaType.GIF;
        } else if (isVideo()) {
            i = MediaType.VIDEO;
        } else {
            i = isGifVideo() ? MediaType.GIFV : 0;
        }
        this.source = i;
    }

    public static /* synthetic */ MediaContent copy$default(MediaContent mediaContent, int i, String str, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mediaContent.source;
        }
        if ((i2 & 2) != 0) {
            str = mediaContent.contentUrl;
        }
        if ((i2 & 4) != 0) {
            num = mediaContent.width;
        }
        if ((i2 & 8) != 0) {
            num2 = mediaContent.height;
        }
        return mediaContent.copy(i, str, num, num2);
    }

    public final MediaContent copy(int i, String str, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "contentUrl");
        return new MediaContent(i, str, num, num2);
    }

    public final float aspectRatio() {
        return AspectRatioCalculator.INSTANCE.calculate(Integer.valueOf(width()), Integer.valueOf(height()));
    }

    public String toString() {
        return "MediaContent(source=" + this.source + ", contentUrl='" + this.contentUrl + "', width=" + this.width + ", height=" + this.height + ')';
    }
}
