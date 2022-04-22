package editor.ffmpeg.internal.core;

import android.content.Context;
import editor.ffmpeg.internal.exception.FfmpegMissingException;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/FfmpegLibraryFinder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "find", "Ljava/io/File;", "findFfmpegFile", "name", "", "rootDir", "findSafely", "getAppNativeDir", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegLibraryFinder.kt */
public final class FfmpegLibraryFinder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FFMPEG_FILE_NAME = "lib_ffmpeg.so";
    private final Context context;

    public FfmpegLibraryFinder(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/FfmpegLibraryFinder$Companion;", "", "()V", "FFMPEG_FILE_NAME", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfmpegLibraryFinder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final File find() {
        File findFfmpegFile = findFfmpegFile(FFMPEG_FILE_NAME, new File(getAppNativeDir(this.context)));
        if (findFfmpegFile != null && findFfmpegFile.exists()) {
            return findFfmpegFile;
        }
        throw new FfmpegMissingException();
    }

    public final File findSafely() {
        try {
            return find();
        } catch (Exception e) {
            Timber.m313w(e);
            return null;
        }
    }

    private final String getAppNativeDir(Context context2) {
        String str = context2.getApplicationInfo().nativeLibraryDir;
        Intrinsics.checkNotNullExpressionValue(str, "libArchDir");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null);
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    private final File findFfmpegFile(String str, File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            if (file2.isDirectory()) {
                return findFfmpegFile(str, file2);
            }
            if (StringsKt.equals(str, file2.getName(), true)) {
                return file2;
            }
        }
        return null;
    }
}
