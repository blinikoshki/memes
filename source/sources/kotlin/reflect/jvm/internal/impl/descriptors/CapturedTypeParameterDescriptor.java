package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: typeParameterUtils.kt */
final class CapturedTypeParameterDescriptor implements TypeParameterDescriptor {
    private final DeclarationDescriptor declarationDescriptor;
    private final int declaredTypeParametersCount;
    private final TypeParameterDescriptor originalDescriptor;

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.originalDescriptor.accept(declarationDescriptorVisitor, d);
    }

    public Annotations getAnnotations() {
        return this.originalDescriptor.getAnnotations();
    }

    public SimpleType getDefaultType() {
        return this.originalDescriptor.getDefaultType();
    }

    public Name getName() {
        return this.originalDescriptor.getName();
    }

    public SourceElement getSource() {
        return this.originalDescriptor.getSource();
    }

    public StorageManager getStorageManager() {
        return this.originalDescriptor.getStorageManager();
    }

    public TypeConstructor getTypeConstructor() {
        return this.originalDescriptor.getTypeConstructor();
    }

    public List<KotlinType> getUpperBounds() {
        return this.originalDescriptor.getUpperBounds();
    }

    public Variance getVariance() {
        return this.originalDescriptor.getVariance();
    }

    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    public boolean isReified() {
        return this.originalDescriptor.isReified();
    }

    public CapturedTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor2, int i) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics.checkNotNullParameter(declarationDescriptor2, "declarationDescriptor");
        this.originalDescriptor = typeParameterDescriptor;
        this.declarationDescriptor = declarationDescriptor2;
        this.declaredTypeParametersCount = i;
    }

    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.originalDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.declarationDescriptor;
    }

    public int getIndex() {
        return this.declaredTypeParametersCount + this.originalDescriptor.getIndex();
    }

    public String toString() {
        return this.originalDescriptor + "[inner-copy]";
    }
}
