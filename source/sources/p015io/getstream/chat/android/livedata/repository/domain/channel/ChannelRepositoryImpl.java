package p015io.getstream.chat.android.livedata.repository.domain.channel;

import androidx.collection.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u00123\u0010\r\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150$H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0$2\u0006\u0010\u0019\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J)\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0002J'\u00106\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020*0$H@ø\u0001\u0000¢\u0006\u0002\u00108R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0016R>\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u00069"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;", "channelDao", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelDao;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "getMessage", "messageId", "Lio/getstream/chat/android/client/models/Message;", "cacheSize", "", "(Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelDao;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;I)V", "channelCache", "Landroidx/collection/LruCache;", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlin/jvm/functions/Function2;", "deleteChannel", "", "cid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannel", "channel", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannels", "channels", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelWithoutMessages", "selectChannels", "", "channelCIDs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelsSyncNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMembersForChannel", "Lio/getstream/chat/android/client/models/Member;", "setChannelDeletedAt", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHiddenForChannel", "hidden", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideMessagesBefore", "(Ljava/lang/String;ZLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCache", "updateMembersForChannel", "members", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl */
/* compiled from: ChannelRepository.kt */
public final class ChannelRepositoryImpl implements ChannelRepository {
    private final LruCache<String, Channel> channelCache;
    private final ChannelDao channelDao;
    private final Function2<String, Continuation<? super Message>, Object> getMessage;
    private final Function2<String, Continuation<? super User>, Object> getUser;

