package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class WebViewActivityBinding implements ViewBinding {
    public final WebView contentWebView;
    private final WebView rootView;

    private WebViewActivityBinding(WebView webView, WebView webView2) {
        this.rootView = webView;
        this.contentWebView = webView2;
    }

    public WebView getRoot() {
        return this.rootView;
    }

    public static WebViewActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WebViewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.web_view_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WebViewActivityBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        WebView webView = (WebView) view;
        return new WebViewActivityBinding(webView, webView);
    }
}
