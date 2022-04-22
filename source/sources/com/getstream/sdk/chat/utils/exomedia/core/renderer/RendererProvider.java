package com.getstream.sdk.chat.utils.exomedia.core.renderer;

import android.content.Context;
import android.os.Handler;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.List;

public class RendererProvider {
    protected AudioRendererEventListener audioRendererEventListener;
    protected TextOutput captionListener;
    protected Context context;
    protected DrmSessionManager drmSessionManager;
    protected int droppedFrameNotificationAmount = 50;
    protected Handler handler;
    protected MetadataOutput metadataListener;
    protected int videoJoiningTimeMs = 5000;
    protected VideoRendererEventListener videoRendererEventListener;

    public RendererProvider(Context context2, Handler handler2, TextOutput textOutput, MetadataOutput metadataOutput, AudioRendererEventListener audioRendererEventListener2, VideoRendererEventListener videoRendererEventListener2) {
        this.context = context2;
        this.handler = handler2;
        this.captionListener = textOutput;
        this.metadataListener = metadataOutput;
        this.audioRendererEventListener = audioRendererEventListener2;
        this.videoRendererEventListener = videoRendererEventListener2;
    }

    public void setDrmSessionManager(DrmSessionManager drmSessionManager2) {
        this.drmSessionManager = drmSessionManager2;
    }

    public void setDroppedFrameNotificationAmount(int i) {
        this.droppedFrameNotificationAmount = i;
    }

    public void setVideoJoiningTimeMs(int i) {
        this.videoJoiningTimeMs = i;
    }

    public List<Renderer> generate() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(buildAudioRenderers());
        arrayList.addAll(buildVideoRenderers());
        arrayList.addAll(buildCaptionRenderers());
        arrayList.addAll(buildMetadataRenderers());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<Renderer> buildAudioRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecAudioRenderer(this.context, MediaCodecSelector.DEFAULT, this.handler, this.audioRendererEventListener, AudioCapabilities.getCapabilities(this.context), new AudioProcessor[0]));
        List<String> list = ExoMedia.Data.registeredRendererClasses.get(ExoMedia.RendererType.AUDIO);
        if (list != null) {
            for (String cls : list) {
                try {
                    arrayList.add((Renderer) Class.forName(cls).getConstructor(new Class[]{Handler.class, AudioRendererEventListener.class}).newInstance(new Object[]{this.handler, this.audioRendererEventListener}));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<Renderer> buildVideoRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecVideoRenderer(this.context, MediaCodecSelector.DEFAULT, (long) this.videoJoiningTimeMs, this.handler, this.videoRendererEventListener, this.droppedFrameNotificationAmount));
        List<String> list = ExoMedia.Data.registeredRendererClasses.get(ExoMedia.RendererType.VIDEO);
        if (list != null) {
            for (String cls : list) {
                try {
                    arrayList.add((Renderer) Class.forName(cls).getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE}).newInstance(new Object[]{true, Integer.valueOf(this.videoJoiningTimeMs), this.handler, this.videoRendererEventListener, Integer.valueOf(this.droppedFrameNotificationAmount)}));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<Renderer> buildCaptionRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextRenderer(this.captionListener, this.handler.getLooper()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<Renderer> buildMetadataRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MetadataRenderer(this.metadataListener, this.handler.getLooper(), MetadataDecoderFactory.DEFAULT));
        return arrayList;
    }
}
