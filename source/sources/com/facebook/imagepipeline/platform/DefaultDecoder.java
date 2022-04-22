package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = DefaultDecoder.class;
    private final BitmapPool mBitmapPool;
    final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
    @Nullable
    private final PreverificationHelper mPreverificationHelper;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        TailAppendingInputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, (ColorSpace) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        com.facebook.common.logging.FLog.m55e(TAG, "Could not decode region %s, decoding full bitmap instead.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a1, code lost:
        if (r0 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a7, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a8, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r6.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r2 = r8.mPreverificationHelper;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0096 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x0100 */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7, all -> 0x00d5, IOException -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b2 A[Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7, all -> 0x00d5, IOException -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r9, android.graphics.BitmapFactory.Options r10, @javax.annotation.Nullable android.graphics.Rect r11, @javax.annotation.Nullable android.graphics.ColorSpace r12) {
        /*
            r8 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r9)
            int r0 = r10.outWidth
            int r1 = r10.outHeight
            if (r11 == 0) goto L_0x0017
            int r0 = r11.width()
            int r1 = r10.inSampleSize
            int r0 = r0 / r1
            int r1 = r11.height()
            int r2 = r10.inSampleSize
            int r1 = r1 / r2
        L_0x0017:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x002d
            com.facebook.imagepipeline.platform.PreverificationHelper r2 = r8.mPreverificationHelper
            if (r2 == 0) goto L_0x002d
            android.graphics.Bitmap$Config r6 = r10.inPreferredConfig
            boolean r2 = r2.shouldUseHardwareBitmapConfig(r6)
            if (r2 == 0) goto L_0x002d
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            r6 = 0
            if (r11 != 0) goto L_0x0037
            if (r2 == 0) goto L_0x0037
            r10.inMutable = r5
            r2 = r6
            goto L_0x0050
        L_0x0037:
            if (r11 == 0) goto L_0x003f
            if (r2 == 0) goto L_0x003f
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            r10.inPreferredConfig = r2
        L_0x003f:
            int r2 = r8.getBitmapSize(r0, r1, r10)
            com.facebook.imagepipeline.memory.BitmapPool r7 = r8.mBitmapPool
            java.lang.Object r2 = r7.get(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            java.lang.String r7 = "BitmapPool.get returned null"
            java.util.Objects.requireNonNull(r2, r7)
        L_0x0050:
            r10.inBitmap = r2
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r3) goto L_0x0060
            if (r12 != 0) goto L_0x005e
            android.graphics.ColorSpace$Named r12 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r12 = android.graphics.ColorSpace.get(r12)
        L_0x005e:
            r10.inPreferredColorSpace = r12
        L_0x0060:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r12 = r8.mDecodeBuffers
            java.lang.Object r12 = r12.acquire()
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            if (r12 != 0) goto L_0x0070
            r12 = 16384(0x4000, float:2.2959E-41)
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)
        L_0x0070:
            byte[] r3 = r12.array()     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
            r10.inTempStorage = r3     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
            r7 = 19
            if (r3 < r7) goto L_0x00af
            if (r11 == 0) goto L_0x00af
            if (r2 == 0) goto L_0x00af
            android.graphics.Bitmap$Config r3 = r10.inPreferredConfig     // Catch:{ IOException -> 0x0095, all -> 0x0093 }
            r2.reconfigure(r0, r1, r3)     // Catch:{ IOException -> 0x0095, all -> 0x0093 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r9, r4)     // Catch:{ IOException -> 0x0095, all -> 0x0093 }
            android.graphics.Bitmap r11 = r0.decodeRegion(r11, r10)     // Catch:{ IOException -> 0x0096 }
            if (r0 == 0) goto L_0x00b0
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
            goto L_0x00b0
        L_0x0093:
            r10 = move-exception
            goto L_0x00a9
        L_0x0095:
            r0 = r6
        L_0x0096:
            java.lang.Class<?> r1 = TAG     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a7 }
            r4[r5] = r11     // Catch:{ all -> 0x00a7 }
            com.facebook.common.logging.FLog.m55e((java.lang.Class<?>) r1, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x00af
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
            goto L_0x00af
        L_0x00a7:
            r10 = move-exception
            r6 = r0
        L_0x00a9:
            if (r6 == 0) goto L_0x00ae
            r6.recycle()     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
        L_0x00ae:
            throw r10     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
        L_0x00af:
            r11 = r6
        L_0x00b0:
            if (r11 != 0) goto L_0x00b6
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeStream(r9, r6, r10)     // Catch:{ IllegalArgumentException -> 0x00e0, RuntimeException -> 0x00d7 }
        L_0x00b6:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r9 = r8.mDecodeBuffers
            r9.release(r12)
            if (r2 == 0) goto L_0x00ce
            if (r2 != r11) goto L_0x00c0
            goto L_0x00ce
        L_0x00c0:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            r9.release(r2)
            r11.recycle()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x00ce:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.m123of(r11, r9)
            return r9
        L_0x00d5:
            r9 = move-exception
            goto L_0x0101
        L_0x00d7:
            r9 = move-exception
            if (r2 == 0) goto L_0x00df
            com.facebook.imagepipeline.memory.BitmapPool r10 = r8.mBitmapPool     // Catch:{ all -> 0x00d5 }
            r10.release(r2)     // Catch:{ all -> 0x00d5 }
        L_0x00df:
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x00e0:
            r10 = move-exception
            if (r2 == 0) goto L_0x00e8
            com.facebook.imagepipeline.memory.BitmapPool r11 = r8.mBitmapPool     // Catch:{ all -> 0x00d5 }
            r11.release(r2)     // Catch:{ all -> 0x00d5 }
        L_0x00e8:
            r9.reset()     // Catch:{ IOException -> 0x0100 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ IOException -> 0x0100 }
            if (r9 == 0) goto L_0x00ff
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r11 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x0100 }
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.m123of(r9, r11)     // Catch:{ IOException -> 0x0100 }
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            return r9
        L_0x00ff:
            throw r10     // Catch:{ IOException -> 0x0100 }
        L_0x0100:
            throw r10     // Catch:{ all -> 0x00d5 }
        L_0x0101:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.CloseableReference");
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
