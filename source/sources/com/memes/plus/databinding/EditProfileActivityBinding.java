package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class EditProfileActivityBinding implements ViewBinding {
    public final EditText bioEditText;
    public final TextView bioLabelTextView;
    public final ContentLayout contentLayout;
    public final ImageView coverImageView;
    public final EditText locationEditText;
    public final TextView locationLabelTextView;
    public final TextView logoutTextView;
    public final EditText nameEditText;
    public final TextView nameLabelTextView;
    public final TextView notificationSettingsTextView;
    public final View optionsDivider;
    public final TextView privacyPolicyTextView;
    public final ImageView profilePicAddImageView;
    public final UserAvatarView profilePicImageView;
    public final TextView rateAppTextView;
    public final TextView restorePurchasesTextView;
    private final ContentLayout rootView;
    public final TextView storeTextView;
    public final TextView supportTextView;
    public final TextView termsConditionsTextView;
    public final ImageView topBarBackImageView;
    public final LinearLayout topBarLayout;
    public final Button topBarSaveButton;
    public final TextView topBarTitleTextView;
    public final EditText usernameEditText;
    public final TextView usernameLabelTextView;

    private EditProfileActivityBinding(ContentLayout contentLayout2, EditText editText, TextView textView, ContentLayout contentLayout3, ImageView imageView, EditText editText2, TextView textView2, TextView textView3, EditText editText3, TextView textView4, TextView textView5, View view, TextView textView6, ImageView imageView2, UserAvatarView userAvatarView, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ImageView imageView3, LinearLayout linearLayout, Button button, TextView textView12, EditText editText4, TextView textView13) {
        this.rootView = contentLayout2;
        this.bioEditText = editText;
        this.bioLabelTextView = textView;
        this.contentLayout = contentLayout3;
        this.coverImageView = imageView;
        this.locationEditText = editText2;
        this.locationLabelTextView = textView2;
        this.logoutTextView = textView3;
        this.nameEditText = editText3;
        this.nameLabelTextView = textView4;
        this.notificationSettingsTextView = textView5;
        this.optionsDivider = view;
        this.privacyPolicyTextView = textView6;
        this.profilePicAddImageView = imageView2;
        this.profilePicImageView = userAvatarView;
        this.rateAppTextView = textView7;
        this.restorePurchasesTextView = textView8;
        this.storeTextView = textView9;
        this.supportTextView = textView10;
        this.termsConditionsTextView = textView11;
        this.topBarBackImageView = imageView3;
        this.topBarLayout = linearLayout;
        this.topBarSaveButton = button;
        this.topBarTitleTextView = textView12;
        this.usernameEditText = editText4;
        this.usernameLabelTextView = textView13;
    }

    public ContentLayout getRoot() {
        return this.rootView;
    }

    public static EditProfileActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditProfileActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.edit_profile_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditProfileActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.bio_edit_text;
        EditText editText = (EditText) view2.findViewById(C4199R.C4203id.bio_edit_text);
        if (editText != null) {
            i = C4199R.C4203id.bio_label_text_view;
            TextView textView = (TextView) view2.findViewById(C4199R.C4203id.bio_label_text_view);
            if (textView != null) {
                ContentLayout contentLayout2 = (ContentLayout) view2;
                i = C4199R.C4203id.cover_image_view;
                ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.cover_image_view);
                if (imageView != null) {
                    i = C4199R.C4203id.location_edit_text;
                    EditText editText2 = (EditText) view2.findViewById(C4199R.C4203id.location_edit_text);
                    if (editText2 != null) {
                        i = C4199R.C4203id.location_label_text_view;
                        TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.location_label_text_view);
                        if (textView2 != null) {
                            i = C4199R.C4203id.logout_text_view;
                            TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.logout_text_view);
                            if (textView3 != null) {
                                i = C4199R.C4203id.name_edit_text;
                                EditText editText3 = (EditText) view2.findViewById(C4199R.C4203id.name_edit_text);
                                if (editText3 != null) {
                                    i = C4199R.C4203id.name_label_text_view;
                                    TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.name_label_text_view);
                                    if (textView4 != null) {
                                        i = C4199R.C4203id.notification_settings_text_view;
                                        TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.notification_settings_text_view);
                                        if (textView5 != null) {
                                            i = C4199R.C4203id.options_divider;
                                            View findViewById = view2.findViewById(C4199R.C4203id.options_divider);
                                            if (findViewById != null) {
                                                i = C4199R.C4203id.privacy_policy_text_view;
                                                TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.privacy_policy_text_view);
                                                if (textView6 != null) {
                                                    i = C4199R.C4203id.profile_pic_add_image_view;
                                                    ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.profile_pic_add_image_view);
                                                    if (imageView2 != null) {
                                                        i = C4199R.C4203id.profile_pic_image_view;
                                                        UserAvatarView userAvatarView = (UserAvatarView) view2.findViewById(C4199R.C4203id.profile_pic_image_view);
                                                        if (userAvatarView != null) {
                                                            i = C4199R.C4203id.rate_app_text_view;
                                                            TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.rate_app_text_view);
                                                            if (textView7 != null) {
                                                                i = C4199R.C4203id.restore_purchases_text_view;
                                                                TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.restore_purchases_text_view);
                                                                if (textView8 != null) {
                                                                    i = C4199R.C4203id.store_text_view;
                                                                    TextView textView9 = (TextView) view2.findViewById(C4199R.C4203id.store_text_view);
                                                                    if (textView9 != null) {
                                                                        i = C4199R.C4203id.support_text_view;
                                                                        TextView textView10 = (TextView) view2.findViewById(C4199R.C4203id.support_text_view);
                                                                        if (textView10 != null) {
                                                                            i = C4199R.C4203id.terms_conditions_text_view;
                                                                            TextView textView11 = (TextView) view2.findViewById(C4199R.C4203id.terms_conditions_text_view);
                                                                            if (textView11 != null) {
                                                                                i = C4199R.C4203id.top_bar_back_image_view;
                                                                                ImageView imageView3 = (ImageView) view2.findViewById(C4199R.C4203id.top_bar_back_image_view);
                                                                                if (imageView3 != null) {
                                                                                    i = C4199R.C4203id.top_bar_layout;
                                                                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.top_bar_layout);
                                                                                    if (linearLayout != null) {
                                                                                        i = C4199R.C4203id.top_bar_save_button;
                                                                                        Button button = (Button) view2.findViewById(C4199R.C4203id.top_bar_save_button);
                                                                                        if (button != null) {
                                                                                            i = C4199R.C4203id.top_bar_title_text_view;
                                                                                            TextView textView12 = (TextView) view2.findViewById(C4199R.C4203id.top_bar_title_text_view);
                                                                                            if (textView12 != null) {
                                                                                                i = C4199R.C4203id.username_edit_text;
                                                                                                EditText editText4 = (EditText) view2.findViewById(C4199R.C4203id.username_edit_text);
                                                                                                if (editText4 != null) {
                                                                                                    i = C4199R.C4203id.username_label_text_view;
                                                                                                    TextView textView13 = (TextView) view2.findViewById(C4199R.C4203id.username_label_text_view);
                                                                                                    if (textView13 != null) {
                                                                                                        return new EditProfileActivityBinding(contentLayout2, editText, textView, contentLayout2, imageView, editText2, textView2, textView3, editText3, textView4, textView5, findViewById, textView6, imageView2, userAvatarView, textView7, textView8, textView9, textView10, textView11, imageView3, linearLayout, button, textView12, editText4, textView13);
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
