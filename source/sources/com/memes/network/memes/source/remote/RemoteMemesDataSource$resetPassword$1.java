package com.memes.network.memes.source.remote;

import com.memes.network.memes.api.model.auth.ResetPasswordRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005H@"}, mo26107d2 = {"resetPassword", "", "request", "Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/network/core/UniversalResult;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.network.memes.source.remote.RemoteMemesDataSource", mo26808f = "RemoteMemesDataSource.kt", mo26809i = {0}, mo26810l = {95}, mo26811m = "resetPassword", mo26812n = {"this"}, mo26813s = {"L$0"})
/* compiled from: RemoteMemesDataSource.kt */
final class RemoteMemesDataSource$resetPassword$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteMemesDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteMemesDataSource$resetPassword$1(RemoteMemesDataSource remoteMemesDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteMemesDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resetPassword((ResetPasswordRequest) null, this);
    }
}
