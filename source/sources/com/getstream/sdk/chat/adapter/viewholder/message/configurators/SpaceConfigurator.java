package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.view.AttachmentListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/SpaceConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;)V", "configure", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SpaceConfigurator.kt */
public final class SpaceConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;

    public SpaceConfigurator(StreamItemMessageBinding streamItemMessageBinding) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        this.binding = streamItemMessageBinding;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        int i = 8;
        if (messageItem.getPositions().contains(MessageListItem.Position.TOP)) {
            Space space = this.binding.spaceHeader;
            Intrinsics.checkNotNullExpressionValue(space, "binding.spaceHeader");
            space.setVisibility(0);
            Space space2 = this.binding.spaceSameUser;
            Intrinsics.checkNotNullExpressionValue(space2, "binding.spaceSameUser");
            space2.setVisibility(8);
        } else {
            Space space3 = this.binding.spaceHeader;
            Intrinsics.checkNotNullExpressionValue(space3, "binding.spaceHeader");
            space3.setVisibility(8);
            Space space4 = this.binding.spaceSameUser;
            Intrinsics.checkNotNullExpressionValue(space4, "binding.spaceSameUser");
            space4.setVisibility(0);
        }
        Space space5 = this.binding.spaceAttachment;
        Intrinsics.checkNotNullExpressionValue(space5, "binding.spaceAttachment");
        View view = space5;
        AttachmentListView attachmentListView = this.binding.attachmentview;
        Intrinsics.checkNotNullExpressionValue(attachmentListView, "binding.attachmentview");
        boolean z = true;
        view.setVisibility(attachmentListView.getVisibility() == 0 ? 0 : 8);
        AttachmentListView attachmentListView2 = this.binding.attachmentview;
        Intrinsics.checkNotNullExpressionValue(attachmentListView2, "binding.attachmentview");
        if (attachmentListView2.getVisibility() == 0) {
            if (messageItem.getMessage().getText().length() == 0) {
                Space space6 = this.binding.spaceAttachment;
                Intrinsics.checkNotNullExpressionValue(space6, "binding.spaceAttachment");
                space6.setVisibility(8);
            }
        }
        Space space7 = this.binding.spaceReaction;
        Intrinsics.checkNotNullExpressionValue(space7, "binding.spaceReaction");
        View view2 = space7;
        RecyclerView recyclerView = this.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
        if (recyclerView.getVisibility() != 0) {
            z = false;
        }
        if (z) {
            i = 0;
        }
        view2.setVisibility(i);
    }
}
