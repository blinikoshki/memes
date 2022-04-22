package p015io.getstream.chat.android.client.token;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H'J$\u0010\t\u001a\u00020\u00032\u001a\b\u0002\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0004\u0012\u00020\u00030\u000bH'J\b\u0010\r\u001a\u00020\u0003H'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/token/TokenManager;", "", "expireToken", "", "getToken", "", "hasToken", "", "hasTokenProvider", "loadAsync", "listener", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/utils/Result;", "loadSync", "setTokenProvider", "provider", "Lio/getstream/chat/android/client/token/TokenProvider;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.token.TokenManager */
/* compiled from: TokenManager.kt */
public interface TokenManager {
    void expireToken();

    String getToken();

    boolean hasToken();

    boolean hasTokenProvider();

    void loadAsync();

    void loadAsync(Function1<? super Result<String>, Unit> function1);

    void loadSync();

    void setTokenProvider(TokenProvider tokenProvider);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.token.TokenManager$DefaultImpls */
    /* compiled from: TokenManager.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void loadAsync$default(TokenManager tokenManager, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = TokenManager$loadAsync$1.INSTANCE;
                }
                tokenManager.loadAsync(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAsync");
        }
    }
}
