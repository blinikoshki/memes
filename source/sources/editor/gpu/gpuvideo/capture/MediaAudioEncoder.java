package editor.gpu.gpuvideo.capture;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Process;
import android.util.Log;
import android.view.Surface;
import editor.gpu.gpuvideo.capture.MediaEncoder;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
    /* access modifiers changed from: private */
    public static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    private static final int BIT_RATE = 64000;
    private static final int FRAMES_PER_BUFFER = 25;
    private static final String MIME_TYPE = "audio/mp4a-latm";
    private static final int SAMPLES_PER_FRAME = 1024;
    private static final int SAMPLE_RATE = 44100;
    private static final String TAG = "MediaAudioEncoder";
    private AudioThread audioThread = null;

    public MediaAudioEncoder(MediaMuxerCaptureWrapper mediaMuxerCaptureWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener) {
        super(mediaMuxerCaptureWrapper, mediaEncoderListener);
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        Log.v(TAG, "prepare:");
        this.trackIndex = -1;
        this.isEOS = false;
        this.muxerStarted = false;
        MediaCodecInfo selectAudioCodec = selectAudioCodec("audio/mp4a-latm");
        if (selectAudioCodec == null) {
            Log.e(TAG, "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        Log.i(TAG, "selected codec: " + selectAudioCodec.getName());
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", BIT_RATE);
        createAudioFormat.setInteger("channel-count", 1);
        Log.i(TAG, "format: " + createAudioFormat);
        this.mediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.mediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
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

    /* access modifiers changed from: protected */
    public void startRecording() {
        super.startRecording();
        if (this.audioThread == null) {
            AudioThread audioThread2 = new AudioThread();
            this.audioThread = audioThread2;
            audioThread2.start();
        }
    }

    /* access modifiers changed from: protected */
    public void release() {
        this.audioThread = null;
        super.release();
    }

    private class AudioThread extends Thread {
        private AudioThread() {
        }

        public void run() {
            Process.setThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(MediaAudioEncoder.SAMPLE_RATE, 16, 2);
                int i = 25600;
                if (25600 < minBufferSize) {
                    i = ((minBufferSize / 1024) + 1) * 1024 * 2;
                }
                AudioRecord audioRecord = null;
                for (int audioRecord2 : MediaAudioEncoder.AUDIO_SOURCES) {
                    try {
                        AudioRecord audioRecord3 = new AudioRecord(audioRecord2, MediaAudioEncoder.SAMPLE_RATE, 16, 2, i);
                        if (audioRecord3.getState() != 1) {
                            audioRecord3 = null;
                        }
                        audioRecord = audioRecord3;
                    } catch (Exception unused) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        break;
                    }
                }
                if (audioRecord != null) {
                    try {
                        if (MediaAudioEncoder.this.isCapturing) {
                            Log.v(MediaAudioEncoder.TAG, "AudioThread:start audio recording");
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                            audioRecord.startRecording();
                            while (MediaAudioEncoder.this.isCapturing && !MediaAudioEncoder.this.requestStop && !MediaAudioEncoder.this.isEOS) {
                                allocateDirect.clear();
                                int read = audioRecord.read(allocateDirect, 1024);
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    MediaAudioEncoder mediaAudioEncoder = MediaAudioEncoder.this;
                                    mediaAudioEncoder.encode(allocateDirect, read, mediaAudioEncoder.getPTSUs());
                                    MediaAudioEncoder.this.frameAvailableSoon();
                                }
                            }
                            MediaAudioEncoder.this.frameAvailableSoon();
                            audioRecord.stop();
                        }
                        audioRecord.release();
                    } catch (Throwable th) {
                        audioRecord.release();
                        throw th;
                    }
                } else {
                    Log.e(MediaAudioEncoder.TAG, "failed to initialize AudioRecord");
                }
            } catch (Exception e) {
                Log.e(MediaAudioEncoder.TAG, "AudioThread#run", e);
            }
            Log.v(MediaAudioEncoder.TAG, "AudioThread:finished");
        }
    }

    private static MediaCodecInfo selectAudioCodec(String str) {
        Log.v(TAG, "selectAudioCodec:");
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                for (int i = 0; i < supportedTypes.length; i++) {
                    if (supportedTypes[i].equalsIgnoreCase(str)) {
                        Log.i(TAG, "codec:" + mediaCodecInfo.getName() + ",MIME=" + supportedTypes[i]);
                        return mediaCodecInfo;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
