package com.google.android.exoplayer2;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$6KZj6jeBk3y4xp24TnhZsWGlwhA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExoPlayerImpl$6KZj6jeBk3y4xp24TnhZsWGlwhA implements BasePlayer.ListenerInvocation {
    public static final /* synthetic */ $$Lambda$ExoPlayerImpl$6KZj6jeBk3y4xp24TnhZsWGlwhA INSTANCE = new $$Lambda$ExoPlayerImpl$6KZj6jeBk3y4xp24TnhZsWGlwhA();

    private /* synthetic */ $$Lambda$ExoPlayerImpl$6KZj6jeBk3y4xp24TnhZsWGlwhA() {
    }

    public final void invokeListener(Player.EventListener eventListener) {
        eventListener.onPlayerError(ExoPlaybackException.createForTimeout(new TimeoutException("Player release timed out."), 1));
    }
}
