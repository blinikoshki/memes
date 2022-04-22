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

public final class AuthRecoveryOtpConfirmationFragmentBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextInputEditText otpEditText;
    public final TextView resendOtpTextView;
    private final ConstraintLayout rootView;
    public final TextView submitButton;

    private AuthRecoveryOtpConfirmationFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextInputEditText textInputEditText, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.otpEditText = textInputEditText;
        this.resendOtpTextView = textView;
        this.submitButton = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthRecoveryOtpConfirmationFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthRecoveryOtpConfirmationFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_recovery_otp_confirmation_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthRecoveryOtpConfirmationFragmentBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.otp_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.otp_edit_text);
            if (textInputEditText != null) {
                i = C4199R.C4203id.resend_otp_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.resend_otp_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.submit_button;
                    TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.submit_button);
                    if (textView2 != null) {
                        return new AuthRecoveryOtpConfirmationFragmentBinding((ConstraintLayout) view, imageView, textInputEditText, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
