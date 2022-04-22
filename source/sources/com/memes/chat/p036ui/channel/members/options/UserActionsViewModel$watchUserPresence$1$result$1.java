package com.memes.chat.p036ui.channel.members.options;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/User;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.members.options.UserActionsViewModel$watchUserPresence$1$result$1", mo26808f = "UserActionsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel$watchUserPresence$1$result$1 */
/* compiled from: UserActionsViewModel.kt */
final class UserActionsViewModel$watchUserPresence$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<List<? extends User>>>, Object> {
    int label;
    final /* synthetic */ UserActionsViewModel$watchUserPresence$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionsViewModel$watchUserPresence$1$result$1(UserActionsViewModel$watchUserPresence$1 userActionsViewModel$watchUserPresence$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = userActionsViewModel$watchUserPresence$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new UserActionsViewModel$watchUserPresence$1$result$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UserActionsViewModel$watchUserPresence$1$result$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QueryUsersRequest queryUsersRequest = new QueryUsersRequest(Filters.m1008in("id", (List<?>) CollectionsKt.listOf(this.this$0.$user.getId())), 0, 1, (QuerySort) null, false, 24, (DefaultConstructorMarker) null);
            queryUsersRequest.setPresence(true);
            return this.this$0.this$0.chatClient.queryUsers(queryUsersRequest).execute();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
