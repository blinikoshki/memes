package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$FHdePZbX29tMQI2hkEItev2KViw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FHdePZbX29tMQI2hkEItev2KViw implements Consumer {
    public static final /* synthetic */ $$Lambda$FHdePZbX29tMQI2hkEItev2KViw INSTANCE = new $$Lambda$FHdePZbX29tMQI2hkEItev2KViw();

    private /* synthetic */ $$Lambda$FHdePZbX29tMQI2hkEItev2KViw() {
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionAcquired();
    }
}
