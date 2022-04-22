package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.optionbutton.SmallOptionButton;

public final class NMediaEditFragmentBinding implements ViewBinding {
    public final SmallOptionButton deleteOptionView;
    public final SmallOptionButton duplicateOptionView;
    public final SmallOptionButton replaceOptionView;
    private final ConstraintLayout rootView;
    public final SmallOptionButton showFullSizeOptionView;

    private NMediaEditFragmentBinding(ConstraintLayout constraintLayout, SmallOptionButton smallOptionButton, SmallOptionButton smallOptionButton2, SmallOptionButton smallOptionButton3, SmallOptionButton smallOptionButton4) {
        this.rootView = constraintLayout;
        this.deleteOptionView = smallOptionButton;
        this.duplicateOptionView = smallOptionButton2;
        this.replaceOptionView = smallOptionButton3;
        this.showFullSizeOptionView = smallOptionButton4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NMediaEditFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaEditFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_edit_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaEditFragmentBinding bind(View view) {
        int i = C4175R.C4179id.delete_option_view;
        SmallOptionButton smallOptionButton = (SmallOptionButton) view.findViewById(i);
        if (smallOptionButton != null) {
            i = C4175R.C4179id.duplicate_option_view;
            SmallOptionButton smallOptionButton2 = (SmallOptionButton) view.findViewById(i);
            if (smallOptionButton2 != null) {
                i = C4175R.C4179id.replace_option_view;
                SmallOptionButton smallOptionButton3 = (SmallOptionButton) view.findViewById(i);
                if (smallOptionButton3 != null) {
                    i = C4175R.C4179id.show_full_size_option_view;
                    SmallOptionButton smallOptionButton4 = (SmallOptionButton) view.findViewById(i);
                    if (smallOptionButton4 != null) {
                        return new NMediaEditFragmentBinding((ConstraintLayout) view, smallOptionButton, smallOptionButton2, smallOptionButton3, smallOptionButton4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
