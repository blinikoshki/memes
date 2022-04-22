package editor.editor.dashboard.drafts;

import com.appsflyer.ServerParameters;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006-"}, mo26107d2 = {"Leditor/editor/dashboard/drafts/EditorDraft;", "", "uid", "", "thumbnailPath", "frameWidth", "", "frameHeight", "timestamp", "", "textStyles", "", "Leditor/editor/equipment/text/TextStyle;", "mediaStyles", "Leditor/editor/equipment/media/MediaStyle;", "frameStyle", "Leditor/editor/equipment/frame/FrameStyle;", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/util/List;Ljava/util/List;Leditor/editor/equipment/frame/FrameStyle;)V", "getFrameHeight", "()I", "getFrameStyle", "()Leditor/editor/equipment/frame/FrameStyle;", "getFrameWidth", "getMediaStyles", "()Ljava/util/List;", "getTextStyles", "getThumbnailPath", "()Ljava/lang/String;", "getTimestamp", "()J", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraft.kt */
public final class EditorDraft {
    private final int frameHeight;
    private final FrameStyle frameStyle;
    private final int frameWidth;
    private final List<MediaStyle> mediaStyles;
    private final List<TextStyle> textStyles;
    private final String thumbnailPath;
    private final long timestamp;
    private final String uid;

    public static /* synthetic */ EditorDraft copy$default(EditorDraft editorDraft, String str, String str2, int i, int i2, long j, List list, List list2, FrameStyle frameStyle2, int i3, Object obj) {
        EditorDraft editorDraft2 = editorDraft;
        int i4 = i3;
        return editorDraft.copy((i4 & 1) != 0 ? editorDraft2.uid : str, (i4 & 2) != 0 ? editorDraft2.thumbnailPath : str2, (i4 & 4) != 0 ? editorDraft2.frameWidth : i, (i4 & 8) != 0 ? editorDraft2.frameHeight : i2, (i4 & 16) != 0 ? editorDraft2.timestamp : j, (i4 & 32) != 0 ? editorDraft2.textStyles : list, (i4 & 64) != 0 ? editorDraft2.mediaStyles : list2, (i4 & 128) != 0 ? editorDraft2.frameStyle : frameStyle2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.thumbnailPath;
    }

    public final int component3() {
        return this.frameWidth;
    }

    public final int component4() {
        return this.frameHeight;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final List<TextStyle> component6() {
        return this.textStyles;
    }

    public final List<MediaStyle> component7() {
        return this.mediaStyles;
    }

    public final FrameStyle component8() {
        return this.frameStyle;
    }

    public final EditorDraft copy(String str, String str2, int i, int i2, long j, List<TextStyle> list, List<MediaStyle> list2, FrameStyle frameStyle2) {
        Intrinsics.checkNotNullParameter(str, ServerParameters.AF_USER_ID);
        return new EditorDraft(str, str2, i, i2, j, list, list2, frameStyle2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditorDraft)) {
            return false;
        }
        EditorDraft editorDraft = (EditorDraft) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) editorDraft.uid) && Intrinsics.areEqual((Object) this.thumbnailPath, (Object) editorDraft.thumbnailPath) && this.frameWidth == editorDraft.frameWidth && this.frameHeight == editorDraft.frameHeight && this.timestamp == editorDraft.timestamp && Intrinsics.areEqual((Object) this.textStyles, (Object) editorDraft.textStyles) && Intrinsics.areEqual((Object) this.mediaStyles, (Object) editorDraft.mediaStyles) && Intrinsics.areEqual((Object) this.frameStyle, (Object) editorDraft.frameStyle);
    }

    public int hashCode() {
        String str = this.uid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.thumbnailPath;
        int hashCode2 = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.frameWidth) * 31) + this.frameHeight) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.timestamp)) * 31;
        List<TextStyle> list = this.textStyles;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<MediaStyle> list2 = this.mediaStyles;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        FrameStyle frameStyle2 = this.frameStyle;
        if (frameStyle2 != null) {
            i = frameStyle2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "EditorDraft(uid=" + this.uid + ", thumbnailPath=" + this.thumbnailPath + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", timestamp=" + this.timestamp + ", textStyles=" + this.textStyles + ", mediaStyles=" + this.mediaStyles + ", frameStyle=" + this.frameStyle + ")";
    }

    public EditorDraft(String str, String str2, int i, int i2, long j, List<TextStyle> list, List<MediaStyle> list2, FrameStyle frameStyle2) {
        Intrinsics.checkNotNullParameter(str, ServerParameters.AF_USER_ID);
        this.uid = str;
        this.thumbnailPath = str2;
        this.frameWidth = i;
        this.frameHeight = i2;
        this.timestamp = j;
        this.textStyles = list;
        this.mediaStyles = list2;
        this.frameStyle = frameStyle2;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public final int getFrameWidth() {
        return this.frameWidth;
    }

    public final int getFrameHeight() {
        return this.frameHeight;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final List<TextStyle> getTextStyles() {
        return this.textStyles;
    }

    public final List<MediaStyle> getMediaStyles() {
        return this.mediaStyles;
    }

    public final FrameStyle getFrameStyle() {
        return this.frameStyle;
    }
}
