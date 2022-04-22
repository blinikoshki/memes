package com.memes.commons.media;

import android.content.Context;
import android.media.MediaScannerConnection;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/media/MediaScannerUtility;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scan", "", "file", "Ljava/io/File;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaScannerUtility.kt */
public final class MediaScannerUtility {
    private final Context context;

    public MediaScannerUtility(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void scan(File file) {
        if (file != null && file.exists()) {
            MediaScannerConnection.scanFile(this.context, new String[]{file.getAbsolutePath()}, (String[]) null, MediaScannerUtility$scan$1.INSTANCE);
        }
    }
}
