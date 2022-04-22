package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.ShapeData;

public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();

    private ShapeDataParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r5.equals("i") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.airbnb.lottie.model.content.ShapeData parse(android.util.JsonReader r13, float r14) throws java.io.IOException {
        /*
            r12 = this;
            android.util.JsonToken r0 = r13.peek()
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY
            if (r0 != r1) goto L_0x000b
            r13.beginArray()
        L_0x000b:
            r13.beginObject()
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r2
            r4 = 0
        L_0x0013:
            boolean r5 = r13.hasNext()
            r6 = 1
            if (r5 == 0) goto L_0x006d
            java.lang.String r5 = r13.nextName()
            r5.hashCode()
            r7 = -1
            int r8 = r5.hashCode()
            switch(r8) {
                case 99: goto L_0x004b;
                case 105: goto L_0x0042;
                case 111: goto L_0x0037;
                case 118: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r6 = -1
            goto L_0x0055
        L_0x002b:
            java.lang.String r6 = "v"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0035
            goto L_0x0029
        L_0x0035:
            r6 = 3
            goto L_0x0055
        L_0x0037:
            java.lang.String r6 = "o"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0040
            goto L_0x0029
        L_0x0040:
            r6 = 2
            goto L_0x0055
        L_0x0042:
            java.lang.String r8 = "i"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L_0x0055
            goto L_0x0029
        L_0x004b:
            java.lang.String r6 = "c"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0054
            goto L_0x0029
        L_0x0054:
            r6 = 0
        L_0x0055:
            switch(r6) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0063;
                case 2: goto L_0x005e;
                case 3: goto L_0x0059;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x0013
        L_0x0059:
            java.util.List r0 = com.airbnb.lottie.parser.JsonUtils.jsonToPoints(r13, r14)
            goto L_0x0013
        L_0x005e:
            java.util.List r3 = com.airbnb.lottie.parser.JsonUtils.jsonToPoints(r13, r14)
            goto L_0x0013
        L_0x0063:
            java.util.List r2 = com.airbnb.lottie.parser.JsonUtils.jsonToPoints(r13, r14)
            goto L_0x0013
        L_0x0068:
            boolean r4 = r13.nextBoolean()
            goto L_0x0013
        L_0x006d:
            r13.endObject()
            android.util.JsonToken r14 = r13.peek()
            android.util.JsonToken r5 = android.util.JsonToken.END_ARRAY
            if (r14 != r5) goto L_0x007b
            r13.endArray()
        L_0x007b:
            if (r0 == 0) goto L_0x0106
            if (r2 == 0) goto L_0x0106
            if (r3 == 0) goto L_0x0106
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x0096
            com.airbnb.lottie.model.content.ShapeData r13 = new com.airbnb.lottie.model.content.ShapeData
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>()
            java.util.List r0 = java.util.Collections.emptyList()
            r13.<init>(r14, r1, r0)
            return r13
        L_0x0096:
            int r13 = r0.size()
            java.lang.Object r14 = r0.get(r1)
            android.graphics.PointF r14 = (android.graphics.PointF) r14
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r13)
            r7 = 1
        L_0x00a6:
            if (r7 >= r13) goto L_0x00d5
            java.lang.Object r8 = r0.get(r7)
            android.graphics.PointF r8 = (android.graphics.PointF) r8
            int r9 = r7 + -1
            java.lang.Object r10 = r0.get(r9)
            android.graphics.PointF r10 = (android.graphics.PointF) r10
            java.lang.Object r9 = r3.get(r9)
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            java.lang.Object r11 = r2.get(r7)
            android.graphics.PointF r11 = (android.graphics.PointF) r11
            android.graphics.PointF r9 = com.airbnb.lottie.utils.MiscUtils.addPoints(r10, r9)
            android.graphics.PointF r10 = com.airbnb.lottie.utils.MiscUtils.addPoints(r8, r11)
            com.airbnb.lottie.model.CubicCurveData r11 = new com.airbnb.lottie.model.CubicCurveData
            r11.<init>(r9, r10, r8)
            r5.add(r11)
            int r7 = r7 + 1
            goto L_0x00a6
        L_0x00d5:
            if (r4 == 0) goto L_0x0100
            java.lang.Object r7 = r0.get(r1)
            android.graphics.PointF r7 = (android.graphics.PointF) r7
            int r13 = r13 - r6
            java.lang.Object r0 = r0.get(r13)
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            java.lang.Object r13 = r3.get(r13)
            android.graphics.PointF r13 = (android.graphics.PointF) r13
            java.lang.Object r1 = r2.get(r1)
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.PointF r13 = com.airbnb.lottie.utils.MiscUtils.addPoints(r0, r13)
            android.graphics.PointF r0 = com.airbnb.lottie.utils.MiscUtils.addPoints(r7, r1)
            com.airbnb.lottie.model.CubicCurveData r1 = new com.airbnb.lottie.model.CubicCurveData
            r1.<init>(r13, r0, r7)
            r5.add(r1)
        L_0x0100:
            com.airbnb.lottie.model.content.ShapeData r13 = new com.airbnb.lottie.model.content.ShapeData
            r13.<init>(r14, r4, r5)
            return r13
        L_0x0106:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Shape data was missing information."
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ShapeDataParser.parse(android.util.JsonReader, float):com.airbnb.lottie.model.content.ShapeData");
    }
}
