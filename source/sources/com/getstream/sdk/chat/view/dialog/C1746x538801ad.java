package com.getstream.sdk.chat.view.dialog;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.LinearLayout;
import com.google.firebase.messaging.Constants;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/getstream/sdk/chat/view/dialog/MessageMoreActionDialog$setupMessageActions$6$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.dialog.MessageMoreActionDialog$setupMessageActions$$inlined$apply$lambda$2 */
/* compiled from: MessageMoreActionDialog.kt */
final class C1746x538801ad implements View.OnClickListener {
    final /* synthetic */ LinearLayout $this_apply;
    final /* synthetic */ MessageMoreActionDialog this$0;

    C1746x538801ad(LinearLayout linearLayout, MessageMoreActionDialog messageMoreActionDialog) {
        this.$this_apply = linearLayout;
        this.this$0 = messageMoreActionDialog;
    }

    public final void onClick(View view) {
        Object systemService = this.$this_apply.getContext().getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.ScionAnalytics.PARAM_LABEL, this.this$0.message.getText()));
        this.this$0.dismiss();
    }
}
