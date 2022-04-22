package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

public class Assume {
    public static void assumeTrue(boolean z) {
        assumeThat(Boolean.valueOf(z), CoreMatchers.m223is(true));
    }

    public static void assumeFalse(boolean z) {
        assumeTrue(!z);
    }

    public static void assumeTrue(String str, boolean z) {
        if (!z) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static void assumeFalse(String str, boolean z) {
        assumeTrue(str, !z);
    }

    public static void assumeNotNull(Object... objArr) {
        assumeThat(Arrays.asList(objArr), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
    }

    public static <T> void assumeThat(T t, Matcher<T> matcher) {
        if (!matcher.matches(t)) {
            throw new AssumptionViolatedException(t, matcher);
        }
    }

    public static <T> void assumeThat(String str, T t, Matcher<T> matcher) {
        if (!matcher.matches(t)) {
            throw new AssumptionViolatedException(str, t, matcher);
        }
    }

    public static void assumeNoException(Throwable th) {
        assumeThat(th, CoreMatchers.nullValue());
    }

    public static void assumeNoException(String str, Throwable th) {
        assumeThat(str, th, CoreMatchers.nullValue());
    }
}
