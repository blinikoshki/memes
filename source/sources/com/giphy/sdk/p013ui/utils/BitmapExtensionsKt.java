package com.giphy.sdk.p013ui.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"tintedWithColor", "Landroid/graphics/Bitmap;", "color", "", "tintedWithLinearGradientColors", "colors", "", "ui-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.BitmapExtensionsKt */
/* compiled from: BitmapExtensions.kt */
public final class BitmapExtensionsKt {
    public static final Bitmap tintedWithLinearGradientColors(Bitmap bitmap, int[] iArr) {
        Bitmap bitmap2 = bitmap;
        int[] iArr2 = iArr;
        Intrinsics.checkParameterIsNotNull(bitmap2, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, "colors");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "updatedBitmap");
        createBitmap.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 100.0f, 100.0f, 0.0f, iArr2[0], iArr2[1], Shader.TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
        return createBitmap;
    }

    public static final Bitmap tintedWithColor(Bitmap bitmap, int i) {
        Intrinsics.checkParameterIsNotNull(bitmap, "receiver$0");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "updatedBitmap");
        createBitmap.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
