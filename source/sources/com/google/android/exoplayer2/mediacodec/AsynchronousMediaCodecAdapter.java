package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

final class AsynchronousMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private static final int STATE_CONFIGURED = 1;
    private static final int STATE_CREATED = 0;
    private static final int STATE_SHUT_DOWN = 3;
    private static final int STATE_STARTED = 2;
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private Handler handler;
    private final HandlerThread handlerThread;
    private IllegalStateException internalException;
    private final Object lock;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;
    private long pendingFlushCount;
    private int state;

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, int i) {
        this(mediaCodec, false, i, new HandlerThread(createThreadLabel(i)));
    }

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i) {
        this(mediaCodec, z, i, new HandlerThread(createThreadLabel(i)));
    }

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i, HandlerThread handlerThread2) {
        MediaCodecInputBufferEnqueuer mediaCodecInputBufferEnqueuer;
        this.lock = new Object();
        this.mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.codec = mediaCodec;
        this.handlerThread = handlerThread2;
        if (z) {
            mediaCodecInputBufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, i);
        } else {
            mediaCodecInputBufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(mediaCodec);
        }
        this.bufferEnqueuer = mediaCodecInputBufferEnqueuer;
        this.state = 0;
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.handlerThread.start();
        Handler handler2 = new Handler(this.handlerThread.getLooper());
        this.handler = handler2;
        this.codec.setCallback(this, handler2);
        this.codec.configure(mediaFormat, surface, mediaCrypto, i);
        this.state = 1;
    }

    public void start() {
        this.bufferEnqueuer.start();
        this.codec.start();
        this.state = 2;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public int dequeueInputBufferIndex() {
        synchronized (this.lock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            int dequeueInputBufferIndex = this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
            return dequeueInputBufferIndex;
        }
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.lock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            int dequeueOutputBufferIndex = this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
            return dequeueOutputBufferIndex;
        }
    }

    public MediaFormat getOutputFormat() {
        MediaFormat outputFormat;
        synchronized (this.lock) {
            outputFormat = this.mediaCodecAsyncCallback.getOutputFormat();
        }
        return outputFormat;
    }

    public void flush() {
        synchronized (this.lock) {
            this.bufferEnqueuer.flush();
            this.codec.flush();
            this.pendingFlushCount++;
            ((Handler) Util.castNonNull(this.handler)).post(new Runnable() {
                public final void run() {
                    AsynchronousMediaCodecAdapter.this.onFlushCompleted();
                }
            });
        }
    }

    public void shutdown() {
        synchronized (this.lock) {
            if (this.state == 2) {
                this.bufferEnqueuer.shutdown();
            }
            int i = this.state;
            if (i == 1 || i == 2) {
                this.handlerThread.quit();
                this.mediaCodecAsyncCallback.flush();
                this.pendingFlushCount++;
            }
            this.state = 3;
        }
    }

    public MediaCodec getCodec() {
        return this.codec;
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onInputBufferAvailable(mediaCodec, i);
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onOutputBufferAvailable(mediaCodec, i, bufferInfo);
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onError(mediaCodec, codecException);
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    /* access modifiers changed from: private */
    public void onFlushCompleted() {
        synchronized (this.lock) {
            onFlushCompletedSynchronized();
        }
    }

    private void onFlushCompletedSynchronized() {
        if (this.state != 3) {
            long j = this.pendingFlushCount - 1;
            this.pendingFlushCount = j;
            if (j <= 0) {
                if (j < 0) {
                    this.internalException = new IllegalStateException();
                    return;
                }
                this.mediaCodecAsyncCallback.flush();
                try {
                    this.codec.start();
                } catch (IllegalStateException e) {
                    this.internalException = e;
                } catch (Exception e2) {
                    this.internalException = new IllegalStateException(e2);
                }
            }
        }
    }

    private boolean isFlushing() {
        return this.pendingFlushCount > 0;
    }

    private void maybeThrowException() {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException != null) {
            this.internalException = null;
            throw illegalStateException;
        }
    }

    private static String createThreadLabel(int i) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }
}
