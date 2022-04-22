package com.memes.plus.data.source.purchase;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/data/source/purchase/RemoteStoreDataSource;", "Lcom/memes/plus/data/source/purchase/StoreDataSource;", "()V", "fetchStoreInfo", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteStoreDataSource.kt */
public final class RemoteStoreDataSource implements StoreDataSource {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchStoreInfo(kotlin.coroutines.Continuation<? super com.memes.plus.data.mapped_response.UniversalResult<com.memes.plus.data.source.purchase.StoreInfo>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.memes.plus.data.source.purchase.RemoteStoreDataSource$fetchStoreInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.memes.plus.data.source.purchase.RemoteStoreDataSource$fetchStoreInfo$1 r0 = (com.memes.plus.data.source.purchase.RemoteStoreDataSource$fetchStoreInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.memes.plus.data.source.purchase.RemoteStoreDataSource$fetchStoreInfo$1 r0 = new com.memes.plus.data.source.purchase.RemoteStoreDataSource$fetchStoreInfo$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            com.memes.plus.data.domain.ApiServiceGenerator r8 = com.memes.plus.data.domain.ApiServiceGenerator.INSTANCE
            com.memes.plus.data.domain.StoreClient r8 = r8.getStoreClient()
            r0.label = r3
            java.lang.Object r8 = r8.fetchStoreInfo(r0)
            if (r8 != r1) goto L_0x0044
            return r1
        L_0x0044:
            retrofit2.Response r8 = (retrofit2.Response) r8
            com.memes.plus.data.mapped_response.UniversalResult r6 = new com.memes.plus.data.mapped_response.UniversalResult
            int r1 = r8.code()
            java.lang.String r2 = r8.message()
            java.lang.String r0 = "response.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.Object r8 = r8.body()
            com.memes.plus.data.source.purchase.StoreObjectResponse r8 = (com.memes.plus.data.source.purchase.StoreObjectResponse) r8
            com.memes.plus.data.source.purchase.StoreInfo r3 = com.memes.plus.data.source.purchase.StoreObjectResponseKt.getStoreInfoIfAvailable(r8)
            r4 = 0
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.data.source.purchase.RemoteStoreDataSource.fetchStoreInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
