package com.giphy.sdk.tracking;

import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, mo26107d2 = {"Lcom/giphy/sdk/tracking/GifTrackingCallback;", "", "isMediaLoadedForIndex", "", "position", "", "onLoad", "Lkotlin/Function0;", "", "mediaForIndex", "Lcom/giphy/sdk/core/models/Media;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GifTrackingCallback.kt */
public interface GifTrackingCallback {
    boolean isMediaLoadedForIndex(int i, Function0<Unit> function0);

    Media mediaForIndex(int i);
}
