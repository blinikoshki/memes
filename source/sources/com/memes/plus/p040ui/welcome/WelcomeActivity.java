package com.memes.plus.p040ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bumptech.glide.Glide;
import com.memes.plus.AppConfig;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.WelcomeActivityBinding;
import com.memes.plus.p040ui.web_view.WebViewDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/welcome/WelcomeActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/WelcomeActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/WelcomeActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "termsConditionsDialog", "Lcom/memes/plus/ui/web_view/WebViewDialog;", "getTermsConditionsDialog", "()Lcom/memes/plus/ui/web_view/WebViewDialog;", "termsConditionsDialog$delegate", "viewModel", "Lcom/memes/plus/ui/welcome/WelcomeViewModel;", "getViewModel", "()Lcom/memes/plus/ui/welcome/WelcomeViewModel;", "viewModel$delegate", "applyFullPageBackground", "", "applyTermsOfServiceTextAction", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTermsOfServicePage", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeActivity */
/* compiled from: WelcomeActivity.kt */
public final class WelcomeActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new WelcomeActivity$binding$2(this));
    private final Lazy termsConditionsDialog$delegate = LazyKt.lazy(new WelcomeActivity$termsConditionsDialog$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new WelcomeActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final WelcomeActivityBinding getBinding() {
        return (WelcomeActivityBinding) this.binding$delegate.getValue();
    }

    private final WebViewDialog getTermsConditionsDialog() {
        return (WebViewDialog) this.termsConditionsDialog$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final WelcomeViewModel getViewModel() {
        return (WelcomeViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/welcome/WelcomeActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.welcome.WelcomeActivity$Companion */
    /* compiled from: WelcomeActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, WelcomeActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WelcomeActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        applyFullPageBackground();
        applyTermsOfServiceTextAction();
        LifecycleOwner lifecycleOwner = this;
        getViewModel().onShowAuthPrompt().observe(lifecycleOwner, new WelcomeActivity$onCreate$1(this));
        getViewModel().onProminentTextChanged().observe(lifecycleOwner, new WelcomeActivity$onCreate$2(this));
        getViewModel().onBackgroundAlphaChanged().observe(lifecycleOwner, new WelcomeActivity$onCreate$3(this));
        getViewModel().onForegroundSheetColorChanged().observe(lifecycleOwner, new WelcomeActivity$onCreate$4(this));
        getBinding().finishWelcomeButton.setOnClickListener(new WelcomeActivity$onCreate$5(this));
        getViewModel().start();
    }

    private final void applyFullPageBackground() {
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(C4199R.C4202drawable.welcome_bg)).into(getBinding().backgroundImageView);
    }

    private final void applyTermsOfServiceTextAction() {
        SpannableString spannableString = new SpannableString(getString(C4199R.string.welcome_page_text_3));
        String string = getString(C4199R.string.welcome_page_text_3_highlighted_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.welco…_text_3_highlighted_text)");
        WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1 welcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1 = new WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1(this);
        CharSequence charSequence = spannableString;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        spannableString.setSpan(welcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1, indexOf$default, string.length() + indexOf$default, 33);
        TextView textView = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.termsConditionsTextView");
        textView.setText(charSequence);
        TextView textView2 = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.termsConditionsTextView");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().termsConditionsTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.termsConditionsTextView");
        textView3.setHighlightColor(0);
    }

    /* access modifiers changed from: private */
    public final void showTermsOfServicePage() {
        WebViewDialog termsConditionsDialog = getTermsConditionsDialog();
        String string = getString(C4199R.string.community_guidelines_eula);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.community_guidelines_eula)");
        termsConditionsDialog.showPage(string, AppConfig.EULA_URL);
    }
}
