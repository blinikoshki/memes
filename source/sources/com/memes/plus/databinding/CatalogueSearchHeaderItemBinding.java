package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class CatalogueSearchHeaderItemBinding implements ViewBinding {
    public final TextView headerTitleTextView;
    private final TextView rootView;

    private CatalogueSearchHeaderItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.headerTitleTextView = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static CatalogueSearchHeaderItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CatalogueSearchHeaderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.catalogue_search_header_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogueSearchHeaderItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new CatalogueSearchHeaderItemBinding(textView, textView);
    }
}
