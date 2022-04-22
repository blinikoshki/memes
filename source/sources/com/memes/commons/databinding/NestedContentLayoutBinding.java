package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;
import java.util.Objects;

public final class NestedContentLayoutBinding implements ViewBinding {
    public final LinearLayout nestedErrorContainer;
    public final ImageView nestedErrorIconImageView;
    public final TextView nestedErrorMessageTextView;
    public final Button nestedErrorResolutionButton;
    public final ProgressBar nestedProgressBar;
    private final View rootView;

    private NestedContentLayoutBinding(View view, LinearLayout linearLayout, ImageView imageView, TextView textView, Button button, ProgressBar progressBar) {
        this.rootView = view;
        this.nestedErrorContainer = linearLayout;
        this.nestedErrorIconImageView = imageView;
        this.nestedErrorMessageTextView = textView;
        this.nestedErrorResolutionButton = button;
        this.nestedProgressBar = progressBar;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NestedContentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4144R.C4150layout.nested_content_layout, viewGroup);
        return bind(viewGroup);
    }

    public static NestedContentLayoutBinding bind(View view) {
        int i = C4144R.C4148id.nested_error_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = C4144R.C4148id.nested_error_icon_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4144R.C4148id.nested_error_message_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4144R.C4148id.nested_error_resolution_button;
                    Button button = (Button) view.findViewById(i);
                    if (button != null) {
                        i = C4144R.C4148id.nested_progress_bar;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(i);
                        if (progressBar != null) {
                            return new NestedContentLayoutBinding(view, linearLayout, imageView, textView, button, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
