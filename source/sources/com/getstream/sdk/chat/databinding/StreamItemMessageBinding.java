package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.AttachmentListView;
import com.getstream.sdk.chat.view.AvatarView;
import com.getstream.sdk.chat.view.ReadStateView;

public final class StreamItemMessageBinding implements ViewBinding {
    public final AttachmentListView attachmentview;
    public final AvatarView avatar;
    public final ConstraintLayout itemMessageContainer;
    public final ImageView ivDeliver;
    public final ImageView ivReply;
    public final ImageView ivTail;
    public final ProgressBar pbDeliver;
    public final RecyclerView reactionsRecyclerView;
    public final ReadStateView readState;
    private final ConstraintLayout rootView;
    public final Space spaceAttachment;
    public final Space spaceHeader;
    public final Space spaceReaction;
    public final Space spaceReactionTail;
    public final Space spaceSameUser;
    public final TextView tvMessagedate;
    public final TextView tvReply;
    public final TextView tvText;
    public final TextView tvUsername;

    private StreamItemMessageBinding(ConstraintLayout constraintLayout, AttachmentListView attachmentListView, AvatarView avatarView, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, RecyclerView recyclerView, ReadStateView readStateView, Space space, Space space2, Space space3, Space space4, Space space5, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.attachmentview = attachmentListView;
        this.avatar = avatarView;
        this.itemMessageContainer = constraintLayout2;
        this.ivDeliver = imageView;
        this.ivReply = imageView2;
        this.ivTail = imageView3;
        this.pbDeliver = progressBar;
        this.reactionsRecyclerView = recyclerView;
        this.readState = readStateView;
        this.spaceAttachment = space;
        this.spaceHeader = space2;
        this.spaceReaction = space3;
        this.spaceReactionTail = space4;
        this.spaceSameUser = space5;
        this.tvMessagedate = textView;
        this.tvReply = textView2;
        this.tvText = textView3;
        this.tvUsername = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemMessageBinding bind(View view) {
        View view2 = view;
        int i = C1673R.C1677id.attachmentview;
        AttachmentListView attachmentListView = (AttachmentListView) view2.findViewById(i);
        if (attachmentListView != null) {
            i = C1673R.C1677id.avatar;
            AvatarView avatarView = (AvatarView) view2.findViewById(i);
            if (avatarView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                i = C1673R.C1677id.iv_deliver;
                ImageView imageView = (ImageView) view2.findViewById(i);
                if (imageView != null) {
                    i = C1673R.C1677id.iv_reply;
                    ImageView imageView2 = (ImageView) view2.findViewById(i);
                    if (imageView2 != null) {
                        i = C1673R.C1677id.iv_tail;
                        ImageView imageView3 = (ImageView) view2.findViewById(i);
                        if (imageView3 != null) {
                            i = C1673R.C1677id.pb_deliver;
                            ProgressBar progressBar = (ProgressBar) view2.findViewById(i);
                            if (progressBar != null) {
                                i = C1673R.C1677id.reactionsRecyclerView;
                                RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                                if (recyclerView != null) {
                                    i = C1673R.C1677id.read_state;
                                    ReadStateView readStateView = (ReadStateView) view2.findViewById(i);
                                    if (readStateView != null) {
                                        i = C1673R.C1677id.space_attachment;
                                        Space space = (Space) view2.findViewById(i);
                                        if (space != null) {
                                            i = C1673R.C1677id.space_header;
                                            Space space2 = (Space) view2.findViewById(i);
                                            if (space2 != null) {
                                                i = C1673R.C1677id.space_reaction;
                                                Space space3 = (Space) view2.findViewById(i);
                                                if (space3 != null) {
                                                    i = C1673R.C1677id.space_reaction_tail;
                                                    Space space4 = (Space) view2.findViewById(i);
                                                    if (space4 != null) {
                                                        i = C1673R.C1677id.space_same_user;
                                                        Space space5 = (Space) view2.findViewById(i);
                                                        if (space5 != null) {
                                                            i = C1673R.C1677id.tv_messagedate;
                                                            TextView textView = (TextView) view2.findViewById(i);
                                                            if (textView != null) {
                                                                i = C1673R.C1677id.tv_reply;
                                                                TextView textView2 = (TextView) view2.findViewById(i);
                                                                if (textView2 != null) {
                                                                    i = C1673R.C1677id.tv_text;
                                                                    TextView textView3 = (TextView) view2.findViewById(i);
                                                                    if (textView3 != null) {
                                                                        i = C1673R.C1677id.tv_username;
                                                                        TextView textView4 = (TextView) view2.findViewById(i);
                                                                        if (textView4 != null) {
                                                                            return new StreamItemMessageBinding(constraintLayout, attachmentListView, avatarView, constraintLayout, imageView, imageView2, imageView3, progressBar, recyclerView, readStateView, space, space2, space3, space4, space5, textView, textView2, textView3, textView4);
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
