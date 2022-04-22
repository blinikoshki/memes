package p015io.getstream.chat.android.client.utils;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"io/getstream/chat/android/client/utils/ThreadLocalDelegate$threadLocal$1", "Ljava/lang/ThreadLocal;", "initialValue", "()Ljava/lang/Object;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.ThreadLocalDelegate$threadLocal$1 */
/* compiled from: ThreadLocalDelegate.kt */
public final class ThreadLocalDelegate$threadLocal$1 extends ThreadLocal<T> {
    final /* synthetic */ ThreadLocalDelegate this$0;

    ThreadLocalDelegate$threadLocal$1(ThreadLocalDelegate threadLocalDelegate) {
        this.this$0 = threadLocalDelegate;
    }

    /* access modifiers changed from: protected */
    public T initialValue() {
        return this.this$0.value.invoke();
    }
}
