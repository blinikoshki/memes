package com.memes.plus.custom;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.plus.databinding.UserAvatarViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/databinding/UserAvatarViewBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
final class UserAvatarView$binding$2 extends Lambda implements Function0<UserAvatarViewBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UserAvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserAvatarView$binding$2(UserAvatarView userAvatarView, Context context) {
        super(0);
        this.this$0 = userAvatarView;
        this.$context = context;
    }

    public final UserAvatarViewBinding invoke() {
        return UserAvatarViewBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
    }
}
