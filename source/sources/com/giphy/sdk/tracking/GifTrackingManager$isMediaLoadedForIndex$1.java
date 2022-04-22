package com.giphy.sdk.tracking;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: GifTrackingManager.kt */
final class GifTrackingManager$isMediaLoadedForIndex$1 extends FunctionReference implements Function0<Unit> {
    GifTrackingManager$isMediaLoadedForIndex$1(GifTrackingManager gifTrackingManager) {
        super(0, gifTrackingManager);
    }

    public final String getName() {
        return "updateTracking";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GifTrackingManager.class);
    }

    public final String getSignature() {
        return "updateTracking()V";
    }

    public final void invoke() {
        ((GifTrackingManager) this.receiver).updateTracking();
    }
}
