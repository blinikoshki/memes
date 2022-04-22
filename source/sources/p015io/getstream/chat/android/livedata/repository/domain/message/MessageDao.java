package p015io.getstream.chat.android.livedata.repository.domain.message;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\r\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012H¥@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012H¥@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0019H¥@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0012H¥@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"H§@ø\u0001\u0000¢\u0006\u0002\u0010#J1\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J1\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J1\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J1\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010&J\u001b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010,J%\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\b\b\u0002\u0010/\u001a\u000200H§@ø\u0001\u0000¢\u0006\u0002\u00101\u0002\u0004\n\u0002\b\u0019¨\u00062"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageDao;", "", "()V", "deleteChannelMessagesBefore", "", "cid", "", "deleteMessagesBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessage", "messageId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "messageEntity", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageEntities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAttachments", "attachmentEntities", "Lio/getstream/chat/android/livedata/repository/domain/message/attachment/AttachmentEntity;", "insertMessageInnerEntities", "messageInnerEntities", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;", "insertMessageInnerEntity", "messageInnerEntity", "(Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReactions", "reactions", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "messagesForChannel", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messagesForChannelEqualOrNewerThan", "dateFilter", "(Ljava/lang/String;ILjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messagesForChannelEqualOrOlderThan", "messagesForChannelNewerThan", "messagesForChannelOlderThan", "select", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "selectSyncNeeded", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "(Lio/getstream/chat/android/client/utils/SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageDao */
/* compiled from: MessageDao.kt */
public abstract class MessageDao {
    public abstract Object deleteChannelMessagesBefore(String str, Date date, Continuation<? super Unit> continuation);

    public abstract Object deleteMessage(String str, String str2, Continuation<? super Unit> continuation);

    public Object insert(MessageEntity messageEntity, Continuation<? super Unit> continuation) {
        return insert$suspendImpl(this, messageEntity, (Continuation) continuation);
    }

    public Object insert(List<MessageEntity> list, Continuation<? super Unit> continuation) {
        return insert$suspendImpl(this, (List) list, (Continuation) continuation);
    }

    /* access modifiers changed from: protected */
    public abstract Object insertAttachments(List<AttachmentEntity> list, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object insertMessageInnerEntities(List<MessageInnerEntity> list, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object insertMessageInnerEntity(MessageInnerEntity messageInnerEntity, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object insertReactions(List<ReactionEntity> list, Continuation<? super Unit> continuation);

    public abstract Object messagesForChannel(String str, int i, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object messagesForChannelEqualOrNewerThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object messagesForChannelEqualOrOlderThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object messagesForChannelNewerThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object messagesForChannelOlderThan(String str, int i, Date date, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object select(String str, Continuation<? super MessageEntity> continuation);

    public abstract Object select(List<String> list, Continuation<? super List<MessageEntity>> continuation);

    public abstract Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<MessageEntity>> continuation);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1 A[LOOP:1: B:24:0x009b->B:26:0x00a1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6 A[LOOP:2: B:32:0x00d0->B:34:0x00d6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object insert$suspendImpl(p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao r8, java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity> r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0102
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r9 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c3
        L_0x0046:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008d
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r6)
            r2.<init>(r6)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x006a:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L_0x007e
            java.lang.Object r6 = r10.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r6
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r6 = r6.getMessageInnerEntity()
            r2.add(r6)
            goto L_0x006a
        L_0x007e:
            java.util.List r2 = (java.util.List) r2
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r10 = r8.insertMessageInnerEntities(r2, r0)
            if (r10 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r10 = r9
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x009b:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00b1
            java.lang.Object r5 = r10.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r5 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r5
            java.util.List r5 = r5.getAttachments()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            kotlin.collections.CollectionsKt.addAll(r2, r5)
            goto L_0x009b
        L_0x00b1:
            java.util.List r2 = (java.util.List) r2
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r8.insertAttachments(r2, r0)
            if (r10 != r1) goto L_0x00c0
            return r1
        L_0x00c0:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00c3:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r8 = r8.iterator()
        L_0x00d0:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x00f2
            java.lang.Object r2 = r8.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r2
            java.util.List r4 = r2.getLatestReactions()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r2 = r2.getOwnReactions()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.plus(r4, r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.collections.CollectionsKt.addAll(r10, r2)
            goto L_0x00d0
        L_0x00f2:
            java.util.List r10 = (java.util.List) r10
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r9.insertReactions(r10, r0)
            if (r8 != r1) goto L_0x0102
            return r1
        L_0x0102:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao.insert$suspendImpl(io.getstream.chat.android.livedata.repository.domain.message.MessageDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: io.getstream.chat.android.livedata.repository.domain.message.MessageEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object insert$suspendImpl(p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao r7, p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5
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
            goto L_0x0097
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            java.lang.Object r7 = r0.L$1
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r7 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r7
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0079
        L_0x0044:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r8
            java.lang.Object r7 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r7 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0065
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r9)
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r9 = r8.getMessageInnerEntity()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r7.insertMessageInnerEntity(r9, r0)
            if (r9 != r1) goto L_0x0065
            return r1
        L_0x0065:
            java.util.List r9 = r8.getAttachments()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r7.insertAttachments(r9, r0)
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0079:
            java.util.List r9 = r7.getLatestReactions()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.List r7 = r7.getOwnReactions()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.plus(r9, r7)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r7 = r8.insertReactions(r7, r0)
            if (r7 != r1) goto L_0x0097
            return r1
        L_0x0097:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao.insert$suspendImpl(io.getstream.chat.android.livedata.repository.domain.message.MessageDao, io.getstream.chat.android.livedata.repository.domain.message.MessageEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object messagesForChannelNewerThan$default(MessageDao messageDao, String str, int i, Date date, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return messageDao.messagesForChannelNewerThan(str, i, date, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesForChannelNewerThan");
    }

    public static /* synthetic */ Object messagesForChannelEqualOrNewerThan$default(MessageDao messageDao, String str, int i, Date date, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return messageDao.messagesForChannelEqualOrNewerThan(str, i, date, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesForChannelEqualOrNewerThan");
    }

    public static /* synthetic */ Object messagesForChannelOlderThan$default(MessageDao messageDao, String str, int i, Date date, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return messageDao.messagesForChannelOlderThan(str, i, date, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesForChannelOlderThan");
    }

    public static /* synthetic */ Object messagesForChannelEqualOrOlderThan$default(MessageDao messageDao, String str, int i, Date date, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return messageDao.messagesForChannelEqualOrOlderThan(str, i, date, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesForChannelEqualOrOlderThan");
    }

    public static /* synthetic */ Object messagesForChannel$default(MessageDao messageDao, String str, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return messageDao.messagesForChannel(str, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesForChannel");
    }

    public static /* synthetic */ Object selectSyncNeeded$default(MessageDao messageDao, SyncStatus syncStatus, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                syncStatus = SyncStatus.SYNC_NEEDED;
            }
            return messageDao.selectSyncNeeded(syncStatus, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSyncNeeded");
    }
}
