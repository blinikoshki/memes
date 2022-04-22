package com.memes.network.memes.source.remote;

import com.memes.network.memes.api.model.auth.AccountRecoveryOtpResult;
import com.memes.network.memes.api.model.auth.AccountRecoveryRequest;
import com.memes.network.memes.api.model.auth.AuthResult;
import com.memes.network.memes.api.model.auth.EmailCheckRequest;
import com.memes.network.memes.api.model.auth.EmailSignUpRequest;
import com.memes.network.memes.api.model.auth.FbAccountCheckRequest;
import com.memes.network.memes.api.model.auth.FbAccountCheckResult;
import com.memes.network.memes.api.model.auth.FbSignInRequest;
import com.memes.network.memes.api.model.auth.ResetPasswordRequest;
import com.memes.network.memes.api.model.auth.SignInRequest;
import com.memes.network.memes.api.model.auth.SnapchatSignInRequest;
import com.memes.network.memes.api.model.auth.UsernameCheckRequest;
import com.memes.network.memes.api.model.core.AuthenticationRequest;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.memes.api.model.stockmemes.StockMemesRequest;
import com.memes.network.memes.source.remote.model.core.MemesListResponse;
import com.memes.network.memes.source.remote.model.core.MemesObjectResponse;
import com.memes.network.memes.source.remote.model.core.MemesResponse;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import com.memes.network.util.zipgson.object.ZippedObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ3\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00032\u0014\b\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ3\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f0\u0012H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\"H§@ø\u0001\u0000¢\u0006\u0002\u0010#J'\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010%J'\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J'\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020)H§@ø\u0001\u0000¢\u0006\u0002\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/MemesClient;", "", "checkAccountExists", "Lretrofit2/Response;", "Lcom/memes/network/memes/source/remote/model/core/MemesResponse;", "request", "Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/source/remote/model/core/MemesObjectResponse;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckResult;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStockMemes", "Lcom/memes/network/memes/source/remote/model/core/MemesListResponse;", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "body", "Lcom/memes/network/util/zipgson/object/ZippedObject;", "Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;", "(Lcom/memes/network/util/zipgson/object/ZippedObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOtpForAccountRecovery", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryOtpResult;", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;", "(Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "(Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchUsers", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "signIn", "Lcom/memes/network/memes/api/model/auth/AuthResult;", "Lcom/memes/network/memes/api/model/auth/FbSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/FbSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesClient.kt */
public interface MemesClient {
    @POST("api/checkEmailExist")
    Object checkAccountExists(@Body EmailCheckRequest emailCheckRequest, Continuation<? super Response<MemesResponse>> continuation);

    @POST("api/checkFbUserExists")
    Object checkAccountExists(@Body FbAccountCheckRequest fbAccountCheckRequest, Continuation<? super Response<MemesObjectResponse<FbAccountCheckResult>>> continuation);

    @POST("api/checkUsernameExist")
    Object checkAccountExists(@Body UsernameCheckRequest usernameCheckRequest, Continuation<? super Response<MemesResponse>> continuation);

    @POST("stockImages")
    Object fetchStockMemes(@Body ZippedObject<AuthenticationRequest, StockMemesRequest> zippedObject, Continuation<? super Response<MemesListResponse<StockMeme>>> continuation);

    @POST("api/forgotpassword")
    Object requestOtpForAccountRecovery(@Body AccountRecoveryRequest accountRecoveryRequest, Continuation<? super Response<MemesObjectResponse<AccountRecoveryOtpResult>>> continuation);

    @POST("api/changePassword")
    Object resetPassword(@Body ResetPasswordRequest resetPasswordRequest, Continuation<? super Response<MemesResponse>> continuation);

    @POST("api/searchByTypes")
    Object searchUsers(@Body ZippedObject<AuthenticationRequest, UserSearchRequest> zippedObject, Continuation<? super Response<MemesListResponse<UserSearchResult>>> continuation);

    @POST("api/loginWithFacebook")
    Object signIn(@Body FbSignInRequest fbSignInRequest, Continuation<? super Response<MemesObjectResponse<AuthResult>>> continuation);

    @POST("api/loginUser")
    Object signIn(@Body SignInRequest signInRequest, Continuation<? super Response<MemesObjectResponse<AuthResult>>> continuation);

    @POST("api/loginWithSnapchat")
    Object signIn(@Body SnapchatSignInRequest snapchatSignInRequest, Continuation<? super Response<MemesObjectResponse<AuthResult>>> continuation);

    @POST("api/userRegistration")
    Object signUp(@Body EmailSignUpRequest emailSignUpRequest, Continuation<? super Response<MemesObjectResponse<AuthResult>>> continuation);
}
