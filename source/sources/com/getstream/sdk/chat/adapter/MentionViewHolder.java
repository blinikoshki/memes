package com.getstream.sdk.chat.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.databinding.StreamItemMentionBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.messageinput.MessageInputStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MentionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemMentionBinding;", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "onUserClicked", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/models/User;", "", "(Lcom/getstream/sdk/chat/databinding/StreamItemMentionBinding;Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;Lkotlin/jvm/functions/Function1;)V", "bind", "user", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MentionsAdapter.kt */
public final class MentionViewHolder extends RecyclerView.ViewHolder {
    private final StreamItemMentionBinding binding;
    /* access modifiers changed from: private */
    public final Function1<User, Unit> onUserClicked;
    private final MessageInputStyle style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MentionViewHolder(StreamItemMentionBinding streamItemMentionBinding, MessageInputStyle messageInputStyle, Function1<? super User, Unit> function1) {
        super(streamItemMentionBinding.getRoot());
        Intrinsics.checkNotNullParameter(streamItemMentionBinding, "binding");
        Intrinsics.checkNotNullParameter(messageInputStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "onUserClicked");
        this.binding = streamItemMentionBinding;
        this.style = messageInputStyle;
        this.onUserClicked = function1;
    }

    public final void bind(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.binding.avatar.setUser(user, this.style.getAvatarStyle());
        TextView textView = this.binding.tvUsername;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvUsername");
        textView.setText(ContentUtils.getName(user));
        TextStyle inputBackgroundText = this.style.getInputBackgroundText();
        TextView textView2 = this.binding.tvUsername;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvUsername");
        inputBackgroundText.apply(textView2);
        this.binding.getRoot().setOnClickListener(new MentionViewHolder$bind$1(this, user));
    }
}
