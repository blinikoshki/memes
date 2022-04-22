package p015io.getstream.chat.android.client.token;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\"\u0010\u0016\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/client/token/TokenManagerImpl;", "Lio/getstream/chat/android/client/token/TokenManager;", "()V", "listeners", "", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/utils/Result;", "", "", "loadingFuture", "Ljava/util/concurrent/Future;", "provider", "Lio/getstream/chat/android/client/token/TokenProvider;", "token", "tokenProviderExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "expireToken", "getToken", "hasToken", "", "hasTokenProvider", "loadAsync", "listener", "loadSync", "onTokenLoaded", "onTokenLoadingError", "cause", "", "setTokenProvider", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.token.TokenManagerImpl */
/* compiled from: TokenManagerImpl.kt */
public final class TokenManagerImpl implements TokenManager {
    private final List<Function1<Result<String>, Unit>> listeners = new ArrayList();
    /* access modifiers changed from: private */
    public volatile Future<?> loadingFuture;
    /* access modifiers changed from: private */
    public TokenProvider provider;
    private volatile String token = "";
    private final ExecutorService tokenProviderExecutor = Executors.newSingleThreadExecutor();

    public static final /* synthetic */ TokenProvider access$getProvider$p(TokenManagerImpl tokenManagerImpl) {
        TokenProvider tokenProvider = tokenManagerImpl.provider;
        if (tokenProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
        }
        return tokenProvider;
    }

    public void loadAsync(Function1<? super Result<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (hasToken()) {
            function1.invoke(new Result(this.token));
            return;
        }
        this.listeners.add(function1);
        loadAsync();
    }

    public void loadAsync() {
        if (this.loadingFuture == null) {
            this.loadingFuture = this.tokenProviderExecutor.submit(new TokenManagerImpl$loadAsync$1(this));
        }
    }

    public void loadSync() {
        try {
            TokenProvider tokenProvider = this.provider;
            if (tokenProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("provider");
            }
            onTokenLoaded(tokenProvider.loadToken());
        } catch (Throwable th) {
            onTokenLoadingError(th);
        }
    }

    public String getToken() {
        return this.token;
    }

    public void expireToken() {
        this.token = "";
    }

    public void setTokenProvider(TokenProvider tokenProvider) {
        Intrinsics.checkNotNullParameter(tokenProvider, "provider");
        this.token = "";
        this.provider = tokenProvider;
    }

    public boolean hasToken() {
        return this.token.length() > 0;
    }

    public boolean hasTokenProvider() {
        return this.provider != null;
    }

    private final synchronized void onTokenLoaded(String str) {
        if (str == null) {
            str = "";
        }
        this.token = str;
        for (Function1 function1 : this.listeners) {
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(new Result(this.token));
            }
        }
        this.listeners.clear();
    }

    private final void onTokenLoadingError(Throwable th) {
        this.token = "";
        for (Function1 function1 : this.listeners) {
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(new Result(new ChatError("Unable to load token", th)));
            }
        }
        this.listeners.clear();
    }
}
