package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NMediaViewBinding implements ViewBinding {
    public final LinearLayout mediaControlsLayout;
    public final ImageView photoView;
    public final ImageView placeholderView;
    public final ImageView playbackToggleButton;
    private final View rootView;
    public final PlayerView videoView;
    public final ImageView volumeToggleButton;

    private NMediaViewBinding(View view, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, PlayerView playerView, ImageView imageView4) {
        this.rootView = view;
        this.mediaControlsLayout = linearLayout;
        this.photoView = imageView;
        this.placeholderView = imageView2;
        this.playbackToggleButton = imageView3;
        this.videoView = playerView;
        this.volumeToggleButton = imageView4;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NMediaViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4175R.C4181layout.n_media_view, viewGroup);
        return bind(viewGroup);
    }

    public static NMediaViewBinding bind(View view) {
        int i = C4175R.C4179id.media_controls_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = C4175R.C4179id.photo_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4175R.C4179id.placeholder_view;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C4175R.C4179id.playback_toggle_button;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = C4175R.C4179id.video_view;
                        PlayerView playerView = (PlayerView) view.findViewById(i);
                        if (playerView != null) {
                            i = C4175R.C4179id.volume_toggle_button;
                            ImageView imageView4 = (ImageView) view.findViewById(i);
                            if (imageView4 != null) {
                                return new NMediaViewBinding(view, linearLayout, imageView, imageView2, imageView3, playerView, imageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
