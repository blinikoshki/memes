package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Lcoil/decode/GifDecoder;", "Lcoil/decode/Decoder;", "()V", "decode", "Lcoil/decode/DecodeResult;", "pool", "Lcoil/bitmap/BitmapPool;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "mimeType", "", "Companion", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: GifDecoder.kt */
public final class GifDecoder implements Decoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REPEAT_COUNT_KEY = "coil#repeat_count";

    public boolean handles(BufferedSource bufferedSource, String str) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return DecodeUtils.isGif(bufferedSource);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/decode/GifDecoder$Companion;", "", "()V", "REPEAT_COUNT_KEY", "", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: GifDecoder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f4, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f8, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(coil.bitmap.BitmapPool r9, okio.BufferedSource r10, coil.size.Size r11, coil.decode.Options r12, kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r13) {
        /*
            r8 = this;
            kotlinx.coroutines.CancellableContinuationImpl r11 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r13)
            r1 = 1
            r11.<init>(r0, r1)
            r11.initCancellability()
            r0 = r11
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0
            coil.decode.InterruptibleSource r2 = new coil.decode.InterruptibleSource     // Catch:{ Exception -> 0x00fe }
            okio.Source r10 = (okio.Source) r10     // Catch:{ Exception -> 0x00fe }
            r2.<init>(r0, r10)     // Catch:{ Exception -> 0x00fe }
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00f9 }
            r10 = r2
            okio.Source r10 = (okio.Source) r10     // Catch:{ all -> 0x00f9 }
            okio.BufferedSource r10 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x00f9 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f9 }
            r4 = 18
            java.lang.String r5 = "Required value was null."
            r6 = 0
            r7 = 0
            if (r3 > r4) goto L_0x0053
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ all -> 0x00f9 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00f9 }
            r3 = r10
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x004c }
            byte[] r3 = r3.readByteArray()     // Catch:{ all -> 0x004c }
            int r4 = r3.length     // Catch:{ all -> 0x004c }
            android.graphics.Movie r3 = android.graphics.Movie.decodeByteArray(r3, r7, r4)     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0040
            kotlin.p017io.CloseableKt.closeFinally(r10, r6)     // Catch:{ all -> 0x00f9 }
            goto L_0x0067
        L_0x0040:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004c }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x004c }
            r9.<init>(r11)     // Catch:{ all -> 0x004c }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x004c }
            throw r9     // Catch:{ all -> 0x004c }
        L_0x004c:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004e }
        L_0x004e:
            r11 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r10, r9)     // Catch:{ all -> 0x00f9 }
            throw r11     // Catch:{ all -> 0x00f9 }
        L_0x0053:
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ all -> 0x00f9 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00f9 }
            r3 = r10
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x00f2 }
            java.io.InputStream r3 = r3.inputStream()     // Catch:{ all -> 0x00f2 }
            android.graphics.Movie r3 = android.graphics.Movie.decodeStream(r3)     // Catch:{ all -> 0x00f2 }
            if (r3 == 0) goto L_0x00e6
            kotlin.p017io.CloseableKt.closeFinally(r10, r6)     // Catch:{ all -> 0x00f9 }
        L_0x0067:
            int r10 = r3.width()     // Catch:{ all -> 0x00f9 }
            if (r10 <= 0) goto L_0x0074
            int r10 = r3.height()     // Catch:{ all -> 0x00f9 }
            if (r10 <= 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r1 = 0
        L_0x0075:
            if (r1 == 0) goto L_0x00d8
            coil.drawable.MovieDrawable r10 = new coil.drawable.MovieDrawable     // Catch:{ all -> 0x00f9 }
            boolean r1 = r3.isOpaque()     // Catch:{ all -> 0x00f9 }
            if (r1 == 0) goto L_0x0088
            boolean r1 = r12.getAllowRgb565()     // Catch:{ all -> 0x00f9 }
            if (r1 == 0) goto L_0x0088
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x00f9 }
            goto L_0x009d
        L_0x0088:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f9 }
            r4 = 26
            if (r1 < r4) goto L_0x0099
            android.graphics.Bitmap$Config r1 = r12.getConfig()     // Catch:{ all -> 0x00f9 }
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ all -> 0x00f9 }
            if (r1 != r4) goto L_0x0099
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x00f9 }
            goto L_0x009d
        L_0x0099:
            android.graphics.Bitmap$Config r1 = r12.getConfig()     // Catch:{ all -> 0x00f9 }
        L_0x009d:
            coil.size.Scale r4 = r12.getScale()     // Catch:{ all -> 0x00f9 }
            r10.<init>(r3, r9, r1, r4)     // Catch:{ all -> 0x00f9 }
            coil.request.Parameters r9 = r12.getParameters()     // Catch:{ all -> 0x00f9 }
            java.lang.Integer r9 = coil.request.Gifs.repeatCount(r9)     // Catch:{ all -> 0x00f9 }
            if (r9 == 0) goto L_0x00b3
            int r9 = r9.intValue()     // Catch:{ all -> 0x00f9 }
            goto L_0x00b4
        L_0x00b3:
            r9 = -1
        L_0x00b4:
            r10.setRepeatCount(r9)     // Catch:{ all -> 0x00f9 }
            coil.decode.DecodeResult r9 = new coil.decode.DecodeResult     // Catch:{ all -> 0x00f9 }
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ all -> 0x00f9 }
            r9.<init>(r10, r7)     // Catch:{ all -> 0x00f9 }
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x00f9 }
            java.lang.Object r9 = kotlin.Result.m1029constructorimpl(r9)     // Catch:{ all -> 0x00f9 }
            r0.resumeWith(r9)     // Catch:{ all -> 0x00f9 }
            r2.clearInterrupt()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r9 = r11.getResult()
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r10) goto L_0x00d7
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r13)
        L_0x00d7:
            return r9
        L_0x00d8:
            java.lang.String r9 = "Failed to decode GIF."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f9 }
            r10.<init>(r9)     // Catch:{ all -> 0x00f9 }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x00f9 }
            throw r10     // Catch:{ all -> 0x00f9 }
        L_0x00e6:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f2 }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x00f2 }
            r9.<init>(r11)     // Catch:{ all -> 0x00f2 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x00f2 }
            throw r9     // Catch:{ all -> 0x00f2 }
        L_0x00f2:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r11 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r10, r9)     // Catch:{ all -> 0x00f9 }
            throw r11     // Catch:{ all -> 0x00f9 }
        L_0x00f9:
            r9 = move-exception
            r2.clearInterrupt()     // Catch:{ Exception -> 0x00fe }
            throw r9     // Catch:{ Exception -> 0x00fe }
        L_0x00fe:
            r9 = move-exception
            boolean r10 = r9 instanceof java.lang.InterruptedException
            if (r10 != 0) goto L_0x010b
            boolean r10 = r9 instanceof java.io.InterruptedIOException
            if (r10 == 0) goto L_0x0108
            goto L_0x010b
        L_0x0108:
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x010b:
            java.util.concurrent.CancellationException r10 = new java.util.concurrent.CancellationException
            java.lang.String r11 = "Blocking call was interrupted due to parent cancellation."
            r10.<init>(r11)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Throwable r9 = r10.initCause(r9)
            java.lang.String r10 = "CancellationException(\"B…n.\").initCause(exception)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.GifDecoder.decode(coil.bitmap.BitmapPool, okio.BufferedSource, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
