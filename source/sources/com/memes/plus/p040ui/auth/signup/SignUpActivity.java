package com.memes.plus.p040ui.auth.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.provider.SimpleFileProvider;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthSignUpActivityBinding;
import com.memes.plus.p040ui.auth.login.FacebookSignInActivityContract;
import com.memes.plus.p040ui.auth.signin.SignInActivity;
import com.memes.plus.p040ui.auth.signinsc.SnapchatAuthActivityContract;
import com.memes.plus.p040ui.auth.signup.stages.SignUpStage;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/SignUpActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/plus/ui/auth/signup/SignUpActivityHandle;", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "()V", "binding", "Lcom/memes/plus/databinding/AuthSignUpActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthSignUpActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "facebookSignInContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "profilePictureSelector", "Lcom/memes/commons/imageselection/ImageSelector;", "signUpViewModel", "Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "getSignUpViewModel", "()Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "signUpViewModel$delegate", "snapChatSignInContractLauncher", "notifySignUpComplete", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFacebookSignInRequested", "onImageFileSelected", "requestIdentifier", "", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "onPickProfilePictureRequested", "onSignInRequested", "onSnapchatSignInRequested", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpActivity */
/* compiled from: SignUpActivity.kt */
public final class SignUpActivity extends BaseActivity implements SignUpActivityHandle, ImageSelector.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_STARTED_BY_SIGN_IN = "intent_extra_started_by_sign_in";
    public static final int RC_CHOOSE_PHOTO = 5644;
    private final Lazy binding$delegate = LazyKt.lazy(new SignUpActivity$binding$2(this));
    private final ActivityResultLauncher<String> facebookSignInContractLauncher;
    private final ImageSelector profilePictureSelector;
    private final Lazy signUpViewModel$delegate;
    private final ActivityResultLauncher<String> snapChatSignInContractLauncher;

    /* access modifiers changed from: private */
    public final AuthSignUpActivityBinding getBinding() {
        return (AuthSignUpActivityBinding) this.binding$delegate.getValue();
    }

    private final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel$delegate.getValue();
    }

    public SignUpActivity() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new FacebookSignInActivityContract(), new SignUpActivity$facebookSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…fySignUpComplete()\n\t\t}\n\t}");
        this.facebookSignInContractLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult(new SnapchatAuthActivityContract(), new SignUpActivity$snapChatSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul…fySignUpComplete()\n\t\t}\n\t}");
        this.snapChatSignInContractLauncher = registerForActivityResult2;
        this.profilePictureSelector = new ImageSelector(this, SimpleFileProvider.NAME);
        this.signUpViewModel$delegate = LazyKt.lazy(new SignUpActivity$signUpViewModel$2(this));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/SignUpActivity$Companion;", "", "()V", "EXTRA_STARTED_BY_SIGN_IN", "", "RC_CHOOSE_PHOTO", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "startedBySignIn", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signup.SignUpActivity$Companion */
    /* compiled from: SignUpActivity.kt */
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
            Intent intent = new Intent(context, SignUpActivity.class);
            intent.putExtra(SignUpActivity.EXTRA_STARTED_BY_SIGN_IN, z);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthSignUpActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getSignUpViewModel());
        SignUpPagerAdapter signUpPagerAdapter = new SignUpPagerAdapter(this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setOffscreenPageLimit(signUpPagerAdapter.getItemCount());
        ViewPager2 viewPager22 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.viewPager");
        viewPager22.setUserInputEnabled(false);
        ViewPager2 viewPager23 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager23, "binding.viewPager");
        viewPager23.setAdapter(signUpPagerAdapter);
        LifecycleOwner lifecycleOwner = this;
        getSignUpViewModel().onSignUpStageChanged().observe(lifecycleOwner, new SignUpActivity$onCreate$1(this));
        getSignUpViewModel().onSignUpSuccessful().observe(lifecycleOwner, new SignUpActivity$onCreate$2(this));
    }

    public void onBackPressed() {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        SignUpStage signUpStage = null;
        if (viewPager2.getCurrentItem() == SignUpStage.PROFILE_INPUT.getPosition()) {
            signUpStage = SignUpStage.EMAIL_INPUT;
        } else {
            int position = SignUpStage.EMAIL_INPUT.getPosition();
        }
        if (signUpStage != null) {
            getSignUpViewModel().changeStage(signUpStage);
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void notifySignUpComplete() {
        Intent intent = HomeRouting.INSTANCE.getIntent(this);
        if (isStartedForResult()) {
            setResult(-1, new Intent());
            ActivityStarter.Companion.finishWithRootCheck(this, intent);
            return;
        }
        ActivityStarter.Companion.mo57312of(intent).finishAffinity().startFrom((Activity) this);
    }

    public void onSignInRequested() {
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra(EXTRA_STARTED_BY_SIGN_IN, false);
        }
        if (z) {
            finish();
            return;
        }
        ActivityStarter.Companion.mo57312of(SignInActivity.Companion.getStartIntent(this, true)).startFrom((Activity) this);
    }

    public void onFacebookSignInRequested() {
        this.facebookSignInContractLauncher.launch(null);
    }

    public void onSnapchatSignInRequested() {
        this.snapChatSignInContractLauncher.launch(null);
    }

    public void onPickProfilePictureRequested() {
        this.profilePictureSelector.requestIdentifier(5644).selectionSourcesLayoutRes(C4199R.C4205layout.image_selection_choices_item).enableCrop(ImageSelector.Companion.getCROP_SQUARE()).callback(this).start();
    }

    public void onImageFileSelected(int i, ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        if (i == 5644) {
            getSignUpViewModel().profilePictureChanged(imageContent.getFile().getAbsolutePath());
        }
    }
}
