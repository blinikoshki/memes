package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;

public final class NAddTextActivityBinding implements ViewBinding {
    public final EditText editText;
    public final CancelDoneFooter footer;
    private final LinearLayout rootView;

    private NAddTextActivityBinding(LinearLayout linearLayout, EditText editText2, CancelDoneFooter cancelDoneFooter) {
        this.rootView = linearLayout;
        this.editText = editText2;
        this.footer = cancelDoneFooter;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NAddTextActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NAddTextActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_add_text_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NAddTextActivityBinding bind(View view) {
        int i = C4175R.C4179id.edit_text;
        EditText editText2 = (EditText) view.findViewById(i);
        if (editText2 != null) {
            i = C4175R.C4179id.footer;
            CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
            if (cancelDoneFooter != null) {
                return new NAddTextActivityBinding((LinearLayout) view, editText2, cancelDoneFooter);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
