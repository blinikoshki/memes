package com.getstream.sdk.chat.adapter.viewholder.message;

import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemPayloadDiff;
import com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.view.AvatarView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/viewholder/message/TypingIndicatorViewHolder;", "Lcom/getstream/sdk/chat/adapter/viewholder/message/BaseMessageListItemViewHolder;", "Lcom/getstream/sdk/chat/adapter/MessageListItem$TypingItem;", "parent", "Landroid/view/ViewGroup;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemTypeIndicatorBinding;", "(Landroid/view/ViewGroup;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lcom/getstream/sdk/chat/databinding/StreamItemTypeIndicatorBinding;)V", "bind", "", "messageListItem", "diff", "Lcom/getstream/sdk/chat/adapter/MessageListItemPayloadDiff;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TypingIndicatorViewHolder.kt */
public final class TypingIndicatorViewHolder extends BaseMessageListItemViewHolder<MessageListItem.TypingItem> {
    private final StreamItemTypeIndicatorBinding binding;
    private final MessageListViewStyle style;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TypingIndicatorViewHolder(android.view.ViewGroup r2, com.getstream.sdk.chat.view.MessageListViewStyle r3, com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding r4) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r4.getRoot()
            java.lang.String r0 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r1.<init>(r2)
            r1.style = r3
            r1.binding = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.TypingIndicatorViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding):void");
    }

    /* access modifiers changed from: protected */
    public void bind(MessageListItem.TypingItem typingItem, MessageListItemPayloadDiff messageListItemPayloadDiff) {
        int i;
        Intrinsics.checkNotNullParameter(typingItem, "messageListItem");
        Intrinsics.checkNotNullParameter(messageListItemPayloadDiff, "diff");
        LinearLayout linearLayout = this.binding.llTypingIndicator;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llTypingIndicator");
        linearLayout.setVisibility(0);
        ImageView imageView = this.binding.ivTypingIndicator;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTypingIndicator");
        imageView.setVisibility(0);
        this.binding.llTypingIndicator.removeAllViews();
        int i2 = 0;
        for (User user : typingItem.getUsers()) {
            AvatarView avatarView = new AvatarView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            avatarView.setUser(user, this.style.getAvatarStyle());
            int avatarHeight = this.style.getAvatarStyle().getAvatarHeight();
            int avatarWidth = this.style.getAvatarStyle().getAvatarWidth();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(avatarWidth, avatarHeight);
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams;
            if (i2 == 0) {
                i = 0;
            } else {
                i = (-avatarWidth) / 2;
            }
            marginLayoutParams.setMargins(i, 0, 0, 0);
            avatarView.setLayoutParams(layoutParams);
            this.binding.llTypingIndicator.addView(avatarView);
            i2++;
        }
        ImageView imageView2 = this.binding.ivTypingIndicator;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTypingIndicator");
        ViewExtensionsKt.load$default(imageView2, Integer.valueOf(C1673R.raw.stream_typing), (Integer) null, (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 30, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TypingIndicatorViewHolder(android.view.ViewGroup r1, com.getstream.sdk.chat.view.MessageListViewStyle r2, com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x001b
            android.content.Context r3 = r1.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            java.lang.String r4 = "LayoutInflater.from(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = 0
            com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding r3 = com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding.inflate(r3, r1, r4)
            java.lang.String r4 = "StreamItemTypeIndicatorB….inflater, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x001b:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.viewholder.message.TypingIndicatorViewHolder.<init>(android.view.ViewGroup, com.getstream.sdk.chat.view.MessageListViewStyle, com.getstream.sdk.chat.databinding.StreamItemTypeIndicatorBinding, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
