package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NMediaSelectionFragmentActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextView doneTextView;
    public final FragmentContainerView fragmentContainerView;
    private final LinearLayout rootView;
    public final TextView selectionCountView;
    public final LinearLayout selectionLayout;
    public final TextView titleTextView;

    private NMediaSelectionFragmentActivityBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, FragmentContainerView fragmentContainerView2, TextView textView2, LinearLayout linearLayout2, TextView textView3) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.doneTextView = textView;
        this.fragmentContainerView = fragmentContainerView2;
        this.selectionCountView = textView2;
        this.selectionLayout = linearLayout2;
        this.titleTextView = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NMediaSelectionFragmentActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaSelectionFragmentActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_selection_fragment_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaSelectionFragmentActivityBinding bind(View view) {
        int i = C4175R.C4179id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.done_text_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4175R.C4179id.fragment_container_view;
                FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(i);
                if (fragmentContainerView2 != null) {
                    i = C4175R.C4179id.selection_count_view;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C4175R.C4179id.selection_layout;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = C4175R.C4179id.title_text_view;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new NMediaSelectionFragmentActivityBinding((LinearLayout) view, imageView, textView, fragmentContainerView2, textView2, linearLayout, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
