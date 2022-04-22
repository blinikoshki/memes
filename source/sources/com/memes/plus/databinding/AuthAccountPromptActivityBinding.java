package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class AuthAccountPromptActivityBinding implements ViewBinding {
    public final TextView continueWithEmailButton;
    public final LinearLayout continueWithFacebookButton;
    public final LinearLayout continueWithSnapchatButton;
    private final ConstraintLayout rootView;
    public final TextView signInTextView;
    public final TextView termsConditionsTextView;
    public final TextView titleTextView;

    private AuthAccountPromptActivityBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.continueWithEmailButton = textView;
        this.continueWithFacebookButton = linearLayout;
        this.continueWithSnapchatButton = linearLayout2;
        this.signInTextView = textView2;
        this.termsConditionsTextView = textView3;
        this.titleTextView = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthAccountPromptActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthAccountPromptActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_account_prompt_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthAccountPromptActivityBinding bind(View view) {
        int i = C4199R.C4203id.continue_with_email_button;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.continue_with_email_button);
        if (textView != null) {
            i = C4199R.C4203id.continue_with_facebook_button;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.continue_with_facebook_button);
            if (linearLayout != null) {
                i = C4199R.C4203id.continue_with_snapchat_button;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C4199R.C4203id.continue_with_snapchat_button);
                if (linearLayout2 != null) {
                    i = C4199R.C4203id.sign_in_text_view;
                    TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.sign_in_text_view);
                    if (textView2 != null) {
                        i = C4199R.C4203id.terms_conditions_text_view;
                        TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.terms_conditions_text_view);
                        if (textView3 != null) {
                            i = C4199R.C4203id.title_text_view;
                            TextView textView4 = (TextView) view.findViewById(C4199R.C4203id.title_text_view);
                            if (textView4 != null) {
                                return new AuthAccountPromptActivityBinding((ConstraintLayout) view, textView, linearLayout, linearLayout2, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
