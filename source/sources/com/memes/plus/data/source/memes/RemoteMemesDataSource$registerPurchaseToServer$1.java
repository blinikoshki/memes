package com.memes.plus.data.source.memes;

import com.memes.plus.p040ui.subscription.PurchaseRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005H@"}, mo26107d2 = {"registerPurchaseToServer", "", "record", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/memes/plus/data/mapped_response/UniversalResult;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.data.source.memes.RemoteMemesDataSource", mo26808f = "RemoteMemesDataSource.kt", mo26809i = {}, mo26810l = {825}, mo26811m = "registerPurchaseToServer", mo26812n = {}, mo26813s = {})
/* compiled from: RemoteMemesDataSource.kt */
final class RemoteMemesDataSource$registerPurchaseToServer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteMemesDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteMemesDataSource$registerPurchaseToServer$1(RemoteMemesDataSource remoteMemesDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = remoteMemesDataSource;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerPurchaseToServer((PurchaseRecord) null, this);
    }
}
