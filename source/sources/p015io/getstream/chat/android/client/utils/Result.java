package p015io.getstream.chat.android.client.utils;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/Result;", "T", "", "data", "(Ljava/lang/Object;)V", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "(Lio/getstream/chat/android/client/errors/ChatError;)V", "(Ljava/lang/Object;Lio/getstream/chat/android/client/errors/ChatError;)V", "Ljava/lang/Object;", "isError", "", "()Z", "isSuccess", "()Ljava/lang/Object;", "equals", "other", "hashCode", "", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.Result */
/* compiled from: Result.kt */
public final class Result<T> {
    private final T data;
    private final ChatError error;

    private Result(T t, ChatError chatError) {
        this.data = t;
        this.error = chatError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Result(T t) {
        this(t, (ChatError) null);
        Intrinsics.checkNotNullParameter(t, "data");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Result(ChatError chatError) {
        this((Object) null, chatError);
        Intrinsics.checkNotNullParameter(chatError, "error");
    }

    public final boolean isSuccess() {
        return this.data != null;
    }

    public final boolean isError() {
        return this.error != null;
    }

    public final T data() {
        T t = this.data;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Result is not successful. Check result.isSuccess before reading the data.".toString());
    }

    public final ChatError error() {
        ChatError chatError = this.error;
        if (chatError != null) {
            return chatError;
        }
        throw new IllegalStateException("Result is successful, not an error. Check result.isSuccess before reading the error.".toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type io.getstream.chat.android.client.utils.Result<*>");
        Result result = (Result) obj;
        if (!(!Intrinsics.areEqual((Object) this.data, (Object) result.data)) && !(!Intrinsics.areEqual((Object) this.error, (Object) result.error))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        T t = this.data;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        ChatError chatError = this.error;
        if (chatError != null) {
            i = chatError.hashCode();
        }
        return hashCode + i;
    }
}
