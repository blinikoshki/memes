package com.memes.plus.data.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ApiServiceGenerator.kt */
final /* synthetic */ class ApiServiceGenerator$getStoreClient$1 extends MutablePropertyReference0Impl {
    ApiServiceGenerator$getStoreClient$1(ApiServiceGenerator apiServiceGenerator) {
        super(apiServiceGenerator, ApiServiceGenerator.class, "storeApiClient", "getStoreApiClient()Lcom/memes/plus/data/domain/StoreClient;", 0);
    }

    public Object get() {
        return ApiServiceGenerator.access$getStoreApiClient$p((ApiServiceGenerator) this.receiver);
    }

    public void set(Object obj) {
        ApiServiceGenerator.storeApiClient = (StoreClient) obj;
    }
}
