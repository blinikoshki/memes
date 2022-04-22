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

public final class ContentLayoutBinding implements ViewBinding {
    public final LinearLayout errorContainer;
    public final ImageView errorIconImageView;
    public final TextView errorMessageTextView;
    public final Button errorResolutionButton;
    public final ProgressBar progressBar;
    private final View rootView;

    private ContentLayoutBinding(View view, LinearLayout linearLayout, ImageView imageView, TextView textView, Button button, ProgressBar progressBar2) {
        this.rootView = view;
        this.errorContainer = linearLayout;
        this.errorIconImageView = imageView;
        this.errorMessageTextView = textView;
        this.errorResolutionButton = button;
        this.progressBar = progressBar2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static ContentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4144R.C4150layout.content_layout, viewGroup);
        return bind(viewGroup);
    }

    public static ContentLayoutBinding bind(View view) {
        int i = C4144R.C4148id.error_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = C4144R.C4148id.error_icon_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4144R.C4148id.error_message_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4144R.C4148id.error_resolution_button;
                    Button button = (Button) view.findViewById(i);
                    if (button != null) {
                        i = C4144R.C4148id.progress_bar;
                        ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                        if (progressBar2 != null) {
                            return new ContentLayoutBinding(view, linearLayout, imageView, textView, button, progressBar2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
