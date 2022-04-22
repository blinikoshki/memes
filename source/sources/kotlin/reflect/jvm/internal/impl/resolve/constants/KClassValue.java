package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: constantValues.kt */
public final class KClassValue extends ConstantValue<Value> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* compiled from: constantValues.kt */
    public static abstract class Value {
        public /* synthetic */ Value(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: constantValues.kt */
        public static final class NormalClass extends Value {
            private final ClassLiteralValue value;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NormalClass) && Intrinsics.areEqual((Object) this.value, (Object) ((NormalClass) obj).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.value + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NormalClass(ClassLiteralValue classLiteralValue) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(classLiteralValue, "value");
                this.value = classLiteralValue;
            }

            public final ClassLiteralValue getValue() {
                return this.value;
            }

            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }
        }

        private Value() {
        }

        /* compiled from: constantValues.kt */
        public static final class LocalClass extends Value {
            private final KotlinType type;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LocalClass) && Intrinsics.areEqual((Object) this.type, (Object) ((LocalClass) obj).type);
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.type + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LocalClass(KotlinType kotlinType) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(kotlinType, "type");
                this.type = kotlinType;
            }

            public final KotlinType getType() {
                return this.type;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassValue(Value value) {
        super(value);
        Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KClassValue(ClassLiteralValue classLiteralValue) {
        this((Value) new Value.NormalClass(classLiteralValue));
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KClassValue(ClassId classId, int i) {
        this(new ClassLiteralValue(classId, i));
        Intrinsics.checkNotNullParameter(classId, "classId");
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        Annotations empty = Annotations.Companion.getEMPTY();
        ClassDescriptor kClass = moduleDescriptor.getBuiltIns().getKClass();
        Intrinsics.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(empty, kClass, CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(moduleDescriptor))));
    }

    public final KotlinType getArgumentType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Value value = (Value) getValue();
        if (value instanceof Value.LocalClass) {
            return ((Value.LocalClass) getValue()).getType();
        }
        if (value instanceof Value.NormalClass) {
            ClassLiteralValue value2 = ((Value.NormalClass) getValue()).getValue();
            ClassId component1 = value2.component1();
            int component2 = value2.component2();
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, component1);
            if (findClassAcrossModuleDependencies == null) {
                SimpleType createErrorType = ErrorUtils.createErrorType("Unresolved type: " + component1 + " (arrayDimensions=" + component2 + ')');
                Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
                return createErrorType;
            }
            SimpleType defaultType = findClassAcrossModuleDependencies.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
            KotlinType replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
            for (int i = 0; i < component2; i++) {
                replaceArgumentsWithStarProjections = moduleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, replaceArgumentsWithStarProjections);
                Intrinsics.checkNotNullExpressionValue(replaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
            }
            return replaceArgumentsWithStarProjections;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: constantValues.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConstantValue<?> create(KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "argumentType");
            if (KotlinTypeKt.isError(kotlinType)) {
                return null;
            }
            KotlinType kotlinType2 = kotlinType;
            int i = 0;
            while (KotlinBuiltIns.isArray(kotlinType2)) {
                kotlinType2 = ((TypeProjection) CollectionsKt.single(kotlinType2.getArguments())).getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtilsKt.getClassId(declarationDescriptor);
                if (classId == null) {
                    return new KClassValue((Value) new Value.LocalClass(kotlinType));
                }
                return new KClassValue(classId, i);
            } else if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            } else {
                ClassId classId2 = ClassId.topLevel(StandardNames.FqNames.any.toSafe());
                Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new KClassValue(classId2, 0);
            }
        }
    }
}
