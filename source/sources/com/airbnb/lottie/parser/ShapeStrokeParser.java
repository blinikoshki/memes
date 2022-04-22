package com.airbnb.lottie.parser;

class ShapeStrokeParser {
    private ShapeStrokeParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ShapeStroke parse(android.util.JsonReader r17, com.airbnb.lottie.LottieComposition r18) throws java.io.IOException {
        /*
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1 = 0
            r1 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x000e:
            boolean r10 = r17.hasNext()
            if (r10 == 0) goto L_0x013d
            java.lang.String r10 = r17.nextName()
            r10.hashCode()
            int r11 = r10.hashCode()
            java.lang.String r13 = "o"
            java.lang.String r14 = "d"
            r12 = 1
            switch(r11) {
                case 99: goto L_0x0073;
                case 100: goto L_0x006a;
                case 111: goto L_0x0061;
                case 119: goto L_0x0055;
                case 3447: goto L_0x004a;
                case 3454: goto L_0x003f;
                case 3487: goto L_0x0034;
                case 3519: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            r10 = -1
            goto L_0x007d
        L_0x0029:
            java.lang.String r11 = "nm"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            r10 = 7
            goto L_0x007d
        L_0x0034:
            java.lang.String r11 = "ml"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x003d
            goto L_0x0027
        L_0x003d:
            r10 = 6
            goto L_0x007d
        L_0x003f:
            java.lang.String r11 = "lj"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0048
            goto L_0x0027
        L_0x0048:
            r10 = 5
            goto L_0x007d
        L_0x004a:
            java.lang.String r11 = "lc"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0053
            goto L_0x0027
        L_0x0053:
            r10 = 4
            goto L_0x007d
        L_0x0055:
            java.lang.String r11 = "w"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x005f
            goto L_0x0027
        L_0x005f:
            r10 = 3
            goto L_0x007d
        L_0x0061:
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x0068
            goto L_0x0027
        L_0x0068:
            r10 = 2
            goto L_0x007d
        L_0x006a:
            boolean r10 = r10.equals(r14)
            if (r10 != 0) goto L_0x0071
            goto L_0x0027
        L_0x0071:
            r10 = 1
            goto L_0x007d
        L_0x0073:
            java.lang.String r11 = "c"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x007c
            goto L_0x0027
        L_0x007c:
            r10 = 0
        L_0x007d:
            switch(r10) {
                case 0: goto L_0x0137;
                case 1: goto L_0x00b5;
                case 2: goto L_0x00af;
                case 3: goto L_0x00a9;
                case 4: goto L_0x009c;
                case 5: goto L_0x008f;
                case 6: goto L_0x0089;
                case 7: goto L_0x0084;
                default: goto L_0x0080;
            }
        L_0x0080:
            r17.skipValue()
            goto L_0x000e
        L_0x0084:
            java.lang.String r1 = r17.nextString()
            goto L_0x000e
        L_0x0089:
            double r9 = r17.nextDouble()
            float r9 = (float) r9
            goto L_0x000e
        L_0x008f:
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r8 = r17.nextInt()
            int r8 = r8 - r12
            r8 = r0[r8]
            goto L_0x000e
        L_0x009c:
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r7 = r17.nextInt()
            int r7 = r7 - r12
            r7 = r0[r7]
            goto L_0x000e
        L_0x00a9:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r6 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r17, r18)
            goto L_0x000e
        L_0x00af:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r5 = com.airbnb.lottie.parser.AnimatableValueParser.parseInteger(r17, r18)
            goto L_0x000e
        L_0x00b5:
            r17.beginArray()
        L_0x00b8:
            boolean r10 = r17.hasNext()
            if (r10 == 0) goto L_0x0124
            r17.beginObject()
            r10 = 0
            r11 = 0
        L_0x00c3:
            boolean r16 = r17.hasNext()
            if (r16 == 0) goto L_0x00ef
            java.lang.String r15 = r17.nextName()
            r15.hashCode()
            java.lang.String r0 = "n"
            boolean r0 = r15.equals(r0)
            if (r0 != 0) goto L_0x00ea
            java.lang.String r0 = "v"
            boolean r0 = r15.equals(r0)
            if (r0 != 0) goto L_0x00e5
            r17.skipValue()
            goto L_0x00c3
        L_0x00e5:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r11 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r17, r18)
            goto L_0x00c3
        L_0x00ea:
            java.lang.String r10 = r17.nextString()
            goto L_0x00c3
        L_0x00ef:
            r17.endObject()
            r10.hashCode()
            int r0 = r10.hashCode()
            switch(r0) {
                case 100: goto L_0x0112;
                case 103: goto L_0x0107;
                case 111: goto L_0x00fe;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            r0 = -1
            goto L_0x011a
        L_0x00fe:
            boolean r0 = r10.equals(r13)
            if (r0 != 0) goto L_0x0105
            goto L_0x00fc
        L_0x0105:
            r0 = 2
            goto L_0x011a
        L_0x0107:
            java.lang.String r0 = "g"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0110
            goto L_0x00fc
        L_0x0110:
            r0 = 1
            goto L_0x011a
        L_0x0112:
            boolean r0 = r10.equals(r14)
            if (r0 != 0) goto L_0x0119
            goto L_0x00fc
        L_0x0119:
            r0 = 0
        L_0x011a:
            switch(r0) {
                case 0: goto L_0x0120;
                case 1: goto L_0x0120;
                case 2: goto L_0x011e;
                default: goto L_0x011d;
            }
        L_0x011d:
            goto L_0x00b8
        L_0x011e:
            r2 = r11
            goto L_0x00b8
        L_0x0120:
            r3.add(r11)
            goto L_0x00b8
        L_0x0124:
            r17.endArray()
            int r0 = r3.size()
            if (r0 != r12) goto L_0x000e
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            r3.add(r0)
            goto L_0x000e
        L_0x0137:
            com.airbnb.lottie.model.animatable.AnimatableColorValue r4 = com.airbnb.lottie.parser.AnimatableValueParser.parseColor(r17, r18)
            goto L_0x000e
        L_0x013d:
            com.airbnb.lottie.model.content.ShapeStroke r10 = new com.airbnb.lottie.model.content.ShapeStroke
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ShapeStrokeParser.parse(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
