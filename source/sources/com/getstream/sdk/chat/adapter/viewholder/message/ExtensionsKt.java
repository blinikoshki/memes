package com.getstream.sdk.chat.adapter.viewholder.message;

import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.model.ModelType;
import com.getstream.sdk.chat.view.AttachmentListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\t\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\n\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0007*\u00020\u0003H\u0000¨\u0006\f"}, mo26107d2 = {"getActiveContentViewResId", "", "message", "Lio/getstream/chat/android/client/models/Message;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "hasNoAttachments", "", "isDeleted", "isEphemeral", "isFailed", "isInThread", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final boolean isDeleted(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$isDeleted");
        return message.getDeletedAt() != null;
    }

    public static final boolean isFailed(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$isFailed");
        return message.getSyncStatus() == SyncStatus.FAILED_PERMANENTLY || Intrinsics.areEqual((Object) message.getType(), (Object) "error");
    }

    public static final boolean isInThread(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$isInThread");
        CharSequence parentId = message.getParentId();
        return !(parentId == null || parentId.length() == 0);
    }

    public static final boolean hasNoAttachments(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$hasNoAttachments");
        return message.getAttachments().isEmpty();
    }

    public static final boolean isEphemeral(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$isEphemeral");
        return Intrinsics.areEqual((Object) message.getType(), (Object) ModelType.message_ephemeral);
    }

    public static final int getActiveContentViewResId(Message message, StreamItemMessageBinding streamItemMessageBinding) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        if (!message.getAttachments().isEmpty()) {
            AttachmentListView attachmentListView = streamItemMessageBinding.attachmentview;
            Intrinsics.checkNotNullExpressionValue(attachmentListView, "binding.attachmentview");
            return attachmentListView.getId();
        }
        TextView textView = streamItemMessageBinding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
        return textView.getId();
    }
}
