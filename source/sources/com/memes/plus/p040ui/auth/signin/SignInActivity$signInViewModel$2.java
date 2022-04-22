package com.memes.plus.p040ui.auth.signin;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.NetworkProxy;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/auth/signin/SignInViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInActivity$signInViewModel$2 */
/* compiled from: SignInActivity.kt */
final class SignInActivity$signInViewModel$2 extends Lambda implements Function0<SignInViewModel> {
    final /* synthetic */ SignInActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignInActivity$signInViewModel$2(SignInActivity signInActivity) {
        super(0);
        this.this$0 = signInActivity;
    }

    public final SignInViewModel invoke() {
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<SignInViewModel>(this) {
            final /* synthetic */ SignInActivity$signInViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SignInViewModel invoke() {
                return new SignInViewModel(NetworkProxy.INSTANCE.fromMemes(), RepositoryInjection.INSTANCE.storageRepository(this.this$0.this$0));
            }
        })).get(SignInViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return (SignInViewModel) viewModel;
    }
}
