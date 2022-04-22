package com.getstream.sdk.chat.view.messageinput;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$onAttachedToWindow$2<O> implements ActivityResultCallback<List<? extends Uri>> {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$onAttachedToWindow$2(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final void onActivityResult(List<? extends Uri> list) {
        MessageInputController access$getMessageInputController$p = this.this$0.getMessageInputController();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        access$getMessageInputController$p.onFilesSelected$stream_chat_android_release(list);
    }
}
