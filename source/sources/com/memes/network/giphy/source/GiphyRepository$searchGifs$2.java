package com.memes.network.giphy.source;

import com.memes.network.core.UniversalResult;
import com.memes.network.giphy.api.GiphyDataSource;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.giphy.api.model.GiphyPostsRequest;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/giphy/api/model/GiphyGif;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.giphy.source.GiphyRepository$searchGifs$2", mo26808f = "GiphyRepository.kt", mo26809i = {}, mo26810l = {22}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: GiphyRepository.kt */
final class GiphyRepository$searchGifs$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UniversalResult<GiphyGif>>, Object> {
    final /* synthetic */ GiphyPostsRequest $request;
    int label;
    final /* synthetic */ GiphyRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyRepository$searchGifs$2(GiphyRepository giphyRepository, GiphyPostsRequest giphyPostsRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = giphyRepository;
        this.$request = giphyPostsRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new GiphyRepository$searchGifs$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((GiphyRepository$searchGifs$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GiphyDataSource access$getDataSource$p = this.this$0.dataSource;
            GiphyPostsRequest giphyPostsRequest = this.$request;
            this.label = 1;
            obj = access$getDataSource$p.searchGifs(giphyPostsRequest, this);
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
