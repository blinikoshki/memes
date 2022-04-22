package com.memes.plus.p040ui.auth.auth_prompt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.res.ResourcesCompat;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthAccountPromptActivityBinding;
import com.memes.plus.p040ui.auth.login.FacebookSignInActivityContract;
import com.memes.plus.p040ui.auth.signinsc.SnapchatAuthActivityContract;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J8\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/auth_prompt/AuthPromptActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "authContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "binding", "Lcom/memes/plus/databinding/AuthAccountPromptActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthAccountPromptActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "facebookSignInContractLauncher", "", "snapChatSignInContractLauncher", "beforeBinding", "", "notifySignInComplete", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setClickableSpan", "spannable", "Landroid/text/Spannable;", "typeface", "Landroid/graphics/Typeface;", "start", "", "end", "callback", "Lkotlin/Function0;", "updateTermsConditionsTextWithSpans", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity */
/* compiled from: AuthPromptActivity.kt */
public final class AuthPromptActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> authContractLauncher;
    private final Lazy binding$delegate = LazyKt.lazy(new AuthPromptActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<String> facebookSignInContractLauncher;
    /* access modifiers changed from: private */
    public final ActivityResultLauncher<String> snapChatSignInContractLauncher;

    private final AuthAccountPromptActivityBinding getBinding() {
        return (AuthAccountPromptActivityBinding) this.binding$delegate.getValue();
    }

    public AuthPromptActivity() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new FacebookSignInActivityContract(), new AuthPromptActivity$facebookSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…fySignInComplete()\n\t\t}\n\t}");
        this.facebookSignInContractLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult(new SnapchatAuthActivityContract(), new AuthPromptActivity$snapChatSignInContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul…fySignInComplete()\n\t\t}\n\t}");
        this.snapChatSignInContractLauncher = registerForActivityResult2;
        ActivityResultLauncher<Intent> registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AuthPromptActivity$authContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResul…ng.getIntent(this)\n\t\t)\n\t}");
        this.authContractLauncher = registerForActivityResult3;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/auth_prompt/AuthPromptActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity$Companion */
    /* compiled from: AuthPromptActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, AuthPromptActivity.class);
        }
    }

    public boolean beforeBinding() {
        ExtensionsKt.hideStatusBar(this);
        return super.beforeBinding();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthAccountPromptActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        getBinding().continueWithEmailButton.setOnClickListener(new AuthPromptActivity$onCreate$1(this));
        getBinding().continueWithFacebookButton.setOnClickListener(new AuthPromptActivity$onCreate$2(this));
        getBinding().continueWithSnapchatButton.setOnClickListener(new AuthPromptActivity$onCreate$3(this));
        getBinding().signInTextView.setOnClickListener(new AuthPromptActivity$onCreate$4(this));
        updateTermsConditionsTextWithSpans();
    }

    private final void updateTermsConditionsTextWithSpans() {
        String string = getString(C4199R.string.auth_prompt_terms_disclaimer);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.auth_prompt_terms_disclaimer)");
        SpannableString valueOf = SpannableString.valueOf(string);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
        Spannable spannable = valueOf;
        Typeface font = ResourcesCompat.getFont(this, C4199R.font.sf_ui_display_bold);
        String string2 = getString(C4199R.string.auth_prompt_terms_snippet);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.auth_prompt_terms_snippet)");
        CharSequence charSequence = spannable;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string2, 0, false, 6, (Object) null);
        setClickableSpan(spannable, font, indexOf$default, indexOf$default + string2.length(), new AuthPromptActivity$updateTermsConditionsTextWithSpans$1(this));
        String string3 = getString(C4199R.string.auth_prompt_policy_snippet);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.auth_prompt_policy_snippet)");
        int indexOf$default2 = StringsKt.indexOf$default(charSequence, string3, 0, false, 6, (Object) null);
        setClickableSpan(spannable, font, indexOf$default2, indexOf$default2 + string3.length(), new AuthPromptActivity$updateTermsConditionsTextWithSpans$2(this));
        TextView textView = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.termsConditionsTextView");
        textView.setLinksClickable(true);
        TextView textView2 = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.termsConditionsTextView");
        textView2.setMovementMethod(new LinkMovementMethod());
        TextView textView3 = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.termsConditionsTextView");
        textView3.setText(charSequence);
    }

    private final void setClickableSpan(Spannable spannable, Typeface typeface, int i, int i2, Function0<Unit> function0) {
        spannable.setSpan(new MagicalTypefaceSpan(typeface), i, i2, 17);
        spannable.setSpan(new AuthPromptActivity$setClickableSpan$1(function0), i, i2, 17);
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
