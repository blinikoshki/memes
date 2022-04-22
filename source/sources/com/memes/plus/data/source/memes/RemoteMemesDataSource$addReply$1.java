package com.memes.plus.data.source.memes;

import com.memes.plus.data.api_response.ApiObjectResponse;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.functions.Function;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Lcom/memes/plus/data/api_response/ApiObjectResponse;", "apply"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RemoteMemesDataSource.kt */
final class RemoteMemesDataSource$addReply$1<T, R> implements Function<Response<ApiObjectResponse<Reply>>, UniversalResult<Reply>> {
    public static final RemoteMemesDataSource$addReply$1 INSTANCE = new RemoteMemesDataSource$addReply$1();

    RemoteMemesDataSource$addReply$1() {
    }

    public final UniversalResult<Reply> apply(Response<ApiObjectResponse<Reply>> response) {
        Intrinsics.checkNotNullParameter(response, "it");
        return MemesCoreMapper.INSTANCE.processObjectResponse(response);
    }
}
