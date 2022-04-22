package com.memes.plus.p040ui.web_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.WebViewActivityBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/web_view/WebViewActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/WebViewActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/WebViewActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.web_view.WebViewActivity */
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_LINK = "intent_extra_Link";
    private final Lazy binding$delegate = LazyKt.lazy(new WebViewActivity$binding$2(this));

    private final WebViewActivityBinding getBinding() {
        return (WebViewActivityBinding) this.binding$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/web_view/WebViewActivity$Companion;", "", "()V", "EXTRA_LINK", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "link", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.web_view.WebViewActivity$Companion */
    /* compiled from: WebViewActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "link");
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra(WebViewActivity.EXTRA_LINK, str);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebViewActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        if (getIntent().hasExtra(EXTRA_LINK)) {
            String stringExtra = getIntent().getStringExtra(EXTRA_LINK);
            WebView webView = getBinding().contentWebView;
            Intrinsics.checkNotNullExpressionValue(webView, "binding.contentWebView");
            WebSettings settings = webView.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "binding.contentWebView.settings");
            settings.setJavaScriptEnabled(true);
            WebView webView2 = getBinding().contentWebView;
            Intrinsics.checkNotNullExpressionValue(webView2, "binding.contentWebView");
            WebSettings settings2 = webView2.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings2, "binding.contentWebView.settings");
            settings2.setPluginState(WebSettings.PluginState.ON);
            WebView webView3 = getBinding().contentWebView;
            Intrinsics.checkNotNullExpressionValue(webView3, "binding.contentWebView");
            webView3.setWebChromeClient(new WebChromeClient());
            WebView webView4 = getBinding().contentWebView;
            Intrinsics.checkNotNullExpressionValue(webView4, "binding.contentWebView");
            webView4.setWebViewClient(new WebViewClient());
            getBinding().contentWebView.loadUrl(stringExtra);
            return;
        }
        finish();
    }
}
