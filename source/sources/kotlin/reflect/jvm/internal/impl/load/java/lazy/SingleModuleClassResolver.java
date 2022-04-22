package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* compiled from: ModuleClassResolver.kt */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    public ClassDescriptor resolveClass(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return getResolver().resolveClass(javaClass);
    }

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver javaDescriptorResolver = this.resolver;
        if (javaDescriptorResolver != null) {
            return javaDescriptorResolver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        throw null;
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        Intrinsics.checkNotNullParameter(javaDescriptorResolver, "<set-?>");
        this.resolver = javaDescriptorResolver;
    }
}
