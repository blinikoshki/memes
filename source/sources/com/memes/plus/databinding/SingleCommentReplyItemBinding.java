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

public final class SingleCommentReplyItemBinding implements ViewBinding {
    public final ImageView commentContentImageView;
    public final TextView commentTimeTextView;
    public final RelativeLayout commentsRelativeLayout;
    public final LinearLayout linearParentLike;
    public final UserAvatarView profilePicImageView;
    public final TextView replyDeleteTextView;
    public final TextView replyEditTextView;
    public final ImageView replyLikeImageView;
    public final TextView replyLikesCountTextView;
    public final LinearLayout replyLinearLayout;
    public final TextView replyReplyTextView;
    public final TextView replyReportTextView;
    private final RelativeLayout rootView;
    public final SocialTextView userCommentTextView;
    public final TextView userNameTextView;

    private SingleCommentReplyItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, RelativeLayout relativeLayout2, LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, LinearLayout linearLayout2, TextView textView5, TextView textView6, SocialTextView socialTextView, TextView textView7) {
        this.rootView = relativeLayout;
        this.commentContentImageView = imageView;
        this.commentTimeTextView = textView;
        this.commentsRelativeLayout = relativeLayout2;
        this.linearParentLike = linearLayout;
        this.profilePicImageView = userAvatarView;
        this.replyDeleteTextView = textView2;
        this.replyEditTextView = textView3;
        this.replyLikeImageView = imageView2;
        this.replyLikesCountTextView = textView4;
        this.replyLinearLayout = linearLayout2;
        this.replyReplyTextView = textView5;
        this.replyReportTextView = textView6;
        this.userCommentTextView = socialTextView;
        this.userNameTextView = textView7;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleCommentReplyItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SingleCommentReplyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.single_comment_reply_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SingleCommentReplyItemBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.comment_content_image_view;
        ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.comment_content_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.comment_time_text_view;
            TextView textView = (TextView) view2.findViewById(C4199R.C4203id.comment_time_text_view);
            if (textView != null) {
                i = C4199R.C4203id.comments_relative_layout;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(C4199R.C4203id.comments_relative_layout);
                if (relativeLayout != null) {
                    i = C4199R.C4203id.linear_parent_like;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.linear_parent_like);
                    if (linearLayout != null) {
                        i = C4199R.C4203id.profile_pic_image_view;
                        UserAvatarView userAvatarView = (UserAvatarView) view2.findViewById(C4199R.C4203id.profile_pic_image_view);
                        if (userAvatarView != null) {
                            i = C4199R.C4203id.reply_delete_text_view;
                            TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.reply_delete_text_view);
                            if (textView2 != null) {
                                i = C4199R.C4203id.reply_edit_text_view;
                                TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.reply_edit_text_view);
                                if (textView3 != null) {
                                    i = C4199R.C4203id.reply_like_image_view;
                                    ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.reply_like_image_view);
                                    if (imageView2 != null) {
                                        i = C4199R.C4203id.reply_likes_count_text_view;
                                        TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.reply_likes_count_text_view);
                                        if (textView4 != null) {
                                            i = C4199R.C4203id.reply_linear_layout;
                                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.reply_linear_layout);
                                            if (linearLayout2 != null) {
                                                i = C4199R.C4203id.reply_reply_text_view;
                                                TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.reply_reply_text_view);
                                                if (textView5 != null) {
                                                    i = C4199R.C4203id.reply_report_text_view;
                                                    TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.reply_report_text_view);
                                                    if (textView6 != null) {
                                                        i = C4199R.C4203id.user_comment_text_view;
                                                        SocialTextView socialTextView = (SocialTextView) view2.findViewById(C4199R.C4203id.user_comment_text_view);
                                                        if (socialTextView != null) {
                                                            i = C4199R.C4203id.user_name_text_view;
                                                            TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.user_name_text_view);
                                                            if (textView7 != null) {
                                                                return new SingleCommentReplyItemBinding((RelativeLayout) view2, imageView, textView, relativeLayout, linearLayout, userAvatarView, textView2, textView3, imageView2, textView4, linearLayout2, textView5, textView6, socialTextView, textView7);
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
