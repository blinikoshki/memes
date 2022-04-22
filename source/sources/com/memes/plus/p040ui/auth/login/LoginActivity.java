package com.memes.plus.p040ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthFbLoginActivityBinding;
import com.memes.plus.p040ui.auth.signinfb.FbAuthProvider;
import com.memes.plus.p040ui.auth.signinfb.FbAuthViewModel;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/login/LoginActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/AuthFbLoginActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthFbLoginActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "fbAuthViewModel", "Lcom/memes/plus/ui/auth/signinfb/FbAuthViewModel;", "getFbAuthViewModel", "()Lcom/memes/plus/ui/auth/signinfb/FbAuthViewModel;", "fbAuthViewModel$delegate", "fbSignInProvider", "Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider;", "getFbSignInProvider", "()Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider;", "fbSignInProvider$delegate", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "obsolete")
/* renamed from: com.memes.plus.ui.auth.login.LoginActivity */
/* compiled from: LoginActivity.kt */
public final class LoginActivity extends BaseActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new LoginActivity$binding$2(this));
    private final Lazy fbAuthViewModel$delegate = LazyKt.lazy(new LoginActivity$fbAuthViewModel$2(this));
    private final Lazy fbSignInProvider$delegate = LazyKt.lazy(new LoginActivity$fbSignInProvider$2(this));

    /* access modifiers changed from: private */
    public final AuthFbLoginActivityBinding getBinding() {
        return (AuthFbLoginActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FbAuthViewModel getFbAuthViewModel() {
        return (FbAuthViewModel) this.fbAuthViewModel$delegate.getValue();
    }

    private final FbAuthProvider getFbSignInProvider() {
        return (FbAuthProvider) this.fbSignInProvider$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthFbLoginActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getFbAuthViewModel());
        getFbSignInProvider();
        getBinding().backImageView.setOnClickListener(new LoginActivity$onCreate$1(this));
        getBinding().submitButton.setOnClickListener(new LoginActivity$onCreate$2(this));
        LifecycleOwner lifecycleOwner = this;
        getFbAuthViewModel().onEmailInputRequired().observe(lifecycleOwner, new LoginActivity$onCreate$3(this));
        getFbAuthViewModel().onSignInComplete().observe(lifecycleOwner, new LoginActivity$onCreate$4(this));
        getBinding().facebookLoginButton.performClick();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getFbSignInProvider().handleActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }
}
