package com.memes.plus.p040ui.web_view;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.WebViewDialogBinding;
import com.memes.plus.p040ui.web_view.WebViewDialog$webViewClient$2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/ui/web_view/WebViewDialog;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/memes/plus/databinding/WebViewDialogBinding;", "getBinding", "()Lcom/memes/plus/databinding/WebViewDialogBinding;", "binding$delegate", "Lkotlin/Lazy;", "webViewClient", "com/memes/plus/ui/web_view/WebViewDialog$webViewClient$2$1", "getWebViewClient", "()Lcom/memes/plus/ui/web_view/WebViewDialog$webViewClient$2$1;", "webViewClient$delegate", "showPage", "", "title", "", "link", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.web_view.WebViewDialog */
/* compiled from: WebViewDialog.kt */
public final class WebViewDialog extends AlertDialog {
    private final Lazy binding$delegate;
    private final Lazy webViewClient$delegate = LazyKt.lazy(new WebViewDialog$webViewClient$2(this));

    /* access modifiers changed from: private */
    public final WebViewDialogBinding getBinding() {
        return (WebViewDialogBinding) this.binding$delegate.getValue();
    }

    private final WebViewDialog$webViewClient$2.C43591 getWebViewClient() {
        return (WebViewDialog$webViewClient$2.C43591) this.webViewClient$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new WebViewDialog$binding$2(context));
        WebViewDialogBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setView(binding.getRoot(), 0, 40, 0, 8);
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
        webView4.setWebViewClient(getWebViewClient());
        setButton(-1, context.getString(C4199R.string.f1000ok), C43581.INSTANCE);
    }

    public final void showPage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "link");
        setTitle(str);
        getBinding().contentLayout.showProgress("Please wait...");
        getBinding().contentWebView.loadUrl(str2);
        show();
    }
}
