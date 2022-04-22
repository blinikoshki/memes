package com.memes.network.memes.source.remote;

import com.memes.network.memes.api.MemesDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\n\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\n\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\b2\u0006\u0010\u0016\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b2\u0006\u0010\n\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b2\u0006\u0010\n\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b2\u0006\u0010\n\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0\b2\u0006\u0010\n\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/RemoteMemesDataSource;", "Lcom/memes/network/memes/api/MemesDataSource;", "client", "Lcom/memes/network/memes/source/remote/MemesClient;", "mapper", "Lcom/memes/network/memes/source/remote/MemesMapper;", "(Lcom/memes/network/memes/source/remote/MemesClient;Lcom/memes/network/memes/source/remote/MemesMapper;)V", "checkAccountExists", "Lcom/memes/network/core/UniversalResult;", "", "request", "Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckResult;", "Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/FbAccountCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;", "(Lcom/memes/network/memes/api/model/auth/UsernameCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStockMemes", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "authRequest", "Lcom/memes/network/memes/api/model/core/AuthenticationRequest;", "paramsRequest", "Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;", "(Lcom/memes/network/memes/api/model/core/AuthenticationRequest;Lcom/memes/network/memes/api/model/stockmemes/StockMemesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOtpForAccountRecovery", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryOtpResult;", "Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;", "(Lcom/memes/network/memes/api/model/auth/AccountRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;", "(Lcom/memes/network/memes/api/model/auth/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchUsers", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "(Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "Lcom/memes/network/memes/api/model/auth/AuthResult;", "Lcom/memes/network/memes/api/model/auth/FbSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/FbSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;", "(Lcom/memes/network/memes/api/model/auth/SnapchatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;", "(Lcom/memes/network/memes/api/model/auth/EmailSignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteMemesDataSource.kt */
public final class RemoteMemesDataSource implements MemesDataSource {
    private final MemesClient client;
    private final MemesMapper mapper;

    public RemoteMemesDataSource(MemesClient memesClient, MemesMapper memesMapper) {
        Intrinsics.checkNotNullParameter(memesClient, "client");
        Intrinsics.checkNotNullParameter(memesMapper, "mapper");
        this.client = memesClient;
        this.mapper = memesMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object signIn(com.memes.network.memes.api.model.auth.SignInRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.AuthResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.signIn((com.memes.network.memes.api.model.auth.SignInRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesObjectResponse<com.memes.network.memes.api.model.auth.AuthResult>>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.signIn(com.memes.network.memes.api.model.auth.SignInRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object signIn(com.memes.network.memes.api.model.auth.FbSignInRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.AuthResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$2
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$2 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$2 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$2
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.signIn((com.memes.network.memes.api.model.auth.FbSignInRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesObjectResponse<com.memes.network.memes.api.model.auth.AuthResult>>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.signIn(com.memes.network.memes.api.model.auth.FbSignInRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object signIn(com.memes.network.memes.api.model.auth.SnapchatSignInRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.AuthResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$3
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$3 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$3 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$signIn$3
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.signIn((com.memes.network.memes.api.model.auth.SnapchatSignInRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesObjectResponse<com.memes.network.memes.api.model.auth.AuthResult>>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.signIn(com.memes.network.memes.api.model.auth.SnapchatSignInRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object checkAccountExists(com.memes.network.memes.api.model.auth.FbAccountCheckRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.FbAccountCheckResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.checkAccountExists((com.memes.network.memes.api.model.auth.FbAccountCheckRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesObjectResponse<com.memes.network.memes.api.model.auth.FbAccountCheckResult>>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.checkAccountExists(com.memes.network.memes.api.model.auth.FbAccountCheckRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object checkAccountExists(com.memes.network.memes.api.model.auth.UsernameCheckRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$2
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$2 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$2 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$2
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.checkAccountExists((com.memes.network.memes.api.model.auth.UsernameCheckRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesResponse>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.checkAccountExists(com.memes.network.memes.api.model.auth.UsernameCheckRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object checkAccountExists(com.memes.network.memes.api.model.auth.EmailCheckRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$3
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$3 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$3 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$checkAccountExists$3
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.checkAccountExists((com.memes.network.memes.api.model.auth.EmailCheckRequest) r5, (kotlin.coroutines.Continuation<? super retrofit2.Response<com.memes.network.memes.source.remote.model.core.MemesResponse>>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.checkAccountExists(com.memes.network.memes.api.model.auth.EmailCheckRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object signUp(com.memes.network.memes.api.model.auth.EmailSignUpRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.AuthResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$signUp$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signUp$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$signUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$signUp$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$signUp$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.signUp(r5, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.signUp(com.memes.network.memes.api.model.auth.EmailSignUpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object requestOtpForAccountRecovery(com.memes.network.memes.api.model.auth.AccountRecoveryRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.auth.AccountRecoveryOtpResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$requestOtpForAccountRecovery$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$requestOtpForAccountRecovery$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$requestOtpForAccountRecovery$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$requestOtpForAccountRecovery$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$requestOtpForAccountRecovery$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.requestOtpForAccountRecovery(r5, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processObjectResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.requestOtpForAccountRecovery(com.memes.network.memes.api.model.auth.AccountRecoveryRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object resetPassword(com.memes.network.memes.api.model.auth.ResetPasswordRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$resetPassword$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$resetPassword$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$resetPassword$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$resetPassword$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$resetPassword$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.resetPassword(r5, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            com.memes.network.core.UniversalResult r5 = r5.processResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.resetPassword(com.memes.network.memes.api.model.auth.ResetPasswordRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.memes.network.memes.api.model.stockmemes.StockMemesRequest} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchStockMemes(com.memes.network.memes.api.model.core.AuthenticationRequest r5, com.memes.network.memes.api.model.stockmemes.StockMemesRequest r6, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.api.model.stockmemes.StockMeme>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$fetchStockMemes$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.memes.network.memes.source.remote.RemoteMemesDataSource$fetchStockMemes$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$fetchStockMemes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$fetchStockMemes$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$fetchStockMemes$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.memes.network.memes.api.model.stockmemes.StockMemesRequest r6 = (com.memes.network.memes.api.model.stockmemes.StockMemesRequest) r6
            java.lang.Object r5 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r5 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.memes.network.util.zipgson.object.ZippedObject r7 = new com.memes.network.util.zipgson.object.ZippedObject
            r7.<init>(r5, r6)
            com.memes.network.memes.source.remote.MemesClient r5 = r4.client
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.fetchStockMemes(r7, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r5 = r4
        L_0x0053:
            retrofit2.Response r7 = (retrofit2.Response) r7
            com.memes.network.memes.source.remote.MemesMapper r5 = r5.mapper
            int r6 = r6.getPage()
            com.memes.network.core.UniversalResult r5 = r5.processListResponse(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.fetchStockMemes(com.memes.network.memes.api.model.core.AuthenticationRequest, com.memes.network.memes.api.model.stockmemes.StockMemesRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object searchUsers(com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest r5, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.memes.source.remote.model.usersearch.UserSearchResult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.network.memes.source.remote.RemoteMemesDataSource$searchUsers$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.network.memes.source.remote.RemoteMemesDataSource$searchUsers$1 r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource$searchUsers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.network.memes.source.remote.RemoteMemesDataSource$searchUsers$1 r0 = new com.memes.network.memes.source.remote.RemoteMemesDataSource$searchUsers$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest r5 = (com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest) r5
            java.lang.Object r0 = r0.L$0
            com.memes.network.memes.source.remote.RemoteMemesDataSource r0 = (com.memes.network.memes.source.remote.RemoteMemesDataSource) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0058
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.MemesSession r6 = com.memes.network.memes.MemesSession.INSTANCE
            com.memes.network.memes.api.model.core.AuthenticationRequest r6 = r6.obtainAuthenticationRequest()
            com.memes.network.util.zipgson.object.ZippedObject r2 = new com.memes.network.util.zipgson.object.ZippedObject
            r2.<init>(r6, r5)
            com.memes.network.memes.source.remote.MemesClient r6 = r4.client
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.searchUsers(r2, r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r0 = r4
        L_0x0058:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.network.memes.source.remote.MemesMapper r0 = r0.mapper
            int r5 = r5.getPage()
            com.memes.network.core.UniversalResult r5 = r0.processListResponse(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.memes.source.remote.RemoteMemesDataSource.searchUsers(com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
