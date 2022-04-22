package coil.fetch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import coil.bitmap.BitmapPool;
import coil.decode.DecodeUtils;
import coil.decode.Options;
import coil.fetch.Fetcher;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import com.memes.commons.output.OutputExtension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0019\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\r\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, mo26107d2 = {"Lcoil/fetch/VideoFrameFetcher;", "T", "", "Lcoil/fetch/Fetcher;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/lang/Object;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConfigValid", "", "bitmap", "Landroid/graphics/Bitmap;", "isSizeValid", "normalizeBitmap", "inBitmap", "setDataSource", "", "Landroid/media/MediaMetadataRetriever;", "(Landroid/media/MediaMetadataRetriever;Ljava/lang/Object;)V", "Companion", "coil-video_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: VideoFrameFetcher.kt */
public abstract class VideoFrameFetcher<T> implements Fetcher<T> {
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String[] SUPPORTED_FILE_EXTENSIONS = {".3gp", ".mkv", OutputExtension.MP4, ".ts", ".webm"};
    public static final String VIDEO_FRAME_MICROS_KEY = "coil#video_frame_micros";
    public static final String VIDEO_FRAME_OPTION_KEY = "coil#video_frame_option";
    private final Context context;
    private final Paint paint = new Paint(3);

    public Object fetch(BitmapPool bitmapPool, T t, Size size, Options options, Continuation<? super FetchResult> continuation) {
        return fetch$suspendImpl(this, bitmapPool, t, size, options, continuation);
    }

    /* access modifiers changed from: protected */
    public abstract void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, T t);

    public VideoFrameFetcher(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public boolean handles(T t) {
        Intrinsics.checkNotNullParameter(t, "data");
        return Fetcher.DefaultImpls.handles(this, t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9 A[ADDED_TO_REGION, Catch:{ all -> 0x0192 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object fetch$suspendImpl(coil.fetch.VideoFrameFetcher r16, coil.bitmap.BitmapPool r17, java.lang.Object r18, coil.size.Size r19, coil.decode.Options r20, kotlin.coroutines.Continuation r21) {
        /*
            r0 = r16
            r1 = r19
            android.media.MediaMetadataRetriever r7 = new android.media.MediaMetadataRetriever
            r7.<init>()
            r2 = r18
            r0.setDataSource(r7, r2)     // Catch:{ all -> 0x0192 }
            coil.request.Parameters r2 = r20.getParameters()     // Catch:{ all -> 0x0192 }
            java.lang.Integer r2 = coil.request.Videos.videoFrameOption(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x001e
            int r2 = r2.intValue()     // Catch:{ all -> 0x0192 }
            r4 = r2
            goto L_0x0020
        L_0x001e:
            r2 = 2
            r4 = 2
        L_0x0020:
            coil.request.Parameters r2 = r20.getParameters()     // Catch:{ all -> 0x0192 }
            java.lang.Long r2 = coil.request.Videos.videoFrameMicros(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x002f
            long r2 = r2.longValue()     // Catch:{ all -> 0x0192 }
            goto L_0x0031
        L_0x002f:
            r2 = 0
        L_0x0031:
            r8 = r2
            boolean r2 = r1 instanceof coil.size.PixelSize     // Catch:{ all -> 0x0192 }
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r12 = 0
            if (r2 == 0) goto L_0x00e9
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0192 }
            r3 = 17
            if (r2 < r3) goto L_0x0052
            r2 = 24
            java.lang.String r2 = r7.extractMetadata(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0052
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0052
            int r2 = r2.intValue()     // Catch:{ all -> 0x0192 }
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            r3 = 90
            r5 = 18
            r6 = 19
            if (r2 == r3) goto L_0x0085
            r3 = 270(0x10e, float:3.78E-43)
            if (r2 != r3) goto L_0x0060
            goto L_0x0085
        L_0x0060:
            java.lang.String r2 = r7.extractMetadata(r5)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0071
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0071
            int r2 = r2.intValue()     // Catch:{ all -> 0x0192 }
            goto L_0x0072
        L_0x0071:
            r2 = 0
        L_0x0072:
            java.lang.String r3 = r7.extractMetadata(r6)     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0083
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0083
            int r3 = r3.intValue()     // Catch:{ all -> 0x0192 }
            goto L_0x00a7
        L_0x0083:
            r3 = 0
            goto L_0x00a7
        L_0x0085:
            java.lang.String r2 = r7.extractMetadata(r6)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0096
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x0192 }
            if (r2 == 0) goto L_0x0096
            int r2 = r2.intValue()     // Catch:{ all -> 0x0192 }
            goto L_0x0097
        L_0x0096:
            r2 = 0
        L_0x0097:
            java.lang.String r3 = r7.extractMetadata(r5)     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0083
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0083
            int r3 = r3.intValue()     // Catch:{ all -> 0x0192 }
        L_0x00a7:
            if (r2 <= 0) goto L_0x00e0
            if (r3 <= 0) goto L_0x00e0
            r5 = r1
            coil.size.PixelSize r5 = (coil.size.PixelSize) r5     // Catch:{ all -> 0x0192 }
            int r5 = r5.getWidth()     // Catch:{ all -> 0x0192 }
            coil.size.PixelSize r1 = (coil.size.PixelSize) r1     // Catch:{ all -> 0x0192 }
            int r1 = r1.getHeight()     // Catch:{ all -> 0x0192 }
            coil.size.Scale r6 = r20.getScale()     // Catch:{ all -> 0x0192 }
            double r5 = coil.decode.DecodeUtils.computeSizeMultiplier((int) r2, (int) r3, (int) r5, (int) r1, (coil.size.Scale) r6)     // Catch:{ all -> 0x0192 }
            boolean r1 = r20.getAllowInexactSize()     // Catch:{ all -> 0x0192 }
            if (r1 == 0) goto L_0x00ca
            double r5 = kotlin.ranges.RangesKt.coerceAtMost((double) r5, (double) r10)     // Catch:{ all -> 0x0192 }
        L_0x00ca:
            double r13 = (double) r2     // Catch:{ all -> 0x0192 }
            double r13 = r13 * r5
            int r1 = kotlin.math.MathKt.roundToInt((double) r13)     // Catch:{ all -> 0x0192 }
            double r13 = (double) r3     // Catch:{ all -> 0x0192 }
            double r5 = r5 * r13
            int r5 = kotlin.math.MathKt.roundToInt((double) r5)     // Catch:{ all -> 0x0192 }
            coil.size.PixelSize r6 = new coil.size.PixelSize     // Catch:{ all -> 0x0192 }
            r6.<init>(r1, r5)     // Catch:{ all -> 0x0192 }
            coil.size.Size r6 = (coil.size.Size) r6     // Catch:{ all -> 0x0192 }
            goto L_0x00e5
        L_0x00e0:
            coil.size.OriginalSize r1 = coil.size.OriginalSize.INSTANCE     // Catch:{ all -> 0x0192 }
            r6 = r1
            coil.size.Size r6 = (coil.size.Size) r6     // Catch:{ all -> 0x0192 }
        L_0x00e5:
            r13 = r2
            r14 = r3
            r15 = r6
            goto L_0x00f5
        L_0x00e9:
            boolean r1 = r1 instanceof coil.size.OriginalSize     // Catch:{ all -> 0x0192 }
            if (r1 == 0) goto L_0x018c
            coil.size.OriginalSize r1 = coil.size.OriginalSize.INSTANCE     // Catch:{ all -> 0x0192 }
            r6 = r1
            coil.size.Size r6 = (coil.size.Size) r6     // Catch:{ all -> 0x0192 }
            r15 = r6
            r13 = 0
            r14 = 0
        L_0x00f5:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0192 }
            r2 = 27
            if (r1 < r2) goto L_0x0114
            boolean r1 = r15 instanceof coil.size.PixelSize     // Catch:{ all -> 0x0192 }
            if (r1 == 0) goto L_0x0114
            r1 = r15
            coil.size.PixelSize r1 = (coil.size.PixelSize) r1     // Catch:{ all -> 0x0192 }
            int r5 = r1.getWidth()     // Catch:{ all -> 0x0192 }
            r1 = r15
            coil.size.PixelSize r1 = (coil.size.PixelSize) r1     // Catch:{ all -> 0x0192 }
            int r6 = r1.getHeight()     // Catch:{ all -> 0x0192 }
            r1 = r7
            r2 = r8
            android.graphics.Bitmap r1 = r1.getScaledFrameAtTime(r2, r4, r5, r6)     // Catch:{ all -> 0x0192 }
            goto L_0x0129
        L_0x0114:
            android.graphics.Bitmap r1 = r7.getFrameAtTime(r8, r4)     // Catch:{ all -> 0x0192 }
            if (r1 == 0) goto L_0x0128
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0192 }
            int r13 = r1.getWidth()     // Catch:{ all -> 0x0192 }
            int r14 = r1.getHeight()     // Catch:{ all -> 0x0192 }
            goto L_0x0129
        L_0x0128:
            r1 = 0
        L_0x0129:
            if (r1 == 0) goto L_0x016a
            r2 = r17
            r3 = r20
            android.graphics.Bitmap r1 = r0.normalizeBitmap(r2, r1, r15, r3)     // Catch:{ all -> 0x0192 }
            r2 = 1
            if (r13 <= 0) goto L_0x014c
            if (r14 <= 0) goto L_0x014c
            int r4 = r1.getWidth()     // Catch:{ all -> 0x0192 }
            int r5 = r1.getHeight()     // Catch:{ all -> 0x0192 }
            coil.size.Scale r3 = r20.getScale()     // Catch:{ all -> 0x0192 }
            double r3 = coil.decode.DecodeUtils.computeSizeMultiplier((int) r13, (int) r14, (int) r4, (int) r5, (coil.size.Scale) r3)     // Catch:{ all -> 0x0192 }
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x014d
        L_0x014c:
            r12 = 1
        L_0x014d:
            coil.fetch.DrawableResult r2 = new coil.fetch.DrawableResult     // Catch:{ all -> 0x0192 }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x0192 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0192 }
            java.lang.String r3 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ all -> 0x0192 }
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0192 }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x0192 }
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3     // Catch:{ all -> 0x0192 }
            coil.decode.DataSource r0 = coil.decode.DataSource.DISK     // Catch:{ all -> 0x0192 }
            r2.<init>(r3, r12, r0)     // Catch:{ all -> 0x0192 }
            r7.release()
            return r2
        L_0x016a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r0.<init>()     // Catch:{ all -> 0x0192 }
            java.lang.String r1 = "Failed to decode frame at "
            r0.append(r1)     // Catch:{ all -> 0x0192 }
            r0.append(r8)     // Catch:{ all -> 0x0192 }
            java.lang.String r1 = " microseconds."
            r0.append(r1)     // Catch:{ all -> 0x0192 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0192 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0192 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0192 }
            r1.<init>(r0)     // Catch:{ all -> 0x0192 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0192 }
            throw r1     // Catch:{ all -> 0x0192 }
        L_0x018c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0192 }
            r0.<init>()     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0192:
            r0 = move-exception
            r7.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.VideoFrameFetcher.fetch$suspendImpl(coil.fetch.VideoFrameFetcher, coil.bitmap.BitmapPool, java.lang.Object, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Bitmap normalizeBitmap(BitmapPool bitmapPool, Bitmap bitmap, Size size, Options options) {
        float f;
        int i;
        int i2;
        Bitmap.Config config;
        if (isConfigValid(bitmap, options) && isSizeValid(bitmap, options, size)) {
            return bitmap;
        }
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            f = (float) DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), pixelSize.getWidth(), pixelSize.getHeight(), options.getScale());
            i2 = MathKt.roundToInt(((float) bitmap.getWidth()) * f);
            i = MathKt.roundToInt(((float) bitmap.getHeight()) * f);
        } else if (size instanceof OriginalSize) {
            f = 1.0f;
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT < 26 || options.getConfig() != Bitmap.Config.HARDWARE) {
            config = options.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(i2, i, config);
        Canvas canvas = new Canvas(bitmap2);
        canvas.scale(f, f);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        bitmapPool.put(bitmap);
        return bitmap2;
    }

    private final boolean isConfigValid(Bitmap bitmap, Options options) {
        return Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE || options.getConfig() == Bitmap.Config.HARDWARE;
    }

    private final boolean isSizeValid(Bitmap bitmap, Options options, Size size) {
        return options.getAllowInexactSize() || (size instanceof OriginalSize) || Intrinsics.areEqual((Object) size, (Object) DecodeUtils.computePixelSize(bitmap.getWidth(), bitmap.getHeight(), size, options.getScale()));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcoil/fetch/VideoFrameFetcher$Companion;", "", "()V", "ASSET_FILE_PATH_ROOT", "", "SUPPORTED_FILE_EXTENSIONS", "", "[Ljava/lang/String;", "VIDEO_FRAME_MICROS_KEY", "VIDEO_FRAME_OPTION_KEY", "coil-video_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: VideoFrameFetcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
