package com.memes.plus.p040ui.profile.user_profile;

import android.content.Context;
import android.view.View;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onBindingComplete$4 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onBindingComplete$4 implements View.OnClickListener {
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$onBindingComplete$4(UserProfileFragment userProfileFragment) {
        this.this$0 = userProfileFragment;
    }

    public final void onClick(View view) {
        UserProfile profile = UserProfileFragment.access$getViewModel$p(this.this$0).getProfile();
        String messagingId = profile != null ? profile.getMessagingId() : null;
        CharSequence charSequence = messagingId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ChatRouting chatRouting = ChatRouting.INSTANCE;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.this$0.startActivity(chatRouting.getDirectMessagingIntent(requireContext, messagingId));
        }
    }
}
