package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR>\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;", "reactionDao", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionDao;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "(Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionDao;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "insertReaction", "", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Lio/getstream/chat/android/client/models/Reaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectReactionsSyncNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUserReactionsToMessage", "messageId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReactionsForMessageByDeletedDate", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl */
/* compiled from: ReactionRepository.kt */
public final class ReactionRepositoryImpl implements ReactionRepository {
    private final Function2<String, Continuation<? super User>, Object> getUser;
    private final ReactionDao reactionDao;

    public ReactionRepositoryImpl(ReactionDao reactionDao2, Function2<? super String, ? super Continuation<? super User>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(reactionDao2, "reactionDao");
        Intrinsics.checkNotNullParameter(function2, "getUser");
        this.reactionDao = reactionDao2;
        this.getUser = function2;
    }

    public Object insertReaction(Reaction reaction, Continuation<? super Unit> continuation) {
        boolean z = true;
        if (reaction.getMessageId().length() > 0) {
            if (reaction.getType().length() > 0) {
                if (reaction.getUserId().length() <= 0) {
                    z = false;
                }
                if (z) {
                    Object insert = this.reactionDao.insert(ReactionMapperKt.toEntity(reaction), continuation);
                    if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return insert;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("user id can't be empty when creating a reaction".toString());
            }
            throw new IllegalArgumentException("type can't be empty when creating a reaction".toString());
        }
        throw new IllegalArgumentException("message id can't be empty when creating a reaction".toString());
    }

    public Object updateReactionsForMessageByDeletedDate(String str, String str2, Date date, Continuation<? super Unit> continuation) {
        Object deleteAt = this.reactionDao.setDeleteAt(str, str2, date, continuation);
        if (deleteAt == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return deleteAt;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectReactionsSyncNeeded(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Reaction>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectReactionsSyncNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectReactionsSyncNeeded$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectReactionsSyncNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectReactionsSyncNeeded$1 r0 = new io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectReactionsSyncNeeded$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
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
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0095
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl r2 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r8)
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao r8 = r7.reactionDao
            r0.L$0 = r7
            r0.label = r4
            r2 = 0
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao.DefaultImpls.selectSyncNeeded$default(r8, r2, r0, r4, r2)
            if (r8 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r2 = r7
        L_0x005f:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r8 = r8.iterator()
            r6 = r2
            r2 = r4
            r4 = r8
        L_0x0075:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x009c
            java.lang.Object r8 = r4.next()
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r8
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r5 = r6.getUser
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r4
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel(r8, r5, r0)
            if (r8 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r5 = r2
        L_0x0095:
            io.getstream.chat.android.client.models.Reaction r8 = (p015io.getstream.chat.android.client.models.Reaction) r8
            r2.add(r8)
            r2 = r5
            goto L_0x0075
        L_0x009c:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl.selectReactionsSyncNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectUserReactionsToMessage(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Reaction>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectUserReactionsToMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectUserReactionsToMessage$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectUserReactionsToMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectUserReactionsToMessage$1 r0 = new io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl$selectUserReactionsToMessage$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r6 = r0.L$3
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl r4 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0094
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl r6 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r8)
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao r8 = r5.reactionDao
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r8 = r8.selectUserReactionsToMessage(r6, r7, r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r6 = r5
        L_0x005e:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r7 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r2)
            r7.<init>(r2)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r8 = r8.iterator()
            r4 = r6
            r6 = r7
            r7 = r8
        L_0x0074:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x009b
            java.lang.Object r8 = r7.next()
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r8
            kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super io.getstream.chat.android.client.models.User>, java.lang.Object> r2 = r4.getUser
            r0.L$0 = r4
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r6
            r0.label = r3
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel(r8, r2, r0)
            if (r8 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r2 = r6
        L_0x0094:
            io.getstream.chat.android.client.models.Reaction r8 = (p015io.getstream.chat.android.client.models.Reaction) r8
            r6.add(r8)
            r6 = r2
            goto L_0x0074
        L_0x009b:
            java.util.List r6 = (java.util.List) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepositoryImpl.selectUserReactionsToMessage(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
