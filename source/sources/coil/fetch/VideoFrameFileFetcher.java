package coil.fetch;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, mo26107d2 = {"Lcoil/fetch/VideoFrameFileFetcher;", "Lcoil/fetch/VideoFrameFetcher;", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handles", "", "data", "key", "", "setDataSource", "", "Landroid/media/MediaMetadataRetriever;", "coil-video_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: VideoFrameFetcher.kt */
public final class VideoFrameFileFetcher extends VideoFrameFetcher<File> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoFrameFileFetcher(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public String key(File file) {
        Intrinsics.checkNotNullParameter(file, "data");
        return file.getPath() + ':' + file.lastModified();
    }

    public boolean handles(File file) {
        Intrinsics.checkNotNullParameter(file, "data");
        String name = file.getName();
        for (String str : VideoFrameFetcher.SUPPORTED_FILE_EXTENSIONS) {
            Intrinsics.checkNotNullExpressionValue(name, "fileName");
            if (StringsKt.endsWith(name, str, true)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, File file) {
        Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "$this$setDataSource");
        Intrinsics.checkNotNullParameter(file, "data");
        mediaMetadataRetriever.setDataSource(file.getPath());
    }
}
