package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatSearchInputLayout;
import com.memes.commons.contentlayout.ContentLayout;

public final class ChooseChannelMembersFragmentBinding implements ViewBinding {
    public final RecyclerView channelMembersRecyclerView;
    public final ProgressBar loadingNextPageProgressBar;
    public final TextView nameInputLabel;
    public final ChatSearchInputLayout nameInputLayout;
    private final ConstraintLayout rootView;
    public final ContentLayout searchResultsContentLayout;
    public final RecyclerView searchResultsRecyclerView;

    private ChooseChannelMembersFragmentBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ProgressBar progressBar, TextView textView, ChatSearchInputLayout chatSearchInputLayout, ContentLayout contentLayout, RecyclerView recyclerView2) {
        this.rootView = constraintLayout;
        this.channelMembersRecyclerView = recyclerView;
        this.loadingNextPageProgressBar = progressBar;
        this.nameInputLabel = textView;
        this.nameInputLayout = chatSearchInputLayout;
        this.searchResultsContentLayout = contentLayout;
        this.searchResultsRecyclerView = recyclerView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChooseChannelMembersFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChooseChannelMembersFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.choose_channel_members_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChooseChannelMembersFragmentBinding bind(View view) {
        int i = C4059R.C4063id.channel_members_recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            i = C4059R.C4063id.loading_next_page_progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(i);
            if (progressBar != null) {
                i = C4059R.C4063id.name_input_label;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4059R.C4063id.name_input_layout;
                    ChatSearchInputLayout chatSearchInputLayout = (ChatSearchInputLayout) view.findViewById(i);
                    if (chatSearchInputLayout != null) {
                        i = C4059R.C4063id.search_results_content_layout;
                        ContentLayout contentLayout = (ContentLayout) view.findViewById(i);
                        if (contentLayout != null) {
                            i = C4059R.C4063id.search_results_recycler_view;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
                            if (recyclerView2 != null) {
                                return new ChooseChannelMembersFragmentBinding((ConstraintLayout) view, recyclerView, progressBar, textView, chatSearchInputLayout, contentLayout, recyclerView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
