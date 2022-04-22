package com.snapchat.kit.sdk.core.networking;

import com.google.gson.Gson;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import javax.inject.Inject;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.wire.WireConverterFactory;

@SnapConnectScope
public class ClientFactory {

    /* renamed from: a */
    private final Cache f1242a;

    /* renamed from: b */
    private final Gson f1243b;

    /* renamed from: c */
    private final C4448a f1244c;

    /* renamed from: d */
    private final C4452e f1245d;

    /* renamed from: e */
    private final C4455g f1246e;

    @Inject
    ClientFactory(Cache cache, Gson gson, C4448a aVar, C4452e eVar, C4455g gVar) {
        this.f1242a = cache;
        this.f1243b = gson;
        this.f1244c = aVar;
        this.f1245d = eVar;
        this.f1246e = gVar;
    }

    public <T> T generateAuthedClient(Class<T> cls) {
        return generateAuthedClient("https://api.snapkit.com", cls);
    }

    public <T> T generateAuthedClient(String str, Class<T> cls) {
        return m908a(this.f1245d, str, cls, GsonConverterFactory.create(this.f1243b));
    }

    public <T> T generateAuthedAndFingerprintedWireClient(String str, Class<T> cls) {
        return m908a(this.f1244c, str, cls, WireConverterFactory.create());
    }

    public <T> T generateFingerprintedWireClient(String str, Class<T> cls) {
        return m908a(this.f1246e, str, cls, WireConverterFactory.create());
    }

    public <T> T generateFingerprintedClient(String str, Class<T> cls) {
        return m908a(this.f1246e, str, cls, GsonConverterFactory.create(this.f1243b));
    }

    /* renamed from: a */
    private <T> T m908a(C4457i iVar, String str, Class<T> cls, Converter.Factory factory) {
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().cache(this.f1242a).addInterceptor(iVar);
        if (str.startsWith("https://api.snapkit.com")) {
            addInterceptor.certificatePinner(C4458j.m918a());
        }
        return new Retrofit.Builder().baseUrl(str).client(addInterceptor.build()).addConverterFactory(factory).build().create(cls);
    }
}
