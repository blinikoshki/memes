package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.custom.mediacategoryview.MediaCategoryView;

public final class NMediaSelectionActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final MediaCategoryView colorsGradientsCategoryView;
    public final MediaCategoryView giphyCategoryView;
    public final MediaCategoryView memesCategoryView;
    public final MediaCategoryView patternsCategoryView;
    public final MediaCategoryView photosCategoryView;
    public final MediaCategoryView redditCategoryView;
    private final LinearLayout rootView;
    public final MediaCategoryView selectedMediaCategoryView;
    public final TextView titleTextView;
    public final MediaCategoryView videosCategoryView;

    private NMediaSelectionActivityBinding(LinearLayout linearLayout, ImageView imageView, MediaCategoryView mediaCategoryView, MediaCategoryView mediaCategoryView2, MediaCategoryView mediaCategoryView3, MediaCategoryView mediaCategoryView4, MediaCategoryView mediaCategoryView5, MediaCategoryView mediaCategoryView6, MediaCategoryView mediaCategoryView7, TextView textView, MediaCategoryView mediaCategoryView8) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.colorsGradientsCategoryView = mediaCategoryView;
        this.giphyCategoryView = mediaCategoryView2;
        this.memesCategoryView = mediaCategoryView3;
        this.patternsCategoryView = mediaCategoryView4;
        this.photosCategoryView = mediaCategoryView5;
        this.redditCategoryView = mediaCategoryView6;
        this.selectedMediaCategoryView = mediaCategoryView7;
        this.titleTextView = textView;
        this.videosCategoryView = mediaCategoryView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NMediaSelectionActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NMediaSelectionActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_media_selection_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NMediaSelectionActivityBinding bind(View view) {
        int i = C4175R.C4179id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.colors_gradients_category_view;
            MediaCategoryView mediaCategoryView = (MediaCategoryView) view.findViewById(i);
            if (mediaCategoryView != null) {
                i = C4175R.C4179id.giphy_category_view;
                MediaCategoryView mediaCategoryView2 = (MediaCategoryView) view.findViewById(i);
                if (mediaCategoryView2 != null) {
                    i = C4175R.C4179id.memes_category_view;
                    MediaCategoryView mediaCategoryView3 = (MediaCategoryView) view.findViewById(i);
                    if (mediaCategoryView3 != null) {
                        i = C4175R.C4179id.patterns_category_view;
                        MediaCategoryView mediaCategoryView4 = (MediaCategoryView) view.findViewById(i);
                        if (mediaCategoryView4 != null) {
                            i = C4175R.C4179id.photos_category_view;
                            MediaCategoryView mediaCategoryView5 = (MediaCategoryView) view.findViewById(i);
                            if (mediaCategoryView5 != null) {
                                i = C4175R.C4179id.reddit_category_view;
                                MediaCategoryView mediaCategoryView6 = (MediaCategoryView) view.findViewById(i);
                                if (mediaCategoryView6 != null) {
                                    i = C4175R.C4179id.selected_media_category_view;
                                    MediaCategoryView mediaCategoryView7 = (MediaCategoryView) view.findViewById(i);
                                    if (mediaCategoryView7 != null) {
                                        i = C4175R.C4179id.title_text_view;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            i = C4175R.C4179id.videos_category_view;
                                            MediaCategoryView mediaCategoryView8 = (MediaCategoryView) view.findViewById(i);
                                            if (mediaCategoryView8 != null) {
                                                return new NMediaSelectionActivityBinding((LinearLayout) view, imageView, mediaCategoryView, mediaCategoryView2, mediaCategoryView3, mediaCategoryView4, mediaCategoryView5, mediaCategoryView6, mediaCategoryView7, textView, mediaCategoryView8);
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
