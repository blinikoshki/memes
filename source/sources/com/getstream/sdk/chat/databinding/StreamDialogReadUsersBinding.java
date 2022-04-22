package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamDialogReadUsersBinding implements ViewBinding {
    public final ListView lvReadUser;
    private final ConstraintLayout rootView;

    private StreamDialogReadUsersBinding(ConstraintLayout constraintLayout, ListView listView) {
        this.rootView = constraintLayout;
        this.lvReadUser = listView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamDialogReadUsersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamDialogReadUsersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_dialog_read_users, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamDialogReadUsersBinding bind(View view) {
        int i = C1673R.C1677id.lv_read_user;
        ListView listView = (ListView) view.findViewById(i);
        if (listView != null) {
            return new StreamDialogReadUsersBinding((ConstraintLayout) view, listView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
