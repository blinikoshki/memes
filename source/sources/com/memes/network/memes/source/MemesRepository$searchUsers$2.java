package com.memes.network.memes.source;

import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.memes.source.MemesRepository$searchUsers$2", mo26808f = "MemesRepository.kt", mo26809i = {}, mo26810l = {90}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: MemesRepository.kt */
final class MemesRepository$searchUsers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UniversalResult<UserSearchResult>>, Object> {
    final /* synthetic */ UserSearchRequest $paramsRequest;
    int label;
    final /* synthetic */ MemesRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemesRepository$searchUsers$2(MemesRepository memesRepository, UserSearchRequest userSearchRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = memesRepository;
        this.$paramsRequest = userSearchRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MemesRepository$searchUsers$2(this.this$0, this.$paramsRequest, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MemesRepository$searchUsers$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MemesDataSource access$getDataSource$p = this.this$0.dataSource;
            UserSearchRequest userSearchRequest = this.$paramsRequest;
            this.label = 1;
            obj = access$getDataSource$p.searchUsers(userSearchRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
