package com.airbnb.lottie.parser;

class GradientFillParser {
    private GradientFillParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.GradientFill parse(android.util.JsonReader r11, com.airbnb.lottie.LottieComposition r12) throws java.io.IOException {
        /*
            r0 = 0
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0008:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = r11.nextName()
            r0.hashCode()
            int r1 = r0.hashCode()
            r9 = -1
            r10 = 1
            switch(r1) {
                case 101: goto L_0x0063;
                case 103: goto L_0x0058;
                case 111: goto L_0x004d;
                case 114: goto L_0x0042;
                case 115: goto L_0x0037;
                case 116: goto L_0x002b;
                case 3519: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r0 = -1
            goto L_0x006d
        L_0x0020:
            java.lang.String r1 = "nm"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0029
            goto L_0x001e
        L_0x0029:
            r0 = 6
            goto L_0x006d
        L_0x002b:
            java.lang.String r1 = "t"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0035
            goto L_0x001e
        L_0x0035:
            r0 = 5
            goto L_0x006d
        L_0x0037:
            java.lang.String r1 = "s"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0040
            goto L_0x001e
        L_0x0040:
            r0 = 4
            goto L_0x006d
        L_0x0042:
            java.lang.String r1 = "r"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004b
            goto L_0x001e
        L_0x004b:
            r0 = 3
            goto L_0x006d
        L_0x004d:
            java.lang.String r1 = "o"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x001e
        L_0x0056:
            r0 = 2
            goto L_0x006d
        L_0x0058:
            java.lang.String r1 = "g"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0061
            goto L_0x001e
        L_0x0061:
            r0 = 1
            goto L_0x006d
        L_0x0063:
            java.lang.String r1 = "e"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006c
            goto L_0x001e
        L_0x006c:
            r0 = 0
        L_0x006d:
            switch(r0) {
                case 0: goto L_0x00d8;
                case 1: goto L_0x00a3;
                case 2: goto L_0x009c;
                case 3: goto L_0x008e;
                case 4: goto L_0x0087;
                case 5: goto L_0x007a;
                case 6: goto L_0x0074;
                default: goto L_0x0070;
            }
        L_0x0070:
            r11.skipValue()
            goto L_0x0008
        L_0x0074:
            java.lang.String r0 = r11.nextString()
            r2 = r0
            goto L_0x0008
        L_0x007a:
            int r0 = r11.nextInt()
            if (r0 != r10) goto L_0x0083
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Linear
            goto L_0x0085
        L_0x0083:
            com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Radial
        L_0x0085:
            r3 = r0
            goto L_0x0008
        L_0x0087:
            com.airbnb.lottie.model.animatable.AnimatablePointValue r0 = com.airbnb.lottie.parser.AnimatableValueParser.parsePoint(r11, r12)
            r7 = r0
            goto L_0x0008
        L_0x008e:
            int r0 = r11.nextInt()
            if (r0 != r10) goto L_0x0097
            android.graphics.Path$FillType r0 = android.graphics.Path.FillType.WINDING
            goto L_0x0099
        L_0x0097:
            android.graphics.Path$FillType r0 = android.graphics.Path.FillType.EVEN_ODD
        L_0x0099:
            r4 = r0
            goto L_0x0008
        L_0x009c:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r0 = com.airbnb.lottie.parser.AnimatableValueParser.parseInteger(r11, r12)
            r6 = r0
            goto L_0x0008
        L_0x00a3:
            r11.beginObject()
        L_0x00a6:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = r11.nextName()
            r0.hashCode()
            java.lang.String r1 = "k"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x00cd
            java.lang.String r1 = "p"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c7
            r11.skipValue()
            goto L_0x00a6
        L_0x00c7:
            int r0 = r11.nextInt()
            r9 = r0
            goto L_0x00a6
        L_0x00cd:
            com.airbnb.lottie.model.animatable.AnimatableGradientColorValue r0 = com.airbnb.lottie.parser.AnimatableValueParser.parseGradientColor(r11, r12, r9)
            r5 = r0
            goto L_0x00a6
        L_0x00d3:
            r11.endObject()
            goto L_0x0008
        L_0x00d8:
            com.airbnb.lottie.model.animatable.AnimatablePointValue r0 = com.airbnb.lottie.parser.AnimatableValueParser.parsePoint(r11, r12)
            r8 = r0
            goto L_0x0008
        L_0x00df:
            com.airbnb.lottie.model.content.GradientFill r11 = new com.airbnb.lottie.model.content.GradientFill
            r9 = 0
            r10 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.GradientFillParser.parse(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.GradientFill");
    }
}
