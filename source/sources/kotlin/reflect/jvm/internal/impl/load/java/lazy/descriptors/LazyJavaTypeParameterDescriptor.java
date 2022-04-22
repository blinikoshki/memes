package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaAnnotations annotations;

    /* renamed from: c */
    private final LazyJavaResolverContext f349c;
    private final JavaTypeParameter javaTypeParameter;

    /* access modifiers changed from: protected */
    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyJavaTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r13, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter r14, int r15, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r16) {
        /*
            r12 = this;
            r9 = r12
            r10 = r13
            r11 = r14
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "javaTypeParameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "containingDeclaration"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r13.getStorageManager()
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r14.getName()
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r13.getComponents()
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r8 = r0.getSupertypeLoopChecker()
            r5 = 0
            r0 = r12
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.f349c = r10
            r9.javaTypeParameter = r11
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations r6 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations
            r2 = r11
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r2
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            r1 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r9.annotations = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter, int, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):void");
    }

    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }

    /* access modifiers changed from: protected */
    public List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType anyType = this.f349c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.f349c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Iterable<JavaClassifierType> iterable = upperBounds;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaClassifierType transformJavaType : iterable) {
            arrayList.add(this.f349c.getTypeResolver().transformJavaType(transformJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, (Object) null)));
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: protected */
    public List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "bounds");
        return this.f349c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.f349c);
    }
}
