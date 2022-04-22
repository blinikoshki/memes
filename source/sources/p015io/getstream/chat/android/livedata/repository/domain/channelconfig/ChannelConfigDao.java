package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tH¥@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H¥@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\tH¥@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigDao;", "", "()V", "insert", "", "channelConfigEntity", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelConfigEntities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCommands", "commands", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/CommandInnerEntity;", "insertConfig", "channelConfigInnerEntity", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigInnerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertConfigs", "channelConfigInnerEntities", "selectAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao */
/* compiled from: ChannelConfigDao.kt */
public abstract class ChannelConfigDao {
    public Object insert(ChannelConfigEntity channelConfigEntity, Continuation<? super Unit> continuation) {
        return insert$suspendImpl(this, channelConfigEntity, (Continuation) continuation);
    }

    public Object insert(List<ChannelConfigEntity> list, Continuation<? super Unit> continuation) {
        return insert$suspendImpl(this, (List) list, (Continuation) continuation);
    }

    /* access modifiers changed from: protected */
    public abstract Object insertCommands(List<CommandInnerEntity> list, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object insertConfig(ChannelConfigInnerEntity channelConfigInnerEntity, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object insertConfigs(List<ChannelConfigInnerEntity> list, Continuation<? super Unit> continuation);

    public abstract Object selectAll(Continuation<? super List<ChannelConfigEntity>> continuation);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090 A[LOOP:1: B:22:0x008a->B:24:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object insert$suspendImpl(p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao r6, java.util.List<p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity> r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b0
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao r6 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007d
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r5)
            r2.<init>(r5)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L_0x005a:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x006e
            java.lang.Object r5 = r8.next()
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r5 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity) r5
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity r5 = r5.getChannelConfigInnerEntity()
            r2.add(r5)
            goto L_0x005a
        L_0x006e:
            java.util.List r2 = (java.util.List) r2
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.insertConfigs(r2, r0)
            if (r8 != r1) goto L_0x007d
            return r1
        L_0x007d:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x008a:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r7.next()
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity) r2
            java.util.List r2 = r2.getCommands()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.collections.CollectionsKt.addAll(r8, r2)
            goto L_0x008a
        L_0x00a0:
            java.util.List r8 = (java.util.List) r8
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r6.insertCommands(r8, r0)
            if (r6 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao.insert$suspendImpl(io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object insert$suspendImpl(p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao r5, p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$4
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$4 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$4 r0 = new io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$4
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity) r6
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao r5 = (p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0056
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigInnerEntity r7 = r6.getChannelConfigInnerEntity()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.insertConfig(r7, r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            java.util.List r6 = r6.getCommands()
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = r5.insertCommands(r6, r0)
            if (r5 != r1) goto L_0x0068
            return r1
        L_0x0068:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao.insert$suspendImpl(io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao, io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
