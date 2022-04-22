package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/User;", "onUserClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$DEFAULT_USER_CLICK_LISTENER$1 implements MessageListView.UserClickListener {
    public static final MessageListView$DEFAULT_USER_CLICK_LISTENER$1 INSTANCE = new MessageListView$DEFAULT_USER_CLICK_LISTENER$1();

    MessageListView$DEFAULT_USER_CLICK_LISTENER$1() {
    }

    public final void onUserClick(User user) {
        Intrinsics.checkNotNullParameter(user, "it");
    }
}
