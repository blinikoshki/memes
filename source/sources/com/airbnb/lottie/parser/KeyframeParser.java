package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }

    static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.view.animation.Interpolator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.value.Keyframe<T> parseKeyframe(com.airbnb.lottie.LottieComposition r16, android.util.JsonReader r17, float r18, com.airbnb.lottie.parser.ValueParser<T> r19) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r17.beginObject()
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r7
            r9 = r8
            r13 = r9
            r14 = r13
            r5 = 0
            r11 = 0
        L_0x0013:
            boolean r10 = r17.hasNext()
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = r17.nextName()
            r10.hashCode()
            r12 = -1
            int r15 = r10.hashCode()
            r3 = 1
            switch(r15) {
                case 101: goto L_0x007b;
                case 104: goto L_0x0070;
                case 105: goto L_0x0065;
                case 111: goto L_0x005a;
                case 115: goto L_0x004f;
                case 116: goto L_0x0043;
                case 3701: goto L_0x0037;
                case 3707: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0085
        L_0x002b:
            java.lang.String r15 = "to"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0035
            goto L_0x0085
        L_0x0035:
            r12 = 7
            goto L_0x0085
        L_0x0037:
            java.lang.String r15 = "ti"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0041
            goto L_0x0085
        L_0x0041:
            r12 = 6
            goto L_0x0085
        L_0x0043:
            java.lang.String r15 = "t"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x004d
            goto L_0x0085
        L_0x004d:
            r12 = 5
            goto L_0x0085
        L_0x004f:
            java.lang.String r15 = "s"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0058
            goto L_0x0085
        L_0x0058:
            r12 = 4
            goto L_0x0085
        L_0x005a:
            java.lang.String r15 = "o"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0063
            goto L_0x0085
        L_0x0063:
            r12 = 3
            goto L_0x0085
        L_0x0065:
            java.lang.String r15 = "i"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x006e
            goto L_0x0085
        L_0x006e:
            r12 = 2
            goto L_0x0085
        L_0x0070:
            java.lang.String r15 = "h"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0079
            goto L_0x0085
        L_0x0079:
            r12 = 1
            goto L_0x0085
        L_0x007b:
            java.lang.String r15 = "e"
            boolean r10 = r10.equals(r15)
            if (r10 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r12 = 0
        L_0x0085:
            switch(r12) {
                case 0: goto L_0x00bd;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00ab;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009f;
                case 5: goto L_0x0097;
                case 6: goto L_0x0091;
                case 7: goto L_0x008c;
                default: goto L_0x0088;
            }
        L_0x0088:
            r17.skipValue()
            goto L_0x0013
        L_0x008c:
            android.graphics.PointF r13 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r17, r18)
            goto L_0x0013
        L_0x0091:
            android.graphics.PointF r14 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r17, r18)
            goto L_0x0013
        L_0x0097:
            double r10 = r17.nextDouble()
            float r3 = (float) r10
            r11 = r3
            goto L_0x0013
        L_0x009f:
            java.lang.Object r8 = r2.parse(r0, r1)
            goto L_0x0013
        L_0x00a5:
            android.graphics.PointF r6 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r17, r18)
            goto L_0x0013
        L_0x00ab:
            android.graphics.PointF r7 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r17, r18)
            goto L_0x0013
        L_0x00b1:
            int r5 = r17.nextInt()
            if (r5 != r3) goto L_0x00ba
            r5 = 1
            goto L_0x0013
        L_0x00ba:
            r5 = 0
            goto L_0x0013
        L_0x00bd:
            java.lang.Object r9 = r2.parse(r0, r1)
            goto L_0x0013
        L_0x00c3:
            r17.endObject()
            if (r5 == 0) goto L_0x00cd
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r10 = r0
            r9 = r8
            goto L_0x0130
        L_0x00cd:
            if (r6 == 0) goto L_0x012d
            if (r7 == 0) goto L_0x012d
            float r0 = r6.x
            float r2 = -r1
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r2, (float) r1)
            r6.x = r0
            float r0 = r6.y
            r3 = -1027080192(0xffffffffc2c80000, float:-100.0)
            r5 = 1120403456(0x42c80000, float:100.0)
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r3, (float) r5)
            r6.y = r0
            float r0 = r7.x
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r2, (float) r1)
            r7.x = r0
            float r0 = r7.y
            float r0 = com.airbnb.lottie.utils.MiscUtils.clamp((float) r0, (float) r3, (float) r5)
            r7.y = r0
            float r0 = r6.x
            float r2 = r6.y
            float r3 = r7.x
            float r5 = r7.y
            int r0 = com.airbnb.lottie.utils.Utils.hashFor(r0, r2, r3, r5)
            java.lang.ref.WeakReference r2 = getInterpolator(r0)
            if (r2 == 0) goto L_0x010f
            java.lang.Object r3 = r2.get()
            r4 = r3
            android.view.animation.Interpolator r4 = (android.view.animation.Interpolator) r4
        L_0x010f:
            if (r2 == 0) goto L_0x0113
            if (r4 != 0) goto L_0x012b
        L_0x0113:
            float r2 = r6.x
            float r2 = r2 / r1
            float r3 = r6.y
            float r3 = r3 / r1
            float r4 = r7.x
            float r4 = r4 / r1
            float r5 = r7.y
            float r5 = r5 / r1
            android.view.animation.Interpolator r4 = androidx.core.view.animation.PathInterpolatorCompat.create(r2, r3, r4, r5)
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x012b }
            r1.<init>(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x012b }
            putInterpolator(r0, r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x012b }
        L_0x012b:
            r10 = r4
            goto L_0x0130
        L_0x012d:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r10 = r0
        L_0x0130:
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r12 = 0
            r6 = r0
            r7 = r16
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0.pathCp1 = r13
            r0.pathCp2 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parseKeyframe(com.airbnb.lottie.LottieComposition, android.util.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
