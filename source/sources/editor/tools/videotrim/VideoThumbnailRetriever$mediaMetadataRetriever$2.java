package editor.tools.videotrim;

import android.media.MediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/media/MediaMetadataRetriever;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoThumbnailRetriever.kt */
final class VideoThumbnailRetriever$mediaMetadataRetriever$2 extends Lambda implements Function0<MediaMetadataRetriever> {
    public static final VideoThumbnailRetriever$mediaMetadataRetriever$2 INSTANCE = new VideoThumbnailRetriever$mediaMetadataRetriever$2();

    VideoThumbnailRetriever$mediaMetadataRetriever$2() {
        super(0);
    }

    public final MediaMetadataRetriever invoke() {
        return new MediaMetadataRetriever();
    }
}
