package com.memes.chat.p036ui.channel.members.options;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.options.UserActionsViewModel$updateUserActionState$2", mo26808f = "UserActionsViewModel.kt", mo26809i = {0, 0, 0}, mo26810l = {66}, mo26811m = "invokeSuspend", mo26812n = {"isSelf", "isDirectMessaging", "canMute"}, mo26813s = {"Z$0", "Z$1", "I$0"})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$updateUserActionState$2 */
/* compiled from: UserActionsViewModel.kt */
final class UserActionsViewModel$updateUserActionState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ User $user;
    int I$0;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ UserActionsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsViewModel$updateUserActionState$2(UserActionsViewModel userActionsViewModel, User user, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userActionsViewModel;
        this.$user = user;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserActionsViewModel$updateUserActionState$2(this.this$0, this.$user, this.$channel, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserActionsViewModel$updateUserActionState$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0022
            if (r2 != r4) goto L_0x001a
            int r1 = r0.I$0
            boolean r2 = r0.Z$1
            boolean r5 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r17)
            r7 = r17
            goto L_0x0063
        L_0x001a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r17)
            io.getstream.chat.android.client.models.User r2 = r0.$user
            java.lang.String r2 = r2.getId()
            com.memes.chat.ui.channel.members.options.UserActionsViewModel r5 = r0.this$0
            io.getstream.chat.android.client.models.User r5 = r5.currentUser
            java.lang.String r5 = r5.getId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            io.getstream.chat.android.client.models.Channel r2 = r0.$channel
            boolean r2 = com.memes.chat.util.extensions.ChannelExtKt.isDirectMessagingScope(r2)
            r6 = r5 ^ 1
            if (r5 == 0) goto L_0x0045
            r11 = 0
            goto L_0x006b
        L_0x0045:
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.memes.chat.ui.channel.members.options.UserActionsViewModel$updateUserActionState$2$isMuted$1 r8 = new com.memes.chat.ui.channel.members.options.UserActionsViewModel$updateUserActionState$2$isMuted$1
            r9 = 0
            r8.<init>(r0, r9)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.Z$0 = r5
            r0.Z$1 = r2
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r0)
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r1 = r6
        L_0x0063:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            r11 = r6
            r6 = r1
        L_0x006b:
            r14 = r5 ^ 1
            com.memes.chat.ui.channel.members.options.UserActionsViewModel r1 = r0.this$0
            com.memes.chat.ui.channel.members.options.UserActionState r15 = new com.memes.chat.ui.channel.members.options.UserActionState
            io.getstream.chat.android.client.models.User r7 = r0.$user
            io.getstream.chat.android.client.models.Channel r8 = r0.$channel
            if (r5 != 0) goto L_0x007b
            if (r2 != 0) goto L_0x007b
            r9 = 1
            goto L_0x007c
        L_0x007b:
            r9 = 0
        L_0x007c:
            if (r6 == 0) goto L_0x0080
            r10 = 1
            goto L_0x0081
        L_0x0080:
            r10 = 0
        L_0x0081:
            r12 = 0
            r13 = 0
            r2 = 0
            r6 = r15
            r3 = r15
            r15 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1.userActionState = r3
            com.memes.chat.ui.channel.members.options.UserActionsViewModel r1 = r0.this$0
            androidx.lifecycle.MutableLiveData r1 = r1._messageUserActionState
            com.memes.chat.ui.channel.members.options.UserActionsViewModel r2 = r0.this$0
            com.memes.chat.ui.channel.members.options.UserActionState r2 = com.memes.chat.p036ui.channel.members.options.UserActionsViewModel.access$getUserActionState$p(r2)
            r1.setValue(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.members.options.UserActionsViewModel$updateUserActionState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
