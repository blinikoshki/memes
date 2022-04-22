package com.memes.chat.util.usecases;

import com.memes.chat.util.usecases.ChatSignInUseCase;
import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/util/usecases/ChatSignInUseCase$Response;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.ChatSignInUseCase$execute$2", mo26808f = "ChatSignInUseCase.kt", mo26809i = {1}, mo26810l = {24, 37}, mo26811m = "invokeSuspend", mo26812n = {"chatToken"}, mo26813s = {"L$0"})
/* compiled from: ChatSignInUseCase.kt */
final class ChatSignInUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChatSignInUseCase.Response>, Object> {
    final /* synthetic */ ChatSignInRequest $request;
    Object L$0;
    int label;
    final /* synthetic */ ChatSignInUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSignInUseCase$execute$2(ChatSignInUseCase chatSignInUseCase, ChatSignInRequest chatSignInRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = chatSignInUseCase;
        this.$request = chatSignInRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChatSignInUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChatSignInUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            r27 = this;
            r0 = r27
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Unable to sign in."
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x002c
            if (r2 == r6) goto L_0x0026
            if (r2 != r4) goto L_0x001e
            java.lang.Object r1 = r0.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r28)
            r4 = r28
            goto L_0x00ca
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r28)
            r2 = r28
            goto L_0x0054
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r28)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "execute: "
            r2.append(r7)
            com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r7 = r0.$request
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            timber.log.Timber.m300d(r2, r7)
            com.memes.chat.util.usecases.ChatSignInUseCase r2 = r0.this$0
            com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r7 = r0.$request
            r0.label = r6
            java.lang.Object r2 = r2.signIn(r7, r0)
            if (r2 != r1) goto L_0x0054
            return r1
        L_0x0054:
            java.lang.String r2 = (java.lang.String) r2
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0064
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r7 = 0
            goto L_0x0065
        L_0x0064:
            r7 = 1
        L_0x0065:
            if (r7 != 0) goto L_0x00dc
            io.getstream.chat.android.client.models.User r7 = new io.getstream.chat.android.client.models.User
            r8 = r7
            com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r9 = r0.$request
            java.lang.String r9 = r9.getUserId()
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 65534(0xfffe, float:9.1833E-41)
            r26 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            java.util.Map r8 = r7.getExtraData()
            com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r9 = r0.$request
            java.lang.String r9 = r9.getUserName()
            java.lang.String r10 = "name"
            r8.put(r10, r9)
            com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r8 = r0.$request
            java.lang.String r8 = r8.getUserImage()
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x00b0
            boolean r9 = kotlin.text.StringsKt.isBlank(r9)
            if (r9 == 0) goto L_0x00b1
        L_0x00b0:
            r5 = 1
        L_0x00b1:
            if (r5 != 0) goto L_0x00bc
            java.util.Map r5 = r7.getExtraData()
            java.lang.String r6 = "image"
            r5.put(r6, r8)
        L_0x00bc:
            com.memes.chat.util.usecases.ChatSignInUseCase r5 = r0.this$0
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r4 = r5.signIn(r7, r2, r0)
            if (r4 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r1 = r2
        L_0x00ca:
            io.getstream.chat.android.client.models.User r4 = (p015io.getstream.chat.android.client.models.User) r4
            if (r4 == 0) goto L_0x00d4
            com.memes.chat.util.usecases.ChatSignInUseCase$Response r2 = new com.memes.chat.util.usecases.ChatSignInUseCase$Response
            r2.<init>(r4, r1)
            return r2
        L_0x00d4:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r3)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00dc:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r3)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.util.usecases.ChatSignInUseCase$execute$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
