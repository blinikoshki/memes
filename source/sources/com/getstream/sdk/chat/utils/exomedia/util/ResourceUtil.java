package com.getstream.sdk.chat.utils.exomedia.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.graphics.drawable.DrawableCompat;

public class ResourceUtil {
    public static Drawable tint(Context context, int i, int i2) {
        return tint(context, getDrawable(context, i).mutate(), i2);
    }

    public static Drawable tint(Context context, Drawable drawable, int i) {
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrap, getColor(context, i));
        return wrap;
    }

    public static Drawable tintList(Context context, int i, int i2) {
        return tintList(context, getDrawable(context, i).mutate(), i2);
    }

    public static Drawable tintList(Context context, Drawable drawable, int i) {
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrap, getColorStateList(context, i));
        return wrap;
    }

    public static Drawable getDrawable(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(i, context.getTheme());
        }
        return AppCompatDrawableManager.get().getDrawable(context, i);
    }

    public static int getResolvedResourceId(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        if (typedValue.type == 1) {
            return typedValue.data;
        }
        return typedValue.resourceId;
    }

    public static int getColor(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(i, context.getTheme());
        }
        return context.getResources().getColor(i);
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColorStateList(i, context.getTheme());
        }
        return context.getResources().getColorStateList(i);
    }
}
