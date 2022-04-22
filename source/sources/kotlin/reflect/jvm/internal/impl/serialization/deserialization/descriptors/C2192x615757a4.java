package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$functionsByName$2 */
/* compiled from: DeserializedMemberScope.kt */
final class C2192x615757a4 extends Lambda implements Function0<Map<Name, ? extends List<? extends SimpleFunctionDescriptor>>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2192x615757a4(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    public final Map<Name, List<SimpleFunctionDescriptor>> invoke() {
        Map<Name, List<SimpleFunctionDescriptor>> linkedHashMap = new LinkedHashMap<>();
        for (Object next : this.this$0.getAllFunctions()) {
            Name name = ((SimpleFunctionDescriptor) next).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            List<SimpleFunctionDescriptor> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add(next);
        }
        return linkedHashMap;
    }
}
