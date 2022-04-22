package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.nudge.NudgeButton;
import editor.common.sheetfooter.CancelDoneFooter;

public final class NNudgeFragmentBinding implements ViewBinding {
    public final NudgeButton downNudgeButton;
    public final CancelDoneFooter footer;
    public final NudgeButton leftNudgeButton;
    public final NudgeButton rightNudgeButton;
    private final LinearLayout rootView;
    public final NudgeButton upNudgeButton;

    private NNudgeFragmentBinding(LinearLayout linearLayout, NudgeButton nudgeButton, CancelDoneFooter cancelDoneFooter, NudgeButton nudgeButton2, NudgeButton nudgeButton3, NudgeButton nudgeButton4) {
        this.rootView = linearLayout;
        this.downNudgeButton = nudgeButton;
        this.footer = cancelDoneFooter;
        this.leftNudgeButton = nudgeButton2;
        this.rightNudgeButton = nudgeButton3;
        this.upNudgeButton = nudgeButton4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NNudgeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NNudgeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_nudge_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NNudgeFragmentBinding bind(View view) {
        int i = C4175R.C4179id.down_nudge_button;
        NudgeButton nudgeButton = (NudgeButton) view.findViewById(i);
        if (nudgeButton != null) {
            i = C4175R.C4179id.footer;
            CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
            if (cancelDoneFooter != null) {
                i = C4175R.C4179id.left_nudge_button;
                NudgeButton nudgeButton2 = (NudgeButton) view.findViewById(i);
                if (nudgeButton2 != null) {
                    i = C4175R.C4179id.right_nudge_button;
                    NudgeButton nudgeButton3 = (NudgeButton) view.findViewById(i);
                    if (nudgeButton3 != null) {
                        i = C4175R.C4179id.up_nudge_button;
                        NudgeButton nudgeButton4 = (NudgeButton) view.findViewById(i);
                        if (nudgeButton4 != null) {
                            return new NNudgeFragmentBinding((LinearLayout) view, nudgeButton, cancelDoneFooter, nudgeButton2, nudgeButton3, nudgeButton4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
