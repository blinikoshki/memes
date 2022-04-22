package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class ExportCaptionTagSuggestionItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView textView;

    private ExportCaptionTagSuggestionItemBinding(TextView textView2, TextView textView3) {
        this.rootView = textView2;
        this.textView = textView3;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static ExportCaptionTagSuggestionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ExportCaptionTagSuggestionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.export_caption_tag_suggestion_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ExportCaptionTagSuggestionItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView2 = (TextView) view;
        return new ExportCaptionTagSuggestionItemBinding(textView2, textView2);
    }
}
