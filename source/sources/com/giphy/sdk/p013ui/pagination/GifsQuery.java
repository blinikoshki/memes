package com.giphy.sdk.p013ui.pagination;

import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\n"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifsQuery;", "", "queryGifs", "Ljava/util/concurrent/Future;", "offset", "", "completionHandler", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifsQuery */
/* compiled from: GifsQuery.kt */
public interface GifsQuery {
    public static final Companion Companion = Companion.$$INSTANCE;

    Future<?> queryGifs(int i, CompletionHandler<? super ListMediaResponse> completionHandler);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/GifsQuery$Companion;", "", "()V", "emojiQuery", "Lcom/giphy/sdk/ui/pagination/GifsQuery;", "searchQuery", "search", "", "mediaType", "Lcom/giphy/sdk/core/models/enums/MediaType;", "ratingType", "Lcom/giphy/sdk/core/models/enums/RatingType;", "trendingQuery", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.pagination.GifsQuery$Companion */
    /* compiled from: GifsQuery.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ GifsQuery trendingQuery$default(Companion companion, MediaType mediaType, RatingType ratingType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = MediaType.gif;
            }
            return companion.trendingQuery(mediaType, ratingType);
        }

        public final GifsQuery trendingQuery(MediaType mediaType, RatingType ratingType) {
            Intrinsics.checkParameterIsNotNull(mediaType, "mediaType");
            Intrinsics.checkParameterIsNotNull(ratingType, "ratingType");
            return new GifsQuery$Companion$trendingQuery$1(mediaType, ratingType);
        }

        public static /* synthetic */ GifsQuery searchQuery$default(Companion companion, String str, MediaType mediaType, RatingType ratingType, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaType = MediaType.gif;
            }
            return companion.searchQuery(str, mediaType, ratingType);
        }

        public final GifsQuery searchQuery(String str, MediaType mediaType, RatingType ratingType) {
            Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Event.SEARCH);
            Intrinsics.checkParameterIsNotNull(mediaType, "mediaType");
            Intrinsics.checkParameterIsNotNull(ratingType, "ratingType");
            return new GifsQuery$Companion$searchQuery$1(str, mediaType, ratingType);
        }

        public final GifsQuery emojiQuery() {
            return new GifsQuery$Companion$emojiQuery$1();
        }
    }
}
