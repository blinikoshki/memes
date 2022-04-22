package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;

public final class NAlertMessageBottomSheetBinding implements ViewBinding {
    public final TextView messageTextView;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private NAlertMessageBottomSheetBinding(LinearLayout linearLayout, TextView textView, MaterialButton materialButton, MaterialButton materialButton2, TextView textView2) {
        this.rootView = linearLayout;
        this.messageTextView = textView;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
        this.titleTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NAlertMessageBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NAlertMessageBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_alert_message_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NAlertMessageBottomSheetBinding bind(View view) {
        int i = C4175R.C4179id.message_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.negative_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(i);
            if (materialButton != null) {
                i = C4175R.C4179id.positive_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(i);
                if (materialButton2 != null) {
                    i = C4175R.C4179id.title_text_view;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new NAlertMessageBottomSheetBinding((LinearLayout) view, textView, materialButton, materialButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
