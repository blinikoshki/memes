package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.commons.contentlayout.ContentLayout;

public final class ChatStartupActivityBinding implements ViewBinding {
    public final ContentLayout chatStartupContentLayout;
    private final LinearLayout rootView;

    private ChatStartupActivityBinding(LinearLayout linearLayout, ContentLayout contentLayout) {
        this.rootView = linearLayout;
        this.chatStartupContentLayout = contentLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChatStartupActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChatStartupActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.chat_startup_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChatStartupActivityBinding bind(View view) {
        int i = C4059R.C4063id.chat_startup_content_layout;
        ContentLayout contentLayout = (ContentLayout) view.findViewById(i);
        if (contentLayout != null) {
            return new ChatStartupActivityBinding((LinearLayout) view, contentLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
