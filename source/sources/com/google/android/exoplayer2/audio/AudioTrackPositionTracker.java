package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private float audioTrackPlaybackSpeed;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPosition;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private boolean notifiedPositionIncreasing;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j);

        void onPositionAdvancing(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    public AudioTrackPositionTracker(Listener listener2) {
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    public void setAudioTrack(AudioTrack audioTrack2, boolean z, int i, int i2, int i3) {
        this.audioTrack = audioTrack2;
        this.outputPcmFrameSize = i2;
        this.bufferSize = i3;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack2);
        this.outputSampleRate = audioTrack2.getSampleRate();
        this.needsPassthroughWorkarounds = z && needsPassthroughWorkarounds(i);
        boolean isEncodingLinearPcm = Util.isEncodingLinearPcm(i);
        this.isOutputPcm = isEncodingLinearPcm;
        this.bufferSizeUs = isEncodingLinearPcm ? framesToDurationUs((long) (i3 / i2)) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0;
        this.rawPlaybackHeadWrapCount = 0;
        this.passthroughWorkaroundPauseOffset = 0;
        this.hasData = false;
        this.stopTimestampUs = C1844C.TIME_UNSET;
        this.forceResetWorkaroundTimeMs = C1844C.TIME_UNSET;
        this.lastLatencySampleTimeUs = 0;
        this.latencyUs = 0;
        this.audioTrackPlaybackSpeed = 1.0f;
    }

    public void setAudioTrackPlaybackSpeed(float f) {
        this.audioTrackPlaybackSpeed = f;
        AudioTimestampPoller audioTimestampPoller2 = this.audioTimestampPoller;
        if (audioTimestampPoller2 != null) {
            audioTimestampPoller2.reset();
        }
    }

    public long getCurrentPositionUs(boolean z) {
        long j;
        if (((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller2 = (AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller);
        boolean hasAdvancingTimestamp = audioTimestampPoller2.hasAdvancingTimestamp();
        if (hasAdvancingTimestamp) {
            j = framesToDurationUs(audioTimestampPoller2.getTimestampPositionFrames()) + Util.getMediaDurationForPlayoutDuration(nanoTime - audioTimestampPoller2.getTimestampSystemTimeUs(), this.audioTrackPlaybackSpeed);
        } else {
            if (this.playheadOffsetCount == 0) {
                j = getPlaybackHeadPositionUs();
            } else {
                j = this.smoothedPlayheadOffsetUs + nanoTime;
            }
            if (!z) {
                j = Math.max(0, j - this.latencyUs);
            }
        }
        if (this.lastSampleUsedGetTimestampMode != hasAdvancingTimestamp) {
            this.previousModeSystemTimeUs = this.lastSystemTimeUs;
            this.previousModePositionUs = this.lastPositionUs;
        }
        long j2 = nanoTime - this.previousModeSystemTimeUs;
        if (j2 < 1000000) {
            long j3 = (j2 * 1000) / 1000000;
            j = ((j * j3) + ((1000 - j3) * (this.previousModePositionUs + Util.getMediaDurationForPlayoutDuration(j2, this.audioTrackPlaybackSpeed)))) / 1000;
        }
        if (!this.notifiedPositionIncreasing) {
            long j4 = this.lastPositionUs;
            if (j > j4) {
                this.notifiedPositionIncreasing = true;
                this.listener.onPositionAdvancing(System.currentTimeMillis() - C1844C.usToMs(Util.getPlayoutDurationForMediaDuration(C1844C.usToMs(j - j4), this.audioTrackPlaybackSpeed)));
            }
        }
        this.lastSystemTimeUs = nanoTime;
        this.lastPositionUs = j;
        this.lastSampleUsedGetTimestampMode = hasAdvancingTimestamp;
        return j;
    }

    public void start() {
        ((AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller)).reset();
    }

    public boolean isPlaying() {
        return ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 3;
    }

    public boolean mayHandleBuffer(long j) {
        int playState = ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            } else if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z = this.hasData;
        boolean hasPendingData = hasPendingData(j);
        this.hasData = hasPendingData;
        if (z && !hasPendingData && playState != 1) {
            this.listener.onUnderrun(this.bufferSize, C1844C.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public int getAvailableBufferSize(long j) {
        return this.bufferSize - ((int) (j - (getPlaybackHeadPosition() * ((long) this.outputPcmFrameSize))));
    }

    public long getPendingBufferDurationMs(long j) {
        return C1844C.usToMs(framesToDurationUs(j - getPlaybackHeadPosition()));
    }

    public boolean isStalled(long j) {
        return this.forceResetWorkaroundTimeMs != C1844C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200;
    }

    public void handleEndOfStream(long j) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j;
    }

    public boolean hasPendingData(long j) {
        return j > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != C1844C.TIME_UNSET) {
            return false;
        }
        ((AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller)).reset();
        return true;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
                long[] jArr = this.playheadOffsets;
                int i = this.nextPlayheadOffsetIndex;
                jArr[i] = playbackHeadPositionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (i + 1) % 10;
                int i2 = this.playheadOffsetCount;
                if (i2 < 10) {
                    this.playheadOffsetCount = i2 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.playheadOffsetCount;
                    if (i3 >= i4) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / ((long) i4);
                    i3++;
                }
            }
            if (!this.needsPassthroughWorkarounds) {
                maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
                maybeUpdateLatency(nanoTime);
            }
        }
    }

    private void maybePollAndCheckTimestamp(long j, long j2) {
        AudioTimestampPoller audioTimestampPoller2 = (AudioTimestampPoller) Assertions.checkNotNull(this.audioTimestampPoller);
        if (audioTimestampPoller2.maybePollTimestamp(j)) {
            long timestampSystemTimeUs = audioTimestampPoller2.getTimestampSystemTimeUs();
            long timestampPositionFrames = audioTimestampPoller2.getTimestampPositionFrames();
            if (Math.abs(timestampSystemTimeUs - j) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j, j2);
                audioTimestampPoller2.rejectTimestamp();
            } else if (Math.abs(framesToDurationUs(timestampPositionFrames) - j2) > 5000000) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j, j2);
                audioTimestampPoller2.rejectTimestamp();
            } else {
                audioTimestampPoller2.acceptTimestamp();
            }
        }
    }

    private void maybeUpdateLatency(long j) {
        Method method;
        if (this.isOutputPcm && (method = this.getLatencyMethod) != null && j - this.lastLatencySampleTimeUs >= 500000) {
            try {
                long intValue = (((long) ((Integer) Util.castNonNull((Integer) method.invoke(Assertions.checkNotNull(this.audioTrack), new Object[0]))).intValue()) * 1000) - this.bufferSizeUs;
                this.latencyUs = intValue;
                long max = Math.max(intValue, 0);
                this.latencyUs = max;
                if (max > 5000000) {
                    this.listener.onInvalidLatency(max);
                    this.latencyUs = 0;
                }
            } catch (Exception unused) {
                this.getLatencyMethod = null;
            }
            this.lastLatencySampleTimeUs = j;
        }
    }

    private long framesToDurationUs(long j) {
        return (j * 1000000) / ((long) this.outputSampleRate);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0;
        this.lastSystemTimeUs = 0;
        this.previousModeSystemTimeUs = 0;
        this.notifiedPositionIncreasing = false;
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && ((AudioTrack) Assertions.checkNotNull(this.audioTrack)).getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private static boolean needsPassthroughWorkarounds(int i) {
        return Util.SDK_INT < 23 && (i == 5 || i == 6);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private long getPlaybackHeadPosition() {
        AudioTrack audioTrack2 = (AudioTrack) Assertions.checkNotNull(this.audioTrack);
        if (this.stopTimestampUs != C1844C.TIME_UNSET) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * ((long) this.outputSampleRate)) / 1000000));
        }
        int playState = audioTrack2.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack2.getPlaybackHeadPosition());
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == C1844C.TIME_UNSET) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = C1844C.TIME_UNSET;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }
}
