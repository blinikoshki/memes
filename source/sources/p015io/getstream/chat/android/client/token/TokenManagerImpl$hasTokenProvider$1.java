package p015io.getstream.chat.android.client.token;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.token.TokenManagerImpl$hasTokenProvider$1 */
/* compiled from: TokenManagerImpl.kt */
final /* synthetic */ class TokenManagerImpl$hasTokenProvider$1 extends MutablePropertyReference0Impl {
    TokenManagerImpl$hasTokenProvider$1(TokenManagerImpl tokenManagerImpl) {
        super(tokenManagerImpl, TokenManagerImpl.class, "provider", "getProvider()Lio/getstream/chat/android/client/token/TokenProvider;", 0);
    }

    public Object get() {
        return TokenManagerImpl.access$getProvider$p((TokenManagerImpl) this.receiver);
    }

    public void set(Object obj) {
        ((TokenManagerImpl) this.receiver).provider = (TokenProvider) obj;
    }
}
