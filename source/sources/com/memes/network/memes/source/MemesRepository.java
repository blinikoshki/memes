package com.memes.network.memes.source;

import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0007\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0013\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00052\u0006\u0010\u0007\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00052\u0006\u0010\u0007\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00052\u0006\u0010\u0007\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u00052\u0006\u0010\u0007\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, mo26107d2 = {"Lcom/memes/network/memes/source/MemesRepository;", "Lcom/memes/network/memes/api/MemesDataSource;", "dataSource", "(Lcom/memes/network/memes/api/MemesDataSource;)V", "checkAccountExists", "Lcom/memes/network/core/UniversalResult;", "", "request", "Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckResult;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStockMemes", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "authRequest", "Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "paramsRequest", "Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;", "(Lcom/memes/network/memes/api/model/core/AuthenticationRequest;Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOtpForAccountRecovery", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryOtpResult;", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;", "(Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "(Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchUsers", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "(Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "Lcom/memes/network/memes/api/model/auth/AuthResult;", "Lcom/memes/network/memes/api/model/auth/FbSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/FbSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesRepository.kt */
public final class MemesRepository implements MemesDataSource {
    /* access modifiers changed from: private */
    public final MemesDataSource dataSource;

    public MemesRepository(MemesDataSource memesDataSource) {
        Intrinsics.checkNotNullParameter(memesDataSource, "dataSource");
        this.dataSource = memesDataSource;
    }

    public Object signIn(SignInRequest signInRequest, Continuation<? super UniversalResult<AuthResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$signIn$2(this, signInRequest, (Continuation) null), continuation);
    }

    public Object signIn(FbSignInRequest fbSignInRequest, Continuation<? super UniversalResult<AuthResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$signIn$4(this, fbSignInRequest, (Continuation) null), continuation);
    }

    public Object signIn(SnapchatSignInRequest snapchatSignInRequest, Continuation<? super UniversalResult<AuthResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$signIn$6(this, snapchatSignInRequest, (Continuation) null), continuation);
    }

    public Object checkAccountExists(FbAccountCheckRequest fbAccountCheckRequest, Continuation<? super UniversalResult<FbAccountCheckResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$checkAccountExists$2(this, fbAccountCheckRequest, (Continuation) null), continuation);
    }

    public Object checkAccountExists(UsernameCheckRequest usernameCheckRequest, Continuation<? super UniversalResult<Object>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$checkAccountExists$4(this, usernameCheckRequest, (Continuation) null), continuation);
    }

    public Object checkAccountExists(EmailCheckRequest emailCheckRequest, Continuation<? super UniversalResult<Object>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$checkAccountExists$6(this, emailCheckRequest, (Continuation) null), continuation);
    }

    public Object signUp(EmailSignUpRequest emailSignUpRequest, Continuation<? super UniversalResult<AuthResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$signUp$2(this, emailSignUpRequest, (Continuation) null), continuation);
    }

    public Object requestOtpForAccountRecovery(AccountRecoveryRequest accountRecoveryRequest, Continuation<? super UniversalResult<AccountRecoveryOtpResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$requestOtpForAccountRecovery$2(this, accountRecoveryRequest, (Continuation) null), continuation);
    }

    public Object resetPassword(ResetPasswordRequest resetPasswordRequest, Continuation<? super UniversalResult<Object>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$resetPassword$2(this, resetPasswordRequest, (Continuation) null), continuation);
    }

    public Object fetchStockMemes(AuthenticationRequest authenticationRequest, StockMemesRequest stockMemesRequest, Continuation<? super UniversalResult<StockMeme>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$fetchStockMemes$2(this, authenticationRequest, stockMemesRequest, (Continuation) null), continuation);
    }

    public Object searchUsers(UserSearchRequest userSearchRequest, Continuation<? super UniversalResult<UserSearchResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$searchUsers$2(this, userSearchRequest, (Continuation) null), continuation);
    }
}
