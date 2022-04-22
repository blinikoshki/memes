package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001aH\u0010\u0003\u001a\u00020\u0002*\u00020\u000121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "Lio/getstream/chat/android/client/models/Reaction;", "toModel", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "(Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt */
/* compiled from: ReactionMapper.kt */
public final class ReactionMapperKt {
    public static final ReactionEntity toEntity(Reaction reaction) {
        Intrinsics.checkNotNullParameter(reaction, "$this$toEntity");
        return new ReactionEntity(reaction.getMessageId(), reaction.fetchUserId(), reaction.getType(), reaction.getScore(), reaction.getCreatedAt(), reaction.getUpdatedAt(), reaction.getDeletedAt(), reaction.getEnforceUnique(), reaction.getExtraData(), reaction.getSyncStatus());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toModel(p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r15, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User>, ? extends java.lang.Object> r16, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Reaction> r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1 r1 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1 r1 = new io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0046
            if (r3 != r4) goto L_0x003e
            int r2 = r1.I$0
            java.lang.Object r3 = r1.L$2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r1.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r1.L$0
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r1 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r2
            r14 = r4
            r4 = r3
            r3 = r14
            goto L_0x0071
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r15.getMessageId()
            java.lang.String r3 = r15.getType()
            int r5 = r15.getScore()
            java.lang.String r6 = r15.getUserId()
            r7 = r15
            r1.L$0 = r7
            r1.L$1 = r0
            r1.L$2 = r3
            r1.I$0 = r5
            r1.label = r4
            r4 = r16
            java.lang.Object r1 = r4.invoke(r6, r1)
            if (r1 != r2) goto L_0x006d
            return r2
        L_0x006d:
            r4 = r3
            r3 = r0
            r0 = r1
            r1 = r7
        L_0x0071:
            r6 = r0
            io.getstream.chat.android.client.models.User r6 = (p015io.getstream.chat.android.client.models.User) r6
            java.util.Map r0 = r1.getExtraData()
            java.util.Map r12 = kotlin.collections.MapsKt.toMutableMap(r0)
            java.util.Date r8 = r1.getCreatedAt()
            java.util.Date r9 = r1.getUpdatedAt()
            java.util.Date r10 = r1.getDeletedAt()
            io.getstream.chat.android.client.utils.SyncStatus r11 = r1.getSyncStatus()
            java.lang.String r7 = r1.getUserId()
            boolean r13 = r1.getEnforceUnique()
            io.getstream.chat.android.client.models.Reaction r0 = new io.getstream.chat.android.client.models.Reaction
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel(io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
