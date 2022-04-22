package com.memes.commons.output;

import android.content.Context;
import android.os.Environment;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.memes.commons.annotations.DangerousUse;
import com.memes.commons.util.DirectoryUtil;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u0014\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J@\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/commons/output/OutputTargetGenerator;", "", "rootDirectory", "Ljava/io/File;", "(Ljava/io/File;)V", "outputFile", "changeRootDirectory", "directory", "clearCache", "_childFolderName", "", "existsInRootDirectory", "", "file", "getOutputDirectory", "getOutputFile", "getRootDirectory", "setDefaultOutputDestination", "_fileName", "_fileExtension", "useExtension", "createFile", "setOutputDestination", "path", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OutputTargetGenerator.kt */
public final class OutputTargetGenerator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public File outputFile;
    private File rootDirectory;

    private OutputTargetGenerator(File file) {
        this.rootDirectory = file;
        file.mkdirs();
    }

    public /* synthetic */ OutputTargetGenerator(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    public static final /* synthetic */ File access$getOutputFile$p(OutputTargetGenerator outputTargetGenerator) {
        File file = outputTargetGenerator.outputFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        return file;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0012\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, mo26107d2 = {"Lcom/memes/commons/output/OutputTargetGenerator$Companion;", "", "()V", "fromCacheDirectory", "Lcom/memes/commons/output/OutputTargetGenerator;", "context", "Landroid/content/Context;", "fromDefaultExternalCacheDirectory", "fromExternalCacheDirectory", "internalFolderName", "", "fromMemesDirectory", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: OutputTargetGenerator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OutputTargetGenerator fromCacheDirectory(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File cacheDir = context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
            return new OutputTargetGenerator(cacheDir, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ OutputTargetGenerator fromExternalCacheDirectory$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.fromExternalCacheDirectory(str);
        }

        public final OutputTargetGenerator fromExternalCacheDirectory(String str) {
            String str2 = Environment.getExternalStorageDirectory() + "/.memes";
            CharSequence charSequence = str;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                str2 = str2 + '/' + str;
            }
            return new OutputTargetGenerator(new File(str2), (DefaultConstructorMarker) null);
        }

        public final OutputTargetGenerator fromDefaultExternalCacheDirectory() {
            return fromExternalCacheDirectory(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY);
        }

        public final OutputTargetGenerator fromMemesDirectory() {
            return new OutputTargetGenerator(new File(Environment.getExternalStorageDirectory() + "/memes"), (DefaultConstructorMarker) null);
        }
    }

    public final File getRootDirectory() {
        return this.rootDirectory;
    }

    public final OutputTargetGenerator changeRootDirectory(File file) {
        Intrinsics.checkNotNullParameter(file, "directory");
        this.rootDirectory = file;
        return this;
    }

    public static /* synthetic */ OutputTargetGenerator setDefaultOutputDestination$default(OutputTargetGenerator outputTargetGenerator, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = "";
        }
        return outputTargetGenerator.setDefaultOutputDestination(str, str4, str3, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2);
    }

    @DangerousUse(comments = "Assumes file to be JPG if extension is empty. Creepy Implement.")
    public final OutputTargetGenerator setDefaultOutputDestination(String str, String str2, String str3, boolean z, boolean z2) {
        if (str == null) {
            str = OutputTarget.FOLDER_EDITOR_CACHE;
        }
        CharSequence charSequence = str2;
        boolean z3 = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str2 = "com.memes.plus.android." + System.nanoTime();
        }
        if (z) {
            CharSequence charSequence2 = str3;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z3 = true;
            }
            if (z3) {
                str3 = OutputExtension.JPG;
            }
        }
        setOutputDestination(new File(this.rootDirectory, str + '/' + str2 + str3), z2);
        return this;
    }

    public final OutputTargetGenerator setOutputDestination(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return setOutputDestination$default(this, new File(str), false, 2, (Object) null);
    }

    public static /* synthetic */ OutputTargetGenerator setOutputDestination$default(OutputTargetGenerator outputTargetGenerator, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return outputTargetGenerator.setOutputDestination(file, z);
    }

    public final OutputTargetGenerator setOutputDestination(File file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.outputFile = file;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        if (file.exists()) {
            File file2 = this.outputFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
            if (!file2.delete()) {
                Timber.m312w("Output file exists, and we couldn't delete it.", new Object[0]);
            }
        }
        File file3 = this.outputFile;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        File parentFile = file3.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (z) {
            File file4 = this.outputFile;
            if (file4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
            file4.createNewFile();
        }
        return this;
    }

    public final File getOutputDirectory() {
        if (this.outputFile != null) {
            File file = this.outputFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                return parentFile;
            }
            throw new FileNotFoundException("Parent dir not found for output file.");
        }
        throw new NullPointerException("No output destination was specified.");
    }

    public final File getOutputFile() {
        if (this.outputFile != null) {
            File file = this.outputFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFile");
            }
            return file;
        }
        throw new NullPointerException("No output destination was specified.");
    }

    public final boolean existsInRootDirectory(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            String absolutePath2 = this.rootDirectory.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "rootDirectory.absolutePath");
            if (StringsKt.contains$default((CharSequence) absolutePath, (CharSequence) absolutePath2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ OutputTargetGenerator clearCache$default(OutputTargetGenerator outputTargetGenerator, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return outputTargetGenerator.clearCache(str);
    }

    @DangerousUse(comments = "Make sure that you're not deleting user's content")
    public final OutputTargetGenerator clearCache(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            clearCache(OutputTarget.FOLDER_EDITOR_SOURCE);
            clearCache(OutputTarget.FOLDER_EDITOR_OUTPUT);
            clearCache(OutputTarget.FOLDER_EDITOR_CACHE);
            return this;
        }
        DirectoryUtil.INSTANCE.safeDelete(new File(this.rootDirectory, str));
        return this;
    }
}
