package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.jetbrains.anko.DimensionsKt;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, DimensionsKt.XXXHDPI, 540, DimensionsKt.XXHDPI};
    private static final int SURFACE_FRAME_RATE_COMPATIBILITY_DEFAULT = 0;
    private static final int SURFACE_FRAME_RATE_COMPATIBILITY_FIXED_SOURCE = 1;
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private static final Method surfaceSetFrameRateMethod;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private float currentFrameRate;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private float surfaceFrameRate;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public String getName() {
        return TAG;
    }

    static {
        Method method;
        if (Util.SDK_INT >= 30) {
            Class<Surface> cls = Surface.class;
            try {
                method = cls.getMethod("setFrameRate", new Class[]{Float.TYPE, Integer.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            surfaceSetFrameRateMethod = method;
        }
        method = null;
        surfaceSetFrameRateMethod = method;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, (Handler) null, (VideoRendererEventListener) null, -1);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, z, 30.0f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = C1844C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(0);
        }
        boolean z = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.CC.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.CC.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.CC.create(isFormatSupported ? 4 : 3, i2, i);
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, z, this.tunneling);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, z2), format);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 16 || intValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(MimeTypes.VIDEO_H265, z, z2));
            } else if (intValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(MimeTypes.VIDEO_H264, z, z2));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        int i = this.tunnelingAudioSessionId;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i2;
        this.tunneling = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.initialPositionUs = C1844C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C1844C.TIME_UNSET;
        }
    }

    public boolean isReady() {
        Surface surface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C1844C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C1844C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C1844C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        updateSurfaceFrameRate(false);
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = C1844C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        clearSurfaceFrameRate();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                surface2.release();
                this.dummySurface = null;
            }
        } catch (Throwable th) {
            if (this.dummySurface != null) {
                Surface surface3 = this.surface;
                Surface surface4 = this.dummySurface;
                if (surface3 == surface4) {
                    this.surface = null;
                }
                surface4.release();
                this.dummySurface = null;
            }
            throw th;
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface2) throws ExoPlaybackException {
        if (surface2 == null) {
            Surface surface3 = this.dummySurface;
            if (surface3 != null) {
                surface2 = surface3;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface2 = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface2;
                }
            }
        }
        if (this.surface != surface2) {
            clearSurfaceFrameRate();
            this.surface = surface2;
            this.haveReportedFirstFrameRenderedForCurrentSurface = false;
            updateSurfaceFrameRate(true);
            int state = getState();
            MediaCodec codec = getCodec();
            if (codec != null) {
                if (Util.SDK_INT < 23 || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodecOrBypass();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    /* access modifiers changed from: protected */
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            if (shouldUseDummySurface(mediaCodecInfo)) {
                if (this.dummySurface == null) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.dummySurface;
            } else {
                throw new IllegalStateException();
            }
        }
        mediaCodecAdapter.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodecAdapter.getCodec());
        }
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true) || format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 3 : 2;
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setOperatingRate(float f) throws ExoPlaybackException {
        super.setOperatingRate(f);
        updateSurfaceFrameRate(false);
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format);
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int i;
        int i2;
        MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            this.currentWidth = format.width;
            this.currentHeight = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                i = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            }
            this.currentWidth = i;
            if (z) {
                i2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            }
            this.currentHeight = i2;
        }
        this.currentPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        if (Util.SDK_INT < 21) {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        } else if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
            int i3 = this.currentWidth;
            this.currentWidth = this.currentHeight;
            this.currentHeight = i3;
            this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
        }
        this.currentFrameRate = format.frameRate;
        updateSurfaceFrameRate(false);
    }

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        if (shouldForceRenderOutputBuffer(r1, r13) != false) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processOutputBuffer(long r26, long r28, android.media.MediaCodec r30, java.nio.ByteBuffer r31, int r32, int r33, int r34, long r35, boolean r37, boolean r38, com.google.android.exoplayer2.Format r39) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r25 = this;
            r8 = r25
            r6 = r26
            r9 = r30
            r10 = r32
            r0 = r35
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r30)
            long r2 = r8.initialPositionUs
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x001a
            r8.initialPositionUs = r6
        L_0x001a:
            long r2 = r25.getOutputStreamOffsetUs()
            long r11 = r0 - r2
            r13 = 1
            if (r37 == 0) goto L_0x0029
            if (r38 != 0) goto L_0x0029
            r8.skipOutputBuffer(r9, r10, r11)
            return r13
        L_0x0029:
            long r14 = r0 - r6
            android.view.Surface r4 = r8.surface
            android.view.Surface r5 = r8.dummySurface
            r16 = 0
            if (r4 != r5) goto L_0x0041
            boolean r0 = isBufferLate(r14)
            if (r0 == 0) goto L_0x0040
            r8.skipOutputBuffer(r9, r10, r11)
            r8.updateVideoFrameProcessingOffsetCounters(r14)
            return r13
        L_0x0040:
            return r16
        L_0x0041:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r17 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r17
            r19 = r14
            long r13 = r8.lastRenderTimeUs
            long r13 = r4 - r13
            int r15 = r25.getState()
            r0 = 2
            if (r15 != r0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            boolean r1 = r8.renderedFirstFrameAfterEnable
            if (r1 != 0) goto L_0x0064
            if (r0 != 0) goto L_0x0068
            boolean r1 = r8.mayRenderFirstFrameAfterEnableIfNotStarted
            if (r1 == 0) goto L_0x006c
            goto L_0x0068
        L_0x0064:
            boolean r1 = r8.renderedFirstFrameAfterReset
            if (r1 != 0) goto L_0x006c
        L_0x0068:
            r21 = r4
            r1 = 1
            goto L_0x006f
        L_0x006c:
            r21 = r4
            r1 = 0
        L_0x006f:
            long r4 = r8.joiningDeadlineMs
            r23 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r15 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r15 != 0) goto L_0x008f
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x008f
            if (r1 != 0) goto L_0x008b
            if (r0 == 0) goto L_0x008f
            r1 = r19
            boolean r3 = r8.shouldForceRenderOutputBuffer(r1, r13)
            if (r3 == 0) goto L_0x0091
            goto L_0x008d
        L_0x008b:
            r1 = r19
        L_0x008d:
            r3 = 1
            goto L_0x0092
        L_0x008f:
            r1 = r19
        L_0x0091:
            r3 = 0
        L_0x0092:
            r13 = 21
            if (r3 == 0) goto L_0x00bf
            long r3 = java.lang.System.nanoTime()
            r33 = r25
            r34 = r11
            r36 = r3
            r38 = r39
            r33.notifyFrameMetadataListener(r34, r36, r38)
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r0 < r13) goto L_0x00b7
            r33 = r25
            r34 = r30
            r35 = r32
            r36 = r11
            r38 = r3
            r33.renderOutputBufferV21(r34, r35, r36, r38)
            goto L_0x00ba
        L_0x00b7:
            r8.renderOutputBuffer(r9, r10, r11)
        L_0x00ba:
            r8.updateVideoFrameProcessingOffsetCounters(r1)
        L_0x00bd:
            r0 = 1
            return r0
        L_0x00bf:
            if (r0 == 0) goto L_0x0187
            long r3 = r8.initialPositionUs
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00c9
            goto L_0x0187
        L_0x00c9:
            long r4 = r21 - r28
            long r14 = r1 - r4
            long r0 = java.lang.System.nanoTime()
            long r14 = r14 * r17
            long r14 = r14 + r0
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper r2 = r8.frameReleaseTimeHelper
            r3 = r35
            long r14 = r2.adjustReleaseTime(r3, r14)
            long r0 = r14 - r0
            long r3 = r0 / r17
            long r0 = r8.joiningDeadlineMs
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r2 == 0) goto L_0x00ee
            r19 = 1
            goto L_0x00f0
        L_0x00ee:
            r19 = 0
        L_0x00f0:
            r0 = r25
            r1 = r3
            r20 = r3
            r3 = r28
            r5 = r38
            boolean r0 = r0.shouldDropBuffersToKeyframe(r1, r3, r5)
            if (r0 == 0) goto L_0x0111
            r0 = r25
            r1 = r30
            r2 = r32
            r3 = r11
            r5 = r26
            r7 = r19
            boolean r0 = r0.maybeDropBuffersToKeyframe(r1, r2, r3, r5, r7)
            if (r0 == 0) goto L_0x0111
            return r16
        L_0x0111:
            r0 = r25
            r1 = r20
            r3 = r28
            r5 = r38
            boolean r0 = r0.shouldDropOutputBuffer(r1, r3, r5)
            if (r0 == 0) goto L_0x012e
            if (r19 == 0) goto L_0x0125
            r8.skipOutputBuffer(r9, r10, r11)
            goto L_0x0128
        L_0x0125:
            r8.dropOutputBuffer(r9, r10, r11)
        L_0x0128:
            r0 = r20
            r8.updateVideoFrameProcessingOffsetCounters(r0)
            goto L_0x00bd
        L_0x012e:
            r0 = r20
            int r2 = com.google.android.exoplayer2.util.Util.SDK_INT
            if (r2 < r13) goto L_0x0156
            r2 = 50000(0xc350, double:2.47033E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0187
            r33 = r25
            r34 = r11
            r36 = r14
            r38 = r39
            r33.notifyFrameMetadataListener(r34, r36, r38)
            r34 = r30
            r35 = r32
            r36 = r11
            r38 = r14
            r33.renderOutputBufferV21(r34, r35, r36, r38)
            r8.updateVideoFrameProcessingOffsetCounters(r0)
            goto L_0x00bd
        L_0x0156:
            r2 = 30000(0x7530, double:1.4822E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0187
            r2 = 11000(0x2af8, double:5.4347E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0174
            r2 = 10000(0x2710, double:4.9407E-320)
            long r3 = r0 - r2
            long r3 = r3 / r17
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x016c }
            goto L_0x0174
        L_0x016c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            return r16
        L_0x0174:
            r33 = r25
            r34 = r11
            r36 = r14
            r38 = r39
            r33.notifyFrameMetadataListener(r34, r36, r38)
            r8.renderOutputBuffer(r9, r10, r11)
            r8.updateVideoFrameProcessingOffsetCounters(r0)
            goto L_0x00bd
        L_0x0187:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.processOutputBuffer(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        int i2 = this.buffersInCodecCount + skipSource;
        if (z) {
            this.decoderCounters.skippedOutputBufferCount += i2;
        } else {
            updateDroppedBufferCounters(i2);
        }
        flushOrReinitializeCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i) {
        this.decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        this.consecutiveDroppedFrameCount += i;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 > 0 && this.droppedFrames >= i2) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private void updateSurfaceFrameRate(boolean z) {
        Surface surface2;
        if (Util.SDK_INT >= 30 && (surface2 = this.surface) != null && surface2 != this.dummySurface) {
            float operatingRate = getState() == 2 && (this.currentFrameRate > -1.0f ? 1 : (this.currentFrameRate == -1.0f ? 0 : -1)) != 0 ? this.currentFrameRate * getOperatingRate() : 0.0f;
            if (this.surfaceFrameRate != operatingRate || z) {
                this.surfaceFrameRate = operatingRate;
                setSurfaceFrameRateV30(this.surface, operatingRate);
            }
        }
    }

    private void clearSurfaceFrameRate() {
        Surface surface2;
        if (Util.SDK_INT >= 30 && (surface2 = this.surface) != null && surface2 != this.dummySurface && this.surfaceFrameRate != 0.0f) {
            this.surfaceFrameRate = 0.0f;
            setSurfaceFrameRateV30(surface2, 0.0f);
        }
    }

    private void setSurfaceFrameRateV30(Surface surface2, float f) {
        Method method = surfaceSetFrameRateMethod;
        if (method == null) {
            Log.m354e(TAG, "Failed to call Surface.setFrameRate (method does not exist)");
        }
        try {
            method.invoke(surface2, new Object[]{Float.valueOf(f), Integer.valueOf(f == 0.0f ? 0 : 1)});
        } catch (Exception e) {
            Log.m355e(TAG, "Failed to call Surface.setFrameRate", e);
        }
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : C1844C.TIME_UNSET;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != i || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodec mediaCodec, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    /* access modifiers changed from: protected */
    public void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, format.width);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(Constants.FirelogAnalytics.PARAM_PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            Log.m358w(TAG, sb.toString());
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, i, i2));
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                Log.m358w(TAG, sb2.toString());
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.surface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x00a6
            if (r8 != r0) goto L_0x0007
            goto L_0x00a6
        L_0x0007:
            r6.hashCode()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r6 = -1
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r6 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r6 = 4
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r6 = 3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r6 = 2
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r6 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r6 = 0
        L_0x0057:
            switch(r6) {
                case 0: goto L_0x009d;
                case 1: goto L_0x009a;
                case 2: goto L_0x009d;
                case 3: goto L_0x005b;
                case 4: goto L_0x009d;
                case 5: goto L_0x009a;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r1 = "Amazon"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0088
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "KFSOWI"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x0099
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0088
            boolean r5 = r5.secure
            if (r5 == 0) goto L_0x0088
            goto L_0x0099
        L_0x0088:
            r5 = 16
            int r6 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r7, (int) r5)
            int r7 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r8, (int) r5)
            int r6 = r6 * r7
            int r6 = r6 * 16
            int r7 = r6 * 16
            goto L_0x009f
        L_0x0099:
            return r0
        L_0x009a:
            int r7 = r7 * r8
            goto L_0x00a0
        L_0x009d:
            int r7 = r7 * r8
        L_0x009f:
            r2 = 2
        L_0x00a0:
            int r7 = r7 * 3
            int r2 = r2 * 2
            int r7 = r7 / r2
            return r7
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* access modifiers changed from: protected */
    public Surface getSurface() {
        return this.surface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x07d3, code lost:
        if (r0.equals("CP8676_I02") == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x081d, code lost:
        if (r0.equals("AFTN") == false) goto L_0x0815;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x0839, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 4
            r2 = 3
            r3 = 28
            r4 = 2
            r5 = -1
            r6 = 0
            r7 = 1
            if (r0 > r3) goto L_0x0055
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r8 = r0.hashCode()
            switch(r8) {
                case -1339091551: goto L_0x0046;
                case -1220081023: goto L_0x003b;
                case -1220066608: goto L_0x0030;
                case -64886864: goto L_0x0025;
                case 825323514: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r0 = -1
            goto L_0x0050
        L_0x001a:
            java.lang.String r8 = "machuca"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0023
            goto L_0x0018
        L_0x0023:
            r0 = 4
            goto L_0x0050
        L_0x0025:
            java.lang.String r8 = "magnolia"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x002e
            goto L_0x0018
        L_0x002e:
            r0 = 3
            goto L_0x0050
        L_0x0030:
            java.lang.String r8 = "dangalUHD"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0039
            goto L_0x0018
        L_0x0039:
            r0 = 2
            goto L_0x0050
        L_0x003b:
            java.lang.String r8 = "dangalFHD"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0044
            goto L_0x0018
        L_0x0044:
            r0 = 1
            goto L_0x0050
        L_0x0046:
            java.lang.String r8 = "dangal"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x004f
            goto L_0x0018
        L_0x004f:
            r0 = 0
        L_0x0050:
            switch(r0) {
                case 0: goto L_0x0054;
                case 1: goto L_0x0054;
                case 2: goto L_0x0054;
                case 3: goto L_0x0054;
                case 4: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0055
        L_0x0054:
            return r7
        L_0x0055:
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r8 = 27
            if (r0 > r8) goto L_0x0066
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r9 = "HWEML"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0066
            return r7
        L_0x0066:
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r9 = 26
            if (r0 > r9) goto L_0x083a
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r10 = r0.hashCode()
            switch(r10) {
                case -2144781245: goto L_0x07fb;
                case -2144781185: goto L_0x07ef;
                case -2144781160: goto L_0x07e3;
                case -2097309513: goto L_0x07d7;
                case -2022874474: goto L_0x07cd;
                case -1978993182: goto L_0x07c1;
                case -1978990237: goto L_0x07b5;
                case -1936688988: goto L_0x07a9;
                case -1936688066: goto L_0x079c;
                case -1936688065: goto L_0x078e;
                case -1931988508: goto L_0x0780;
                case -1885099851: goto L_0x0772;
                case -1696512866: goto L_0x0764;
                case -1680025915: goto L_0x0756;
                case -1615810839: goto L_0x0748;
                case -1600724499: goto L_0x073a;
                case -1554255044: goto L_0x072c;
                case -1481772737: goto L_0x071e;
                case -1481772730: goto L_0x0710;
                case -1481772729: goto L_0x0702;
                case -1320080169: goto L_0x06f4;
                case -1217592143: goto L_0x06e6;
                case -1180384755: goto L_0x06d8;
                case -1139198265: goto L_0x06ca;
                case -1052835013: goto L_0x06bc;
                case -993250464: goto L_0x06ae;
                case -993250458: goto L_0x06a0;
                case -965403638: goto L_0x0692;
                case -958336948: goto L_0x0684;
                case -879245230: goto L_0x0676;
                case -842500323: goto L_0x0668;
                case -821392978: goto L_0x065a;
                case -797483286: goto L_0x064c;
                case -794946968: goto L_0x063e;
                case -788334647: goto L_0x0630;
                case -782144577: goto L_0x0622;
                case -575125681: goto L_0x0614;
                case -521118391: goto L_0x0606;
                case -430914369: goto L_0x05f8;
                case -290434366: goto L_0x05ea;
                case -282781963: goto L_0x05dc;
                case -277133239: goto L_0x05ce;
                case -173639913: goto L_0x05c0;
                case -56598463: goto L_0x05b2;
                case 2126: goto L_0x05a4;
                case 2564: goto L_0x0596;
                case 2715: goto L_0x0588;
                case 2719: goto L_0x057a;
                case 3091: goto L_0x056c;
                case 3483: goto L_0x055e;
                case 73405: goto L_0x0550;
                case 75537: goto L_0x0542;
                case 75739: goto L_0x0534;
                case 76779: goto L_0x0526;
                case 78669: goto L_0x0518;
                case 79305: goto L_0x050a;
                case 80618: goto L_0x04fc;
                case 88274: goto L_0x04ee;
                case 98846: goto L_0x04e0;
                case 98848: goto L_0x04d2;
                case 99329: goto L_0x04c4;
                case 101481: goto L_0x04b6;
                case 1513190: goto L_0x04a8;
                case 1514184: goto L_0x049a;
                case 1514185: goto L_0x048c;
                case 2133089: goto L_0x047e;
                case 2133091: goto L_0x0470;
                case 2133120: goto L_0x0462;
                case 2133151: goto L_0x0454;
                case 2133182: goto L_0x0446;
                case 2133184: goto L_0x0438;
                case 2436959: goto L_0x042a;
                case 2463773: goto L_0x041c;
                case 2464648: goto L_0x040e;
                case 2689555: goto L_0x0400;
                case 3154429: goto L_0x03f2;
                case 3284551: goto L_0x03e4;
                case 3351335: goto L_0x03d6;
                case 3386211: goto L_0x03c8;
                case 41325051: goto L_0x03ba;
                case 51349633: goto L_0x03ac;
                case 51350594: goto L_0x039e;
                case 55178625: goto L_0x0390;
                case 61542055: goto L_0x0382;
                case 65355429: goto L_0x0374;
                case 66214468: goto L_0x0366;
                case 66214470: goto L_0x0358;
                case 66214473: goto L_0x034a;
                case 66215429: goto L_0x033c;
                case 66215431: goto L_0x032e;
                case 66215433: goto L_0x0320;
                case 66216390: goto L_0x0312;
                case 76402249: goto L_0x0304;
                case 76404105: goto L_0x02f6;
                case 76404911: goto L_0x02e8;
                case 80963634: goto L_0x02da;
                case 82882791: goto L_0x02cc;
                case 98715550: goto L_0x02be;
                case 101370885: goto L_0x02b0;
                case 102844228: goto L_0x02a2;
                case 165221241: goto L_0x0294;
                case 182191441: goto L_0x0286;
                case 245388979: goto L_0x0278;
                case 287431619: goto L_0x026a;
                case 307593612: goto L_0x025c;
                case 308517133: goto L_0x024e;
                case 316215098: goto L_0x0240;
                case 316215116: goto L_0x0232;
                case 316246811: goto L_0x0224;
                case 316246818: goto L_0x0216;
                case 407160593: goto L_0x0208;
                case 507412548: goto L_0x01fa;
                case 793982701: goto L_0x01ec;
                case 794038622: goto L_0x01de;
                case 794040393: goto L_0x01d0;
                case 835649806: goto L_0x01c2;
                case 917340916: goto L_0x01b4;
                case 958008161: goto L_0x01a6;
                case 1060579533: goto L_0x0198;
                case 1150207623: goto L_0x018a;
                case 1176899427: goto L_0x017c;
                case 1280332038: goto L_0x016e;
                case 1306947716: goto L_0x0160;
                case 1349174697: goto L_0x0152;
                case 1522194893: goto L_0x0144;
                case 1691543273: goto L_0x0136;
                case 1691544261: goto L_0x0128;
                case 1709443163: goto L_0x011a;
                case 1865889110: goto L_0x010c;
                case 1906253259: goto L_0x00fe;
                case 1977196784: goto L_0x00f0;
                case 2006372676: goto L_0x00e3;
                case 2019281702: goto L_0x00d6;
                case 2029784656: goto L_0x00c9;
                case 2030379515: goto L_0x00bc;
                case 2033393791: goto L_0x00af;
                case 2047190025: goto L_0x00a2;
                case 2047252157: goto L_0x0095;
                case 2048319463: goto L_0x0088;
                case 2048855701: goto L_0x007b;
                default: goto L_0x0078;
            }
        L_0x0078:
            r1 = -1
            goto L_0x0806
        L_0x007b:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0084
            goto L_0x0078
        L_0x0084:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x0806
        L_0x0088:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0091
            goto L_0x0078
        L_0x0091:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x0806
        L_0x0095:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009e
            goto L_0x0078
        L_0x009e:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x0806
        L_0x00a2:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ab
            goto L_0x0078
        L_0x00ab:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x0806
        L_0x00af:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b8
            goto L_0x0078
        L_0x00b8:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x0806
        L_0x00bc:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            goto L_0x0078
        L_0x00c5:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x0806
        L_0x00c9:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d2
            goto L_0x0078
        L_0x00d2:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x0806
        L_0x00d6:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00df
            goto L_0x0078
        L_0x00df:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x0806
        L_0x00e3:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0078
        L_0x00ec:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x0806
        L_0x00f0:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00fa
            goto L_0x0078
        L_0x00fa:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x0806
        L_0x00fe:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0108
            goto L_0x0078
        L_0x0108:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x0806
        L_0x010c:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0116
            goto L_0x0078
        L_0x0116:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x0806
        L_0x011a:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0124
            goto L_0x0078
        L_0x0124:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x0806
        L_0x0128:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0132
            goto L_0x0078
        L_0x0132:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x0806
        L_0x0136:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0140
            goto L_0x0078
        L_0x0140:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x0806
        L_0x0144:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014e
            goto L_0x0078
        L_0x014e:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x0806
        L_0x0152:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015c
            goto L_0x0078
        L_0x015c:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x0806
        L_0x0160:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016a
            goto L_0x0078
        L_0x016a:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x0806
        L_0x016e:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0178
            goto L_0x0078
        L_0x0178:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x0806
        L_0x017c:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0186
            goto L_0x0078
        L_0x0186:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x0806
        L_0x018a:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0194
            goto L_0x0078
        L_0x0194:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x0806
        L_0x0198:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a2
            goto L_0x0078
        L_0x01a2:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x0806
        L_0x01a6:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01b0
            goto L_0x0078
        L_0x01b0:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x0806
        L_0x01b4:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01be
            goto L_0x0078
        L_0x01be:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x0806
        L_0x01c2:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01cc
            goto L_0x0078
        L_0x01cc:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x0806
        L_0x01d0:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01da
            goto L_0x0078
        L_0x01da:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x0806
        L_0x01de:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e8
            goto L_0x0078
        L_0x01e8:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x0806
        L_0x01ec:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f6
            goto L_0x0078
        L_0x01f6:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x0806
        L_0x01fa:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0204
            goto L_0x0078
        L_0x0204:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x0806
        L_0x0208:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0212
            goto L_0x0078
        L_0x0212:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x0806
        L_0x0216:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0220
            goto L_0x0078
        L_0x0220:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x0806
        L_0x0224:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022e
            goto L_0x0078
        L_0x022e:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x0806
        L_0x0232:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x023c
            goto L_0x0078
        L_0x023c:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x0806
        L_0x0240:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x024a
            goto L_0x0078
        L_0x024a:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x0806
        L_0x024e:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0258
            goto L_0x0078
        L_0x0258:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x0806
        L_0x025c:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0266
            goto L_0x0078
        L_0x0266:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x0806
        L_0x026a:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0274
            goto L_0x0078
        L_0x0274:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x0806
        L_0x0278:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0282
            goto L_0x0078
        L_0x0282:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x0806
        L_0x0286:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0290
            goto L_0x0078
        L_0x0290:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x0806
        L_0x0294:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029e
            goto L_0x0078
        L_0x029e:
            r1 = 100
            goto L_0x0806
        L_0x02a2:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ac
            goto L_0x0078
        L_0x02ac:
            r1 = 99
            goto L_0x0806
        L_0x02b0:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ba
            goto L_0x0078
        L_0x02ba:
            r1 = 98
            goto L_0x0806
        L_0x02be:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c8
            goto L_0x0078
        L_0x02c8:
            r1 = 97
            goto L_0x0806
        L_0x02cc:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d6
            goto L_0x0078
        L_0x02d6:
            r1 = 96
            goto L_0x0806
        L_0x02da:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e4
            goto L_0x0078
        L_0x02e4:
            r1 = 95
            goto L_0x0806
        L_0x02e8:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f2
            goto L_0x0078
        L_0x02f2:
            r1 = 94
            goto L_0x0806
        L_0x02f6:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0300
            goto L_0x0078
        L_0x0300:
            r1 = 93
            goto L_0x0806
        L_0x0304:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030e
            goto L_0x0078
        L_0x030e:
            r1 = 92
            goto L_0x0806
        L_0x0312:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x031c
            goto L_0x0078
        L_0x031c:
            r1 = 91
            goto L_0x0806
        L_0x0320:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x032a
            goto L_0x0078
        L_0x032a:
            r1 = 90
            goto L_0x0806
        L_0x032e:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0338
            goto L_0x0078
        L_0x0338:
            r1 = 89
            goto L_0x0806
        L_0x033c:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0346
            goto L_0x0078
        L_0x0346:
            r1 = 88
            goto L_0x0806
        L_0x034a:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0354
            goto L_0x0078
        L_0x0354:
            r1 = 87
            goto L_0x0806
        L_0x0358:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0362
            goto L_0x0078
        L_0x0362:
            r1 = 86
            goto L_0x0806
        L_0x0366:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0370
            goto L_0x0078
        L_0x0370:
            r1 = 85
            goto L_0x0806
        L_0x0374:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037e
            goto L_0x0078
        L_0x037e:
            r1 = 84
            goto L_0x0806
        L_0x0382:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x038c
            goto L_0x0078
        L_0x038c:
            r1 = 83
            goto L_0x0806
        L_0x0390:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x039a
            goto L_0x0078
        L_0x039a:
            r1 = 82
            goto L_0x0806
        L_0x039e:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a8
            goto L_0x0078
        L_0x03a8:
            r1 = 81
            goto L_0x0806
        L_0x03ac:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b6
            goto L_0x0078
        L_0x03b6:
            r1 = 80
            goto L_0x0806
        L_0x03ba:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c4
            goto L_0x0078
        L_0x03c4:
            r1 = 79
            goto L_0x0806
        L_0x03c8:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d2
            goto L_0x0078
        L_0x03d2:
            r1 = 78
            goto L_0x0806
        L_0x03d6:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03e0
            goto L_0x0078
        L_0x03e0:
            r1 = 77
            goto L_0x0806
        L_0x03e4:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ee
            goto L_0x0078
        L_0x03ee:
            r1 = 76
            goto L_0x0806
        L_0x03f2:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03fc
            goto L_0x0078
        L_0x03fc:
            r1 = 75
            goto L_0x0806
        L_0x0400:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x040a
            goto L_0x0078
        L_0x040a:
            r1 = 74
            goto L_0x0806
        L_0x040e:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0418
            goto L_0x0078
        L_0x0418:
            r1 = 73
            goto L_0x0806
        L_0x041c:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0426
            goto L_0x0078
        L_0x0426:
            r1 = 72
            goto L_0x0806
        L_0x042a:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0434
            goto L_0x0078
        L_0x0434:
            r1 = 71
            goto L_0x0806
        L_0x0438:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0442
            goto L_0x0078
        L_0x0442:
            r1 = 70
            goto L_0x0806
        L_0x0446:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0450
            goto L_0x0078
        L_0x0450:
            r1 = 69
            goto L_0x0806
        L_0x0454:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045e
            goto L_0x0078
        L_0x045e:
            r1 = 68
            goto L_0x0806
        L_0x0462:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x046c
            goto L_0x0078
        L_0x046c:
            r1 = 67
            goto L_0x0806
        L_0x0470:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x047a
            goto L_0x0078
        L_0x047a:
            r1 = 66
            goto L_0x0806
        L_0x047e:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0488
            goto L_0x0078
        L_0x0488:
            r1 = 65
            goto L_0x0806
        L_0x048c:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0496
            goto L_0x0078
        L_0x0496:
            r1 = 64
            goto L_0x0806
        L_0x049a:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a4
            goto L_0x0078
        L_0x04a4:
            r1 = 63
            goto L_0x0806
        L_0x04a8:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b2
            goto L_0x0078
        L_0x04b2:
            r1 = 62
            goto L_0x0806
        L_0x04b6:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04c0
            goto L_0x0078
        L_0x04c0:
            r1 = 61
            goto L_0x0806
        L_0x04c4:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ce
            goto L_0x0078
        L_0x04ce:
            r1 = 60
            goto L_0x0806
        L_0x04d2:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04dc
            goto L_0x0078
        L_0x04dc:
            r1 = 59
            goto L_0x0806
        L_0x04e0:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ea
            goto L_0x0078
        L_0x04ea:
            r1 = 58
            goto L_0x0806
        L_0x04ee:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f8
            goto L_0x0078
        L_0x04f8:
            r1 = 57
            goto L_0x0806
        L_0x04fc:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0506
            goto L_0x0078
        L_0x0506:
            r1 = 56
            goto L_0x0806
        L_0x050a:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0514
            goto L_0x0078
        L_0x0514:
            r1 = 55
            goto L_0x0806
        L_0x0518:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0522
            goto L_0x0078
        L_0x0522:
            r1 = 54
            goto L_0x0806
        L_0x0526:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0530
            goto L_0x0078
        L_0x0530:
            r1 = 53
            goto L_0x0806
        L_0x0534:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053e
            goto L_0x0078
        L_0x053e:
            r1 = 52
            goto L_0x0806
        L_0x0542:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x054c
            goto L_0x0078
        L_0x054c:
            r1 = 51
            goto L_0x0806
        L_0x0550:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x055a
            goto L_0x0078
        L_0x055a:
            r1 = 50
            goto L_0x0806
        L_0x055e:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0568
            goto L_0x0078
        L_0x0568:
            r1 = 49
            goto L_0x0806
        L_0x056c:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0576
            goto L_0x0078
        L_0x0576:
            r1 = 48
            goto L_0x0806
        L_0x057a:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0584
            goto L_0x0078
        L_0x0584:
            r1 = 47
            goto L_0x0806
        L_0x0588:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0592
            goto L_0x0078
        L_0x0592:
            r1 = 46
            goto L_0x0806
        L_0x0596:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05a0
            goto L_0x0078
        L_0x05a0:
            r1 = 45
            goto L_0x0806
        L_0x05a4:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ae
            goto L_0x0078
        L_0x05ae:
            r1 = 44
            goto L_0x0806
        L_0x05b2:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05bc
            goto L_0x0078
        L_0x05bc:
            r1 = 43
            goto L_0x0806
        L_0x05c0:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ca
            goto L_0x0078
        L_0x05ca:
            r1 = 42
            goto L_0x0806
        L_0x05ce:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d8
            goto L_0x0078
        L_0x05d8:
            r1 = 41
            goto L_0x0806
        L_0x05dc:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e6
            goto L_0x0078
        L_0x05e6:
            r1 = 40
            goto L_0x0806
        L_0x05ea:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f4
            goto L_0x0078
        L_0x05f4:
            r1 = 39
            goto L_0x0806
        L_0x05f8:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0602
            goto L_0x0078
        L_0x0602:
            r1 = 38
            goto L_0x0806
        L_0x0606:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0610
            goto L_0x0078
        L_0x0610:
            r1 = 37
            goto L_0x0806
        L_0x0614:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061e
            goto L_0x0078
        L_0x061e:
            r1 = 36
            goto L_0x0806
        L_0x0622:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x062c
            goto L_0x0078
        L_0x062c:
            r1 = 35
            goto L_0x0806
        L_0x0630:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x063a
            goto L_0x0078
        L_0x063a:
            r1 = 34
            goto L_0x0806
        L_0x063e:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0648
            goto L_0x0078
        L_0x0648:
            r1 = 33
            goto L_0x0806
        L_0x064c:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0656
            goto L_0x0078
        L_0x0656:
            r1 = 32
            goto L_0x0806
        L_0x065a:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0664
            goto L_0x0078
        L_0x0664:
            r1 = 31
            goto L_0x0806
        L_0x0668:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0672
            goto L_0x0078
        L_0x0672:
            r1 = 30
            goto L_0x0806
        L_0x0676:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0680
            goto L_0x0078
        L_0x0680:
            r1 = 29
            goto L_0x0806
        L_0x0684:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068e
            goto L_0x0078
        L_0x068e:
            r1 = 28
            goto L_0x0806
        L_0x0692:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069c
            goto L_0x0078
        L_0x069c:
            r1 = 27
            goto L_0x0806
        L_0x06a0:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06aa
            goto L_0x0078
        L_0x06aa:
            r1 = 26
            goto L_0x0806
        L_0x06ae:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b8
            goto L_0x0078
        L_0x06b8:
            r1 = 25
            goto L_0x0806
        L_0x06bc:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c6
            goto L_0x0078
        L_0x06c6:
            r1 = 24
            goto L_0x0806
        L_0x06ca:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d4
            goto L_0x0078
        L_0x06d4:
            r1 = 23
            goto L_0x0806
        L_0x06d8:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06e2
            goto L_0x0078
        L_0x06e2:
            r1 = 22
            goto L_0x0806
        L_0x06e6:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06f0
            goto L_0x0078
        L_0x06f0:
            r1 = 21
            goto L_0x0806
        L_0x06f4:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fe
            goto L_0x0078
        L_0x06fe:
            r1 = 20
            goto L_0x0806
        L_0x0702:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x070c
            goto L_0x0078
        L_0x070c:
            r1 = 19
            goto L_0x0806
        L_0x0710:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x071a
            goto L_0x0078
        L_0x071a:
            r1 = 18
            goto L_0x0806
        L_0x071e:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0728
            goto L_0x0078
        L_0x0728:
            r1 = 17
            goto L_0x0806
        L_0x072c:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0736
            goto L_0x0078
        L_0x0736:
            r1 = 16
            goto L_0x0806
        L_0x073a:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0744
            goto L_0x0078
        L_0x0744:
            r1 = 15
            goto L_0x0806
        L_0x0748:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0752
            goto L_0x0078
        L_0x0752:
            r1 = 14
            goto L_0x0806
        L_0x0756:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0760
            goto L_0x0078
        L_0x0760:
            r1 = 13
            goto L_0x0806
        L_0x0764:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076e
            goto L_0x0078
        L_0x076e:
            r1 = 12
            goto L_0x0806
        L_0x0772:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x077c
            goto L_0x0078
        L_0x077c:
            r1 = 11
            goto L_0x0806
        L_0x0780:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x078a
            goto L_0x0078
        L_0x078a:
            r1 = 10
            goto L_0x0806
        L_0x078e:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0798
            goto L_0x0078
        L_0x0798:
            r1 = 9
            goto L_0x0806
        L_0x079c:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a6
            goto L_0x0078
        L_0x07a6:
            r1 = 8
            goto L_0x0806
        L_0x07a9:
            java.lang.String r1 = "PGN528"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b3
            goto L_0x0078
        L_0x07b3:
            r1 = 7
            goto L_0x0806
        L_0x07b5:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07bf
            goto L_0x0078
        L_0x07bf:
            r1 = 6
            goto L_0x0806
        L_0x07c1:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cb
            goto L_0x0078
        L_0x07cb:
            r1 = 5
            goto L_0x0806
        L_0x07cd:
            java.lang.String r2 = "CP8676_I02"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0806
            goto L_0x0078
        L_0x07d7:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e1
            goto L_0x0078
        L_0x07e1:
            r1 = 3
            goto L_0x0806
        L_0x07e3:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07ed
            goto L_0x0078
        L_0x07ed:
            r1 = 2
            goto L_0x0806
        L_0x07ef:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f9
            goto L_0x0078
        L_0x07f9:
            r1 = 1
            goto L_0x0806
        L_0x07fb:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0805
            goto L_0x0078
        L_0x0805:
            r1 = 0
        L_0x0806:
            switch(r1) {
                case 0: goto L_0x0839;
                case 1: goto L_0x0839;
                case 2: goto L_0x0839;
                case 3: goto L_0x0839;
                case 4: goto L_0x0839;
                case 5: goto L_0x0839;
                case 6: goto L_0x0839;
                case 7: goto L_0x0839;
                case 8: goto L_0x0839;
                case 9: goto L_0x0839;
                case 10: goto L_0x0839;
                case 11: goto L_0x0839;
                case 12: goto L_0x0839;
                case 13: goto L_0x0839;
                case 14: goto L_0x0839;
                case 15: goto L_0x0839;
                case 16: goto L_0x0839;
                case 17: goto L_0x0839;
                case 18: goto L_0x0839;
                case 19: goto L_0x0839;
                case 20: goto L_0x0839;
                case 21: goto L_0x0839;
                case 22: goto L_0x0839;
                case 23: goto L_0x0839;
                case 24: goto L_0x0839;
                case 25: goto L_0x0839;
                case 26: goto L_0x0839;
                case 27: goto L_0x0839;
                case 28: goto L_0x0839;
                case 29: goto L_0x0839;
                case 30: goto L_0x0839;
                case 31: goto L_0x0839;
                case 32: goto L_0x0839;
                case 33: goto L_0x0839;
                case 34: goto L_0x0839;
                case 35: goto L_0x0839;
                case 36: goto L_0x0839;
                case 37: goto L_0x0839;
                case 38: goto L_0x0839;
                case 39: goto L_0x0839;
                case 40: goto L_0x0839;
                case 41: goto L_0x0839;
                case 42: goto L_0x0839;
                case 43: goto L_0x0839;
                case 44: goto L_0x0839;
                case 45: goto L_0x0839;
                case 46: goto L_0x0839;
                case 47: goto L_0x0839;
                case 48: goto L_0x0839;
                case 49: goto L_0x0839;
                case 50: goto L_0x0839;
                case 51: goto L_0x0839;
                case 52: goto L_0x0839;
                case 53: goto L_0x0839;
                case 54: goto L_0x0839;
                case 55: goto L_0x0839;
                case 56: goto L_0x0839;
                case 57: goto L_0x0839;
                case 58: goto L_0x0839;
                case 59: goto L_0x0839;
                case 60: goto L_0x0839;
                case 61: goto L_0x0839;
                case 62: goto L_0x0839;
                case 63: goto L_0x0839;
                case 64: goto L_0x0839;
                case 65: goto L_0x0839;
                case 66: goto L_0x0839;
                case 67: goto L_0x0839;
                case 68: goto L_0x0839;
                case 69: goto L_0x0839;
                case 70: goto L_0x0839;
                case 71: goto L_0x0839;
                case 72: goto L_0x0839;
                case 73: goto L_0x0839;
                case 74: goto L_0x0839;
                case 75: goto L_0x0839;
                case 76: goto L_0x0839;
                case 77: goto L_0x0839;
                case 78: goto L_0x0839;
                case 79: goto L_0x0839;
                case 80: goto L_0x0839;
                case 81: goto L_0x0839;
                case 82: goto L_0x0839;
                case 83: goto L_0x0839;
                case 84: goto L_0x0839;
                case 85: goto L_0x0839;
                case 86: goto L_0x0839;
                case 87: goto L_0x0839;
                case 88: goto L_0x0839;
                case 89: goto L_0x0839;
                case 90: goto L_0x0839;
                case 91: goto L_0x0839;
                case 92: goto L_0x0839;
                case 93: goto L_0x0839;
                case 94: goto L_0x0839;
                case 95: goto L_0x0839;
                case 96: goto L_0x0839;
                case 97: goto L_0x0839;
                case 98: goto L_0x0839;
                case 99: goto L_0x0839;
                case 100: goto L_0x0839;
                case 101: goto L_0x0839;
                case 102: goto L_0x0839;
                case 103: goto L_0x0839;
                case 104: goto L_0x0839;
                case 105: goto L_0x0839;
                case 106: goto L_0x0839;
                case 107: goto L_0x0839;
                case 108: goto L_0x0839;
                case 109: goto L_0x0839;
                case 110: goto L_0x0839;
                case 111: goto L_0x0839;
                case 112: goto L_0x0839;
                case 113: goto L_0x0839;
                case 114: goto L_0x0839;
                case 115: goto L_0x0839;
                case 116: goto L_0x0839;
                case 117: goto L_0x0839;
                case 118: goto L_0x0839;
                case 119: goto L_0x0839;
                case 120: goto L_0x0839;
                case 121: goto L_0x0839;
                case 122: goto L_0x0839;
                case 123: goto L_0x0839;
                case 124: goto L_0x0839;
                case 125: goto L_0x0839;
                case 126: goto L_0x0839;
                case 127: goto L_0x0839;
                case 128: goto L_0x0839;
                case 129: goto L_0x0839;
                case 130: goto L_0x0839;
                case 131: goto L_0x0839;
                case 132: goto L_0x0839;
                case 133: goto L_0x0839;
                case 134: goto L_0x0839;
                case 135: goto L_0x0839;
                case 136: goto L_0x0839;
                case 137: goto L_0x0839;
                case 138: goto L_0x0839;
                case 139: goto L_0x0839;
                default: goto L_0x0809;
            }
        L_0x0809:
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.MODEL
            r0.hashCode()
            int r1 = r0.hashCode()
            switch(r1) {
                case -594534941: goto L_0x082b;
                case 2006354: goto L_0x0820;
                case 2006367: goto L_0x0817;
                default: goto L_0x0815;
            }
        L_0x0815:
            r4 = -1
            goto L_0x0835
        L_0x0817:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0835
            goto L_0x0815
        L_0x0820:
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0829
            goto L_0x0815
        L_0x0829:
            r4 = 1
            goto L_0x0835
        L_0x082b:
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0834
            goto L_0x0815
        L_0x0834:
            r4 = 0
        L_0x0835:
            switch(r4) {
                case 0: goto L_0x0839;
                case 1: goto L_0x0839;
                case 2: goto L_0x0839;
                default: goto L_0x0838;
            }
        L_0x0838:
            goto L_0x083a
        L_0x0839:
            return r7
        L_0x083a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodec.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                if (j == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
                } catch (ExoPlaybackException e) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
                }
            }
        }
    }
}
