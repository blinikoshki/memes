package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1 */
/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class C2095xfa5093a1 implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
    final /* synthetic */ ClassDescriptor $annotationClass;
    final /* synthetic */ Name $name;
    private final ArrayList<ConstantValue<?>> elements = new ArrayList<>();
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 this$0;

    C2095xfa5093a1(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1, Name name, ClassDescriptor classDescriptor) {
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1;
        this.$name = name;
        this.$annotationClass = classDescriptor;
    }

    public void visit(Object obj) {
        this.elements.add(this.this$0.createConstant(this.$name, obj));
    }

    public void visitEnum(ClassId classId, Name name) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name, "enumEntryName");
        this.elements.add(new EnumValue(classId, name));
    }

    public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
        this.elements.add(new KClassValue(classLiteralValue));
    }

    public void visitEnd() {
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(this.$name, this.$annotationClass);
        if (annotationParameterByName != null) {
            Name name = this.$name;
            ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
            List<T> compact = CollectionsKt.compact(this.elements);
            KotlinType type = annotationParameterByName.getType();
            Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
            this.this$0.arguments.put(name, constantValueFactory.createArrayValue((List<? extends ConstantValue<?>>) compact, type));
        }
    }
}
