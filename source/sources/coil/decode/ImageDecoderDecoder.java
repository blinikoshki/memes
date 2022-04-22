package coil.decode;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import coil.bitmap.BitmapPool;
import coil.drawable.ScaleDrawable;
import coil.request.Gifs;
import coil.size.Size;
import java.io.Closeable;
import java.io.File;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p017io.CloseableKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Lcoil/decode/ImageDecoderDecoder;", "Lcoil/decode/Decoder;", "()V", "decode", "Lcoil/decode/DecodeResult;", "pool", "Lcoil/bitmap/BitmapPool;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "mimeType", "", "Companion", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ImageDecoderDecoder.kt */
public final class ImageDecoderDecoder implements Decoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REPEAT_COUNT_KEY = "coil#repeat_count";

    public boolean handles(BufferedSource bufferedSource, String str) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return DecodeUtils.isGif(bufferedSource) || DecodeUtils.isAnimatedWebP(bufferedSource) || (Build.VERSION.SDK_INT >= 30 && DecodeUtils.isAnimatedHeif(bufferedSource));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/decode/ImageDecoderDecoder$Companion;", "", "()V", "REPEAT_COUNT_KEY", "", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ImageDecoderDecoder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object decode(BitmapPool bitmapPool, BufferedSource bufferedSource, Size size, Options options, Continuation<? super DecodeResult> continuation) {
        ImageDecoder.Source source;
        Throwable th;
        Throwable th2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        try {
            InterruptibleSource interruptibleSource = new InterruptibleSource(cancellableContinuation, bufferedSource);
            try {
                Continuation continuation2 = cancellableContinuation;
                Source source2 = interruptibleSource;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = (File) null;
                try {
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    booleanRef.element = false;
                    BufferedSource buffer = Okio.buffer(source2);
                    if (Build.VERSION.SDK_INT >= 30) {
                        Closeable closeable = buffer;
                        Throwable th3 = null;
                        try {
                            byte[] readByteArray = ((BufferedSource) closeable).readByteArray();
                            CloseableKt.closeFinally(closeable, th3);
                            source = ImageDecoder.createSource(ByteBuffer.wrap(readByteArray));
                        } catch (Throwable th4) {
                            Throwable th5 = th4;
                            CloseableKt.closeFinally(closeable, th2);
                            throw th5;
                        }
                    } else {
                        objectRef.element = File.createTempFile("tmp", (String) null, (File) null);
                        Closeable closeable2 = buffer;
                        Throwable th6 = null;
                        try {
                            BufferedSource bufferedSource2 = (BufferedSource) closeable2;
                            File file = (File) objectRef.element;
                            Intrinsics.checkNotNullExpressionValue(file, "tempFile");
                            th = Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                            Throwable th7 = null;
                            try {
                                Long boxLong = Boxing.boxLong(bufferedSource2.readAll((Sink) th));
                                CloseableKt.closeFinally(th, th7);
                                Boxing.boxLong(boxLong.longValue());
                                CloseableKt.closeFinally(closeable2, th6);
                                source = ImageDecoder.createSource((File) objectRef.element);
                            } catch (Throwable th8) {
                                Throwable th9 = th8;
                                CloseableKt.closeFinally(th, th);
                                throw th9;
                            }
                        } finally {
                            Closeable closeable3 = th;
                            try {
                            } catch (Throwable th10) {
                                Throwable th11 = th10;
                                CloseableKt.closeFinally(closeable2, closeable3);
                                throw th11;
                            }
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(source, "if (SDK_INT >= 30) {\n   …e(tempFile)\n            }");
                    Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new C0926xd26e187e(objectRef, booleanRef, size, options));
                    Intrinsics.checkExpressionValueIsNotNull(decodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
                    if (decodeDrawable instanceof AnimatedImageDrawable) {
                        AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) decodeDrawable;
                        Integer repeatCount = Gifs.repeatCount(options.getParameters());
                        animatedImageDrawable.setRepeatCount(repeatCount != null ? repeatCount.intValue() : -1);
                        decodeDrawable = new ScaleDrawable(decodeDrawable, options.getScale());
                    }
                    DecodeResult decodeResult = new DecodeResult(decodeDrawable, booleanRef.element);
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m1029constructorimpl(decodeResult));
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                } finally {
                    File file2 = (File) objectRef.element;
                    if (file2 != null) {
                        Boxing.boxBoolean(file2.delete());
                    }
                }
            } finally {
                interruptibleSource.clearInterrupt();
            }
        } catch (Exception e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e;
        }
    }
}
