package com.memes.network.giphy.api;

import com.memes.network.core.UniversalResult;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.giphy.api.model.GiphyPostsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/network/giphy/api/GiphyDataSource;", "", "fetchQuerySuggestions", "Lcom/memes/network/core/UniversalResult;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchGifs", "Lcom/memes/network/giphy/api/model/GiphyGif;", "request", "Lcom/memes/network/giphy/api/model/GiphyPostsRequest;", "(Lcom/memes/network/giphy/api/model/GiphyPostsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyDataSource.kt */
public interface GiphyDataSource {
    Object fetchQuerySuggestions(Continuation<? super UniversalResult<String>> continuation);

    Object searchGifs(GiphyPostsRequest giphyPostsRequest, Continuation<? super UniversalResult<GiphyGif>> continuation);
}
