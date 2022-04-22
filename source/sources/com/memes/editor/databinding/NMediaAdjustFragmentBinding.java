package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.optionbutton.SmallOptionButton;

public final class NMediaAdjustFragmentBinding implements ViewBinding {
    public final SmallOptionButton cornerOptionView;
    public final SmallOptionButton cropOptionView;
    public final SmallOptionButton enhanceOptionView;
    public final SmallOptionButton flipHorizontalOptionView;
    public final SmallOptionButton flipVerticalOptionView;
    public final SmallOptionButton nudgeOptionView;
    public final SmallOptionButton opacityOptionView;
    private final HorizontalScrollView rootView;
    public final SmallOptionButton rotateOptionView;
    public final SmallOptionButton scaleOptionView;

    private NMediaAdjustFragmentBinding(HorizontalScrollView horizontalScrollView, SmallOptionButton smallOptionButton, SmallOptionButton smallOptionButton2, SmallOptionButton smallOptionButton3, SmallOptionButton smallOptionButton4, SmallOptionButton smallOptionButton5, SmallOptionButton smallOptionButton6, SmallOptionButton smallOptionButton7, SmallOptionButton smallOptionButton8, SmallOptionButton smallOptionButton9) {
        this.rootView = horizontalScrollView;
        this.cornerOptionView = smallOptionButton;
        this.cropOptionView = smallOptionButton2;
        this.enhanceOptionView = smallOptionButton3;
        this.flipHorizontalOptionView = smallOptionButton4;
        this.flipVerticalOptionView = smallOptionButton5;
        this.nudgeOptionView = smallOptionButton6;
        this.opacityOptionView = smallOptionButton7;
        this.rotateOptionView = smallOptionButton8;
        this.scaleOptionView = smallOptionButton9;
    }

    public HorizontalScrollView getRoot() {
        return this.rootView;
    }

    public static NMediaAdjustFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaAdjustFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_adjust_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaAdjustFragmentBinding bind(View view) {
        int i = C4175R.C4179id.corner_option_view;
        SmallOptionButton smallOptionButton = (SmallOptionButton) view.findViewById(i);
        if (smallOptionButton != null) {
            i = C4175R.C4179id.crop_option_view;
            SmallOptionButton smallOptionButton2 = (SmallOptionButton) view.findViewById(i);
            if (smallOptionButton2 != null) {
                i = C4175R.C4179id.enhance_option_view;
                SmallOptionButton smallOptionButton3 = (SmallOptionButton) view.findViewById(i);
                if (smallOptionButton3 != null) {
                    i = C4175R.C4179id.flip_horizontal_option_view;
                    SmallOptionButton smallOptionButton4 = (SmallOptionButton) view.findViewById(i);
                    if (smallOptionButton4 != null) {
                        i = C4175R.C4179id.flip_vertical_option_view;
                        SmallOptionButton smallOptionButton5 = (SmallOptionButton) view.findViewById(i);
                        if (smallOptionButton5 != null) {
                            i = C4175R.C4179id.nudge_option_view;
                            SmallOptionButton smallOptionButton6 = (SmallOptionButton) view.findViewById(i);
                            if (smallOptionButton6 != null) {
                                i = C4175R.C4179id.opacity_option_view;
                                SmallOptionButton smallOptionButton7 = (SmallOptionButton) view.findViewById(i);
                                if (smallOptionButton7 != null) {
                                    i = C4175R.C4179id.rotate_option_view;
                                    SmallOptionButton smallOptionButton8 = (SmallOptionButton) view.findViewById(i);
                                    if (smallOptionButton8 != null) {
                                        i = C4175R.C4179id.scale_option_view;
                                        SmallOptionButton smallOptionButton9 = (SmallOptionButton) view.findViewById(i);
                                        if (smallOptionButton9 != null) {
                                            return new NMediaAdjustFragmentBinding((HorizontalScrollView) view, smallOptionButton, smallOptionButton2, smallOptionButton3, smallOptionButton4, smallOptionButton5, smallOptionButton6, smallOptionButton7, smallOptionButton8, smallOptionButton9);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
