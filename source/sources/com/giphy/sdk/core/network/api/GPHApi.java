package com.giphy.sdk.core.network.api;

import com.giphy.sdk.core.models.enums.LangType;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.core.network.response.MediaResponse;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&J(\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J6\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&Jc\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0002\u0010\u001dJG\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0002\u0010\u001f¨\u0006 "}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/GPHApi;", "", "emoji", "Ljava/util/concurrent/Future;", "limit", "", "offset", "completionHandler", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "gifById", "gifId", "", "Lcom/giphy/sdk/core/network/response/MediaResponse;", "gifsByIds", "gifIds", "", "random", "tag", "type", "Lcom/giphy/sdk/core/models/enums/MediaType;", "rating", "Lcom/giphy/sdk/core/models/enums/RatingType;", "search", "searchQuery", "lang", "Lcom/giphy/sdk/core/models/enums/LangType;", "pingbackId", "(Ljava/lang/String;Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/models/enums/LangType;Ljava/lang/String;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "trending", "(Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/giphy/sdk/core/models/enums/RatingType;Lcom/giphy/sdk/core/network/api/CompletionHandler;)Ljava/util/concurrent/Future;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GPHApi.kt */
public interface GPHApi {
    Future<?> emoji(Integer num, Integer num2, CompletionHandler<? super ListMediaResponse> completionHandler);

    Future<?> gifById(String str, CompletionHandler<? super MediaResponse> completionHandler);

    Future<?> gifsByIds(List<String> list, CompletionHandler<? super ListMediaResponse> completionHandler);

    Future<?> random(String str, MediaType mediaType, RatingType ratingType, CompletionHandler<? super MediaResponse> completionHandler);

    Future<?> search(String str, MediaType mediaType, Integer num, Integer num2, RatingType ratingType, LangType langType, String str2, CompletionHandler<? super ListMediaResponse> completionHandler);

    Future<?> trending(MediaType mediaType, Integer num, Integer num2, RatingType ratingType, CompletionHandler<? super ListMediaResponse> completionHandler);
}
