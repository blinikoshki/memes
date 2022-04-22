package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import java.util.Objects;

public final class StreamItemLoadingMoreBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private StreamItemLoadingMoreBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemLoadingMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemLoadingMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_loading_more, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemLoadingMoreBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new StreamItemLoadingMoreBinding((ConstraintLayout) view);
    }
}
