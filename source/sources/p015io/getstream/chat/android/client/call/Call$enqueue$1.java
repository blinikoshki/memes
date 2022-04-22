package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "", "it", "Lio/getstream/chat/android/client/utils/Result;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.Call$enqueue$1 */
/* compiled from: Call.kt */
final class Call$enqueue$1 extends Lambda implements Function1<Result<T>, Unit> {
    public static final Call$enqueue$1 INSTANCE = new Call$enqueue$1();

    Call$enqueue$1() {
        super(1);
    }

    public final void invoke(Result<T> result) {
        Intrinsics.checkNotNullParameter(result, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result) obj);
        return Unit.INSTANCE;
    }
}
