package p015io.getstream.chat.android.core.internal.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/core/internal/coroutines/DispatcherProvider;", "", "()V", "<set-?>", "Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setIO$stream_chat_android_core", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "Main", "getMain", "setMain$stream_chat_android_core", "reset", "", "set", "mainDispatcher", "ioDispatcher", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.core.internal.coroutines.DispatcherProvider */
/* compiled from: DispatcherProvider.kt */
public final class DispatcherProvider {
    public static final DispatcherProvider INSTANCE = new DispatcherProvider();

    /* renamed from: IO */
    private static CoroutineDispatcher f1461IO = Dispatchers.getIO();
    private static CoroutineDispatcher Main = Dispatchers.getMain();

    private DispatcherProvider() {
    }

    public final CoroutineDispatcher getMain() {
        return Main;
    }

    public final void setMain$stream_chat_android_core(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<set-?>");
        Main = coroutineDispatcher;
    }

    public final CoroutineDispatcher getIO() {
        return f1461IO;
    }

    public final void setIO$stream_chat_android_core(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<set-?>");
        f1461IO = coroutineDispatcher;
    }

    public final void set(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "ioDispatcher");
        Main = coroutineDispatcher;
        f1461IO = coroutineDispatcher2;
    }

    public final void reset() {
        Main = Dispatchers.getMain();
        f1461IO = Dispatchers.getIO();
    }
}
