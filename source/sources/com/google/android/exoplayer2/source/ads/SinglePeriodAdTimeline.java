package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
        super(timeline);
        boolean z = false;
        Assertions.checkState(timeline.getPeriodCount() == 1);
        Assertions.checkState(timeline.getWindowCount() == 1 ? true : z);
        this.adPlaybackState = adPlaybackState2;
    }

    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        period.set(period.f196id, period.uid, period.windowIndex, period.durationUs == C1844C.TIME_UNSET ? this.adPlaybackState.contentDurationUs : period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState);
        return period;
    }
}
