package editor.gpu.gpuvideo.composer;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.util.Log;
import android.util.Size;
import com.google.android.exoplayer2.util.MimeTypes;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import java.io.FileDescriptor;
import java.io.IOException;

class GPUMp4ComposerEngine {
    private static final long PROGRESS_INTERVAL_STEPS = 10;
    private static final double PROGRESS_UNKNOWN = -1.0d;
    private static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 10;
    private static final String TAG = "GPUMp4ComposerEngine";
    private IAudioComposer audioComposer;
    private long durationUs;
    private FileDescriptor inputFileDescriptor;
    private MediaExtractor mediaExtractor;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private MediaMuxer mediaMuxer;
    private ProgressCallback progressCallback;
    private VideoComposer videoComposer;

    interface ProgressCallback {
        void onProgress(double d);
    }

    GPUMp4ComposerEngine() {
    }

    /* access modifiers changed from: package-private */
    public void setDataSource(FileDescriptor fileDescriptor) {
        this.inputFileDescriptor = fileDescriptor;
    }

    /* access modifiers changed from: package-private */
    public void setProgressCallback(ProgressCallback progressCallback2) {
        this.progressCallback = progressCallback2;
    }

    /* access modifiers changed from: package-private */
    public void compose(String str, Size size, GlVideoFilter glVideoFilter, int i, boolean z, Rotation rotation, Size size2, FillMode fillMode, FillModeCustomItem fillModeCustomItem, int i2, boolean z2, boolean z3) throws IOException {
        int i3;
        try {
            MediaExtractor mediaExtractor2 = new MediaExtractor();
            this.mediaExtractor = mediaExtractor2;
            mediaExtractor2.setDataSource(this.inputFileDescriptor);
            i3 = 0;
            this.mediaMuxer = new MediaMuxer(str, 0);
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            this.mediaMetadataRetriever = mediaMetadataRetriever2;
            mediaMetadataRetriever2.setDataSource(this.inputFileDescriptor);
            this.durationUs = Long.parseLong(this.mediaMetadataRetriever.extractMetadata(9)) * 1000;
        } catch (NumberFormatException unused) {
            this.durationUs = -1;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                VideoComposer videoComposer2 = this.videoComposer;
                if (videoComposer2 != null) {
                    videoComposer2.release();
                    this.videoComposer = null;
                }
                IAudioComposer iAudioComposer = this.audioComposer;
                if (iAudioComposer != null) {
                    iAudioComposer.release();
                    this.audioComposer = null;
                }
                MediaExtractor mediaExtractor3 = this.mediaExtractor;
                if (mediaExtractor3 != null) {
                    mediaExtractor3.release();
                    this.mediaExtractor = null;
                }
                try {
                    MediaMuxer mediaMuxer2 = this.mediaMuxer;
                    if (mediaMuxer2 != null) {
                        mediaMuxer2.release();
                        this.mediaMuxer = null;
                    }
                } catch (RuntimeException e) {
                    Log.e(TAG, "Failed to release mediaMuxer.", e);
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever3 = this.mediaMetadataRetriever;
                    if (mediaMetadataRetriever3 != null) {
                        mediaMetadataRetriever3.release();
                        this.mediaMetadataRetriever = null;
                    }
                } catch (RuntimeException e2) {
                    Log.e(TAG, "Failed to release mediaMetadataRetriever.", e2);
                }
                throw th2;
            } catch (RuntimeException e3) {
                throw new Error("Could not shutdown mediaExtractor, codecs and mediaMuxer pipeline.", e3);
            }
        }
        Log.d(TAG, "Duration (us): " + this.durationUs);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("bitrate", i);
        createVideoFormat.setInteger("frame-rate", 30);
        int i4 = 1;
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("color-format", 2130708361);
        MuxRender muxRender = new MuxRender(this.mediaMuxer);
        if (!this.mediaExtractor.getTrackFormat(0).getString("mime").startsWith("video/")) {
            i3 = 1;
            i4 = 0;
        }
        VideoComposer videoComposer3 = new VideoComposer(this.mediaExtractor, i3, createVideoFormat, muxRender, i2);
        this.videoComposer = videoComposer3;
        videoComposer3.setUp(glVideoFilter, rotation, size, size2, fillMode, fillModeCustomItem, z2, z3);
        this.mediaExtractor.selectTrack(i3);
        if (this.mediaMetadataRetriever.extractMetadata(16) == null || z) {
            runPipelinesNoAudio();
        } else {
            if (i2 < 2) {
                this.audioComposer = new AudioComposer(this.mediaExtractor, i4, muxRender);
            } else {
                MediaExtractor mediaExtractor4 = this.mediaExtractor;
                this.audioComposer = new RemixAudioComposer(mediaExtractor4, i4, mediaExtractor4.getTrackFormat(i4), muxRender, i2);
            }
            this.audioComposer.setup();
            this.mediaExtractor.selectTrack(i4);
            runPipelines();
        }
        this.mediaMuxer.stop();
        try {
            VideoComposer videoComposer4 = this.videoComposer;
            if (videoComposer4 != null) {
                videoComposer4.release();
                this.videoComposer = null;
            }
            IAudioComposer iAudioComposer2 = this.audioComposer;
            if (iAudioComposer2 != null) {
                iAudioComposer2.release();
                this.audioComposer = null;
            }
            MediaExtractor mediaExtractor5 = this.mediaExtractor;
            if (mediaExtractor5 != null) {
                mediaExtractor5.release();
                this.mediaExtractor = null;
            }
            try {
                MediaMuxer mediaMuxer3 = this.mediaMuxer;
                if (mediaMuxer3 != null) {
                    mediaMuxer3.release();
                    this.mediaMuxer = null;
                }
            } catch (RuntimeException e4) {
                Log.e(TAG, "Failed to release mediaMuxer.", e4);
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever4 = this.mediaMetadataRetriever;
                if (mediaMetadataRetriever4 != null) {
                    mediaMetadataRetriever4.release();
                    this.mediaMetadataRetriever = null;
                }
            } catch (RuntimeException e5) {
                Log.e(TAG, "Failed to release mediaMetadataRetriever.", e5);
            }
        } catch (RuntimeException e6) {
            throw new Error("Could not shutdown mediaExtractor, codecs and mediaMuxer pipeline.", e6);
        }
    }

    private void runPipelines() {
        ProgressCallback progressCallback2;
        if (this.durationUs <= 0 && (progressCallback2 = this.progressCallback) != null) {
            progressCallback2.onProgress(PROGRESS_UNKNOWN);
        }
        long j = 0;
        while (true) {
            if (!this.videoComposer.isFinished() || !this.audioComposer.isFinished()) {
                boolean z = this.videoComposer.stepPipeline() || this.audioComposer.stepPipeline();
                j++;
                if (this.durationUs > 0 && j % 10 == 0) {
                    double d = 1.0d;
                    double min = this.videoComposer.isFinished() ? 1.0d : Math.min(1.0d, ((double) this.videoComposer.getWrittenPresentationTimeUs()) / ((double) this.durationUs));
                    if (!this.audioComposer.isFinished()) {
                        d = Math.min(1.0d, ((double) this.audioComposer.getWrittenPresentationTimeUs()) / ((double) this.durationUs));
                    }
                    double d2 = (min + d) / 2.0d;
                    ProgressCallback progressCallback3 = this.progressCallback;
                    if (progressCallback3 != null) {
                        progressCallback3.onProgress(d2);
                    }
                }
                if (!z) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                return;
            }
        }
    }

    private void runPipelinesNoAudio() {
        ProgressCallback progressCallback2;
        if (this.durationUs <= 0 && (progressCallback2 = this.progressCallback) != null) {
            progressCallback2.onProgress(PROGRESS_UNKNOWN);
        }
        long j = 0;
        while (!this.videoComposer.isFinished()) {
            boolean stepPipeline = this.videoComposer.stepPipeline();
            j++;
            if (this.durationUs > 0 && j % 10 == 0) {
                double d = 1.0d;
                if (!this.videoComposer.isFinished()) {
                    d = Math.min(1.0d, ((double) this.videoComposer.getWrittenPresentationTimeUs()) / ((double) this.durationUs));
                }
                ProgressCallback progressCallback3 = this.progressCallback;
                if (progressCallback3 != null) {
                    progressCallback3.onProgress(d);
                }
            }
            if (!stepPipeline) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
