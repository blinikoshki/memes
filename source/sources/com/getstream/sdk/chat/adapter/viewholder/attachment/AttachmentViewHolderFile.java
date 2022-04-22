package com.getstream.sdk.chat.adapter.viewholder.attachment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.adapter.AttachmentListItem;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.UiUtils;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/attachment/AttachmentViewHolderFile;", "Lcom/getstream/sdk/chat/adapter/viewholder/attachment/BaseAttachmentViewHolder;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "clickListener", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "longClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "longClickListenerView", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemAttachmentFileBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;Lcom/getstream/sdk/chat/databinding/StreamItemAttachmentFileBinding;)V", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "applyStyle", "", "bind", "attachmentListItem", "Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "configAttachment", "configClickListeners", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentViewHolderFile.kt */
public final class AttachmentViewHolderFile extends BaseAttachmentViewHolder {
    /* access modifiers changed from: private */
    public Attachment attachment;
    private final StreamItemAttachmentFileBinding binding;
    private final MessageListView.BubbleHelper bubbleHelper;
    /* access modifiers changed from: private */
    public final MessageListView.AttachmentClickListener clickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListener longClickListener;
    /* access modifiers changed from: private */
    public final MessageListView.MessageLongClickListenerView longClickListenerView;
    /* access modifiers changed from: private */
    public final MessageListItem.MessageItem messageItem;
    private final MessageListViewStyle style;

    public static final /* synthetic */ Attachment access$getAttachment$p(AttachmentViewHolderFile attachmentViewHolderFile) {
        Attachment attachment2 = attachmentViewHolderFile.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        return attachment2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AttachmentViewHolderFile(android.view.ViewGroup r12, com.getstream.sdk.chat.view.MessageListViewStyle r13, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r14, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r15, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r16, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r17, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r18, com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000b
            r1 = 0
            com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView r1 = (com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView) r1
            r9 = r1
            goto L_0x000d
        L_0x000b:
            r9 = r18
        L_0x000d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002b
            android.content.Context r0 = r12.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            java.lang.String r1 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r3 = r12
            com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding r0 = com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding.inflate(r0, r12, r1)
            java.lang.String r1 = "StreamItemAttachmentFile….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10 = r0
            goto L_0x002e
        L_0x002b:
            r3 = r12
            r10 = r19
        L_0x002e:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderFile.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AttachmentViewHolderFile(android.view.ViewGroup r2, com.getstream.sdk.chat.view.MessageListViewStyle r3, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r4, com.getstream.sdk.chat.adapter.MessageListItem.MessageItem r5, com.getstream.sdk.chat.view.MessageListView.AttachmentClickListener r6, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r7, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListenerView r8, com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding r9) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "bubbleHelper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "messageItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "clickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r9.getRoot()
            java.lang.String r0 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            r1.style = r3
            r1.bubbleHelper = r4
            r1.messageItem = r5
            r1.clickListener = r6
            r1.longClickListener = r7
            r1.longClickListenerView = r8
            r1.binding = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.attachment.AttachmentViewHolderFile.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.adapter.MessageListItem$MessageItem, com.getstream.sdk.chat.view.MessageListView$AttachmentClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListenerView, com.getstream.sdk.chat.databinding.StreamItemAttachmentFileBinding):void");
    }

    public void bind(AttachmentListItem attachmentListItem) {
        Intrinsics.checkNotNullParameter(attachmentListItem, "attachmentListItem");
        this.attachment = attachmentListItem.getAttachment();
        applyStyle();
        configAttachment();
        configClickListeners();
    }

    private final void applyStyle() {
        if (this.messageItem.isMine()) {
            TextStyle attachmentTitleTextMine = this.style.getAttachmentTitleTextMine();
            TextView textView = this.binding.tvFileTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvFileTitle");
            attachmentTitleTextMine.apply(textView);
            TextStyle attachmentFileSizeTextMine = this.style.getAttachmentFileSizeTextMine();
            TextView textView2 = this.binding.tvFileSize;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvFileSize");
            attachmentFileSizeTextMine.apply(textView2);
            return;
        }
        TextStyle attachmentTitleTextTheirs = this.style.getAttachmentTitleTextTheirs();
        TextView textView3 = this.binding.tvFileTitle;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvFileTitle");
        attachmentTitleTextTheirs.apply(textView3);
        TextStyle attachmentFileSizeTextTheirs = this.style.getAttachmentFileSizeTextTheirs();
        TextView textView4 = this.binding.tvFileSize;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvFileSize");
        attachmentFileSizeTextTheirs.apply(textView4);
    }

    private final void configAttachment() {
        TextView textView = this.binding.tvFileSize;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvFileSize");
        UiUtils uiUtils = UiUtils.INSTANCE;
        Attachment attachment2 = this.attachment;
        if (attachment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        textView.setText(uiUtils.getFileSizeHumanized(attachment2.getFileSize()));
        ImageView imageView = this.binding.ivFileThumb;
        UiUtils uiUtils2 = UiUtils.INSTANCE;
        Attachment attachment3 = this.attachment;
        if (attachment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        imageView.setImageResource(uiUtils2.getIcon(attachment3.getMimeType()));
        TextView textView2 = this.binding.tvFileTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvFileTitle");
        Attachment attachment4 = this.attachment;
        if (attachment4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        textView2.setText(attachment4.getTitle());
        MessageListView.BubbleHelper bubbleHelper2 = this.bubbleHelper;
        Message message = this.messageItem.getMessage();
        boolean isMine = this.messageItem.isMine();
        List<MessageListItem.Position> positions = this.messageItem.getPositions();
        Attachment attachment5 = this.attachment;
        if (attachment5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.ATTACHMENT);
        }
        Drawable drawableForAttachment = bubbleHelper2.getDrawableForAttachment(message, isMine, positions, attachment5);
        ConstraintLayout constraintLayout = this.binding.attachmentview;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.attachmentview");
        constraintLayout.setBackground(drawableForAttachment);
    }

    private final void configClickListeners() {
        this.binding.attachmentview.setOnClickListener(new AttachmentViewHolderFile$configClickListeners$1(this));
        this.binding.attachmentview.setOnLongClickListener(new AttachmentViewHolderFile$configClickListeners$2(this));
    }
}
