package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.editorframehost.selection.NicoLayerSelectionView;

public final class NEditorActivityBinding implements ViewBinding {
    public final Guideline centerGuideline;
    public final ImageView exportImageView;
    public final FragmentContainerView fragmentContainer;
    public final EditorFrame frame;
    public final FrameLayout frameContainer;
    public final ConstraintLayout generatorToolbar;
    public final TextView hiddenEntitiesIndicatorView;
    public final ImageView homeImageView;
    public final ImageView officialWatermarkView;
    public final ImageView redoImageView;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final NicoLayerSelectionView selectionView;
    public final RecyclerView tabsRecyclerView;
    public final ImageView undoImageView;

    private NEditorActivityBinding(LinearLayout linearLayout, Guideline guideline, ImageView imageView, FragmentContainerView fragmentContainerView, EditorFrame editorFrame, FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, NicoLayerSelectionView nicoLayerSelectionView, RecyclerView recyclerView, ImageView imageView5) {
        this.rootView = linearLayout;
        this.centerGuideline = guideline;
        this.exportImageView = imageView;
        this.fragmentContainer = fragmentContainerView;
        this.frame = editorFrame;
        this.frameContainer = frameLayout;
        this.generatorToolbar = constraintLayout;
        this.hiddenEntitiesIndicatorView = textView;
        this.homeImageView = imageView2;
        this.officialWatermarkView = imageView3;
        this.redoImageView = imageView4;
        this.root = linearLayout2;
        this.selectionView = nicoLayerSelectionView;
        this.tabsRecyclerView = recyclerView;
        this.undoImageView = imageView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NEditorActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NEditorActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_editor_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NEditorActivityBinding bind(View view) {
        View view2 = view;
        int i = C4175R.C4179id.center_guideline;
        Guideline guideline = (Guideline) view2.findViewById(i);
        if (guideline != null) {
            i = C4175R.C4179id.export_image_view;
            ImageView imageView = (ImageView) view2.findViewById(i);
            if (imageView != null) {
                i = C4175R.C4179id.fragment_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) view2.findViewById(i);
                if (fragmentContainerView != null) {
                    i = C4175R.C4179id.frame;
                    EditorFrame editorFrame = (EditorFrame) view2.findViewById(i);
                    if (editorFrame != null) {
                        i = C4175R.C4179id.frame_container;
                        FrameLayout frameLayout = (FrameLayout) view2.findViewById(i);
                        if (frameLayout != null) {
                            i = C4175R.C4179id.generator_toolbar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(i);
                            if (constraintLayout != null) {
                                i = C4175R.C4179id.hidden_entities_indicator_view;
                                TextView textView = (TextView) view2.findViewById(i);
                                if (textView != null) {
                                    i = C4175R.C4179id.home_image_view;
                                    ImageView imageView2 = (ImageView) view2.findViewById(i);
                                    if (imageView2 != null) {
                                        i = C4175R.C4179id.official_watermark_view;
                                        ImageView imageView3 = (ImageView) view2.findViewById(i);
                                        if (imageView3 != null) {
                                            i = C4175R.C4179id.redo_image_view;
                                            ImageView imageView4 = (ImageView) view2.findViewById(i);
                                            if (imageView4 != null) {
                                                LinearLayout linearLayout = (LinearLayout) view2;
                                                i = C4175R.C4179id.selection_view;
                                                NicoLayerSelectionView nicoLayerSelectionView = (NicoLayerSelectionView) view2.findViewById(i);
                                                if (nicoLayerSelectionView != null) {
                                                    i = C4175R.C4179id.tabs_recycler_view;
                                                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                                                    if (recyclerView != null) {
                                                        i = C4175R.C4179id.undo_image_view;
                                                        ImageView imageView5 = (ImageView) view2.findViewById(i);
                                                        if (imageView5 != null) {
                                                            return new NEditorActivityBinding(linearLayout, guideline, imageView, fragmentContainerView, editorFrame, frameLayout, constraintLayout, textView, imageView2, imageView3, imageView4, linearLayout, nicoLayerSelectionView, recyclerView, imageView5);
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
