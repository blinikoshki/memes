package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.util.IntArrayQueue;
import java.util.ArrayDeque;

final class MediaCodecAsyncCallback extends MediaCodec.Callback {
    private final IntArrayQueue availableInputBuffers = new IntArrayQueue();
    private final IntArrayQueue availableOutputBuffers = new IntArrayQueue();
    private final ArrayDeque<MediaCodec.BufferInfo> bufferInfos = new ArrayDeque<>();
    private MediaFormat currentFormat;
    private final ArrayDeque<MediaFormat> formats = new ArrayDeque<>();
    private IllegalStateException mediaCodecException;
    private MediaFormat pendingOutputFormat;

    public int dequeueInputBufferIndex() {
        if (this.availableInputBuffers.isEmpty()) {
            return -1;
        }
        return this.availableInputBuffers.remove();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        if (this.availableOutputBuffers.isEmpty()) {
            return -1;
        }
        int remove = this.availableOutputBuffers.remove();
        if (remove >= 0) {
            MediaCodec.BufferInfo remove2 = this.bufferInfos.remove();
            bufferInfo.set(remove2.offset, remove2.size, remove2.presentationTimeUs, remove2.flags);
        } else if (remove == -2) {
            this.currentFormat = this.formats.remove();
        }
        return remove;
    }

    public MediaFormat getOutputFormat() throws IllegalStateException {
        MediaFormat mediaFormat = this.currentFormat;
        if (mediaFormat != null) {
            return mediaFormat;
        }
        throw new IllegalStateException();
    }

    public void maybeThrowMediaCodecException() throws IllegalStateException {
        IllegalStateException illegalStateException = this.mediaCodecException;
        this.mediaCodecException = null;
        if (illegalStateException != null) {
            throw illegalStateException;
        }
    }

    public void flush() {
        this.pendingOutputFormat = this.formats.isEmpty() ? null : this.formats.getLast();
        this.availableInputBuffers.clear();
        this.availableOutputBuffers.clear();
        this.bufferInfos.clear();
        this.formats.clear();
        this.mediaCodecException = null;
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        this.availableInputBuffers.add(i);
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        MediaFormat mediaFormat = this.pendingOutputFormat;
        if (mediaFormat != null) {
            addOutputFormat(mediaFormat);
            this.pendingOutputFormat = null;
        }
        this.availableOutputBuffers.add(i);
        this.bufferInfos.add(bufferInfo);
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        onMediaCodecError(codecException);
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        addOutputFormat(mediaFormat);
        this.pendingOutputFormat = null;
    }

    /* access modifiers changed from: package-private */
    public void onMediaCodecError(IllegalStateException illegalStateException) {
        this.mediaCodecException = illegalStateException;
    }

    private void addOutputFormat(MediaFormat mediaFormat) {
        this.availableOutputBuffers.add(-2);
        this.formats.add(mediaFormat);
    }
}
