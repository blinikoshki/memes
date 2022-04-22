package p015io.getstream.chat.android.client.token;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.token.TokenManagerImpl$loadAsync$1 */
/* compiled from: TokenManagerImpl.kt */
final class TokenManagerImpl$loadAsync$1 implements Runnable {
    final /* synthetic */ TokenManagerImpl this$0;

    TokenManagerImpl$loadAsync$1(TokenManagerImpl tokenManagerImpl) {
        this.this$0 = tokenManagerImpl;
    }

    public final void run() {
        this.this$0.loadSync();
        this.this$0.loadingFuture = null;
    }
}
