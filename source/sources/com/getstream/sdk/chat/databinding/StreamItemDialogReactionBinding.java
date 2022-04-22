package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemDialogReactionBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvCount;
    public final TextView tvEmoji;

    private StreamItemDialogReactionBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvCount = textView;
        this.tvEmoji = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemDialogReactionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemDialogReactionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_dialog_reaction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemDialogReactionBinding bind(View view) {
        int i = C1673R.C1677id.tv_count;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C1673R.C1677id.tv_emoji;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new StreamItemDialogReactionBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
