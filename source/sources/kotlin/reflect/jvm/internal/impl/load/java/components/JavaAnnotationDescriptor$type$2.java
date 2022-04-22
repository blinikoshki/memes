package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f336$c;
    final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaAnnotationDescriptor$type$2(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.f336$c = lazyJavaResolverContext;
        this.this$0 = javaAnnotationDescriptor;
    }

    public final SimpleType invoke() {
        SimpleType defaultType = this.f336$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
        return defaultType;
    }
}
