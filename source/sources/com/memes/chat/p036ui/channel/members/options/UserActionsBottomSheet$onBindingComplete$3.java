package com.memes.chat.p036ui.channel.members.options;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "state", "Lcom/memes/chat/ui/channel/members/options/UserActionState;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet$onBindingComplete$3 */
/* compiled from: UserActionsBottomSheet.kt */
final class UserActionsBottomSheet$onBindingComplete$3<T> implements Observer<UserActionState> {
    final /* synthetic */ UserActionsBottomSheet this$0;

    UserActionsBottomSheet$onBindingComplete$3(UserActionsBottomSheet userActionsBottomSheet) {
        this.this$0 = userActionsBottomSheet;
    }

    public final void onChanged(UserActionState userActionState) {
        UserActionsBottomSheet userActionsBottomSheet = this.this$0;
        Intrinsics.checkNotNullExpressionValue(userActionState, "state");
        userActionsBottomSheet.applyState(userActionState);
    }
}
