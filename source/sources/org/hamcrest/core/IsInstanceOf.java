package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsInstanceOf extends DiagnosingMatcher<Object> {
    private final Class<?> expectedClass;
    private final Class<?> matchableClass;

    public IsInstanceOf(Class<?> cls) {
        this.expectedClass = cls;
        this.matchableClass = matchableClass(cls);
    }

    private static Class<?> matchableClass(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return Boolean.class;
        }
        if (Byte.TYPE.equals(cls)) {
            return Byte.class;
        }
        if (Character.TYPE.equals(cls)) {
            return Character.class;
        }
        if (Double.TYPE.equals(cls)) {
            return Double.class;
        }
        if (Float.TYPE.equals(cls)) {
            return Float.class;
        }
        if (Integer.TYPE.equals(cls)) {
            return Integer.class;
        }
        if (Long.TYPE.equals(cls)) {
            return Long.class;
        }
        return Short.TYPE.equals(cls) ? Short.class : cls;
    }

    /* access modifiers changed from: protected */
    public boolean matches(Object obj, Description description) {
        if (obj == null) {
            description.appendText("null");
            return false;
        } else if (this.matchableClass.isInstance(obj)) {
            return true;
        } else {
            Description appendValue = description.appendValue(obj);
            appendValue.appendText(" is a " + obj.getClass().getName());
            return false;
        }
    }

    public void describeTo(Description description) {
        description.appendText("an instance of ").appendText(this.expectedClass.getName());
    }

    @Factory
    public static <T> Matcher<T> instanceOf(Class<?> cls) {
        return new IsInstanceOf(cls);
    }

    @Factory
    public static <T> Matcher<T> any(Class<T> cls) {
        return new IsInstanceOf(cls);
    }
}
