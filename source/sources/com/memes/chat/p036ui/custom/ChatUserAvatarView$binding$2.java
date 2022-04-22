package com.memes.chat.p036ui.custom;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.chat.databinding.VChatUserAvatarViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/databinding/VChatUserAvatarViewBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$binding$2 */
/* compiled from: ChatUserAvatarView.kt */
final class ChatUserAvatarView$binding$2 extends Lambda implements Function0<VChatUserAvatarViewBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ChatUserAvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatUserAvatarView$binding$2(ChatUserAvatarView chatUserAvatarView, Context context) {
        super(0);
        this.this$0 = chatUserAvatarView;
        this.$context = context;
    }

    public final VChatUserAvatarViewBinding invoke() {
        return VChatUserAvatarViewBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
    }
}
