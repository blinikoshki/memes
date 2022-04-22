package com.memes.plus.p040ui.web_view;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "com/memes/plus/ui/web_view/WebViewDialog$webViewClient$2$1", "invoke", "()Lcom/memes/plus/ui/web_view/WebViewDialog$webViewClient$2$1;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.web_view.WebViewDialog$webViewClient$2 */
/* compiled from: WebViewDialog.kt */
final class WebViewDialog$webViewClient$2 extends Lambda implements Function0<C43591> {
    final /* synthetic */ WebViewDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewDialog$webViewClient$2(WebViewDialog webViewDialog) {
        super(0);
        this.this$0 = webViewDialog;
    }

    public final C43591 invoke() {
        return new WebViewClient(this) {
            final /* synthetic */ WebViewDialog$webViewClient$2 this$0;

            {
                this.this$0 = r1;
            }

            public void onPageFinished(WebView webView, String str) {
                this.this$0.this$0.getBinding().contentLayout.showContent();
            }
        };
    }
}
