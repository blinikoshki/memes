package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class CreateChannelAdditionalInfoFragmentBinding implements ViewBinding {
    public final ChatUserAvatarView channelAvatarView;
    public final TextInputEditText channelDescriptionEditText;
    public final TextView channelMembersEditTextView;
    public final TextView channelMembersLabel;
    public final RecyclerView channelMembersRecyclerView;
    public final View channelMembersSeparator;
    public final TextInputEditText channelNameEditText;
    public final TextView channelNameLabel;
    private final ConstraintLayout rootView;

    private CreateChannelAdditionalInfoFragmentBinding(ConstraintLayout constraintLayout, ChatUserAvatarView chatUserAvatarView, TextInputEditText textInputEditText, TextView textView, TextView textView2, RecyclerView recyclerView, View view, TextInputEditText textInputEditText2, TextView textView3) {
        this.rootView = constraintLayout;
        this.channelAvatarView = chatUserAvatarView;
        this.channelDescriptionEditText = textInputEditText;
        this.channelMembersEditTextView = textView;
        this.channelMembersLabel = textView2;
        this.channelMembersRecyclerView = recyclerView;
        this.channelMembersSeparator = view;
        this.channelNameEditText = textInputEditText2;
        this.channelNameLabel = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CreateChannelAdditionalInfoFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CreateChannelAdditionalInfoFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.create_channel_additional_info_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.memes.chat.C4059R.C4063id.channel_members_separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.memes.chat.databinding.CreateChannelAdditionalInfoFragmentBinding bind(android.view.View r12) {
        /*
            int r0 = com.memes.chat.C4059R.C4063id.channel_avatar_view
            android.view.View r1 = r12.findViewById(r0)
            r4 = r1
            com.memes.chat.ui.custom.ChatUserAvatarView r4 = (com.memes.chat.p036ui.custom.ChatUserAvatarView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_description_edit_text
            android.view.View r1 = r12.findViewById(r0)
            r5 = r1
            com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_members_edit_text_view
            android.view.View r1 = r12.findViewById(r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_members_label
            android.view.View r1 = r12.findViewById(r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_members_recycler_view
            android.view.View r1 = r12.findViewById(r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_members_separator
            android.view.View r9 = r12.findViewById(r0)
            if (r9 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_name_edit_text
            android.view.View r1 = r12.findViewById(r0)
            r10 = r1
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.memes.chat.C4059R.C4063id.channel_name_label
            android.view.View r1 = r12.findViewById(r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            com.memes.chat.databinding.CreateChannelAdditionalInfoFragmentBinding r0 = new com.memes.chat.databinding.CreateChannelAdditionalInfoFragmentBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.databinding.CreateChannelAdditionalInfoFragmentBinding.bind(android.view.View):com.memes.chat.databinding.CreateChannelAdditionalInfoFragmentBinding");
    }
}
