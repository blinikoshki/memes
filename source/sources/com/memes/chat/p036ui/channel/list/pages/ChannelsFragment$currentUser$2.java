package com.memes.chat.p036ui.channel.list.pages;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/User;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelsFragment$currentUser$2 */
/* compiled from: ChannelsFragment.kt */
final class ChannelsFragment$currentUser$2 extends Lambda implements Function0<User> {
    public static final ChannelsFragment$currentUser$2 INSTANCE = new ChannelsFragment$currentUser$2();

    ChannelsFragment$currentUser$2() {
        super(0);
    }

    public final User invoke() {
        User currentUser = ChatClient.Companion.instance().getCurrentUser();
        if (currentUser != null) {
            return currentUser;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
