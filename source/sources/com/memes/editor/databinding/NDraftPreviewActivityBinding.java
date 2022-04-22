package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NDraftPreviewActivityBinding implements ViewBinding {
    public final ImageView closeDraftPreviewView;
    public final TextView deleteDraftView;
    public final TextView editDraftView;
    private final LinearLayout rootView;
    public final TextView shareDraftView;
    public final ImageView thumbnailImageView;

    private NDraftPreviewActivityBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ImageView imageView2) {
        this.rootView = linearLayout;
        this.closeDraftPreviewView = imageView;
        this.deleteDraftView = textView;
        this.editDraftView = textView2;
        this.shareDraftView = textView3;
        this.thumbnailImageView = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NDraftPreviewActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NDraftPreviewActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_draft_preview_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NDraftPreviewActivityBinding bind(View view) {
        int i = C4175R.C4179id.close_draft_preview_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.delete_draft_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4175R.C4179id.edit_draft_view;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C4175R.C4179id.share_draft_view;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        i = C4175R.C4179id.thumbnail_image_view;
                        ImageView imageView2 = (ImageView) view.findViewById(i);
                        if (imageView2 != null) {
                            return new NDraftPreviewActivityBinding((LinearLayout) view, imageView, textView, textView2, textView3, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
