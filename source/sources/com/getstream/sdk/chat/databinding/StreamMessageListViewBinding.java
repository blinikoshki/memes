package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamMessageListViewBinding implements ViewBinding {
    public final RecyclerView chatMessagesRV;
    public final TextView defaultEmptyStateView;
    public final ProgressBar defaultLoadingView;
    public final FrameLayout emptyStateViewContainer;
    public final FrameLayout loadingViewContainer;
    public final TextView newMessagesTV;
    private final ConstraintLayout rootView;
    public final ConstraintLayout scrollBottomBtn;
    public final ImageView scrollIconIV;

    private StreamMessageListViewBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, ProgressBar progressBar, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.chatMessagesRV = recyclerView;
        this.defaultEmptyStateView = textView;
        this.defaultLoadingView = progressBar;
        this.emptyStateViewContainer = frameLayout;
        this.loadingViewContainer = frameLayout2;
        this.newMessagesTV = textView2;
        this.scrollBottomBtn = constraintLayout2;
        this.scrollIconIV = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamMessageListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamMessageListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_message_list_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamMessageListViewBinding bind(View view) {
        int i = C1673R.C1677id.chatMessagesRV;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            i = C1673R.C1677id.defaultEmptyStateView;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1673R.C1677id.defaultLoadingView;
                ProgressBar progressBar = (ProgressBar) view.findViewById(i);
                if (progressBar != null) {
                    i = C1673R.C1677id.emptyStateViewContainer;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                    if (frameLayout != null) {
                        i = C1673R.C1677id.loadingViewContainer;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(i);
                        if (frameLayout2 != null) {
                            i = C1673R.C1677id.newMessagesTV;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = C1673R.C1677id.scrollBottomBtn;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout != null) {
                                    i = C1673R.C1677id.scrollIconIV;
                                    ImageView imageView = (ImageView) view.findViewById(i);
                                    if (imageView != null) {
                                        return new StreamMessageListViewBinding((ConstraintLayout) view, recyclerView, textView, progressBar, frameLayout, frameLayout2, textView2, constraintLayout, imageView);
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
