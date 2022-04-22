package com.memes.plus.data.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import retrofit2.Retrofit;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ApiServiceGenerator.kt */
final /* synthetic */ class ApiServiceGenerator$getStoreClient$2 extends MutablePropertyReference0Impl {
    ApiServiceGenerator$getStoreClient$2(ApiServiceGenerator apiServiceGenerator) {
        super(apiServiceGenerator, ApiServiceGenerator.class, "storeRetrofit", "getStoreRetrofit()Lretrofit2/Retrofit;", 0);
    }

    public Object get() {
        return ApiServiceGenerator.access$getStoreRetrofit$p((ApiServiceGenerator) this.receiver);
    }

    public void set(Object obj) {
        ApiServiceGenerator.storeRetrofit = (Retrofit) obj;
    }
}
