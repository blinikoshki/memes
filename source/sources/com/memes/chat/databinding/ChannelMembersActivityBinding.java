package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.commons.contentlayout.ContentLayout;

public final class ChannelMembersActivityBinding implements ViewBinding {
    public final ImageView addMembersImageView;
    public final ImageView backImageView;
    public final ContentLayout contentLayout;
    public final ProgressBar loadingNextPageProgressBar;
    public final RecyclerView membersRecyclerView;
    private final LinearLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final ConstraintLayout titleContainer;
    public final TextView titleTextView;

    private ChannelMembersActivityBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ContentLayout contentLayout2, ProgressBar progressBar, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2, ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = linearLayout;
        this.addMembersImageView = imageView;
        this.backImageView = imageView2;
        this.contentLayout = contentLayout2;
        this.loadingNextPageProgressBar = progressBar;
        this.membersRecyclerView = recyclerView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.titleContainer = constraintLayout;
        this.titleTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelMembersActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelMembersActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_members_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelMembersActivityBinding bind(View view) {
        int i = C4059R.C4063id.add_members_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.back_image_view;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C4059R.C4063id.content_layout;
                ContentLayout contentLayout2 = (ContentLayout) view.findViewById(i);
                if (contentLayout2 != null) {
                    i = C4059R.C4063id.loading_next_page_progress_bar;
                    ProgressBar progressBar = (ProgressBar) view.findViewById(i);
                    if (progressBar != null) {
                        i = C4059R.C4063id.members_recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                        if (recyclerView != null) {
                            i = C4059R.C4063id.swipe_refresh_layout;
                            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) view.findViewById(i);
                            if (swipeRefreshLayout2 != null) {
                                i = C4059R.C4063id.title_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout != null) {
                                    i = C4059R.C4063id.title_text_view;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        return new ChannelMembersActivityBinding((LinearLayout) view, imageView, imageView2, contentLayout2, progressBar, recyclerView, swipeRefreshLayout2, constraintLayout, textView);
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
