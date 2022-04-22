package com.getstream.sdk.chat.view.messageinput;

import android.os.Bundle;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo26107d2 = {"<anonymous>", "", "inputContentInfo", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "kotlin.jvm.PlatformType", "flags", "", "<anonymous parameter 2>", "Landroid/os/Bundle;", "onCommitContent"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$configInputEditText$3 implements InputConnectionCompat.OnCommitContentListener {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$configInputEditText$3(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        MessageInputView messageInputView = this.this$0;
        Intrinsics.checkNotNullExpressionValue(inputContentInfoCompat, "inputContentInfo");
        return messageInputView.sendGifFromKeyboard(inputContentInfoCompat, i);
    }
}
