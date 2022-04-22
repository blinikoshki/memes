package com.memes.commons.util;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.util.UriResolverHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"com/memes/commons/util/UriResolverHelper$import$1", "Lcom/memes/commons/media/MediaContentDownloader$Callback;", "onDownloadComplete", "", "file", "Ljava/io/File;", "onError", "message", "", "onProgressChanged", "progress", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UriResolverHelper.kt */
public final class UriResolverHelper$import$1 implements MediaContentDownloader.Callback {
    final /* synthetic */ int $contentType;
    final /* synthetic */ UriResolverHelper this$0;

    public void onProgressChanged(int i) {
    }

    UriResolverHelper$import$1(UriResolverHelper uriResolverHelper, int i) {
        this.this$0 = uriResolverHelper;
        this.$contentType = i;
    }

    public void onDownloadComplete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        MediaContent createMediaContent = this.this$0.createMediaContent(file, this.$contentType);
        UriResolverHelper.Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.onUriResolved(createMediaContent);
        }
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        UriResolverHelper uriResolverHelper = this.this$0;
        uriResolverHelper.reportError("Failed to import file: " + str);
    }
}
