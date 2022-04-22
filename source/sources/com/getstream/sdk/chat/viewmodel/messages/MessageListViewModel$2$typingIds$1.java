package com.getstream.sdk.chat.viewmodel.messages;

import androidx.arch.core.util.Function;
import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/User;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lio/getstream/chat/android/client/models/TypingEvent;", "apply"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$2$typingIds$1<I, O> implements Function<TypingEvent, List<? extends User>> {
    public static final MessageListViewModel$2$typingIds$1 INSTANCE = new MessageListViewModel$2$typingIds$1();

    MessageListViewModel$2$typingIds$1() {
    }

    public final List<User> apply(TypingEvent typingEvent) {
        return typingEvent.component2();
    }
}
