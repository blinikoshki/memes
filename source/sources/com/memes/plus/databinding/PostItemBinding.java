package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.commons.p039ui.IconTextHorizontalButton;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.p040ui.posts.post_basics.viewcount.PostViewCountView;

public final class PostItemBinding implements ViewBinding {
    public final LinearLayout addCommentBox;
    public final LinearLayout addCommentLayout;
    public final TextView commentsTextView;
    public final ImageView heartView;
    public final PostCommentPreviewBoxItemBinding includedCommentPreviewBox;
    public final SnippetPostMediaProgressBarBinding includedMediaProgressLayout;
    public final FrameLayout parentMedia;
    public final LinearLayout postActionsContainer;
    public final UserAvatarView postAuthorImageView;
    public final TextView postAuthorUserNameTextView;
    public final RoundedImageView postByUserImageview;
    public final ImageView postCommentCameraImageView;
    public final ImageView postCommentGifImageView;
    public final ImageView postCommentsImageView;
    public final TextView postContentIdentifierView;
    public final ImageView postContentImageView;
    public final PlayerView postContentVideoView;
    public final SocialTextView postDescriptionTextView;
    public final TextView postFollowTextView;
    public final LinearLayout postInfoPopupContainer;
    public final TextView postLikeCountTextView;
    public final ImageView postLikeImageView;
    public final ContentLayout postMediaContentLayout;
    public final ImageView postMediaVolumeToggleButton;
    public final ImageView postOptionsImageView;
    public final IconTextHorizontalButton postSaveButton;
    public final ImageView postSaveImageView;
    public final IconTextHorizontalButton postShareButton;
    public final ImageView postShareImageView;
    public final ImageView postTaggedUsersIndicatorView;
    public final TextView postTimeTextView;
    public final PostViewCountView postViewCountIndicatorView;
    public final TextView postedByUserNameTextView;
    public final LinearLayout repostLinearLayout;
    private final LinearLayout rootView;
    public final LinearLayout screenshotUiContainer;
    public final TextView topCommentsHeaderTextView;

