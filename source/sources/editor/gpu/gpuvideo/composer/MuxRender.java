package editor.gpu.gpuvideo.composer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

class MuxRender {
    private static final int BUFFER_SIZE = 65536;
    private static final String TAG = "MuxRender";
    private MediaFormat audioFormat;
    private int audioTrackIndex;
    private ByteBuffer byteBuffer;
    private final MediaMuxer muxer;
    private final List<SampleInfo> sampleInfoList = new ArrayList();
    private boolean started;
    private MediaFormat videoFormat;
    private int videoTrackIndex;

    public enum SampleType {
        VIDEO,
        AUDIO
    }

    MuxRender(MediaMuxer mediaMuxer) {
        this.muxer = mediaMuxer;
    }

    /* renamed from: editor.gpu.gpuvideo.composer.MuxRender$1 */
    static /* synthetic */ class C47811 {
        static final /* synthetic */ int[] $SwitchMap$editor$gpu$gpuvideo$composer$MuxRender$SampleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                editor.gpu.gpuvideo.composer.MuxRender$SampleType[] r0 = editor.gpu.gpuvideo.composer.MuxRender.SampleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$editor$gpu$gpuvideo$composer$MuxRender$SampleType = r0
                editor.gpu.gpuvideo.composer.MuxRender$SampleType r1 = editor.gpu.gpuvideo.composer.MuxRender.SampleType.VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$editor$gpu$gpuvideo$composer$MuxRender$SampleType     // Catch:{ NoSuchFieldError -> 0x001d }
                editor.gpu.gpuvideo.composer.MuxRender$SampleType r1 = editor.gpu.gpuvideo.composer.MuxRender.SampleType.AUDIO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.composer.MuxRender.C47811.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void setOutputFormat(SampleType sampleType, MediaFormat mediaFormat) {
        int i = C47811.$SwitchMap$editor$gpu$gpuvideo$composer$MuxRender$SampleType[sampleType.ordinal()];
        if (i == 1) {
            this.videoFormat = mediaFormat;
        } else if (i == 2) {
            this.audioFormat = mediaFormat;
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetOutputFormat() {
        MediaFormat mediaFormat = this.videoFormat;
        if (mediaFormat != null && this.audioFormat != null) {
            this.videoTrackIndex = this.muxer.addTrack(mediaFormat);
            Log.v(TAG, "Added track #" + this.videoTrackIndex + " with " + this.videoFormat.getString("mime") + " to muxer");
            this.audioTrackIndex = this.muxer.addTrack(this.audioFormat);
            Log.v(TAG, "Added track #" + this.audioTrackIndex + " with " + this.audioFormat.getString("mime") + " to muxer");
        } else if (mediaFormat != null) {
            this.videoTrackIndex = this.muxer.addTrack(mediaFormat);
            Log.v(TAG, "Added track #" + this.videoTrackIndex + " with " + this.videoFormat.getString("mime") + " to muxer");
        }
        this.muxer.start();
        this.started = true;
        int i = 0;
        if (this.byteBuffer == null) {
            this.byteBuffer = ByteBuffer.allocate(0);
        }
        this.byteBuffer.flip();
        Log.v(TAG, "Output format determined, writing " + this.sampleInfoList.size() + " samples / " + this.byteBuffer.limit() + " bytes to muxer.");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        for (SampleInfo next : this.sampleInfoList) {
            next.writeToBufferInfo(bufferInfo, i);
            this.muxer.writeSampleData(getTrackIndexForSampleType(next.sampleType), this.byteBuffer, bufferInfo);
            i += next.size;
        }
        this.sampleInfoList.clear();
        this.byteBuffer = null;
    }

    /* access modifiers changed from: package-private */
    public void writeSampleData(SampleType sampleType, ByteBuffer byteBuffer2, MediaCodec.BufferInfo bufferInfo) {
        if (this.started) {
            this.muxer.writeSampleData(getTrackIndexForSampleType(sampleType), byteBuffer2, bufferInfo);
            return;
        }
        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer2.position(bufferInfo.offset);
        if (this.byteBuffer == null) {
            this.byteBuffer = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
        }
        this.byteBuffer.put(byteBuffer2);
        this.sampleInfoList.add(new SampleInfo(sampleType, bufferInfo.size, bufferInfo, (C47811) null));
    }

    private int getTrackIndexForSampleType(SampleType sampleType) {
        int i = C47811.$SwitchMap$editor$gpu$gpuvideo$composer$MuxRender$SampleType[sampleType.ordinal()];
        if (i == 1) {
            return this.videoTrackIndex;
        }
        if (i == 2) {
            return this.audioTrackIndex;
        }
        throw new AssertionError();
    }

    private static class SampleInfo {
        private final int flags;
        private final long presentationTimeUs;
        /* access modifiers changed from: private */
        public final SampleType sampleType;
        /* access modifiers changed from: private */
        public final int size;

        /* synthetic */ SampleInfo(SampleType sampleType2, int i, MediaCodec.BufferInfo bufferInfo, C47811 r4) {
            this(sampleType2, i, bufferInfo);
        }

        private SampleInfo(SampleType sampleType2, int i, MediaCodec.BufferInfo bufferInfo) {
            this.sampleType = sampleType2;
            this.size = i;
            this.presentationTimeUs = bufferInfo.presentationTimeUs;
            this.flags = bufferInfo.flags;
        }

        /* access modifiers changed from: private */
        public void writeToBufferInfo(MediaCodec.BufferInfo bufferInfo, int i) {
            bufferInfo.set(i, this.size, this.presentationTimeUs, this.flags);
        }
    }
}
