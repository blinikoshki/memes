package kotlin.test;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J&\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J&\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016J \u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H'¨\u0006\u0016"}, mo26107d2 = {"Lkotlin/test/Asserter;", "", "assertEquals", "", "message", "", "expected", "actual", "assertNotEquals", "illegal", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "lazyMessage", "Lkotlin/Function0;", "", "fail", "", "cause", "", "kotlin-test"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Assertions.kt */
public interface Asserter {
    void assertEquals(String str, Object obj, Object obj2);

    void assertNotEquals(String str, Object obj, Object obj2);

    void assertNotNull(String str, Object obj);

    void assertNotSame(String str, Object obj, Object obj2);

    void assertNull(String str, Object obj);

    void assertSame(String str, Object obj, Object obj2);

    void assertTrue(String str, boolean z);

    void assertTrue(Function0<String> function0, boolean z);

    Void fail(String str);

    Void fail(String str, Throwable th);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* compiled from: Assertions.kt */
    public static final class DefaultImpls {
        public static void assertTrue(Asserter asserter, Function0<String> function0, boolean z) {
            Intrinsics.checkNotNullParameter(function0, "lazyMessage");
            if (!z) {
                asserter.fail(function0.invoke());
                throw new KotlinNothingValueException();
            }
        }

        public static void assertTrue(Asserter asserter, String str, boolean z) {
            asserter.assertTrue((Function0<String>) new Asserter$assertTrue$1(str), z);
        }

        public static void assertEquals(Asserter asserter, String str, Object obj, Object obj2) {
            asserter.assertTrue((Function0<String>) new Asserter$assertEquals$1(str, obj, obj2), Intrinsics.areEqual(obj2, obj));
        }

        public static void assertNotEquals(Asserter asserter, String str, Object obj, Object obj2) {
            asserter.assertTrue((Function0<String>) new Asserter$assertNotEquals$1(str, obj2), !Intrinsics.areEqual(obj2, obj));
        }

        public static void assertSame(Asserter asserter, String str, Object obj, Object obj2) {
            asserter.assertTrue((Function0<String>) new Asserter$assertSame$1(str, obj, obj2), obj2 == obj);
        }

        public static void assertNotSame(Asserter asserter, String str, Object obj, Object obj2) {
            asserter.assertTrue((Function0<String>) new Asserter$assertNotSame$1(str, obj2), obj2 != obj);
        }

        public static void assertNull(Asserter asserter, String str, Object obj) {
            asserter.assertTrue((Function0<String>) new Asserter$assertNull$1(str, obj), obj == null);
        }

        public static void assertNotNull(Asserter asserter, String str, Object obj) {
            asserter.assertTrue((Function0<String>) new Asserter$assertNotNull$1(str), obj != null);
        }
    }
}
