package p015io.getstream.chat.android.livedata.repository.domain.channel;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a}\u0010\u0003\u001a\u00020\u0002*\u00020\u000121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000523\u0010\r\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;", "Lio/getstream/chat/android/client/models/Channel;", "toModel", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "getMessage", "messageId", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt */
/* compiled from: ChannelMapper.kt */
public final class ChannelMapperKt {
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0111, code lost:
        r2 = r2.getMessageInnerEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity toEntity(p015io.getstream.chat.android.client.models.Channel r21) {
        /*
            java.lang.String r0 = "$this$toEntity"
            r1 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 0
            r2 = r0
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r2
            r3 = r0
            java.util.Date r3 = (java.util.Date) r3
            java.util.List r4 = r21.getMessages()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.lastOrNull(r4)
            io.getstream.chat.android.client.models.Message r4 = (p015io.getstream.chat.android.client.models.Message) r4
            if (r4 == 0) goto L_0x0022
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toEntity(r4)
            java.util.Date r3 = r4.getCreatedAt()
        L_0x0022:
            r13 = r3
            java.lang.String r4 = r21.getType()
            java.lang.String r5 = r21.getId()
            int r6 = r21.getCooldown()
            boolean r8 = r21.getFrozen()
            java.util.Date r15 = r21.getCreatedAt()
            java.util.Date r16 = r21.getUpdatedAt()
            java.util.Date r17 = r21.getDeletedAt()
            java.util.Map r18 = r21.getExtraData()
            io.getstream.chat.android.client.utils.SyncStatus r19 = r21.getSyncStatus()
            java.lang.Boolean r9 = r21.getHidden()
            java.util.Date r10 = r21.getHiddenMessagesBefore()
            java.util.List r3 = r21.getMembers()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r7 = new java.util.ArrayList
            r11 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r11)
            r7.<init>(r12)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r3 = r3.iterator()
        L_0x0066:
            boolean r12 = r3.hasNext()
            if (r12 == 0) goto L_0x007a
            java.lang.Object r12 = r3.next()
            io.getstream.chat.android.client.models.Member r12 = (p015io.getstream.chat.android.client.models.Member) r12
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r12 = p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberMapperKt.toEntity(r12)
            r7.add(r12)
            goto L_0x0066
        L_0x007a:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r11)
            int r3 = kotlin.collections.MapsKt.mapCapacity(r3)
            r12 = 16
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r12)
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>(r3)
            java.util.Map r14 = (java.util.Map) r14
            java.util.Iterator r3 = r7.iterator()
        L_0x0097:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00ae
            java.lang.Object r7 = r3.next()
            r20 = r7
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r20 = (p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity) r20
            java.lang.String r0 = r20.getUserId()
            r14.put(r0, r7)
            r0 = 0
            goto L_0x0097
        L_0x00ae:
            java.util.Map r0 = kotlin.collections.MapsKt.toMutableMap(r14)
            java.util.List r3 = r21.getRead()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r7 = new java.util.ArrayList
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r11)
            r7.<init>(r14)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r3 = r3.iterator()
        L_0x00c7:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x00db
            java.lang.Object r14 = r3.next()
            io.getstream.chat.android.client.models.ChannelUserRead r14 = (p015io.getstream.chat.android.client.models.ChannelUserRead) r14
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity r14 = p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt.toEntity(r14)
            r7.add(r14)
            goto L_0x00c7
        L_0x00db:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r11)
            int r3 = kotlin.collections.MapsKt.mapCapacity(r3)
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r12)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>(r3)
            java.util.Map r11 = (java.util.Map) r11
            java.util.Iterator r3 = r7.iterator()
        L_0x00f6:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x010b
            java.lang.Object r7 = r3.next()
            r12 = r7
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity r12 = (p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity) r12
            java.lang.String r12 = r12.getUserId()
            r11.put(r12, r7)
            goto L_0x00f6
        L_0x010b:
            java.util.Map r12 = kotlin.collections.MapsKt.toMutableMap(r11)
            if (r2 == 0) goto L_0x011d
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r2 = r2.getMessageInnerEntity()
            if (r2 == 0) goto L_0x011d
            java.lang.String r2 = r2.getId()
            r14 = r2
            goto L_0x011e
        L_0x011d:
            r14 = 0
        L_0x011e:
            io.getstream.chat.android.client.models.User r1 = r21.getCreatedBy()
            java.lang.String r7 = r1.getId()
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r1 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity
            r3 = r1
            r11 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt.toEntity(io.getstream.chat.android.client.models.Channel):io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x04be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toModel(p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r32, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User>, ? extends java.lang.Object> r33, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Message>, ? extends java.lang.Object> r34, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel> r35) {
        /*
            r0 = r35
            boolean r1 = r0 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt$toModel$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt$toModel$1 r1 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt$toModel$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt$toModel$1 r1 = new io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt$toModel$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r3 == 0) goto L_0x0203
            if (r3 == r9) goto L_0x018b
            if (r3 == r8) goto L_0x0125
            if (r3 == r7) goto L_0x009d
            if (r3 != r6) goto L_0x0095
            int r2 = r1.I$2
            boolean r3 = r1.Z$0
            int r4 = r1.I$1
            int r5 = r1.I$0
            java.lang.Object r6 = r1.L$13
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$12
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$11
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$10
            java.util.Date r9 = (java.util.Date) r9
            java.lang.Object r10 = r1.L$9
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            java.lang.Object r11 = r1.L$8
            io.getstream.chat.android.client.utils.SyncStatus r11 = (p015io.getstream.chat.android.client.utils.SyncStatus) r11
            java.lang.Object r12 = r1.L$7
            java.util.Date r12 = (java.util.Date) r12
            java.lang.Object r13 = r1.L$6
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r1.L$5
            java.util.Date r14 = (java.util.Date) r14
            java.lang.Object r15 = r1.L$4
            java.util.Date r15 = (java.util.Date) r15
            r32 = r2
            java.lang.Object r2 = r1.L$3
            java.util.Date r2 = (java.util.Date) r2
            r33 = r2
            java.lang.Object r2 = r1.L$2
            java.lang.String r2 = (java.lang.String) r2
            r34 = r2
            java.lang.Object r2 = r1.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r24 = r5
            r16 = r6
            r23 = r9
            r22 = r10
            r21 = r13
            r9 = r14
            r10 = r15
            r6 = r3
            r5 = r4
            r13 = r7
            r14 = r8
            r7 = r12
            r12 = r32
            r8 = r33
            r4 = r1
            r3 = r2
            r2 = r34
            goto L_0x04de
        L_0x0095:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x009d:
            int r3 = r1.I$2
            boolean r4 = r1.Z$0
            int r5 = r1.I$1
            int r8 = r1.I$0
            java.lang.Object r9 = r1.L$17
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r11 = r1.L$16
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.L$15
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.L$14
            java.util.Date r13 = (java.util.Date) r13
            java.lang.Object r14 = r1.L$13
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r1.L$12
            io.getstream.chat.android.client.utils.SyncStatus r15 = (p015io.getstream.chat.android.client.utils.SyncStatus) r15
            java.lang.Object r6 = r1.L$11
            java.util.Date r6 = (java.util.Date) r6
            java.lang.Object r7 = r1.L$10
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r10 = r1.L$9
            java.util.Date r10 = (java.util.Date) r10
            r18 = r2
            java.lang.Object r2 = r1.L$8
            java.util.Date r2 = (java.util.Date) r2
            r32 = r2
            java.lang.Object r2 = r1.L$7
            java.util.Date r2 = (java.util.Date) r2
            r33 = r2
            java.lang.Object r2 = r1.L$6
            java.lang.String r2 = (java.lang.String) r2
            r34 = r2
            java.lang.Object r2 = r1.L$5
            java.lang.String r2 = (java.lang.String) r2
            r19 = r2
            java.lang.Object r2 = r1.L$4
            java.lang.String r2 = (java.lang.String) r2
            r20 = r2
            java.lang.Object r2 = r1.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            r21 = r2
            java.lang.Object r2 = r1.L$2
            java.util.Collection r2 = (java.util.Collection) r2
            r22 = r2
            java.lang.Object r2 = r1.L$1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r23 = r2
            java.lang.Object r2 = r1.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r24 = r8
            r25 = r11
            r26 = r12
            r8 = r13
            r11 = r6
            r12 = r7
            r13 = r10
            r6 = r19
            r10 = r34
            r7 = r2
            r19 = r3
            r2 = r21
            r3 = r1
            r21 = r4
            r4 = r14
            r14 = r32
            r1 = r33
            r29 = r23
            r23 = r5
            r5 = r29
            goto L_0x0455
        L_0x0125:
            r18 = r2
            int r2 = r1.I$2
            boolean r3 = r1.Z$0
            int r5 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$13
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$12
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r9 = r1.L$11
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            java.lang.Object r10 = r1.L$10
            io.getstream.chat.android.client.utils.SyncStatus r10 = (p015io.getstream.chat.android.client.utils.SyncStatus) r10
            java.lang.Object r11 = r1.L$9
            java.util.Date r11 = (java.util.Date) r11
            java.lang.Object r12 = r1.L$8
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r13 = r1.L$7
            java.util.Date r13 = (java.util.Date) r13
            java.lang.Object r14 = r1.L$6
            java.util.Date r14 = (java.util.Date) r14
            java.lang.Object r15 = r1.L$5
            java.util.Date r15 = (java.util.Date) r15
            java.lang.Object r4 = r1.L$4
            java.lang.String r4 = (java.lang.String) r4
            r20 = r2
            java.lang.Object r2 = r1.L$3
            java.lang.String r2 = (java.lang.String) r2
            r32 = r2
            java.lang.Object r2 = r1.L$2
            java.lang.String r2 = (java.lang.String) r2
            r33 = r2
            java.lang.Object r2 = r1.L$1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r34 = r2
            java.lang.Object r2 = r1.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r23 = r3
            r25 = r6
            r21 = r15
            r6 = r32
            r3 = r34
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r4
            r4 = r18
            r18 = r2
            r2 = r33
            goto L_0x037f
        L_0x018b:
            r18 = r2
            int r2 = r1.I$2
            boolean r3 = r1.Z$0
            int r4 = r1.I$1
            int r5 = r1.I$0
            java.lang.Object r6 = r1.L$16
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r1.L$15
            java.util.Date r7 = (java.util.Date) r7
            java.lang.Object r10 = r1.L$14
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            java.lang.Object r11 = r1.L$13
            io.getstream.chat.android.client.utils.SyncStatus r11 = (p015io.getstream.chat.android.client.utils.SyncStatus) r11
            java.lang.Object r12 = r1.L$12
            java.util.Date r12 = (java.util.Date) r12
            java.lang.Object r13 = r1.L$11
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r1.L$10
            java.util.Date r14 = (java.util.Date) r14
            java.lang.Object r15 = r1.L$9
            java.util.Date r15 = (java.util.Date) r15
            java.lang.Object r8 = r1.L$8
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r9 = r1.L$7
            java.lang.String r9 = (java.lang.String) r9
            r22 = r2
            java.lang.Object r2 = r1.L$6
            java.lang.String r2 = (java.lang.String) r2
            r32 = r2
            java.lang.Object r2 = r1.L$5
            java.lang.String r2 = (java.lang.String) r2
            r33 = r2
            java.lang.Object r2 = r1.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            r34 = r2
            java.lang.Object r2 = r1.L$3
            java.util.Collection r2 = (java.util.Collection) r2
            r23 = r2
            java.lang.Object r2 = r1.L$2
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r24 = r2
            java.lang.Object r2 = r1.L$1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r25 = r2
            java.lang.Object r2 = r1.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r26 = r3
            r27 = r4
            r28 = r5
            r5 = r33
            r4 = r34
            r3 = r1
            r1 = r25
            r25 = r22
            r22 = r18
            r18 = r10
            r10 = r14
            r14 = r8
            r8 = r32
            goto L_0x02ef
        L_0x0203:
            r18 = r2
            kotlin.ResultKt.throwOnFailure(r0)
            int r0 = r32.getCooldown()
            java.lang.String r2 = r32.getType()
            java.lang.String r3 = r32.getChannelId()
            java.lang.String r4 = r32.getCid()
            boolean r6 = r32.getFrozen()
            java.util.Date r7 = r32.getCreatedAt()
            java.util.Date r8 = r32.getUpdatedAt()
            java.util.Date r9 = r32.getDeletedAt()
            java.util.Map r10 = r32.getExtraData()
            java.util.Map r10 = kotlin.collections.MapsKt.toMutableMap(r10)
            java.util.Date r11 = r32.getLastMessageAt()
            io.getstream.chat.android.client.utils.SyncStatus r12 = r32.getSyncStatus()
            java.lang.Boolean r13 = r32.getHidden()
            java.util.Date r14 = r32.getHideMessagesBefore()
            java.util.Map r15 = r32.getMembers()
            java.util.Collection r15 = r15.values()
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r5 = new java.util.ArrayList
            r23 = r0
            r24 = r1
            r0 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r0)
            r5.<init>(r1)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r0 = r15.iterator()
            r1 = r33
            r15 = r13
            r25 = r23
            r22 = 0
            r23 = r6
            r13 = r8
            r8 = r10
            r6 = r3
            r10 = r9
            r3 = r24
            r24 = 0
            r9 = r4
            r4 = r0
            r0 = r32
            r32 = r14
            r14 = r7
            r7 = r12
            r12 = r5
            r5 = r2
            r2 = r34
        L_0x027c:
            boolean r26 = r4.hasNext()
            if (r26 == 0) goto L_0x030e
            java.lang.Object r26 = r4.next()
            r33 = r15
            r15 = r26
            io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity r15 = (p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity) r15
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r12
            r3.L$4 = r4
            r3.L$5 = r5
            r3.L$6 = r6
            r3.L$7 = r9
            r3.L$8 = r14
            r3.L$9 = r13
            r3.L$10 = r10
            r3.L$11 = r8
            r3.L$12 = r11
            r3.L$13 = r7
            r34 = r4
            r4 = r33
            r3.L$14 = r4
            r26 = r2
            r2 = r32
            r3.L$15 = r2
            r3.L$16 = r12
            r2 = r25
            r3.I$0 = r2
            r2 = r24
            r3.I$1 = r2
            r2 = r23
            r3.Z$0 = r2
            r2 = r22
            r3.I$2 = r2
            r2 = 1
            r3.label = r2
            java.lang.Object r15 = p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberMapperKt.toModel(r15, r1, r3)
            r2 = r18
            if (r15 != r2) goto L_0x02d2
            return r2
        L_0x02d2:
            r18 = r4
            r27 = r24
            r28 = r25
            r24 = r26
            r4 = r34
            r25 = r22
            r26 = r23
            r22 = r2
            r23 = r12
            r2 = r0
            r0 = r15
            r15 = r13
            r13 = r8
            r8 = r6
            r6 = r23
            r12 = r11
            r11 = r7
            r7 = r32
        L_0x02ef:
            io.getstream.chat.android.client.models.Member r0 = (p015io.getstream.chat.android.client.models.Member) r0
            r6.add(r0)
            r0 = r2
            r32 = r7
            r6 = r8
            r7 = r11
            r11 = r12
            r8 = r13
            r13 = r15
            r15 = r18
            r18 = r22
            r12 = r23
            r2 = r24
            r22 = r25
            r23 = r26
            r24 = r27
            r25 = r28
            goto L_0x027c
        L_0x030e:
            r26 = r2
            r4 = r15
            r2 = r18
            java.util.List r12 = (java.util.List) r12
            java.lang.String r15 = r0.getLastMessageId()
            if (r15 == 0) goto L_0x0399
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r5
            r3.L$3 = r6
            r3.L$4 = r9
            r3.L$5 = r14
            r3.L$6 = r13
            r3.L$7 = r10
            r3.L$8 = r8
            r3.L$9 = r11
            r3.L$10 = r7
            r3.L$11 = r4
            r18 = r0
            r0 = r32
            r3.L$12 = r0
            r3.L$13 = r12
            r0 = 0
            r3.L$14 = r0
            r3.L$15 = r0
            r3.L$16 = r0
            r0 = r25
            r3.I$0 = r0
            r0 = r24
            r3.I$1 = r0
            r0 = r23
            r3.Z$0 = r0
            r0 = r22
            r3.I$2 = r0
            r0 = 2
            r3.label = r0
            r0 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r0)
            r0 = r26
            java.lang.Object r0 = r0.invoke(r15, r3)
            r15 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r15)
            if (r0 != r2) goto L_0x0366
            return r2
        L_0x0366:
            r15 = r13
            r21 = r14
            r20 = r22
            r13 = r8
            r14 = r10
            r8 = r32
            r10 = r4
            r4 = r2
            r2 = r5
            r5 = r24
            r29 = r3
            r3 = r1
            r1 = r29
            r30 = r11
            r11 = r7
            r7 = r12
            r12 = r30
        L_0x037f:
            io.getstream.chat.android.client.models.Message r0 = (p015io.getstream.chat.android.client.models.Message) r0
            r24 = r5
            r5 = r2
            r2 = r4
            r29 = r3
            r3 = r1
            r1 = r29
            r30 = r12
            r12 = r7
            r7 = r11
            r11 = r30
            r31 = r14
            r14 = r8
            r8 = r13
            r13 = r15
            r15 = r10
            r10 = r31
            goto L_0x03a3
        L_0x0399:
            r18 = r0
            r15 = r4
            r21 = r14
            r20 = r22
            r0 = 0
            r14 = r32
        L_0x03a3:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull(r0)
            java.util.Map r4 = r18.getReads()
            java.util.Collection r4 = r4.values()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r32 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r33 = r1
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r4.iterator()
            r4 = r15
            r19 = r20
            r20 = r23
            r22 = r25
            r23 = r32
            r15 = r0
            r0 = r21
            r21 = r24
            r24 = r12
            r12 = r8
            r8 = r14
            r14 = r13
            r13 = r10
            r10 = r7
            r7 = r18
            r18 = r2
            r2 = r1
            r1 = r5
            r5 = r33
        L_0x03e3:
            boolean r25 = r2.hasNext()
            if (r25 == 0) goto L_0x046d
            java.lang.Object r25 = r2.next()
            r26 = r8
            r8 = r25
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity) r8
            r3.L$0 = r7
            r3.L$1 = r5
            r3.L$2 = r15
            r3.L$3 = r2
            r3.L$4 = r1
            r3.L$5 = r6
            r3.L$6 = r9
            r3.L$7 = r0
            r3.L$8 = r14
            r3.L$9 = r13
            r3.L$10 = r12
            r3.L$11 = r11
            r3.L$12 = r10
            r3.L$13 = r4
            r32 = r2
            r2 = r26
            r3.L$14 = r2
            r2 = r24
            r3.L$15 = r2
            r2 = r23
            r3.L$16 = r2
            r3.L$17 = r15
            r2 = r22
            r3.I$0 = r2
            r2 = r21
            r3.I$1 = r2
            r2 = r20
            r3.Z$0 = r2
            r2 = r19
            r3.I$2 = r2
            r2 = 3
            r3.label = r2
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt.toModel(r8, r5, r3)
            r2 = r18
            if (r8 != r2) goto L_0x043b
            return r2
        L_0x043b:
            r18 = r2
            r25 = r23
            r2 = r32
            r23 = r21
            r21 = r20
            r20 = r1
            r1 = r0
            r0 = r8
            r8 = r26
            r26 = r24
            r24 = r22
            r22 = r15
            r15 = r10
            r10 = r9
            r9 = r22
        L_0x0455:
            io.getstream.chat.android.client.models.ChannelUserRead r0 = (p015io.getstream.chat.android.client.models.ChannelUserRead) r0
            r9.add(r0)
            r0 = r1
            r9 = r10
            r10 = r15
            r1 = r20
            r20 = r21
            r15 = r22
            r21 = r23
            r22 = r24
            r23 = r25
            r24 = r26
            goto L_0x03e3
        L_0x046d:
            r26 = r8
            r2 = r18
            r8 = r15
            java.util.List r8 = (java.util.List) r8
            java.lang.String r7 = r7.getCreatedByUserId()
            r3.L$0 = r1
            r3.L$1 = r6
            r3.L$2 = r9
            r3.L$3 = r0
            r3.L$4 = r14
            r3.L$5 = r13
            r3.L$6 = r12
            r3.L$7 = r11
            r3.L$8 = r10
            r3.L$9 = r4
            r15 = r26
            r3.L$10 = r15
            r16 = r0
            r0 = r24
            r3.L$11 = r0
            r0 = r23
            r3.L$12 = r0
            r3.L$13 = r8
            r0 = 0
            r3.L$14 = r0
            r3.L$15 = r0
            r3.L$16 = r0
            r3.L$17 = r0
            r0 = r22
            r3.I$0 = r0
            r0 = r21
            r3.I$1 = r0
            r0 = r20
            r3.Z$0 = r0
            r0 = r19
            r3.I$2 = r0
            r0 = 4
            r3.label = r0
            java.lang.Object r0 = r5.invoke(r7, r3)
            if (r0 != r2) goto L_0x04bf
            return r2
        L_0x04bf:
            r3 = r6
            r2 = r9
            r7 = r11
            r9 = r13
            r6 = r20
            r5 = r21
            r13 = r23
            r11 = r10
            r21 = r12
            r10 = r14
            r23 = r15
            r12 = r19
            r14 = r24
            r24 = r22
            r22 = r4
            r4 = r1
            r29 = r16
            r16 = r8
            r8 = r29
        L_0x04de:
            r20 = 0
            r19 = 0
            r17 = 0
            r15 = 0
            r18 = r0
            io.getstream.chat.android.client.models.User r18 = (p015io.getstream.chat.android.client.models.User) r18
            r25 = 0
            r26 = 8823816(0x86a408, float:1.23648E-38)
            r27 = 0
            io.getstream.chat.android.client.models.Channel r0 = new io.getstream.chat.android.client.models.Channel
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelMapperKt.toModel(io.getstream.chat.android.livedata.repository.domain.channel.ChannelEntity, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
