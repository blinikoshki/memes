package com.airbnb.lottie.parser;

class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.GradientStroke parse(android.util.JsonReader r20, com.airbnb.lottie.LottieComposition r21) throws java.io.IOException {
        /*
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r1 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
        L_0x0011:
            boolean r13 = r20.hasNext()
            if (r13 == 0) goto L_0x01cb
            java.lang.String r13 = r20.nextName()
            r13.hashCode()
            int r14 = r13.hashCode()
            java.lang.String r15 = "o"
            java.lang.String r0 = "g"
            r16 = r12
            java.lang.String r12 = "d"
            r17 = -1
            r18 = r10
            r10 = 1
            switch(r14) {
                case 100: goto L_0x00a6;
                case 101: goto L_0x009b;
                case 103: goto L_0x0092;
                case 111: goto L_0x0089;
                case 115: goto L_0x007e;
                case 116: goto L_0x0072;
                case 119: goto L_0x0066;
                case 3447: goto L_0x005b;
                case 3454: goto L_0x004f;
                case 3487: goto L_0x0042;
                case 3519: goto L_0x0035;
                default: goto L_0x0032;
            }
        L_0x0032:
            r13 = -1
            goto L_0x00ae
        L_0x0035:
            java.lang.String r14 = "nm"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x003e
            goto L_0x0032
        L_0x003e:
            r13 = 10
            goto L_0x00ae
        L_0x0042:
            java.lang.String r14 = "ml"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x004b
            goto L_0x0032
        L_0x004b:
            r13 = 9
            goto L_0x00ae
        L_0x004f:
            java.lang.String r14 = "lj"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0058
            goto L_0x0032
        L_0x0058:
            r13 = 8
            goto L_0x00ae
        L_0x005b:
            java.lang.String r14 = "lc"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0064
            goto L_0x0032
        L_0x0064:
            r13 = 7
            goto L_0x00ae
        L_0x0066:
            java.lang.String r14 = "w"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0070
            goto L_0x0032
        L_0x0070:
            r13 = 6
            goto L_0x00ae
        L_0x0072:
            java.lang.String r14 = "t"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x007c
            goto L_0x0032
        L_0x007c:
            r13 = 5
            goto L_0x00ae
        L_0x007e:
            java.lang.String r14 = "s"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0087
            goto L_0x0032
        L_0x0087:
            r13 = 4
            goto L_0x00ae
        L_0x0089:
            boolean r13 = r13.equals(r15)
            if (r13 != 0) goto L_0x0090
            goto L_0x0032
        L_0x0090:
            r13 = 3
            goto L_0x00ae
        L_0x0092:
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x0099
            goto L_0x0032
        L_0x0099:
            r13 = 2
            goto L_0x00ae
        L_0x009b:
            java.lang.String r14 = "e"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x00a4
            goto L_0x0032
        L_0x00a4:
            r13 = 1
            goto L_0x00ae
        L_0x00a6:
            boolean r13 = r13.equals(r12)
            if (r13 != 0) goto L_0x00ad
            goto L_0x0032
        L_0x00ad:
            r13 = 0
        L_0x00ae:
            switch(r13) {
                case 0: goto L_0x0146;
                case 1: goto L_0x013c;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00e5;
                case 6: goto L_0x00e0;
                case 7: goto L_0x00d4;
                case 8: goto L_0x00c8;
                case 9: goto L_0x00bf;
                case 10: goto L_0x00b5;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            r20.skipValue()
            goto L_0x00b9
        L_0x00b5:
            java.lang.String r1 = r20.nextString()
        L_0x00b9:
            r12 = r16
            r10 = r18
            goto L_0x0011
        L_0x00bf:
            double r12 = r20.nextDouble()
            float r10 = (float) r12
            r12 = r16
            goto L_0x0011
        L_0x00c8:
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r9 = r20.nextInt()
            int r9 = r9 - r10
            r9 = r0[r9]
            goto L_0x00b9
        L_0x00d4:
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r8 = r20.nextInt()
            int r8 = r8 - r10
            r8 = r0[r8]
            goto L_0x00b9
        L_0x00e0:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r7 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r20, r21)
            goto L_0x00b9
        L_0x00e5:
            int r0 = r20.nextInt()
            if (r0 != r10) goto L_0x00ee
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Linear
            goto L_0x00f0
        L_0x00ee:
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Radial
        L_0x00f0:
            r2 = r0
            goto L_0x00b9
        L_0x00f2:
            com.airbnb.lottie.model.animatable.AnimatablePointValue r5 = com.airbnb.lottie.parser.AnimatableValueParser.parsePoint(r20, r21)
            goto L_0x00b9
        L_0x00f7:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r4 = com.airbnb.lottie.parser.AnimatableValueParser.parseInteger(r20, r21)
            goto L_0x00b9
        L_0x00fc:
            r20.beginObject()
            r0 = -1
        L_0x0100:
            boolean r10 = r20.hasNext()
            if (r10 == 0) goto L_0x0133
            java.lang.String r10 = r20.nextName()
            r10.hashCode()
            java.lang.String r12 = "k"
            boolean r12 = r10.equals(r12)
            if (r12 != 0) goto L_0x012a
            java.lang.String r12 = "p"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0121
            r20.skipValue()
            goto L_0x0125
        L_0x0121:
            int r0 = r20.nextInt()
        L_0x0125:
            r13 = r20
            r14 = r21
            goto L_0x0100
        L_0x012a:
            r13 = r20
            r14 = r21
            com.airbnb.lottie.model.animatable.AnimatableGradientColorValue r3 = com.airbnb.lottie.parser.AnimatableValueParser.parseGradientColor(r13, r14, r0)
            goto L_0x0100
        L_0x0133:
            r13 = r20
            r14 = r21
            r20.endObject()
            goto L_0x00b9
        L_0x013c:
            r13 = r20
            r14 = r21
            com.airbnb.lottie.model.animatable.AnimatablePointValue r6 = com.airbnb.lottie.parser.AnimatableValueParser.parsePoint(r20, r21)
            goto L_0x00b9
        L_0x0146:
            r13 = r20
            r14 = r21
            r20.beginArray()
        L_0x014d:
            boolean r17 = r20.hasNext()
            if (r17 == 0) goto L_0x01af
            r20.beginObject()
            r10 = 0
            r13 = 0
        L_0x0158:
            boolean r19 = r20.hasNext()
            if (r19 == 0) goto L_0x018a
            java.lang.String r14 = r20.nextName()
            r14.hashCode()
            r19 = r9
            java.lang.String r9 = "n"
            boolean r9 = r14.equals(r9)
            if (r9 != 0) goto L_0x0181
            java.lang.String r9 = "v"
            boolean r9 = r14.equals(r9)
            if (r9 != 0) goto L_0x017c
            r20.skipValue()
            goto L_0x0185
        L_0x017c:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r13 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r20, r21)
            goto L_0x0185
        L_0x0181:
            java.lang.String r10 = r20.nextString()
        L_0x0185:
            r14 = r21
            r9 = r19
            goto L_0x0158
        L_0x018a:
            r19 = r9
            r20.endObject()
            boolean r9 = r10.equals(r15)
            if (r9 == 0) goto L_0x0198
            r16 = r13
            goto L_0x01a7
        L_0x0198:
            boolean r9 = r10.equals(r12)
            if (r9 != 0) goto L_0x01a4
            boolean r9 = r10.equals(r0)
            if (r9 == 0) goto L_0x01a7
        L_0x01a4:
            r11.add(r13)
        L_0x01a7:
            r13 = r20
            r14 = r21
            r9 = r19
            r10 = 1
            goto L_0x014d
        L_0x01af:
            r19 = r9
            r20.endArray()
            int r0 = r11.size()
            r9 = 1
            if (r0 != r9) goto L_0x01c3
            r0 = 0
            java.lang.Object r0 = r11.get(r0)
            r11.add(r0)
        L_0x01c3:
            r12 = r16
            r10 = r18
            r9 = r19
            goto L_0x0011
        L_0x01cb:
            r19 = r9
            r18 = r10
            r16 = r12
            com.airbnb.lottie.model.content.GradientStroke r13 = new com.airbnb.lottie.model.content.GradientStroke
            r0 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.GradientStrokeParser.parse(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.GradientStroke");
    }
}
