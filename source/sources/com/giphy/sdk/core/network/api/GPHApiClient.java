package com.giphy.sdk.core.network.api;

import android.net.Uri;
import com.appsflyer.ServerParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.core.models.enums.LangType;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.api.Constants;
import com.giphy.sdk.core.network.engine.DefaultNetworkSession;
import com.giphy.sdk.core.network.engine.NetworkSession;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.core.network.response.MediaResponse;
import com.giphy.sdk.core.network.response.RandomGifResponse;
import com.giphy.sdk.core.threading.ApiTask;
import com.giphy.sdk.tracking.CompletionHandlerExtensionKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.eventtracker.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u000256B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J3\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H\u0016J(\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002JN\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001f0&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(J6\u0010)\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010*\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010+\u001a\u0004\u0018\u00010,2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H\u0016Jc\u0010-\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010.\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0002\u00102JG\u00103\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0002\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u00067"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/GPHApiClient;", "Lcom/giphy/sdk/core/network/api/GPHApi;", "apiKey", "", "networkSession", "Lcom/giphy/sdk/core/network/engine/NetworkSession;", "(Ljava/lang/String;Lcom/giphy/sdk/core/network/engine/NetworkSession;)V", "getApiKey", "()Ljava/lang/String;", "getNetworkSession", "()Lcom/giphy/sdk/core/network/engine/NetworkSession;", "emoji", "Ljava/util/concurrent/Future;", "limit", "", "offset", "completionHandler", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "gifById", "gifId", "Lcom/giphy/sdk/core/network/response/MediaResponse;", "gifsByIds", "gifIds", "", "mediaTypeToEndpoint", "type", "Lcom/giphy/sdk/core/models/enums/MediaType;", "queryStringConnectionWrapper", "Lcom/giphy/sdk/core/threading/ApiTask;", "T", "serverUrl", "Landroid/net/Uri;", "path", "method", "Lcom/giphy/sdk/core/network/api/GPHApiClient$HTTPMethod;", "responseClass", "Ljava/lang/Class;", "queryStrings", "", "random", "tag", "rating", "Lcom/giphy/sdk/core/models/enums/RatingType;", "search", "searchQuery", "lang", "Lcom/giphy/sdk/core/models/enums/LangType;", "pingbackId", "(Ljava/lang/String;Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/models/enums/LangType;Ljava/lang/String;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "trending", "(Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "Companion", "HTTPMethod", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GPHApiClient.kt */
public final class GPHApiClient implements GPHApi {
    public static final String API_KEY = "api_key";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String apiKey;
    private final NetworkSession networkSession;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/GPHApiClient$HTTPMethod;", "", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: GPHApiClient.kt */
    public enum HTTPMethod {
        GET,
        POST,
        PUT,
        DELETE
    }

    public GPHApiClient(String str) {
        this(str, (NetworkSession) null, 2, (DefaultConstructorMarker) null);
    }

    public GPHApiClient(String str, NetworkSession networkSession2) {
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        Intrinsics.checkParameterIsNotNull(networkSession2, "networkSession");
        this.apiKey = str;
        this.networkSession = networkSession2;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHApiClient(String str, NetworkSession networkSession2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new DefaultNetworkSession() : networkSession2);
    }

    public final NetworkSession getNetworkSession() {
        return this.networkSession;
    }

    public Future<?> search(String str, MediaType mediaType, Integer num, Integer num2, RatingType ratingType, LangType langType, String str2, CompletionHandler<? super ListMediaResponse> completionHandler) {
        String str3;
        Map map;
        String str4 = str;
        MediaType mediaType2 = mediaType;
        String str5 = str2;
        Intrinsics.checkParameterIsNotNull(str, "searchQuery");
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        boolean z = false;
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey), TuplesKt.m181to("q", str));
        if (num != null) {
            hashMapOf.put("limit", String.valueOf(num.intValue()));
        }
        if (num2 != null) {
            hashMapOf.put("offset", String.valueOf(num2.intValue()));
        }
        if (ratingType != null) {
            map = hashMapOf;
            str3 = ratingType.toString();
        } else {
            GPHApiClient gPHApiClient = this;
            map = hashMapOf;
            str3 = RatingType.pg13.toString();
        }
        map.put("rating", str3);
        if (langType != null) {
            hashMapOf.put(ServerParameters.LANG, langType.toString());
        }
        if (str5 != null) {
            hashMapOf.put("pingback_id", str5);
        }
        Uri server_url = Constants.INSTANCE.getSERVER_URL();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Constants.Paths.INSTANCE.getSEARCH(), Arrays.copyOf(new Object[]{mediaTypeToEndpoint(mediaType)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        ApiTask<ListMediaResponse> queryStringConnectionWrapper = queryStringConnectionWrapper(server_url, format, HTTPMethod.GET, ListMediaResponse.class, hashMapOf);
        EventType eventType = mediaType2 == MediaType.text ? EventType.TEXT_SEARCH : EventType.GIF_SEARCH;
        if (mediaType2 == MediaType.text) {
            z = true;
        }
        return queryStringConnectionWrapper.executeAsyncTask(CompletionHandlerExtensionKt.completionHandlerWithUserDictionary$default(completionHandler, eventType, false, z, 2, (Object) null));
    }

    public Future<?> trending(MediaType mediaType, Integer num, Integer num2, RatingType ratingType, CompletionHandler<? super ListMediaResponse> completionHandler) {
        Map map;
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey));
        if (num != null) {
            hashMapOf.put("limit", String.valueOf(num.intValue()));
        }
        if (num2 != null) {
            hashMapOf.put("offset", String.valueOf(num2.intValue()));
        }
        if (ratingType != null) {
            map = hashMapOf;
        } else {
            GPHApiClient gPHApiClient = this;
            map = hashMapOf;
            ratingType = RatingType.pg13;
        }
        map.put("rating", ratingType.toString());
        Uri server_url = Constants.INSTANCE.getSERVER_URL();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Constants.Paths.INSTANCE.getTRENDING(), Arrays.copyOf(new Object[]{mediaTypeToEndpoint(mediaType)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return queryStringConnectionWrapper(server_url, format, HTTPMethod.GET, ListMediaResponse.class, hashMapOf).executeAsyncTask(CompletionHandlerExtensionKt.completionHandlerWithUserDictionary$default(completionHandler, mediaType == MediaType.text ? EventType.TEXT_TRENDING : EventType.GIF_TRENDING, false, mediaType == MediaType.text, 2, (Object) null));
    }

    public Future<?> random(String str, MediaType mediaType, RatingType ratingType, CompletionHandler<? super MediaResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey), TuplesKt.m181to(ViewHierarchyConstants.TAG_KEY, str));
        if (ratingType != null) {
            hashMapOf.put("rating", ratingType.toString());
        } else {
            GPHApiClient gPHApiClient = this;
            hashMapOf.put("rating", RatingType.pg13.toString());
        }
        GPHApiClient$random$completionHandlerWrapper$1 gPHApiClient$random$completionHandlerWrapper$1 = new GPHApiClient$random$completionHandlerWrapper$1(completionHandler);
        Uri server_url = Constants.INSTANCE.getSERVER_URL();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Constants.Paths.INSTANCE.getRANDOM(), Arrays.copyOf(new Object[]{mediaTypeToEndpoint(mediaType)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return queryStringConnectionWrapper(server_url, format, HTTPMethod.GET, RandomGifResponse.class, hashMapOf).executeAsyncTask(gPHApiClient$random$completionHandlerWrapper$1);
    }

    public Future<?> gifById(String str, CompletionHandler<? super MediaResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(str, "gifId");
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey));
        Uri server_url = Constants.INSTANCE.getSERVER_URL();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Constants.Paths.INSTANCE.getGIF_BY_ID(), Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return queryStringConnectionWrapper(server_url, format, HTTPMethod.GET, MediaResponse.class, hashMapOf).executeAsyncTask(completionHandler);
    }

    public Future<?> gifsByIds(List<String> list, CompletionHandler<? super ListMediaResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(list, "gifIds");
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey));
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(Util.EVENT_ID_SEPARATOR);
            }
        }
        Map map = hashMapOf;
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "str.toString()");
        map.put("ids", sb2);
        return queryStringConnectionWrapper(Constants.INSTANCE.getSERVER_URL(), Constants.Paths.INSTANCE.getGIF_BY_IDS(), HTTPMethod.GET, ListMediaResponse.class, map).executeAsyncTask(completionHandler);
    }

    public final <T> ApiTask<T> queryStringConnectionWrapper(Uri uri, String str, HTTPMethod hTTPMethod, Class<T> cls, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(uri, "serverUrl");
        Intrinsics.checkParameterIsNotNull(str, "path");
        Intrinsics.checkParameterIsNotNull(hTTPMethod, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkParameterIsNotNull(cls, "responseClass");
        return new ApiTask<>(new GPHApiClient$queryStringConnectionWrapper$1(this, map, uri, str, hTTPMethod, cls), this.networkSession.getNetworkRequestExecutor(), this.networkSession.getCompletionExecutor());
    }

    public Future<?> emoji(Integer num, Integer num2, CompletionHandler<? super ListMediaResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(API_KEY, this.apiKey));
        if (num != null) {
            hashMapOf.put("limit", String.valueOf(num.intValue()));
        }
        if (num2 != null) {
            hashMapOf.put("offset", String.valueOf(num2.intValue()));
        }
        return queryStringConnectionWrapper(Constants.INSTANCE.getSERVER_URL(), Constants.Paths.INSTANCE.getEMOJI(), HTTPMethod.GET, ListMediaResponse.class, hashMapOf).executeAsyncTask(CompletionHandlerExtensionKt.completionHandlerWithUserDictionary$default(completionHandler, EventType.EMOJI, true, false, 4, (Object) null));
    }

    private final String mediaTypeToEndpoint(MediaType mediaType) {
        if (mediaType == MediaType.sticker) {
            return "stickers";
        }
        return mediaType == MediaType.text ? "text" : "gifs";
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/GPHApiClient$Companion;", "", "()V", "API_KEY", "", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: GPHApiClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
