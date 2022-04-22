package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ModuleDescriptor.kt */
public interface ModuleDescriptor extends DeclarationDescriptor {
    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> moduleCapability);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1);

    boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor);

    /* compiled from: ModuleDescriptor.kt */
    public static final class DefaultImpls {
        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "this");
            return null;
        }

        public static <R, D> R accept(ModuleDescriptor moduleDescriptor, DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "this");
            Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.visitModuleDeclaration(moduleDescriptor, d);
        }
    }
}
