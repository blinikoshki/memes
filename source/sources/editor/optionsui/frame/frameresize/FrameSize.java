package editor.optionsui.frame.frameresize;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006."}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSize;", "Landroid/os/Parcelable;", "title", "", "width", "", "height", "type", "Leditor/optionsui/frame/frameresize/FrameSizeType;", "thumbName", "(Ljava/lang/String;FFLeditor/optionsui/frame/frameresize/FrameSizeType;Ljava/lang/String;)V", "getHeight", "()F", "getThumbName", "()Ljava/lang/String;", "getTitle", "getType", "()Leditor/optionsui/frame/frameresize/FrameSizeType;", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isDefaultCustomSize", "isLandscape", "isPortrait", "isSquare", "isValid", "ratio", "subtitle", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameSize.kt */
public final class FrameSize implements Parcelable {
    public static final Parcelable.Creator<FrameSize> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FrameSize DEFAULT_CUSTOM_FRAME_SIZE = new FrameSize("Custom", 512.0001f, 512.0f, FrameSizeType.CUSTOM, (String) null, 16, (DefaultConstructorMarker) null);
    @SerializedName("height")
    @Expose
    private final float height;
    @SerializedName("thumb_name")
    @Expose
    private final String thumbName;
    @SerializedName("title")
    @Expose
    private final String title;
    @SerializedName("type")
    @Expose
    private final FrameSizeType type;
    @SerializedName("width")
    @Expose
    private final float width;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FrameSize> {
        public final FrameSize createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FrameSize(parcel.readString(), parcel.readFloat(), parcel.readFloat(), (FrameSizeType) Enum.valueOf(FrameSizeType.class, parcel.readString()), parcel.readString());
        }

        public final FrameSize[] newArray(int i) {
            return new FrameSize[i];
        }
    }

    public static /* synthetic */ FrameSize copy$default(FrameSize frameSize, String str, float f, float f2, FrameSizeType frameSizeType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = frameSize.title;
        }
        if ((i & 2) != 0) {
            f = frameSize.width;
        }
        float f3 = f;
        if ((i & 4) != 0) {
            f2 = frameSize.height;
        }
        float f4 = f2;
        if ((i & 8) != 0) {
            frameSizeType = frameSize.type;
        }
        FrameSizeType frameSizeType2 = frameSizeType;
        if ((i & 16) != 0) {
            str2 = frameSize.thumbName;
        }
        return frameSize.copy(str, f3, f4, frameSizeType2, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final float component2() {
        return this.width;
    }

    public final float component3() {
        return this.height;
    }

    public final FrameSizeType component4() {
        return this.type;
    }

    public final String component5() {
        return this.thumbName;
    }

    public final FrameSize copy(String str, float f, float f2, FrameSizeType frameSizeType, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(frameSizeType, "type");
        return new FrameSize(str, f, f2, frameSizeType, str2);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FrameSize(title=" + this.title + ", width=" + this.width + ", height=" + this.height + ", type=" + this.type + ", thumbName=" + this.thumbName + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeString(this.type.name());
        parcel.writeString(this.thumbName);
    }

    public FrameSize(String str, float f, float f2, FrameSizeType frameSizeType, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(frameSizeType, "type");
        this.title = str;
        this.width = f;
        this.height = f2;
        this.type = frameSizeType;
        this.thumbName = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final FrameSizeType getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameSize(String str, float f, float f2, FrameSizeType frameSizeType, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, f2, frameSizeType, (i & 16) != 0 ? null : str2);
    }

    public final String getThumbName() {
        return this.thumbName;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSize$Companion;", "", "()V", "DEFAULT_CUSTOM_FRAME_SIZE", "Leditor/optionsui/frame/frameresize/FrameSize;", "getDEFAULT_CUSTOM_FRAME_SIZE", "()Leditor/optionsui/frame/frameresize/FrameSize;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FrameSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FrameSize getDEFAULT_CUSTOM_FRAME_SIZE() {
            return FrameSize.DEFAULT_CUSTOM_FRAME_SIZE;
        }
    }

    public final boolean isDefaultCustomSize() {
        return Intrinsics.areEqual((Object) this, (Object) DEFAULT_CUSTOM_FRAME_SIZE);
    }

    public final boolean isValid() {
        float f = (float) 0;
        return this.width > f && this.height > f;
    }

    public final boolean isSquare() {
        return MathKt.roundToInt(this.width) == MathKt.roundToInt(this.height);
    }

    public final boolean isPortrait() {
        return this.width < this.height;
    }

    public final boolean isLandscape() {
        return this.width > this.height;
    }

    public final float ratio() {
        if (!isValid()) {
            return 1.0f;
        }
        return this.width / this.height;
    }

    public final String subtitle() {
        float f = (float) 0;
        if (this.width <= f || this.height <= f) {
            return "";
        }
        return MathKt.roundToInt(this.width) + " x " + MathKt.roundToInt(this.height);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type editor.optionsui.frame.frameresize.FrameSize");
        FrameSize frameSize = (FrameSize) obj;
        if (this.width == frameSize.width && this.height == frameSize.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
    }
}
