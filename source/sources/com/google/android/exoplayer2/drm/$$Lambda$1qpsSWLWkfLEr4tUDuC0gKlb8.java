package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$1qpsSWLWkfLEr4-tUDu-C0gKlb8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$1qpsSWLWkfLEr4tUDuC0gKlb8 implements Consumer {
    public static final /* synthetic */ $$Lambda$1qpsSWLWkfLEr4tUDuC0gKlb8 INSTANCE = new $$Lambda$1qpsSWLWkfLEr4tUDuC0gKlb8();

    private /* synthetic */ $$Lambda$1qpsSWLWkfLEr4tUDuC0gKlb8() {
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionReleased();
    }
}
