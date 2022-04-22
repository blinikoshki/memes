package editor.tools.videotrim;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Leditor/tools/videotrim/VideoThumbnailRetriever;", "", "()V", "filePath", "", "mediaMetadataRetriever", "Landroid/media/MediaMetadataRetriever;", "getMediaMetadataRetriever", "()Landroid/media/MediaMetadataRetriever;", "mediaMetadataRetriever$delegate", "Lkotlin/Lazy;", "retrieve", "", "Landroid/graphics/Bitmap;", "thumbnailCount", "", "thumbnailSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVideoFilePath", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VideoThumbnailRetriever.kt */
public final class VideoThumbnailRetriever {
    /* access modifiers changed from: private */
    public String filePath;
    private final Lazy mediaMetadataRetriever$delegate = LazyKt.lazy(VideoThumbnailRetriever$mediaMetadataRetriever$2.INSTANCE);

    /* access modifiers changed from: private */
    public final MediaMetadataRetriever getMediaMetadataRetriever() {
        return (MediaMetadataRetriever) this.mediaMetadataRetriever$delegate.getValue();
    }

    public final VideoThumbnailRetriever setVideoFilePath(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        this.filePath = str;
        return this;
    }

    public final Object retrieve(int i, int i2, Continuation<? super List<Bitmap>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoThumbnailRetriever$retrieve$2(this, i, i2, (Continuation) null), continuation);
    }
}
