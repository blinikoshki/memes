package com.memes.network.memes.source.remote;

import com.appsflyer.internal.referrer.Payload;
import com.memes.network.core.UniversalResult;
import com.memes.network.core.pagination.PageBasedPaginationInfo;
import com.memes.network.core.pagination.PaginationInfo;
import com.memes.network.memes.source.remote.model.core.MemesListResponse;
import com.memes.network.memes.source.remote.model.core.MemesObjectResponse;
import com.memes.network.memes.source.remote.model.core.MemesResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n0\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\f0\tJ\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/MemesMapper;", "", "()V", "processListResponse", "Lcom/memes/network/core/UniversalResult;", "ITEM", "currentPage", "", "response", "Lretrofit2/Response;", "Lcom/memes/network/memes/source/remote/model/core/MemesListResponse;", "processObjectResponse", "Lcom/memes/network/memes/source/remote/model/core/MemesObjectResponse;", "processResponse", "Lcom/memes/network/memes/source/remote/model/core/MemesResponse;", "Companion", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesMapper.kt */
public final class MemesMapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SESSION_EXPIRED_MESSAGE = "You need to be a registered user to access this content. Please register a new account or login if you already have an account.";
    private static final List<String> UNAUTHORIZED_ACCESS_TRIGGERS = CollectionsKt.listOf("Access denied", "Please enter correct user id.", "Please provide a User ID.", "Invalid login token");

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/MemesMapper$Companion;", "", "()V", "SESSION_EXPIRED_MESSAGE", "", "UNAUTHORIZED_ACCESS_TRIGGERS", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MemesMapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ UniversalResult processListResponse$default(MemesMapper memesMapper, int i, Response response, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return memesMapper.processListResponse(i, response);
    }

    public final <ITEM> UniversalResult<ITEM> processListResponse(int i, Response<MemesListResponse<ITEM>> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        MemesListResponse body = response.body();
        if (body == null) {
            universalResult.setMessage("Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        String str = "";
        if (!body.isSuccess()) {
            universalResult.setManualError();
            String message2 = body.getMessage();
            if (message2 != null) {
                str = message2;
            }
            universalResult.setMessage(str);
            if (UNAUTHORIZED_ACCESS_TRIGGERS.contains(universalResult.getMessage())) {
                universalResult.setCode(401);
                universalResult.setMessage(SESSION_EXPIRED_MESSAGE);
            }
            return universalResult;
        }
        String message3 = body.getMessage();
        if (message3 != null) {
            str = message3;
        }
        universalResult.setMessage(str);
        universalResult.setItems(body.getData());
        PageBasedPaginationInfo.Companion companion = PageBasedPaginationInfo.Companion;
        Integer totalPages = body.getTotalPages();
        universalResult.setPagination(companion.m2575default(i, totalPages != null ? totalPages.intValue() : 1));
        return universalResult;
    }

    public final <ITEM> UniversalResult<ITEM> processObjectResponse(Response<MemesObjectResponse<ITEM>> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        MemesObjectResponse body = response.body();
        if (body == null) {
            universalResult.setMessage("Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        String str = "";
        if (!body.isSuccess()) {
            universalResult.setManualError();
            String message2 = body.getMessage();
            if (message2 != null) {
                str = message2;
            }
            universalResult.setMessage(str);
            if (UNAUTHORIZED_ACCESS_TRIGGERS.contains(universalResult.getMessage())) {
                universalResult.setCode(401);
                universalResult.setMessage(SESSION_EXPIRED_MESSAGE);
            }
            return universalResult;
        }
        String message3 = body.getMessage();
        if (message3 != null) {
            str = message3;
        }
        universalResult.setMessage(str);
        universalResult.setItem(body.getData());
        return universalResult;
    }

    public final UniversalResult<Object> processResponse(Response<MemesResponse> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        MemesResponse body = response.body();
        if (body == null) {
            universalResult.setMessage("Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        String str = "";
        if (!body.isSuccess()) {
            universalResult.setManualError();
            String message2 = body.getMessage();
            if (message2 != null) {
                str = message2;
            }
            universalResult.setMessage(str);
            if (UNAUTHORIZED_ACCESS_TRIGGERS.contains(universalResult.getMessage())) {
                universalResult.setCode(401);
                universalResult.setMessage(SESSION_EXPIRED_MESSAGE);
            }
            return universalResult;
        }
        String message3 = body.getMessage();
        if (message3 != null) {
            str = message3;
        }
        universalResult.setMessage(str);
        return universalResult;
    }
}
