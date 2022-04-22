package com.getstream.sdk.chat.utils.exomedia.core.exoplayer;

import com.google.android.exoplayer2.Timeline;

public class WindowInfo {
    public final Timeline.Window currentWindow;
    public final int currentWindowIndex;
    public final int nextWindowIndex;
    public final int previousWindowIndex;

    public WindowInfo(int i, int i2, int i3, Timeline.Window window) {
        this.previousWindowIndex = i;
        this.currentWindowIndex = i2;
        this.nextWindowIndex = i3;
        this.currentWindow = window;
    }
}
