package com.iab.omid.library.giphy.publisher;

import android.webkit.WebView;

/* renamed from: com.iab.omid.library.giphy.publisher.a */
public class C3992a extends AdSessionStatePublisher {
    public C3992a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo55987a(webView);
    }
}
