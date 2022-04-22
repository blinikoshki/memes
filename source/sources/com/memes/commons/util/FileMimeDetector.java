package com.memes.commons.util;

import com.memes.commons.output.OutputExtension;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/util/FileMimeDetector;", "", "()V", "detect", "", "file", "Ljava/io/File;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FileMimeDetector.kt */
public final class FileMimeDetector {
    public static final FileMimeDetector INSTANCE = new FileMimeDetector();

    private FileMimeDetector() {
    }

    public final String detect(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "fileName");
        if (StringsKt.endsWith$default(name, OutputExtension.MP4, false, 2, (Object) null)) {
            return "video/mp4";
        }
        if (!StringsKt.endsWith$default(name, OutputExtension.JPG, false, 2, (Object) null) && !StringsKt.endsWith$default(name, ".jpeg", false, 2, (Object) null)) {
            return StringsKt.endsWith$default(name, OutputExtension.PNG, false, 2, (Object) null) ? "image/png" : "unknown";
        }
        return "image/jpeg";
    }
}
