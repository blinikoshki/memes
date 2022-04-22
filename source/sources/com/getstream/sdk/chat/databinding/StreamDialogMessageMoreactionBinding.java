package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamDialogMessageMoreactionBinding implements ViewBinding {
    public final LinearLayout copyMessageButton;
    public final ImageView copyMessageButtonImageView;
    public final TextView copyMessageButtonTextView;
    public final LinearLayout deleteMessageButton;
    public final ImageView deleteMessageButtonImageView;
    public final TextView deleteMessageButtonTextView;
    public final LinearLayout editMessageButton;
    public final ImageView editMessageButtonImageView;
    public final TextView editMessageButtonTextView;
    public final LinearLayout flagMessageButton;
    public final ImageView flagMessageButtonImageView;
    public final TextView flagMessageButtonTextView;
    public final LinearLayout messageActionButtons;
    public final RelativeLayout reactionsContainer;
    public final RecyclerView reactionsRecyclerView;
    private final ConstraintLayout rootView;
    public final LinearLayout startThreadButton;
    public final ImageView startThreadButtonImageView;
    public final TextView startThreadButtonTextView;

    private StreamDialogMessageMoreactionBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, ImageView imageView2, TextView textView2, LinearLayout linearLayout3, ImageView imageView3, TextView textView3, LinearLayout linearLayout4, ImageView imageView4, TextView textView4, LinearLayout linearLayout5, RelativeLayout relativeLayout, RecyclerView recyclerView, LinearLayout linearLayout6, ImageView imageView5, TextView textView5) {
        this.rootView = constraintLayout;
        this.copyMessageButton = linearLayout;
        this.copyMessageButtonImageView = imageView;
        this.copyMessageButtonTextView = textView;
        this.deleteMessageButton = linearLayout2;
        this.deleteMessageButtonImageView = imageView2;
        this.deleteMessageButtonTextView = textView2;
        this.editMessageButton = linearLayout3;
        this.editMessageButtonImageView = imageView3;
        this.editMessageButtonTextView = textView3;
        this.flagMessageButton = linearLayout4;
        this.flagMessageButtonImageView = imageView4;
        this.flagMessageButtonTextView = textView4;
        this.messageActionButtons = linearLayout5;
        this.reactionsContainer = relativeLayout;
        this.reactionsRecyclerView = recyclerView;
        this.startThreadButton = linearLayout6;
        this.startThreadButtonImageView = imageView5;
        this.startThreadButtonTextView = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamDialogMessageMoreactionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamDialogMessageMoreactionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_dialog_message_moreaction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamDialogMessageMoreactionBinding bind(View view) {
        View view2 = view;
        int i = C1673R.C1677id.copyMessageButton;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
        if (linearLayout != null) {
            i = C1673R.C1677id.copyMessageButtonImageView;
            ImageView imageView = (ImageView) view2.findViewById(i);
            if (imageView != null) {
                i = C1673R.C1677id.copyMessageButtonTextView;
                TextView textView = (TextView) view2.findViewById(i);
                if (textView != null) {
                    i = C1673R.C1677id.deleteMessageButton;
                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(i);
                    if (linearLayout2 != null) {
                        i = C1673R.C1677id.deleteMessageButtonImageView;
                        ImageView imageView2 = (ImageView) view2.findViewById(i);
                        if (imageView2 != null) {
                            i = C1673R.C1677id.deleteMessageButtonTextView;
                            TextView textView2 = (TextView) view2.findViewById(i);
                            if (textView2 != null) {
                                i = C1673R.C1677id.editMessageButton;
                                LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                if (linearLayout3 != null) {
                                    i = C1673R.C1677id.editMessageButtonImageView;
                                    ImageView imageView3 = (ImageView) view2.findViewById(i);
                                    if (imageView3 != null) {
                                        i = C1673R.C1677id.editMessageButtonTextView;
                                        TextView textView3 = (TextView) view2.findViewById(i);
                                        if (textView3 != null) {
                                            i = C1673R.C1677id.flagMessageButton;
                                            LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                            if (linearLayout4 != null) {
                                                i = C1673R.C1677id.flagMessageButtonImageView;
                                                ImageView imageView4 = (ImageView) view2.findViewById(i);
                                                if (imageView4 != null) {
                                                    i = C1673R.C1677id.flagMessageButtonTextView;
                                                    TextView textView4 = (TextView) view2.findViewById(i);
                                                    if (textView4 != null) {
                                                        i = C1673R.C1677id.messageActionButtons;
                                                        LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(i);
                                                        if (linearLayout5 != null) {
                                                            i = C1673R.C1677id.reactionsContainer;
                                                            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(i);
                                                            if (relativeLayout != null) {
                                                                i = C1673R.C1677id.reactionsRecyclerView;
                                                                RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                                                                if (recyclerView != null) {
                                                                    i = C1673R.C1677id.startThreadButton;
                                                                    LinearLayout linearLayout6 = (LinearLayout) view2.findViewById(i);
                                                                    if (linearLayout6 != null) {
                                                                        i = C1673R.C1677id.startThreadButtonImageView;
                                                                        ImageView imageView5 = (ImageView) view2.findViewById(i);
                                                                        if (imageView5 != null) {
                                                                            i = C1673R.C1677id.startThreadButtonTextView;
                                                                            TextView textView5 = (TextView) view2.findViewById(i);
                                                                            if (textView5 != null) {
                                                                                return new StreamDialogMessageMoreactionBinding((ConstraintLayout) view2, linearLayout, imageView, textView, linearLayout2, imageView2, textView2, linearLayout3, imageView3, textView3, linearLayout4, imageView4, textView4, linearLayout5, relativeLayout, recyclerView, linearLayout6, imageView5, textView5);
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
