package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

public class FrameworkField extends FrameworkMember<FrameworkField> {
    private final Field field;

    FrameworkField(Field field2) {
        Objects.requireNonNull(field2, "FrameworkField cannot be created without an underlying field.");
        this.field = field2;
    }

    public String getName() {
        return getField().getName();
    }

    public Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.field.getAnnotation(cls);
    }

    public boolean isShadowedBy(FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }

    /* access modifiers changed from: protected */
    public int getModifiers() {
        return this.field.getModifiers();
    }

    public Field getField() {
        return this.field;
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.field.get(obj);
    }

    public String toString() {
        return this.field.toString();
    }
}
