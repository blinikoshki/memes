package com.memes.eventtracker.util;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, mo26107d2 = {"readAssetsFile", "", "Landroid/content/res/AssetManager;", "fileName", "eventtracker_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Util.kt */
public final class UtilKt {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readAssetsFile(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "$this$readAssetsFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            java.io.Reader r0 = (java.io.Reader) r0
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0023
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x002b
        L_0x0023:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x002b:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x003d }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x003d }
            java.lang.String r2 = kotlin.p017io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x003d }
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x003d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.eventtracker.util.UtilKt.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }
}
