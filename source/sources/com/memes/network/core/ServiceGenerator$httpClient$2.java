package com.memes.network.core;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ServiceGenerator.kt */
final class ServiceGenerator$httpClient$2 extends Lambda implements Function0<OkHttpClient> {
    public static final ServiceGenerator$httpClient$2 INSTANCE = new ServiceGenerator$httpClient$2();

    ServiceGenerator$httpClient$2() {
        super(0);
    }

    public final OkHttpClient invoke() {
        OkHttpClient.Builder readTimeout = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        readTimeout.addInterceptor(httpLoggingInterceptor);
        return readTimeout.build();
    }
}
