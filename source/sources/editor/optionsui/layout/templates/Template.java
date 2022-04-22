package editor.optionsui.layout.templates;

import android.os.Parcel;
import android.os.Parcelable;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaType;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo26107d2 = {"Leditor/optionsui/layout/templates/Template;", "Landroid/os/Parcelable;", "id", "", "thumbnailPath", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;II)V", "getHeight", "()I", "getId", "()Ljava/lang/String;", "getThumbnailPath", "getWidth", "aspectRatio", "", "describeContents", "toEditorDraft", "Leditor/editor/dashboard/drafts/EditorDraft;", "toPhotoMediaContent", "Lcom/memes/commons/media/MediaContent;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Template.kt */
public final class Template implements Parcelable {
    public static final Parcelable.Creator<Template> CREATOR = new Creator();
    private final int height;

    /* renamed from: id */
    private final String f1434id;
    private final String thumbnailPath;
    private final int width;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Template> {
        public final Template createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Template(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        public final Template[] newArray(int i) {
            return new Template[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f1434id);
        parcel.writeString(this.thumbnailPath);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public Template(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "thumbnailPath");
        this.f1434id = str;
        this.thumbnailPath = str2;
        this.width = i;
        this.height = i2;
    }

    public final String getId() {
        return this.f1434id;
    }

    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float aspectRatio() {
        return ((float) this.width) / ((float) this.height);
    }

    public final MediaContent toPhotoMediaContent() {
        return new MediaContent(MediaType.PHOTO, this.thumbnailPath, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public final EditorDraft toEditorDraft() {
        MediaStyle mediaStyle = new MediaStyle();
        mediaStyle.setContent(toPhotoMediaContent());
        mediaStyle.getMetadata().update(100.0f, 100.0f, 50.0f, 50.0f);
        FrameStyle frameStyle = new FrameStyle();
        frameStyle.setAspectRatio(aspectRatio());
        return new EditorDraft(this.f1434id, this.thumbnailPath, this.width, this.height, System.currentTimeMillis(), (List<TextStyle>) null, CollectionsKt.listOf(mediaStyle), frameStyle);
    }
}
