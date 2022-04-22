package com.memes.plus.p040ui.explore;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.integrations.facebook.FacebookActivityContext;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$facebookIntegrationViewModel$2 */
/* compiled from: ExploreTabFragment.kt */
final class ExploreTabFragment$facebookIntegrationViewModel$2 extends Lambda implements Function0<FacebookIntegrationViewModel> {
    final /* synthetic */ ExploreTabFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExploreTabFragment$facebookIntegrationViewModel$2(ExploreTabFragment exploreTabFragment) {
        super(0);
        this.this$0 = exploreTabFragment;
    }

    public final FacebookIntegrationViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<FacebookIntegrationViewModel>(this) {
            final /* synthetic */ ExploreTabFragment$facebookIntegrationViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final FacebookIntegrationViewModel invoke() {
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return new FacebookIntegrationViewModel(new FacebookActivityContext(requireActivity));
            }
        })).get(FacebookIntegrationViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (FacebookIntegrationViewModel) viewModel;
    }
}
