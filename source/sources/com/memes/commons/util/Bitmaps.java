package com.memes.commons.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0006J\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007J*\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0006J*\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0006¨\u0006!"}, mo26107d2 = {"Lcom/memes/commons/util/Bitmaps;", "", "()V", "createBitmapFromDrawable", "Landroid/graphics/Bitmap;", "width", "", "height", "drawable", "Landroid/graphics/drawable/Drawable;", "createBitmapFromView", "view", "Landroid/view/View;", "scaleX", "", "scaleY", "createCircularOverlay", "bgColor", "createMonoColorBitmap", "color", "createRoundedCornersOverlay", "cornerRadius", "createScaledBitmap", "source", "save", "Ljava/io/File;", "bitmap", "destinationFile", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "saveToFile", "saveToFileSafely", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Bitmaps.kt */
public final class Bitmaps {
    public static final Bitmaps INSTANCE = new Bitmaps();

    private Bitmaps() {
    }

    public final Bitmap createMonoColorBitmap(int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) i2, paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public final Bitmap createBitmapFromDrawable(int i, int i2, Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(createBitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public final Bitmap createBitmapFromView(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        return createBitmapFromView(view, i, i2, view.getScaleX(), view.getScaleY());
    }

    public static /* synthetic */ Bitmap createBitmapFromView$default(Bitmaps bitmaps, View view, int i, int i2, float f, float f2, int i3, Object obj) {
        return bitmaps.createBitmapFromView(view, i, i2, f, (i3 & 16) != 0 ? f : f2);
    }

    public final Bitmap createBitmapFromView(View view, int i, int i2, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Bitmap createBitmap = Bitmap.createBitmap(MathKt.roundToInt(((float) i) * f), MathKt.roundToInt(((float) i2) * f2), Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(f, f2);
        view.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public final Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "source");
        if (!bitmap.isRecycled()) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma…rce, width, height, true)");
            return createScaledBitmap;
        }
        throw new RuntimeException("Bitmap is already recycled and so, can't be used.");
    }

    public static /* synthetic */ Bitmap createRoundedCornersOverlay$default(Bitmaps bitmaps, int i, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -16776961;
        }
        if ((i4 & 8) != 0) {
            f = 50.0f;
        }
        return bitmaps.createRoundedCornersOverlay(i, i2, i3, f);
    }

    public final Bitmap createRoundedCornersOverlay(int i, int i2, int i3, float f) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i3);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint2.setAntiAlias(true);
        Rect rect = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(rect, paint);
        canvas.drawRoundRect(new RectF(rect), f, f, paint2);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createCircularOverlay$default(Bitmaps bitmaps, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -16776961;
        }
        return bitmaps.createCircularOverlay(i, i2, i3);
    }

    public final Bitmap createCircularOverlay(int i, int i2, int i3) {
        int i4;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i3);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint2.setAntiAlias(true);
        Rect rect = new Rect(0, 0, i, i2);
        if (i > i2) {
            i4 = i2 / 2;
        } else {
            i4 = i / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(rect, paint);
        canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) i4, paint2);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public static /* synthetic */ File save$default(Bitmaps bitmaps, Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if ((i2 & 8) != 0) {
            i = 100;
        }
        return bitmaps.save(bitmap, file, compressFormat, i);
    }

    @Deprecated(message = "Deprecated because of ambiguous name")
    public final File save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(file, "destinationFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static /* synthetic */ File saveToFile$default(Bitmaps bitmaps, Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if ((i2 & 8) != 0) {
            i = 100;
        }
        return bitmaps.saveToFile(bitmap, file, compressFormat, i);
    }

    public final File saveToFile(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(file, "destinationFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(compressFormat, i, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        bitmap.recycle();
        return file;
    }

    public static /* synthetic */ File saveToFileSafely$default(Bitmaps bitmaps, Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if ((i2 & 8) != 0) {
            i = 100;
        }
        return bitmaps.saveToFileSafely(bitmap, file, compressFormat, i);
    }

    public final File saveToFileSafely(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(file, "destinationFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        try {
            return saveToFile(bitmap, file, compressFormat, i);
        } catch (Exception e) {
            e.printStackTrace();
            return file;
        }
    }
}
