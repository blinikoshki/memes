package p015io.noties.markwon.image.data;

/* renamed from: io.noties.markwon.image.data.DataUriParser */
public abstract class DataUriParser {
    public abstract DataUri parse(String str);

    public static DataUriParser create() {
        return new Impl();
    }

    /* renamed from: io.noties.markwon.image.data.DataUriParser$Impl */
    static class Impl extends DataUriParser {
        Impl() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
            if (r4.indexOf(47) > -1) goto L_0x004c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p015io.noties.markwon.image.data.DataUri parse(java.lang.String r12) {
            /*
                r11 = this;
                r0 = 44
                int r0 = r12.indexOf(r0)
                r1 = 0
                if (r0 >= 0) goto L_0x000a
                return r1
            L_0x000a:
                r2 = 1
                r3 = 0
                if (r0 <= 0) goto L_0x004b
                java.lang.String r4 = r12.substring(r3, r0)
                java.lang.String r5 = ";"
                java.lang.String[] r4 = r4.split(r5)
                int r5 = r4.length
                if (r5 <= 0) goto L_0x004b
                java.lang.String r6 = "base64"
                r7 = -1
                r8 = 47
                if (r5 != r2) goto L_0x0034
                r4 = r4[r3]
                boolean r5 = r6.equals(r4)
                if (r5 == 0) goto L_0x002d
                r4 = r1
                r3 = 1
                goto L_0x004c
            L_0x002d:
                int r5 = r4.indexOf(r8)
                if (r5 <= r7) goto L_0x004b
                goto L_0x004c
            L_0x0034:
                r9 = r4[r3]
                int r8 = r9.indexOf(r8)
                if (r8 <= r7) goto L_0x003f
                r3 = r4[r3]
                goto L_0x0040
            L_0x003f:
                r3 = r1
            L_0x0040:
                int r5 = r5 - r2
                r4 = r4[r5]
                boolean r4 = r6.equals(r4)
                r10 = r4
                r4 = r3
                r3 = r10
                goto L_0x004c
            L_0x004b:
                r4 = r1
            L_0x004c:
                int r5 = r12.length()
                if (r0 >= r5) goto L_0x006b
                int r0 = r0 + r2
                int r2 = r12.length()
                java.lang.String r12 = r12.substring(r0, r2)
                java.lang.String r0 = "\n"
                java.lang.String r2 = ""
                java.lang.String r12 = r12.replaceAll(r0, r2)
                int r0 = r12.length()
                if (r0 != 0) goto L_0x006a
                goto L_0x006b
            L_0x006a:
                r1 = r12
            L_0x006b:
                io.noties.markwon.image.data.DataUri r12 = new io.noties.markwon.image.data.DataUri
                r12.<init>(r4, r3, r1)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: p015io.noties.markwon.image.data.DataUriParser.Impl.parse(java.lang.String):io.noties.markwon.image.data.DataUri");
        }
    }
}
