package editor.editor.export.regions;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/export/regions/FileRegion;", "Leditor/editor/export/regions/Region;", "()V", "x", "", "y", "width", "height", "(IIII)V", "contentFile", "Ljava/io/File;", "getContentFile", "()Ljava/io/File;", "setContentFile", "(Ljava/io/File;)V", "contentType", "getContentType", "()I", "setContentType", "(I)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FileRegion.kt */
public class FileRegion extends Region {
    public File contentFile;
    private int contentType;

    public FileRegion(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public FileRegion() {
        this(0, 0, 0, 0);
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final void setContentType(int i) {
        this.contentType = i;
    }

    public final File getContentFile() {
        File file = this.contentFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentFile");
        }
        return file;
    }

    public final void setContentFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.contentFile = file;
    }
}
