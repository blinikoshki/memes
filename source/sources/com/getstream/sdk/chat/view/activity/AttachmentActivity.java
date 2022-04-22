package com.getstream.sdk.chat.view.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.UrlSigner;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.model.ModelType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.p016ui.common.C1891R;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/activity/AttachmentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "iv_image", "Landroid/widget/ImageView;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "progressBar", "Landroid/widget/ProgressBar;", "urlSigner", "Lcom/getstream/sdk/chat/UrlSigner;", "getUrlSigner", "()Lcom/getstream/sdk/chat/UrlSigner;", "webView", "Landroid/webkit/WebView;", "configUIs", "", "loadUrlToWeb", "url", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showAttachment", "type", "showGiphy", "AppWebViewClients", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentActivity.kt */
public final class AttachmentActivity extends AppCompatActivity {
    private ImageView iv_image;
    /* access modifiers changed from: private */
    public final TaggedLogger logger = ChatLogger.Companion.get("AttachmentActivity");
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    private WebView webView;

    public static final /* synthetic */ ProgressBar access$getProgressBar$p(AttachmentActivity attachmentActivity) {
        ProgressBar progressBar2 = attachmentActivity.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar2;
    }

    /* access modifiers changed from: private */
    public final UrlSigner getUrlSigner() {
        return ChatUI.Companion.instance().getUrlSigner();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1891R.C1897layout.stream_activity_attachment);
        View findViewById = findViewById(C1891R.C1895id.webView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.webView)");
        this.webView = (WebView) findViewById;
        View findViewById2 = findViewById(C1891R.C1895id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_image)");
        this.iv_image = (ImageView) findViewById2;
        View findViewById3 = findViewById(C1891R.C1895id.progressBar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.progressBar)");
        this.progressBar = (ProgressBar) findViewById3;
        configUIs();
        String stringExtra = getIntent().getStringExtra("type");
        String stringExtra2 = getIntent().getStringExtra("url");
        CharSequence charSequence = stringExtra;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = stringExtra2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                showAttachment(stringExtra, stringExtra2);
                return;
            }
        }
        this.logger.logE("This file can't be displayed. TYPE or URL is missing.");
        Toast.makeText(this, getString(C1891R.string.stream_ui_attachment_display_error), 0).show();
    }

    private final void configUIs() {
        ImageView imageView = this.iv_image;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iv_image");
        }
        imageView.setVisibility(8);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView2.setVisibility(8);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        WebSettings settings = webView3.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        webView3.setWebViewClient(new AppWebViewClients());
    }

    private final void showAttachment(String str, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) ModelType.attach_giphy)) {
            showGiphy(str2);
        } else {
            loadUrlToWeb(str2);
        }
    }

    private final void loadUrlToWeb(String str) {
        ImageView imageView = this.iv_image;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iv_image");
        }
        imageView.setVisibility(8);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView2.setVisibility(0);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar2.setVisibility(0);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView3.loadUrl(getUrlSigner().signFileUrl(str));
    }

    private final void showGiphy(String str) {
        if (str == null) {
            Toast.makeText(this, "Error!", 0).show();
            return;
        }
        ImageView imageView = this.iv_image;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iv_image");
        }
        imageView.setVisibility(0);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView2.setVisibility(8);
        ImageView imageView2 = this.iv_image;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iv_image");
        }
        ViewExtensionsKt.load$default(imageView2, getUrlSigner().signImageUrl(str), Integer.valueOf(C1891R.C1894drawable.stream_placeholder), (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 28, (Object) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0010"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/activity/AttachmentActivity$AppWebViewClients;", "Landroid/webkit/WebViewClient;", "(Lcom/getstream/sdk/chat/view/activity/AttachmentActivity;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "shouldOverrideUrlLoading", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AttachmentActivity.kt */
    private final class AppWebViewClients extends WebViewClient {
        public AppWebViewClients() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "url");
            webView.loadUrl(AttachmentActivity.this.getUrlSigner().signFileUrl(str));
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageFinished(webView, AttachmentActivity.this.getUrlSigner().signFileUrl(str));
            AttachmentActivity.access$getProgressBar$p(AttachmentActivity.this).setVisibility(8);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            TaggedLogger access$getLogger$p = AttachmentActivity.this.logger;
            access$getLogger$p.logE("The load failed due to an unknown error: " + webResourceError);
            if (webResourceError != null) {
                Toast.makeText(AttachmentActivity.this, webResourceError.toString(), 0).show();
            }
        }
    }
}