    private PostItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ImageView imageView, PostCommentPreviewBoxItemBinding postCommentPreviewBoxItemBinding, SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding, FrameLayout frameLayout, LinearLayout linearLayout4, UserAvatarView userAvatarView, TextView textView2, RoundedImageView roundedImageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, PlayerView playerView, SocialTextView socialTextView, TextView textView4, LinearLayout linearLayout5, TextView textView5, ImageView imageView6, ContentLayout contentLayout, ImageView imageView7, ImageView imageView8, IconTextHorizontalButton iconTextHorizontalButton, ImageView imageView9, IconTextHorizontalButton iconTextHorizontalButton2, ImageView imageView10, ImageView imageView11, TextView textView6, PostViewCountView postViewCountView, TextView textView7, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView8) {
        this.rootView = linearLayout;
        this.addCommentBox = linearLayout2;
        this.addCommentLayout = linearLayout3;
        this.commentsTextView = textView;
        this.heartView = imageView;
        this.includedCommentPreviewBox = postCommentPreviewBoxItemBinding;
        this.includedMediaProgressLayout = snippetPostMediaProgressBarBinding;
        this.parentMedia = frameLayout;
        this.postActionsContainer = linearLayout4;
        this.postAuthorImageView = userAvatarView;
        this.postAuthorUserNameTextView = textView2;
        this.postByUserImageview = roundedImageView;
        this.postCommentCameraImageView = imageView2;
        this.postCommentGifImageView = imageView3;
        this.postCommentsImageView = imageView4;
        this.postContentIdentifierView = textView3;
        this.postContentImageView = imageView5;
        this.postContentVideoView = playerView;
        this.postDescriptionTextView = socialTextView;
        this.postFollowTextView = textView4;
        this.postInfoPopupContainer = linearLayout5;
        this.postLikeCountTextView = textView5;
        this.postLikeImageView = imageView6;
        this.postMediaContentLayout = contentLayout;
        this.postMediaVolumeToggleButton = imageView7;
        this.postOptionsImageView = imageView8;
        this.postSaveButton = iconTextHorizontalButton;
        this.postSaveImageView = imageView9;
        this.postShareButton = iconTextHorizontalButton2;
        this.postShareImageView = imageView10;
        this.postTaggedUsersIndicatorView = imageView11;
        this.postTimeTextView = textView6;
        this.postViewCountIndicatorView = postViewCountView;
        this.postedByUserNameTextView = textView7;
        this.repostLinearLayout = linearLayout6;
        this.screenshotUiContainer = linearLayout7;
        this.topCommentsHeaderTextView = textView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PostItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostItemBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.add_comment_box;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.add_comment_box);
        if (linearLayout != null) {
            i = C4199R.C4203id.add_comment_layout;
            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.add_comment_layout);
            if (linearLayout2 != null) {
                i = C4199R.C4203id.comments_text_view;
                TextView textView = (TextView) view2.findViewById(C4199R.C4203id.comments_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.heartView;
                    ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.heartView);
                    if (imageView != null) {
                        i = C4199R.C4203id.included_comment_preview_box;
                        View findViewById = view2.findViewById(C4199R.C4203id.included_comment_preview_box);
                        if (findViewById != null) {
                            PostCommentPreviewBoxItemBinding bind = PostCommentPreviewBoxItemBinding.bind(findViewById);
                            i = C4199R.C4203id.included_media_progress_layout;
                            View findViewById2 = view2.findViewById(C4199R.C4203id.included_media_progress_layout);
                            if (findViewById2 != null) {
                                SnippetPostMediaProgressBarBinding bind2 = SnippetPostMediaProgressBarBinding.bind(findViewById2);
                                i = C4199R.C4203id.parent_media;
                                FrameLayout frameLayout = (FrameLayout) view2.findViewById(C4199R.C4203id.parent_media);
                                if (frameLayout != null) {
                                    i = C4199R.C4203id.post_actions_container;
                                    LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(C4199R.C4203id.post_actions_container);
                                    if (linearLayout3 != null) {
                                        i = C4199R.C4203id.post_author_image_view;
                                        UserAvatarView userAvatarView = (UserAvatarView) view2.findViewById(C4199R.C4203id.post_author_image_view);
                                        if (userAvatarView != null) {
                                            i = C4199R.C4203id.post_author_user_name_text_view;
                                            TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.post_author_user_name_text_view);
                                            if (textView2 != null) {
                                                i = C4199R.C4203id.post_by_user_imageview;
                                                RoundedImageView roundedImageView = (RoundedImageView) view2.findViewById(C4199R.C4203id.post_by_user_imageview);
                                                if (roundedImageView != null) {
                                                    i = C4199R.C4203id.post_comment_camera_image_view;
                                                    ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.post_comment_camera_image_view);
                                                    if (imageView2 != null) {
                                                        i = C4199R.C4203id.post_comment_gif_image_view;
                                                        ImageView imageView3 = (ImageView) view2.findViewById(C4199R.C4203id.post_comment_gif_image_view);
                                                        if (imageView3 != null) {
                                                            i = C4199R.C4203id.post_comments_image_view;
                                                            ImageView imageView4 = (ImageView) view2.findViewById(C4199R.C4203id.post_comments_image_view);
                                                            if (imageView4 != null) {
                                                                i = C4199R.C4203id.post_content_identifier_view;
                                                                TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.post_content_identifier_view);
                                                                if (textView3 != null) {
                                                                    i = C4199R.C4203id.post_content_image_view;
                                                                    ImageView imageView5 = (ImageView) view2.findViewById(C4199R.C4203id.post_content_image_view);
                                                                    if (imageView5 != null) {
                                                                        i = C4199R.C4203id.post_content_video_view;
                                                                        PlayerView playerView = (PlayerView) view2.findViewById(C4199R.C4203id.post_content_video_view);
                                                                        if (playerView != null) {
                                                                            i = C4199R.C4203id.post_description_text_view;
                                                                            SocialTextView socialTextView = (SocialTextView) view2.findViewById(C4199R.C4203id.post_description_text_view);
                                                                            if (socialTextView != null) {
                                                                                i = C4199R.C4203id.post_follow_text_view;
                                                                                TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.post_follow_text_view);
                                                                                if (textView4 != null) {
                                                                                    i = C4199R.C4203id.post_info_popup_container;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(C4199R.C4203id.post_info_popup_container);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = C4199R.C4203id.post_like_count_text_view;
                                                                                        TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.post_like_count_text_view);
                                                                                        if (textView5 != null) {
                                                                                            i = C4199R.C4203id.post_like_image_view;
                                                                                            ImageView imageView6 = (ImageView) view2.findViewById(C4199R.C4203id.post_like_image_view);
                                                                                            if (imageView6 != null) {
                                                                                                i = C4199R.C4203id.post_media_content_layout;
                                                                                                ContentLayout contentLayout = (ContentLayout) view2.findViewById(C4199R.C4203id.post_media_content_layout);
                                                                                                if (contentLayout != null) {
                                                                                                    i = C4199R.C4203id.post_media_volume_toggle_button;
                                                                                                    ImageView imageView7 = (ImageView) view2.findViewById(C4199R.C4203id.post_media_volume_toggle_button);
                                                                                                    if (imageView7 != null) {
                                                                                                        i = C4199R.C4203id.post_options_image_view;
                                                                                                        ImageView imageView8 = (ImageView) view2.findViewById(C4199R.C4203id.post_options_image_view);
                                                                                                        if (imageView8 != null) {
                                                                                                            i = C4199R.C4203id.post_save_button;
                                                                                                            IconTextHorizontalButton iconTextHorizontalButton = (IconTextHorizontalButton) view2.findViewById(C4199R.C4203id.post_save_button);
                                                                                                            if (iconTextHorizontalButton != null) {
                                                                                                                i = C4199R.C4203id.post_save_image_view;
                                                                                                                ImageView imageView9 = (ImageView) view2.findViewById(C4199R.C4203id.post_save_image_view);
                                                                                                                if (imageView9 != null) {
                                                                                                                    i = C4199R.C4203id.post_share_button;
                                                                                                                    IconTextHorizontalButton iconTextHorizontalButton2 = (IconTextHorizontalButton) view2.findViewById(C4199R.C4203id.post_share_button);
                                                                                                                    if (iconTextHorizontalButton2 != null) {
                                                                                                                        i = C4199R.C4203id.post_share_image_view;
                                                                                                                        ImageView imageView10 = (ImageView) view2.findViewById(C4199R.C4203id.post_share_image_view);
                                                                                                                        if (imageView10 != null) {
                                                                                                                            i = C4199R.C4203id.post_tagged_users_indicator_view;
                                                                                                                            ImageView imageView11 = (ImageView) view2.findViewById(C4199R.C4203id.post_tagged_users_indicator_view);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                i = C4199R.C4203id.post_time_text_view;
                                                                                                                                TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.post_time_text_view);
                                                                                                                                if (textView6 != null) {
                                                                                                                                    i = C4199R.C4203id.post_view_count_indicator_view;
                                                                                                                                    PostViewCountView postViewCountView = (PostViewCountView) view2.findViewById(C4199R.C4203id.post_view_count_indicator_view);
                                                                                                                                    if (postViewCountView != null) {
                                                                                                                                        i = C4199R.C4203id.posted_by_user_name_text_view;
                                                                                                                                        TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.posted_by_user_name_text_view);
                                                                                                                                        if (textView7 != null) {
                                                                                                                                            i = C4199R.C4203id.repost_linear_layout;
                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(C4199R.C4203id.repost_linear_layout);
                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                i = C4199R.C4203id.screenshot_ui_container;
                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) view2.findViewById(C4199R.C4203id.screenshot_ui_container);
                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                    i = C4199R.C4203id.top_comments_header_text_view;
                                                                                                                                                    TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.top_comments_header_text_view);
                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                        return new PostItemBinding((LinearLayout) view2, linearLayout, linearLayout2, textView, imageView, bind, bind2, frameLayout, linearLayout3, userAvatarView, textView2, roundedImageView, imageView2, imageView3, imageView4, textView3, imageView5, playerView, socialTextView, textView4, linearLayout4, textView5, imageView6, contentLayout, imageView7, imageView8, iconTextHorizontalButton, imageView9, iconTextHorizontalButton2, imageView10, imageView11, textView6, postViewCountView, textView7, linearLayout5, linearLayout6, textView8);
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
