package com.getstream.sdk.chat.adapter.viewholder.message;

import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemPayloadDiff;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/LoadingMoreViewHolder;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$LoadingMoreIndicatorItem;", "parent", "Landroid/view/ViewGroup;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemLoadingMoreBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/databinding/StreamItemLoadingMoreBinding;)V", "bind", "", "messageListItem", "diff", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LoadingMoreViewHolder.kt */
public final class LoadingMoreViewHolder extends BaseMessageListItemViewHolder<MessageListItem.LoadingMoreIndicatorItem> {
    /* access modifiers changed from: protected */
    public void bind(MessageListItem.LoadingMoreIndicatorItem loadingMoreIndicatorItem, MessageListItemPayloadDiff messageListItemPayloadDiff) {
        Intrinsics.checkNotNullParameter(loadingMoreIndicatorItem, "messageListItem");
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "diff");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoadingMoreViewHolder(android.view.ViewGroup r2, com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding r3) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
            java.lang.String r3 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.LoadingMoreViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoadingMoreViewHolder(android.view.ViewGroup r1, com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x001b
            android.content.Context r2 = r1.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            java.lang.String r3 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 0
            com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding r2 = com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding.inflate(r2, r1, r3)
            java.lang.String r3 = "StreamItemLoadingMoreBin…rent,\n        false\n    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x001b:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.LoadingMoreViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.databinding.StreamItemLoadingMoreBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
