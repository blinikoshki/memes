package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import java.util.Objects;

public final class VChatSearchLayoutBinding implements ViewBinding {
    private final View rootView;
    public final ImageView searchIndicatorImageView;
    public final ImageView searchInputCancelView;
    public final EditText searchInputEditText;

    private VChatSearchLayoutBinding(View view, ImageView imageView, ImageView imageView2, EditText editText) {
        this.rootView = view;
        this.searchIndicatorImageView = imageView;
        this.searchInputCancelView = imageView2;
        this.searchInputEditText = editText;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static VChatSearchLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4059R.C4065layout.v_chat_search_layout, viewGroup);
        return bind(viewGroup);
    }

    public static VChatSearchLayoutBinding bind(View view) {
        int i = C4059R.C4063id.search_indicator_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.search_input_cancel_view;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C4059R.C4063id.search_input_edit_text;
                EditText editText = (EditText) view.findViewById(i);
                if (editText != null) {
                    return new VChatSearchLayoutBinding(view, imageView, imageView2, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
