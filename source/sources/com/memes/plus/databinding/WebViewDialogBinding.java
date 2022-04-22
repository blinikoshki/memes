package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class WebViewDialogBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final WebView contentWebView;
    private final ContentLayout rootView;

    private WebViewDialogBinding(ContentLayout contentLayout2, ContentLayout contentLayout3, WebView webView) {
        this.rootView = contentLayout2;
        this.contentLayout = contentLayout3;
        this.contentWebView = webView;
    }

    public ContentLayout getRoot() {
        return this.rootView;
    }

    public static WebViewDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WebViewDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.web_view_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WebViewDialogBinding bind(View view) {
        ContentLayout contentLayout2 = (ContentLayout) view;
        WebView webView = (WebView) view.findViewById(C4199R.C4203id.content_web_view);
        if (webView != null) {
            return new WebViewDialogBinding(contentLayout2, contentLayout2, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C4199R.C4203id.content_web_view)));
    }
}
