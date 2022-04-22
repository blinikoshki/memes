package com.facebook.drawee.interfaces;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public interface DraweeHierarchy {
    Rect getBounds();

    Drawable getTopLevelDrawable();
}
