package p015io.getstream.chat.android.client.p049di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.ChatClientConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.di.BaseChatModule$getAnonymousProvider$1 */
/* compiled from: BaseChatModule.kt */
final class BaseChatModule$getAnonymousProvider$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ChatClientConfig $config;
    final /* synthetic */ boolean $isAnonymousApi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseChatModule$getAnonymousProvider$1(boolean z, ChatClientConfig chatClientConfig) {
        super(0);
        this.$isAnonymousApi = z;
        this.$config = chatClientConfig;
    }

    public final boolean invoke() {
        return this.$isAnonymousApi || this.$config.isAnonymous();
    }
}
