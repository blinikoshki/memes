package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$constructors$1 extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    public final Collection<ClassConstructorDescriptor> invoke() {
        return this.this$0.computeConstructors();
    }
}
