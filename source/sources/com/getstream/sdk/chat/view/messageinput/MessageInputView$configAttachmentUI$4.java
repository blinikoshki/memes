package com.getstream.sdk.chat.view.messageinput;

import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$configAttachmentUI$4 implements View.OnClickListener {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$configAttachmentUI$4(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final void onClick(View view) {
        ActivityResultLauncher access$getSelectFilesResultLauncher$p = this.this$0.selectFilesResultLauncher;
        if (access$getSelectFilesResultLauncher$p != null) {
            access$getSelectFilesResultLauncher$p.launch(Unit.INSTANCE);
        }
    }
}