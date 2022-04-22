package com.getstream.sdk.chat.view.activity;

import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.p016ui.common.C1891R;

public class AttachmentDocumentActivity extends AppCompatActivity {
    private static final String TAG = "AttachmentDocumentActivity";
    /* access modifiers changed from: private */
    public TaggedLogger logger = ChatLogger.Companion.get(TAG);
    final int maxReloadCount = 5;
    ProgressBar progressBar;
    int reloadCount = 0;
    WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1891R.C1897layout.stream_activity_attachment_document);
        this.webView = (WebView) findViewById(C1891R.C1895id.webView);
        this.progressBar = (ProgressBar) findViewById(C1891R.C1895id.progressBar);
        configUIs();
        init();
    }

    private void init() {
        loadDocument(getIntent().getStringExtra("url"));
    }

    private void configUIs() {
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.webView.setWebViewClient(new AppWebViewClients());
    }

    public void loadDocument(String str) {
        this.progressBar.setVisibility(0);
        if (ChatClient.instance().isSocketConnected()) {
            WebView webView2 = this.webView;
            webView2.loadUrl("https://docs.google.com/gview?embedded=true&url=" + str);
            return;
        }
        finish();
    }

    private class AppWebViewClients extends WebViewClient {
        private AppWebViewClients() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            if (!webView.getTitle().equals("")) {
                AttachmentDocumentActivity.this.progressBar.setVisibility(8);
            } else if (AttachmentDocumentActivity.this.reloadCount < 5) {
                webView.reload();
                AttachmentDocumentActivity.this.reloadCount++;
            } else {
                AttachmentDocumentActivity.this.progressBar.setVisibility(8);
                Toast.makeText(AttachmentDocumentActivity.this, AttachmentDocumentActivity.this.getString(C1891R.string.stream_attachment_load_failed_unknown), 0).show();
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            TaggedLogger access$100 = AttachmentDocumentActivity.this.logger;
            access$100.logE("The load failed due to an unknown error: " + webResourceError);
            if (webResourceError != null) {
                Toast.makeText(AttachmentDocumentActivity.this, webResourceError.toString(), 0).show();
            }
        }
    }
}
