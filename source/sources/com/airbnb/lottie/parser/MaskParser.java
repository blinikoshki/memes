package com.airbnb.lottie.parser;

class MaskParser {
    private MaskParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r0.equals(editor.ffmpeg.api.FfmpegCommand.SUBTITLE_STREAM) == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.Mask parse(android.util.JsonReader r9, com.airbnb.lottie.LottieComposition r10) throws java.io.IOException {
        /*
            r9.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0006:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x00b4
            java.lang.String r3 = r9.nextName()
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = -1
            switch(r4) {
                case 111: goto L_0x0036;
                case 3588: goto L_0x002b;
                case 3357091: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r4 = -1
            goto L_0x0040
        L_0x0020:
            java.lang.String r4 = "mode"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0029
            goto L_0x001e
        L_0x0029:
            r4 = 2
            goto L_0x0040
        L_0x002b:
            java.lang.String r4 = "pt"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0034
            goto L_0x001e
        L_0x0034:
            r4 = 1
            goto L_0x0040
        L_0x0036:
            java.lang.String r4 = "o"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x003f
            goto L_0x001e
        L_0x003f:
            r4 = 0
        L_0x0040:
            switch(r4) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00a8;
                case 2: goto L_0x0047;
                default: goto L_0x0043;
            }
        L_0x0043:
            r9.skipValue()
            goto L_0x0006
        L_0x0047:
            java.lang.String r0 = r9.nextString()
            r0.hashCode()
            int r4 = r0.hashCode()
            switch(r4) {
                case 97: goto L_0x006b;
                case 105: goto L_0x0060;
                case 115: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            r5 = -1
            goto L_0x0075
        L_0x0057:
            java.lang.String r4 = "s"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0075
            goto L_0x0055
        L_0x0060:
            java.lang.String r4 = "i"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0069
            goto L_0x0055
        L_0x0069:
            r5 = 1
            goto L_0x0075
        L_0x006b:
            java.lang.String r4 = "a"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0074
            goto L_0x0055
        L_0x0074:
            r5 = 0
        L_0x0075:
            switch(r5) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x009b;
                case 2: goto L_0x0097;
                default: goto L_0x0078;
            }
        L_0x0078:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Unknown mask mode "
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = ". Defaulting to Add."
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "LOTTIE"
            android.util.Log.w(r3, r0)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L_0x0006
        L_0x0097:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeSubtract
            goto L_0x0006
        L_0x009b:
            java.lang.String r0 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r10.addWarning(r0)
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeIntersect
            goto L_0x0006
        L_0x00a4:
            com.airbnb.lottie.model.content.Mask$MaskMode r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd
            goto L_0x0006
        L_0x00a8:
            com.airbnb.lottie.model.animatable.AnimatableShapeValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseShapeData(r9, r10)
            goto L_0x0006
        L_0x00ae:
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r2 = com.airbnb.lottie.parser.AnimatableValueParser.parseInteger(r9, r10)
            goto L_0x0006
        L_0x00b4:
            r9.endObject()
            com.airbnb.lottie.model.content.Mask r9 = new com.airbnb.lottie.model.content.Mask
            r9.<init>(r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.MaskParser.parse(android.util.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.Mask");
    }
}
