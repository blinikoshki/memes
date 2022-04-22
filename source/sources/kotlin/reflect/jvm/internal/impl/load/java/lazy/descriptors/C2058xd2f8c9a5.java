package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1 */
/* compiled from: LazyJavaStaticClassScope.kt */
final class C2058xd2f8c9a5 extends Lambda implements Function1<MemberScope, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ Name $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2058xd2f8c9a5(Name name) {
        super(1);
        this.$name = name;
    }

    public final Collection<? extends PropertyDescriptor> invoke(MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "it");
        return memberScope.getContributedVariables(this.$name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }
}
