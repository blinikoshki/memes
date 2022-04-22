package com.getstream.sdk.chat.view.dialog;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/getstream/sdk/chat/view/dialog/MessageMoreActionDialog$setupMessageActions$5$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.dialog.MessageMoreActionDialog$setupMessageActions$$inlined$apply$lambda$1 */
/* compiled from: MessageMoreActionDialog.kt */
final class C1745x538801ac implements View.OnClickListener {
    final /* synthetic */ MessageMoreActionDialog this$0;

    C1745x538801ac(MessageMoreActionDialog messageMoreActionDialog) {
        this.this$0 = messageMoreActionDialog;
    }

    public final void onClick(View view) {
        this.this$0.onStartThreadHandler.invoke(this.this$0.message);
        this.this$0.dismiss();
    }
}
