package com.getstream.sdk.chat.adapter;

import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "realListener", "Lkotlin/Function0;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ListenerContainerImpl.kt */
final class ListenerContainerImpl$userClickListener$2 extends Lambda implements Function1<Function0<? extends MessageListView.UserClickListener>, MessageListView.UserClickListener> {
    public static final ListenerContainerImpl$userClickListener$2 INSTANCE = new ListenerContainerImpl$userClickListener$2();

    ListenerContainerImpl$userClickListener$2() {
        super(1);
    }

    public final MessageListView.UserClickListener invoke(final Function0<? extends MessageListView.UserClickListener> function0) {
        Intrinsics.checkNotNullParameter(function0, "realListener");
        return new MessageListView.UserClickListener() {
            public final void onUserClick(User user) {
                Intrinsics.checkNotNullParameter(user, "user");
                ((MessageListView.UserClickListener) function0.invoke()).onUserClick(user);
            }
        };
    }
}
