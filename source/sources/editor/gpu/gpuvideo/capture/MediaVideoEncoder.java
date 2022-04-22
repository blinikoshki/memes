package editor.gpu.gpuvideo.capture;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.util.Log;
import android.view.Surface;
import editor.gpu.gpuvideo.capture.MediaEncoder;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import java.io.IOException;

public class MediaVideoEncoder extends MediaEncoder {
    private static final float BPP = 0.25f;
    private static final int FRAME_RATE = 30;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "MediaVideoEncoder";
    private EncodeRenderHandler encodeRenderHandler;
    private final int fileHeight;
    private final int fileWidth;
    private Surface surface;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaVideoEncoder(MediaMuxerCaptureWrapper mediaMuxerCaptureWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener, int i, int i2, boolean z, boolean z2, float f, float f2, boolean z3, GlVideoFilter glVideoFilter) {
        super(mediaMuxerCaptureWrapper, mediaEncoderListener);
        int i3 = i;
        int i4 = i2;
        this.fileWidth = i3;
        this.fileHeight = i4;
        this.encodeRenderHandler = EncodeRenderHandler.createHandler(TAG, z2, z, f > f2 ? f / f2 : f2 / f, (float) i3, (float) i4, z3, glVideoFilter);
    }

    public void frameAvailableSoon(int i, float[] fArr, float[] fArr2, float f) {
        if (super.frameAvailableSoon()) {
            this.encodeRenderHandler.draw(i, fArr, fArr2, f);
        }
    }

    public boolean frameAvailableSoon() {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.encodeRenderHandler.prepareDraw();
        }
        return frameAvailableSoon;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        Log.i(TAG, "prepare: ");
        this.trackIndex = -1;
        this.isEOS = false;
        this.muxerStarted = false;
        MediaCodecInfo selectVideoCodec = selectVideoCodec("video/avc");
        if (selectVideoCodec == null) {
            Log.e(TAG, "Unable to find an appropriate codec for video/avc");
            return;
        }
        Log.i(TAG, "selected codec: " + selectVideoCodec.getName());
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.fileWidth, this.fileHeight);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", calcBitRate(this.fileWidth, this.fileHeight));
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 3);
        Log.i(TAG, "format: " + createVideoFormat);
        this.mediaCodec = MediaCodec.createEncoderByType("video/avc");
        this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.surface = this.mediaCodec.createInputSurface();
        this.mediaCodec.start();
        Log.i(TAG, "prepare finishing");
        if (this.listener != null) {
            try {
                this.listener.onPrepared(this);
            } catch (Exception e) {
                Log.e(TAG, "prepare:", e);
            }
        }
    }

    public void setEglContext(EGLContext eGLContext, int i) {
        this.encodeRenderHandler.setEglContext(eGLContext, i, this.surface);
    }

    /* access modifiers changed from: protected */
    public void release() {
        Log.i(TAG, "release:");
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
        EncodeRenderHandler encodeRenderHandler2 = this.encodeRenderHandler;
        if (encodeRenderHandler2 != null) {
            encodeRenderHandler2.release();
            this.encodeRenderHandler = null;
        }
        super.release();
    }

    private static int calcBitRate(int i, int i2) {
        int i3 = (int) (((float) i) * 7.5f * ((float) i2));
        Log.i(TAG, "bitrate=" + i3);
        return i3;
    }

    private static MediaCodecInfo selectVideoCodec(String str) {
        Log.v(TAG, "selectVideoCodec:");
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                for (int i = 0; i < supportedTypes.length; i++) {
                    if (supportedTypes[i].equalsIgnoreCase(str)) {
                        Log.i(TAG, "codec:" + mediaCodecInfo.getName() + ",MIME=" + supportedTypes[i]);
                        if (selectColorFormat(mediaCodecInfo, str) > 0) {
                            return mediaCodecInfo;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    private static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        Log.i(TAG, "selectColorFormat: ");
        try {
            Thread.currentThread().setPriority(10);
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Thread.currentThread().setPriority(5);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= capabilitiesForType.colorFormats.length) {
                    break;
                }
                int i3 = capabilitiesForType.colorFormats[i2];
                if (isRecognizedViewoFormat(i3)) {
                    i = i3;
                    break;
                }
                i2++;
            }
            if (i == 0) {
                Log.e(TAG, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
            }
            return i;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    private static boolean isRecognizedViewoFormat(int i) {
        Log.i(TAG, "isRecognizedViewoFormat:colorFormat=" + i);
        return i == 2130708361;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        Log.d(TAG, "sending EOS to encoder");
        this.mediaCodec.signalEndOfInputStream();
        this.isEOS = true;
    }
}
