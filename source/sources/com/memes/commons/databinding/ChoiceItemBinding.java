package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;
import java.util.Objects;

public final class ChoiceItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView titleView;

    private ChoiceItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.titleView = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static ChoiceItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChoiceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4144R.C4150layout.choice_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChoiceItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ChoiceItemBinding(textView, textView);
    }
}
