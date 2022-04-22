package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class PromoItemBinding implements ViewBinding {
    public final ImageView promoImageView;
    private final LinearLayout rootView;

    private PromoItemBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.promoImageView = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PromoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PromoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.promo_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PromoItemBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.promo_image_view);
        if (imageView != null) {
            return new PromoItemBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C4199R.C4203id.promo_image_view)));
    }
}
