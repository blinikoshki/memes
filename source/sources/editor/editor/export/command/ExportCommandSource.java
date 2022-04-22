package editor.editor.export.command;

import editor.editor.export.regions.FileRegion;
import editor.editor.export.regions.FrameRegion;
import editor.editor.export.regions.OverlayRegion;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cJ\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006)"}, mo26107d2 = {"Leditor/editor/export/command/ExportCommandSource;", "", "()V", "container", "Leditor/editor/export/regions/FileRegion;", "getContainer", "()Leditor/editor/export/regions/FileRegion;", "setContainer", "(Leditor/editor/export/regions/FileRegion;)V", "content", "Leditor/editor/export/regions/FrameRegion;", "getContent", "()Leditor/editor/export/regions/FrameRegion;", "setContent", "(Leditor/editor/export/regions/FrameRegion;)V", "endTimeoutMillis", "", "getEndTimeoutMillis", "()J", "setEndTimeoutMillis", "(J)V", "isImageOutput", "", "()Z", "setImageOutput", "(Z)V", "overlayRegions", "", "Leditor/editor/export/regions/OverlayRegion;", "getOverlayRegions", "()Ljava/util/List;", "setOverlayRegions", "(Ljava/util/List;)V", "watermark", "getWatermark", "setWatermark", "addOverlayRegion", "", "region", "hasEndTimeoutMillis", "hasWatermark", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ExportCommandSource.kt */
public final class ExportCommandSource {
    private FileRegion container = new FileRegion();
    private FrameRegion content = new FrameRegion();
    private long endTimeoutMillis = -1;
    private boolean isImageOutput;
    private List<OverlayRegion> overlayRegions = new ArrayList();
    private FileRegion watermark = new FileRegion();

    public final List<OverlayRegion> getOverlayRegions() {
        return this.overlayRegions;
    }

    public final void setOverlayRegions(List<OverlayRegion> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.overlayRegions = list;
    }

    public final FileRegion getContainer() {
        return this.container;
    }

    public final void setContainer(FileRegion fileRegion) {
        Intrinsics.checkNotNullParameter(fileRegion, "<set-?>");
        this.container = fileRegion;
    }

    public final FrameRegion getContent() {
        return this.content;
    }

    public final void setContent(FrameRegion frameRegion) {
        Intrinsics.checkNotNullParameter(frameRegion, "<set-?>");
        this.content = frameRegion;
    }

    public final FileRegion getWatermark() {
        return this.watermark;
    }

    public final void setWatermark(FileRegion fileRegion) {
        Intrinsics.checkNotNullParameter(fileRegion, "<set-?>");
        this.watermark = fileRegion;
    }

    public final boolean isImageOutput() {
        return this.isImageOutput;
    }

    public final void setImageOutput(boolean z) {
        this.isImageOutput = z;
    }

    public final long getEndTimeoutMillis() {
        return this.endTimeoutMillis;
    }

    public final void setEndTimeoutMillis(long j) {
        this.endTimeoutMillis = j;
    }

    public final void addOverlayRegion(OverlayRegion overlayRegion) {
        Intrinsics.checkNotNullParameter(overlayRegion, TtmlNode.TAG_REGION);
        this.overlayRegions.add(overlayRegion);
    }

    public final boolean hasWatermark() {
        return this.watermark.isValid();
    }

    public final boolean hasEndTimeoutMillis() {
        return this.endTimeoutMillis > 0;
    }
}
