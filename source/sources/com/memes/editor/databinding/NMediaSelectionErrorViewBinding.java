package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NMediaSelectionErrorViewBinding implements ViewBinding {
    public final TextView messageTextView;
    public final ProgressBar progressBar;
    public final TextView retryView;
    private final View rootView;

    private NMediaSelectionErrorViewBinding(View view, TextView textView, ProgressBar progressBar2, TextView textView2) {
        this.rootView = view;
        this.messageTextView = textView;
        this.progressBar = progressBar2;
        this.retryView = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NMediaSelectionErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4175R.C4181layout.n_media_selection_error_view, viewGroup);
        return bind(viewGroup);
    }

    public static NMediaSelectionErrorViewBinding bind(View view) {
        int i = C4175R.C4179id.message_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.progress_bar;
            ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
            if (progressBar2 != null) {
                i = C4175R.C4179id.retry_view;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new NMediaSelectionErrorViewBinding(view, textView, progressBar2, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
