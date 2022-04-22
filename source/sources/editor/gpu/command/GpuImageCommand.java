package editor.gpu.command;

import android.graphics.Bitmap;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/gpu/command/GpuImageCommand;", "", "inputBitmap", "Landroid/graphics/Bitmap;", "outputFile", "Ljava/io/File;", "(Landroid/graphics/Bitmap;Ljava/io/File;)V", "getInputBitmap", "()Landroid/graphics/Bitmap;", "getOutputFile", "()Ljava/io/File;", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuImageCommand.kt */
public final class GpuImageCommand {
    private final Bitmap inputBitmap;
    private final File outputFile;

    public GpuImageCommand(Bitmap bitmap, File file) {
        Intrinsics.checkNotNullParameter(bitmap, "inputBitmap");
        Intrinsics.checkNotNullParameter(file, "outputFile");
        this.inputBitmap = bitmap;
        this.outputFile = file;
    }

    public final Bitmap getInputBitmap() {
        return this.inputBitmap;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }
}
