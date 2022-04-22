package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.C4175R;

public final class NEditorEntryFrameSizeItemBinding implements ViewBinding {
    public final AspectRatioFrameLayout aspectRatioLayout;
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView subtitleTextView;
    public final TextView titleTextView;

    private NEditorEntryFrameSizeItemBinding(LinearLayout linearLayout, AspectRatioFrameLayout aspectRatioFrameLayout, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.aspectRatioLayout = aspectRatioFrameLayout;
        this.imageView = imageView2;
        this.subtitleTextView = textView;
        this.titleTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NEditorEntryFrameSizeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NEditorEntryFrameSizeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_editor_entry_frame_size_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NEditorEntryFrameSizeItemBinding bind(View view) {
        int i = C4175R.C4179id.aspect_ratio_layout;
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) view.findViewById(i);
        if (aspectRatioFrameLayout != null) {
            i = C4175R.C4179id.image_view;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C4175R.C4179id.subtitle_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4175R.C4179id.title_text_view;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new NEditorEntryFrameSizeItemBinding((LinearLayout) view, aspectRatioFrameLayout, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
