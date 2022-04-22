package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$shadowBanUser$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$shadowBanUser$1 extends Lambda implements Function1<CompletableResponse, Unit> {
    public static final ChatClient$shadowBanUser$1 INSTANCE = new ChatClient$shadowBanUser$1();

    ChatClient$shadowBanUser$1() {
        super(1);
    }

    public final void invoke(CompletableResponse completableResponse) {
        Intrinsics.checkNotNullParameter(completableResponse, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CompletableResponse) obj);
        return Unit.INSTANCE;
    }
}
