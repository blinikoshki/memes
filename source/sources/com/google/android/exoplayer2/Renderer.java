package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Renderer extends PlayerMessage.Target {
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_SET_AUDIO_ATTRIBUTES = 3;
    public static final int MSG_SET_AUDIO_SESSION_ID = 102;
    public static final int MSG_SET_AUX_EFFECT_INFO = 5;
    public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
    public static final int MSG_SET_SCALING_MODE = 4;
    public static final int MSG_SET_SKIP_SILENCE_ENABLED = 101;
    public static final int MSG_SET_SURFACE = 1;
    public static final int MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER = 8;
    public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
    public static final int MSG_SET_VOLUME = 2;
    public static final int MSG_SET_WAKEUP_LISTENER = 103;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;
    public static final int VIDEO_SCALING_MODE_DEFAULT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    /* renamed from: com.google.android.exoplayer2.Renderer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setOperatingRate(Renderer renderer, float f) throws ExoPlaybackException {
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    public interface WakeupListener {
        void onSleep(long j);

        void onWakeup();
    }

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException;

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j, long j2) throws ExoPlaybackException;

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int i);

    void setOperatingRate(float f) throws ExoPlaybackException;

    void start() throws ExoPlaybackException;

    void stop();
}
