package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NChoiceItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView titleView;

    private NChoiceItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.titleView = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static NChoiceItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NChoiceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_choice_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NChoiceItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new NChoiceItemBinding(textView, textView);
    }
}
