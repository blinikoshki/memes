package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private int audioMediaCodecOperationMode;
    private final Context context;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableOffload;
    private int extensionRendererMode;
    private MediaCodecSelector mediaCodecSelector;
    private int videoMediaCodecOperationMode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
        this.audioMediaCodecOperationMode = 0;
        this.videoMediaCodecOperationMode = 0;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i) {
        this(context2, i, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i, long j) {
        this.context = context2;
        this.extensionRendererMode = i;
        this.allowedVideoJoiningTimeMs = j;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public DefaultRenderersFactory experimentalSetAudioMediaCodecOperationMode(int i) {
        this.audioMediaCodecOperationMode = i;
        return this;
    }

    public DefaultRenderersFactory experimentalSetVideoMediaCodecOperationMode(int i) {
        this.videoMediaCodecOperationMode = i;
        return this;
    }

    public DefaultRenderersFactory experimentalSetMediaCodecOperationMode(int i) {
        experimentalSetAudioMediaCodecOperationMode(i);
        experimentalSetVideoMediaCodecOperationMode(i);
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.enableFloatOutput = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.enableOffload = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.enableAudioTrackPlaybackParams = z;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioTrackPlaybackParams, this.enableOffload);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        Handler handler2 = handler;
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildVideoRenderers(android.content.Context r14, int r15, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r16, boolean r17, android.os.Handler r18, com.google.android.exoplayer2.video.VideoRendererEventListener r19, long r20, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r22) {
        /*
            r13 = this;
            r0 = r15
            r10 = r22
            java.lang.String r11 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r12 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            r9 = 50
            r1 = r12
            r2 = r14
            r3 = r16
            r4 = r20
            r6 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r6, r7, r8, r9)
            r1 = r13
            int r2 = r1.videoMediaCodecOperationMode
            r12.experimentalSetMediaCodecOperationMode(r2)
            r10.add(r12)
            if (r0 != 0) goto L_0x0024
            return
        L_0x0024:
            int r2 = r22.size()
            r3 = 2
            if (r0 != r3) goto L_0x002d
            int r2 = r2 + -1
        L_0x002d:
            r0 = 50
            r4 = 3
            r5 = 0
            r6 = 4
            r7 = 1
            java.lang.String r8 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r5] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class<android.os.Handler> r12 = android.os.Handler.class
            r9[r7] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r12 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r9[r3] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r4] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Long r12 = java.lang.Long.valueOf(r20)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r5] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r7] = r18     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r3] = r19     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r9[r4] = r12     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            com.google.android.exoplayer2.Renderer r8 = (com.google.android.exoplayer2.Renderer) r8     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            int r9 = r2 + 1
            r10.add(r2, r8)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            java.lang.String r2 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.m356i(r11, r2)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            goto L_0x007e
        L_0x0072:
            r2 = r9
            goto L_0x007d
        L_0x0074:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating VP9 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x007d:
            r9 = r2
        L_0x007e:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r8[r5] = r12     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class<android.os.Handler> r12 = android.os.Handler.class
            r8[r7] = r12     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r12 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r8[r3] = r12     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r8[r4] = r12     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Long r8 = java.lang.Long.valueOf(r20)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r6[r7] = r18     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r6[r3] = r19     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r6[r4] = r0     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Object r0 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r10.add(r9, r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.m356i(r11, r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating AV1 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildVideoRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r12, int r13, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r14, boolean r15, com.google.android.exoplayer2.audio.AudioSink r16, android.os.Handler r17, com.google.android.exoplayer2.audio.AudioRendererEventListener r18, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r19) {
        /*
            r11 = this;
            r0 = r13
            r8 = r19
            java.lang.String r9 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r10 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            r1 = r10
            r2 = r12
            r3 = r14
            r4 = r15
            r5 = r17
            r6 = r18
            r7 = r16
            r1.<init>((android.content.Context) r2, (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) r3, (boolean) r4, (android.os.Handler) r5, (com.google.android.exoplayer2.audio.AudioRendererEventListener) r6, (com.google.android.exoplayer2.audio.AudioSink) r7)
            r1 = r11
            int r2 = r1.audioMediaCodecOperationMode
            r10.experimentalSetMediaCodecOperationMode(r2)
            r8.add(r10)
            if (r0 != 0) goto L_0x0020
            return
        L_0x0020:
            int r2 = r19.size()
            r3 = 2
            if (r0 != r3) goto L_0x0029
            int r2 = r2 + -1
        L_0x0029:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r7[r0] = r10     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r10 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r10 = com.google.android.exoplayer2.audio.AudioSink.class
            r7[r3] = r10     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            r7[r0] = r17     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            r7[r5] = r18     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            r7[r3] = r16     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            com.google.android.exoplayer2.Renderer r6 = (com.google.android.exoplayer2.Renderer) r6     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x005f }
            int r7 = r2 + 1
            r8.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x005d, Exception -> 0x005f }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.m356i(r9, r2)     // Catch:{ ClassNotFoundException -> 0x005d, Exception -> 0x005f }
            goto L_0x0069
        L_0x005d:
            r2 = r7
            goto L_0x0068
        L_0x005f:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating Opus extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0068:
            r7 = r2
        L_0x0069:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r6[r0] = r10     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r10 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r6[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r10 = com.google.android.exoplayer2.audio.AudioSink.class
            r6[r3] = r10     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            r6[r0] = r17     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            r6[r5] = r18     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            r6[r3] = r16     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            com.google.android.exoplayer2.Renderer r2 = (com.google.android.exoplayer2.Renderer) r2     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x009c }
            int r6 = r7 + 1
            r8.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x009c }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.m356i(r9, r2)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x009c }
            goto L_0x00a6
        L_0x009a:
            r7 = r6
            goto L_0x00a5
        L_0x009c:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FLAC extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00a5:
            r6 = r7
        L_0x00a6:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r7[r0] = r10     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r10 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r10 = com.google.android.exoplayer2.audio.AudioSink.class
            r7[r3] = r10     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            r4[r0] = r17     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            r4[r5] = r18     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            r4[r3] = r16     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            r8.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.m356i(r9, r0)     // Catch:{ ClassNotFoundException -> 0x00de, Exception -> 0x00d5 }
            goto L_0x00de
        L_0x00d5:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FFmpeg extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildCameraMotionRenderers(Context context2, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public AudioSink buildAudioSink(Context context2, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink(AudioCapabilities.getCapabilities(context2), new DefaultAudioSink.DefaultAudioProcessorChain(new AudioProcessor[0]), z, z2, z3);
    }
}
