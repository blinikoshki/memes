package com.memes.network.memes.source.remote;

import com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H@"}, mo26107d2 = {"searchUsers", "", "paramsRequest", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.memes.source.remote.RemoteMemesDataSource", mo26808f = "RemoteMemesDataSource.kt", mo26809i = {0, 0}, mo26810l = {124}, mo26811m = "searchUsers", mo26812n = {"this", "paramsRequest"}, mo26813s = {"L$0", "L$1"})
/* compiled from: RemoteMemesDataSource.kt */
final class RemoteMemesDataSource$searchUsers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteMemesDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteMemesDataSource$searchUsers$1(RemoteMemesDataSource remoteMemesDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteMemesDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchUsers((UserSearchRequest) null, this);
    }
}
