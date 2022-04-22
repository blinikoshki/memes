package p015io.getstream.chat.android.client.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.GetReactionsResponse;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Reaction;", "it", "Lio/getstream/chat/android/client/api/models/GetReactionsResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$getReactions$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$getReactions$1 extends Lambda implements Function1<GetReactionsResponse, List<? extends Reaction>> {
    public static final GsonChatApi$getReactions$1 INSTANCE = new GsonChatApi$getReactions$1();

    GsonChatApi$getReactions$1() {
        super(1);
    }

    public final List<Reaction> invoke(GetReactionsResponse getReactionsResponse) {
        Intrinsics.checkNotNullParameter(getReactionsResponse, "it");
        return getReactionsResponse.getReactions();
    }
}
