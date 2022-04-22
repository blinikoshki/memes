package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class UserActionsBottomSheetBinding implements ViewBinding {
    public final TextView avatarLabelView;
    public final ChatUserAvatarView avatarView;
    public final TextView banUserLabelView;
    public final LinearLayout banUserView;
    public final TextView muteUserLabelView;
    public final LinearLayout muteUserView;
    public final TextView reportUserLabelView;
    public final LinearLayout reportUserView;
    private final LinearLayout rootView;
    public final TextView sendMessageLabelView;
    public final LinearLayout sendMessageView;
    public final TextView viewProfileLabelView;
    public final LinearLayout viewProfileView;

    private UserActionsBottomSheetBinding(LinearLayout linearLayout, TextView textView, ChatUserAvatarView chatUserAvatarView, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, LinearLayout linearLayout4, TextView textView5, LinearLayout linearLayout5, TextView textView6, LinearLayout linearLayout6) {
        this.rootView = linearLayout;
        this.avatarLabelView = textView;
        this.avatarView = chatUserAvatarView;
        this.banUserLabelView = textView2;
        this.banUserView = linearLayout2;
        this.muteUserLabelView = textView3;
        this.muteUserView = linearLayout3;
        this.reportUserLabelView = textView4;
        this.reportUserView = linearLayout4;
        this.sendMessageLabelView = textView5;
        this.sendMessageView = linearLayout5;
        this.viewProfileLabelView = textView6;
        this.viewProfileView = linearLayout6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserActionsBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static UserActionsBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.user_actions_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserActionsBottomSheetBinding bind(View view) {
        View view2 = view;
        int i = C4059R.C4063id.avatar_label_view;
        TextView textView = (TextView) view2.findViewById(i);
        if (textView != null) {
            i = C4059R.C4063id.avatar_view;
            ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view2.findViewById(i);
            if (chatUserAvatarView != null) {
                i = C4059R.C4063id.ban_user_label_view;
                TextView textView2 = (TextView) view2.findViewById(i);
                if (textView2 != null) {
                    i = C4059R.C4063id.ban_user_view;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                    if (linearLayout != null) {
                        i = C4059R.C4063id.mute_user_label_view;
                        TextView textView3 = (TextView) view2.findViewById(i);
                        if (textView3 != null) {
                            i = C4059R.C4063id.mute_user_view;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(i);
                            if (linearLayout2 != null) {
                                i = C4059R.C4063id.report_user_label_view;
                                TextView textView4 = (TextView) view2.findViewById(i);
                                if (textView4 != null) {
                                    i = C4059R.C4063id.report_user_view;
                                    LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                    if (linearLayout3 != null) {
                                        i = C4059R.C4063id.send_message_label_view;
                                        TextView textView5 = (TextView) view2.findViewById(i);
                                        if (textView5 != null) {
                                            i = C4059R.C4063id.send_message_view;
                                            LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                            if (linearLayout4 != null) {
                                                i = C4059R.C4063id.view_profile_label_view;
                                                TextView textView6 = (TextView) view2.findViewById(i);
                                                if (textView6 != null) {
                                                    i = C4059R.C4063id.view_profile_view;
                                                    LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(i);
                                                    if (linearLayout5 != null) {
                                                        return new UserActionsBottomSheetBinding((LinearLayout) view2, textView, chatUserAvatarView, textView2, linearLayout, textView3, linearLayout2, textView4, linearLayout3, textView5, linearLayout4, textView6, linearLayout5);
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
