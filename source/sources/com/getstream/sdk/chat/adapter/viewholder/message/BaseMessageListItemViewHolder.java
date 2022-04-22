package com.getstream.sdk.chat.adapter.viewholder.message;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemPayloadDiff;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH$¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012R\u0014\u0010\u0007\u001a\u00020\b8DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "T", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bind", "", "messageListItem", "diff", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "(Lcom/getstream/sdk/chat/adapter/MessageListItem;Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;)V", "bindListItem", "bindListItem$stream_chat_android_release", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseMessageListItemViewHolder.kt */
public abstract class BaseMessageListItemViewHolder<T extends MessageListItem> extends RecyclerView.ViewHolder {
    /* access modifiers changed from: protected */
    public abstract void bind(T t, MessageListItemPayloadDiff messageListItemPayloadDiff);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMessageListItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public final void bindListItem$stream_chat_android_release(MessageListItem messageListItem, MessageListItemPayloadDiff messageListItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(messageListItem, "messageListItem");
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "diff");
        bind(messageListItem, messageListItemPayloadDiff);
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }
}
