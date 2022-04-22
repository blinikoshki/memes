package com.memes.network.giphy.source.remote;

import com.memes.network.core.UniversalResult;
import com.memes.network.core.pagination.OffsetBasedPaginationInfo;
import com.memes.network.core.pagination.PaginationInfo;
import com.memes.network.giphy.api.GiphyDataSource;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.giphy.api.model.GiphyPostsRequest;
import com.memes.network.giphy.source.remote.model.GiphyImages;
import com.memes.network.giphy.source.remote.model.GiphyItem;
import com.memes.network.giphy.source.remote.model.GiphyMp4Info;
import com.memes.network.giphy.source.remote.model.GiphyPreviewInfo;
import com.memes.network.giphy.source.remote.model.GiphyResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/RemoteGiphyDataSource;", "Lcom/memes/network/giphy/api/GiphyDataSource;", "giphyClient", "Lcom/memes/network/giphy/source/remote/GiphyClient;", "(Lcom/memes/network/giphy/source/remote/GiphyClient;)V", "fetchQuerySuggestions", "Lcom/memes/network/core/UniversalResult;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processGiphyResponse", "Lcom/memes/network/giphy/api/model/GiphyGif;", "request", "Lcom/memes/network/giphy/api/model/GiphyPostsRequest;", "response", "Lretrofit2/Response;", "Lcom/memes/network/giphy/source/remote/model/GiphyResponse;", "searchGifs", "(Lcom/memes/network/giphy/api/model/GiphyPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteGiphyDataSource.kt */
public final class RemoteGiphyDataSource implements GiphyDataSource {
    private static final String API_KEY = "0lApGRwt2dAR4xjJIjCNdq9n3Q1t4Ygw";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final GiphyClient giphyClient;

    public RemoteGiphyDataSource(GiphyClient giphyClient2) {
        Intrinsics.checkNotNullParameter(giphyClient2, "giphyClient");
        this.giphyClient = giphyClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/RemoteGiphyDataSource$Companion;", "", "()V", "API_KEY", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: RemoteGiphyDataSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object fetchQuerySuggestions(Continuation<? super UniversalResult<String>> continuation) {
        return new UniversalResult(200, "Best response eva!", (Object) null, CollectionsKt.listOf(GiphyPostsRequest.QUERY_TRENDING, "reaction", "meme", "excited", "dance", "angry", "confused", "happy", "bored", "love", "sleepy"), (PaginationInfo) null, 20, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object searchGifs(com.memes.network.giphy.api.model.GiphyPostsRequest r8, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.giphy.api.model.GiphyGif>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.memes.network.giphy.source.remote.RemoteGiphyDataSource$searchGifs$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.memes.network.giphy.source.remote.RemoteGiphyDataSource$searchGifs$1 r0 = (com.memes.network.giphy.source.remote.RemoteGiphyDataSource$searchGifs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.memes.network.giphy.source.remote.RemoteGiphyDataSource$searchGifs$1 r0 = new com.memes.network.giphy.source.remote.RemoteGiphyDataSource$searchGifs$1
            r0.<init>(r7, r9)
        L_0x0019:
            r6 = r0
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x004a
            if (r1 == r3) goto L_0x003e
            if (r1 != r2) goto L_0x0036
            java.lang.Object r8 = r6.L$1
            com.memes.network.giphy.api.model.GiphyPostsRequest r8 = (com.memes.network.giphy.api.model.GiphyPostsRequest) r8
            java.lang.Object r0 = r6.L$0
            com.memes.network.giphy.source.remote.RemoteGiphyDataSource r0 = (com.memes.network.giphy.source.remote.RemoteGiphyDataSource) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0095
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r6.L$1
            com.memes.network.giphy.api.model.GiphyPostsRequest r8 = (com.memes.network.giphy.api.model.GiphyPostsRequest) r8
            java.lang.Object r0 = r6.L$0
            com.memes.network.giphy.source.remote.RemoteGiphyDataSource r0 = (com.memes.network.giphy.source.remote.RemoteGiphyDataSource) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0073
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r8.getQuery()
            java.lang.String r1 = "trending"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r1)
            if (r9 == 0) goto L_0x0076
            com.memes.network.giphy.source.remote.GiphyClient r9 = r7.giphyClient
            java.lang.String r1 = r8.getOffset()
            int r2 = r8.getLimit()
            r6.L$0 = r7
            r6.L$1 = r8
            r6.label = r3
            java.lang.String r3 = "0lApGRwt2dAR4xjJIjCNdq9n3Q1t4Ygw"
            java.lang.Object r9 = r9.fetchTrendingGifs(r3, r1, r2, r6)
            if (r9 != r0) goto L_0x0072
            return r0
        L_0x0072:
            r0 = r7
        L_0x0073:
            retrofit2.Response r9 = (retrofit2.Response) r9
            goto L_0x0097
        L_0x0076:
            com.memes.network.giphy.source.remote.GiphyClient r1 = r7.giphyClient
            java.lang.String r9 = r8.getQuery()
            java.lang.String r4 = r8.getOffset()
            int r5 = r8.getLimit()
            r6.L$0 = r7
            r6.L$1 = r8
            r6.label = r2
            java.lang.String r3 = "0lApGRwt2dAR4xjJIjCNdq9n3Q1t4Ygw"
            r2 = r9
            java.lang.Object r9 = r1.fetchGifs(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0094
            return r0
        L_0x0094:
            r0 = r7
        L_0x0095:
            retrofit2.Response r9 = (retrofit2.Response) r9
        L_0x0097:
            com.memes.network.core.UniversalResult r8 = r0.processGiphyResponse(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.giphy.source.remote.RemoteGiphyDataSource.searchGifs(com.memes.network.giphy.api.model.GiphyPostsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final UniversalResult<GiphyGif> processGiphyResponse(GiphyPostsRequest giphyPostsRequest, Response<GiphyResponse> response) {
        GiphyPreviewInfo previewGif;
        String url;
        GiphyMp4Info originalMp4;
        String mp4;
        GiphyPreviewInfo previewGif2;
        Integer width;
        Integer height;
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        GiphyResponse body = response.body();
        if (body == null) {
            universalResult.setMessage("Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        List<GiphyItem> items = body.getItems();
        if (items != null && (!items.isEmpty())) {
            List arrayList = new ArrayList();
            for (GiphyItem next : items) {
                GiphyImages images = next.getImages();
                if (!(images == null || (previewGif = images.getPreviewGif()) == null || (url = previewGif.getUrl()) == null || (originalMp4 = images.getOriginalMp4()) == null || (mp4 = originalMp4.getMp4()) == null || (previewGif2 = images.getPreviewGif()) == null || (width = previewGif2.getWidth()) == null)) {
                    int intValue = width.intValue();
                    GiphyPreviewInfo previewGif3 = images.getPreviewGif();
                    if (!(previewGif3 == null || (height = previewGif3.getHeight()) == null)) {
                        arrayList.add(new GiphyGif(next.getId(), url, mp4, intValue, height.intValue()));
                    }
                }
            }
            universalResult.setItems(arrayList);
        }
        int parseInt = Integer.parseInt(giphyPostsRequest.getOffset()) + giphyPostsRequest.getLimit();
        universalResult.setMessage("");
        universalResult.setPagination(OffsetBasedPaginationInfo.Companion.m2574default(giphyPostsRequest.getLimit(), String.valueOf(parseInt)));
        return universalResult;
    }
}
