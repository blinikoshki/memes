package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.roundedImageView.PorterShapeImageView;

public final class StreamItemAttachMediaBinding implements ViewBinding {
    public final ConstraintLayout clAction;
    public final ConstraintLayout clDes;
    public final ImageView ivCommandLogo;
    public final PorterShapeImageView ivMediaThumb;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvActionCancel;
    public final TextView tvActionSend;
    public final TextView tvActionShuffle;
    public final TextView tvMediaDes;
    public final TextView tvMediaPlay;
    public final TextView tvMediaTitle;

    private StreamItemAttachMediaBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, PorterShapeImageView porterShapeImageView, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.clAction = constraintLayout2;
        this.clDes = constraintLayout3;
        this.ivCommandLogo = imageView;
        this.ivMediaThumb = porterShapeImageView;
        this.progressBar = progressBar2;
        this.tvActionCancel = textView;
        this.tvActionSend = textView2;
        this.tvActionShuffle = textView3;
        this.tvMediaDes = textView4;
        this.tvMediaPlay = textView5;
        this.tvMediaTitle = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemAttachMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemAttachMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_attach_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemAttachMediaBinding bind(View view) {
        int i = C1673R.C1677id.cl_action;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
        if (constraintLayout != null) {
            i = C1673R.C1677id.cl_des;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout2 != null) {
                i = C1673R.C1677id.iv_command_logo;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C1673R.C1677id.iv_media_thumb;
                    PorterShapeImageView porterShapeImageView = (PorterShapeImageView) view.findViewById(i);
                    if (porterShapeImageView != null) {
                        i = C1673R.C1677id.progressBar;
                        ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                        if (progressBar2 != null) {
                            i = C1673R.C1677id.tv_action_cancel;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C1673R.C1677id.tv_action_send;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C1673R.C1677id.tv_action_shuffle;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = C1673R.C1677id.tv_media_des;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = C1673R.C1677id.tv_media_play;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = C1673R.C1677id.tv_media_title;
                                                TextView textView6 = (TextView) view.findViewById(i);
                                                if (textView6 != null) {
                                                    return new StreamItemAttachMediaBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, imageView, porterShapeImageView, progressBar2, textView, textView2, textView3, textView4, textView5, textView6);
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
