package p015io.getstream.chat.android.client.call;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00030\u0004B'\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/MapCall;", "T", "", "K", "Lio/getstream/chat/android/client/call/Call;", "call", "mapper", "Lkotlin/Function1;", "(Lio/getstream/chat/android/client/call/Call;Lkotlin/jvm/functions/Function1;)V", "canceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCanceled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setCanceled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "Lio/getstream/chat/android/client/utils/Result;", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.MapCall */
/* compiled from: MapCall.kt */
public final class MapCall<T, K> implements Call<K> {
    private final Call<T> call;
    private AtomicBoolean canceled = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final Function1<T, K> mapper;

    public MapCall(Call<T> call2, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(function1, "mapper");
        this.call = call2;
        this.mapper = function1;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<K>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    /* access modifiers changed from: protected */
    public final AtomicBoolean getCanceled() {
        return this.canceled;
    }

    /* access modifiers changed from: protected */
    public final void setCanceled(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.canceled = atomicBoolean;
    }

    public void cancel() {
        this.canceled.set(true);
    }

    public Result<K> execute() {
        Result<T> execute = this.call.execute();
        if (execute.isSuccess()) {
            return new Result<>(this.mapper.invoke(execute.data()));
        }
        return new Result<>(execute.error());
    }

    public void enqueue(Call.Callback<K> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.call.enqueue(new MapCall$enqueue$1(this, callback));
    }
}
