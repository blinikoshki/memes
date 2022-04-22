package kotlin.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"kotlin/test/AssertionsKt__AssertionsImplKt", "kotlin/test/AssertionsKt__AssertionsKt"}, mo26108k = 4, mo26109mv = {1, 4, 1})
public final class AssertionsKt {
    public static final AssertionError AssertionErrorWithCause(String str, Throwable th) {
        return AssertionsKt__AssertionsImplKt.AssertionErrorWithCause(str, th);
    }

    public static final <T> void assertEquals(T t, T t2, String str) {
        AssertionsKt__AssertionsKt.assertEquals(t, t2, str);
    }

    public static final void assertFalse(String str, Function0<Boolean> function0) {
        AssertionsKt__AssertionsKt.assertFalse(str, function0);
    }

    public static final void assertFalse(boolean z, String str) {
        AssertionsKt__AssertionsKt.assertFalse(z, str);
    }

    public static final <T> void assertNotEquals(T t, T t2, String str) {
        AssertionsKt__AssertionsKt.assertNotEquals(t, t2, str);
    }

    public static final <T> T assertNotNull(T t, String str) {
        return AssertionsKt__AssertionsKt.assertNotNull(t, str);
    }

    public static final <T, R> void assertNotNull(T t, String str, Function1<? super T, ? extends R> function1) {
        AssertionsKt__AssertionsKt.assertNotNull(t, str, function1);
    }

    public static final <T> void assertNotSame(T t, T t2, String str) {
        AssertionsKt__AssertionsKt.assertNotSame(t, t2, str);
    }

    public static final void assertNull(Object obj, String str) {
        AssertionsKt__AssertionsKt.assertNull(obj, str);
    }

    public static final <T> void assertSame(T t, T t2, String str) {
        AssertionsKt__AssertionsKt.assertSame(t, t2, str);
    }

    public static final void assertTrue(String str, Function0<Boolean> function0) {
        AssertionsKt__AssertionsKt.assertTrue(str, function0);
    }

    public static final void assertTrue(boolean z, String str) {
        AssertionsKt__AssertionsKt.assertTrue(z, str);
    }

    public static final Throwable checkResultIsFailure(String str, Object obj) {
        return AssertionsKt__AssertionsKt.checkResultIsFailure(str, obj);
    }

    public static final <T extends Throwable> T checkResultIsFailure(KClass<T> kClass, String str, Object obj) {
        return AssertionsKt__AssertionsImplKt.checkResultIsFailure(kClass, str, obj);
    }

    public static final <T> void expect(T t, String str, Function0<? extends T> function0) {
        AssertionsKt__AssertionsKt.expect(t, str, function0);
    }

    public static final <T> void expect(T t, Function0<? extends T> function0) {
        AssertionsKt__AssertionsKt.expect(t, function0);
    }

    public static final Void fail(String str) {
        return AssertionsKt__AssertionsKt.fail(str);
    }

    public static final Void fail(String str, Throwable th) {
        return AssertionsKt__AssertionsKt.fail(str, th);
    }

    public static final Asserter getAsserter() {
        return AssertionsKt__AssertionsKt.getAsserter();
    }

    public static final Asserter get_asserter() {
        return AssertionsKt__AssertionsKt.get_asserter();
    }

    public static final void set_asserter(Asserter asserter) {
        AssertionsKt__AssertionsKt.set_asserter(asserter);
    }
}
