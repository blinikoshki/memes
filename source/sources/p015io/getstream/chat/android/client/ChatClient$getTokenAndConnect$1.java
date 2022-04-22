package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/utils/Result;", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$getTokenAndConnect$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$getTokenAndConnect$1 extends Lambda implements Function1<Result<String>, Unit> {
    final /* synthetic */ Function0 $connect;
    final /* synthetic */ ChatClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatClient$getTokenAndConnect$1(ChatClient chatClient, Function0 function0) {
        super(1);
        this.this$0 = chatClient;
        this.$connect = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<String>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<String> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        if (result.isSuccess()) {
            this.this$0.clientStateService.onTokenReceived(result.data());
        } else {
            this.this$0.clientStateService.onTokenReceived("");
        }
        this.$connect.invoke();
    }
}
