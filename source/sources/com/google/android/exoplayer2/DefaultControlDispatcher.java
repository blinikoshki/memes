package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

public class DefaultControlDispatcher implements ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    private static final int MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline.Window window;

    public DefaultControlDispatcher() {
        this(15000, 5000);
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.fastForwardIncrementMs = j;
        this.rewindIncrementMs = j2;
        this.window = new Timeline.Window();
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    public boolean dispatchSeekTo(Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    public boolean dispatchPrevious(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int previousWindowIndex = player.getPreviousWindowIndex();
            if (previousWindowIndex == -1 || (player.getCurrentPosition() > 3000 && (!this.window.isDynamic || this.window.isSeekable))) {
                player.seekTo(currentWindowIndex, 0);
            } else {
                player.seekTo(previousWindowIndex, C1844C.TIME_UNSET);
            }
        }
        return true;
    }

    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, C1844C.TIME_UNSET);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.window).isLive) {
                player.seekTo(currentWindowIndex, C1844C.TIME_UNSET);
            }
        }
        return true;
    }

    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, -this.rewindIncrementMs);
        return true;
    }

    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, this.fastForwardIncrementMs);
        return true;
    }

    public boolean dispatchSetRepeatMode(Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    public boolean dispatchStop(Player player, boolean z) {
        player.stop(z);
        return true;
    }

    public boolean isRewindEnabled() {
        return this.rewindIncrementMs > 0;
    }

    public boolean isFastForwardEnabled() {
        return this.fastForwardIncrementMs > 0;
    }

    public long getRewindIncrementMs() {
        return this.rewindIncrementMs;
    }

    public long getFastForwardIncrementMs() {
        return this.fastForwardIncrementMs;
    }

    @Deprecated
    public void setRewindIncrementMs(long j) {
        this.rewindIncrementMs = j;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long j) {
        this.fastForwardIncrementMs = j;
    }

    private static void seekToOffset(Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != C1844C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0));
    }
}
