package com.getstream.sdk.chat.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.CommandMentionListItemAdapter;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.ArrayList;
import java.util.List;
import p015io.getstream.chat.android.client.models.ChannelUserRead;

public class ReadUsersDialog extends Dialog {
    List<ChannelUserRead> reads;
    MessageListViewStyle style;

    public ReadUsersDialog(Context context) {
        super(context);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.flags &= -3;
        window.setAttributes(attributes);
    }

    public ReadUsersDialog setReads(List<ChannelUserRead> list) {
        this.reads = list;
        init();
        return this;
    }

    public ReadUsersDialog setStyle(MessageListViewStyle messageListViewStyle) {
        this.style = messageListViewStyle;
        init();
        return this;
    }

    public void init() {
        if (this.reads != null && this.style != null) {
            setContentView(C1673R.C1679layout.stream_dialog_read_users);
            ListView listView = (ListView) findViewById(C1673R.C1677id.lv_read_user);
            ArrayList arrayList = new ArrayList();
            for (ChannelUserRead user : this.reads) {
                arrayList.add(user.getUser());
            }
            listView.setAdapter(new CommandMentionListItemAdapter(getContext(), arrayList, this.style));
        }
    }
}
