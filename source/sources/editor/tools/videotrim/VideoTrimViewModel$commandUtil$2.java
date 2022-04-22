package editor.tools.videotrim;

import editor.util.FfmpegCommandUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/util/FfmpegCommandUtil;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimViewModel.kt */
final class VideoTrimViewModel$commandUtil$2 extends Lambda implements Function0<FfmpegCommandUtil> {
    final /* synthetic */ VideoTrimViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimViewModel$commandUtil$2(VideoTrimViewModel videoTrimViewModel) {
        super(0);
        this.this$0 = videoTrimViewModel;
    }

    public final FfmpegCommandUtil invoke() {
        return new FfmpegCommandUtil(this.this$0.ffmpegFramework, this.this$0.outputTargetGenerator);
    }
}
