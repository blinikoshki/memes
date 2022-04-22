package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI implements Consumer {
    public static final /* synthetic */ $$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI INSTANCE = new $$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI();

    private /* synthetic */ $$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI() {
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRemoved();
    }
}
