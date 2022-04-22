package editor.tools.crop;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.memes.commons.output.OutputTargetGenerator;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.BaseViewModelFactory;
import editor.ffmpeg.api.FfmpegFramework;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/tools/crop/CropViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
final class CropActivity$cropViewModel$2 extends Lambda implements Function0<CropViewModel> {
    final /* synthetic */ CropActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CropActivity$cropViewModel$2(CropActivity cropActivity) {
        super(0);
        this.this$0 = cropActivity;
    }

    public final CropViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m18of((FragmentActivity) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<CropViewModel>(this) {
            final /* synthetic */ CropActivity$cropViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final CropViewModel invoke() {
                return new CropViewModel(new FfmpegFramework(this.this$0.this$0), OutputTargetGenerator.Companion.fromDefaultExternalCacheDirectory(), AssetsProvider.Companion.from(this.this$0.this$0));
            }
        })).get(CropViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (CropViewModel) viewModel;
    }
}
