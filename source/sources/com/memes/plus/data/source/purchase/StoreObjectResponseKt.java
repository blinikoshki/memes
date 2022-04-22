package com.memes.plus.data.source.purchase;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002¨\u0006\u0005"}, mo26107d2 = {"getStoreInfoIfAvailable", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "Lcom/memes/plus/data/source/purchase/StoreObjectResponse;", "isSuccessful", "", "app_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: StoreObjectResponse.kt */
public final class StoreObjectResponseKt {
    public static final boolean isSuccessful(StoreObjectResponse storeObjectResponse) {
        if (storeObjectResponse == null) {
            return false;
        }
        return storeObjectResponse.getSuccess();
    }

    public static final StoreInfo getStoreInfoIfAvailable(StoreObjectResponse storeObjectResponse) {
        if (storeObjectResponse != null && isSuccessful(storeObjectResponse)) {
            return storeObjectResponse.getStoreInfo();
        }
        return null;
    }
}
