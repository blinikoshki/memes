package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$bKbtDH-u_QKCKrOHwO53RHdbHaY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY implements Consumer {
    public static final /* synthetic */ $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY INSTANCE = new $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY();

    private /* synthetic */ $$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY() {
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRestored();
    }
}
