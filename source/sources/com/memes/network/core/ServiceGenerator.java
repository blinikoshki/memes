package com.memes.network.core;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.memes.network.chat.source.remote.ChatClient;
import com.memes.network.giphy.source.remote.GiphyClient;
import com.memes.network.memes.source.remote.MemesClient;
import com.memes.network.reddit.source.remote.RedditClient;
import com.memes.network.util.zipgson.list.ZippedListTypeAdapterFactory;
import com.memes.network.util.zipgson.object.ZippedObjectTypeAdapterFactory;
import com.memes.plus.ApiRouting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/core/ServiceGenerator;", "", "()V", "httpClient", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "getHttpClient", "()Lokhttp3/OkHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "getChatClient", "Lcom/memes/network/chat/source/remote/ChatClient;", "getGiphyClient", "Lcom/memes/network/giphy/source/remote/GiphyClient;", "getMemesClient", "Lcom/memes/network/memes/source/remote/MemesClient;", "getRedditClient", "Lcom/memes/network/reddit/source/remote/RedditClient;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ServiceGenerator.kt */
public final class ServiceGenerator {
    private final Lazy httpClient$delegate = LazyKt.lazy(ServiceGenerator$httpClient$2.INSTANCE);

    private final OkHttpClient getHttpClient() {
        return (OkHttpClient) this.httpClient$delegate.getValue();
    }

    public final MemesClient getMemesClient() {
        Object create = new Retrofit.Builder().baseUrl(ApiRouting.BASE_MEMES).client(getHttpClient().newBuilder().build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapterFactory(new ZippedListTypeAdapterFactory()).registerTypeAdapterFactory(new ZippedObjectTypeAdapterFactory()).setLenient().create())).build().create(MemesClient.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(MemesClient::class.java)");
        return (MemesClient) create;
    }

    public final ChatClient getChatClient() {
        Object create = new Retrofit.Builder().baseUrl(ApiRouting.BASE_MEMES).client(getHttpClient().newBuilder().build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create())).build().create(ChatClient.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(ChatClient::class.java)");
        return (ChatClient) create;
    }

    public final RedditClient getRedditClient() {
        Object create = new Retrofit.Builder().baseUrl("https://www.reddit.com/").client(getHttpClient().newBuilder().build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create())).build().create(RedditClient.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(RedditClient::class.java)");
        return (RedditClient) create;
    }

    public final GiphyClient getGiphyClient() {
        Object create = new Retrofit.Builder().baseUrl("https://api.giphy.com/v1/gifs/").client(getHttpClient().newBuilder().build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient().create())).build().create(GiphyClient.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(GiphyClient::class.java)");
        return (GiphyClient) create;
    }
}
