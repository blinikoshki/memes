package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class TagPeopleActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final ContentLayout contentLayout;
    public final TextView doneTextView;
    public final ImageView previewImageView;
    public final PlayerView previewPlayerView;
    private final LinearLayout rootView;
    public final LinearLayout tagMorePeopleLayout;
    public final LinearLayout tagPeopleLayout;
    public final RecyclerView taggedPeopleRecyclerView;

    private TagPeopleActivityBinding(LinearLayout linearLayout, ImageView imageView, ContentLayout contentLayout2, TextView textView, ImageView imageView2, PlayerView playerView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.contentLayout = contentLayout2;
        this.doneTextView = textView;
        this.previewImageView = imageView2;
        this.previewPlayerView = playerView;
        this.tagMorePeopleLayout = linearLayout2;
        this.tagPeopleLayout = linearLayout3;
        this.taggedPeopleRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TagPeopleActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TagPeopleActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.tag_people_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TagPeopleActivityBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.content_layout;
            ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
            if (contentLayout2 != null) {
                i = C4199R.C4203id.done_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.done_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.preview_image_view;
                    ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.preview_image_view);
                    if (imageView2 != null) {
                        i = C4199R.C4203id.preview_player_view;
                        PlayerView playerView = (PlayerView) view.findViewById(C4199R.C4203id.preview_player_view);
                        if (playerView != null) {
                            i = C4199R.C4203id.tag_more_people_layout;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.tag_more_people_layout);
                            if (linearLayout != null) {
                                i = C4199R.C4203id.tag_people_layout;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C4199R.C4203id.tag_people_layout);
                                if (linearLayout2 != null) {
                                    i = C4199R.C4203id.tagged_people_recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.tagged_people_recycler_view);
                                    if (recyclerView != null) {
                                        return new TagPeopleActivityBinding((LinearLayout) view, imageView, contentLayout2, textView, imageView2, playerView, linearLayout, linearLayout2, recyclerView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
