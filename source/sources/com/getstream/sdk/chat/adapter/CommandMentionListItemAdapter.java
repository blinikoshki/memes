package com.getstream.sdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.getstream.sdk.chat.databinding.StreamItemMentionBinding;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.List;
import p015io.getstream.chat.android.client.models.User;

public class CommandMentionListItemAdapter extends BaseAdapter {
    private final List<User> items;
    private final LayoutInflater layoutInflater;
    private final MessageListViewStyle style;

    public long getItemId(int i) {
        return (long) i;
    }

    public CommandMentionListItemAdapter(Context context, List<User> list, MessageListViewStyle messageListViewStyle) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = list;
        this.style = messageListViewStyle;
    }

    public int getCount() {
        return this.items.size();
    }

    public Object getItem(int i) {
        return this.items.get(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.getstream.sdk.chat.databinding.StreamItemMentionBinding} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r2, android.view.View r3, android.view.ViewGroup r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0013
            android.view.LayoutInflater r3 = r1.layoutInflater
            int r4 = com.getstream.sdk.chat.C1673R.C1679layout.stream_item_mention
            r0 = 0
            android.view.View r3 = r3.inflate(r4, r0)
            com.getstream.sdk.chat.databinding.StreamItemMentionBinding r4 = com.getstream.sdk.chat.databinding.StreamItemMentionBinding.bind(r3)
            r3.setTag(r4)
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = r3.getTag()
            r4 = r3
            com.getstream.sdk.chat.databinding.StreamItemMentionBinding r4 = (com.getstream.sdk.chat.databinding.StreamItemMentionBinding) r4
        L_0x001a:
            r1.configMentions(r4, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r4.getRoot()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.CommandMentionListItemAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void configMentions(StreamItemMentionBinding streamItemMentionBinding, int i) {
        User user = this.items.get(i);
        streamItemMentionBinding.avatar.setUser(user, this.style.getAvatarStyle());
        streamItemMentionBinding.tvUsername.setText((CharSequence) user.getExtraValue("name", ""));
    }
}
