package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.databinding.StreamItemMessageBinding;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.utils.extensions.MessageItemKt;
import com.getstream.sdk.chat.view.AvatarView;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/UserAvatarConfigurator;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/configurators/Configurator;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;", "context", "Landroid/content/Context;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "userClickListener", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "(Lcom/getstream/sdk/chat/databinding/StreamItemMessageBinding;Landroid/content/Context;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;)V", "configParamsUserAvatar", "", "messageItem", "Lcom/getstream/sdk/chat/adapter/MessageListItem$MessageItem;", "configUserAvatar", "configure", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarConfigurator.kt */
public final class UserAvatarConfigurator implements Configurator {
    private final StreamItemMessageBinding binding;
    private final Context context;
    private final MessageListViewStyle style;
    /* access modifiers changed from: private */
    public final MessageListView.UserClickListener userClickListener;

    public UserAvatarConfigurator(StreamItemMessageBinding streamItemMessageBinding, Context context2, MessageListViewStyle messageListViewStyle, MessageListView.UserClickListener userClickListener2) {
        Intrinsics.checkNotNullParameter(streamItemMessageBinding, "binding");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(userClickListener2, "userClickListener");
        this.binding = streamItemMessageBinding;
        this.context = context2;
        this.style = messageListViewStyle;
        this.userClickListener = userClickListener2;
    }

    public void configure(MessageListItem.MessageItem messageItem) {
        Intrinsics.checkNotNullParameter(messageItem, "messageItem");
        configUserAvatar(messageItem);
        configParamsUserAvatar(messageItem);
    }

    private final void configUserAvatar(MessageListItem.MessageItem messageItem) {
        Message message = messageItem.getMessage();
        AvatarView avatarView = this.binding.avatar;
        avatarView.setVisibility(MessageItemKt.isBottomPosition(messageItem) ? 0 : 8);
        avatarView.setUser(message.getUser(), this.style.getAvatarStyle());
        avatarView.setOnClickListener(new UserAvatarConfigurator$configUserAvatar$$inlined$apply$lambda$1(this, messageItem, message));
    }

    private final void configParamsUserAvatar(MessageListItem.MessageItem messageItem) {
        AvatarView avatarView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(avatarView, "binding.avatar");
        if (!(avatarView.getVisibility() == 8)) {
            AvatarView avatarView2 = this.binding.avatar;
            Intrinsics.checkNotNullExpressionValue(avatarView2, "binding.avatar");
            View view = avatarView2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
            int dimension = (int) this.context.getResources().getDimension(C1673R.dimen.stream_message_avatar_margin);
            if (messageItem.isTheirs()) {
                layoutParams3.startToStart = 0;
                layoutParams3.setMarginStart(dimension);
                layoutParams3.setMarginEnd(0);
                layoutParams3.horizontalBias = 0.0f;
            } else {
                layoutParams3.setMarginStart(Utils.dpToPx(15));
                layoutParams3.setMarginStart(0);
                layoutParams3.setMarginEnd(dimension);
                layoutParams3.horizontalBias = 1.0f;
            }
            view.setLayoutParams(layoutParams2);
        }
    }
}
