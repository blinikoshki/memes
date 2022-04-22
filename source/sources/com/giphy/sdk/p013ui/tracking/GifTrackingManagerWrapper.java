package com.giphy.sdk.p013ui.tracking;

import androidx.lifecycle.ViewModel;
import com.giphy.sdk.tracking.GifTrackingManager;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/tracking/GifTrackingManagerWrapper;", "Landroidx/lifecycle/ViewModel;", "()V", "gifTrackingManager", "Lcom/giphy/sdk/tracking/GifTrackingManager;", "getGifTrackingManager", "()Lcom/giphy/sdk/tracking/GifTrackingManager;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.tracking.GifTrackingManagerWrapper */
/* compiled from: GifTrackingManagerWrapper.kt */
public final class GifTrackingManagerWrapper extends ViewModel {
    private final GifTrackingManager gifTrackingManager = new GifTrackingManager(false, 1, (DefaultConstructorMarker) null);

    public final GifTrackingManager getGifTrackingManager() {
        return this.gifTrackingManager;
    }
}
