package p015io.getstream.chat.android.client.call;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.CallKt$sam$io_getstream_chat_android_client_call_Call_Callback$0 */
/* compiled from: Call.kt */
final class CallKt$sam$io_getstream_chat_android_client_call_Call_Callback$0 implements Call.Callback, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    CallKt$sam$io_getstream_chat_android_client_call_Call_Callback$0(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Call.Callback) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(result), "invoke(...)");
    }
}
