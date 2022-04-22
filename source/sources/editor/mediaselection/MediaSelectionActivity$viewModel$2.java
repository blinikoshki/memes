package editor.mediaselection;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.BaseViewModelFactory;
import editor.mediaselection.items.MediaSelectionItemsViewModel;
import editor.mediaselection.localmedia.MediaProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/items/MediaSelectionItemsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$viewModel$2 extends Lambda implements Function0<MediaSelectionItemsViewModel> {
    final /* synthetic */ MediaSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionActivity$viewModel$2(MediaSelectionActivity mediaSelectionActivity) {
        super(0);
        this.this$0 = mediaSelectionActivity;
    }

    public final MediaSelectionItemsViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m18of((FragmentActivity) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<MediaSelectionItemsViewModel>(this) {
            final /* synthetic */ MediaSelectionActivity$viewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final MediaSelectionItemsViewModel invoke() {
                return new MediaSelectionItemsViewModel(AssetsProvider.Companion.from(this.this$0.this$0), MediaProvider.Companion.from(this.this$0.this$0));
            }
        })).get(MediaSelectionItemsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (MediaSelectionItemsViewModel) viewModel;
    }
}
