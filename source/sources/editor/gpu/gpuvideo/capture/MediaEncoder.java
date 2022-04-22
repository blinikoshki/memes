package editor.gpu.gpuvideo.capture;

import android.media.MediaCodec;
import android.util.Log;
import androidx.work.WorkRequest;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
    protected static final int TIMEOUT_USEC = 10000;
    private final String TAG = getClass().getSimpleName();
    private MediaCodec.BufferInfo bufferInfo;
    protected volatile boolean isCapturing;
    protected boolean isEOS;
    protected final MediaEncoderListener listener;
    protected MediaCodec mediaCodec;
    protected boolean muxerStarted;
    private long prevOutputPTSUs;
    protected int requestDrain;
    protected volatile boolean requestStop;
    protected final Object sync;
    protected int trackIndex;
    protected final WeakReference<MediaMuxerCaptureWrapper> weakMuxer;

    public interface MediaEncoderListener {
        void onExit();

        void onPrepared(MediaEncoder mediaEncoder);

        void onStopped(MediaEncoder mediaEncoder);
    }

    /* access modifiers changed from: package-private */
    public abstract void prepare() throws IOException;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|5|6|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    MediaEncoder(editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper r4, editor.gpu.gpuvideo.capture.MediaEncoder.MediaEncoderListener r5) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Class r0 = r3.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r3.TAG = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.sync = r0
            r1 = 0
            r3.prevOutputPTSUs = r1
            java.lang.String r1 = "MediaEncoderListener is null"
            java.util.Objects.requireNonNull(r5, r1)
            java.lang.String r1 = "MediaMuxerCaptureWrapper is null"
            java.util.Objects.requireNonNull(r4, r1)
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            r3.weakMuxer = r1
            r4.addEncoder(r3)
            r3.listener = r5
            monitor-enter(r0)
            android.media.MediaCodec$BufferInfo r4 = new android.media.MediaCodec$BufferInfo     // Catch:{ all -> 0x004b }
            r4.<init>()     // Catch:{ all -> 0x004b }
            r3.bufferInfo = r4     // Catch:{ all -> 0x004b }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ all -> 0x004b }
            java.lang.Class r5 = r3.getClass()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x004b }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x004b }
            r4.start()     // Catch:{ all -> 0x004b }
            r0.wait()     // Catch:{ InterruptedException -> 0x0049 }
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x004b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.MediaEncoder.<init>(editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper, editor.gpu.gpuvideo.capture.MediaEncoder$MediaEncoderListener):void");
    }

    public boolean frameAvailableSoon() {
        synchronized (this.sync) {
            if (this.isCapturing) {
                if (!this.requestStop) {
                    this.requestDrain++;
                    this.sync.notifyAll();
                    return true;
                }
            }
            return false;
        }
    }

    public void run() {
        boolean z;
        boolean z2;
        synchronized (this.sync) {
            this.requestStop = false;
            this.requestDrain = 0;
            this.sync.notify();
        }
        while (true) {
            synchronized (this.sync) {
                z = this.requestStop;
                int i = this.requestDrain;
                z2 = i > 0;
                if (z2) {
                    this.requestDrain = i - 1;
                }
            }
            if (z) {
                drain();
                signalEndOfInputStream();
                drain();
                release();
                break;
            } else if (z2) {
                drain();
            } else {
                synchronized (this.sync) {
                    try {
                        this.sync.wait();
                        try {
                        } finally {
                            while (true) {
                            }
                        }
                    } catch (InterruptedException unused) {
                        Log.d(this.TAG, "Encoder thread exiting");
                        synchronized (this.sync) {
                            this.requestStop = true;
                            this.isCapturing = false;
                        }
                        this.listener.onExit();
                        return;
                    }
                }
            }
        }
        while (true) {
        }
    }

    /* access modifiers changed from: package-private */
    public void startRecording() {
        Log.v(this.TAG, "startRecording");
        synchronized (this.sync) {
            this.isCapturing = true;
            this.requestStop = false;
            this.sync.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopRecording() {
        /*
            r2 = this;
            java.lang.String r0 = r2.TAG
            java.lang.String r1 = "stopRecording"
            android.util.Log.v(r0, r1)
            java.lang.Object r0 = r2.sync
            monitor-enter(r0)
            boolean r1 = r2.isCapturing     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            boolean r1 = r2.requestStop     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0013
            goto L_0x001d
        L_0x0013:
            r1 = 1
            r2.requestStop = r1     // Catch:{ all -> 0x001f }
            java.lang.Object r1 = r2.sync     // Catch:{ all -> 0x001f }
            r1.notifyAll()     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.MediaEncoder.stopRecording():void");
    }

    /* access modifiers changed from: protected */
    public void release() {
        Log.d(this.TAG, "release:");
        try {
            this.listener.onStopped(this);
        } catch (Exception e) {
            Log.e(this.TAG, "failed onStopped", e);
        }
        this.isCapturing = false;
        MediaCodec mediaCodec2 = this.mediaCodec;
        if (mediaCodec2 != null) {
            try {
                mediaCodec2.stop();
                this.mediaCodec.release();
                this.mediaCodec = null;
            } catch (Exception e2) {
                Log.e(this.TAG, "failed releasing MediaCodec", e2);
            }
        }
        if (this.muxerStarted) {
            WeakReference<MediaMuxerCaptureWrapper> weakReference = this.weakMuxer;
            MediaMuxerCaptureWrapper mediaMuxerCaptureWrapper = weakReference != null ? (MediaMuxerCaptureWrapper) weakReference.get() : null;
            if (mediaMuxerCaptureWrapper != null) {
                try {
                    mediaMuxerCaptureWrapper.stop();
                } catch (Exception e3) {
                    Log.e(this.TAG, "failed stopping muxer", e3);
                }
            }
        }
        this.bufferInfo = null;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        Log.d(this.TAG, "sending EOS to encoder");
        encode((ByteBuffer) null, 0, getPTSUs());
    }

    /* access modifiers changed from: protected */
    public void encode(ByteBuffer byteBuffer, int i, long j) {
        if (this.isCapturing) {
            while (this.isCapturing) {
                int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(WorkRequest.MIN_BACKOFF_MILLIS);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = this.mediaCodec.getInputBuffer(dequeueInputBuffer);
                    inputBuffer.clear();
                    if (byteBuffer != null) {
                        inputBuffer.put(byteBuffer);
                    }
                    if (i <= 0) {
                        this.isEOS = true;
                        Log.i(this.TAG, "send BUFFER_FLAG_END_OF_STREAM");
                        this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                        return;
                    }
                    this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drain() {
        /*
            r7 = this;
            android.media.MediaCodec r0 = r7.mediaCodec
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.ref.WeakReference<editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper> r0 = r7.weakMuxer
            java.lang.Object r0 = r0.get()
            editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper r0 = (editor.gpu.gpuvideo.capture.MediaMuxerCaptureWrapper) r0
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r7.TAG
            java.lang.String r1 = "muxer is unexpectedly null"
            android.util.Log.w(r0, r1)
            return
        L_0x0017:
            r1 = 0
            r2 = 0
        L_0x0019:
            boolean r3 = r7.isCapturing
            if (r3 == 0) goto L_0x00fe
            android.media.MediaCodec r3 = r7.mediaCodec
            android.media.MediaCodec$BufferInfo r4 = r7.bufferInfo
            r5 = 10000(0x2710, double:4.9407E-320)
            int r3 = r3.dequeueOutputBuffer(r4, r5)
            r4 = -1
            if (r3 != r4) goto L_0x0035
            boolean r3 = r7.isEOS
            if (r3 != 0) goto L_0x0019
            int r2 = r2 + 1
            r3 = 5
            if (r2 <= r3) goto L_0x0019
            goto L_0x00fe
        L_0x0035:
            r4 = -2
            if (r3 != r4) goto L_0x0075
            java.lang.String r3 = r7.TAG
            java.lang.String r4 = "INFO_OUTPUT_FORMAT_CHANGED"
            android.util.Log.v(r3, r4)
            boolean r3 = r7.muxerStarted
            if (r3 != 0) goto L_0x006d
            android.media.MediaCodec r3 = r7.mediaCodec
            android.media.MediaFormat r3 = r3.getOutputFormat()
            int r3 = r0.addTrack(r3)
            r7.trackIndex = r3
            r3 = 1
            r7.muxerStarted = r3
            boolean r3 = r0.start()
            if (r3 != 0) goto L_0x0019
            monitor-enter(r0)
        L_0x0059:
            boolean r3 = r0.isStarted()     // Catch:{ all -> 0x006a }
            if (r3 != 0) goto L_0x0068
            r3 = 100
            r0.wait(r3)     // Catch:{ InterruptedException -> 0x0065 }
            goto L_0x0059
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            goto L_0x00fe
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0019
        L_0x006a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r1
        L_0x006d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)
            throw r0
        L_0x0075:
            if (r3 >= 0) goto L_0x008e
            java.lang.String r4 = r7.TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "drain:unexpected result from encoder#dequeueOutputBuffer: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.w(r4, r3)
            goto L_0x0019
        L_0x008e:
            android.media.MediaCodec r4 = r7.mediaCodec
            java.nio.ByteBuffer r4 = r4.getOutputBuffer(r3)
            if (r4 == 0) goto L_0x00e2
            android.media.MediaCodec$BufferInfo r5 = r7.bufferInfo
            int r5 = r5.flags
            r5 = r5 & 2
            if (r5 == 0) goto L_0x00a9
            java.lang.String r5 = r7.TAG
            java.lang.String r6 = "drain:BUFFER_FLAG_CODEC_CONFIG"
            android.util.Log.d(r5, r6)
            android.media.MediaCodec$BufferInfo r5 = r7.bufferInfo
            r5.size = r1
        L_0x00a9:
            android.media.MediaCodec$BufferInfo r5 = r7.bufferInfo
            int r5 = r5.size
            if (r5 == 0) goto L_0x00d2
            boolean r2 = r7.muxerStarted
            if (r2 == 0) goto L_0x00ca
            android.media.MediaCodec$BufferInfo r2 = r7.bufferInfo
            long r5 = r7.getPTSUs()
            r2.presentationTimeUs = r5
            int r2 = r7.trackIndex
            android.media.MediaCodec$BufferInfo r5 = r7.bufferInfo
            r0.writeSampleData(r2, r4, r5)
            android.media.MediaCodec$BufferInfo r2 = r7.bufferInfo
            long r4 = r2.presentationTimeUs
            r7.prevOutputPTSUs = r4
            r2 = 0
            goto L_0x00d2
        L_0x00ca:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "drain:muxer hasn't started"
            r0.<init>(r1)
            throw r0
        L_0x00d2:
            android.media.MediaCodec r4 = r7.mediaCodec
            r4.releaseOutputBuffer(r3, r1)
            android.media.MediaCodec$BufferInfo r3 = r7.bufferInfo
            int r3 = r3.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x0019
            r7.isCapturing = r1
            goto L_0x00fe
        L_0x00e2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " was null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.MediaEncoder.drain():void");
    }

    /* access modifiers changed from: package-private */
    public long getPTSUs() {
        long nanoTime = System.nanoTime() / 1000;
        long j = this.prevOutputPTSUs;
        return nanoTime < j ? nanoTime + (j - nanoTime) : nanoTime;
    }
}
