package p015io.getstream.chat.android.livedata.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/utils/DefaultRetryPolicy;", "Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "()V", "retryTimeout", "", "client", "Lio/getstream/chat/android/client/ChatClient;", "attempt", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "shouldRetry", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.utils.DefaultRetryPolicy */
/* compiled from: DefaultRetryPolicy.kt */
public final class DefaultRetryPolicy implements RetryPolicy {
    public int retryTimeout(ChatClient chatClient, int i, ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatClient, "client");
        Intrinsics.checkNotNullParameter(chatError, "error");
        return i * 1000;
    }

    public boolean shouldRetry(ChatClient chatClient, int i, ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatClient, "client");
        Intrinsics.checkNotNullParameter(chatError, "error");
        return i < 3;
    }
}
