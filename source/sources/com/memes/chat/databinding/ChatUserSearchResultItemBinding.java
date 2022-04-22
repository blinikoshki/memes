package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class ChatUserSearchResultItemBinding implements ViewBinding {
    public final TextView fullNameTextView;
    public final Guideline guidelineVertical50;
    private final ConstraintLayout rootView;
    public final ChatUserAvatarView userAvatarView;
    public final AppCompatImageView userSelectionIndicatorView;
    public final TextView usernameTextView;

    private ChatUserSearchResultItemBinding(ConstraintLayout constraintLayout, TextView textView, Guideline guideline, ChatUserAvatarView chatUserAvatarView, AppCompatImageView appCompatImageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.fullNameTextView = textView;
        this.guidelineVertical50 = guideline;
        this.userAvatarView = chatUserAvatarView;
        this.userSelectionIndicatorView = appCompatImageView;
        this.usernameTextView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChatUserSearchResultItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChatUserSearchResultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.chat_user_search_result_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChatUserSearchResultItemBinding bind(View view) {
        int i = C4059R.C4063id.full_name_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4059R.C4063id.guideline_vertical_50;
            Guideline guideline = (Guideline) view.findViewById(i);
            if (guideline != null) {
                i = C4059R.C4063id.user_avatar_view;
                ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view.findViewById(i);
                if (chatUserAvatarView != null) {
                    i = C4059R.C4063id.user_selection_indicator_view;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
                    if (appCompatImageView != null) {
                        i = C4059R.C4063id.username_text_view;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new ChatUserSearchResultItemBinding((ConstraintLayout) view, textView, guideline, chatUserAvatarView, appCompatImageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
