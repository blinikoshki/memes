package p015io.getstream.chat.android.livedata.repository.domain.message;

import androidx.collection.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.Pagination;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 32\u00020\u0001:\u00013BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J'\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060#H@ø\u0001\u0000¢\u0006\u0002\u0010*J)\u0010+\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010.H@ø\u0001\u0000¢\u0006\u0002\u0010/J)\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010.H@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130#H@ø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R>\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;", "messageDao", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageDao;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "cacheSize", "", "(Lio/getstream/chat/android/livedata/repository/domain/message/MessageDao;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "messageCache", "Landroidx/collection/LruCache;", "Lio/getstream/chat/android/client/models/Message;", "deleteChannelMessage", "", "message", "(Lio/getstream/chat/android/client/models/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChannelMessagesBefore", "cid", "hideMessagesBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessage", "cache", "", "(Lio/getstream/chat/android/client/models/Message;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessages", "messages", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessage", "messageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessages", "messageIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessagesEntitiesForChannel", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessagesForChannel", "selectMessagesSyncNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl */
/* compiled from: MessageRepository.kt */
public final class MessageRepositoryImpl implements MessageRepository {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int DEFAULT_MESSAGE_LIMIT = 100;
    private final int cacheSize;
    private final Function2<String, Continuation<? super User>, Object> getUser;
    private LruCache<String, Message> messageCache;
    private final MessageDao messageDao;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Pagination.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Pagination.GREATER_THAN_OR_EQUAL.ordinal()] = 1;
            iArr[Pagination.GREATER_THAN.ordinal()] = 2;
            iArr[Pagination.LESS_THAN_OR_EQUAL.ordinal()] = 3;
            iArr[Pagination.LESS_THAN.ordinal()] = 4;
        }
    }

    public MessageRepositoryImpl(MessageDao messageDao2, Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2, int i) {
        Intrinsics.checkNotNullParameter(messageDao2, "messageDao");
        Intrinsics.checkNotNullParameter(function2, "getUser");
        this.messageDao = messageDao2;
        this.getUser = function2;
        this.cacheSize = i;
        this.messageCache = new LruCache<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageRepositoryImpl(MessageDao messageDao2, Function2 function2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageDao2, function2, (i2 & 4) != 0 ? 100 : i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectMessagesForChannel(java.lang.String r8, p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r9, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Message>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r8 = r0.L$3
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r4 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009c
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0045:
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r10 = r7.selectMessagesEntitiesForChannel(r8, r9, r0)
            if (r10 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r8 = r7
        L_0x005c:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r9 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r2)
            r9.<init>(r2)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r10.iterator()
            r4 = r8
            r8 = r9
            r9 = r10
        L_0x0072:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00a3
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r10 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r10
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r2 = r4.getUser
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$2$1 r5 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesForChannel$2$1
            r6 = r4
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r6
            r5.<init>(r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r10 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toModel(r10, r2, r5, r0)
            if (r10 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r2 = r8
        L_0x009c:
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            r8.add(r10)
            r8 = r2
            goto L_0x0072
        L_0x00a3:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.selectMessagesForChannel(java.lang.String, io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r5 = r11.getMessageInnerEntity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c9, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00db, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ed, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0101, code lost:
        r11 = r2.messageDao;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0103, code lost:
        if (r10 == null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10.getMessageLimit());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010d, code lost:
        if (r10 == null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010f, code lost:
        r10 = r10.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0114, code lost:
        r10 = 100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0116, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
        r11 = r11.messagesForChannel(r9, r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0123, code lost:
        if (r11 != r1) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0125, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0126, code lost:
        return r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object selectMessagesEntitiesForChannel(java.lang.String r9, p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r10, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity>> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1
            r0.<init>(r8, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0058;
                case 1: goto L_0x0047;
                case 2: goto L_0x0042;
                case 3: goto L_0x003d;
                case 4: goto L_0x0038;
                case 5: goto L_0x0033;
                case 6: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0126
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00db
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ed
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ff
        L_0x0047:
            java.lang.Object r9 = r0.L$2
            r10 = r9
            io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r10 = (p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest) r10
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0079
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 == 0) goto L_0x0100
            boolean r11 = p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequestKt.hasFilter(r10)
            if (r11 == 0) goto L_0x0100
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r11 = r8.messageDao
            java.lang.String r2 = r10.getMessageFilterValue()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r11 = r11.select((java.lang.String) r2, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity>) r0)
            if (r11 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r2 = r8
        L_0x0079:
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r11 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r11
            if (r11 == 0) goto L_0x0088
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r5 = r11.getMessageInnerEntity()
            if (r5 == 0) goto L_0x0088
            java.util.Date r5 = r5.getCreatedAt()
            goto L_0x0089
        L_0x0088:
            r5 = r4
        L_0x0089:
            if (r5 != 0) goto L_0x0090
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            return r9
        L_0x0090:
            int r5 = r10.getMessageLimit()
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r11 = r11.getMessageInnerEntity()
            java.util.Date r11 = r11.getCreatedAt()
            io.getstream.chat.android.client.api.models.Pagination r6 = r10.getMessageFilterDirection()
            if (r6 != 0) goto L_0x00a3
            goto L_0x0101
        L_0x00a3:
            int[] r7 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 2
            if (r6 == r3) goto L_0x00ee
            r3 = 3
            if (r6 == r7) goto L_0x00dc
            r7 = 4
            if (r6 == r3) goto L_0x00ca
            if (r6 == r7) goto L_0x00b7
            goto L_0x0101
        L_0x00b7:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r10 = r2.messageDao
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r2 = 5
            r0.label = r2
            java.lang.Object r11 = r10.messagesForChannelOlderThan(r9, r5, r11, r0)
            if (r11 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            return r11
        L_0x00ca:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r10 = r2.messageDao
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r7
            java.lang.Object r11 = r10.messagesForChannelEqualOrOlderThan(r9, r5, r11, r0)
            if (r11 != r1) goto L_0x00db
            return r1
        L_0x00db:
            return r11
        L_0x00dc:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r10 = r2.messageDao
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r11 = r10.messagesForChannelNewerThan(r9, r5, r11, r0)
            if (r11 != r1) goto L_0x00ed
            return r1
        L_0x00ed:
            return r11
        L_0x00ee:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r10 = r2.messageDao
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r7
            java.lang.Object r11 = r10.messagesForChannelEqualOrNewerThan(r9, r5, r11, r0)
            if (r11 != r1) goto L_0x00ff
            return r1
        L_0x00ff:
            return r11
        L_0x0100:
            r2 = r8
        L_0x0101:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r11 = r2.messageDao
            if (r10 == 0) goto L_0x0114
            int r10 = r10.getMessageLimit()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            if (r10 == 0) goto L_0x0114
            int r10 = r10.intValue()
            goto L_0x0116
        L_0x0114:
            r10 = 100
        L_0x0116:
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r2 = 6
            r0.label = r2
            java.lang.Object r11 = r11.messagesForChannel(r9, r10, r0)
            if (r11 != r1) goto L_0x0126
            return r1
        L_0x0126:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.selectMessagesEntitiesForChannel(java.lang.String, io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectMessages(java.util.List<java.lang.String> r10, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Message>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$1
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
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$1
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x010c
        L_0x0042:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004a:
            java.lang.Object r10 = r0.L$1
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c9
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r2 = r10.iterator()
        L_0x0067:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x008d
            java.lang.Object r5 = r2.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Message> r7 = r9.messageCache
            java.lang.Object r6 = r7.get(r6)
            if (r6 != 0) goto L_0x007e
            r6 = 1
            goto L_0x007f
        L_0x007e:
            r6 = 0
        L_0x007f:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0067
            r11.add(r5)
            goto L_0x0067
        L_0x008d:
            java.util.List r11 = (java.util.List) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x009a:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00b4
            java.lang.Object r5 = r10.next()
            java.lang.String r5 = (java.lang.String) r5
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Message> r6 = r9.messageCache
            java.lang.Object r5 = r6.get(r5)
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            if (r5 == 0) goto L_0x009a
            r2.add(r5)
            goto L_0x009a
        L_0x00b4:
            java.util.List r2 = (java.util.List) r2
            r10 = r2
            java.util.Collection r10 = (java.util.Collection) r10
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r2 = r9.messageDao
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r2.select((java.util.List<java.lang.String>) r11, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity>>) r0)
            if (r11 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r2 = r9
        L_0x00c9:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r11 = r11.iterator()
            r6 = r2
            r2 = r10
            r10 = r4
            r4 = r11
        L_0x00e0:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x011c
            java.lang.Object r11 = r4.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r11 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r11
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r5 = r6.getUser
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$3$1 r7 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessages$3$1
            r8 = r6
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r8
            r7.<init>(r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.L$0 = r6
            r0.L$1 = r10
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r10
            r0.label = r3
            java.lang.Object r11 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toModel(r11, r5, r7, r0)
            if (r11 != r1) goto L_0x010b
            return r1
        L_0x010b:
            r5 = r10
        L_0x010c:
            io.getstream.chat.android.client.models.Message r11 = (p015io.getstream.chat.android.client.models.Message) r11
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Message> r7 = r6.messageCache
            java.lang.String r8 = r11.getId()
            r7.put(r8, r11)
            r10.add(r11)
            r10 = r5
            goto L_0x00e0
        L_0x011c:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r10 = kotlin.collections.CollectionsKt.plus(r2, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.selectMessages(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectMessage(java.lang.String r7, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Message> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0075
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            java.lang.Object r7 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r7 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005b
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Message> r8 = r6.messageCache
            java.lang.Object r8 = r8.get(r7)
            io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
            if (r8 == 0) goto L_0x004d
            r3 = r8
            goto L_0x0078
        L_0x004d:
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r8 = r6.messageDao
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r8.select((java.lang.String) r7, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity>) r0)
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r7 = r6
        L_0x005b:
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r8
            if (r8 == 0) goto L_0x0078
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r2 = r7.getUser
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$2 r5 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessage$2
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r7 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r7
            r5.<init>(r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toModel(r8, r2, r5, r0)
            if (r8 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r3 = r8
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
        L_0x0078:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.selectMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object insertMessages(List<Message> list, boolean z, Continuation<? super Unit> continuation) {
        boolean z2;
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        Companion companion = Companion;
        Collection arrayList = new ArrayList();
        for (Message access$allMessages : list) {
            CollectionsKt.addAll(arrayList, companion.allMessages(access$allMessages));
        }
        List<Message> list2 = (List) arrayList;
        for (Message cid : list2) {
            if (cid.getCid().length() > 0) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (!z2) {
                throw new IllegalArgumentException("message.cid can not be empty".toString());
            }
        }
        for (Message message : list2) {
            if (this.messageCache.get(message.getId()) != null || z) {
                this.messageCache.put(message.getId(), message);
            }
        }
        MessageDao messageDao2 = this.messageDao;
        Iterable<Message> iterable = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Message entity : iterable) {
            arrayList2.add(MessageMapperKt.toEntity(entity));
        }
        Object insert = messageDao2.insert((List<MessageEntity>) (List) arrayList2, continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public Object insertMessage(Message message, boolean z, Continuation<? super Unit> continuation) {
        Object insertMessages = insertMessages(CollectionsKt.listOf(message), z, continuation);
        if (insertMessages == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insertMessages;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deleteChannelMessagesBefore(java.lang.String r5, java.util.Date r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessagesBefore$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessagesBefore$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessagesBefore$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessagesBefore$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessagesBefore$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r5 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r7 = r4.messageDao
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r7.deleteChannelMessagesBefore(r5, r6, r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            androidx.collection.LruCache r6 = new androidx.collection.LruCache
            int r7 = r5.cacheSize
            r6.<init>(r7)
            r5.messageCache = r6
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.deleteChannelMessagesBefore(java.lang.String, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deleteChannelMessage(p015io.getstream.chat.android.client.models.Message r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessage$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessage$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$deleteChannelMessage$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.L$1
            io.getstream.chat.android.client.models.Message r6 = (p015io.getstream.chat.android.client.models.Message) r6
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r7 = r5.messageDao
            java.lang.String r2 = r6.getCid()
            java.lang.String r4 = r6.getId()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r7.deleteMessage(r2, r4, r0)
            if (r7 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r5
        L_0x0055:
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.Message> r7 = r0.messageCache
            java.lang.String r6 = r6.getId()
            r7.remove(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.deleteChannelMessage(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectMessagesSyncNeeded(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Message>> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$1 r0 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
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
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009f
        L_0x003d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r10)
            io.getstream.chat.android.livedata.repository.domain.message.MessageDao r10 = r9.messageDao
            r0.L$0 = r9
            r0.label = r4
            r2 = 0
            java.lang.Object r10 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageDao.selectSyncNeeded$default(r10, r2, r0, r4, r2)
            if (r10 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r2 = r9
        L_0x005f:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r10 = r10.iterator()
            r6 = r2
            r2 = r4
            r4 = r10
        L_0x0075:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x00a6
            java.lang.Object r10 = r4.next()
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r10 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r10
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r5 = r6.getUser
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$2$1 r7 = new io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesSyncNeeded$2$1
            r8 = r6
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl) r8
            r7.<init>(r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r4
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r10 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toModel(r10, r5, r7, r0)
            if (r10 != r1) goto L_0x009e
            return r1
        L_0x009e:
            r5 = r2
        L_0x009f:
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            r2.add(r10)
            r2 = r5
            goto L_0x0075
        L_0x00a6:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl.selectMessagesSyncNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepositoryImpl$Companion;", "", "()V", "DEFAULT_MESSAGE_LIMIT", "", "allMessages", "", "Lio/getstream/chat/android/client/models/Message;", "message", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$Companion */
    /* compiled from: MessageRepository.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final List<Message> allMessages(Message message) {
            Collection listOf = CollectionsKt.listOf(message);
            Message replyTo = message.getReplyTo();
            List<Message> allMessages = replyTo != null ? MessageRepositoryImpl.Companion.allMessages(replyTo) : null;
            if (allMessages == null) {
                allMessages = CollectionsKt.emptyList();
            }
            return CollectionsKt.plus(listOf, allMessages);
        }
    }
}
