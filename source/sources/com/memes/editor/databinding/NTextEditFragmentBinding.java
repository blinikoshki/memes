package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NTextEditFragmentBinding implements ViewBinding {
    public final AppCompatImageView adjustOptionView;
    public final AppCompatImageView alignCenterOptionView;
    public final AppCompatImageView alignLeftOptionView;
    public final AppCompatImageView alignRightOptionView;
    public final AppCompatImageView allCapsOptionView;
    public final AppCompatImageView boldOptionView;
    public final TextView deleteOptionView;
    public final TextView duplicateOptionView;
    public final TextView editTextOptionView;
    public final AppCompatImageView italicOptionView;
    public final AppCompatImageView noCapsOptionView;
    public final AppCompatImageView nudgeOptionView;
    private final LinearLayout rootView;
    public final AppCompatImageView spacingOptionView;
    public final AppCompatImageView underlineOptionView;
    public final AppCompatImageView wordCapsOptionView;

    private NTextEditFragmentBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView7, AppCompatImageView appCompatImageView8, AppCompatImageView appCompatImageView9, AppCompatImageView appCompatImageView10, AppCompatImageView appCompatImageView11, AppCompatImageView appCompatImageView12) {
        this.rootView = linearLayout;
        this.adjustOptionView = appCompatImageView;
        this.alignCenterOptionView = appCompatImageView2;
        this.alignLeftOptionView = appCompatImageView3;
        this.alignRightOptionView = appCompatImageView4;
        this.allCapsOptionView = appCompatImageView5;
        this.boldOptionView = appCompatImageView6;
        this.deleteOptionView = textView;
        this.duplicateOptionView = textView2;
        this.editTextOptionView = textView3;
        this.italicOptionView = appCompatImageView7;
        this.noCapsOptionView = appCompatImageView8;
        this.nudgeOptionView = appCompatImageView9;
        this.spacingOptionView = appCompatImageView10;
        this.underlineOptionView = appCompatImageView11;
        this.wordCapsOptionView = appCompatImageView12;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextEditFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextEditFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_edit_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextEditFragmentBinding bind(View view) {
        View view2 = view;
        int i = C4175R.C4179id.adjust_option_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view2.findViewById(i);
        if (appCompatImageView != null) {
            i = C4175R.C4179id.align_center_option_view;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(i);
            if (appCompatImageView2 != null) {
                i = C4175R.C4179id.align_left_option_view;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) view2.findViewById(i);
                if (appCompatImageView3 != null) {
                    i = C4175R.C4179id.align_right_option_view;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) view2.findViewById(i);
                    if (appCompatImageView4 != null) {
                        i = C4175R.C4179id.all_caps_option_view;
                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) view2.findViewById(i);
                        if (appCompatImageView5 != null) {
                            i = C4175R.C4179id.bold_option_view;
                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) view2.findViewById(i);
                            if (appCompatImageView6 != null) {
                                i = C4175R.C4179id.delete_option_view;
                                TextView textView = (TextView) view2.findViewById(i);
                                if (textView != null) {
                                    i = C4175R.C4179id.duplicate_option_view;
                                    TextView textView2 = (TextView) view2.findViewById(i);
                                    if (textView2 != null) {
                                        i = C4175R.C4179id.edit_text_option_view;
                                        TextView textView3 = (TextView) view2.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4175R.C4179id.italic_option_view;
                                            AppCompatImageView appCompatImageView7 = (AppCompatImageView) view2.findViewById(i);
                                            if (appCompatImageView7 != null) {
                                                i = C4175R.C4179id.no_caps_option_view;
                                                AppCompatImageView appCompatImageView8 = (AppCompatImageView) view2.findViewById(i);
                                                if (appCompatImageView8 != null) {
                                                    i = C4175R.C4179id.nudge_option_view;
                                                    AppCompatImageView appCompatImageView9 = (AppCompatImageView) view2.findViewById(i);
                                                    if (appCompatImageView9 != null) {
                                                        i = C4175R.C4179id.spacing_option_view;
                                                        AppCompatImageView appCompatImageView10 = (AppCompatImageView) view2.findViewById(i);
                                                        if (appCompatImageView10 != null) {
                                                            i = C4175R.C4179id.underline_option_view;
                                                            AppCompatImageView appCompatImageView11 = (AppCompatImageView) view2.findViewById(i);
                                                            if (appCompatImageView11 != null) {
                                                                i = C4175R.C4179id.word_caps_option_view;
                                                                AppCompatImageView appCompatImageView12 = (AppCompatImageView) view2.findViewById(i);
                                                                if (appCompatImageView12 != null) {
                                                                    return new NTextEditFragmentBinding((LinearLayout) view2, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6, textView, textView2, textView3, appCompatImageView7, appCompatImageView8, appCompatImageView9, appCompatImageView10, appCompatImageView11, appCompatImageView12);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
