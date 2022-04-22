package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.sequences.SequencesKt;

/* compiled from: typeParameterUtils.kt */
public final class TypeParameterUtilsKt {
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        DeclarationDescriptor declarationDescriptor2 = classifierDescriptorWithTypeParameters;
        List<R> list2 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(declarationDescriptor2), C2024x246a49e2.INSTANCE), C2025x246a49e3.INSTANCE), C2026x246a49e4.INSTANCE));
        Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(declarationDescriptor2).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                declarationDescriptor = null;
                break;
            }
            declarationDescriptor = it.next();
            if (declarationDescriptor instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (!(classDescriptor == null || (typeConstructor = classDescriptor.getTypeConstructor()) == null)) {
            list = typeConstructor.getParameters();
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            Iterable<TypeParameterDescriptor> plus = CollectionsKt.plus(list2, list);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : plus) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "it");
                arrayList.add(capturedCopyForInnerDeclaration(typeParameterDescriptor, declarationDescriptor2, declaredTypeParameters.size()));
            }
            return CollectionsKt.plus(declaredTypeParameters, (List) arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i);
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType r5, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r6, int r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x005d
            r1 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r1
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r1)
            if (r2 == 0) goto L_0x000d
            goto L_0x005d
        L_0x000d:
            java.util.List r2 = r6.getDeclaredTypeParameters()
            int r2 = r2.size()
            int r2 = r2 + r7
            boolean r3 = r6.isInner()
            if (r3 != 0) goto L_0x0040
            java.util.List r3 = r5.getArguments()
            int r3 = r3.size()
            if (r2 == r3) goto L_0x002a
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(r1)
        L_0x002a:
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r1 = new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType
            java.util.List r2 = r5.getArguments()
            java.util.List r5 = r5.getArguments()
            int r5 = r5.size()
            java.util.List r5 = r2.subList(r7, r5)
            r1.<init>(r6, r5, r0)
            return r1
        L_0x0040:
            java.util.List r1 = r5.getArguments()
            java.util.List r7 = r1.subList(r7, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r1 = new kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r6.getContainingDeclaration()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
            if (r4 == 0) goto L_0x0055
            r0 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) r0
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r5 = buildPossiblyInnerType(r5, r0, r2)
            r1.<init>(r6, r7, r5)
            return r1
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.buildPossiblyInnerType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, int):kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType");
    }
}
