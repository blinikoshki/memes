package com.memes.plus.custom.player;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.p024ui.PlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/plus/custom/player/ExoPlayerHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "eventListener", "Lcom/google/android/exoplayer2/Player$EventListener;", "playbackSpeed", "", "getPlaybackSpeed", "()F", "setPlaybackSpeed", "(F)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getPlayer", "mute", "", "pause", "release", "resume", "setMuted", "isMuted", "", "start", "mediaUri", "Landroid/net/Uri;", "playerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "toggleVolume", "unmute", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ExoPlayerHelper.kt */
public final class ExoPlayerHelper {
    private final Context context;
    private Player.EventListener eventListener;
    private float playbackSpeed = 1.0f;
    private SimpleExoPlayer player;

    public ExoPlayerHelper(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    public final void setPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    public final SimpleExoPlayer getPlayer() {
        return this.player;
    }

    public static /* synthetic */ void start$default(ExoPlayerHelper exoPlayerHelper, Uri uri, PlayerView playerView, Player.EventListener eventListener2, int i, Object obj) {
        if ((i & 4) != 0) {
            eventListener2 = null;
        }
        exoPlayerHelper.start(uri, playerView, eventListener2);
    }

    public final void start(Uri uri, PlayerView playerView, Player.EventListener eventListener2) {
        SimpleExoPlayer simpleExoPlayer;
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        this.eventListener = eventListener2;
        if (this.player == null) {
            SimpleExoPlayer build = new SimpleExoPlayer.Builder(this.context).build();
            Intrinsics.checkNotNullExpressionValue(build, "SimpleExoPlayer.Builder(context).build()");
            build.setPlaybackParameters(new PlaybackParameters(this.playbackSpeed));
            playerView.setUseController(false);
            playerView.setPlayer(build);
            playerView.setKeepContentOnPlayerReset(true);
            build.setPlayWhenReady(true);
            build.setRepeatMode(2);
            this.player = build;
        }
        if (!(eventListener2 == null || (simpleExoPlayer = this.player) == null)) {
            simpleExoPlayer.addListener(eventListener2);
        }
        if (uri == null) {
            release();
            return;
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            MediaSourceCreator mediaSourceCreator = MediaSourceCreator.INSTANCE;
            Context context2 = playerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "playerView.context");
            simpleExoPlayer2.prepare(mediaSourceCreator.buildMediaSource(context2, uri), true, false);
        }
    }

    public final void pause() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null && simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public final void resume() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null && simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public final void release() {
        SimpleExoPlayer simpleExoPlayer;
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.stop();
            }
            Player.EventListener eventListener2 = this.eventListener;
            if (!(eventListener2 == null || (simpleExoPlayer = this.player) == null)) {
                simpleExoPlayer.removeListener(eventListener2);
            }
            SimpleExoPlayer simpleExoPlayer3 = this.player;
            if (simpleExoPlayer3 != null) {
                simpleExoPlayer3.setPlayWhenReady(false);
            }
            SimpleExoPlayer simpleExoPlayer4 = this.player;
            if (simpleExoPlayer4 != null) {
                simpleExoPlayer4.release();
            }
            this.player = null;
        }
    }

    private final void unmute() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(1.0f);
        }
    }

    private final void mute() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(0.0f);
        }
    }

    public final void setMuted(boolean z) {
        if (z) {
            mute();
        } else {
            unmute();
        }
    }

    public final boolean toggleVolume() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null || simpleExoPlayer.getVolume() != 0.0f) {
            mute();
        } else {
            unmute();
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        return simpleExoPlayer2 == null || simpleExoPlayer2.getVolume() != 0.0f;
    }
}
