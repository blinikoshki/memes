package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import java.util.Objects;

public final class ChannelMembersShowAllItemBinding implements ViewBinding {
    private final LinearLayout rootView;

    private ChannelMembersShowAllItemBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelMembersShowAllItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelMembersShowAllItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_members_show_all_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelMembersShowAllItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ChannelMembersShowAllItemBinding((LinearLayout) view);
    }
}
