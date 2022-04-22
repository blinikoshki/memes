package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.utils.extensions.ConstraintLayoutKt;
import com.getstream.sdk.chat.utils.extensions.MessageItemKt;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.ReadStateStyle;
import com.getstream.sdk.chat.view.ReadStateView;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/IndicatorConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "readStateStyle", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "readStateClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Lcom/getstream/sdk/chat/view/ReadStateStyle;Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;)V", "configDeliveredIndicator", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configParamsReadIndicator", "configParamsReadIndicator$stream_chat_android_release", "configReadIndicator", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: IndicatorConfigurator.kt */
public final class IndicatorConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    /* access modifiers changed from: private */
    public final MessageListView.ReadStateClickListener readStateClickListener;
    private final ReadStateStyle readStateStyle;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SyncStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SyncStatus.IN_PROGRESS.ordinal()] = 1;
            iArr[SyncStatus.SYNC_NEEDED.ordinal()] = 2;
            iArr[SyncStatus.COMPLETED.ordinal()] = 3;
            iArr[SyncStatus.FAILED_PERMANENTLY.ordinal()] = 4;
        }
    }

    public IndicatorConfigurator(StreamItemMessageBinding streamItemMessageBinding, ReadStateStyle readStateStyle2, MessageListView.ReadStateClickListener readStateClickListener2) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(readStateStyle2, "readStateStyle");
        Intrinsics.checkNotNullParameter(readStateClickListener2, "readStateClickListener");
        this.binding = streamItemMessageBinding;
        this.readStateStyle = readStateStyle2;
        this.readStateClickListener = readStateClickListener2;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configDeliveredIndicator(messageItem);
        configReadIndicator(messageItem);
        configParamsReadIndicator$stream_chat_android_release(messageItem);
    }

    private final void configDeliveredIndicator(MessageListItem.MessageItem messageItem) {
        ImageView imageView = this.binding.ivDeliver;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivDeliver");
        imageView.setVisibility(8);
        ProgressBar progressBar = this.binding.pbDeliver;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.pbDeliver");
        progressBar.setVisibility(8);
        Message message = messageItem.getMessage();
        if (!ExtensionsKt.isDeleted(message) && !ExtensionsKt.isFailed(message)) {
            if (!(message.getId().length() == 0) && !MessageItemKt.isNotBottomPosition(messageItem) && !(!messageItem.getMessageReadBy().isEmpty()) && messageItem.isMine() && !ExtensionsKt.isInThread(message) && !ExtensionsKt.isEphemeral(message) && this.readStateStyle.isDeliveredIndicatorEnabled()) {
                int i = WhenMappings.$EnumSwitchMapping$0[message.getSyncStatus().ordinal()];
                if (i == 1 || i == 2) {
                    ProgressBar progressBar2 = this.binding.pbDeliver;
                    Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.pbDeliver");
                    progressBar2.setVisibility(0);
                    ImageView imageView2 = this.binding.ivDeliver;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivDeliver");
                    imageView2.setVisibility(8);
                } else if (i == 3) {
                    ProgressBar progressBar3 = this.binding.pbDeliver;
                    Intrinsics.checkNotNullExpressionValue(progressBar3, "binding.pbDeliver");
                    progressBar3.setVisibility(8);
                    ImageView imageView3 = this.binding.ivDeliver;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivDeliver");
                    imageView3.setVisibility(0);
                } else if (i == 4) {
                    ProgressBar progressBar4 = this.binding.pbDeliver;
                    Intrinsics.checkNotNullExpressionValue(progressBar4, "binding.pbDeliver");
                    progressBar4.setVisibility(8);
                    ImageView imageView4 = this.binding.ivDeliver;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivDeliver");
                    imageView4.setVisibility(8);
                }
            }
        }
    }

    private final void configReadIndicator(MessageListItem.MessageItem messageItem) {
        List<ChannelUserRead> messageReadBy = messageItem.getMessageReadBy();
        Message message = messageItem.getMessage();
        if (ExtensionsKt.isDeleted(message) || ExtensionsKt.isFailed(message) || messageReadBy.isEmpty() || ExtensionsKt.isInThread(message) || ExtensionsKt.isEphemeral(message) || !this.readStateStyle.isReadStateEnabled()) {
            ReadStateView readStateView = this.binding.readState;
            Intrinsics.checkNotNullExpressionValue(readStateView, "binding.readState");
            readStateView.setVisibility(8);
            return;
        }
        ReadStateView readStateView2 = this.binding.readState;
        readStateView2.setVisibility(0);
        ReadStateView.setReads$default(readStateView2, messageReadBy, messageItem.isTheirs(), this.readStateStyle, (AvatarStyle) null, 8, (Object) null);
        readStateView2.setOnClickListener(new C1706xe7f1427a(this, messageReadBy, messageItem));
    }

    public final void configParamsReadIndicator$stream_chat_android_release(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        ReadStateView readStateView = this.binding.readState;
        Intrinsics.checkNotNullExpressionValue(readStateView, "binding.readState");
        if (!(readStateView.getVisibility() == 8)) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ConstraintLayoutKt.updateConstraints(root, IndicatorConfigurator$configParamsReadIndicator$1.INSTANCE);
            ReadStateView readStateView2 = this.binding.readState;
            Intrinsics.checkNotNullExpressionValue(readStateView2, "binding.readState");
            View view = readStateView2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
            int activeContentViewResId = ExtensionsKt.getActiveContentViewResId(messageItem.getMessage(), this.binding);
            if (messageItem.isMine()) {
                layoutParams3.endToStart = activeContentViewResId;
            } else {
                layoutParams3.startToEnd = activeContentViewResId;
            }
            layoutParams3.bottomToBottom = activeContentViewResId;
            layoutParams3.leftMargin = Utils.dpToPx(8);
            layoutParams3.rightMargin = Utils.dpToPx(8);
            view.setLayoutParams(layoutParams2);
        }
    }
}
