package p015io.getstream.chat.android.client.parser2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KCallable;
import kotlin.reflect.full.KClasses;
import p015io.getstream.chat.android.client.parser2.CustomObjectDtoAdapter;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "", "Value", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.CustomObjectDtoAdapter$memberNames$2 */
/* compiled from: CustomObjectDtoAdapter.kt */
final class CustomObjectDtoAdapter$memberNames$2 extends Lambda implements Function0<List<? extends String>> {
    final /* synthetic */ CustomObjectDtoAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomObjectDtoAdapter$memberNames$2(CustomObjectDtoAdapter customObjectDtoAdapter) {
        super(0);
        this.this$0 = customObjectDtoAdapter;
    }

    public final List<String> invoke() {
        Iterable<KCallable> declaredMemberProperties = KClasses.getDeclaredMemberProperties(this.this$0.kClass);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(declaredMemberProperties, 10));
        for (KCallable name : declaredMemberProperties) {
            arrayList.add(name.getName());
        }
        CustomObjectDtoAdapter.Companion unused = CustomObjectDtoAdapter.Companion;
        return CollectionsKt.minus((List) arrayList, "extraData");
    }
}
