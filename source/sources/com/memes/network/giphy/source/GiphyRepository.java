package com.memes.network.giphy.source;

import com.memes.network.core.UniversalResult;
import com.memes.network.giphy.api.GiphyDataSource;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.giphy.api.model.GiphyPostsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/network/giphy/source/GiphyRepository;", "Lcom/memes/network/giphy/api/GiphyDataSource;", "dataSource", "(Lcom/memes/network/giphy/api/GiphyDataSource;)V", "fetchQuerySuggestions", "Lcom/memes/network/core/UniversalResult;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchGifs", "Lcom/memes/network/giphy/api/model/GiphyGif;", "request", "Lcom/memes/network/giphy/api/model/GiphyPostsRequest;", "(Lcom/memes/network/giphy/api/model/GiphyPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyRepository.kt */
public final class GiphyRepository implements GiphyDataSource {
    /* access modifiers changed from: private */
    public final GiphyDataSource dataSource;

    public GiphyRepository(GiphyDataSource giphyDataSource) {
        Intrinsics.checkNotNullParameter(giphyDataSource, "dataSource");
        this.dataSource = giphyDataSource;
    }

    public Object fetchQuerySuggestions(Continuation<? super UniversalResult<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GiphyRepository$fetchQuerySuggestions$2(this, (Continuation) null), continuation);
    }

    public Object searchGifs(GiphyPostsRequest giphyPostsRequest, Continuation<? super UniversalResult<GiphyGif>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GiphyRepository$searchGifs$2(this, giphyPostsRequest, (Continuation) null), continuation);
    }
}
