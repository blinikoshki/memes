package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.livedata.model.SyncState;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepository;", "", "insertSyncState", "", "syncState", "Lio/getstream/chat/android/livedata/model/SyncState;", "(Lio/getstream/chat/android/livedata/model/SyncState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSyncState", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepository */
/* compiled from: SyncStateRepository.kt */
public interface SyncStateRepository {
    Object insertSyncState(SyncState syncState, Continuation<? super Unit> continuation);

    Object selectSyncState(String str, Continuation<? super SyncState> continuation);
}