    public ChannelRepositoryImpl(ChannelDao channelDao2, Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super Message>, ? extends Object> function22, int i) {
        Intrinsics.checkNotNullParameter(channelDao2, "channelDao");
        Intrinsics.checkNotNullParameter(function2, "getUser");
        Intrinsics.checkNotNullParameter(function22, "getMessage");
        this.channelDao = channelDao2;
        this.getUser = function2;
        this.getMessage = function22;
        this.channelCache = new LruCache<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelRepositoryImpl(ChannelDao channelDao2, Function2 function2, Function2 function22, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(channelDao2, function2, function22, (i2 & 8) != 0 ? 100 : i);
    }

    public Object insertChannel(Channel channel, Continuation<? super Unit> continuation) {
        updateCache(CollectionsKt.listOf(channel));
        Object insert = this.channelDao.insert(ChannelMapperKt.toEntity(channel), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public Object insertChannels(Collection<Channel> collection, Continuation<? super Unit> continuation) {
        if (collection.isEmpty()) {
            return Unit.INSTANCE;
        }
        updateCache(collection);
        ChannelDao channelDao2 = this.channelDao;
        Iterable<Channel> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Channel entity : iterable) {
            arrayList.add(ChannelMapperKt.toEntity(entity));
        }
        Object insertMany = channelDao2.insertMany((List) arrayList, continuation);
        if (insertMany == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insertMany;
        }
        return Unit.INSTANCE;
    }

    public Object deleteChannel(String str, Continuation<? super Unit> continuation) {
        this.channelCache.remove(str);
        Object delete = this.channelDao.delete(str, continuation);
        if (delete == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return delete;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectChannelWithoutMessages(java.lang.String r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelWithoutMessages$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelWithoutMessages$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelWithoutMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelWithoutMessages$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelWithoutMessages$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
            r0.label = r3
            java.lang.Object r6 = r4.selectChannels(r5, r0)
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x0042:
            java.util.List r6 = (java.util.List) r6
            r5 = 0
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl.selectChannelWithoutMessages(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectChannels(java.util.List<java.lang.String> r10, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r10 = r0.L$4
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$2
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0106
        L_0x0042:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004a:
            java.lang.Object r10 = r0.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00cb
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Channel> r2 = r9.channelCache
            java.util.Iterator r5 = r10.iterator()
        L_0x006b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0083
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r2.get(r6)
            io.getstream.chat.android.client.models.Channel r6 = (p015io.getstream.chat.android.client.models.Channel) r6
            if (r6 == 0) goto L_0x006b
            r11.add(r6)
            goto L_0x006b
        L_0x0083:
            java.util.List r11 = (java.util.List) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x0090:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00b6
            java.lang.Object r5 = r10.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Channel> r7 = r9.channelCache
            java.lang.Object r6 = r7.get(r6)
            if (r6 != 0) goto L_0x00a7
            r6 = 1
            goto L_0x00a8
        L_0x00a7:
            r6 = 0
        L_0x00a8:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0090
            r2.add(r5)
            goto L_0x0090
        L_0x00b6:
            java.util.List r2 = (java.util.List) r2
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao r10 = r9.channelDao
            r0.L$0 = r9
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r10 = r10.select((java.util.List<java.lang.String>) r2, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity>>) r0)
            if (r10 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            r2 = r9
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x00cb:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r11 = r11.iterator()
            r5 = r10
            r6 = r2
            r10 = r4
            r2 = r11
        L_0x00e2:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x010d
            java.lang.Object r11 = r2.next()
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r11 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r11
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r4 = r6.getUser
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.Message>, java.lang.Object> r7 = r6.getMessage
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r10
            r0.L$3 = r2
            r0.L$4 = r10
            r0.label = r3
            java.lang.Object r11 = p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt.toModel(r11, r4, r7, r0)
            if (r11 != r1) goto L_0x0105
            return r1
        L_0x0105:
            r4 = r10
        L_0x0106:
            io.getstream.chat.android.client.models.Channel r11 = (p015io.getstream.chat.android.client.models.Channel) r11
            r10.add(r11)
            r10 = r4
            goto L_0x00e2
        L_0x010d:
            java.util.List r10 = (java.util.List) r10
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.List r10 = kotlin.collections.CollectionsKt.toMutableList(r10)
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            r6.updateCache(r11)
            java.util.Collection r5 = (java.util.Collection) r5
            r10.addAll(r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl.selectChannels(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectChannelsSyncNeeded(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelsSyncNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelsSyncNeeded$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelsSyncNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelsSyncNeeded$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannelsSyncNeeded$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r2 = r0.L$3
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$1
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0097
        L_0x003d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r9)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao r9 = r8.channelDao
            r0.L$0 = r8
            r0.label = r4
            r2 = 0
            java.lang.Object r9 = p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao.DefaultImpls.selectSyncNeeded$default(r9, r2, r0, r4, r2)
            if (r9 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r2 = r8
        L_0x005f:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r9 = r9.iterator()
            r6 = r2
            r2 = r4
            r4 = r9
        L_0x0075:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x009e
            java.lang.Object r9 = r4.next()
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r9 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r9
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r5 = r6.getUser
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.Message>, java.lang.Object> r7 = r6.getMessage
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r4
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r9 = p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt.toModel(r9, r5, r7, r0)
            if (r9 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r5 = r2
        L_0x0097:
            io.getstream.chat.android.client.models.Channel r9 = (p015io.getstream.chat.android.client.models.Channel) r9
            r2.add(r9)
            r2 = r5
            goto L_0x0075
        L_0x009e:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl.selectChannelsSyncNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object setChannelDeletedAt(String str, Date date, Continuation<? super Unit> continuation) {
        this.channelCache.remove(str);
        Object deletedAt = this.channelDao.setDeletedAt(str, date, continuation);
        if (deletedAt == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return deletedAt;
        }
        return Unit.INSTANCE;
    }

    public Object setHiddenForChannel(String str, boolean z, Date date, Continuation<? super Unit> continuation) {
        this.channelCache.remove(str);
        Object hidden = this.channelDao.setHidden(str, z, date, continuation);
        if (hidden == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return hidden;
        }
        return Unit.INSTANCE;
    }

    public Object setHiddenForChannel(String str, boolean z, Continuation<? super Unit> continuation) {
        this.channelCache.remove(str);
        Object hidden = this.channelDao.setHidden(str, z, continuation);
        if (hidden == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return hidden;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectMembersForChannel(java.lang.String r7, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Member>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectMembersForChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectMembersForChannel$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectMembersForChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectMembersForChannel$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectMembersForChannel$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r7 = r0.L$3
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r5 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00a4
        L_0x003d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0045:
            java.lang.Object r7 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r7 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r8)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao r8 = r6.channelDao
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r8.select((java.lang.String) r7, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity>) r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r7 = r6
        L_0x005e:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r8
            if (r8 == 0) goto L_0x00b0
            java.util.Map r8 = r8.getMembers()
            if (r8 == 0) goto L_0x00b0
            java.util.Collection r8 = r8.values()
            if (r8 == 0) goto L_0x00b0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r4)
            r2.<init>(r4)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
            r5 = r7
            r7 = r2
            r2 = r8
        L_0x0084:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x00ab
            java.lang.Object r8 = r2.next()
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity) r8
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r4 = r5.getUser
            r0.L$0 = r5
            r0.L$1 = r7
            r0.L$2 = r2
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberMapperKt.toModel(r8, r4, r0)
            if (r8 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            r4 = r7
        L_0x00a4:
            io.getstream.chat.android.client.models.Member r8 = (p015io.getstream.chat.android.client.models.Member) r8
            r7.add(r8)
            r7 = r4
            goto L_0x0084
        L_0x00ab:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x00b0
            goto L_0x00b4
        L_0x00b0:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00b4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl.selectMembersForChannel(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateMembersForChannel(java.lang.String r26, java.util.List<p015io.getstream.chat.android.client.models.Member> r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1 r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1 r2 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0049
            if (r4 == r6) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f4
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            java.lang.Object r4 = r2.L$1
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r6 = r2.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r4
            r4 = r6
            goto L_0x00bc
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r27
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r7 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r7)
            r4.<init>(r8)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0061:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0075
            java.lang.Object r8 = r1.next()
            io.getstream.chat.android.client.models.Member r8 = (p015io.getstream.chat.android.client.models.Member) r8
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r8 = p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberMapperKt.toEntity(r8)
            r4.add(r8)
            goto L_0x0061
        L_0x0075:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
            int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
            r7 = 16
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r7)
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>(r1)
            r1 = r7
            java.util.Map r1 = (java.util.Map) r1
            java.util.Iterator r4 = r4.iterator()
        L_0x0093:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00a8
            java.lang.Object r7 = r4.next()
            r8 = r7
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity) r8
            java.lang.String r8 = r8.getUserId()
            r1.put(r8, r7)
            goto L_0x0093
        L_0x00a8:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao r4 = r0.channelDao
            r2.L$0 = r0
            r2.L$1 = r1
            r2.label = r6
            r6 = r26
            java.lang.Object r4 = r4.select((java.lang.String) r6, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity>) r2)
            if (r4 != r3) goto L_0x00b9
            return r3
        L_0x00b9:
            r14 = r1
            r1 = r4
            r4 = r0
        L_0x00bc:
            r6 = r1
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r6
            r1 = 0
            if (r6 == 0) goto L_0x00e2
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 65407(0xff7f, float:9.1655E-41)
            r24 = 0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r6 = p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x00e3
        L_0x00e2:
            r6 = r1
        L_0x00e3:
            if (r6 == 0) goto L_0x00f4
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao r4 = r4.channelDao
            r2.L$0 = r1
            r2.L$1 = r1
            r2.label = r5
            java.lang.Object r1 = r4.insert(r6, r2)
            if (r1 != r3) goto L_0x00f4
            return r3
        L_0x00f4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl.updateMembersForChannel(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateCache(Collection<Channel> collection) {
        for (Channel next : collection) {
            this.channelCache.put(next.getCid(), next);
        }
    }
}
