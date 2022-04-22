package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 */
/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class C2092x2cf49cf1 implements KotlinJvmBinaryClass.MemberVisitor {
    final /* synthetic */ HashMap<MemberSignature, List<A>> $memberAnnotations;
    final /* synthetic */ HashMap<MemberSignature, C> $propertyConstants;
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

    C2092x2cf49cf1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> hashMap, HashMap<MemberSignature, C> hashMap2) {
        this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        this.$memberAnnotations = hashMap;
        this.$propertyConstants = hashMap2;
    }

    public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, str));
    }

    public KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String str, Object obj) {
        C loadConstant;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
        if (!(obj == null || (loadConstant = this.this$0.loadConstant(str, obj)) == null)) {
            this.$propertyConstants.put(fromFieldNameAndDesc, loadConstant);
        }
        return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$AnnotationVisitorForMethod */
    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
        final /* synthetic */ C2092x2cf49cf1 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnnotationVisitorForMethod(C2092x2cf49cf1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
            Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
        }

        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
            List list = this.this$0.$memberAnnotations.get(fromMethodSignatureAndParameterIndex);
            if (list == null) {
                list = new ArrayList();
                this.this$0.$memberAnnotations.put(fromMethodSignatureAndParameterIndex, list);
            }
            return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, list);
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$MemberAnnotationVisitor */
    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
        private final ArrayList<A> result = new ArrayList<>();
        private final MemberSignature signature;
        final /* synthetic */ C2092x2cf49cf1 this$0;

        public MemberAnnotationVisitor(C2092x2cf49cf1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            this.signature = memberSignature;
        }

        /* access modifiers changed from: protected */
        public final MemberSignature getSignature() {
            return this.signature;
        }

        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, this.result);
        }

        public void visitEnd() {
            if (!this.result.isEmpty()) {
                this.this$0.$memberAnnotations.put(this.signature, this.result);
            }
        }
    }
}
