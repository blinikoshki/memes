package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class ExportPostActivityBinding implements ViewBinding {
    public final TextView addHashTagsTextView;
    public final TextView addYourFavoriteTextView;
    public final FrameLayout autoSaveLayout;
    public final TextView autoSaveMessageTextView;
    public final TextView backImageView;
    public final RecyclerView captionSuggestionsRecyclerView;
    public final LinearLayout captionTagLayout;
    public final TextView deleteReorderTextView;
    public final Space exportPostBottomSpace;
    public final Guideline exportPostGlLeft;
    public final Guideline exportPostGlRight;
    public final TextView exportPostTextView;
    public final RecyclerView hashTagsRecyclerView;
    public final TextView hashTagsTitleTextView;
    public final SwitchCompat memeAutoSaveSwitch;
    public final EditText memeCaptionEditText;
    public final ImageView memePreviewImageView;
    public final ImageView memePreviewVideoIndicatorView;
    public final LinearLayout moreSharingLayout;
    public final TextView newPostTextView;
    public final FrameLayout postPreview;
    public final LinearLayout premiumButtonLayout;
    public final Space premiumButtonSpacer;
    private final ScrollView rootView;
    public final TextView savePostTextView;
    public final FrameLayout tagPeopleLayout;
    public final TextView tagPeopleTextView;
    public final TextView tagsPeopleCountTextView;

    private ExportPostActivityBinding(ScrollView scrollView, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, TextView textView4, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView5, Space space, Guideline guideline, Guideline guideline2, TextView textView6, RecyclerView recyclerView2, TextView textView7, SwitchCompat switchCompat, EditText editText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, TextView textView8, FrameLayout frameLayout2, LinearLayout linearLayout3, Space space2, TextView textView9, FrameLayout frameLayout3, TextView textView10, TextView textView11) {
        this.rootView = scrollView;
        this.addHashTagsTextView = textView;
        this.addYourFavoriteTextView = textView2;
        this.autoSaveLayout = frameLayout;
        this.autoSaveMessageTextView = textView3;
        this.backImageView = textView4;
        this.captionSuggestionsRecyclerView = recyclerView;
        this.captionTagLayout = linearLayout;
        this.deleteReorderTextView = textView5;
        this.exportPostBottomSpace = space;
        this.exportPostGlLeft = guideline;
        this.exportPostGlRight = guideline2;
        this.exportPostTextView = textView6;
        this.hashTagsRecyclerView = recyclerView2;
        this.hashTagsTitleTextView = textView7;
        this.memeAutoSaveSwitch = switchCompat;
        this.memeCaptionEditText = editText;
        this.memePreviewImageView = imageView;
        this.memePreviewVideoIndicatorView = imageView2;
        this.moreSharingLayout = linearLayout2;
        this.newPostTextView = textView8;
        this.postPreview = frameLayout2;
        this.premiumButtonLayout = linearLayout3;
        this.premiumButtonSpacer = space2;
        this.savePostTextView = textView9;
        this.tagPeopleLayout = frameLayout3;
        this.tagPeopleTextView = textView10;
        this.tagsPeopleCountTextView = textView11;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ExportPostActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ExportPostActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.export_post_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ExportPostActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.add_hash_tags_text_view;
        TextView textView = (TextView) view2.findViewById(C4199R.C4203id.add_hash_tags_text_view);
        if (textView != null) {
            i = C4199R.C4203id.add_your_favorite_text_view;
            TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.add_your_favorite_text_view);
            if (textView2 != null) {
                i = C4199R.C4203id.auto_save_layout;
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(C4199R.C4203id.auto_save_layout);
                if (frameLayout != null) {
                    i = C4199R.C4203id.auto_save_message_text_view;
                    TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.auto_save_message_text_view);
                    if (textView3 != null) {
                        i = C4199R.C4203id.back_image_view;
                        TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.back_image_view);
                        if (textView4 != null) {
                            i = C4199R.C4203id.caption_suggestions_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view2.findViewById(C4199R.C4203id.caption_suggestions_recycler_view);
                            if (recyclerView != null) {
                                i = C4199R.C4203id.caption_tag_layout;
                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.caption_tag_layout);
                                if (linearLayout != null) {
                                    i = C4199R.C4203id.delete_reorder_text_view;
                                    TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.delete_reorder_text_view);
                                    if (textView5 != null) {
                                        i = C4199R.C4203id.export_post_bottom_space;
                                        Space space = (Space) view2.findViewById(C4199R.C4203id.export_post_bottom_space);
                                        if (space != null) {
                                            i = C4199R.C4203id.export_post_gl_left;
                                            Guideline guideline = (Guideline) view2.findViewById(C4199R.C4203id.export_post_gl_left);
                                            if (guideline != null) {
                                                i = C4199R.C4203id.export_post_gl_right;
                                                Guideline guideline2 = (Guideline) view2.findViewById(C4199R.C4203id.export_post_gl_right);
                                                if (guideline2 != null) {
                                                    i = C4199R.C4203id.export_post_text_view;
                                                    TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.export_post_text_view);
                                                    if (textView6 != null) {
                                                        i = C4199R.C4203id.hash_tags_recycler_view;
                                                        RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(C4199R.C4203id.hash_tags_recycler_view);
                                                        if (recyclerView2 != null) {
                                                            i = C4199R.C4203id.hash_tags_title_text_view;
                                                            TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.hash_tags_title_text_view);
                                                            if (textView7 != null) {
                                                                i = C4199R.C4203id.meme_auto_save_switch;
                                                                SwitchCompat switchCompat = (SwitchCompat) view2.findViewById(C4199R.C4203id.meme_auto_save_switch);
                                                                if (switchCompat != null) {
                                                                    i = C4199R.C4203id.meme_caption_edit_text;
                                                                    EditText editText = (EditText) view2.findViewById(C4199R.C4203id.meme_caption_edit_text);
                                                                    if (editText != null) {
                                                                        i = C4199R.C4203id.meme_preview_image_view;
                                                                        ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.meme_preview_image_view);
                                                                        if (imageView != null) {
                                                                            i = C4199R.C4203id.meme_preview_video_indicator_view;
                                                                            ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.meme_preview_video_indicator_view);
                                                                            if (imageView2 != null) {
                                                                                i = C4199R.C4203id.more_sharing_layout;
                                                                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.more_sharing_layout);
                                                                                if (linearLayout2 != null) {
                                                                                    i = C4199R.C4203id.new_post_text_view;
                                                                                    TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.new_post_text_view);
                                                                                    if (textView8 != null) {
                                                                                        i = C4199R.C4203id.post_preview;
                                                                                        FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(C4199R.C4203id.post_preview);
                                                                                        if (frameLayout2 != null) {
                                                                                            i = C4199R.C4203id.premium_button_layout;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(C4199R.C4203id.premium_button_layout);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = C4199R.C4203id.premium_button_spacer;
                                                                                                Space space2 = (Space) view2.findViewById(C4199R.C4203id.premium_button_spacer);
                                                                                                if (space2 != null) {
                                                                                                    i = C4199R.C4203id.save_post_text_view;
                                                                                                    TextView textView9 = (TextView) view2.findViewById(C4199R.C4203id.save_post_text_view);
                                                                                                    if (textView9 != null) {
                                                                                                        i = C4199R.C4203id.tag_people_layout;
                                                                                                        FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(C4199R.C4203id.tag_people_layout);
                                                                                                        if (frameLayout3 != null) {
                                                                                                            i = C4199R.C4203id.tag_people_text_view;
                                                                                                            TextView textView10 = (TextView) view2.findViewById(C4199R.C4203id.tag_people_text_view);
                                                                                                            if (textView10 != null) {
                                                                                                                i = C4199R.C4203id.tags_people_count_text_view;
                                                                                                                TextView textView11 = (TextView) view2.findViewById(C4199R.C4203id.tags_people_count_text_view);
                                                                                                                if (textView11 != null) {
                                                                                                                    return new ExportPostActivityBinding((ScrollView) view2, textView, textView2, frameLayout, textView3, textView4, recyclerView, linearLayout, textView5, space, guideline, guideline2, textView6, recyclerView2, textView7, switchCompat, editText, imageView, imageView2, linearLayout2, textView8, frameLayout2, linearLayout3, space2, textView9, frameLayout3, textView10, textView11);
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
