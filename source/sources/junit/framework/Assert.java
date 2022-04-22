package junit.framework;

import org.apache.commons.lang3.StringUtils;

@Deprecated
public class Assert {
    protected Assert() {
    }

    public static void assertTrue(String str, boolean z) {
        if (!z) {
            fail(str);
        }
    }

    public static void assertTrue(boolean z) {
        assertTrue((String) null, z);
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertFalse(boolean z) {
        assertFalse((String) null, z);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionFailedError();
        }
        throw new AssertionFailedError(str);
    }

    public static void fail() {
        fail((String) null);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj != null || obj2 != null) {
            if (obj == null || !obj.equals(obj2)) {
                failNotEquals(str, obj, obj2);
            }
        }
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if (str2 != null || str3 != null) {
            if (str2 == null || !str2.equals(str3)) {
                if (str == null) {
                    str = "";
                }
                throw new ComparisonFailure(str, str2, str3);
            }
        }
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, double d, double d2, double d3) {
        if (Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3) {
            failNotEquals(str, new Double(d), new Double(d2));
        }
    }

    public static void assertEquals(double d, double d2, double d3) {
        assertEquals((String) null, d, d2, d3);
    }

    public static void assertEquals(String str, float f, float f2, float f3) {
        if (Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3) {
            failNotEquals(str, new Float(f), new Float(f2));
        }
    }

    public static void assertEquals(float f, float f2, float f3) {
        assertEquals((String) null, f, f2, f3);
    }

    public static void assertEquals(String str, long j, long j2) {
        assertEquals(str, (Object) Long.valueOf(j), (Object) Long.valueOf(j2));
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        assertEquals(str, (Object) Boolean.valueOf(z), (Object) Boolean.valueOf(z2));
    }

    public static void assertEquals(boolean z, boolean z2) {
        assertEquals((String) null, z, z2);
    }

    public static void assertEquals(String str, byte b, byte b2) {
        assertEquals(str, (Object) Byte.valueOf(b), (Object) Byte.valueOf(b2));
    }

    public static void assertEquals(byte b, byte b2) {
        assertEquals((String) null, b, b2);
    }

    public static void assertEquals(String str, char c, char c2) {
        assertEquals(str, (Object) Character.valueOf(c), (Object) Character.valueOf(c2));
    }

    public static void assertEquals(char c, char c2) {
        assertEquals((String) null, c, c2);
    }

    public static void assertEquals(String str, short s, short s2) {
        assertEquals(str, (Object) Short.valueOf(s), (Object) Short.valueOf(s2));
    }

    public static void assertEquals(short s, short s2) {
        assertEquals((String) null, s, s2);
    }

    public static void assertEquals(String str, int i, int i2) {
        assertEquals(str, (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
    }

    public static void assertEquals(int i, int i2) {
        assertEquals((String) null, i, i2);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull((String) null, obj);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            failNotSame(str, obj, obj2);
        }
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame((String) null, obj, obj2);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame((String) null, obj, obj2);
    }

    public static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + StringUtils.SPACE;
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + StringUtils.SPACE;
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
        } else {
            str2 = str + StringUtils.SPACE;
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }
}
