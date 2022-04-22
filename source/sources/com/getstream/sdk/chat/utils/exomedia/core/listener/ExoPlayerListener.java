package com.getstream.sdk.chat.utils.exomedia.core.listener;

import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.listener.OnSeekCompletionListener;

public interface ExoPlayerListener extends OnSeekCompletionListener {
    void onError(ExoMediaPlayer exoMediaPlayer, Exception exc);

    void onStateChanged(boolean z, int i);

    void onVideoSizeChanged(int i, int i2, int i3, float f);
}
