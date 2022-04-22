package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ResolutionScope.kt */
public interface ResolutionScope {
    ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

    void recordLookup(Name name, LookupLocation lookupLocation);

    /* compiled from: ResolutionScope.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope resolutionScope, DescriptorKindFilter descriptorKindFilter, Function1<Name, Boolean> function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    descriptorKindFilter = DescriptorKindFilter.ALL;
                }
                if ((i & 2) != 0) {
                    function1 = MemberScope.Companion.getALL_NAME_FILTER();
                }
                return resolutionScope.getContributedDescriptors(descriptorKindFilter, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void recordLookup(ResolutionScope resolutionScope, Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(resolutionScope, "this");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            resolutionScope.getContributedFunctions(name, lookupLocation);
        }
    }
}
