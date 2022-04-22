package p015io.getstream.chat.android.client.call;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u00020\u00042\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0017J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bH'¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/Call;", "T", "", "cancel", "", "enqueue", "callback", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "Callback", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.Call */
/* compiled from: Call.kt */
public interface Call<T> {

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H&¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/Call$Callback;", "T", "", "onResult", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.call.Call$Callback */
    /* compiled from: Call.kt */
    public interface Callback<T> {
        void onResult(Result<T> result);
    }

    void cancel();

    void enqueue();

    void enqueue(Callback<T> callback);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    void enqueue(Function1<? super Result<T>, Unit> function1);

    Result<T> execute();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.call.Call$DefaultImpls */
    /* compiled from: Call.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void enqueue$default(Call call, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = Call$enqueue$1.INSTANCE;
                }
                call.enqueue(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
        public static <T> void enqueue(Call<T> call, Function1<? super Result<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            call.enqueue((Callback<T>) new CallKt$sam$io_getstream_chat_android_client_call_Call_Callback$0(function1));
        }

        public static <T> void enqueue(Call<T> call) {
            call.enqueue((Callback<T>) Call$enqueue$2.INSTANCE);
        }
    }
}
