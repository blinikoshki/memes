package com.memes.plus.data.domain;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.memes.plus.ApiRouting;
import com.memes.plus.BuildConfig;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/data/domain/ApiServiceGenerator;", "", "()V", "memesApiClient", "Lcom/memes/plus/data/domain/MemesClient;", "memesRetrofit", "Lretrofit2/Retrofit;", "storeApiClient", "Lcom/memes/plus/data/domain/StoreClient;", "storeRetrofit", "getMemesClient", "getStoreClient", "newHttpClient", "Lokhttp3/OkHttpClient;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ApiServiceGenerator.kt */
public final class ApiServiceGenerator {
    public static final ApiServiceGenerator INSTANCE = new ApiServiceGenerator();
    /* access modifiers changed from: private */
    public static MemesClient memesApiClient;
    /* access modifiers changed from: private */
    public static Retrofit memesRetrofit;
    /* access modifiers changed from: private */
    public static StoreClient storeApiClient;
    /* access modifiers changed from: private */
    public static Retrofit storeRetrofit;

    private ApiServiceGenerator() {
    }

    public static final /* synthetic */ MemesClient access$getMemesApiClient$p(ApiServiceGenerator apiServiceGenerator) {
        MemesClient memesClient = memesApiClient;
        if (memesClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesApiClient");
        }
        return memesClient;
    }

    public static final /* synthetic */ Retrofit access$getMemesRetrofit$p(ApiServiceGenerator apiServiceGenerator) {
        Retrofit retrofit = memesRetrofit;
        if (retrofit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesRetrofit");
        }
        return retrofit;
    }

    public static final /* synthetic */ StoreClient access$getStoreApiClient$p(ApiServiceGenerator apiServiceGenerator) {
        StoreClient storeClient = storeApiClient;
        if (storeClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeApiClient");
        }
        return storeClient;
    }

    public static final /* synthetic */ Retrofit access$getStoreRetrofit$p(ApiServiceGenerator apiServiceGenerator) {
        Retrofit retrofit = storeRetrofit;
        if (retrofit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeRetrofit");
        }
        return retrofit;
    }

    public final MemesClient getMemesClient() {
        MemesClient memesClient = memesApiClient;
        if (memesClient != null) {
            if (memesClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memesApiClient");
            }
            return memesClient;
        }
        Retrofit retrofit = memesRetrofit;
        if (retrofit != null) {
            if (retrofit == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memesRetrofit");
            }
            Object create = retrofit.create(MemesClient.class);
            Intrinsics.checkNotNullExpressionValue(create, "memesRetrofit.create(MemesClient::class.java)");
            return (MemesClient) create;
        }
        Retrofit build = new Retrofit.Builder().baseUrl(ApiRouting.BASE_MEMES).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(newHttpClient()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create())).build();
        Intrinsics.checkNotNullExpressionValue(build, "Retrofit.Builder()\n\t\t\t.b…()\n\t\t\t\t)\n\t\t\t)\n\t\t\t.build()");
        memesRetrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesRetrofit");
        }
        Object create2 = build.create(MemesClient.class);
        Intrinsics.checkNotNullExpressionValue(create2, "memesRetrofit.create(MemesClient::class.java)");
        MemesClient memesClient2 = (MemesClient) create2;
        memesApiClient = memesClient2;
        if (memesClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memesApiClient");
        }
        return memesClient2;
    }

    public final StoreClient getStoreClient() {
        StoreClient storeClient = storeApiClient;
        if (storeClient != null) {
            if (storeClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeApiClient");
            }
            return storeClient;
        }
        Retrofit retrofit = storeRetrofit;
        if (retrofit != null) {
            if (retrofit == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeRetrofit");
            }
            Object create = retrofit.create(StoreClient.class);
            Intrinsics.checkNotNullExpressionValue(create, "storeRetrofit.create(StoreClient::class.java)");
            return (StoreClient) create;
        }
        Retrofit build = new Retrofit.Builder().baseUrl(ApiRouting.INSTANCE.activeStoreUrl()).client(newHttpClient()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create())).build();
        Intrinsics.checkNotNullExpressionValue(build, "Retrofit.Builder()\n\t\t\t.b…()\n\t\t\t\t)\n\t\t\t)\n\t\t\t.build()");
        storeRetrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeRetrofit");
        }
        Object create2 = build.create(StoreClient.class);
        Intrinsics.checkNotNullExpressionValue(create2, "storeRetrofit.create(StoreClient::class.java)");
        StoreClient storeClient2 = (StoreClient) create2;
        storeApiClient = storeClient2;
        if (storeClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeApiClient");
        }
        return storeClient2;
    }

    private final OkHttpClient newHttpClient() {
        OkHttpClient.Builder readTimeout = new OkHttpClient.Builder().addInterceptor(new StaticRequestInterceptor()).connectTimeout(60, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);
        Boolean bool = BuildConfig.DEVELOPER_MODE;
        Intrinsics.checkNotNullExpressionValue(bool, "BuildConfig.DEVELOPER_MODE");
        if (bool.booleanValue()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            Unit unit = Unit.INSTANCE;
            readTimeout.addInterceptor(httpLoggingInterceptor);
        }
        return readTimeout.build();
    }
}
