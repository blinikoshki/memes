package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: typeEnhancement.kt */
final class EnhancementResult<T> {
    private final Annotations enhancementAnnotations;
    private final T result;

    public final T component1() {
        return this.result;
    }

    public final Annotations component2() {
        return this.enhancementAnnotations;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnhancementResult)) {
            return false;
        }
        EnhancementResult enhancementResult = (EnhancementResult) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) enhancementResult.result) && Intrinsics.areEqual((Object) this.enhancementAnnotations, (Object) enhancementResult.enhancementAnnotations);
    }

    public int hashCode() {
        T t = this.result;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.enhancementAnnotations;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.enhancementAnnotations + ')';
    }

    public EnhancementResult(T t, Annotations annotations) {
        this.result = t;
        this.enhancementAnnotations = annotations;
    }
}
