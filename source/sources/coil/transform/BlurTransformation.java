package coil.transform;

import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J)\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo26107d2 = {"Lcoil/transform/BlurTransformation;", "Lcoil/transform/Transformation;", "context", "Landroid/content/Context;", "radius", "", "sampling", "(Landroid/content/Context;FF)V", "equals", "", "other", "", "hashCode", "", "key", "", "toString", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "input", "size", "Lcoil/size/Size;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BlurTransformation.kt */
public final class BlurTransformation implements Transformation {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_RADIUS = 10.0f;
    private static final float DEFAULT_SAMPLING = 1.0f;
    private final Context context;
    private final float radius;
    private final float sampling;

    public BlurTransformation(Context context2) {
        this(context2, 0.0f, 0.0f, 6, (DefaultConstructorMarker) null);
    }

    public BlurTransformation(Context context2, float f) {
        this(context2, f, 0.0f, 4, (DefaultConstructorMarker) null);
    }

    public BlurTransformation(Context context2, float f, float f2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.radius = f;
        this.sampling = f2;
        double d = (double) f;
        boolean z = true;
        if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d <= 25.0d) {
            if (!(f2 <= ((float) 0) ? false : z)) {
                throw new IllegalArgumentException("sampling must be > 0.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("radius must be in [0, 25].".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurTransformation(Context context2, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? 10.0f : f, (i & 4) != 0 ? 1.0f : f2);
    }

    public String key() {
        return BlurTransformation.class.getName() + '-' + this.radius + '-' + this.sampling;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object transform(coil.bitmap.BitmapPool r6, android.graphics.Bitmap r7, coil.size.Size r8, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r9) {
        /*
            r5 = this;
            android.graphics.Paint r8 = new android.graphics.Paint
            r9 = 3
            r8.<init>(r9)
            int r9 = r7.getWidth()
            float r9 = (float) r9
            float r0 = r5.sampling
            float r9 = r9 / r0
            int r9 = (int) r9
            int r0 = r7.getHeight()
            float r0 = (float) r0
            float r1 = r5.sampling
            float r0 = r0 / r1
            int r0 = (int) r0
            android.graphics.Bitmap$Config r1 = coil.util.Bitmaps.getSafeConfig(r7)
            android.graphics.Bitmap r6 = r6.get(r9, r0, r1)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r6)
            r0 = 1
            float r1 = (float) r0
            float r2 = r5.sampling
            float r3 = r1 / r2
            float r1 = r1 / r2
            r9.scale(r3, r1)
            r1 = 0
            r9.drawBitmap(r7, r1, r1, r8)
            r7 = 0
            r8 = r7
            android.renderscript.RenderScript r8 = (android.renderscript.RenderScript) r8
            r9 = r7
            android.renderscript.Allocation r9 = (android.renderscript.Allocation) r9
            android.renderscript.ScriptIntrinsicBlur r7 = (android.renderscript.ScriptIntrinsicBlur) r7
            android.content.Context r1 = r5.context     // Catch:{ all -> 0x0084 }
            android.renderscript.RenderScript r8 = android.renderscript.RenderScript.create(r1)     // Catch:{ all -> 0x0084 }
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0084 }
            android.renderscript.Allocation r0 = android.renderscript.Allocation.createFromBitmap(r8, r6, r1, r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = "tmpInt"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x007f }
            android.renderscript.Type r1 = r0.getType()     // Catch:{ all -> 0x007f }
            android.renderscript.Allocation r9 = android.renderscript.Allocation.createTyped(r8, r1)     // Catch:{ all -> 0x007f }
            android.renderscript.Element r1 = android.renderscript.Element.U8_4(r8)     // Catch:{ all -> 0x007f }
            android.renderscript.ScriptIntrinsicBlur r7 = android.renderscript.ScriptIntrinsicBlur.create(r8, r1)     // Catch:{ all -> 0x007f }
            float r1 = r5.radius     // Catch:{ all -> 0x007f }
            r7.setRadius(r1)     // Catch:{ all -> 0x007f }
            r7.setInput(r0)     // Catch:{ all -> 0x007f }
            r7.forEach(r9)     // Catch:{ all -> 0x007f }
            r9.copyTo(r6)     // Catch:{ all -> 0x007f }
            if (r8 == 0) goto L_0x0071
            r8.destroy()
        L_0x0071:
            r0.destroy()
            if (r9 == 0) goto L_0x0079
            r9.destroy()
        L_0x0079:
            if (r7 == 0) goto L_0x007e
            r7.destroy()
        L_0x007e:
            return r6
        L_0x007f:
            r6 = move-exception
            r4 = r0
            r0 = r9
            r9 = r4
            goto L_0x0086
        L_0x0084:
            r6 = move-exception
            r0 = r9
        L_0x0086:
            if (r8 == 0) goto L_0x008b
            r8.destroy()
        L_0x008b:
            if (r9 == 0) goto L_0x0090
            r9.destroy()
        L_0x0090:
            if (r0 == 0) goto L_0x0095
            r0.destroy()
        L_0x0095:
            if (r7 == 0) goto L_0x009a
            r7.destroy()
        L_0x009a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.transform.BlurTransformation.transform(coil.bitmap.BitmapPool, android.graphics.Bitmap, coil.size.Size, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            if (Intrinsics.areEqual((Object) this.context, (Object) blurTransformation.context) && this.radius == blurTransformation.radius && this.sampling == blurTransformation.sampling) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + Float.floatToIntBits(this.radius)) * 31) + Float.floatToIntBits(this.sampling);
    }

    public String toString() {
        return "BlurTransformation(context=" + this.context + ", radius=" + this.radius + ", sampling=" + this.sampling + ')';
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcoil/transform/BlurTransformation$Companion;", "", "()V", "DEFAULT_RADIUS", "", "DEFAULT_SAMPLING", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: BlurTransformation.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
