package com.memes.chat.p036ui.channel.members.options;

import com.memes.chat.util.extensions.ChatErrorExtKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.options.UserActionsViewModel$reportUser$1", mo26808f = "UserActionsViewModel.kt", mo26809i = {0}, mo26810l = {226}, mo26811m = "invokeSuspend", mo26812n = {"targetUserName"}, mo26813s = {"L$0"})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$reportUser$1 */
/* compiled from: UserActionsViewModel.kt */
final class UserActionsViewModel$reportUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserActionState $state;
    Object L$0;
    int label;
    final /* synthetic */ UserActionsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsViewModel$reportUser$1(UserActionsViewModel userActionsViewModel, UserActionState userActionState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userActionsViewModel;
        this.$state = userActionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserActionsViewModel$reportUser$1(this.this$0, this.$state, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserActionsViewModel$reportUser$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = this.$state.getUser().getId();
            String name = ContentUtils.getName(this.$state.getUser());
            this.L$0 = name;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UserActionsViewModel$reportUser$1$result$1(this, objectRef, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = name;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result result = (Result) obj;
        if (result.isError()) {
            String displayableMessage = ChatErrorExtKt.displayableMessage(result.error());
            UserActionsViewModel userActionsViewModel = this.this$0;
            userActionsViewModel.toast("Failed to report '" + str + "': " + displayableMessage);
            return Unit.INSTANCE;
        }
        this.$state.setReported(true);
        this.this$0._messageUserActionState.setValue(this.$state);
        UserActionsViewModel userActionsViewModel2 = this.this$0;
        userActionsViewModel2.toast('\'' + str + "' reported successfully.");
        return Unit.INSTANCE;
    }
}
