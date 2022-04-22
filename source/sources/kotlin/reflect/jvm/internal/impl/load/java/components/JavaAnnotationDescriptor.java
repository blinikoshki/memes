package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.appsflyer.share.Constants;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    private final JavaAnnotationArgument firstArgument;
    private final FqName fqName;
    private final boolean isIdeExternalAnnotation;
    private final SourceElement source;
    private final NotNullLazyValue type$delegate;

    public JavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, FqName fqName2) {
        JavaSourceElement javaSourceElement;
        SourceElement sourceElement;
        JavaAnnotationArgument javaAnnotationArgument;
        Collection<JavaAnnotationArgument> arguments;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, Constants.URL_CAMPAIGN);
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.fqName = fqName2;
        Boolean bool = null;
        if (javaAnnotation == null) {
            javaSourceElement = null;
        } else {
            javaSourceElement = lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaAnnotation);
        }
        if (javaSourceElement == null) {
            sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        } else {
            sourceElement = javaSourceElement;
        }
        this.source = sourceElement;
        this.type$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new JavaAnnotationDescriptor$type$2(lazyJavaResolverContext, this));
        if (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) {
            javaAnnotationArgument = null;
        } else {
            javaAnnotationArgument = (JavaAnnotationArgument) CollectionsKt.firstOrNull(arguments);
        }
        this.firstArgument = javaAnnotationArgument;
        this.isIdeExternalAnnotation = Intrinsics.areEqual((Object) javaAnnotation != null ? Boolean.valueOf(javaAnnotation.isIdeExternalAnnotation()) : bool, (Object) true);
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public SourceElement getSource() {
        return this.source;
    }

    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: protected */
    public final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }
}
