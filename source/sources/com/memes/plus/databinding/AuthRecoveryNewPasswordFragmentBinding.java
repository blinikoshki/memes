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

public final class AuthRecoveryNewPasswordFragmentBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextInputEditText confirmPasswordEditText;
    public final TextInputEditText newPasswordEditText;
    private final ConstraintLayout rootView;
    public final TextView submitButton;

    private AuthRecoveryNewPasswordFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextView textView) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.confirmPasswordEditText = textInputEditText;
        this.newPasswordEditText = textInputEditText2;
        this.submitButton = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthRecoveryNewPasswordFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthRecoveryNewPasswordFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_recovery_new_password_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthRecoveryNewPasswordFragmentBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.confirm_password_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.confirm_password_edit_text);
            if (textInputEditText != null) {
                i = C4199R.C4203id.new_password_edit_text;
                TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(C4199R.C4203id.new_password_edit_text);
                if (textInputEditText2 != null) {
                    i = C4199R.C4203id.submit_button;
                    TextView textView = (TextView) view.findViewById(C4199R.C4203id.submit_button);
                    if (textView != null) {
                        return new AuthRecoveryNewPasswordFragmentBinding((ConstraintLayout) view, imageView, textInputEditText, textInputEditText2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
