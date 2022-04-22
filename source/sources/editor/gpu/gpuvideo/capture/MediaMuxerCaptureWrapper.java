package editor.gpu.gpuvideo.capture;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;

public class MediaMuxerCaptureWrapper {
    private static final String TAG = "MediaMuxerWrapper";
    private MediaEncoder audioEncoder;
    private int audioTrackIndex = -1;
    private int encoderCount;
    private boolean isStarted;
    private final MediaMuxer mediaMuxer;
    private long preventAudioPresentationTimeUs = -1;
    private int startedCount;
    private MediaEncoder videoEncoder;

    public MediaMuxerCaptureWrapper(String str) throws IOException {
        this.mediaMuxer = new MediaMuxer(str, 0);
        this.startedCount = 0;
        this.encoderCount = 0;
        this.isStarted = false;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.videoEncoder;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.audioEncoder;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.videoEncoder;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.audioEncoder;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.videoEncoder;
        if (mediaEncoder != null) {
            mediaEncoder.stopRecording();
        }
        this.videoEncoder = null;
        MediaEncoder mediaEncoder2 = this.audioEncoder;
        if (mediaEncoder2 != null) {
            mediaEncoder2.stopRecording();
        }
        this.audioEncoder = null;
    }

    public synchronized boolean isStarted() {
        return this.isStarted;
    }

    /* access modifiers changed from: package-private */
    public void addEncoder(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.videoEncoder == null) {
                this.videoEncoder = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.audioEncoder == null) {
            this.audioEncoder = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.videoEncoder != null ? 1 : 0;
        if (this.audioEncoder == null) {
            i = 0;
        }
        this.encoderCount = i2 + i;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean start() {
        Log.v(TAG, "start:");
        int i = this.startedCount + 1;
        this.startedCount = i;
        int i2 = this.encoderCount;
        if (i2 > 0 && i == i2) {
            this.mediaMuxer.start();
            this.isStarted = true;
            notifyAll();
            Log.v(TAG, "MediaMuxer started:");
        }
        return this.isStarted;
    }

    /* access modifiers changed from: package-private */
    public synchronized void stop() {
        Log.v(TAG, "stop:startedCount=" + this.startedCount);
        int i = this.startedCount + -1;
        this.startedCount = i;
        if (this.encoderCount > 0 && i <= 0) {
            this.mediaMuxer.stop();
            this.mediaMuxer.release();
            this.isStarted = false;
            Log.v(TAG, "MediaMuxer stopped:");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized int addTrack(MediaFormat mediaFormat) {
        int addTrack;
        if (!this.isStarted) {
            addTrack = this.mediaMuxer.addTrack(mediaFormat);
            Log.i(TAG, "addTrack:trackNum=" + this.encoderCount + ",trackIx=" + addTrack + ",format=" + mediaFormat);
            if (!mediaFormat.getString("mime").startsWith("video/")) {
                this.audioTrackIndex = addTrack;
            }
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return addTrack;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void writeSampleData(int r6, java.nio.ByteBuffer r7, android.media.MediaCodec.BufferInfo r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.startedCount     // Catch:{ all -> 0x0024 }
            if (r0 > 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            int r0 = r5.audioTrackIndex     // Catch:{ all -> 0x0024 }
            if (r0 != r6) goto L_0x001d
            long r0 = r5.preventAudioPresentationTimeUs     // Catch:{ all -> 0x0024 }
            long r2 = r8.presentationTimeUs     // Catch:{ all -> 0x0024 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0022
            android.media.MediaMuxer r0 = r5.mediaMuxer     // Catch:{ all -> 0x0024 }
            r0.writeSampleData(r6, r7, r8)     // Catch:{ all -> 0x0024 }
            long r6 = r8.presentationTimeUs     // Catch:{ all -> 0x0024 }
            r5.preventAudioPresentationTimeUs = r6     // Catch:{ all -> 0x0024 }
            goto L_0x0022
        L_0x001d:
            android.media.MediaMuxer r0 = r5.mediaMuxer     // Catch:{ all -> 0x0024 }
            r0.writeSampleData(r6, r7, r8)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r5)
            return
        L_0x0024:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper.writeSampleData(int, java.nio.ByteBuffer, android.media.MediaCodec$BufferInfo):void");
    }
}
