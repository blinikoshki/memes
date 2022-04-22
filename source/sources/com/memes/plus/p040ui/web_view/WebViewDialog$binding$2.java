package com.memes.plus.p040ui.web_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.memes.plus.databinding.WebViewDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/databinding/WebViewDialogBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.web_view.WebViewDialog$binding$2 */
/* compiled from: WebViewDialog.kt */
final class WebViewDialog$binding$2 extends Lambda implements Function0<WebViewDialogBinding> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewDialog$binding$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final WebViewDialogBinding invoke() {
        return WebViewDialogBinding.inflate(LayoutInflater.from(this.$context), (ViewGroup) null, false);
    }
}
