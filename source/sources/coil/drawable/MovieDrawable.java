package coil.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.bitmap.BitmapPool;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u0006\u0010/\u001a\u00020\u001cJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0012H\u0014J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u000eH\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u001cH\u0016J\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u000e\u00109\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010:\u001a\u00020)H\u0016J\b\u0010;\u001a\u00020)H\u0016J\u0010\u0010<\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000eH\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, mo26107d2 = {"Lcoil/drawable/MovieDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "movie", "Landroid/graphics/Movie;", "pool", "Lcoil/bitmap/BitmapPool;", "config", "Landroid/graphics/Bitmap$Config;", "scale", "Lcoil/size/Scale;", "(Landroid/graphics/Movie;Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap$Config;Lcoil/size/Scale;)V", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "currentBounds", "Landroid/graphics/Rect;", "frameTimeMillis", "", "hardwareDx", "", "hardwareDy", "hardwareScale", "isRunning", "", "loopIteration", "", "paint", "Landroid/graphics/Paint;", "repeatCount", "getScale", "()Lcoil/size/Scale;", "softwareBitmap", "Landroid/graphics/Bitmap;", "softwareCanvas", "Landroid/graphics/Canvas;", "softwareScale", "startTimeMillis", "clearAnimationCallbacks", "", "draw", "canvas", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getRepeatCount", "onBoundsChange", "bounds", "registerAnimationCallback", "callback", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setRepeatCount", "start", "stop", "unregisterAnimationCallback", "Companion", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: MovieDrawable.kt */
public final class MovieDrawable extends Drawable implements Animatable2Compat {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REPEAT_INFINITE = -1;
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final Bitmap.Config config;
    private Rect currentBounds;
    private long frameTimeMillis;
    private float hardwareDx;
    private float hardwareDy;
    private float hardwareScale;
    private boolean isRunning;
    private int loopIteration;
    private final Movie movie;
    private final Paint paint;
    private final BitmapPool pool;
    private int repeatCount;
    private final Scale scale;
    private Bitmap softwareBitmap;
    private Canvas softwareCanvas;
    private float softwareScale;
    private long startTimeMillis;

    public MovieDrawable(Movie movie2) {
        this(movie2, (BitmapPool) null, (Bitmap.Config) null, (Scale) null, 14, (DefaultConstructorMarker) null);
    }

    public MovieDrawable(Movie movie2, BitmapPool bitmapPool) {
        this(movie2, bitmapPool, (Bitmap.Config) null, (Scale) null, 12, (DefaultConstructorMarker) null);
    }

    public MovieDrawable(Movie movie2, BitmapPool bitmapPool, Bitmap.Config config2) {
        this(movie2, bitmapPool, config2, (Scale) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MovieDrawable(Movie movie2, BitmapPool bitmapPool, Bitmap.Config config2, Scale scale2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(movie2, (i & 2) != 0 ? BitmapPool.Companion.create(0) : bitmapPool, (i & 4) != 0 ? Bitmap.Config.ARGB_8888 : config2, (i & 8) != 0 ? Scale.FIT : scale2);
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public MovieDrawable(Movie movie2, BitmapPool bitmapPool, Bitmap.Config config2, Scale scale2) {
        Intrinsics.checkNotNullParameter(movie2, "movie");
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(scale2, "scale");
        this.movie = movie2;
        this.pool = bitmapPool;
        this.config = config2;
        this.scale = scale2;
        this.paint = new Paint(3);
        this.callbacks = new ArrayList();
        this.softwareScale = 1.0f;
        this.hardwareScale = 1.0f;
        this.repeatCount = -1;
        if (!(Build.VERSION.SDK_INT < 26 || config2 != Bitmap.Config.HARDWARE)) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Canvas canvas2 = this.softwareCanvas;
        if (canvas2 != null && (bitmap = this.softwareBitmap) != null) {
            int duration = this.movie.duration();
            if (duration == 0) {
                duration = 0;
                z = false;
            } else {
                if (this.isRunning) {
                    this.frameTimeMillis = SystemClock.uptimeMillis();
                }
                int i = (int) (this.frameTimeMillis - this.startTimeMillis);
                int i2 = i / duration;
                this.loopIteration = i2;
                int i3 = this.repeatCount;
                z = i3 == -1 || i2 <= i3;
                if (z) {
                    duration = i - (i2 * duration);
                }
            }
            this.movie.setTime(duration);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            int save = canvas2.save();
            try {
                float f = this.softwareScale;
                canvas2.scale(f, f);
                this.movie.draw(canvas2, 0.0f, 0.0f, this.paint);
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                try {
                    canvas.translate(this.hardwareDx, this.hardwareDy);
                    float f2 = this.hardwareScale;
                    canvas.scale(f2, f2);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
                    canvas.restoreToCount(save2);
                    if (!this.isRunning || !z) {
                        stop();
                    } else {
                        invalidateSelf();
                    }
                } catch (Throwable th) {
                    canvas.restoreToCount(save2);
                    throw th;
                }
            } catch (Throwable th2) {
                canvas2.restoreToCount(save);
                throw th2;
            }
        }
    }

    public final void setRepeatCount(int i) {
        if (i >= -1) {
            this.repeatCount = i;
            return;
        }
        throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public void setAlpha(int i) {
        if (i >= 0 && 255 >= i) {
            this.paint.setAlpha(i);
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + i).toString());
    }

    public int getOpacity() {
        return (this.paint.getAlpha() != 255 || !this.movie.isOpaque()) ? -3 : -1;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        if (!Intrinsics.areEqual((Object) this.currentBounds, (Object) rect)) {
            this.currentBounds = rect;
            int width = rect.width();
            int height = rect.height();
            int width2 = this.movie.width();
            int height2 = this.movie.height();
            if (width2 > 0 && height2 > 0) {
                float coerceAtMost = RangesKt.coerceAtMost((float) DecodeUtils.computeSizeMultiplier(width2, height2, width, height, this.scale), 1.0f);
                this.softwareScale = coerceAtMost;
                int i = (int) (((float) width2) * coerceAtMost);
                int i2 = (int) (coerceAtMost * ((float) height2));
                Bitmap bitmap = this.pool.get(i, i2, this.config);
                Bitmap bitmap2 = this.softwareBitmap;
                if (bitmap2 != null) {
                    this.pool.put(bitmap2);
                }
                this.softwareBitmap = bitmap;
                this.softwareCanvas = new Canvas(bitmap);
                this.hardwareScale = (float) DecodeUtils.computeSizeMultiplier(i, i2, width, height, this.scale);
                float f = (float) 2;
                this.hardwareDx = ((float) rect.left) + ((((float) width) - (this.hardwareScale * ((float) i))) / f);
                this.hardwareDy = ((float) rect.top) + ((((float) height) - (this.hardwareScale * ((float) i2))) / f);
            }
        }
    }

    public int getIntrinsicWidth() {
        return this.movie.width();
    }

    public int getIntrinsicHeight() {
        return this.movie.height();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.loopIteration = 0;
            this.startTimeMillis = SystemClock.uptimeMillis();
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onAnimationStart(this);
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onAnimationEnd(this);
            }
        }
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        this.callbacks.add(animationCallback);
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        return this.callbacks.remove(animationCallback);
    }

    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/drawable/MovieDrawable$Companion;", "", "()V", "REPEAT_INFINITE", "", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: MovieDrawable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
