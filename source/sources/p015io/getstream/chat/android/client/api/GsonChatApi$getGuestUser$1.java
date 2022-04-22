package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.TokenResponse;
import p015io.getstream.chat.android.client.models.GuestUser;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/GuestUser;", "it", "Lio/getstream/chat/android/client/api/models/TokenResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$getGuestUser$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$getGuestUser$1 extends Lambda implements Function1<TokenResponse, GuestUser> {
    public static final GsonChatApi$getGuestUser$1 INSTANCE = new GsonChatApi$getGuestUser$1();

    GsonChatApi$getGuestUser$1() {
        super(1);
    }

    public final GuestUser invoke(TokenResponse tokenResponse) {
        Intrinsics.checkNotNullParameter(tokenResponse, "it");
        return new GuestUser(tokenResponse.getUser(), tokenResponse.getAccessToken());
    }
}
