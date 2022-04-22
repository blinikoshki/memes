package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NDeepFryFilterPreviewItemBinding implements ViewBinding {
    public final ImageView iconImageView;
    public final FrameLayout iconImageViewLayout;
    public final View premiumIndicatorView;
    private final ConstraintLayout rootView;
    public final TextView titleTextView;

    private NDeepFryFilterPreviewItemBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, View view, TextView textView) {
        this.rootView = constraintLayout;
        this.iconImageView = imageView;
        this.iconImageViewLayout = frameLayout;
        this.premiumIndicatorView = view;
        this.titleTextView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NDeepFryFilterPreviewItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NDeepFryFilterPreviewItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_deep_fry_filter_preview_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.memes.editor.C4175R.C4179id.premium_indicator_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding bind(android.view.View r8) {
        /*
            int r0 = com.memes.editor.C4175R.C4179id.icon_image_view
            android.view.View r1 = r8.findViewById(r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.memes.editor.C4175R.C4179id.icon_image_view_layout
            android.view.View r1 = r8.findViewById(r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.memes.editor.C4175R.C4179id.premium_indicator_view
            android.view.View r6 = r8.findViewById(r0)
            if (r6 == 0) goto L_0x0033
            int r0 = com.memes.editor.C4175R.C4179id.title_text_view
            android.view.View r1 = r8.findViewById(r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0033
            com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding r0 = new com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding.bind(android.view.View):com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding");
    }
}
