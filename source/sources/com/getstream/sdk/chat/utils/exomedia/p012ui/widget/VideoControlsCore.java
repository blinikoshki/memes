package com.getstream.sdk.chat.utils.exomedia.p012ui.widget;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoControlsCore */
public interface VideoControlsCore {
    void finishLoading();

    void hide(boolean z);

    boolean isVisible();

    void onAttachedToView(VideoView videoView);

    void onDetachedFromView(VideoView videoView);

    void setDuration(long j);

    void show();

    void showLoading(boolean z);

    void updatePlaybackState(boolean z);
}
