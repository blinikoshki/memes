package com.giphy.sdk.p013ui.pagination;

import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, mo26107d2 = {"com/giphy/sdk/ui/pagination/GifsQuery$Companion$trendingQuery$1", "Lcom/giphy/sdk/ui/pagination/GifsQuery;", "queryGifs", "Ljava/util/concurrent/Future;", "offset", "", "completionHandler", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifsQuery$Companion$trendingQuery$1 */
/* compiled from: GifsQuery.kt */
public final class GifsQuery$Companion$trendingQuery$1 implements GifsQuery {
    final /* synthetic */ MediaType $mediaType;
    final /* synthetic */ RatingType $ratingType;

    GifsQuery$Companion$trendingQuery$1(MediaType mediaType, RatingType ratingType) {
        this.$mediaType = mediaType;
        this.$ratingType = ratingType;
    }

    public Future<?> queryGifs(int i, CompletionHandler<? super ListMediaResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        return GiphyCore.INSTANCE.getApiClient().trending(this.$mediaType, 25, Integer.valueOf(i), this.$ratingType, completionHandler);
    }
}
