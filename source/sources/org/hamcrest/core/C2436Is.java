package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* renamed from: org.hamcrest.core.Is */
public class C2436Is<T> extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public C2436Is(Matcher<T> matcher2) {
        this.matcher = matcher2;
    }

    public boolean matches(Object obj) {
        return this.matcher.matches(obj);
    }

    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    public void describeMismatch(Object obj, Description description) {
        this.matcher.describeMismatch(obj, description);
    }

    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m229is(Matcher<T> matcher2) {
        return new C2436Is(matcher2);
    }

    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m228is(T t) {
        return m229is(IsEqual.equalTo(t));
    }

    @Deprecated
    @Factory
    /* renamed from: is */
    public static <T> Matcher<T> m227is(Class<T> cls) {
        return m229is(IsInstanceOf.instanceOf(cls));
    }

    @Factory
    public static <T> Matcher<T> isA(Class<T> cls) {
        return m229is(IsInstanceOf.instanceOf(cls));
    }
}
