package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class PostInviteViewBoxBinding implements ViewBinding {
    public final ImageView appIconImageView;
    public final ImageView closeInviteImageView;
    public final Button inviteButton;
    public final TextView inviteFriendsTextView;
    public final RelativeLayout parentViewLayout;
    private final CardView rootView;

    private PostInviteViewBoxBinding(CardView cardView, ImageView imageView, ImageView imageView2, Button button, TextView textView, RelativeLayout relativeLayout) {
        this.rootView = cardView;
        this.appIconImageView = imageView;
        this.closeInviteImageView = imageView2;
        this.inviteButton = button;
        this.inviteFriendsTextView = textView;
        this.parentViewLayout = relativeLayout;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static PostInviteViewBoxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostInviteViewBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_invite_view_box, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostInviteViewBoxBinding bind(View view) {
        int i = C4199R.C4203id.app_icon_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.app_icon_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.close_invite_image_view;
            ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.close_invite_image_view);
            if (imageView2 != null) {
                i = C4199R.C4203id.invite_button;
                Button button = (Button) view.findViewById(C4199R.C4203id.invite_button);
                if (button != null) {
                    i = C4199R.C4203id.invite_friends_text_view;
                    TextView textView = (TextView) view.findViewById(C4199R.C4203id.invite_friends_text_view);
                    if (textView != null) {
                        i = C4199R.C4203id.parent_view_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C4199R.C4203id.parent_view_layout);
                        if (relativeLayout != null) {
                            return new PostInviteViewBoxBinding((CardView) view, imageView, imageView2, button, textView, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
