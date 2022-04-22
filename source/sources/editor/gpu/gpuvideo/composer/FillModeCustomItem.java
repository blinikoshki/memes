package editor.gpu.gpuvideo.composer;

import android.os.Parcel;
import android.os.Parcelable;

public class FillModeCustomItem implements Parcelable {
    public static final Parcelable.Creator<FillModeCustomItem> CREATOR = new Parcelable.Creator<FillModeCustomItem>() {
        public FillModeCustomItem createFromParcel(Parcel parcel) {
            return new FillModeCustomItem(parcel);
        }

        public FillModeCustomItem[] newArray(int i) {
            return new FillModeCustomItem[i];
        }
    };
    private final float rotate;
    private final float scale;
    private final float translateX;
    private final float translateY;
    private final float videoHeight;
    private final float videoWidth;

    public int describeContents() {
        return 0;
    }

    public FillModeCustomItem(float f, float f2, float f3, float f4, float f5, float f6) {
        this.scale = f;
        this.rotate = f2;
        this.translateX = f3;
        this.translateY = f4;
        this.videoWidth = f5;
        this.videoHeight = f6;
    }

    public float getScale() {
        return this.scale;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getTranslateX() {
        return this.translateX;
    }

    public float getTranslateY() {
        return this.translateY;
    }

    public float getVideoWidth() {
        return this.videoWidth;
    }

    public float getVideoHeight() {
        return this.videoHeight;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.scale);
        parcel.writeFloat(this.rotate);
        parcel.writeFloat(this.translateX);
        parcel.writeFloat(this.translateY);
        parcel.writeFloat(this.videoWidth);
        parcel.writeFloat(this.videoHeight);
    }

    protected FillModeCustomItem(Parcel parcel) {
        this.scale = parcel.readFloat();
        this.rotate = parcel.readFloat();
        this.translateX = parcel.readFloat();
        this.translateY = parcel.readFloat();
        this.videoWidth = parcel.readFloat();
        this.videoHeight = parcel.readFloat();
    }
}
