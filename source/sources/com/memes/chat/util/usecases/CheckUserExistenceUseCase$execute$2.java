package com.memes.chat.util.usecases;

import com.memes.chat.util.Strings;
import com.memes.chat.util.Verifications;
import com.memes.chat.util.usecases.CheckUserExistenceUseCase;
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
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/User;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.CheckUserExistenceUseCase$execute$2", mo26808f = "CheckUserExistenceUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CheckUserExistenceUseCase.kt */
final class CheckUserExistenceUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super User>, Object> {
    final /* synthetic */ CheckUserExistenceUseCase.Request $request;
    int label;
    final /* synthetic */ CheckUserExistenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckUserExistenceUseCase$execute$2(CheckUserExistenceUseCase checkUserExistenceUseCase, CheckUserExistenceUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkUserExistenceUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CheckUserExistenceUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CheckUserExistenceUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.m300d("execute: " + this.$request, new Object[0]);
            Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            Verifications.INSTANCE.requireUserId(this.$request.getTargetUserId());
            Result<List<User>> execute = this.this$0.chatClient.queryUsers(new QueryUsersRequest(Filters.m1007eq("id", this.$request.getTargetUserId()), 0, 1, (QuerySort) null, false, 24, (DefaultConstructorMarker) null)).execute();
            if (execute.isSuccess()) {
                User user = (User) CollectionsKt.firstOrNull(execute.data());
                if (Intrinsics.areEqual((Object) user != null ? user.getId() : null, (Object) this.$request.getTargetUserId())) {
                    return user;
                }
                throw new RuntimeException(Strings.INSTANCE.userNotOnStream());
            }
            throw new RuntimeException(Strings.INSTANCE.userExistenceCheckFailed());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
