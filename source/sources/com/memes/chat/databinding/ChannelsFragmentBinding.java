package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.view.channels.ChannelsView;
import com.memes.chat.C4059R;

public final class ChannelsFragmentBinding implements ViewBinding {
    public final ChannelsView channelsView;
    public final ProgressBar loadingNextPageProgressBar;
    private final ConstraintLayout rootView;

    private ChannelsFragmentBinding(ConstraintLayout constraintLayout, ChannelsView channelsView2, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.channelsView = channelsView2;
        this.loadingNextPageProgressBar = progressBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChannelsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channels_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelsFragmentBinding bind(View view) {
        int i = C4059R.C4063id.channels_view;
        ChannelsView channelsView2 = (ChannelsView) view.findViewById(i);
        if (channelsView2 != null) {
            i = C4059R.C4063id.loading_next_page_progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(i);
            if (progressBar != null) {
                return new ChannelsFragmentBinding((ConstraintLayout) view, channelsView2, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
