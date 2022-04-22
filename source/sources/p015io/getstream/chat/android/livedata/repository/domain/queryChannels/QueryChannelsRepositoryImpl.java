package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepository;", "queryChannelsDao", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsDao;", "(Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsDao;)V", "insertQueryChannels", "", "queryChannelsSpec", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "(Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectQueriesChannelsByIds", "", "ids", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectQueryChannels", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl */
/* compiled from: QueryChannelsRepository.kt */
public final class QueryChannelsRepositoryImpl implements QueryChannelsRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final QueryChannelsDao queryChannelsDao;

    public QueryChannelsRepositoryImpl(QueryChannelsDao queryChannelsDao2) {
        Intrinsics.checkNotNullParameter(queryChannelsDao2, "queryChannelsDao");
        this.queryChannelsDao = queryChannelsDao2;
    }

    public Object insertQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super Unit> continuation) {
        Object insert = this.queryChannelsDao.insert(Companion.toEntity(queryChannelsSpec), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public Object selectQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super QueryChannelsSpec> continuation) {
        return selectById(queryChannelsSpec.getId(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectById(java.lang.String r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectById$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectById$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectById$1 r0 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectById$1
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
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao r6 = r4.queryChannelsDao
            r0.label = r3
            java.lang.Object r6 = r6.select((java.lang.String) r5, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts>) r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r6 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts) r6
            if (r6 == 0) goto L_0x004b
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$Companion r5 = Companion
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r5 = r5.toModel(r6)
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl.selectById(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b A[LOOP:0: B:16:0x0055->B:18:0x005b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectQueriesChannelsByIds(java.util.List<java.lang.String> r5, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1 r0 = new io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1
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
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsDao r6 = r4.queryChannelsDao
            r0.label = r3
            java.lang.Object r6 = r6.select((java.util.List<java.lang.String>) r5, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts>>) r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$Companion r5 = Companion
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L_0x0055:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0069
            java.lang.Object r1 = r6.next()
            io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts r1 = (p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts) r1
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r1 = r5.toModel(r1)
            r0.add(r1)
            goto L_0x0055
        L_0x0069:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl.selectQueriesChannelsByIds(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepositoryImpl$Companion;", "", "()V", "restoreQuerySort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "querySortData", "", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/ChannelSortInnerEntity;", "toEntity", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsWithSorts;", "queryChannelsSpec", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "toModel", "queryWithSort", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$Companion */
    /* compiled from: QueryChannelsRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final QueryChannelsWithSorts toEntity(QueryChannelsSpec queryChannelsSpec) {
            QueryChannelsEntity queryChannelsEntity = new QueryChannelsEntity(queryChannelsSpec.getId(), queryChannelsSpec.getFilter(), queryChannelsSpec.getCids());
            Iterable<Pair> list = queryChannelsSpec.getSort().toList();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                arrayList.add(new ChannelSortInnerEntity((String) pair.component1(), ((QuerySort.SortDirection) pair.component2()).getValue(), queryChannelsEntity.getId()));
            }
            return new QueryChannelsWithSorts(queryChannelsEntity, (List) arrayList);
        }

        /* access modifiers changed from: private */
        public final QueryChannelsSpec toModel(QueryChannelsWithSorts queryChannelsWithSorts) {
            return new QueryChannelsSpec(queryChannelsWithSorts.getQuery().getFilter(), QueryChannelsRepositoryImpl.Companion.restoreQuerySort(queryChannelsWithSorts.getSortInnerEntities()), queryChannelsWithSorts.getQuery().getCids());
        }

        private final QuerySort<Channel> restoreQuerySort(List<ChannelSortInnerEntity> list) {
            QuerySort<Channel> querySort = new QuerySort<>();
            for (ChannelSortInnerEntity channelSortInnerEntity : list) {
                int direction = channelSortInnerEntity.getDirection();
                if (direction == QuerySort.SortDirection.ASC.getValue()) {
                    QuerySort.Companion companion = QuerySort.Companion;
                    querySort = querySort.asc(channelSortInnerEntity.getName(), (KClass<Channel>) Reflection.getOrCreateKotlinClass(Channel.class));
                } else if (direction == QuerySort.SortDirection.DESC.getValue()) {
                    QuerySort.Companion companion2 = QuerySort.Companion;
                    querySort = querySort.desc(channelSortInnerEntity.getName(), (KClass<Channel>) Reflection.getOrCreateKotlinClass(Channel.class));
                } else {
                    throw new IllegalStateException("Direction value must be only asc or desc!".toString());
                }
            }
            return querySort;
        }
    }
}
