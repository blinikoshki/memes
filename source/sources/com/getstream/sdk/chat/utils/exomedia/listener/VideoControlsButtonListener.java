package com.getstream.sdk.chat.utils.exomedia.listener;

public interface VideoControlsButtonListener {
    boolean onFastForwardClicked();

    boolean onNextClicked();

    boolean onPlayPauseClicked();

    boolean onPreviousClicked();

    boolean onRewindClicked();
}
