package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName$Companion$USERS_QUERY_SORT$1 */
/* compiled from: SearchUsersByName.kt */
final /* synthetic */ class SearchUsersByName$Companion$USERS_QUERY_SORT$1 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = new SearchUsersByName$Companion$USERS_QUERY_SORT$1();

    SearchUsersByName$Companion$USERS_QUERY_SORT$1() {
        super(ContentUtils.class, "name", "getName(Lio/getstream/chat/android/client/models/User;)Ljava/lang/String;", 1);
    }

    public Object get(Object obj) {
        return ContentUtils.getName((User) obj);
    }

    public void set(Object obj, Object obj2) {
        ContentUtils.setName((User) obj, (String) obj2);
    }
}
