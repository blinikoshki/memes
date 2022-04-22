package com.memes.commons.media;

import com.memes.commons.aspectratio.AspectRatioCalculator;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/commons/media/MediaFile;", "Ljava/io/File;", "path", "", "width", "", "height", "type", "(Ljava/lang/String;III)V", "aspectRatio", "", "getAspectRatio", "()F", "getHeight", "()I", "thumbnail", "getThumbnail", "()Ljava/lang/String;", "setThumbnail", "(Ljava/lang/String;)V", "getType", "getWidth", "toMediaContent", "Lcom/memes/commons/media/MediaContent;", "toString", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaFile.kt */
public final class MediaFile extends File {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float aspectRatio;
    private final int height;
    private String thumbnail;
    private final int type;
    private final int width;

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaFile(String str, int i, int i2, int i3) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "path");
        this.width = i;
        this.height = i2;
        this.type = i3;
        this.aspectRatio = AspectRatioCalculator.INSTANCE.calculate(Integer.valueOf(i), Integer.valueOf(i2));
        String absolutePath = getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
        this.thumbnail = absolutePath;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/media/MediaFile$Companion;", "", "()V", "from", "Lcom/memes/commons/media/MediaFile;", "content", "Lcom/memes/commons/media/MediaContent;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaFile.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaFile from(MediaContent mediaContent) {
            Intrinsics.checkNotNullParameter(mediaContent, "content");
            mediaContent.optimizeContentType();
            return new MediaFile(mediaContent.getContentUrl(), mediaContent.width(), mediaContent.height(), mediaContent.contentType());
        }
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbnail = str;
    }

    public final MediaContent toMediaContent() {
        int i = this.type;
        String path = getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return new MediaContent(i, path, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public String toString() {
        return "MediaFile(" + getPath() + ", " + this.type + ", " + this.width + ", " + this.height + ')';
    }
}
