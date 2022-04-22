package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p015io.getstream.chat.android.livedata.model.ChannelConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016J\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepository;", "channelConfigDao", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigDao;", "(Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigDao;)V", "channelConfigs", "", "", "Lio/getstream/chat/android/livedata/model/ChannelConfig;", "cacheChannelConfigs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearChannelConfigsCache", "insertChannelConfig", "config", "(Lio/getstream/chat/android/livedata/model/ChannelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannelConfigs", "configs", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelConfig", "channelType", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl */
/* compiled from: ChannelConfigRepository.kt */
public final class ChannelConfigRepositoryImpl implements ChannelConfigRepository {
    private final ChannelConfigDao channelConfigDao;
    private final Map<String, ChannelConfig> channelConfigs;

    public ChannelConfigRepositoryImpl(ChannelConfigDao channelConfigDao2) {
        Intrinsics.checkNotNullParameter(channelConfigDao2, "channelConfigDao");
        this.channelConfigDao = channelConfigDao2;
        Map<String, ChannelConfig> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "Collections.synchronizedMap(mutableMapOf())");
        this.channelConfigs = synchronizedMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[LOOP:0: B:17:0x005e->B:19:0x0064, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095 A[LOOP:1: B:21:0x008f->B:23:0x0095, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object cacheChannelConfigs(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            java.util.Map r0 = (java.util.Map) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Map<java.lang.String, io.getstream.chat.android.livedata.model.ChannelConfig> r6 = r5.channelConfigs
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao r2 = r5.channelConfigDao
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r0 = r2.selectAll(r0)
            if (r0 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x004b:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r2)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r6 = r6.iterator()
        L_0x005e:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0072
            java.lang.Object r3 = r6.next()
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r3 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity) r3
            io.getstream.chat.android.livedata.model.ChannelConfig r3 = p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigMapperKt.toModel((p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity) r3)
            r1.add(r3)
            goto L_0x005e
        L_0x0072:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r2)
            int r6 = kotlin.collections.MapsKt.mapCapacity(r6)
            r2 = 16
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>(r6)
            java.util.Map r2 = (java.util.Map) r2
            java.util.Iterator r6 = r1.iterator()
        L_0x008f:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r6.next()
            r3 = r1
            io.getstream.chat.android.livedata.model.ChannelConfig r3 = (p015io.getstream.chat.android.livedata.model.ChannelConfig) r3
            java.lang.String r3 = r3.getType()
            r2.put(r3, r1)
            goto L_0x008f
        L_0x00a4:
            r0.putAll(r2)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl.cacheChannelConfigs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void clearChannelConfigsCache() {
        this.channelConfigs.clear();
    }

    public ChannelConfig selectChannelConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        return this.channelConfigs.get(str);
    }

    public Object insertChannelConfigs(Collection<ChannelConfig> collection, Continuation<? super Unit> continuation) {
        Map<String, ChannelConfig> map = this.channelConfigs;
        Iterable<ChannelConfig> iterable = collection;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((ChannelConfig) next).getType(), next);
        }
        map.putAll(linkedHashMap);
        ChannelConfigDao channelConfigDao2 = this.channelConfigDao;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ChannelConfig entity : iterable) {
            arrayList.add(ChannelConfigMapperKt.toEntity(entity));
        }
        Object insert = channelConfigDao2.insert((List<ChannelConfigEntity>) (List) arrayList, continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public Object insertChannelConfig(ChannelConfig channelConfig, Continuation<? super Unit> continuation) {
        Map<String, ChannelConfig> map = this.channelConfigs;
        Pair pair = TuplesKt.m181to(channelConfig.getType(), channelConfig);
        map.put(pair.getFirst(), pair.getSecond());
        Object insert = this.channelConfigDao.insert(ChannelConfigMapperKt.toEntity(channelConfig), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }
}
