package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.chat.C4059R;

public final class GroupNameInputDialogBinding implements ViewBinding {
    public final TextInputEditText channelNameEditText;
    public final TextView channelNameErrorTextView;
    private final LinearLayout rootView;

    private GroupNameInputDialogBinding(LinearLayout linearLayout, TextInputEditText textInputEditText, TextView textView) {
        this.rootView = linearLayout;
        this.channelNameEditText = textInputEditText;
        this.channelNameErrorTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GroupNameInputDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GroupNameInputDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.group_name_input_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GroupNameInputDialogBinding bind(View view) {
        int i = C4059R.C4063id.channel_name_edit_text;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(i);
        if (textInputEditText != null) {
            i = C4059R.C4063id.channel_name_error_text_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new GroupNameInputDialogBinding((LinearLayout) view, textInputEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
