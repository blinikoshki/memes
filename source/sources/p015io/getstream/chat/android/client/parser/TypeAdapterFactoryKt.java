package p015io.getstream.chat.android.client.parser;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0002¨\u0006\u0003"}, mo26107d2 = {"getAllInterfaces", "", "Ljava/lang/Class;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.TypeAdapterFactoryKt */
/* compiled from: TypeAdapterFactory.kt */
public final class TypeAdapterFactoryKt {
    /* access modifiers changed from: private */
    public static final List<Class<?>> getAllInterfaces(Class<?> cls) {
        List<Class<?>> list;
        if (Intrinsics.areEqual((Object) cls, (Object) Object.class)) {
            return CollectionsKt.emptyList();
        }
        Class[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "interfaces");
        Collection list2 = ArraysKt.toList((T[]) interfaces);
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (list = getAllInterfaces(superclass)) == null) {
            list = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus(list2, list);
    }
}
