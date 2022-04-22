package com.memes.plus.data.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import retrofit2.Retrofit;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ApiServiceGenerator.kt */
final /* synthetic */ class ApiServiceGenerator$getMemesClient$2 extends MutablePropertyReference0Impl {
    ApiServiceGenerator$getMemesClient$2(ApiServiceGenerator apiServiceGenerator) {
        super(apiServiceGenerator, ApiServiceGenerator.class, "memesRetrofit", "getMemesRetrofit()Lretrofit2/Retrofit;", 0);
    }

    public Object get() {
        return ApiServiceGenerator.access$getMemesRetrofit$p((ApiServiceGenerator) this.receiver);
    }

    public void set(Object obj) {
        ApiServiceGenerator.memesRetrofit = (Retrofit) obj;
    }
}
