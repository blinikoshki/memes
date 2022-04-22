package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: KotlinType.kt */
public abstract class WrappedType extends KotlinType {
    /* access modifiers changed from: protected */
    public abstract KotlinType getDelegate();

    public boolean isComputed() {
        return true;
    }

    public WrappedType() {
        super((DefaultConstructorMarker) null);
    }

    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public final UnwrappedType unwrap() {
        KotlinType delegate = getDelegate();
        while (delegate instanceof WrappedType) {
            delegate = ((WrappedType) delegate).getDelegate();
        }
        return (UnwrappedType) delegate;
    }

    public String toString() {
        return isComputed() ? getDelegate().toString() : "<Not computed yet>";
    }
}
