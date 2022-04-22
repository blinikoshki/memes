package com.memes.network.memes.api;

import com.memes.network.core.UniversalResult;
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
import com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0004\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0004\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0018H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u0010\u001a\u00020\u001cH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0004\u001a\u00020 H¦@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0004\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0004\u001a\u00020$H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0004\u001a\u00020'H¦@ø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, mo26107d2 = {"Lcom/memes/network/memes/api/MemesDataSource;", "", "checkAccountExists", "Lcom/memes/network/core/UniversalResult;", "request", "Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckResult;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStockMemes", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "authRequest", "Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "paramsRequest", "Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;", "(Lcom/memes/network/memes/api/model/core/AuthenticationRequest;Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOtpForAccountRecovery", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryOtpResult;", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;", "(Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "(Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchUsers", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "(Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "Lcom/memes/network/memes/api/model/auth/AuthResult;", "Lcom/memes/network/memes/api/model/auth/FbSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/FbSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesDataSource.kt */
public interface MemesDataSource {
    Object checkAccountExists(EmailCheckRequest emailCheckRequest, Continuation<? super UniversalResult<Object>> continuation);

    Object checkAccountExists(FbAccountCheckRequest fbAccountCheckRequest, Continuation<? super UniversalResult<FbAccountCheckResult>> continuation);

    Object checkAccountExists(UsernameCheckRequest usernameCheckRequest, Continuation<? super UniversalResult<Object>> continuation);

    Object fetchStockMemes(AuthenticationRequest authenticationRequest, StockMemesRequest stockMemesRequest, Continuation<? super UniversalResult<StockMeme>> continuation);

    Object requestOtpForAccountRecovery(AccountRecoveryRequest accountRecoveryRequest, Continuation<? super UniversalResult<AccountRecoveryOtpResult>> continuation);

    Object resetPassword(ResetPasswordRequest resetPasswordRequest, Continuation<? super UniversalResult<Object>> continuation);

    Object searchUsers(UserSearchRequest userSearchRequest, Continuation<? super UniversalResult<UserSearchResult>> continuation);

    Object signIn(FbSignInRequest fbSignInRequest, Continuation<? super UniversalResult<AuthResult>> continuation);

    Object signIn(SignInRequest signInRequest, Continuation<? super UniversalResult<AuthResult>> continuation);

    Object signIn(SnapchatSignInRequest snapchatSignInRequest, Continuation<? super UniversalResult<AuthResult>> continuation);

    Object signUp(EmailSignUpRequest emailSignUpRequest, Continuation<? super UniversalResult<AuthResult>> continuation);
}
