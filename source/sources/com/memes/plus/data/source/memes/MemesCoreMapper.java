package com.memes.plus.data.source.memes;

import com.appsflyer.internal.referrer.Payload;
import com.memes.plus.data.api_response.ApiListResponse;
import com.memes.plus.data.api_response.ApiMessageResponse;
import com.memes.plus.data.api_response.ApiObjectResponse;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u00100\u000fJ2\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\u00102\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000fJ\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fJ&\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u00150\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/data/source/memes/MemesCoreMapper;", "", "()V", "ACCESS_DENIED_TRIGGER", "", "INVALID_USER_MISSING_TRIGGER", "INVALID_USER_TRIGGER", "SESSION_EXPIRED_MESSAGE", "SESSION_EXPIRED_TRIGGER", "processListResponse", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "ITEM", "currentPage", "", "response", "Lretrofit2/Response;", "Lcom/memes/plus/data/api_response/ApiListResponse;", "processListResponseAsWhole", "processMessageResponse", "Lcom/memes/plus/data/api_response/ApiMessageResponse;", "processObjectResponse", "Lcom/memes/plus/data/api_response/ApiObjectResponse;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesCoreMapper.kt */
public final class MemesCoreMapper {
    private static final String ACCESS_DENIED_TRIGGER = "Access denied";
    public static final MemesCoreMapper INSTANCE = new MemesCoreMapper();
    private static final String INVALID_USER_MISSING_TRIGGER = "Please provide a User ID.";
    private static final String INVALID_USER_TRIGGER = "Please enter correct user id.";
    private static final String SESSION_EXPIRED_MESSAGE = "You need to be a registered user to access this content. Please register a new account or login if you already have an account.";
    private static final String SESSION_EXPIRED_TRIGGER = "Invalid login token";

    private MemesCoreMapper() {
    }

    public static /* synthetic */ UniversalResult processListResponseAsWhole$default(MemesCoreMapper memesCoreMapper, int i, Response response, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return memesCoreMapper.processListResponseAsWhole(i, response);
    }

    public final <ITEM extends ApiListResponse<?>> UniversalResult<ITEM> processListResponseAsWhole(int i, Response<ITEM> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        ApiListResponse apiListResponse = (ApiListResponse) response.body();
        if (apiListResponse == null) {
            universalResult.setMessage("Empty Response : " + response.code() + " : " + response.message());
            return universalResult;
        }
        String str = "";
        if (!apiListResponse.isSuccess()) {
            universalResult.setManualError();
            String message2 = apiListResponse.getMessage();
            if (message2 != null) {
                str = message2;
            }
            universalResult.setMessage(str);
            if (Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) SESSION_EXPIRED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) ACCESS_DENIED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_MISSING_TRIGGER)) {
                universalResult.setCode(401);
                universalResult.setMessage(SESSION_EXPIRED_MESSAGE);
            }
            return universalResult;
        }
        String message3 = apiListResponse.getMessage();
        if (message3 != null) {
            str = message3;
        }
        universalResult.setMessage(str);
        universalResult.setItem(apiListResponse);
        PageBasedPaginationInfo.Companion companion = PageBasedPaginationInfo.Companion;
        Integer totalPages = apiListResponse.getTotalPages();
        universalResult.setPagination(companion.m2577default(i, totalPages != null ? totalPages.intValue() : 1));
        return universalResult;
    }

    public static /* synthetic */ UniversalResult processListResponse$default(MemesCoreMapper memesCoreMapper, int i, Response response, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return memesCoreMapper.processListResponse(i, response);
    }

    public final <ITEM> UniversalResult<ITEM> processListResponse(int i, Response<ApiListResponse<ITEM>> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        ApiListResponse body = response.body();
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
            if (Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) SESSION_EXPIRED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) ACCESS_DENIED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_MISSING_TRIGGER)) {
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
        universalResult.setPagination(companion.m2577default(i, totalPages != null ? totalPages.intValue() : 1));
        return universalResult;
    }

    public final <ITEM> UniversalResult<ITEM> processObjectResponse(Response<ApiObjectResponse<ITEM>> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        ApiObjectResponse body = response.body();
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
            if (Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) SESSION_EXPIRED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) ACCESS_DENIED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_MISSING_TRIGGER)) {
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

    public final UniversalResult<Object> processMessageResponse(Response<ApiMessageResponse> response) {
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        int code = response.code();
        String message = response.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        UniversalResult universalResult = new UniversalResult(code, message, (Object) null, (List) null, (PaginationInfo) null, 28, (DefaultConstructorMarker) null);
        if (!response.isSuccessful()) {
            universalResult.setMessage("Api Error " + response.code() + " : " + response.message());
            return universalResult;
        }
        ApiMessageResponse body = response.body();
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
            if (Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) SESSION_EXPIRED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) ACCESS_DENIED_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_TRIGGER) || Intrinsics.areEqual((Object) universalResult.getMessage(), (Object) INVALID_USER_MISSING_TRIGGER)) {
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
