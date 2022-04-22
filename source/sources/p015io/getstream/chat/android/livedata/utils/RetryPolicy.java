package p015io.getstream.chat.android.livedata.utils;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "", "retryTimeout", "", "client", "Lio/getstream/chat/android/client/ChatClient;", "attempt", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "shouldRetry", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.utils.RetryPolicy */
/* compiled from: RetryPolicy.kt */
public interface RetryPolicy {
    int retryTimeout(ChatClient chatClient, int i, ChatError chatError);

    boolean shouldRetry(ChatClient chatClient, int i, ChatError chatError);
}
