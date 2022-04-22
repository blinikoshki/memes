package com.getstream.sdk.chat.view;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "bottom", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "oldBottom", "onLayoutChange"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$setMessageListItemAdapter$2 implements View.OnLayoutChangeListener {
    final /* synthetic */ MessageListView this$0;

    MessageListView$setMessageListItemAdapter$2(MessageListView messageListView) {
        this.this$0 = messageListView;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i4 < i8) {
            this.this$0.lockScrollUp = true;
            this.this$0.postDelayed(new Runnable(this) {
                final /* synthetic */ MessageListView$setMessageListItemAdapter$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.this$0.lockScrollUp = false;
                }
            }, 500);
        }
    }
}
