package com.memes.plus.p040ui.profile.self_profile;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.integrations.snapchat.SnapchatContext;
import com.memes.plus.integrations.snapchat.SnapchatIntegrationViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/integrations/snapchat/SnapchatIntegrationViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$snapchatIntegrationViewModel$2 */
/* compiled from: SelfProfileFragment.kt */
final class SelfProfileFragment$snapchatIntegrationViewModel$2 extends Lambda implements Function0<SnapchatIntegrationViewModel> {
    final /* synthetic */ SelfProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfProfileFragment$snapchatIntegrationViewModel$2(SelfProfileFragment selfProfileFragment) {
        super(0);
        this.this$0 = selfProfileFragment;
    }

    public final SnapchatIntegrationViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<SnapchatIntegrationViewModel>(this) {
            final /* synthetic */ SelfProfileFragment$snapchatIntegrationViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SnapchatIntegrationViewModel invoke() {
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                Context applicationContext = requireContext.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "requireContext().applicationContext");
                return new SnapchatIntegrationViewModel(new SnapchatContext(applicationContext), OutputTargetGenerator.Companion.fromMemesDirectory());
            }
        })).get(SnapchatIntegrationViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (SnapchatIntegrationViewModel) viewModel;
    }
}
