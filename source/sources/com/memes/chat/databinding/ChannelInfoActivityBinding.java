package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.memes.chat.C4059R;
import com.memes.commons.contentlayout.ContentLayout;

public final class ChannelInfoActivityBinding implements ViewBinding {
    public final TextView addChannelMembersTextView;
    public final ImageView backImageView;
    public final ImageView changeChannelPicImageView;
    public final ContentLayout channelInfoContentLayout;
    public final ConstraintLayout channelMembersContainer;
    public final TextView channelMembersLabel;
    public final RecyclerView channelMembersRecyclerView;
    public final LinearLayout channelOptionsContainer;
    public final TextView channelOptionsLabel;
    public final ImageView channelPicImageView;
    public final CollapsingToolbarLayout collapsingToolbar;
    public final TextView deleteChannelTextView;
    public final TextView leaveChannelTextView;
    public final LinearLayout multiUserChannelNameContainer;
    public final EditText multiUserChannelNameEditText;
    public final TextView multiUserChannelNameLabel;
    private final LinearLayout rootView;
    public final TextView saveChannelInfoTextView;
    public final ConstraintLayout titleContainer;
    public final TextView titleTextView;
    public final SwitchMaterial toggleMuteChannelSwitch;

    private ChannelInfoActivityBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, ContentLayout contentLayout, ConstraintLayout constraintLayout, TextView textView2, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView3, ImageView imageView3, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView4, TextView textView5, LinearLayout linearLayout3, EditText editText, TextView textView6, TextView textView7, ConstraintLayout constraintLayout2, TextView textView8, SwitchMaterial switchMaterial) {
        this.rootView = linearLayout;
        this.addChannelMembersTextView = textView;
        this.backImageView = imageView;
        this.changeChannelPicImageView = imageView2;
        this.channelInfoContentLayout = contentLayout;
        this.channelMembersContainer = constraintLayout;
        this.channelMembersLabel = textView2;
        this.channelMembersRecyclerView = recyclerView;
        this.channelOptionsContainer = linearLayout2;
        this.channelOptionsLabel = textView3;
        this.channelPicImageView = imageView3;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.deleteChannelTextView = textView4;
        this.leaveChannelTextView = textView5;
        this.multiUserChannelNameContainer = linearLayout3;
        this.multiUserChannelNameEditText = editText;
        this.multiUserChannelNameLabel = textView6;
        this.saveChannelInfoTextView = textView7;
        this.titleContainer = constraintLayout2;
        this.titleTextView = textView8;
        this.toggleMuteChannelSwitch = switchMaterial;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelInfoActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelInfoActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_info_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelInfoActivityBinding bind(View view) {
        View view2 = view;
        int i = C4059R.C4063id.add_channel_members_text_view;
        TextView textView = (TextView) view2.findViewById(i);
        if (textView != null) {
            i = C4059R.C4063id.back_image_view;
            ImageView imageView = (ImageView) view2.findViewById(i);
            if (imageView != null) {
                i = C4059R.C4063id.change_channel_pic_image_view;
                ImageView imageView2 = (ImageView) view2.findViewById(i);
                if (imageView2 != null) {
                    i = C4059R.C4063id.channel_info_content_layout;
                    ContentLayout contentLayout = (ContentLayout) view2.findViewById(i);
                    if (contentLayout != null) {
                        i = C4059R.C4063id.channel_members_container;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(i);
                        if (constraintLayout != null) {
                            i = C4059R.C4063id.channel_members_label;
                            TextView textView2 = (TextView) view2.findViewById(i);
                            if (textView2 != null) {
                                i = C4059R.C4063id.channel_members_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                                if (recyclerView != null) {
                                    i = C4059R.C4063id.channel_options_container;
                                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                                    if (linearLayout != null) {
                                        i = C4059R.C4063id.channel_options_label;
                                        TextView textView3 = (TextView) view2.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4059R.C4063id.channel_pic_image_view;
                                            ImageView imageView3 = (ImageView) view2.findViewById(i);
                                            if (imageView3 != null) {
                                                i = C4059R.C4063id.collapsing_toolbar;
                                                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view2.findViewById(i);
                                                if (collapsingToolbarLayout != null) {
                                                    i = C4059R.C4063id.delete_channel_text_view;
                                                    TextView textView4 = (TextView) view2.findViewById(i);
                                                    if (textView4 != null) {
                                                        i = C4059R.C4063id.leave_channel_text_view;
                                                        TextView textView5 = (TextView) view2.findViewById(i);
                                                        if (textView5 != null) {
                                                            i = C4059R.C4063id.multi_user_channel_name_container;
                                                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(i);
                                                            if (linearLayout2 != null) {
                                                                i = C4059R.C4063id.multi_user_channel_name_edit_text;
                                                                EditText editText = (EditText) view2.findViewById(i);
                                                                if (editText != null) {
                                                                    i = C4059R.C4063id.multi_user_channel_name_label;
                                                                    TextView textView6 = (TextView) view2.findViewById(i);
                                                                    if (textView6 != null) {
                                                                        i = C4059R.C4063id.save_channel_info_text_view;
                                                                        TextView textView7 = (TextView) view2.findViewById(i);
                                                                        if (textView7 != null) {
                                                                            i = C4059R.C4063id.title_container;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(i);
                                                                            if (constraintLayout2 != null) {
                                                                                i = C4059R.C4063id.title_text_view;
                                                                                TextView textView8 = (TextView) view2.findViewById(i);
                                                                                if (textView8 != null) {
                                                                                    i = C4059R.C4063id.toggle_mute_channel_switch;
                                                                                    SwitchMaterial switchMaterial = (SwitchMaterial) view2.findViewById(i);
                                                                                    if (switchMaterial != null) {
                                                                                        return new ChannelInfoActivityBinding((LinearLayout) view2, textView, imageView, imageView2, contentLayout, constraintLayout, textView2, recyclerView, linearLayout, textView3, imageView3, collapsingToolbarLayout, textView4, textView5, linearLayout2, editText, textView6, textView7, constraintLayout2, textView8, switchMaterial);
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
