package com.google.android.exoplayer2;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$ZdR_kWewi848UdJeinjIp_lk11E  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExoPlayerImpl$ZdR_kWewi848UdJeinjIp_lk11E implements BasePlayer.ListenerInvocation {
    public static final /* synthetic */ $$Lambda$ExoPlayerImpl$ZdR_kWewi848UdJeinjIp_lk11E INSTANCE = new $$Lambda$ExoPlayerImpl$ZdR_kWewi848UdJeinjIp_lk11E();

    private /* synthetic */ $$Lambda$ExoPlayerImpl$ZdR_kWewi848UdJeinjIp_lk11E() {
    }

    public final void invokeListener(Player.EventListener eventListener) {
        eventListener.onPlayerError(ExoPlaybackException.createForTimeout(new TimeoutException("Setting foreground mode timed out."), 2));
    }
}
