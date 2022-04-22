package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1 implements DFS.Neighbors<ValueParameterDescriptor> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$1 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$1();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$1() {
    }

    public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
        Iterable<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (ValueParameterDescriptor original : overriddenDescriptors) {
            arrayList.add(original.getOriginal());
        }
        return (List) arrayList;
    }
}
