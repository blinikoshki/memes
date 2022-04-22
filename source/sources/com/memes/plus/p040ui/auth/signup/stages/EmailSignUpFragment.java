package com.memes.plus.p040ui.auth.signup.stages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.databinding.AuthSignUpEmailFragmentBinding;
import com.memes.plus.p040ui.auth.signup.SignUpActivityHandle;
import com.memes.plus.p040ui.auth.signup.SignUpViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/stages/EmailSignUpFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activityHandle", "Lcom/memes/plus/ui/auth/signup/SignUpActivityHandle;", "binding", "Lcom/memes/plus/databinding/AuthSignUpEmailFragmentBinding;", "signUpViewModel", "Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "getSignUpViewModel", "()Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "signUpViewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.EmailSignUpFragment */
/* compiled from: EmailSignUpFragment.kt */
public final class EmailSignUpFragment extends Fragment {
    /* access modifiers changed from: private */
    public SignUpActivityHandle activityHandle;
    private AuthSignUpEmailFragmentBinding binding;
    private final Lazy signUpViewModel$delegate = LazyKt.lazy(new EmailSignUpFragment$signUpViewModel$2(this));

    /* access modifiers changed from: private */
    public final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel$delegate.getValue();
    }

    public static final /* synthetic */ SignUpActivityHandle access$getActivityHandle$p(EmailSignUpFragment emailSignUpFragment) {
        SignUpActivityHandle signUpActivityHandle = emailSignUpFragment.activityHandle;
        if (signUpActivityHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityHandle");
        }
        return signUpActivityHandle;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.activityHandle = (SignUpActivityHandle) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AuthSignUpEmailFragmentBinding inflate = AuthSignUpEmailFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AuthSignUpEmailFragmentB…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding = this.binding;
        if (authSignUpEmailFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpEmailFragmentBinding.backImageView.setOnClickListener(new EmailSignUpFragment$onViewCreated$1(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding2 = this.binding;
        if (authSignUpEmailFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authSignUpEmailFragmentBinding2.emailEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.emailEditText");
        textInputEditText.addTextChangedListener(new C4234xd31aae24(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding3 = this.binding;
        if (authSignUpEmailFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText2 = authSignUpEmailFragmentBinding3.usernameEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.usernameEditText");
        textInputEditText2.addTextChangedListener(new C4235xd31aae25(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding4 = this.binding;
        if (authSignUpEmailFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText3 = authSignUpEmailFragmentBinding4.passwordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText3, "binding.passwordEditText");
        textInputEditText3.addTextChangedListener(new C4236xd31aae26(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding5 = this.binding;
        if (authSignUpEmailFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpEmailFragmentBinding5.signUpButton.setOnClickListener(new EmailSignUpFragment$onViewCreated$5(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding6 = this.binding;
        if (authSignUpEmailFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpEmailFragmentBinding6.facebookSignInButton.setOnClickListener(new EmailSignUpFragment$onViewCreated$6(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding7 = this.binding;
        if (authSignUpEmailFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpEmailFragmentBinding7.snapchatSignInButton.setOnClickListener(new EmailSignUpFragment$onViewCreated$7(this));
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding8 = this.binding;
        if (authSignUpEmailFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpEmailFragmentBinding8.signInTextView.setOnClickListener(new EmailSignUpFragment$onViewCreated$8(this));
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        AuthSignUpEmailFragmentBinding authSignUpEmailFragmentBinding9 = this.binding;
        if (authSignUpEmailFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText4 = authSignUpEmailFragmentBinding9.emailEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText4, "binding.emailEditText");
        softKeyboardUtil.showKeyboard(textInputEditText4);
    }
}
