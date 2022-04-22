package com.memes.commons.media;

import com.downloader.OnProgressListener;
import com.downloader.Progress;
import com.memes.commons.media.MediaContentDownloader;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "progress", "Lcom/downloader/Progress;", "kotlin.jvm.PlatformType", "onProgress"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaContentDownloader.kt */
final class MediaContentDownloader$downloadNetworkFile$1 implements OnProgressListener {
    final /* synthetic */ MediaContentDownloader.Callback $callback;

    MediaContentDownloader$downloadNetworkFile$1(MediaContentDownloader.Callback callback) {
        this.$callback = callback;
    }

    public final void onProgress(Progress progress) {
        MediaContentDownloader.Callback callback;
        if (progress.totalBytes <= 0 && (callback = this.$callback) != null) {
            callback.onProgressChanged(-1);
        }
        double d = (((double) progress.currentBytes) / ((double) progress.totalBytes)) * ((double) 100);
        MediaContentDownloader.Callback callback2 = this.$callback;
        if (callback2 != null) {
            callback2.onProgressChanged(MathKt.roundToInt(d));
        }
    }
}
