package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.view.AvatarView;
import com.getstream.sdk.chat.view.ReadStateView;
import com.memes.chat.C4059R;

public final class SdkStreamItemChannelBinding implements ViewBinding {
    public final AvatarView avatarGroup;
    public final ConstraintLayout clRoot;
    public final View clickArea;
    public final ImageView ivAttachmentType;
    public final ImageView ivSeparator;
    public final ReadStateView readState;
    private final ConstraintLayout rootView;
    public final TextView tvDate;
    public final TextView tvLastMessage;
    public final TextView tvName;

    private SdkStreamItemChannelBinding(ConstraintLayout constraintLayout, AvatarView avatarView, ConstraintLayout constraintLayout2, View view, ImageView imageView, ImageView imageView2, ReadStateView readStateView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.avatarGroup = avatarView;
        this.clRoot = constraintLayout2;
        this.clickArea = view;
        this.ivAttachmentType = imageView;
        this.ivSeparator = imageView2;
        this.readState = readStateView;
        this.tvDate = textView;
        this.tvLastMessage = textView2;
        this.tvName = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SdkStreamItemChannelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SdkStreamItemChannelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.sdk_stream_item_channel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SdkStreamItemChannelBinding bind(View view) {
        int i = C4059R.C4063id.avatar_group;
        AvatarView avatarView = (AvatarView) view.findViewById(i);
        if (avatarView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = C4059R.C4063id.click_area;
            View findViewById = view.findViewById(i);
            if (findViewById != null) {
                i = C4059R.C4063id.iv_attachment_type;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4059R.C4063id.iv_separator;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C4059R.C4063id.read_state;
                        ReadStateView readStateView = (ReadStateView) view.findViewById(i);
                        if (readStateView != null) {
                            i = C4059R.C4063id.tv_date;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C4059R.C4063id.tv_last_message;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C4059R.C4063id.tv_name;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        return new SdkStreamItemChannelBinding(constraintLayout, avatarView, constraintLayout, findViewById, imageView, imageView2, readStateView, textView, textView2, textView3);
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
