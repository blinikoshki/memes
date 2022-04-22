package editor.tools.videotrim;

import com.memes.editor.databinding.NVideoTrimmerActivityBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NVideoTrimmerActivityBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$binding$2 extends Lambda implements Function0<NVideoTrimmerActivityBinding> {
    final /* synthetic */ VideoTrimActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimActivity$binding$2(VideoTrimActivity videoTrimActivity) {
        super(0);
        this.this$0 = videoTrimActivity;
    }

    public final NVideoTrimmerActivityBinding invoke() {
        return NVideoTrimmerActivityBinding.inflate(this.this$0.getLayoutInflater());
    }
}
