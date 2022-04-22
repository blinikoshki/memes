package com.memes.chat.p036ui.channel.members.options;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Flag;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Flag;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.options.UserActionsViewModel$reportUser$1$result$1", mo26808f = "UserActionsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$reportUser$1$result$1 */
/* compiled from: UserActionsViewModel.kt */
final class UserActionsViewModel$reportUser$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<Flag>>, Object> {
    final /* synthetic */ Ref.ObjectRef $targetUserId;
    int label;
    final /* synthetic */ UserActionsViewModel$reportUser$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsViewModel$reportUser$1$result$1(UserActionsViewModel$reportUser$1 userActionsViewModel$reportUser$1, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userActionsViewModel$reportUser$1;
        this.$targetUserId = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserActionsViewModel$reportUser$1$result$1(this.this$0, this.$targetUserId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserActionsViewModel$reportUser$1$result$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.this$0.chatClient.flagUser((String) this.$targetUserId.element).execute();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
