package com.airbnb.lottie.parser;

class ContentModelParser {
    private ContentModelParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c6, code lost:
        if (r2.equals("gf") == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel parse(android.util.JsonReader r6, com.airbnb.lottie.LottieComposition r7) throws java.io.IOException {
        /*
            r6.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r6.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = r6.nextName()
            r2.hashCode()
            java.lang.String r4 = "d"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x002d
            java.lang.String r4 = "ty"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0028
            r6.skipValue()
            goto L_0x0005
        L_0x0028:
            java.lang.String r2 = r6.nextString()
            goto L_0x0033
        L_0x002d:
            int r1 = r6.nextInt()
            goto L_0x0005
        L_0x0032:
            r2 = r3
        L_0x0033:
            if (r2 != 0) goto L_0x0036
            return r3
        L_0x0036:
            r2.hashCode()
            r4 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case 3239: goto L_0x00d6;
                case 3270: goto L_0x00ca;
                case 3295: goto L_0x00c0;
                case 3307: goto L_0x00b5;
                case 3308: goto L_0x00aa;
                case 3488: goto L_0x009f;
                case 3633: goto L_0x0094;
                case 3646: goto L_0x0089;
                case 3669: goto L_0x007c;
                case 3679: goto L_0x006e;
                case 3681: goto L_0x0060;
                case 3705: goto L_0x0052;
                case 3710: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            r0 = -1
            goto L_0x00e1
        L_0x0044:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x0041
        L_0x004e:
            r0 = 12
            goto L_0x00e1
        L_0x0052:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0041
        L_0x005c:
            r0 = 11
            goto L_0x00e1
        L_0x0060:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x006a
            goto L_0x0041
        L_0x006a:
            r0 = 10
            goto L_0x00e1
        L_0x006e:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0078
            goto L_0x0041
        L_0x0078:
            r0 = 9
            goto L_0x00e1
        L_0x007c:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0086
            goto L_0x0041
        L_0x0086:
            r0 = 8
            goto L_0x00e1
        L_0x0089:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0092
            goto L_0x0041
        L_0x0092:
            r0 = 7
            goto L_0x00e1
        L_0x0094:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x009d
            goto L_0x0041
        L_0x009d:
            r0 = 6
            goto L_0x00e1
        L_0x009f:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00a8
            goto L_0x0041
        L_0x00a8:
            r0 = 5
            goto L_0x00e1
        L_0x00aa:
            java.lang.String r0 = "gs"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0041
        L_0x00b3:
            r0 = 4
            goto L_0x00e1
        L_0x00b5:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00be
            goto L_0x0041
        L_0x00be:
            r0 = 3
            goto L_0x00e1
        L_0x00c0:
            java.lang.String r5 = "gf"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00e1
            goto L_0x0041
        L_0x00ca:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00d4
            goto L_0x0041
        L_0x00d4:
            r0 = 1
            goto L_0x00e1
        L_0x00d6:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00e0
            goto L_0x0041
        L_0x00e0:
            r0 = 0
        L_0x00e1:
            switch(r0) {
                case 0: goto L_0x013c;
                case 1: goto L_0x0137;
                case 2: goto L_0x0132;
                case 3: goto L_0x012d;
                case 4: goto L_0x0128;
                case 5: goto L_0x011e;
                case 6: goto L_0x0119;
                case 7: goto L_0x0114;
                case 8: goto L_0x010f;
                case 9: goto L_0x010a;
                case 10: goto L_0x0105;
                case 11: goto L_0x0100;
                case 12: goto L_0x00fb;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown shape type "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "LOTTIE"
            android.util.Log.w(r0, r7)
            goto L_0x0140
        L_0x00fb:
            com.airbnb.lottie.model.animatable.AnimatableTransform r3 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r6, r7)
            goto L_0x0140
        L_0x0100:
            com.airbnb.lottie.model.content.ShapeTrimPath r3 = com.airbnb.lottie.parser.ShapeTrimPathParser.parse(r6, r7)
            goto L_0x0140
        L_0x0105:
            com.airbnb.lottie.model.content.ShapeStroke r3 = com.airbnb.lottie.parser.ShapeStrokeParser.parse(r6, r7)
            goto L_0x0140
        L_0x010a:
            com.airbnb.lottie.model.content.PolystarShape r3 = com.airbnb.lottie.parser.PolystarShapeParser.parse(r6, r7)
            goto L_0x0140
        L_0x010f:
            com.airbnb.lottie.model.content.ShapePath r3 = com.airbnb.lottie.parser.ShapePathParser.parse(r6, r7)
            goto L_0x0140
        L_0x0114:
            com.airbnb.lottie.model.content.Repeater r3 = com.airbnb.lottie.parser.RepeaterParser.parse(r6, r7)
            goto L_0x0140
        L_0x0119:
            com.airbnb.lottie.model.content.RectangleShape r3 = com.airbnb.lottie.parser.RectangleShapeParser.parse(r6, r7)
            goto L_0x0140
        L_0x011e:
            com.airbnb.lottie.model.content.MergePaths r3 = com.airbnb.lottie.parser.MergePathsParser.parse(r6)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r7.addWarning(r0)
            goto L_0x0140
        L_0x0128:
            com.airbnb.lottie.model.content.GradientStroke r3 = com.airbnb.lottie.parser.GradientStrokeParser.parse(r6, r7)
            goto L_0x0140
        L_0x012d:
            com.airbnb.lottie.model.content.ShapeGroup r3 = com.airbnb.lottie.parser.ShapeGroupParser.parse(r6, r7)
            goto L_0x0140
        L_0x0132:
            com.airbnb.lottie.model.content.GradientFill r3 = com.airbnb.lottie.parser.GradientFillParser.parse(r6, r7)
            goto L_0x0140
        L_0x0137:
            com.airbnb.lottie.model.content.ShapeFill r3 = com.airbnb.lottie.parser.ShapeFillParser.parse(r6, r7)
            goto L_0x0140
        L_0x013c:
            com.airbnb.lottie.model.content.CircleShape r3 = com.airbnb.lottie.parser.CircleShapeParser.parse(r6, r7, r1)
        L_0x0140:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x014a
            r6.skipValue()
            goto L_0x0140
        L_0x014a:
            r6.endObject()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ContentModelParser.parse(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
