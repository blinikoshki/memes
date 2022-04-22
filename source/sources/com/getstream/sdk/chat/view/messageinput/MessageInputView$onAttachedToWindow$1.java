package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "file", "Ljava/io/File;", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
final class MessageInputView$onAttachedToWindow$1<O> implements ActivityResultCallback<File> {
    final /* synthetic */ MessageInputView this$0;

    MessageInputView$onAttachedToWindow$1(MessageInputView messageInputView) {
        this.this$0 = messageInputView;
    }

    public final void onActivityResult(File file) {
        if (file != null) {
            MessageInputController access$getMessageInputController$p = this.this$0.getMessageInputController();
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            access$getMessageInputController$p.onFileCaptured$stream_chat_android_release(context, file);
        }
    }
}
