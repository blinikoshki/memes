package com.memes.plus.data.source.memes;

import com.appsflyer.internal.referrer.Payload;
import com.memes.plus.data.api_response.ApiListResponse;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.posts.Post;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.functions.Function;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/posts/Post;", "kotlin.jvm.PlatformType", "response", "Lretrofit2/Response;", "Lcom/memes/plus/data/api_response/ApiListResponse;", "apply"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RemoteMemesDataSource.kt */
final class RemoteMemesDataSource$fetchPosts$1<T, R> implements Function<Response<ApiListResponse<Post>>, UniversalResult<Post>> {
    final /* synthetic */ int $page;

    RemoteMemesDataSource$fetchPosts$1(int i) {
        this.$page = i;
    }

    public final UniversalResult<Post> apply(Response<ApiListResponse<Post>> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        UniversalResult<Post> processListResponse = MemesCoreMapper.INSTANCE.processListResponse(this.$page, response);
        List<Post> items = processListResponse.getItems();
        if (items != null) {
            for (Post updatePostIdForComments : items) {
                updatePostIdForComments.updatePostIdForComments();
            }
        }
        return processListResponse;
    }
}
