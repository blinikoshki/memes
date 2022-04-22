package com.facebook.fresco.p010ui.common;

import com.facebook.fresco.p010ui.common.ControllerListener2;
import javax.annotation.Nullable;

@Deprecated
/* renamed from: com.facebook.fresco.ui.common.BaseControllerListener2 */
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {
    private static final ControllerListener2 NO_OP_LISTENER = new BaseControllerListener2();

    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
    }

    public void onFinalImageSet(String str, @Nullable INFO info, ControllerListener2.Extras extras) {
    }

    public void onIntermediateImageFailed(String str) {
    }

    public void onIntermediateImageSet(String str, @Nullable INFO info) {
    }

    public void onRelease(String str, ControllerListener2.Extras extras) {
    }

    public void onSubmit(String str, Object obj, @Nullable ControllerListener2.Extras extras) {
    }

    public static <I> ControllerListener2<I> getNoOpListener() {
        return NO_OP_LISTENER;
    }
}
