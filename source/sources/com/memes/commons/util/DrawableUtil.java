package com.memes.commons.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\b\u001a\u00020\tJ$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\tJ\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u000b\u001a\u00020\t¨\u0006\f"}, mo26107d2 = {"Lcom/memes/commons/util/DrawableUtil;", "", "()V", "tint", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "newDrawable", "colorRes", "", "drawableRes", "resolvedColor", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DrawableUtil.kt */
public final class DrawableUtil {
    public static final DrawableUtil INSTANCE = new DrawableUtil();

    private DrawableUtil() {
    }

    public final Drawable tint(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return tint(context, context.getDrawable(i), i2);
    }

    public final Drawable tint(Context context, Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return tint(drawable, ContextCompat.getColor(context, i));
    }

    public final Drawable tint(Drawable drawable, int i) {
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        if (mutate != null) {
            mutate.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
        return drawable;
    }
}
