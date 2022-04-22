package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProvider.kt */
public interface PackageFragmentProviderOptimized extends PackageFragmentProvider {
    void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection);
}
