package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.plus.C4199R;

public final class AuthFbLoginActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextInputEditText emailEditText;
    public final LoginButton facebookLoginButton;
    public final ConstraintLayout fbEmailPromptLayout;
    private final FrameLayout rootView;
    public final TextView submitButton;

    private AuthFbLoginActivityBinding(FrameLayout frameLayout, ImageView imageView, TextInputEditText textInputEditText, LoginButton loginButton, ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = frameLayout;
        this.backImageView = imageView;
        this.emailEditText = textInputEditText;
        this.facebookLoginButton = loginButton;
        this.fbEmailPromptLayout = constraintLayout;
        this.submitButton = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AuthFbLoginActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthFbLoginActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_fb_login_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthFbLoginActivityBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.email_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.email_edit_text);
            if (textInputEditText != null) {
                i = C4199R.C4203id.facebook_login_button;
                LoginButton loginButton = (LoginButton) view.findViewById(C4199R.C4203id.facebook_login_button);
                if (loginButton != null) {
                    i = C4199R.C4203id.fb_email_prompt_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C4199R.C4203id.fb_email_prompt_layout);
                    if (constraintLayout != null) {
                        i = C4199R.C4203id.submit_button;
                        TextView textView = (TextView) view.findViewById(C4199R.C4203id.submit_button);
                        if (textView != null) {
                            return new AuthFbLoginActivityBinding((FrameLayout) view, imageView, textInputEditText, loginButton, constraintLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
