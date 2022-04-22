package com.memes.chat.p036ui.channel.create;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.create.CreateChannelViewModel$createChannel$2", mo26808f = "CreateChannelViewModel.kt", mo26809i = {0}, mo26810l = {175, 191}, mo26811m = "invokeSuspend", mo26812n = {"channelName"}, mo26813s = {"L$0"})
/* renamed from: com.memes.chat.ui.channel.create.CreateChannelViewModel$createChannel$2 */
/* compiled from: CreateChannelViewModel.kt */
final class CreateChannelViewModel$createChannel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CreateChannelViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateChannelViewModel$createChannel$2(CreateChannelViewModel createChannelViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = createChannelViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CreateChannelViewModel$createChannel$2(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CreateChannelViewModel$createChannel$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00c9
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            java.lang.Object r1 = r6.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0083
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            com.memes.chat.ui.channel.create.CreateChannelViewModel r7 = r6.this$0
            java.lang.String r1 = "Creating Channel..."
            r7.showBlockingProgressDialog(r1)
            com.memes.chat.ui.channel.create.CreateChannelViewModel r7 = r6.this$0
            java.util.List r7 = r7.channelMembers
            int r7 = r7.size()
            if (r7 <= r3) goto L_0x00a1
            com.memes.chat.ui.channel.create.CreateChannelViewModel r7 = r6.this$0
            java.lang.String r1 = r7.channelNameInput
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4 = 0
            if (r7 == 0) goto L_0x004e
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r7 = 0
            goto L_0x004f
        L_0x004e:
            r7 = 1
        L_0x004f:
            if (r7 != 0) goto L_0x0093
            com.memes.chat.ui.channel.create.CreateChannelViewModel r7 = r6.this$0
            java.lang.String r7 = r7.channelImageInput
            r5 = r7
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0062
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x0063
        L_0x0062:
            r4 = 1
        L_0x0063:
            if (r4 == 0) goto L_0x0068
            java.lang.String r7 = "https://cdn.memes.com/media/messages/user-128/pWybDZpn2Bj.jpg"
            goto L_0x0085
        L_0x0068:
            java.io.File r4 = new java.io.File
            r4.<init>(r7)
            com.memes.chat.util.usecases.FileUploadUseCase$Request r7 = new com.memes.chat.util.usecases.FileUploadUseCase$Request
            r7.<init>(r4)
            com.memes.chat.ui.channel.create.CreateChannelViewModel r4 = r6.this$0
            com.memes.chat.util.usecases.FileUploadUseCase r4 = r4.fileUploadUseCase
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r4.execute(r7, r6)
            if (r7 != r0) goto L_0x0083
            return r0
        L_0x0083:
            java.lang.String r7 = (java.lang.String) r7
        L_0x0085:
            com.memes.chat.util.usecases.CreateChannelUseCase$Request$MultiUserChatRequest r3 = new com.memes.chat.util.usecases.CreateChannelUseCase$Request$MultiUserChatRequest
            com.memes.chat.ui.channel.create.CreateChannelViewModel r4 = r6.this$0
            java.util.List r4 = r4.channelMembers
            r3.<init>(r1, r7, r4)
            com.memes.chat.util.usecases.CreateChannelUseCase$Request r3 = (com.memes.chat.util.usecases.CreateChannelUseCase.Request) r3
            goto L_0x00b7
        L_0x0093:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            com.memes.chat.util.Strings r0 = com.memes.chat.util.Strings.INSTANCE
            java.lang.String r0 = r0.errorCreatingChannelWithoutName()
            r7.<init>(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L_0x00a1:
            if (r7 != r3) goto L_0x010c
            com.memes.chat.util.usecases.CreateChannelUseCase$Request$SingleUserChatRequest r7 = new com.memes.chat.util.usecases.CreateChannelUseCase$Request$SingleUserChatRequest
            com.memes.chat.ui.channel.create.CreateChannelViewModel r1 = r6.this$0
            java.util.List r1 = r1.channelMembers
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)
            io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
            r7.<init>(r1)
            r3 = r7
            com.memes.chat.util.usecases.CreateChannelUseCase$Request r3 = (com.memes.chat.util.usecases.CreateChannelUseCase.Request) r3
        L_0x00b7:
            com.memes.chat.ui.channel.create.CreateChannelViewModel r7 = r6.this$0
            com.memes.chat.util.usecases.CreateChannelUseCase r7 = r7.createChannelUseCase
            r1 = 0
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = r7.execute(r3, r6)
            if (r7 != r0) goto L_0x00c9
            return r0
        L_0x00c9:
            io.getstream.chat.android.client.utils.Result r7 = (p015io.getstream.chat.android.client.utils.Result) r7
            boolean r0 = r7.isSuccess()
            if (r0 == 0) goto L_0x00e6
            com.memes.chat.ui.channel.create.CreateChannelViewModel r0 = r6.this$0
            r0.hideBlockingProgressDialog()
            com.memes.chat.ui.channel.create.CreateChannelViewModel r0 = r6.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r0._channelCreated
            java.lang.Object r7 = r7.data()
            r0.setValue(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00e6:
            io.getstream.chat.android.client.errors.ChatError r7 = r7.error()
            java.lang.String r7 = com.memes.chat.util.extensions.ChatErrorExtKt.displayableMessage(r7)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create chat. '"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = "' Error"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x010c:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            com.memes.chat.util.Strings r0 = com.memes.chat.util.Strings.INSTANCE
            java.lang.String r0 = r0.errorCreatingChannelWithoutMembers()
            r7.<init>(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.create.CreateChannelViewModel$createChannel$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
