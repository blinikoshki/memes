package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.plus.C4199R;

public final class AuthSnapChatSignInActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextInputEditText emailEditText;
    private final ConstraintLayout rootView;
    public final ConstraintLayout scEmailPromptLayout;
    public final TextView submitButton;

    private AuthSnapChatSignInActivityBinding(ConstraintLayout constraintLayout, ImageView imageView, TextInputEditText textInputEditText, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.emailEditText = textInputEditText;
        this.scEmailPromptLayout = constraintLayout2;
        this.submitButton = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthSnapChatSignInActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthSnapChatSignInActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_snap_chat_sign_in_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthSnapChatSignInActivityBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.email_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.email_edit_text);
            if (textInputEditText != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C4199R.C4203id.submit_button;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.submit_button);
                if (textView != null) {
                    return new AuthSnapChatSignInActivityBinding(constraintLayout, imageView, textInputEditText, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
