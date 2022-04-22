package com.memes.plus.p040ui.auth.signinsc;

import android.os.Bundle;
import android.view.View;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthSnapChatSignInActivityBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/AuthSnapChatSignInActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthSnapChatSignInActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "snapchatAuthProvider", "Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider;", "getSnapchatAuthProvider", "()Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider;", "snapchatAuthProvider$delegate", "snapchatAuthViewModel", "Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthViewModel;", "getSnapchatAuthViewModel", "()Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthViewModel;", "snapchatAuthViewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthActivity */
/* compiled from: SnapchatAuthActivity.kt */
public final class SnapchatAuthActivity extends BaseActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new SnapchatAuthActivity$binding$2(this));
    private final Lazy snapchatAuthProvider$delegate = LazyKt.lazy(new SnapchatAuthActivity$snapchatAuthProvider$2(this));
    private final Lazy snapchatAuthViewModel$delegate = LazyKt.lazy(new SnapchatAuthActivity$snapchatAuthViewModel$2(this));

    private final AuthSnapChatSignInActivityBinding getBinding() {
        return (AuthSnapChatSignInActivityBinding) this.binding$delegate.getValue();
    }

    private final SnapchatAuthProvider getSnapchatAuthProvider() {
        return (SnapchatAuthProvider) this.snapchatAuthProvider$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SnapchatAuthViewModel getSnapchatAuthViewModel() {
        return (SnapchatAuthViewModel) this.snapchatAuthViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthSnapChatSignInActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getSnapchatAuthViewModel());
        getSnapchatAuthViewModel().onSignInComplete().observe(this, new SnapchatAuthActivity$onCreate$1(this));
        getSnapchatAuthProvider().startSignIn();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getSnapchatAuthProvider().onDestroy();
        super.onDestroy();
    }
}
