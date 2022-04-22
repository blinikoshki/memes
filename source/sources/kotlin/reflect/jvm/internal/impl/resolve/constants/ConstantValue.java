package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public abstract class ConstantValue<T> {
    private final T value;

    public abstract KotlinType getType(ModuleDescriptor moduleDescriptor);

    public ConstantValue(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            Object value2 = getValue();
            Object obj2 = null;
            ConstantValue constantValue = obj instanceof ConstantValue ? (ConstantValue) obj : null;
            if (constantValue != null) {
                obj2 = constantValue.getValue();
            }
            return Intrinsics.areEqual(value2, obj2);
        }
    }

    public int hashCode() {
        Object value2 = getValue();
        if (value2 == null) {
            return 0;
        }
        return value2.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
