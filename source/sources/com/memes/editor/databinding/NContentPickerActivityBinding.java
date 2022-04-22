package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NContentPickerActivityBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView statusTextView;

    private NContentPickerActivityBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.statusTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NContentPickerActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NContentPickerActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_content_picker_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NContentPickerActivityBinding bind(View view) {
        int i = C4175R.C4179id.status_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            return new NContentPickerActivityBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
