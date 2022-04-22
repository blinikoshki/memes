package editor.tools.crop;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, mo26107d2 = {"Leditor/tools/crop/CropBounds;", "Landroid/os/Parcelable;", "cropRect", "Landroid/graphics/Rect;", "sourceWidth", "", "sourceHeight", "rotationDegrees", "(Landroid/graphics/Rect;III)V", "getCropRect", "()Landroid/graphics/Rect;", "getRotationDegrees", "()I", "getSourceHeight", "getSourceWidth", "cropHeight", "cropWidth", "cropX", "cropY", "describeContents", "isCropBoundsSameAsSource", "", "isRotated", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropBounds.kt */
public final class CropBounds implements Parcelable {
    public static final Parcelable.Creator<CropBounds> CREATOR = new Creator();
    private final Rect cropRect;
    private final int rotationDegrees;
    private final int sourceHeight;
    private final int sourceWidth;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CropBounds> {
        public final CropBounds createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CropBounds((Rect) Rect.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final CropBounds[] newArray(int i) {
            return new CropBounds[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.cropRect.writeToParcel(parcel, 0);
        parcel.writeInt(this.sourceWidth);
        parcel.writeInt(this.sourceHeight);
        parcel.writeInt(this.rotationDegrees);
    }

    public CropBounds(Rect rect, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(rect, "cropRect");
        this.cropRect = rect;
        this.sourceWidth = i;
        this.sourceHeight = i2;
        this.rotationDegrees = i3;
    }

    public final Rect getCropRect() {
        return this.cropRect;
    }

    public final int getSourceWidth() {
        return this.sourceWidth;
    }

    public final int getSourceHeight() {
        return this.sourceHeight;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CropBounds(Rect rect, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(rect, i, i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public final int cropX() {
        return this.cropRect.left;
    }

    public final int cropY() {
        return this.cropRect.top;
    }

    public final int cropWidth() {
        return this.cropRect.width();
    }

    public final int cropHeight() {
        return this.cropRect.height();
    }

    public final boolean isRotated() {
        return this.rotationDegrees != 0;
    }

    public final boolean isCropBoundsSameAsSource() {
        return cropWidth() == this.sourceWidth && cropHeight() == this.sourceHeight;
    }
}
