package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;

public final class UserListingFragmentBinding implements ViewBinding {
    public final ImageView backNavigationImageview;
    public final ContentLayout contentLayout;
    public final TextView headerTextView;
    private final LinearLayout rootView;
    public final SnippetSearchBoxLayoutBinding searchBoxLayout;
    public final RecyclerView usersListRecyclerview;

    private UserListingFragmentBinding(LinearLayout linearLayout, ImageView imageView, ContentLayout contentLayout2, TextView textView, SnippetSearchBoxLayoutBinding snippetSearchBoxLayoutBinding, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.backNavigationImageview = imageView;
        this.contentLayout = contentLayout2;
        this.headerTextView = textView;
        this.searchBoxLayout = snippetSearchBoxLayoutBinding;
        this.usersListRecyclerview = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserListingFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static UserListingFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.user_listing_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserListingFragmentBinding bind(View view) {
        int i = C4199R.C4203id.back_navigation_imageview;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_navigation_imageview);
        if (imageView != null) {
            i = C4199R.C4203id.content_layout;
            ContentLayout contentLayout2 = (ContentLayout) view.findViewById(C4199R.C4203id.content_layout);
            if (contentLayout2 != null) {
                i = C4199R.C4203id.header_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.header_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.search_box_layout;
                    View findViewById = view.findViewById(C4199R.C4203id.search_box_layout);
                    if (findViewById != null) {
                        SnippetSearchBoxLayoutBinding bind = SnippetSearchBoxLayoutBinding.bind(findViewById);
                        i = C4199R.C4203id.users_list_recyclerview;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.users_list_recyclerview);
                        if (recyclerView != null) {
                            return new UserListingFragmentBinding((LinearLayout) view, imageView, contentLayout2, textView, bind, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
