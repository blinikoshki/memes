package com.getstream.sdk.chat.adapter.viewholder.message;

import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemPayloadDiff;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.AttachmentConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.Configurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.IndicatorConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.MarginConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.MessageTextConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReactionConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReplyConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.SpaceConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.UserAvatarConfigurator;
import com.getstream.sdk.chat.adapter.viewholder.message.configurators.UsernameAndDateConfigurator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u000204H\u0014R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/MessageListItemViewHolder;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "viewHolderFactory", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "dateFormatter", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "messageClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "messageLongClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "messageRetryListener", "Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "reactionViewClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "userClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "readStateClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lio/getstream/chat/android/client/models/Channel;Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;Lcom/getstream/sdk/chat/utils/DateFormatter;Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;)V", "attachmentConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/AttachmentConfigurator;", "indicatorConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/IndicatorConfigurator;", "marginConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/MarginConfigurator;", "messageTextConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/MessageTextConfigurator;", "reactionConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/ReactionConfigurator;", "replyConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/ReplyConfigurator;", "spaceConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/SpaceConfigurator;", "userAvatarConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/UserAvatarConfigurator;", "usernameAndDateConfigurator", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/UsernameAndDateConfigurator;", "bind", "", "messageListItem", "diff", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListItemViewHolder.kt */
public class MessageListItemViewHolder extends BaseMessageListItemViewHolder<MessageListItem.MessageItem> {
    private final AttachmentConfigurator attachmentConfigurator;
    /* access modifiers changed from: private */
    public final IndicatorConfigurator indicatorConfigurator;
    private final MarginConfigurator marginConfigurator;
    private final MessageTextConfigurator messageTextConfigurator;
    private final ReactionConfigurator reactionConfigurator;
    private final ReplyConfigurator replyConfigurator;
    private final SpaceConfigurator spaceConfigurator;
    private final UserAvatarConfigurator userAvatarConfigurator;
    private final UsernameAndDateConfigurator usernameAndDateConfigurator;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageListItemViewHolder(android.view.ViewGroup r17, com.getstream.sdk.chat.view.MessageListViewStyle r18, p015io.getstream.chat.android.client.models.Channel r19, com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory r20, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r21, com.getstream.sdk.chat.utils.DateFormatter r22, com.getstream.sdk.chat.view.MessageListView.MessageClickListener r23, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r24, com.getstream.sdk.chat.view.MessageListView.MessageRetryListener r25, com.getstream.sdk.chat.view.MessageListView.ReactionViewClickListener r26, com.getstream.sdk.chat.view.MessageListView.UserClickListener r27, com.getstream.sdk.chat.view.MessageListView.ReadStateClickListener r28, com.getstream.sdk.chat.databinding.StreamItemMessageBinding r29) {
        /*
            r16 = this;
            r0 = r16
            r9 = r18
            r10 = r20
            r1 = r22
            r11 = r27
            r12 = r28
            r13 = r29
            java.lang.String r2 = "parent"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r2 = "channel"
            r14 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            java.lang.String r2 = "viewHolderFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "bubbleHelper"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "dateFormatter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "messageClickListener"
            r15 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "messageLongClickListener"
            r7 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "messageRetryListener"
            r8 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "reactionViewClickListener"
            r6 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "userClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            java.lang.String r2 = "readStateClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r29.getRoot()
            java.lang.String r3 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.<init>(r2)
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.MarginConfigurator r2 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.MarginConfigurator
            r2.<init>(r13, r9)
            r0.marginConfigurator = r2
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.SpaceConfigurator r2 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.SpaceConfigurator
            r2.<init>(r13)
            r0.spaceConfigurator = r2
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.UsernameAndDateConfigurator r2 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.UsernameAndDateConfigurator
            r2.<init>(r13, r9, r1)
            r0.usernameAndDateConfigurator = r2
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.MessageTextConfigurator r4 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.MessageTextConfigurator
            android.content.Context r3 = r16.getContext()
            r1 = r4
            r2 = r29
            r14 = r4
            r4 = r18
            r6 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r0.messageTextConfigurator = r14
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.AttachmentConfigurator r1 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.AttachmentConfigurator
            r1.<init>(r13, r9, r10)
            r0.attachmentConfigurator = r1
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.IndicatorConfigurator r1 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.IndicatorConfigurator
            com.getstream.sdk.chat.view.ReadStateStyle r2 = r18.getReadStateStyle()
            r1.<init>(r13, r2, r12)
            r0.indicatorConfigurator = r1
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReactionConfigurator r8 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReactionConfigurator
            android.content.Context r3 = r16.getContext()
            com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder$reactionConfigurator$1 r1 = new com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder$reactionConfigurator$1
            r1.<init>(r0)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r1 = r8
            r2 = r29
            r5 = r19
            r6 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.reactionConfigurator = r8
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReplyConfigurator r8 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.ReplyConfigurator
            android.content.Context r3 = r16.getContext()
            com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder$replyConfigurator$1 r1 = new com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder$replyConfigurator$1
            r1.<init>(r0)
            r7 = r1
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r1 = r8
            r6 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.replyConfigurator = r8
            com.getstream.sdk.chat.adapter.viewholder.message.configurators.UserAvatarConfigurator r1 = new com.getstream.sdk.chat.adapter.viewholder.message.configurators.UserAvatarConfigurator
            android.content.Context r2 = r16.getContext()
            r1.<init>(r13, r2, r9, r11)
            r0.userAvatarConfigurator = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, io.getstream.chat.android.client.models.Channel, com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.utils.DateFormatter, com.getstream.sdk.chat.view.MessageListView$MessageClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageRetryListener, com.getstream.sdk.chat.view.MessageListView$ReactionViewClickListener, com.getstream.sdk.chat.view.MessageListView$UserClickListener, com.getstream.sdk.chat.view.MessageListView$ReadStateClickListener, com.getstream.sdk.chat.databinding.StreamItemMessageBinding):void");
    }

    /* access modifiers changed from: protected */
    public void bind(MessageListItem.MessageItem messageItem, MessageListItemPayloadDiff messageListItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(messageItem, "messageListItem");
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "diff");
        Configurator[] configuratorArr = new Configurator[9];
        boolean z = false;
        configuratorArr[0] = this.spaceConfigurator;
        configuratorArr[1] = this.marginConfigurator;
        MessageTextConfigurator messageTextConfigurator2 = this.messageTextConfigurator;
        UsernameAndDateConfigurator usernameAndDateConfigurator2 = null;
        if (!(messageListItemPayloadDiff.getText() || messageListItemPayloadDiff.getPositions() || messageListItemPayloadDiff.getDeleted() || messageListItemPayloadDiff.getReactions() || messageListItemPayloadDiff.getSyncStatus())) {
            messageTextConfigurator2 = null;
        }
        configuratorArr[2] = messageTextConfigurator2;
        AttachmentConfigurator attachmentConfigurator2 = this.attachmentConfigurator;
        if (!messageListItemPayloadDiff.getAttachments()) {
            attachmentConfigurator2 = null;
        }
        configuratorArr[3] = attachmentConfigurator2;
        ReactionConfigurator reactionConfigurator2 = this.reactionConfigurator;
        if (!messageListItemPayloadDiff.getReactions()) {
            reactionConfigurator2 = null;
        }
        configuratorArr[4] = reactionConfigurator2;
        ReplyConfigurator replyConfigurator2 = this.replyConfigurator;
        if (!messageListItemPayloadDiff.getReplies()) {
            replyConfigurator2 = null;
        }
        configuratorArr[5] = replyConfigurator2;
        IndicatorConfigurator indicatorConfigurator2 = this.indicatorConfigurator;
        if (messageListItemPayloadDiff.getSyncStatus() || messageListItemPayloadDiff.getReadBy()) {
            z = true;
        }
        if (!z) {
            indicatorConfigurator2 = null;
        }
        configuratorArr[6] = indicatorConfigurator2;
        UserAvatarConfigurator userAvatarConfigurator2 = this.userAvatarConfigurator;
        if (!messageListItemPayloadDiff.getPositions()) {
            userAvatarConfigurator2 = null;
        }
        configuratorArr[7] = userAvatarConfigurator2;
        UsernameAndDateConfigurator usernameAndDateConfigurator3 = this.usernameAndDateConfigurator;
        if (messageListItemPayloadDiff.getPositions()) {
            usernameAndDateConfigurator2 = usernameAndDateConfigurator3;
        }
        configuratorArr[8] = usernameAndDateConfigurator2;
        for (Configurator configure : CollectionsKt.listOfNotNull((T[]) configuratorArr)) {
            configure.configure(messageItem);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageListItemViewHolder(android.view.ViewGroup r17, com.getstream.sdk.chat.view.MessageListViewStyle r18, p015io.getstream.chat.android.client.models.Channel r19, com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory r20, com.getstream.sdk.chat.view.MessageListView.BubbleHelper r21, com.getstream.sdk.chat.utils.DateFormatter r22, com.getstream.sdk.chat.view.MessageListView.MessageClickListener r23, com.getstream.sdk.chat.view.MessageListView.MessageLongClickListener r24, com.getstream.sdk.chat.view.MessageListView.MessageRetryListener r25, com.getstream.sdk.chat.view.MessageListView.ReactionViewClickListener r26, com.getstream.sdk.chat.view.MessageListView.UserClickListener r27, com.getstream.sdk.chat.view.MessageListView.ReadStateClickListener r28, com.getstream.sdk.chat.databinding.StreamItemMessageBinding r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0021
            android.content.Context r0 = r17.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            java.lang.String r1 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r3 = r17
            com.getstream.sdk.chat.databinding.StreamItemMessageBinding r0 = com.getstream.sdk.chat.databinding.StreamItemMessageBinding.inflate(r0, r3, r1)
            java.lang.String r1 = "StreamItemMessageBinding….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r15 = r0
            goto L_0x0025
        L_0x0021:
            r3 = r17
            r15 = r29
        L_0x0025:
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.MessageListItemViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, io.getstream.chat.android.client.models.Channel, com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory, com.getstream.sdk.chat.view.MessageListView$BubbleHelper, com.getstream.sdk.chat.utils.DateFormatter, com.getstream.sdk.chat.view.MessageListView$MessageClickListener, com.getstream.sdk.chat.view.MessageListView$MessageLongClickListener, com.getstream.sdk.chat.view.MessageListView$MessageRetryListener, com.getstream.sdk.chat.view.MessageListView$ReactionViewClickListener, com.getstream.sdk.chat.view.MessageListView$UserClickListener, com.getstream.sdk.chat.view.MessageListView$ReadStateClickListener, com.getstream.sdk.chat.databinding.StreamItemMessageBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
