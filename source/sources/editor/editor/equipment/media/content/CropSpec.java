package editor.editor.equipment.media.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentKt;
import editor.tools.crop.CropBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0000J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\f\u001a\u00020\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/equipment/media/content/CropSpec;", "Landroid/os/Parcelable;", "content", "Lcom/memes/commons/media/MediaContent;", "cropBounds", "Leditor/tools/crop/CropBounds;", "(Lcom/memes/commons/media/MediaContent;Leditor/tools/crop/CropBounds;)V", "contentExists", "", "copy", "describeContents", "", "getContent", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropSpec.kt */
public final class CropSpec implements Parcelable {
    public static final Parcelable.Creator<CropSpec> CREATOR = new Creator();
    private final MediaContent content;
    private final CropBounds cropBounds;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CropSpec> {
        public final CropSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CropSpec((MediaContent) parcel.readParcelable(CropSpec.class.getClassLoader()), parcel.readInt() != 0 ? CropBounds.CREATOR.createFromParcel(parcel) : null);
        }

        public final CropSpec[] newArray(int i) {
            return new CropSpec[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.content, i);
        CropBounds cropBounds2 = this.cropBounds;
        if (cropBounds2 != null) {
            parcel.writeInt(1);
            cropBounds2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public CropSpec(MediaContent mediaContent, CropBounds cropBounds2) {
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        this.content = mediaContent;
        this.cropBounds = cropBounds2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CropSpec(MediaContent mediaContent, CropBounds cropBounds2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaContent, (i & 2) != 0 ? null : cropBounds2);
    }

    public final MediaContent getContent() {
        return this.content;
    }

    public final boolean contentExists() {
        return MediaContentKt.exists(this.content);
    }

    public final CropSpec copy() {
        return new CropSpec(MediaContent.copy$default(this.content, 0, (String) null, (Integer) null, (Integer) null, 15, (Object) null), (CropBounds) null, 2, (DefaultConstructorMarker) null);
    }

    public String toString() {
        return "CropSpec(content=" + this.content + ", cropBounds=" + this.cropBounds + ')';
    }
}
