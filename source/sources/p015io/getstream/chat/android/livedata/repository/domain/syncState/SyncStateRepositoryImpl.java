package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.model.SyncState;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepository;", "syncStateDao", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateDao;", "(Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateDao;)V", "insertSyncState", "", "syncState", "Lio/getstream/chat/android/livedata/model/SyncState;", "(Lio/getstream/chat/android/livedata/model/SyncState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSyncState", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl */
/* compiled from: SyncStateRepository.kt */
public final class SyncStateRepositoryImpl implements SyncStateRepository {
    private final SyncStateDao syncStateDao;

    public SyncStateRepositoryImpl(SyncStateDao syncStateDao2) {
        Intrinsics.checkNotNullParameter(syncStateDao2, "syncStateDao");
        this.syncStateDao = syncStateDao2;
    }

    public Object insertSyncState(SyncState syncState, Continuation<? super Unit> continuation) {
        Object insert = this.syncStateDao.insert(SyncStateMapperKt.toEntity(syncState), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectSyncState(java.lang.String r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.model.SyncState> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1 r0 = new io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl$selectSyncState$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateDao r6 = r4.syncStateDao
            r0.label = r3
            java.lang.Object r6 = r6.select(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity) r6
            if (r6 == 0) goto L_0x0049
            io.getstream.chat.android.livedata.model.SyncState r5 = p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateMapperKt.toModel(r6)
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepositoryImpl.selectSyncState(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
