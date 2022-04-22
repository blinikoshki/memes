package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class CatalogueSearchPeopleItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView searchResultPersonFollowersTextView;
    public final UserAvatarView searchResultPersonImageView;
    public final TextView searchResultPersonNameTextView;

    private CatalogueSearchPeopleItemBinding(LinearLayout linearLayout, TextView textView, UserAvatarView userAvatarView, TextView textView2) {
        this.rootView = linearLayout;
        this.searchResultPersonFollowersTextView = textView;
        this.searchResultPersonImageView = userAvatarView;
        this.searchResultPersonNameTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CatalogueSearchPeopleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueSearchPeopleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_search_people_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueSearchPeopleItemBinding bind(View view) {
        int i = C4199R.C4203id.search_result_person_followers_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.search_result_person_followers_text_view);
        if (textView != null) {
            i = C4199R.C4203id.search_result_person_image_view;
            UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.search_result_person_image_view);
            if (userAvatarView != null) {
                i = C4199R.C4203id.search_result_person_name_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.search_result_person_name_text_view);
                if (textView2 != null) {
                    return new CatalogueSearchPeopleItemBinding((LinearLayout) view, textView, userAvatarView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
