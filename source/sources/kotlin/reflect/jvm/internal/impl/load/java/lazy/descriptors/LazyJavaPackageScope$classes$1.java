package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.facebook.share.internal.ShareConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<LazyJavaPackageScope.FindClassRequest, ClassDescriptor> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f346$c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaPackageScope;
        this.f346$c = lazyJavaResolverContext;
    }

    public final ClassDescriptor invoke(LazyJavaPackageScope.FindClassRequest findClassRequest) {
        KotlinClassFinder.Result result;
        KotlinJvmBinaryClass kotlinJvmBinaryClass;
        ClassId classId;
        LightClassOriginKind lightClassOriginKind;
        FqName fqName;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(findClassRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        ClassId classId2 = new ClassId(this.this$0.getOwnerDescriptor().getFqName(), findClassRequest.getName());
        if (findClassRequest.getJavaClass() != null) {
            result = this.f346$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(findClassRequest.getJavaClass());
        } else {
            result = this.f346$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId2);
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        if (result == null) {
            kotlinJvmBinaryClass = null;
        } else {
            kotlinJvmBinaryClass = result.toKotlinJvmBinaryClass();
        }
        if (kotlinJvmBinaryClass == null) {
            classId = null;
        } else {
            classId = kotlinJvmBinaryClass.getClassId();
        }
        if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
            return null;
        }
        LazyJavaPackageScope.KotlinClassLookupResult access$resolveKotlinBinaryClass = this.this$0.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
            return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) access$resolveKotlinBinaryClass).getDescriptor();
        }
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
            return null;
        }
        if (access$resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
            JavaClass javaClass = findClassRequest.getJavaClass();
            if (javaClass == null) {
                JavaClassFinder finder = this.f346$c.getComponents().getFinder();
                if (result != null) {
                    if (!(result instanceof KotlinClassFinder.Result.ClassFileContent)) {
                        result = null;
                    }
                    KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) result;
                    if (classFileContent != null) {
                        bArr = classFileContent.getContent();
                        javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, (JavaClass) null, 4, (DefaultConstructorMarker) null));
                    }
                }
                bArr = null;
                javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, (JavaClass) null, 4, (DefaultConstructorMarker) null));
            }
            JavaClass javaClass2 = javaClass;
            if (javaClass2 == null) {
                lightClassOriginKind = null;
            } else {
                lightClassOriginKind = javaClass2.getLightClassOriginKind();
            }
            if (lightClassOriginKind != LightClassOriginKind.BINARY) {
                if (javaClass2 == null) {
                    fqName = null;
                } else {
                    fqName = javaClass2.getFqName();
                }
                if (fqName != null && !fqName.isRoot() && Intrinsics.areEqual((Object) fqName.parent(), (Object) this.this$0.getOwnerDescriptor().getFqName())) {
                    lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.f346$c, this.this$0.getOwnerDescriptor(), javaClass2, (ClassDescriptor) null, 8, (DefaultConstructorMarker) null);
                    this.f346$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                }
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId2 + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(this.f346$c.getComponents().getKotlinClassFinder(), javaClass2) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(this.f346$c.getComponents().getKotlinClassFinder(), classId2) + 10);
        }
        throw new NoWhenBranchMatchedException();
    }
}
