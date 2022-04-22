package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H@"}, mo26107d2 = {"selectSyncState", "", "userId", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/livedata/model/SyncState;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl", mo26808f = "SyncStateRepository.kt", mo26809i = {}, mo26810l = {16}, mo26811m = "selectSyncState", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1 */
/* compiled from: SyncStateRepository.kt */
final class SyncStateRepositoryImpl$selectSyncState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SyncStateRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncStateRepositoryImpl$selectSyncState$1(SyncStateRepositoryImpl syncStateRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = syncStateRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectSyncState((String) null, this);
    }
}
