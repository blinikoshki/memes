package com.memes.plus.data.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ApiServiceGenerator.kt */
final /* synthetic */ class ApiServiceGenerator$getMemesClient$1 extends MutablePropertyReference0Impl {
    ApiServiceGenerator$getMemesClient$1(ApiServiceGenerator apiServiceGenerator) {
        super(apiServiceGenerator, ApiServiceGenerator.class, "memesApiClient", "getMemesApiClient()Lcom/memes/plus/data/domain/MemesClient;", 0);
    }

    public Object get() {
        return ApiServiceGenerator.access$getMemesApiClient$p((ApiServiceGenerator) this.receiver);
    }

    public void set(Object obj) {
        ApiServiceGenerator.memesApiClient = (MemesClient) obj;
    }
}
