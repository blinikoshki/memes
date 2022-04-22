package editor.common.mediaplayback;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\u001aJ\u0006\u0010*\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0001J\u0018\u0010/\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u00063"}, mo26107d2 = {"Leditor/common/mediaplayback/MediaPlaybackOrganiser;", "Lcom/google/android/exoplayer2/Player$EventListener;", "()V", "currentVolume", "", "hasAudioTrack", "", "playbackListener", "playbackSpeed", "getPlaybackSpeed", "()F", "setPlaybackSpeed", "(F)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "buildMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "context", "Landroid/content/Context;", "mediaUri", "Landroid/net/Uri;", "createPlayer", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "isPlaying", "mute", "", "onPlayerError", "playbackException", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "", "onTracksChanged", "trackGroups", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "trackSelections", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pause", "pauseSafely", "release", "releaseSafely", "resume", "resumeSafely", "setCallback", "listener", "start", "togglePlaybackState", "toggleVolume", "unmute", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaPlaybackOrganiser.kt */
public final class MediaPlaybackOrganiser implements Player.EventListener {
    private float currentVolume = 1.0f;
    private boolean hasAudioTrack;
    private Player.EventListener playbackListener;
    private float playbackSpeed = 1.0f;
    /* access modifiers changed from: private */
    public SimpleExoPlayer player;

    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
    }

    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
    }

    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
    }

    public /* synthetic */ void onLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onLoadingChanged(this, z);
    }

    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
    }

    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    public /* synthetic */ void onPlaybackStateChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    public /* synthetic */ void onPositionDiscontinuity(int i) {
        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
    }

    public /* synthetic */ void onRepeatModeChanged(int i) {
        Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
    }

    public /* synthetic */ void onSeekProcessed() {
        Player.EventListener.CC.$default$onSeekProcessed(this);
    }

    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
    }

    public static final /* synthetic */ SimpleExoPlayer access$getPlayer$p(MediaPlaybackOrganiser mediaPlaybackOrganiser) {
        SimpleExoPlayer simpleExoPlayer = mediaPlaybackOrganiser.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return simpleExoPlayer;
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    public final void setPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    public final void start(Uri uri, PlayerView playerView) {
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        this.player = createPlayer(playerView);
        setCallback(this);
        Context context = playerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "playerView.context");
        MediaSource buildMediaSource = buildMediaSource(context, uri);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.prepare(buildMediaSource);
    }

    public final void setCallback(Player.EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.addListener(eventListener);
        this.playbackListener = eventListener;
    }

    private final SimpleExoPlayer createPlayer(PlayerView playerView) {
        SimpleExoPlayer build = new SimpleExoPlayer.Builder(playerView.getContext()).build();
        Intrinsics.checkNotNullExpressionValue(build, "SimpleExoPlayer.Builder(…ayerView.context).build()");
        build.setPlaybackParameters(new PlaybackParameters(this.playbackSpeed));
        playerView.setUseController(false);
        playerView.setPlayer(build);
        playerView.setKeepContentOnPlayerReset(true);
        build.setPlayWhenReady(true);
        build.setRepeatMode(2);
        return build;
    }

    private final MediaSource buildMediaSource(Context context, Uri uri) {
        ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(context, (TransferListener) new DefaultBandwidthMeter.Builder(context).build(), (DataSource.Factory) new DefaultHttpDataSourceFactory("memes.editor"))).createMediaSource(uri);
        Intrinsics.checkNotNullExpressionValue(createMediaSource, "ProgressiveMediaSource\n\t…eateMediaSource(mediaUri)");
        return createMediaSource;
    }

    public final boolean hasAudioTrack() {
        return this.hasAudioTrack;
    }

    public final void mute() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.setVolume(0.0f);
    }

    public final void unmute() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.setVolume(1.0f);
    }

    public final boolean toggleVolume() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        if (simpleExoPlayer.getVolume() == 0.0f) {
            unmute();
        } else {
            mute();
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return simpleExoPlayer2.getVolume() != 0.0f;
    }

    public final void pause() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.setPlayWhenReady(false);
    }

    public final void pauseSafely() {
        if (this.player != null) {
            pause();
        }
    }

    public final void resume() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.setPlayWhenReady(true);
    }

    public final void resumeSafely() {
        if (this.player != null) {
            resume();
        }
    }

    public final boolean togglePlaybackState() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer.setPlayWhenReady(!simpleExoPlayer2.getPlayWhenReady());
        return isPlaying();
    }

    public final boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return simpleExoPlayer.getPlayWhenReady();
    }

    public final void release() {
        Player.EventListener eventListener = this.playbackListener;
        if (eventListener != null) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            simpleExoPlayer.removeListener(eventListener);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer2.setPlayWhenReady(false);
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer3.stop();
        SimpleExoPlayer simpleExoPlayer4 = this.player;
        if (simpleExoPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        simpleExoPlayer4.release();
    }

    public final void releaseSafely() {
        try {
            release();
        } catch (UninitializedPropertyAccessException unused) {
        }
    }

    public void onPlayerStateChanged(boolean z, int i) {
        Timber.m300d("onPlayerStateChanged(" + z + ", " + i + ')', new Object[0]);
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Intrinsics.checkNotNullParameter(trackGroupArray, "trackGroups");
        Intrinsics.checkNotNullParameter(trackSelectionArray, "trackSelections");
        Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        this.hasAudioTrack = false;
        int i = trackGroupArray.length;
        for (int i2 = 0; i2 < i; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int i3 = trackGroup.length;
            for (int i4 = 0; i4 < i3; i4++) {
                Format format = trackGroup.getFormat(i4);
                Timber.m306i("~> " + i2 + ' ' + i4 + ' ' + format, new Object[0]);
                String str = format.sampleMimeType;
                Boolean bool = null;
                if (str != null) {
                    bool = Boolean.valueOf(StringsKt.startsWith$default(str, MimeTypes.BASE_TYPE_AUDIO, false, 2, (Object) null));
                }
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    this.hasAudioTrack = true;
                }
            }
        }
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Exception exc;
        Intrinsics.checkNotNullParameter(exoPlaybackException, "playbackException");
        int i = exoPlaybackException.type;
        boolean z = true;
        if (i == 0) {
            IOException sourceException = exoPlaybackException.getSourceException();
            Intrinsics.checkNotNullExpressionValue(sourceException, "playbackException.sourceException");
            exc = sourceException;
        } else if (i == 1) {
            exc = exoPlaybackException.getRendererException();
            Intrinsics.checkNotNullExpressionValue(exc, "playbackException.rendererException");
        } else if (i != 2) {
            exc = exoPlaybackException;
        } else {
            RuntimeException unexpectedException = exoPlaybackException.getUnexpectedException();
            Intrinsics.checkNotNullExpressionValue(unexpectedException, "playbackException.unexpectedException");
            exc = unexpectedException;
        }
        CharSequence message = exc.getMessage();
        if (message != null && !StringsKt.isBlank(message)) {
            z = false;
        }
        if (!z) {
            exc.getMessage();
        }
    }
}
