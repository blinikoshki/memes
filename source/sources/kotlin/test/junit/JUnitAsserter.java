package kotlin.test.junit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.test.Asserter;
import org.junit.Assert;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017¨\u0006\u0014"}, mo26107d2 = {"Lkotlin/test/junit/JUnitAsserter;", "Lkotlin/test/Asserter;", "()V", "assertEquals", "", "message", "", "expected", "", "actual", "assertNotEquals", "illegal", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "fail", "", "cause", "", "kotlin-test-junit"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: JUnitSupport.kt */
public final class JUnitAsserter implements Asserter {
    public static final JUnitAsserter INSTANCE = new JUnitAsserter();

    private JUnitAsserter() {
    }

    public void assertTrue(String str, boolean z) {
        Asserter.DefaultImpls.assertTrue((Asserter) this, str, z);
    }

    public void assertTrue(Function0<String> function0, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        Asserter.DefaultImpls.assertTrue((Asserter) this, function0, z);
    }

    public void assertEquals(String str, Object obj, Object obj2) {
        Assert.assertEquals(str, obj, obj2);
    }

    public void assertNotEquals(String str, Object obj, Object obj2) {
        Assert.assertNotEquals(str, obj, obj2);
    }

    public void assertSame(String str, Object obj, Object obj2) {
        Assert.assertSame(str, obj, obj2);
    }

    public void assertNotSame(String str, Object obj, Object obj2) {
        Assert.assertNotSame(str, obj, obj2);
    }

    public void assertNotNull(String str, Object obj) {
        if (str == null) {
            str = "actual value is null";
        }
        Assert.assertNotNull(str, obj);
    }

    public void assertNull(String str, Object obj) {
        if (str == null) {
            str = "actual value is not null";
        }
        Assert.assertNull(str, obj);
    }

    public Void fail(String str) {
        Assert.fail(str);
        throw new AssertionError(str);
    }

    public Void fail(String str, Throwable th) {
        try {
            Assert.fail(str);
            Throwable initCause = new AssertionError(str).initCause(th);
            Intrinsics.checkNotNullExpressionValue(initCause, "AssertionError(message).initCause(cause)");
            throw initCause;
        } catch (AssertionError e) {
            e.initCause(th);
            throw e;
        }
    }
}
