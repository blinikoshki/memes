package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.editor.C4175R;
import editor.gpu.gpuimage.GPUImageView;

public final class NFiltersActivityBinding implements ViewBinding {
    public final ImageView backView;
    public final FragmentContainerView filtersFragmentContainer;
    public final GPUImageView photoView;
    private final LinearLayout rootView;
    public final PlayerView videoView;

    private NFiltersActivityBinding(LinearLayout linearLayout, ImageView imageView, FragmentContainerView fragmentContainerView, GPUImageView gPUImageView, PlayerView playerView) {
        this.rootView = linearLayout;
        this.backView = imageView;
        this.filtersFragmentContainer = fragmentContainerView;
        this.photoView = gPUImageView;
        this.videoView = playerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NFiltersActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NFiltersActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_filters_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NFiltersActivityBinding bind(View view) {
        int i = C4175R.C4179id.back_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.filters_fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
            if (fragmentContainerView != null) {
                i = C4175R.C4179id.photo_view;
                GPUImageView gPUImageView = (GPUImageView) view.findViewById(i);
                if (gPUImageView != null) {
                    i = C4175R.C4179id.video_view;
                    PlayerView playerView = (PlayerView) view.findViewById(i);
                    if (playerView != null) {
                        return new NFiltersActivityBinding((LinearLayout) view, imageView, fragmentContainerView, gPUImageView, playerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
