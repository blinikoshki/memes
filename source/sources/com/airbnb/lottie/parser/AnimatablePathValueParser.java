package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r4 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.animatable.AnimatableValue<android.graphics.PointF, android.graphics.PointF> parseSplitPath(android.util.JsonReader r9, com.airbnb.lottie.LottieComposition r10) throws java.io.IOException {
        /*
            r9.beginObject()
            r0 = 0
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = 0
        L_0x0008:
            android.util.JsonToken r5 = r9.peek()
            android.util.JsonToken r6 = android.util.JsonToken.END_OBJECT
            if (r5 == r6) goto L_0x0072
            java.lang.String r5 = r9.nextName()
            r5.hashCode()
            r6 = -1
            int r7 = r5.hashCode()
            r8 = 1
            switch(r7) {
                case 107: goto L_0x0039;
                case 120: goto L_0x002d;
                case 121: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0043
        L_0x0021:
            java.lang.String r7 = "y"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x002b
            goto L_0x0043
        L_0x002b:
            r6 = 2
            goto L_0x0043
        L_0x002d:
            java.lang.String r7 = "x"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0037
            goto L_0x0043
        L_0x0037:
            r6 = 1
            goto L_0x0043
        L_0x0039:
            java.lang.String r7 = "k"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            switch(r6) {
                case 0: goto L_0x006d;
                case 1: goto L_0x005b;
                case 2: goto L_0x004a;
                default: goto L_0x0046;
            }
        L_0x0046:
            r9.skipValue()
            goto L_0x0008
        L_0x004a:
            android.util.JsonToken r5 = r9.peek()
            android.util.JsonToken r6 = android.util.JsonToken.STRING
            if (r5 != r6) goto L_0x0056
            r9.skipValue()
            goto L_0x0066
        L_0x0056:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r3 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r9, r10)
            goto L_0x0008
        L_0x005b:
            android.util.JsonToken r5 = r9.peek()
            android.util.JsonToken r6 = android.util.JsonToken.STRING
            if (r5 != r6) goto L_0x0068
            r9.skipValue()
        L_0x0066:
            r4 = 1
            goto L_0x0008
        L_0x0068:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r2 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r9, r10)
            goto L_0x0008
        L_0x006d:
            com.airbnb.lottie.model.animatable.AnimatablePathValue r1 = parse(r9, r10)
            goto L_0x0008
        L_0x0072:
            r9.endObject()
            if (r4 == 0) goto L_0x007c
            java.lang.String r9 = "Lottie doesn't support expressions."
            r10.addWarning(r9)
        L_0x007c:
            if (r1 == 0) goto L_0x007f
            return r1
        L_0x007f:
            com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue r9 = new com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue
            r9.<init>(r2, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatablePathValueParser.parseSplitPath(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.animatable.AnimatableValue");
    }
}
