package com.memes.chat.p036ui.channel.members;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.ChannelMembersViewModel$fetchChannelMembers$2", mo26808f = "ChannelMembersViewModel.kt", mo26809i = {}, mo26810l = {106, 118}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersViewModel$fetchChannelMembers$2 */
/* compiled from: ChannelMembersViewModel.kt */
final class ChannelMembersViewModel$fetchChannelMembers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChannelMembersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMembersViewModel$fetchChannelMembers$2(ChannelMembersViewModel channelMembersViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelMembersViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelMembersViewModel$fetchChannelMembers$2(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelMembersViewModel$fetchChannelMembers$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00b3
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r7 = r6.this$0
            int r7 = r7.membersPaginationPage
            if (r7 != 0) goto L_0x0035
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r1 = r7._channelMembersContentVisibility
            java.lang.String r4 = "Loading Channel Members..."
            r7.showProgress(r1, r4)
        L_0x0035:
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7._channel
            java.lang.Object r7 = r7.getValue()
            if (r7 != 0) goto L_0x0085
            com.memes.chat.util.usecases.ChannelInfoUseCase$Request r7 = new com.memes.chat.util.usecases.ChannelInfoUseCase$Request
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            java.lang.String r1 = com.memes.chat.p036ui.channel.members.ChannelMembersViewModel.access$getChannelId$p(r1)
            r7.<init>(r1)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            com.memes.chat.util.usecases.ChannelInfoUseCase r1 = r1.getChannelInfoUseCase()
            r6.label = r3
            java.lang.Object r7 = r1.execute(r7, r6)
            if (r7 != r0) goto L_0x005b
            return r0
        L_0x005b:
            io.getstream.chat.android.client.models.Channel r7 = (p015io.getstream.chat.android.client.models.Channel) r7
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            androidx.lifecycle.MutableLiveData r1 = r1._channel
            r1.setValue(r7)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            com.memes.commons.util.SingleLiveEvent r1 = r1._canAddMembers
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r4 = r6.this$0
            io.getstream.chat.android.client.models.User r4 = r4.currentUser
            java.lang.Boolean r7 = com.memes.chat.util.extensions.ChannelExtKt.isOwner(r7, r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            r1.setValue(r7)
        L_0x0085:
            com.memes.chat.util.usecases.ChannelMembersUseCase$Request r7 = new com.memes.chat.util.usecases.ChannelMembersUseCase$Request
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            java.lang.String r1 = com.memes.chat.p036ui.channel.members.ChannelMembersViewModel.access$getChannelId$p(r1)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r4 = r6.this$0
            int r4 = r4.membersPaginationPage
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r5 = r6.this$0
            int r5 = r5.membersPaginationLimit
            int r4 = r4 * r5
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r5 = r6.this$0
            int r5 = r5.membersPaginationLimit
            r7.<init>(r1, r4, r5)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            com.memes.chat.util.usecases.ChannelMembersUseCase r1 = r1.getMembersUseCase()
            r6.label = r2
            java.lang.Object r7 = r1.execute(r7, r6)
            if (r7 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            java.util.List r7 = (java.util.List) r7
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r0 = r6.this$0
            int r0 = r0.membersPaginationPage
            if (r0 != 0) goto L_0x00ce
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x00c4
            goto L_0x00ce
        L_0x00c4:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r0 = "No channel members found."
            r7.<init>(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L_0x00ce:
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x00fb
            com.memes.commons.recycleradapter.AdapterUpdate r0 = new com.memes.commons.recycleradapter.AdapterUpdate
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            int r1 = r1.membersPaginationPage
            r0.<init>(r1, r7)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r1 = r6.this$0
            androidx.lifecycle.MutableLiveData r1 = r1._channelMembers
            r1.setValue(r0)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r1 = r0._channelMembersContentVisibility
            r0.showContent(r1)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r0 = r6.this$0
            int r1 = r0.membersPaginationPage
            int r1 = r1 + r3
            r0.membersPaginationPage = r1
        L_0x00fb:
            int r7 = r7.size()
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r0 = r6.this$0
            int r0 = r0.membersPaginationLimit
            r1 = 0
            if (r7 == r0) goto L_0x012e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Channels page="
            r7.append(r0)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r0 = r6.this$0
            int r0 = r0.membersPaginationPage
            r7.append(r0)
            java.lang.String r0 = ": Pagination end has reached."
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            timber.log.Timber.m303e(r7, r0)
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r7 = r6.this$0
            r7.membersPaginationEndReached = r3
        L_0x012e:
            com.memes.chat.ui.channel.members.ChannelMembersViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7._loadingNextMembers
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r7.setValue(r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.members.ChannelMembersViewModel$fetchChannelMembers$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
