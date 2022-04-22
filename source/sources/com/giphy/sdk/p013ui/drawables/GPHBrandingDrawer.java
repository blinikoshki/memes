package com.giphy.sdk.p013ui.drawables;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0012R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/GPHBrandingDrawer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "bounds", "Landroid/graphics/Rect;", "brandingHeight", "", "getContext", "()Landroid/content/Context;", "drawable", "Landroid/graphics/drawable/Drawable;", "offset", "draw", "", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.GPHBrandingDrawer */
/* compiled from: GPHBrandingDrawer.kt */
public final class GPHBrandingDrawer {
    private ValueAnimator alphaAnimator = ValueAnimator.ofInt(new int[]{255, 0});
    private Rect bounds;
    private final int brandingHeight = IntExtensionsKt.getPx(12);
    private final Context context;
    /* access modifiers changed from: private */
    public final Drawable drawable;
    private final int offset = IntExtensionsKt.getPx(10);

    public GPHBrandingDrawer(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        Drawable drawable2 = ContextCompat.getDrawable(context2, C1800R.C1802drawable.gph_gif_branding);
        if (drawable2 == null) {
            Intrinsics.throwNpe();
        }
        Drawable mutate = drawable2.mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate, "ContextCompat.getDrawabl…_gif_branding)!!.mutate()");
        this.drawable = mutate;
        mutate.setAlpha(0);
        ValueAnimator valueAnimator = this.alphaAnimator;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "alphaAnimator");
        valueAnimator.setDuration(800);
        ValueAnimator valueAnimator2 = this.alphaAnimator;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "alphaAnimator");
        valueAnimator2.setStartDelay(1000);
    }

    public final Context getContext() {
        return this.context;
    }

    public final void startAnimation() {
        Timber.m300d("startAnimation", new Object[0]);
        this.drawable.setAlpha(255);
        ValueAnimator valueAnimator = this.alphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.alphaAnimator.addUpdateListener(new GPHBrandingDrawer$startAnimation$1(this));
        this.alphaAnimator.start();
    }

    public final void draw(Canvas canvas) {
        if (this.bounds == null && canvas != null) {
            Rect rect = new Rect((canvas.getClipBounds().right - this.offset) - ((this.drawable.getIntrinsicWidth() / this.drawable.getIntrinsicHeight()) * this.brandingHeight), (canvas.getClipBounds().bottom - this.brandingHeight) - this.offset, canvas.getClipBounds().right - this.offset, canvas.getClipBounds().bottom - this.offset);
            this.bounds = rect;
            this.drawable.setBounds(rect);
        }
        this.drawable.draw(canvas);
    }
}
