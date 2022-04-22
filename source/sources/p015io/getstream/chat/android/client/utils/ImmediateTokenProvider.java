package p015io.getstream.chat.android.client.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.token.TokenProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/ImmediateTokenProvider;", "Lio/getstream/chat/android/client/token/TokenProvider;", "token", "", "(Ljava/lang/String;)V", "loadToken", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.ImmediateTokenProvider */
/* compiled from: ImmediateTokenProvider.kt */
public final class ImmediateTokenProvider implements TokenProvider {
    private final String token;

    public ImmediateTokenProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.token = str;
    }

    public String loadToken() {
        return this.token;
    }
}
