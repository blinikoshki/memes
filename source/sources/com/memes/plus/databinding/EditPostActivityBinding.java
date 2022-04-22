package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.memes.plus.C4199R;

public final class EditPostActivityBinding implements ViewBinding {
    public final TextView backImageView;
    public final RecyclerView captionSuggestionsRecyclerView;
    public final RoundedImageView editPostAuthorImageView;
    public final TextView editPostAuthorNameTextView;
    public final TextView editPostDoneTextView;
    public final Guideline editPostGlLeft;
    public final Guideline editPostGlRight;
    public final TextView editPostTextView;
    public final EditText memeCaptionEditText;
    public final ImageView memePreviewImageView;
    public final FrameLayout postPreview;
    private final ConstraintLayout rootView;
    public final ImageView tagPeopleTextView;
    public final LinearLayout taggedPeopleLayout;
    public final TextView tagsPeopleCountTextView;

    private EditPostActivityBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, RoundedImageView roundedImageView, TextView textView2, TextView textView3, Guideline guideline, Guideline guideline2, TextView textView4, EditText editText, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, LinearLayout linearLayout, TextView textView5) {
        this.rootView = constraintLayout;
        this.backImageView = textView;
        this.captionSuggestionsRecyclerView = recyclerView;
        this.editPostAuthorImageView = roundedImageView;
        this.editPostAuthorNameTextView = textView2;
        this.editPostDoneTextView = textView3;
        this.editPostGlLeft = guideline;
        this.editPostGlRight = guideline2;
        this.editPostTextView = textView4;
        this.memeCaptionEditText = editText;
        this.memePreviewImageView = imageView;
        this.postPreview = frameLayout;
        this.tagPeopleTextView = imageView2;
        this.taggedPeopleLayout = linearLayout;
        this.tagsPeopleCountTextView = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EditPostActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditPostActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.edit_post_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditPostActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.back_image_view;
        TextView textView = (TextView) view2.findViewById(C4199R.C4203id.back_image_view);
        if (textView != null) {
            i = C4199R.C4203id.caption_suggestions_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(C4199R.C4203id.caption_suggestions_recycler_view);
            if (recyclerView != null) {
                i = C4199R.C4203id.edit_post_author_image_view;
                RoundedImageView roundedImageView = (RoundedImageView) view2.findViewById(C4199R.C4203id.edit_post_author_image_view);
                if (roundedImageView != null) {
                    i = C4199R.C4203id.edit_post_author_name_text_view;
                    TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.edit_post_author_name_text_view);
                    if (textView2 != null) {
                        i = C4199R.C4203id.edit_post__done_text_view;
                        TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.edit_post__done_text_view);
                        if (textView3 != null) {
                            i = C4199R.C4203id.edit_post_gl_left;
                            Guideline guideline = (Guideline) view2.findViewById(C4199R.C4203id.edit_post_gl_left);
                            if (guideline != null) {
                                i = C4199R.C4203id.edit_post_gl_right;
                                Guideline guideline2 = (Guideline) view2.findViewById(C4199R.C4203id.edit_post_gl_right);
                                if (guideline2 != null) {
                                    i = C4199R.C4203id.edit_post_text_view;
                                    TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.edit_post_text_view);
                                    if (textView4 != null) {
                                        i = C4199R.C4203id.meme_caption_edit_text;
                                        EditText editText = (EditText) view2.findViewById(C4199R.C4203id.meme_caption_edit_text);
                                        if (editText != null) {
                                            i = C4199R.C4203id.meme_preview_image_view;
                                            ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.meme_preview_image_view);
                                            if (imageView != null) {
                                                i = C4199R.C4203id.post_preview;
                                                FrameLayout frameLayout = (FrameLayout) view2.findViewById(C4199R.C4203id.post_preview);
                                                if (frameLayout != null) {
                                                    i = C4199R.C4203id.tag_people_text_view;
                                                    ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.tag_people_text_view);
                                                    if (imageView2 != null) {
                                                        i = C4199R.C4203id.tagged_people_layout;
                                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.tagged_people_layout);
                                                        if (linearLayout != null) {
                                                            i = C4199R.C4203id.tags_people_count_text_view;
                                                            TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.tags_people_count_text_view);
                                                            if (textView5 != null) {
                                                                return new EditPostActivityBinding((ConstraintLayout) view2, textView, recyclerView, roundedImageView, textView2, textView3, guideline, guideline2, textView4, editText, imageView, frameLayout, imageView2, linearLayout, textView5);
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
