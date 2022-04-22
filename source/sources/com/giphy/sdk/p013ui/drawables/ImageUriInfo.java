package com.giphy.sdk.p013ui.drawables;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/ImageUriInfo;", "Landroid/os/Parcelable;", "uri", "Landroid/net/Uri;", "size", "", "imageFormat", "Lcom/giphy/sdk/ui/drawables/ImageFormat;", "(Landroid/net/Uri;ILcom/giphy/sdk/ui/drawables/ImageFormat;)V", "getImageFormat", "()Lcom/giphy/sdk/ui/drawables/ImageFormat;", "getSize", "()I", "getUri", "()Landroid/net/Uri;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.ImageUriInfo */
/* compiled from: ImageUriInfo.kt */
public final class ImageUriInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final ImageFormat imageFormat;
    private final int size;
    private final Uri uri;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.drawables.ImageUriInfo$Creator */
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new ImageUriInfo((Uri) parcel.readParcelable(ImageUriInfo.class.getClassLoader()), parcel.readInt(), (ImageFormat) Enum.valueOf(ImageFormat.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new ImageUriInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(this.uri, i);
        parcel.writeInt(this.size);
        parcel.writeString(this.imageFormat.name());
    }

    public ImageUriInfo(Uri uri2, int i, ImageFormat imageFormat2) {
        Intrinsics.checkParameterIsNotNull(uri2, ShareConstants.MEDIA_URI);
        Intrinsics.checkParameterIsNotNull(imageFormat2, DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        this.uri = uri2;
        this.size = i;
        this.imageFormat = imageFormat2;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getSize() {
        return this.size;
    }

    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }
}
