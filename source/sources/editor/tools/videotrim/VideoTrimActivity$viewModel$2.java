package editor.tools.videotrim;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.UriResolverHelper;
import editor.core.BaseViewModelFactory;
import editor.ffmpeg.api.FfmpegFramework;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/tools/videotrim/VideoTrimViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
final class VideoTrimActivity$viewModel$2 extends Lambda implements Function0<VideoTrimViewModel> {
    final /* synthetic */ VideoTrimActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimActivity$viewModel$2(VideoTrimActivity videoTrimActivity) {
        super(0);
        this.this$0 = videoTrimActivity;
    }

    public final VideoTrimViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m18of((FragmentActivity) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<VideoTrimViewModel>(this) {
            final /* synthetic */ VideoTrimActivity$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final VideoTrimViewModel invoke() {
                return new VideoTrimViewModel(new UriResolverHelper(this.this$0.this$0, OutputTarget.FOLDER_CACHE, (OutputTargetGenerator) null, 4, (DefaultConstructorMarker) null), OutputTargetGenerator.Companion.fromDefaultExternalCacheDirectory(), new FfmpegFramework(this.this$0.this$0), new VideoThumbnailRetriever());
            }
        })).get(VideoTrimViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (VideoTrimViewModel) viewModel;
    }
}
