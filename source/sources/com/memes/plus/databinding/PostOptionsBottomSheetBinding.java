package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class PostOptionsBottomSheetBinding implements ViewBinding {
    public final TextView cancelTextView;
    public final TextView copyLinkTextView;
    public final TextView deleteTextView;
    public final TextView downloadPostTextView;
    public final TextView reportInappropriateTextView;
    public final TextView reportSpamTextView;
    public final TextView reportTextView;
    public final TextView repostTextView;
    private final CardView rootView;
    public final TextView shareProfileTextView;
    public final TextView toggleNotificationsTextView;
    public final TextView unfollowTextView;

    private PostOptionsBottomSheetBinding(CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = cardView;
        this.cancelTextView = textView;
        this.copyLinkTextView = textView2;
        this.deleteTextView = textView3;
        this.downloadPostTextView = textView4;
        this.reportInappropriateTextView = textView5;
        this.reportSpamTextView = textView6;
        this.reportTextView = textView7;
        this.repostTextView = textView8;
        this.shareProfileTextView = textView9;
        this.toggleNotificationsTextView = textView10;
        this.unfollowTextView = textView11;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static PostOptionsBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostOptionsBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_options_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostOptionsBottomSheetBinding bind(View view) {
        int i = C4199R.C4203id.cancel_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.cancel_text_view);
        if (textView != null) {
            i = C4199R.C4203id.copy_link_text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.copy_link_text_view);
            if (textView2 != null) {
                i = C4199R.C4203id.delete_text_view;
                TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.delete_text_view);
                if (textView3 != null) {
                    i = C4199R.C4203id.download_post_text_view;
                    TextView textView4 = (TextView) view.findViewById(C4199R.C4203id.download_post_text_view);
                    if (textView4 != null) {
                        i = C4199R.C4203id.report_inappropriate_text_view;
                        TextView textView5 = (TextView) view.findViewById(C4199R.C4203id.report_inappropriate_text_view);
                        if (textView5 != null) {
                            i = C4199R.C4203id.report_spam_text_view;
                            TextView textView6 = (TextView) view.findViewById(C4199R.C4203id.report_spam_text_view);
                            if (textView6 != null) {
                                i = C4199R.C4203id.report_text_view;
                                TextView textView7 = (TextView) view.findViewById(C4199R.C4203id.report_text_view);
                                if (textView7 != null) {
                                    i = C4199R.C4203id.repost_text_view;
                                    TextView textView8 = (TextView) view.findViewById(C4199R.C4203id.repost_text_view);
                                    if (textView8 != null) {
                                        i = C4199R.C4203id.share_profile_text_view;
                                        TextView textView9 = (TextView) view.findViewById(C4199R.C4203id.share_profile_text_view);
                                        if (textView9 != null) {
                                            i = C4199R.C4203id.toggle_notifications_text_view;
                                            TextView textView10 = (TextView) view.findViewById(C4199R.C4203id.toggle_notifications_text_view);
                                            if (textView10 != null) {
                                                i = C4199R.C4203id.unfollow_text_view;
                                                TextView textView11 = (TextView) view.findViewById(C4199R.C4203id.unfollow_text_view);
                                                if (textView11 != null) {
                                                    return new PostOptionsBottomSheetBinding((CardView) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
