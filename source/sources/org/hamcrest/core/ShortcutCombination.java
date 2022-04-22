package org.hamcrest.core;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

abstract class ShortcutCombination<T> extends BaseMatcher<T> {
    private final Iterable<Matcher<? super T>> matchers;

    public abstract void describeTo(Description description);

    public abstract boolean matches(Object obj);

    public ShortcutCombination(Iterable<Matcher<? super T>> iterable) {
        this.matchers = iterable;
    }

    /* access modifiers changed from: protected */
    public boolean matches(Object obj, boolean z) {
        for (Matcher<? super T> matches : this.matchers) {
            if (matches.matches(obj) == z) {
                return z;
            }
        }
        return !z;
    }

    public void describeTo(Description description, String str) {
        description.appendList("(", StringUtils.SPACE + str + StringUtils.SPACE, ")", this.matchers);
    }
}
