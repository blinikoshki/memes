package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;

public final class CreateChatActivityBinding implements ViewBinding {
    public final Button createChannelButton;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final EditText userIdEditText;

    private CreateChatActivityBinding(LinearLayout linearLayout, Button button, Toolbar toolbar2, EditText editText) {
        this.rootView = linearLayout;
        this.createChannelButton = button;
        this.toolbar = toolbar2;
        this.userIdEditText = editText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CreateChatActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CreateChatActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.create_chat_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CreateChatActivityBinding bind(View view) {
        int i = C4059R.C4063id.create_channel_button;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C4059R.C4063id.toolbar;
            Toolbar toolbar2 = (Toolbar) view.findViewById(i);
            if (toolbar2 != null) {
                i = C4059R.C4063id.user_id_edit_text;
                EditText editText = (EditText) view.findViewById(i);
                if (editText != null) {
                    return new CreateChatActivityBinding((LinearLayout) view, button, toolbar2, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
