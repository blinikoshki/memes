package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemAttachmentBinding implements ViewBinding {
    public final StreamItemAttachMediaBinding clAttachmentMedia;
    public final ListView lvAttachmentFile;
    private final ConstraintLayout rootView;
    public final Space spaceMediaFile;

    private StreamItemAttachmentBinding(ConstraintLayout constraintLayout, StreamItemAttachMediaBinding streamItemAttachMediaBinding, ListView listView, Space space) {
        this.rootView = constraintLayout;
        this.clAttachmentMedia = streamItemAttachMediaBinding;
        this.lvAttachmentFile = listView;
        this.spaceMediaFile = space;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemAttachmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemAttachmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_attachment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemAttachmentBinding bind(View view) {
        int i = C1673R.C1677id.cl_attachment_media;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            StreamItemAttachMediaBinding bind = StreamItemAttachMediaBinding.bind(findViewById);
            int i2 = C1673R.C1677id.lv_attachment_file;
            ListView listView = (ListView) view.findViewById(i2);
            if (listView != null) {
                i2 = C1673R.C1677id.space_media_file;
                Space space = (Space) view.findViewById(i2);
                if (space != null) {
                    return new StreamItemAttachmentBinding((ConstraintLayout) view, bind, listView, space);
                }
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
