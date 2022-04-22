package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class MediaViewerActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final ContentLayout contentLayout;
    public final ImageView previewImageView;
    public final PlayerView previewPlayerView;
    private final FrameLayout rootView;

    private MediaViewerActivityBinding(FrameLayout frameLayout, ImageView imageView, ContentLayout contentLayout2, ImageView imageView2, PlayerView playerView) {
        this.rootView = frameLayout;
        this.backImageView = imageView;
        this.contentLayout = contentLayout2;
        this.previewImageView = imageView2;
        this.previewPlayerView = playerView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MediaViewerActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MediaViewerActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.media_viewer_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MediaViewerActivityBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.content_layout;
            ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
            if (contentLayout2 != null) {
                i = C4199R.C4203id.preview_image_view;
                ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.preview_image_view);
                if (imageView2 != null) {
                    i = C4199R.C4203id.preview_player_view;
                    PlayerView playerView = (PlayerView) view.findViewById(C4199R.C4203id.preview_player_view);
                    if (playerView != null) {
                        return new MediaViewerActivityBinding((FrameLayout) view, imageView, contentLayout2, imageView2, playerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
