package com.memes.plus.p040ui.auth.signup.stages;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.NetworkProxy;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.auth.signup.SignUpViewModel;
import com.memes.plus.util.RepositoryInjection;
import com.memes.plus.util.assetfile.AssetFileProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.CompleteEmailSignUpFragment$signUpViewModel$2 */
/* compiled from: CompleteEmailSignUpFragment.kt */
final class CompleteEmailSignUpFragment$signUpViewModel$2 extends Lambda implements Function0<SignUpViewModel> {
    final /* synthetic */ CompleteEmailSignUpFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompleteEmailSignUpFragment$signUpViewModel$2(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        super(0);
        this.this$0 = completeEmailSignUpFragment;
    }

    public final SignUpViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<SignUpViewModel>(this) {
            final /* synthetic */ CompleteEmailSignUpFragment$signUpViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SignUpViewModel invoke() {
                MemesDataSource fromMemes = NetworkProxy.INSTANCE.fromMemes();
                RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
                Context requireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                StorageRepository storageRepository = repositoryInjection.storageRepository(requireContext);
                Context requireContext2 = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                AssetManager assets = requireContext2.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "requireContext().assets");
                return new SignUpViewModel(fromMemes, storageRepository, new AssetFileProvider(assets));
            }
        })).get(SignUpViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (SignUpViewModel) viewModel;
    }
}
