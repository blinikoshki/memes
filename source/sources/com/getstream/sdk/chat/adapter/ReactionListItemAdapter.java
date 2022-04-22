package com.getstream.sdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015io.getstream.chat.android.client.logger.ChatLogger;

public class ReactionListItemAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final String TAG = ReactionListItemAdapter.class.getSimpleName();
    private Context context;
    private int reactionCount;
    private Map<String, String> reactionTypes;
    private List<String> reactions = new ArrayList();
    private MessageListViewStyle style;

    public ReactionListItemAdapter(Context context2, Map<String, Integer> map, Map<String, String> map2, MessageListViewStyle messageListViewStyle) {
        this.context = context2;
        this.reactionTypes = map2;
        this.style = messageListViewStyle;
        Set<String> keySet = map.keySet();
        this.reactionCount = 0;
        for (String next : keySet) {
            this.reactions.add(next.toString());
            this.reactionCount += map.get(next).intValue();
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1673R.C1679layout.stream_item_reaction, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        String str;
        if (i == this.reactions.size()) {
            str = String.valueOf(this.reactionCount);
        } else {
            try {
                str = this.reactionTypes.get(this.reactions.get(i));
            } catch (Exception e) {
                ChatLogger.Companion.getInstance().logE((Object) "ReactionListItemAdapter", (Throwable) e);
                str = "";
            }
        }
        myViewHolder.tv_emoji.setText(str);
        myViewHolder.tv_emoji.setTextSize(0, (float) this.style.getReactionViewEmojiSize());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) myViewHolder.tv_emoji.getLayoutParams();
        layoutParams.leftMargin = this.style.getReactionViewEmojiMargin();
        layoutParams.rightMargin = this.style.getReactionViewEmojiMargin();
        layoutParams.topMargin = this.style.getReactionViewEmojiMargin();
        layoutParams.bottomMargin = this.style.getReactionViewEmojiMargin();
        myViewHolder.tv_emoji.setLayoutParams(layoutParams);
    }

    public int getItemCount() {
        return this.reactions.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_emoji;

        public MyViewHolder(View view) {
            super(view);
            this.tv_emoji = (TextView) view.findViewById(C1673R.C1677id.tv_emoji);
        }
    }
}
