package p015io.getstream.chat.android.client.api;

import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.UpdateUsersResponse;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/User;", "response", "Lio/getstream/chat/android/client/api/models/UpdateUsersResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$updateUsers$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$updateUsers$1 extends Lambda implements Function1<UpdateUsersResponse, List<? extends User>> {
    public static final GsonChatApi$updateUsers$1 INSTANCE = new GsonChatApi$updateUsers$1();

    GsonChatApi$updateUsers$1() {
        super(1);
    }

    public final List<User> invoke(UpdateUsersResponse updateUsersResponse) {
        Intrinsics.checkNotNullParameter(updateUsersResponse, Payload.RESPONSE);
        Map<String, User> users = updateUsersResponse.getUsers();
        Collection arrayList = new ArrayList();
        for (Map.Entry<String, User> value : users.entrySet()) {
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf(value.getValue()));
        }
        return (List) arrayList;
    }
}
