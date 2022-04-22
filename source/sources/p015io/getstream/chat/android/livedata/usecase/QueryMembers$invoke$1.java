package p015io.getstream.chat.android.livedata.usecase;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryMembers$invoke$1 */
/* compiled from: QueryMembers.kt */
final /* synthetic */ class QueryMembers$invoke$1 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = new QueryMembers$invoke$1();

    QueryMembers$invoke$1() {
        super(Member.class, "createdAt", "getCreatedAt()Ljava/util/Date;", 0);
    }

    public Object get(Object obj) {
        return ((Member) obj).getCreatedAt();
    }

    public void set(Object obj, Object obj2) {
        ((Member) obj).setCreatedAt((Date) obj2);
    }
}
