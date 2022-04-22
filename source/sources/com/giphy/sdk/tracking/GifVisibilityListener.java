package com.giphy.sdk.tracking;

import android.view.View;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, mo26107d2 = {"Lcom/giphy/sdk/tracking/GifVisibilityListener;", "", "onVisible", "", "position", "", "media", "Lcom/giphy/sdk/core/models/Media;", "view", "Landroid/view/View;", "visiblePercent", "", "reset", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GifVisibilityListener.kt */
public interface GifVisibilityListener {
    void onVisible(int i, Media media, View view, float f);

    void reset();
}
