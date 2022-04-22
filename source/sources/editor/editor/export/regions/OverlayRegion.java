package editor.editor.export.regions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0010\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010)\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"¨\u0006,"}, mo26107d2 = {"Leditor/editor/export/regions/OverlayRegion;", "Leditor/editor/export/regions/FileRegion;", "x", "", "y", "width", "height", "(IIII)V", "clipRegion", "Leditor/editor/export/regions/Region;", "getClipRegion", "()Leditor/editor/export/regions/Region;", "setClipRegion", "(Leditor/editor/export/regions/Region;)V", "durationMillis", "", "getDurationMillis", "()J", "setDurationMillis", "(J)V", "flipHorizontally", "", "getFlipHorizontally", "()Z", "setFlipHorizontally", "(Z)V", "flipVertically", "getFlipVertically", "setFlipVertically", "opacity", "", "getOpacity", "()F", "setOpacity", "(F)V", "rotation", "getRotation", "setRotation", "roundedCorners", "getRoundedCorners", "setRoundedCorners", "scale", "getScale", "setScale", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OverlayRegion.kt */
public class OverlayRegion extends FileRegion {
    private Region clipRegion = Region.Companion.empty();
    private long durationMillis;
    private boolean flipHorizontally;
    private boolean flipVertically;
    private float opacity = 1.0f;
    private float rotation;
    private boolean roundedCorners;
    private float scale = 1.0f;

    public OverlayRegion(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float f) {
        this.rotation = f;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final void setOpacity(float f) {
        this.opacity = f;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    public final void setDurationMillis(long j) {
        this.durationMillis = j;
    }

    public final Region getClipRegion() {
        return this.clipRegion;
    }

    public final void setClipRegion(Region region) {
        Intrinsics.checkNotNullParameter(region, "<set-?>");
        this.clipRegion = region;
    }

    public final boolean getRoundedCorners() {
        return this.roundedCorners;
    }

    public final void setRoundedCorners(boolean z) {
        this.roundedCorners = z;
    }

    public final boolean getFlipHorizontally() {
        return this.flipHorizontally;
    }

    public final void setFlipHorizontally(boolean z) {
        this.flipHorizontally = z;
    }

    public final boolean getFlipVertically() {
        return this.flipVertically;
    }

    public final void setFlipVertically(boolean z) {
        this.flipVertically = z;
    }
}
