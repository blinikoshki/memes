package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class SingleCommentRowBinding implements ViewBinding {
    public final ImageView commentContentImageView;
    public final TextView commentReplyTextView;
    public final TextView commentTimeTextView;
    public final RelativeLayout commentsRelativeLayout;
    public final TextView deleteTextView;
    public final TextView editTextView;
    public final ImageView likeImageView;
    public final TextView likesCountTextView;
    public final View lineViewRepliesView;
    public final LinearLayout linearParentLike;
    public final TextView loadingRepliesTextView;
    public final UserAvatarView profilePicImageView;
    public final LinearLayout replyLinearLayout;
    public final TextView reportTextView;
    private final RelativeLayout rootView;
    public final LinearLayout userCommentLinearLayout;
    public final SocialTextView userCommentTextView;
    public final TextView userNameTextView;
    public final RelativeLayout viewRepliesRelativeLayout;
    public final TextView viewRepliesTextView;

    private SingleCommentRowBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, RelativeLayout relativeLayout2, TextView textView3, TextView textView4, ImageView imageView2, TextView textView5, View view, LinearLayout linearLayout, TextView textView6, UserAvatarView userAvatarView, LinearLayout linearLayout2, TextView textView7, LinearLayout linearLayout3, SocialTextView socialTextView, TextView textView8, RelativeLayout relativeLayout3, TextView textView9) {
        this.rootView = relativeLayout;
        this.commentContentImageView = imageView;
        this.commentReplyTextView = textView;
        this.commentTimeTextView = textView2;
        this.commentsRelativeLayout = relativeLayout2;
        this.deleteTextView = textView3;
        this.editTextView = textView4;
        this.likeImageView = imageView2;
        this.likesCountTextView = textView5;
        this.lineViewRepliesView = view;
        this.linearParentLike = linearLayout;
        this.loadingRepliesTextView = textView6;
        this.profilePicImageView = userAvatarView;
        this.replyLinearLayout = linearLayout2;
        this.reportTextView = textView7;
        this.userCommentLinearLayout = linearLayout3;
        this.userCommentTextView = socialTextView;
        this.userNameTextView = textView8;
        this.viewRepliesRelativeLayout = relativeLayout3;
        this.viewRepliesTextView = textView9;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleCommentRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SingleCommentRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.single_comment_row, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SingleCommentRowBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.comment_content_image_view;
        ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.comment_content_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.comment_reply_text_view;
            TextView textView = (TextView) view2.findViewById(C4199R.C4203id.comment_reply_text_view);
            if (textView != null) {
                i = C4199R.C4203id.comment_time_text_view;
                TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.comment_time_text_view);
                if (textView2 != null) {
                    i = C4199R.C4203id.comments_relative_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(C4199R.C4203id.comments_relative_layout);
                    if (relativeLayout != null) {
                        i = C4199R.C4203id.delete_text_view;
                        TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.delete_text_view);
                        if (textView3 != null) {
                            i = C4199R.C4203id.edit_text_view;
                            TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.edit_text_view);
                            if (textView4 != null) {
                                i = C4199R.C4203id.like_image_view;
                                ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.like_image_view);
                                if (imageView2 != null) {
                                    i = C4199R.C4203id.likes_count_text_view;
                                    TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.likes_count_text_view);
                                    if (textView5 != null) {
                                        i = C4199R.C4203id.line_view_replies_view;
                                        View findViewById = view2.findViewById(C4199R.C4203id.line_view_replies_view);
                                        if (findViewById != null) {
                                            i = C4199R.C4203id.linear_parent_like;
                                            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.linear_parent_like);
                                            if (linearLayout != null) {
                                                i = C4199R.C4203id.loading_replies_text_view;
                                                TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.loading_replies_text_view);
                                                if (textView6 != null) {
                                                    i = C4199R.C4203id.profile_pic_image_view;
                                                    UserAvatarView userAvatarView = (UserAvatarView) view2.findViewById(C4199R.C4203id.profile_pic_image_view);
                                                    if (userAvatarView != null) {
                                                        i = C4199R.C4203id.reply_linear_layout;
                                                        LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.reply_linear_layout);
                                                        if (linearLayout2 != null) {
                                                            i = C4199R.C4203id.report_text_view;
                                                            TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.report_text_view);
                                                            if (textView7 != null) {
                                                                i = C4199R.C4203id.user_comment_linear_layout;
                                                                LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(C4199R.C4203id.user_comment_linear_layout);
                                                                if (linearLayout3 != null) {
                                                                    i = C4199R.C4203id.user_comment_text_view;
                                                                    SocialTextView socialTextView = (SocialTextView) view2.findViewById(C4199R.C4203id.user_comment_text_view);
                                                                    if (socialTextView != null) {
                                                                        i = C4199R.C4203id.user_name_text_view;
                                                                        TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.user_name_text_view);
                                                                        if (textView8 != null) {
                                                                            i = C4199R.C4203id.view_replies_relative_layout;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(C4199R.C4203id.view_replies_relative_layout);
                                                                            if (relativeLayout2 != null) {
                                                                                i = C4199R.C4203id.view_replies_text_view;
                                                                                TextView textView9 = (TextView) view2.findViewById(C4199R.C4203id.view_replies_text_view);
                                                                                if (textView9 != null) {
                                                                                    return new SingleCommentRowBinding((RelativeLayout) view2, imageView, textView, textView2, relativeLayout, textView3, textView4, imageView2, textView5, findViewById, linearLayout, textView6, userAvatarView, linearLayout2, textView7, linearLayout3, socialTextView, textView8, relativeLayout2, textView9);
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
