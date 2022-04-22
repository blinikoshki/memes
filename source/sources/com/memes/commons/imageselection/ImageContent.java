package com.memes.commons.imageselection;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.media.MediaFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/commons/imageselection/ImageContent;", "Landroid/os/Parcelable;", "source", "Lcom/memes/commons/imageselection/ImageSource;", "file", "Lcom/memes/commons/media/MediaFile;", "(Lcom/memes/commons/imageselection/ImageSource;Lcom/memes/commons/media/MediaFile;)V", "getFile", "()Lcom/memes/commons/media/MediaFile;", "setFile", "(Lcom/memes/commons/media/MediaFile;)V", "getSource", "()Lcom/memes/commons/imageselection/ImageSource;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImageContent.kt */
public final class ImageContent implements Parcelable {
    public static final Parcelable.Creator<ImageContent> CREATOR = new Creator();
    private MediaFile file;
    private final ImageSource source;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ImageContent> {
        public final ImageContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ImageContent((ImageSource) Enum.valueOf(ImageSource.class, parcel.readString()), (MediaFile) parcel.readSerializable());
        }

        public final ImageContent[] newArray(int i) {
            return new ImageContent[i];
        }
    }

    public static /* synthetic */ ImageContent copy$default(ImageContent imageContent, ImageSource imageSource, MediaFile mediaFile, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = imageContent.source;
        }
        if ((i & 2) != 0) {
            mediaFile = imageContent.file;
        }
        return imageContent.copy(imageSource, mediaFile);
    }

    public final ImageSource component1() {
        return this.source;
    }

    public final MediaFile component2() {
        return this.file;
    }

    public final ImageContent copy(ImageSource imageSource, MediaFile mediaFile) {
        Intrinsics.checkNotNullParameter(imageSource, "source");
        Intrinsics.checkNotNullParameter(mediaFile, "file");
        return new ImageContent(imageSource, mediaFile);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageContent)) {
            return false;
        }
        ImageContent imageContent = (ImageContent) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) imageContent.source) && Intrinsics.areEqual((Object) this.file, (Object) imageContent.file);
    }

    public int hashCode() {
        ImageSource imageSource = this.source;
        int i = 0;
        int hashCode = (imageSource != null ? imageSource.hashCode() : 0) * 31;
        MediaFile mediaFile = this.file;
        if (mediaFile != null) {
            i = mediaFile.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ImageContent(source=" + this.source + ", file=" + this.file + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.source.name());
        parcel.writeSerializable(this.file);
    }

    public ImageContent(ImageSource imageSource, MediaFile mediaFile) {
        Intrinsics.checkNotNullParameter(imageSource, "source");
        Intrinsics.checkNotNullParameter(mediaFile, "file");
        this.source = imageSource;
        this.file = mediaFile;
    }

    public final ImageSource getSource() {
        return this.source;
    }

    public final MediaFile getFile() {
        return this.file;
    }

    public final void setFile(MediaFile mediaFile) {
        Intrinsics.checkNotNullParameter(mediaFile, "<set-?>");
        this.file = mediaFile;
    }
}
