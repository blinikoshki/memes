package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotation.kt */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements JavaAnnotation {
    private final Annotation annotation;

    public ReflectJavaAnnotation(Annotation annotation2) {
        Intrinsics.checkNotNullParameter(annotation2, "annotation");
        this.annotation = annotation2;
    }

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    public boolean isFreshlySupportedTypeUseAnnotation() {
        return JavaAnnotation.DefaultImpls.isFreshlySupportedTypeUseAnnotation(this);
    }

    public boolean isIdeExternalAnnotation() {
        return JavaAnnotation.DefaultImpls.isIdeExternalAnnotation(this);
    }

    public Collection<JavaAnnotationArgument> getArguments() {
        Method[] declaredMethods = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)).getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        Object[] objArr = (Object[]) declaredMethods;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Method method = (Method) obj;
            ReflectJavaAnnotationArgument.Factory factory = ReflectJavaAnnotationArgument.Factory;
            Object invoke = method.invoke(getAnnotation(), new Object[0]);
            Intrinsics.checkNotNullExpressionValue(invoke, "method.invoke(annotation)");
            arrayList.add(factory.create(invoke, Name.identifier(method.getName())));
        }
        return (List) arrayList;
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && Intrinsics.areEqual((Object) this.annotation, (Object) ((ReflectJavaAnnotation) obj).annotation);
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.annotation;
    }
}
