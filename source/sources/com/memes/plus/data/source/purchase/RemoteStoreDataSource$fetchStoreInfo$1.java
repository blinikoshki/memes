package com.memes.plus.data.source.purchase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H@"}, mo26107d2 = {"fetchStoreInfo", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/data/source/purchase/StoreInfo;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.data.source.purchase.RemoteStoreDataSource", mo26808f = "RemoteStoreDataSource.kt", mo26809i = {}, mo26810l = {11}, mo26811m = "fetchStoreInfo", mo26812n = {}, mo26813s = {})
/* compiled from: RemoteStoreDataSource.kt */
final class RemoteStoreDataSource$fetchStoreInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteStoreDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteStoreDataSource$fetchStoreInfo$1(RemoteStoreDataSource remoteStoreDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteStoreDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchStoreInfo(this);
    }
}
