package com.memes.plus.p040ui.auth.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthSignInActivityBinding;
import com.memes.plus.p040ui.auth.login.FacebookSignInActivityContract;
import com.memes.plus.p040ui.auth.signinsc.SnapchatAuthActivityContract;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signin/SignInActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "accountRecoveryContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "binding", "Lcom/memes/plus/databinding/AuthSignInActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthSignInActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "facebookSignInContractLauncher", "", "signInViewModel", "Lcom/memes/plus/ui/auth/signin/SignInViewModel;", "getSignInViewModel", "()Lcom/memes/plus/ui/auth/signin/SignInViewModel;", "signInViewModel$delegate", "snapChatSignInContractLauncher", "notifySignInComplete", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInActivity */
/* compiled from: SignInActivity.kt */
public final class SignInActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_STARTED_BY_SIGN_UP = "intent_extra_started_by_sign_up";
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> accountRecoveryContractLauncher;
    private final Lazy binding$delegate = LazyKt.lazy(new SignInActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<String> facebookSignInContractLauncher;
    private final Lazy signInViewModel$delegate;
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<String> snapChatSignInContractLauncher;

    /* access modifiers changed from: private */
    public final AuthSignInActivityBinding getBinding() {
        return (AuthSignInActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SignInViewModel getSignInViewModel() {
        return (SignInViewModel) this.signInViewModel$delegate.getValue();
    }

    public SignInActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SignInActivity$accountRecoveryContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…overy_success_msg)\n\t\t}\n\t}");
        this.accountRecoveryContractLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult(new FacebookSignInActivityContract(), new SignInActivity$facebookSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul…fySignInComplete()\n\t\t}\n\t}");
        this.facebookSignInContractLauncher = registerForActivityResult2;
        ActivityResultLauncher<String> registerForActivityResult3 = registerForActivityResult(new SnapchatAuthActivityContract(), new SignInActivity$snapChatSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResul…fySignInComplete()\n\t\t}\n\t}");
        this.snapChatSignInContractLauncher = registerForActivityResult3;
        this.signInViewModel$delegate = LazyKt.lazy(new SignInActivity$signInViewModel$2(this));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signin/SignInActivity$Companion;", "", "()V", "EXTRA_STARTED_BY_SIGN_UP", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "startedBySignUp", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signin.SignInActivity$Companion */
    /* compiled from: SignInActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.getStartIntent(context, z);
        }

        public final Intent getStartIntent(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, SignInActivity.class);
            intent.putExtra(SignInActivity.EXTRA_STARTED_BY_SIGN_UP, z);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthSignInActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getSignInViewModel());
        getBinding().backImageView.setOnClickListener(new SignInActivity$onCreate$1(this));
        TextInputEditText textInputEditText = getBinding().identityEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.identityEditText");
        textInputEditText.addTextChangedListener(new SignInActivity$onCreate$$inlined$addTextChangedListener$1(this));
        TextInputEditText textInputEditText2 = getBinding().passwordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.passwordEditText");
        textInputEditText2.addTextChangedListener(new SignInActivity$onCreate$$inlined$addTextChangedListener$2(this));
        getBinding().forgotPasswordTextView.setOnClickListener(new SignInActivity$onCreate$4(this));
        getBinding().signInButton.setOnClickListener(new SignInActivity$onCreate$5(this));
        getBinding().facebookSignInButton.setOnClickListener(new SignInActivity$onCreate$6(this));
        getBinding().snapchatSignInButton.setOnClickListener(new SignInActivity$onCreate$7(this));
        getBinding().signUpTextView.setOnClickListener(new SignInActivity$onCreate$8(this));
        getSignInViewModel().onSignInSuccessful().observe(this, new SignInActivity$onCreate$9(this));
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        TextInputEditText textInputEditText3 = getBinding().identityEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText3, "binding.identityEditText");
        softKeyboardUtil.showKeyboard(textInputEditText3);
    }

    /* access modifiers changed from: private */
    public final void notifySignInComplete() {
        Intent intent = HomeRouting.INSTANCE.getIntent(this);
        if (isStartedForResult()) {
            setResult(-1, new Intent());
            ActivityStarter.Companion.finishWithRootCheck(this, intent);
            return;
        }
        ActivityStarter.Companion.mo57312of(intent).finishAffinity().startFrom((Activity) this);
    }
}
