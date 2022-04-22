package com.getstream.sdk.chat.view;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/getstream/sdk/chat/view/PreviewMessageView$binding$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: PreviewMessageView.kt */
final class PreviewMessageView$$special$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ PreviewMessageView this$0;

    PreviewMessageView$$special$$inlined$apply$lambda$1(PreviewMessageView previewMessageView) {
        this.this$0 = previewMessageView;
    }

    public final void onClick(View view) {
        this.this$0.getOnCloseClick().invoke();
    }
}
