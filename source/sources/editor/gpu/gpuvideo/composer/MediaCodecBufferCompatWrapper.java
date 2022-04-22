package editor.gpu.gpuvideo.composer;

import android.media.MediaCodec;
import android.os.Build;
import java.nio.ByteBuffer;

class MediaCodecBufferCompatWrapper {
    private final ByteBuffer[] inputBuffers;
    private final MediaCodec mediaCodec;
    private final ByteBuffer[] putputBuffers;

    MediaCodecBufferCompatWrapper(MediaCodec mediaCodec2) {
        this.mediaCodec = mediaCodec2;
        if (Build.VERSION.SDK_INT < 21) {
            this.inputBuffers = mediaCodec2.getInputBuffers();
            this.putputBuffers = mediaCodec2.getOutputBuffers();
            return;
        }
        this.putputBuffers = null;
        this.inputBuffers = null;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getInputBuffer(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mediaCodec.getInputBuffer(i);
        }
        return this.inputBuffers[i];
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getOutputBuffer(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mediaCodec.getOutputBuffer(i);
        }
        return this.putputBuffers[i];
    }
}
