package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class WelcomeActivityBinding implements ViewBinding {
    public final ImageView backgroundImageView;
    public final Button finishWelcomeButton;
    public final TextView memeTextView;
    public final ImageView mimicBlur1ImageView;
    public final ImageView mimicBlur2ImageView;
    private final ConstraintLayout rootView;
    public final TextView termsConditionsTextView;
    public final Guideline topGd;
    public final LinearLayout welcomeMemeSection;
    public final LinearLayout welcomeSection;

    private WelcomeActivityBinding(ConstraintLayout constraintLayout, ImageView imageView, Button button, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, Guideline guideline, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.backgroundImageView = imageView;
        this.finishWelcomeButton = button;
        this.memeTextView = textView;
        this.mimicBlur1ImageView = imageView2;
        this.mimicBlur2ImageView = imageView3;
        this.termsConditionsTextView = textView2;
        this.topGd = guideline;
        this.welcomeMemeSection = linearLayout;
        this.welcomeSection = linearLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WelcomeActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WelcomeActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.welcome_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WelcomeActivityBinding bind(View view) {
        int i = C4199R.C4203id.background_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.background_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.finish_welcome_button;
            Button button = (Button) view.findViewById(C4199R.C4203id.finish_welcome_button);
            if (button != null) {
                i = C4199R.C4203id.meme_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.meme_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.mimic_blur_1_image_view;
                    ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.mimic_blur_1_image_view);
                    if (imageView2 != null) {
                        i = C4199R.C4203id.mimic_blur_2_image_view;
                        ImageView imageView3 = (ImageView) view.findViewById(C4199R.C4203id.mimic_blur_2_image_view);
                        if (imageView3 != null) {
                            i = C4199R.C4203id.terms_conditions_text_view;
                            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.terms_conditions_text_view);
                            if (textView2 != null) {
                                i = C4199R.C4203id.top_gd;
                                Guideline guideline = (Guideline) view.findViewById(C4199R.C4203id.top_gd);
                                if (guideline != null) {
                                    i = C4199R.C4203id.welcome_meme_section;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.welcome_meme_section);
                                    if (linearLayout != null) {
                                        i = C4199R.C4203id.welcome_section;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C4199R.C4203id.welcome_section);
                                        if (linearLayout2 != null) {
                                            return new WelcomeActivityBinding((ConstraintLayout) view, imageView, button, textView, imageView2, imageView3, textView2, guideline, linearLayout, linearLayout2);
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
