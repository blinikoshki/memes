package com.memes.chat.p036ui.directmessaging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.directmessaging.DirectMessagingViewModel$createChannel$2", mo26808f = "DirectMessagingViewModel.kt", mo26809i = {}, mo26810l = {50, 53, 59}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingViewModel$createChannel$2 */
/* compiled from: DirectMessagingViewModel.kt */
final class DirectMessagingViewModel$createChannel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetUserId;
    int label;
    final /* synthetic */ DirectMessagingViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DirectMessagingViewModel$createChannel$2(DirectMessagingViewModel directMessagingViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = directMessagingViewModel;
        this.$targetUserId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new DirectMessagingViewModel$createChannel$2(this.this$0, this.$targetUserId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DirectMessagingViewModel$createChannel$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0067
        L_0x0015:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004f
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0039
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r8)
            com.memes.chat.ui.directmessaging.DirectMessagingViewModel r8 = r7.this$0
            r1 = 0
            com.memes.commons.viewmodel.BaseViewModel.showBlockingProgressDialog$default(r8, r1, r4, r1)
            r5 = 1000(0x3e8, double:4.94E-321)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
            if (r8 != r0) goto L_0x0039
            return r0
        L_0x0039:
            com.memes.chat.util.usecases.CheckUserExistenceUseCase$Request r8 = new com.memes.chat.util.usecases.CheckUserExistenceUseCase$Request
            java.lang.String r1 = r7.$targetUserId
            r8.<init>(r1)
            com.memes.chat.ui.directmessaging.DirectMessagingViewModel r1 = r7.this$0
            com.memes.chat.util.usecases.CheckUserExistenceUseCase r1 = r1.checkUserExistenceUseCase
            r7.label = r3
            java.lang.Object r8 = r1.execute(r8, r7)
            if (r8 != r0) goto L_0x004f
            return r0
        L_0x004f:
            io.getstream.chat.android.client.models.User r8 = (p015io.getstream.chat.android.client.models.User) r8
            com.memes.chat.util.usecases.CreateChannelUseCase$Request$SingleUserChatRequest r1 = new com.memes.chat.util.usecases.CreateChannelUseCase$Request$SingleUserChatRequest
            r1.<init>(r8)
            com.memes.chat.ui.directmessaging.DirectMessagingViewModel r8 = r7.this$0
            com.memes.chat.util.usecases.CreateChannelUseCase r8 = r8.createChannelUseCase
            com.memes.chat.util.usecases.CreateChannelUseCase$Request r1 = (com.memes.chat.util.usecases.CreateChannelUseCase.Request) r1
            r7.label = r2
            java.lang.Object r8 = r8.execute(r1, r7)
            if (r8 != r0) goto L_0x0067
            return r0
        L_0x0067:
            io.getstream.chat.android.client.utils.Result r8 = (p015io.getstream.chat.android.client.utils.Result) r8
            boolean r0 = r8.isSuccess()
            if (r0 == 0) goto L_0x008e
            com.memes.chat.ui.directmessaging.DirectMessagingViewModel r0 = r7.this$0
            r0.hideBlockingProgressDialog()
            com.memes.chat.ui.directmessaging.DirectMessagingViewModel r0 = r7.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r0._channelCreation
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = r8.data()
            java.lang.Object r8 = kotlin.Result.m1029constructorimpl(r8)
            kotlin.Result r8 = kotlin.Result.m1028boximpl(r8)
            r0.setValue(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x008e:
            io.getstream.chat.android.client.errors.ChatError r8 = r8.error()
            java.lang.String r8 = com.memes.chat.util.extensions.ChatErrorExtKt.displayableMessage(r8)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create chat. '"
            r1.append(r2)
            r1.append(r8)
            r8 = 39
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.directmessaging.DirectMessagingViewModel$createChannel$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
