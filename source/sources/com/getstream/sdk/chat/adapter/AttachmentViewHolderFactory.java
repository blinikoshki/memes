package com.getstream.sdk.chat.adapter;

import android.view.ViewGroup;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolder;
import com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderFile;
import com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderMedia;
import com.getstream.sdk.chat.adapter.viewholder.attachment.BaseAttachmentViewHolder;
import com.getstream.sdk.chat.databinding.StreamItemAttachMediaBinding;
import com.getstream.sdk.chat.databinding.StreamItemAttachmentBinding;
import com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "", "()V", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "getBubbleHelper", "()Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "setBubbleHelper", "(Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;)V", "listenerContainer", "Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "getListenerContainer", "()Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "setListenerContainer", "(Lcom/getstream/sdk/chat/adapter/ListenerContainer;)V", "createAttachmentViewHolder", "Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "getAttachmentViewType", "attachmentItem", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolderFactory.kt */
public class AttachmentViewHolderFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FILE_ATTACHMENT = 4;
    public static final int GENERIC_ATTACHMENT = 1;
    public static final int IMAGE_ATTACHMENT = 2;
    public static final int VIDEO_ATTACHMENT = 3;
    public MessageListView.BubbleHelper bubbleHelper;
    public ListenerContainer listenerContainer;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory$Companion;", "", "()V", "FILE_ATTACHMENT", "", "GENERIC_ATTACHMENT", "IMAGE_ATTACHMENT", "VIDEO_ATTACHMENT", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AttachmentViewHolderFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ListenerContainer getListenerContainer() {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (listenerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
        }
        return listenerContainer2;
    }

    public final void setListenerContainer(ListenerContainer listenerContainer2) {
        Intrinsics.checkNotNullParameter(listenerContainer2, "<set-?>");
        this.listenerContainer = listenerContainer2;
    }

    public final MessageListView.BubbleHelper getBubbleHelper() {
        MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
        if (bubbleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
        }
        return bubbleHelper2;
    }

    public final void setBubbleHelper(MessageListView.BubbleHelper bubbleHelper2) {
        Intrinsics.checkNotNullParameter(bubbleHelper2, "<set-?>");
        this.bubbleHelper = bubbleHelper2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getAttachmentViewType(com.getstream.sdk.chat.adapter.AttachmentListItem r3) {
        /*
            r2 = this;
            java.lang.String r0 = "attachmentItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.getstream.chat.android.client.models.Attachment r3 = r3.getAttachment()
            java.lang.String r3 = r3.getType()
            r0 = 1
            if (r3 != 0) goto L_0x0011
            goto L_0x0040
        L_0x0011:
            int r1 = r3.hashCode()
            switch(r1) {
                case 3143036: goto L_0x0037;
                case 98361695: goto L_0x002d;
                case 100313435: goto L_0x0024;
                case 112202875: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0040
        L_0x0019:
            java.lang.String r1 = "video"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0040
            r0 = 3
            goto L_0x0040
        L_0x0024:
            java.lang.String r1 = "image"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0040
            goto L_0x0035
        L_0x002d:
            java.lang.String r1 = "giphy"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0040
        L_0x0035:
            r0 = 2
            goto L_0x0040
        L_0x0037:
            java.lang.String r1 = "file"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0040
            r0 = 4
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory.getAttachmentViewType(com.getstream.sdk.chat.adapter.AttachmentListItem):int");
    }

    public BaseAttachmentViewHolder createAttachmentViewHolder(ViewGroup viewGroup, int i, MessageListViewStyle messageListViewStyle, MessageListItem.MessageItem messageItem) {
        int i2 = i;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        if (i2 == 2 || i2 == 3) {
            MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
            if (bubbleHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
            }
            ListenerContainer listenerContainer2 = this.listenerContainer;
            if (listenerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.GiphySendListener giphySendListener = listenerContainer2.getGiphySendListener();
            ListenerContainer listenerContainer3 = this.listenerContainer;
            if (listenerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.AttachmentClickListener attachmentClickListener = listenerContainer3.getAttachmentClickListener();
            ListenerContainer listenerContainer4 = this.listenerContainer;
            if (listenerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            return new AttachmentViewHolderMedia(viewGroup, messageListViewStyle, bubbleHelper2, messageItem, giphySendListener, attachmentClickListener, listenerContainer4.getMessageLongClickListener(), (MessageListView.MessageLongClickListenerView) null, (StreamItemAttachMediaBinding) null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (DefaultConstructorMarker) null);
        } else if (i2 != 4) {
            MessageListView.BubbleHelper bubbleHelper3 = this.bubbleHelper;
            if (bubbleHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
            }
            ListenerContainer listenerContainer5 = this.listenerContainer;
            if (listenerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.AttachmentClickListener attachmentClickListener2 = listenerContainer5.getAttachmentClickListener();
            ListenerContainer listenerContainer6 = this.listenerContainer;
            if (listenerContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            return new AttachmentViewHolder(viewGroup, messageListViewStyle, bubbleHelper3, messageItem, attachmentClickListener2, listenerContainer6.getMessageLongClickListener(), (MessageListView.MessageLongClickListenerView) null, (StreamItemAttachmentBinding) null, 192, (DefaultConstructorMarker) null);
        } else {
            MessageListView.BubbleHelper bubbleHelper4 = this.bubbleHelper;
            if (bubbleHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
            }
            ListenerContainer listenerContainer7 = this.listenerContainer;
            if (listenerContainer7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            MessageListView.AttachmentClickListener attachmentClickListener3 = listenerContainer7.getAttachmentClickListener();
            ListenerContainer listenerContainer8 = this.listenerContainer;
            if (listenerContainer8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenerContainer");
            }
            return new AttachmentViewHolderFile(viewGroup, messageListViewStyle, bubbleHelper4, messageItem, attachmentClickListener3, listenerContainer8.getMessageLongClickListener(), (MessageListView.MessageLongClickListenerView) null, (StreamItemAttachmentFileBinding) null, 192, (DefaultConstructorMarker) null);
        }
    }
}
