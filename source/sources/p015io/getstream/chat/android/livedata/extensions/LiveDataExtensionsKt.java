package p015io.getstream.chat.android.livedata.extensions;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, mo26107d2 = {"setOnUi", "", "T", "Landroidx/lifecycle/MutableLiveData;", "newValue", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.LiveDataExtensionsKt */
/* compiled from: LiveDataExtensions.kt */
public final class LiveDataExtensionsKt {
    public static final <T> Object setOnUi(MutableLiveData<T> mutableLiveData, T t, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatcherProvider.INSTANCE.getMain(), new LiveDataExtensionsKt$setOnUi$2(mutableLiveData, t, (Continuation) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
