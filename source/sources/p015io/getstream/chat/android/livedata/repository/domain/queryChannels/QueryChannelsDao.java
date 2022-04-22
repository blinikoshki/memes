package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsDao;", "", "deleteSortEntitiesFor", "", "queryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "queryChannelsEntity", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryWithSorts", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsWithSorts;", "(Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsWithSorts;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortInnerEntities", "", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/ChannelSortInnerEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "id", "ids", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao */
/* compiled from: QueryChannelsDao.kt */
public interface QueryChannelsDao {
    Object deleteSortEntitiesFor(String str, Continuation<? super Unit> continuation);

    Object insert(QueryChannelsEntity queryChannelsEntity, Continuation<? super Unit> continuation);

    Object insert(QueryChannelsWithSorts queryChannelsWithSorts, Continuation<? super Unit> continuation);

    Object insert(List<ChannelSortInnerEntity> list, Continuation<? super Unit> continuation);

    Object select(String str, Continuation<? super QueryChannelsWithSorts> continuation);

    Object select(List<String> list, Continuation<? super List<QueryChannelsWithSorts>> continuation);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$DefaultImpls */
    /* compiled from: QueryChannelsDao.kt */
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object insert(p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao r7, p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$insert$3
                if (r0 == 0) goto L_0x0014
                r0 = r9
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$insert$3 r0 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$insert$3) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L_0x0019
            L_0x0014:
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$insert$3 r0 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao$insert$3
                r0.<init>(r7, r9)
            L_0x0019:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0051
                if (r2 == r5) goto L_0x0044
                if (r2 == r4) goto L_0x0038
                if (r2 != r3) goto L_0x0030
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x008f
            L_0x0030:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0038:
                java.lang.Object r7 = r0.L$1
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r7 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts) r7
                java.lang.Object r8 = r0.L$0
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao r8 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x007d
            L_0x0044:
                java.lang.Object r7 = r0.L$1
                r8 = r7
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r8 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts) r8
                java.lang.Object r7 = r0.L$0
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao r7 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao) r7
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x0069
            L_0x0051:
                kotlin.ResultKt.throwOnFailure(r9)
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity r9 = r8.getQuery()
                java.lang.String r9 = r9.getId()
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r5
                java.lang.Object r9 = r7.deleteSortEntitiesFor(r9, r0)
                if (r9 != r1) goto L_0x0069
                return r1
            L_0x0069:
                io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity r9 = r8.getQuery()
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r9 = r7.insert((p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity) r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
                if (r9 != r1) goto L_0x007a
                return r1
            L_0x007a:
                r6 = r8
                r8 = r7
                r7 = r6
            L_0x007d:
                java.util.List r7 = r7.getSortInnerEntities()
                r9 = 0
                r0.L$0 = r9
                r0.L$1 = r9
                r0.label = r3
                java.lang.Object r7 = r8.insert((java.util.List<p015io.getstream.chat.android.livedata.repository.domain.queryChannels.ChannelSortInnerEntity>) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
                if (r7 != r1) goto L_0x008f
                return r1
            L_0x008f:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao.DefaultImpls.insert(io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao, io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
