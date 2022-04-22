package kotlin.reflect.jvm.internal.calls;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"equals", "", "T", "", "other", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$2 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ List $methods;
    final /* synthetic */ Map $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotationConstructorCallerKt$createAnnotationInstance$2(Class cls, List list, Map map) {
        super(1);
        this.$annotationClass = cls;
        this.$methods = list;
        this.$values = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.lang.annotation.Annotation
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r7
        L_0x0008:
            java.lang.annotation.Annotation r0 = (java.lang.annotation.Annotation) r0
            if (r0 == 0) goto L_0x0016
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getAnnotationClass(r0)
            if (r0 == 0) goto L_0x0016
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r0)
        L_0x0016:
            java.lang.Class r0 = r6.$annotationClass
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0103
            java.util.List r0 = r6.$methods
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0034
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0034
        L_0x0031:
            r7 = 1
            goto L_0x0100
        L_0x0034:
            java.util.Iterator r0 = r0.iterator()
        L_0x0038:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0031
            java.lang.Object r3 = r0.next()
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            java.util.Map r4 = r6.$values
            java.lang.String r5 = r3.getName()
            java.lang.Object r4 = r4.get(r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Object r3 = r3.invoke(r7, r5)
            boolean r5 = r4 instanceof boolean[]
            if (r5 == 0) goto L_0x0067
            boolean[] r4 = (boolean[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.BooleanArray"
            java.util.Objects.requireNonNull(r3, r5)
            boolean[] r3 = (boolean[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x0067:
            boolean r5 = r4 instanceof char[]
            if (r5 == 0) goto L_0x007a
            char[] r4 = (char[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.CharArray"
            java.util.Objects.requireNonNull(r3, r5)
            char[] r3 = (char[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x007a:
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x008d
            byte[] r4 = (byte[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.ByteArray"
            java.util.Objects.requireNonNull(r3, r5)
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x008d:
            boolean r5 = r4 instanceof short[]
            if (r5 == 0) goto L_0x009f
            short[] r4 = (short[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.ShortArray"
            java.util.Objects.requireNonNull(r3, r5)
            short[] r3 = (short[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x009f:
            boolean r5 = r4 instanceof int[]
            if (r5 == 0) goto L_0x00b1
            int[] r4 = (int[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.IntArray"
            java.util.Objects.requireNonNull(r3, r5)
            int[] r3 = (int[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x00b1:
            boolean r5 = r4 instanceof float[]
            if (r5 == 0) goto L_0x00c3
            float[] r4 = (float[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.FloatArray"
            java.util.Objects.requireNonNull(r3, r5)
            float[] r3 = (float[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x00c3:
            boolean r5 = r4 instanceof long[]
            if (r5 == 0) goto L_0x00d5
            long[] r4 = (long[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.LongArray"
            java.util.Objects.requireNonNull(r3, r5)
            long[] r3 = (long[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x00d5:
            boolean r5 = r4 instanceof double[]
            if (r5 == 0) goto L_0x00e7
            double[] r4 = (double[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.DoubleArray"
            java.util.Objects.requireNonNull(r3, r5)
            double[] r3 = (double[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x00e7:
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L_0x00f9
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<*>"
            java.util.Objects.requireNonNull(r3, r5)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x00fd
        L_0x00f9:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
        L_0x00fd:
            if (r3 != 0) goto L_0x0038
            r7 = 0
        L_0x0100:
            if (r7 == 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r1 = 0
        L_0x0104:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$2.invoke(java.lang.Object):boolean");
    }
}
