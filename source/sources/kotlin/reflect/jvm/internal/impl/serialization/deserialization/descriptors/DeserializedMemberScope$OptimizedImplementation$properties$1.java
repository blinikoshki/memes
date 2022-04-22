package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$OptimizedImplementation$properties$1 extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$OptimizedImplementation$properties$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.this$0 = optimizedImplementation;
    }

    public final Collection<PropertyDescriptor> invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "it");
        return this.this$0.computeProperties(name);
    }
}
