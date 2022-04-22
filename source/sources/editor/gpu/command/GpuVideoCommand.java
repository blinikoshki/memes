package editor.gpu.command;

import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.util.VideoFilterRange;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000b¨\u0006("}, mo26107d2 = {"Leditor/gpu/command/GpuVideoCommand;", "", "inputFile", "Ljava/io/File;", "outputFile", "(Ljava/io/File;Ljava/io/File;)V", "brightness", "", "getBrightness", "()F", "setBrightness", "(F)V", "conflatedFilter", "Leditor/gpu/conflation/GlConflatedFilter;", "getConflatedFilter", "()Leditor/gpu/conflation/GlConflatedFilter;", "setConflatedFilter", "(Leditor/gpu/conflation/GlConflatedFilter;)V", "contrast", "getContrast", "setContrast", "getInputFile", "()Ljava/io/File;", "getOutputFile", "pixelation", "getPixelation", "setPixelation", "saturation", "getSaturation", "setSaturation", "sharpness", "getSharpness", "setSharpness", "brightnessPercentage", "percentage", "", "contrastPercentage", "pixelationPercentage", "saturationPercentage", "sharpnessPercentage", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuVideoCommand.kt */
public final class GpuVideoCommand {
    private float brightness = VideoFilterRange.INSTANCE.getBRIGHTNESS().getDefault();
    private GlConflatedFilter conflatedFilter;
    private float contrast = VideoFilterRange.INSTANCE.getCONTRAST().getDefault();
    private final File inputFile;
    private final File outputFile;
    private float pixelation = VideoFilterRange.INSTANCE.getPIXELATION().getDefault();
    private float saturation = VideoFilterRange.INSTANCE.getSATURATION().getDefault();
    private float sharpness = VideoFilterRange.INSTANCE.getSHARPNESS().getDefault();

    public GpuVideoCommand(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "inputFile");
        Intrinsics.checkNotNullParameter(file2, "outputFile");
        this.inputFile = file;
        this.outputFile = file2;
    }

    public final File getInputFile() {
        return this.inputFile;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }

    public final float getBrightness() {
        return this.brightness;
    }

    public final void setBrightness(float f) {
        this.brightness = f;
    }

    public final float getContrast() {
        return this.contrast;
    }

    public final void setContrast(float f) {
        this.contrast = f;
    }

    public final float getSaturation() {
        return this.saturation;
    }

    public final void setSaturation(float f) {
        this.saturation = f;
    }

    public final float getPixelation() {
        return this.pixelation;
    }

    public final void setPixelation(float f) {
        this.pixelation = f;
    }

    public final float getSharpness() {
        return this.sharpness;
    }

    public final void setSharpness(float f) {
        this.sharpness = f;
    }

    public final GlConflatedFilter getConflatedFilter() {
        return this.conflatedFilter;
    }

    public final void setConflatedFilter(GlConflatedFilter glConflatedFilter) {
        this.conflatedFilter = glConflatedFilter;
    }

    public final GpuVideoCommand brightnessPercentage(int i) {
        this.brightness = VideoFilterRange.INSTANCE.getBRIGHTNESS().toValue(i);
        return this;
    }

    public final GpuVideoCommand contrastPercentage(int i) {
        this.contrast = VideoFilterRange.INSTANCE.getCONTRAST().toValue(i);
        return this;
    }

    public final GpuVideoCommand saturationPercentage(int i) {
        this.saturation = VideoFilterRange.INSTANCE.getSATURATION().toValue(i);
        return this;
    }

    public final GpuVideoCommand pixelationPercentage(int i) {
        this.pixelation = VideoFilterRange.INSTANCE.getPIXELATION().toValue(i);
        return this;
    }

    public final GpuVideoCommand sharpnessPercentage(int i) {
        this.sharpness = VideoFilterRange.INSTANCE.getSHARPNESS().toValue(i);
        return this;
    }
}
