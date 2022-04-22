package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NVideoTrimmerUpgradePopupBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Button trimDurationUpgradeButton;

    private NVideoTrimmerUpgradePopupBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.trimDurationUpgradeButton = button;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NVideoTrimmerUpgradePopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NVideoTrimmerUpgradePopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_video_trimmer_upgrade_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NVideoTrimmerUpgradePopupBinding bind(View view) {
        int i = C4175R.C4179id.trim_duration_upgrade_button;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            return new NVideoTrimmerUpgradePopupBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
