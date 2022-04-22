package com.giphy.sdk.p013ui.ads;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/ads/AdPillDrawer;", "", "context", "Landroid/content/Context;", "size", "Lcom/giphy/sdk/ui/ads/AdPillSize;", "animate", "", "(Landroid/content/Context;Lcom/giphy/sdk/ui/ads/AdPillSize;Z)V", "getAnimate", "()Z", "bounds", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "drawable", "Landroid/graphics/drawable/Drawable;", "fadeInAnimator", "Landroid/animation/ValueAnimator;", "height", "", "offset", "getSize", "()Lcom/giphy/sdk/ui/ads/AdPillSize;", "width", "cancelAnimation", "", "draw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.ads.AdPillDrawer */
/* compiled from: AdPillDrawer.kt */
public final class AdPillDrawer {
    private final boolean animate;
    private Rect bounds;
    private final Context context;
    /* access modifiers changed from: private */
    public final Drawable drawable;
    private ValueAnimator fadeInAnimator;
    private final int height;
    private final int offset = IntExtensionsKt.getPx(5);
    private final AdPillSize size;
    private final int width;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.ads.AdPillDrawer$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdPillSize.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AdPillSize.LARGE.ordinal()] = 1;
            iArr[AdPillSize.SMALL.ordinal()] = 2;
            iArr[AdPillSize.STICKER_TRAY.ordinal()] = 3;
        }
    }

    public AdPillDrawer(Context context2, AdPillSize adPillSize, boolean z) {
        int i;
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(adPillSize, "size");
        this.context = context2;
        this.size = adPillSize;
        this.animate = z;
        int i2 = WhenMappings.$EnumSwitchMapping$0[adPillSize.ordinal()];
        if (i2 == 1) {
            this.width = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_large_width);
            this.height = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_large_height);
            i = C1800R.C1802drawable.gph_ad_pill_large;
        } else if (i2 == 2) {
            this.width = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_small_width);
            this.height = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_small_height);
            i = C1800R.C1802drawable.gph_ad_pill_small;
        } else if (i2 == 3) {
            this.width = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_sticker_tray_width);
            this.height = context2.getResources().getDimensionPixelSize(C1800R.dimen.gph_ad_pill_sticker_tray_height);
            i = C1800R.C1802drawable.gph_ad_pill_sticker_tray;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Drawable drawable2 = ContextCompat.getDrawable(context2, i);
        if (drawable2 == null) {
            Intrinsics.throwNpe();
        }
        Drawable mutate = drawable2.mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate, "ContextCompat.getDrawabl…illDrawableId)!!.mutate()");
        this.drawable = mutate;
        if (z) {
            startAnimation();
        }
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    public final Context getContext() {
        return this.context;
    }

    public final AdPillSize getSize() {
        return this.size;
    }

    private final void startAnimation() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0, 255});
        this.fadeInAnimator = ofInt;
        if (ofInt != null) {
            ofInt.addUpdateListener(new AdPillDrawer$startAnimation$1(this));
        }
        ValueAnimator valueAnimator = this.fadeInAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(800);
        }
        ValueAnimator valueAnimator2 = this.fadeInAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    public final void cancelAnimation() {
        ValueAnimator valueAnimator = this.fadeInAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void draw(Canvas canvas) {
        if (this.bounds == null && canvas != null) {
            int i = this.offset;
            int i2 = canvas.getClipBounds().bottom - this.height;
            int i3 = this.offset;
            Rect rect = new Rect(i, i2 - i3, i3 + this.width, canvas.getClipBounds().bottom - this.offset);
            this.bounds = rect;
            this.drawable.setBounds(rect);
        }
        this.drawable.draw(canvas);
    }
}
