package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.plus.C4199R;
import com.memes.plus.custom.HighlightedToastView;

public final class AuthSignInActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final ImageView facebookSignInButton;
    public final TextView forgotPasswordTextView;
    public final Guideline guidelineHeight15;
    public final Guideline guidelineHeight80;
    public final Guideline guidelineHeight95;
    public final HighlightedToastView highlightedToastView;
    public final TextInputEditText identityEditText;
    public final TextInputEditText passwordEditText;
    private final ConstraintLayout rootView;
    public final TextView signInButton;
    public final TextView signUpTextView;
    public final ImageView snapchatSignInButton;
    public final TextView titleTextView;

    private AuthSignInActivityBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, HighlightedToastView highlightedToastView2, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextView textView2, TextView textView3, ImageView imageView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.facebookSignInButton = imageView2;
        this.forgotPasswordTextView = textView;
        this.guidelineHeight15 = guideline;
        this.guidelineHeight80 = guideline2;
        this.guidelineHeight95 = guideline3;
        this.highlightedToastView = highlightedToastView2;
        this.identityEditText = textInputEditText;
        this.passwordEditText = textInputEditText2;
        this.signInButton = textView2;
        this.signUpTextView = textView3;
        this.snapchatSignInButton = imageView3;
        this.titleTextView = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthSignInActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthSignInActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_sign_in_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthSignInActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.facebook_sign_in_button;
            ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.facebook_sign_in_button);
            if (imageView2 != null) {
                i = C4199R.C4203id.forgot_password_text_view;
                TextView textView = (TextView) view2.findViewById(C4199R.C4203id.forgot_password_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.guideline_height_15;
                    Guideline guideline = (Guideline) view2.findViewById(C4199R.C4203id.guideline_height_15);
                    if (guideline != null) {
                        i = C4199R.C4203id.guideline_height_80;
                        Guideline guideline2 = (Guideline) view2.findViewById(C4199R.C4203id.guideline_height_80);
                        if (guideline2 != null) {
                            i = C4199R.C4203id.guideline_height_95;
                            Guideline guideline3 = (Guideline) view2.findViewById(C4199R.C4203id.guideline_height_95);
                            if (guideline3 != null) {
                                i = C4199R.C4203id.highlighted_toast_view;
                                HighlightedToastView highlightedToastView2 = (HighlightedToastView) view2.findViewById(C4199R.C4203id.highlighted_toast_view);
                                if (highlightedToastView2 != null) {
                                    i = C4199R.C4203id.identity_edit_text;
                                    TextInputEditText textInputEditText = (TextInputEditText) view2.findViewById(C4199R.C4203id.identity_edit_text);
                                    if (textInputEditText != null) {
                                        i = C4199R.C4203id.password_edit_text;
                                        TextInputEditText textInputEditText2 = (TextInputEditText) view2.findViewById(C4199R.C4203id.password_edit_text);
                                        if (textInputEditText2 != null) {
                                            i = C4199R.C4203id.sign_in_button;
                                            TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.sign_in_button);
                                            if (textView2 != null) {
                                                i = C4199R.C4203id.sign_up_text_view;
                                                TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.sign_up_text_view);
                                                if (textView3 != null) {
                                                    i = C4199R.C4203id.snapchat_sign_in_button;
                                                    ImageView imageView3 = (ImageView) view2.findViewById(C4199R.C4203id.snapchat_sign_in_button);
                                                    if (imageView3 != null) {
                                                        i = C4199R.C4203id.title_text_view;
                                                        TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.title_text_view);
                                                        if (textView4 != null) {
                                                            return new AuthSignInActivityBinding((ConstraintLayout) view2, imageView, imageView2, textView, guideline, guideline2, guideline3, highlightedToastView2, textInputEditText, textInputEditText2, textView2, textView3, imageView3, textView4);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
