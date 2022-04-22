package p015io.getstream.chat.android.client;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/User;", "it", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$updateUser$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$updateUser$1 extends Lambda implements Function1<List<? extends User>, User> {
    public static final ChatClient$updateUser$1 INSTANCE = new ChatClient$updateUser$1();

    ChatClient$updateUser$1() {
        super(1);
    }

    public final User invoke(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return (User) CollectionsKt.first(list);
    }
}
