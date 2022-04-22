package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.ReactionListItemAdapter;
import com.getstream.sdk.chat.adapter.viewholder.message.ExtensionsKt;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.utils.UiUtils;
import com.getstream.sdk.chat.utils.extensions.ConstraintLayoutKt;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import top.defaults.drawabletoolbox.DrawableBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/ReactionConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "context", "Landroid/content/Context;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "reactionViewClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "configParamsReadIndicator", "Lkotlin/Function1;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Landroid/content/Context;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lio/getstream/chat/android/client/models/Channel;Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;Lkotlin/jvm/functions/Function1;)V", "configParamsReactionRecyclerView", "messageItem", "configParamsReactionSpace", "configParamsReactionTail", "configReactionView", "configStyleReactionView", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ReactionConfigurator.kt */
public final class ReactionConfigurator implements Configurator {
    /* access modifiers changed from: private */
    public final StreamItemMessageBinding binding;
    private final Channel channel;
    /* access modifiers changed from: private */
    public final Function1<MessageListItem.MessageItem, Unit> configParamsReadIndicator;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final MessageListView.ReactionViewClickListener reactionViewClickListener;
    private final MessageListViewStyle style;

    public ReactionConfigurator(StreamItemMessageBinding streamItemMessageBinding, Context context2, MessageListViewStyle messageListViewStyle, Channel channel2, MessageListView.ReactionViewClickListener reactionViewClickListener2, Function1<? super MessageListItem.MessageItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(reactionViewClickListener2, "reactionViewClickListener");
        Intrinsics.checkNotNullParameter(function1, "configParamsReadIndicator");
        this.binding = streamItemMessageBinding;
        this.context = context2;
        this.style = messageListViewStyle;
        this.channel = channel2;
        this.reactionViewClickListener = reactionViewClickListener2;
        this.configParamsReadIndicator = function1;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configReactionView(messageItem);
        configParamsReactionSpace(messageItem);
        configParamsReactionTail(messageItem);
        configParamsReactionRecyclerView(messageItem);
    }

    private final void configReactionView(MessageListItem.MessageItem messageItem) {
        Message message = messageItem.getMessage();
        if (ExtensionsKt.isDeleted(message) || ExtensionsKt.isFailed(message) || !this.style.isReactionEnabled() || !this.channel.getConfig().isReactionsEnabled() || message.getReactionCounts().isEmpty()) {
            RecyclerView recyclerView = this.binding.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
            recyclerView.setVisibility(8);
            ImageView imageView = this.binding.ivTail;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
            imageView.setVisibility(8);
            Space space = this.binding.spaceReactionTail;
            Intrinsics.checkNotNullExpressionValue(space, "binding.spaceReactionTail");
            space.setVisibility(8);
            return;
        }
        configStyleReactionView(messageItem);
        RecyclerView recyclerView2 = this.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
        recyclerView2.setVisibility(0);
        ImageView imageView2 = this.binding.ivTail;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTail");
        imageView2.setVisibility(0);
        Space space2 = this.binding.spaceReactionTail;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.spaceReactionTail");
        space2.setVisibility(0);
        RecyclerView recyclerView3 = this.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.reactionsRecyclerView");
        recyclerView3.setAdapter(new ReactionListItemAdapter(this.context, message.getReactionCounts(), UiUtils.getReactionTypes(), this.style));
        this.binding.reactionsRecyclerView.setOnTouchListener(new ReactionConfigurator$configReactionView$1(this, message));
    }

    private final void configStyleReactionView(MessageListItem.MessageItem messageItem) {
        if (this.style.getReactionViewBgDrawable() == -1) {
            RecyclerView recyclerView = this.binding.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
            recyclerView.setBackground(new DrawableBuilder().rectangle().rounded().solidColor(this.style.getReactionViewBgColor()).solidColorPressed(-3355444).build());
            this.binding.ivTail.setImageDrawable(ContextCompat.getDrawable(this.context, messageItem.isMine() ? C1673R.C1676drawable.stream_tail_outgoing : C1673R.C1676drawable.stream_tail_incoming));
            ImageView imageView = this.binding.ivTail;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
            DrawableCompat.setTint(imageView.getDrawable(), this.style.getReactionViewBgColor());
            return;
        }
        int reactionViewBgDrawable = this.style.getReactionViewBgDrawable();
        RecyclerView recyclerView2 = this.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
        recyclerView2.setBackground(ContextCompat.getDrawable(this.context, reactionViewBgDrawable));
        ImageView imageView2 = this.binding.ivTail;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTail");
        imageView2.setVisibility(8);
    }

    private final void configParamsReactionSpace(MessageListItem.MessageItem messageItem) {
        ImageView imageView = this.binding.ivTail;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
        if (imageView.getVisibility() == 0) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ConstraintLayoutKt.updateConstraints(root, ReactionConfigurator$configParamsReactionSpace$1.INSTANCE);
            Space space = this.binding.spaceReactionTail;
            Intrinsics.checkNotNullExpressionValue(space, "binding.spaceReactionTail");
            ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int activeContentViewResId = ExtensionsKt.getActiveContentViewResId(messageItem.getMessage(), this.binding);
            if (messageItem.isMine()) {
                layoutParams2.endToStart = activeContentViewResId;
            } else {
                layoutParams2.startToEnd = activeContentViewResId;
            }
            Space space2 = this.binding.spaceReactionTail;
            Intrinsics.checkNotNullExpressionValue(space2, "binding.spaceReactionTail");
            space2.setLayoutParams(layoutParams2);
            this.binding.reactionsRecyclerView.post(new ReactionConfigurator$configParamsReactionSpace$2(this, layoutParams2));
        }
    }

    private final void configParamsReactionTail(MessageListItem.MessageItem messageItem) {
        ImageView imageView = this.binding.ivTail;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
        if (imageView.getVisibility() == 0) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ConstraintLayoutKt.updateConstraints(root, ReactionConfigurator$configParamsReactionTail$1.INSTANCE);
            ImageView imageView2 = this.binding.ivTail;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTail");
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (messageItem.isMine()) {
                Space space = this.binding.spaceReactionTail;
                Intrinsics.checkNotNullExpressionValue(space, "binding.spaceReactionTail");
                layoutParams2.startToStart = space.getId();
            } else {
                Space space2 = this.binding.spaceReactionTail;
                Intrinsics.checkNotNullExpressionValue(space2, "binding.spaceReactionTail");
                layoutParams2.endToEnd = space2.getId();
            }
            this.binding.reactionsRecyclerView.post(new ReactionConfigurator$configParamsReactionTail$2(this, layoutParams2));
        }
    }

    private final void configParamsReactionRecyclerView(MessageListItem.MessageItem messageItem) {
        RecyclerView recyclerView = this.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
        if (recyclerView.getVisibility() == 0) {
            RecyclerView recyclerView2 = this.binding.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
            recyclerView2.setVisibility(4);
            ImageView imageView = this.binding.ivTail;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
            imageView.setVisibility(4);
            this.binding.reactionsRecyclerView.post(new ReactionConfigurator$configParamsReactionRecyclerView$1(this, messageItem));
        }
    }
}
