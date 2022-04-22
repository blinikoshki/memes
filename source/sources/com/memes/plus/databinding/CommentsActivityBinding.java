package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;
import p048de.hdodenhof.circleimageview.CircleImageView;

public final class CommentsActivityBinding implements ViewBinding {
    public final EditText addCommentEditText;
    public final ImageView cameraSelectionImageView;
    public final LinearLayout commentBoxLinearLayout;
    public final RecyclerView commentsRecyclerView;
    public final ContentLayout contentLayout;
    public final ImageView gifSelectionImageView;
    public final RelativeLayout gifWrapperRelativeLayout;
    public final SnippetTopBarLayoutBinding includedTopBar;
    public final LinearLayout mediaSelectionLinearLayout;
    public final TextView postCommentTextView;
    public final ImageView replyingCloseImageView;
    public final RelativeLayout replyingRelativeLayout;
    public final TextView replyingTextView;
    private final RelativeLayout rootView;
    public final CircleImageView selectedGifCloseImageView;
    public final ImageView selectedGifImageView;
    public final RecyclerView userSearchRecyclerView;

    private CommentsActivityBinding(RelativeLayout relativeLayout, EditText editText, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, ContentLayout contentLayout2, ImageView imageView2, RelativeLayout relativeLayout2, SnippetTopBarLayoutBinding snippetTopBarLayoutBinding, LinearLayout linearLayout2, TextView textView, ImageView imageView3, RelativeLayout relativeLayout3, TextView textView2, CircleImageView circleImageView, ImageView imageView4, RecyclerView recyclerView2) {
        this.rootView = relativeLayout;
        this.addCommentEditText = editText;
        this.cameraSelectionImageView = imageView;
        this.commentBoxLinearLayout = linearLayout;
        this.commentsRecyclerView = recyclerView;
        this.contentLayout = contentLayout2;
        this.gifSelectionImageView = imageView2;
        this.gifWrapperRelativeLayout = relativeLayout2;
        this.includedTopBar = snippetTopBarLayoutBinding;
        this.mediaSelectionLinearLayout = linearLayout2;
        this.postCommentTextView = textView;
        this.replyingCloseImageView = imageView3;
        this.replyingRelativeLayout = relativeLayout3;
        this.replyingTextView = textView2;
        this.selectedGifCloseImageView = circleImageView;
        this.selectedGifImageView = imageView4;
        this.userSearchRecyclerView = recyclerView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CommentsActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommentsActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.comments_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommentsActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.add_comment_edit_text;
        EditText editText = (EditText) view2.findViewById(C4199R.C4203id.add_comment_edit_text);
        if (editText != null) {
            i = C4199R.C4203id.camera_selection_image_view;
            ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.camera_selection_image_view);
            if (imageView != null) {
                i = C4199R.C4203id.comment_box_linear_layout;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.comment_box_linear_layout);
                if (linearLayout != null) {
                    i = C4199R.C4203id.comments_recycler_view;
                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(C4199R.C4203id.comments_recycler_view);
                    if (recyclerView != null) {
                        i = C4199R.C4203id.content_layout;
                        ContentLayout contentLayout2 = (ContentLayout) view2.findViewById(C4199R.C4203id.content_layout);
                        if (contentLayout2 != null) {
                            i = C4199R.C4203id.gif_selection_image_view;
                            ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.gif_selection_image_view);
                            if (imageView2 != null) {
                                i = C4199R.C4203id.gif_wrapper_relative_layout;
                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(C4199R.C4203id.gif_wrapper_relative_layout);
                                if (relativeLayout != null) {
                                    i = C4199R.C4203id.included_top_bar;
                                    View findViewById = view2.findViewById(C4199R.C4203id.included_top_bar);
                                    if (findViewById != null) {
                                        SnippetTopBarLayoutBinding bind = SnippetTopBarLayoutBinding.bind(findViewById);
                                        i = C4199R.C4203id.media_selection_linear_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.media_selection_linear_layout);
                                        if (linearLayout2 != null) {
                                            i = C4199R.C4203id.post_comment_text_view;
                                            TextView textView = (TextView) view2.findViewById(C4199R.C4203id.post_comment_text_view);
                                            if (textView != null) {
                                                i = C4199R.C4203id.replying_close_image_view;
                                                ImageView imageView3 = (ImageView) view2.findViewById(C4199R.C4203id.replying_close_image_view);
                                                if (imageView3 != null) {
                                                    i = C4199R.C4203id.replying_relative_layout;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(C4199R.C4203id.replying_relative_layout);
                                                    if (relativeLayout2 != null) {
                                                        i = C4199R.C4203id.replying_text_view;
                                                        TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.replying_text_view);
                                                        if (textView2 != null) {
                                                            i = C4199R.C4203id.selected_gif_close_image_view;
                                                            CircleImageView circleImageView = (CircleImageView) view2.findViewById(C4199R.C4203id.selected_gif_close_image_view);
                                                            if (circleImageView != null) {
                                                                i = C4199R.C4203id.selected_gif_image_view;
                                                                ImageView imageView4 = (ImageView) view2.findViewById(C4199R.C4203id.selected_gif_image_view);
                                                                if (imageView4 != null) {
                                                                    i = C4199R.C4203id.user_search_recycler_view;
                                                                    RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(C4199R.C4203id.user_search_recycler_view);
                                                                    if (recyclerView2 != null) {
                                                                        return new CommentsActivityBinding((RelativeLayout) view2, editText, imageView, linearLayout, recyclerView, contentLayout2, imageView2, relativeLayout, bind, linearLayout2, textView, imageView3, relativeLayout2, textView2, circleImageView, imageView4, recyclerView2);
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
