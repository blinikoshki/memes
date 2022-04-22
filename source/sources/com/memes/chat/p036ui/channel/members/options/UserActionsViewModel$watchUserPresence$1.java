package com.memes.chat.p036ui.channel.members.options;

import com.memes.chat.util.extensions.ChatErrorExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.options.UserActionsViewModel$watchUserPresence$1", mo26808f = "UserActionsViewModel.kt", mo26809i = {}, mo26810l = {97}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$watchUserPresence$1 */
/* compiled from: UserActionsViewModel.kt */
final class UserActionsViewModel$watchUserPresence$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ User $user;
    int label;
    final /* synthetic */ UserActionsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsViewModel$watchUserPresence$1(UserActionsViewModel userActionsViewModel, User user, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userActionsViewModel;
        this.$user = user;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserActionsViewModel$watchUserPresence$1(this.this$0, this.$user, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserActionsViewModel$watchUserPresence$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UserActionsViewModel$watchUserPresence$1$result$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result result = (Result) obj;
        if (result.isError()) {
            this.this$0._messageUserOnline.setValue(null);
            Timber.m303e("watchMessageAuthorPresence: " + ChatErrorExtKt.displayableMessage(result.error()), new Object[0]);
            return Unit.INSTANCE;
        }
        if (!((User) CollectionsKt.first((List) result.data())).getBanned()) {
            this.this$0._messageUserOnline.setValue(Boxing.boxBoolean(this.$user.getOnline()));
        } else {
            this.this$0._messageUserOnline.setValue(null);
        }
        return Unit.INSTANCE;
    }
}
