package com.memes.chat.p036ui.channel.members.options;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$updateUserActionState$1 */
/* compiled from: UserActionsViewModel.kt */
final /* synthetic */ class UserActionsViewModel$updateUserActionState$1 extends MutablePropertyReference0Impl {
    UserActionsViewModel$updateUserActionState$1(UserActionsViewModel userActionsViewModel) {
        super(userActionsViewModel, UserActionsViewModel.class, "userActionState", "getUserActionState()Lcom/memes/chat/ui/channel/members/options/UserActionState;", 0);
    }

    public Object get() {
        return UserActionsViewModel.access$getUserActionState$p((UserActionsViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((UserActionsViewModel) this.receiver).userActionState = (UserActionState) obj;
    }
}
