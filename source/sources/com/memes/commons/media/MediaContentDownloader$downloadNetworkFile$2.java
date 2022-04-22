package com.memes.commons.media;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.memes.commons.media.MediaContentDownloader;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo26107d2 = {"com/memes/commons/media/MediaContentDownloader$downloadNetworkFile$2", "Lcom/downloader/OnDownloadListener;", "onDownloadComplete", "", "onError", "error", "Lcom/downloader/Error;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaContentDownloader.kt */
public final class MediaContentDownloader$downloadNetworkFile$2 implements OnDownloadListener {
    final /* synthetic */ MediaContentDownloader.Callback $callback;
    final /* synthetic */ String $dir;
    final /* synthetic */ String $fileName;

    MediaContentDownloader$downloadNetworkFile$2(MediaContentDownloader.Callback callback, String str, String str2) {
        this.$callback = callback;
        this.$dir = str;
        this.$fileName = str2;
    }

    public void onDownloadComplete() {
        MediaContentDownloader.Callback callback = this.$callback;
        if (callback != null) {
            callback.onDownloadComplete(new File(this.$dir, this.$fileName));
        }
    }

    public void onError(Error error) {
        String str;
        MediaContentDownloader.Callback callback = this.$callback;
        if (callback != null) {
            if (error == null || (str = error.getServerErrorMessage()) == null) {
                str = "Unknown Error";
            }
            callback.onError(str);
        }
    }
}
