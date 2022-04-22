package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class CatalogueRecentlySearchedPersonItemBinding implements ViewBinding {
    public final UserAvatarView personImageView;
    public final TextView personNameTextView;
    public final ImageView personRemoveImageView;
    private final LinearLayout rootView;

    private CatalogueRecentlySearchedPersonItemBinding(LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView, ImageView imageView) {
        this.rootView = linearLayout;
        this.personImageView = userAvatarView;
        this.personNameTextView = textView;
        this.personRemoveImageView = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CatalogueRecentlySearchedPersonItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueRecentlySearchedPersonItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_recently_searched_person_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueRecentlySearchedPersonItemBinding bind(View view) {
        int i = C4199R.C4203id.person_image_view;
        UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.person_image_view);
        if (userAvatarView != null) {
            i = C4199R.C4203id.person_name_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.person_name_text_view);
            if (textView != null) {
                i = C4199R.C4203id.person_remove_image_view;
                ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.person_remove_image_view);
                if (imageView != null) {
                    return new CatalogueRecentlySearchedPersonItemBinding((LinearLayout) view, userAvatarView, textView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
