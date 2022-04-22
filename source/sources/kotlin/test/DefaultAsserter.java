package kotlin.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.test.Asserter;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017¨\u0006\t"}, mo26107d2 = {"Lkotlin/test/DefaultAsserter;", "Lkotlin/test/Asserter;", "()V", "fail", "", "message", "", "cause", "", "kotlin-test"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: DefaultAsserter.kt */
public final class DefaultAsserter implements Asserter {
    public static final DefaultAsserter INSTANCE = new DefaultAsserter();

    private DefaultAsserter() {
    }

    public void assertEquals(String str, Object obj, Object obj2) {
        Asserter.DefaultImpls.assertEquals(this, str, obj, obj2);
    }

    public void assertNotEquals(String str, Object obj, Object obj2) {
        Asserter.DefaultImpls.assertNotEquals(this, str, obj, obj2);
    }

    public void assertNotNull(String str, Object obj) {
        Asserter.DefaultImpls.assertNotNull(this, str, obj);
    }

    public void assertNotSame(String str, Object obj, Object obj2) {
        Asserter.DefaultImpls.assertNotSame(this, str, obj, obj2);
    }

    public void assertNull(String str, Object obj) {
        Asserter.DefaultImpls.assertNull(this, str, obj);
    }

    public void assertSame(String str, Object obj, Object obj2) {
        Asserter.DefaultImpls.assertSame(this, str, obj, obj2);
    }

    public void assertTrue(String str, boolean z) {
        Asserter.DefaultImpls.assertTrue((Asserter) this, str, z);
    }

    public void assertTrue(Function0<String> function0, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        Asserter.DefaultImpls.assertTrue((Asserter) this, function0, z);
    }

    public Void fail(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    public Void fail(String str, Throwable th) {
        throw AssertionsKt.AssertionErrorWithCause(str, th);
    }
}
