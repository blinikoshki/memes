package com.getstream.sdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.UiUtils;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.Iterator;
import java.util.Map;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.livedata.ChatDomain;

public class ReactionDialogAdapter extends RecyclerView.Adapter<ReactionViewHolder> {
    private static final String TAG = "ReactionDialogAdapter";
    /* access modifiers changed from: private */
    public String cid = "";
    /* access modifiers changed from: private */
    public View.OnClickListener clickListener;
    /* access modifiers changed from: private */
    public Message message;
    /* access modifiers changed from: private */
    public Map<String, String> reactionTypes;
    private MessageListViewStyle style;

    public ReactionDialogAdapter(Message message2, MessageListViewStyle messageListViewStyle, View.OnClickListener onClickListener) {
        this.message = message2;
        this.reactionTypes = UiUtils.getReactionTypes();
        this.style = messageListViewStyle;
        this.clickListener = onClickListener;
        if (!message2.getCid().equals("")) {
            this.cid = message2.getCid();
        }
    }

    public ReactionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ReactionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1673R.C1679layout.stream_item_dialog_reaction, viewGroup, false));
    }

    public void onBindViewHolder(ReactionViewHolder reactionViewHolder, int i) {
        applyStyle(reactionViewHolder);
        reactionViewHolder.bind((String) this.reactionTypes.keySet().toArray()[i], i);
    }

    private void applyStyle(ReactionViewHolder reactionViewHolder) {
        reactionViewHolder.tv_emoji.setTextSize(0, (float) this.style.getReactionInputEmojiSize());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) reactionViewHolder.tv_emoji.getLayoutParams();
        layoutParams.leftMargin = this.style.getReactionInputEmojiMargin();
        layoutParams.rightMargin = this.style.getReactionInputEmojiMargin();
        layoutParams.topMargin = this.style.getReactionInputEmojiMargin();
        layoutParams.bottomMargin = this.style.getReactionInputEmojiMargin();
        reactionViewHolder.tv_emoji.setLayoutParams(layoutParams);
    }

    public int getItemCount() {
        return this.reactionTypes.size();
    }

    public class ReactionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private int position;
        private String reactionKey;
        private TextView tv_count;
        /* access modifiers changed from: private */
        public TextView tv_emoji;

        private ReactionViewHolder(View view) {
            super(view);
            this.tv_emoji = (TextView) view.findViewById(C1673R.C1677id.tv_emoji);
            this.tv_count = (TextView) view.findViewById(C1673R.C1677id.tv_count);
            view.setOnClickListener(this);
        }

        /* access modifiers changed from: package-private */
        public void bind(String str, int i) {
            this.reactionKey = str;
            this.position = i;
            this.tv_emoji.setText((String) ReactionDialogAdapter.this.reactionTypes.get(str));
            Map<String, Integer> reactionCounts = ReactionDialogAdapter.this.message.getReactionCounts();
            if (reactionCounts == null || !reactionCounts.containsKey(str)) {
                this.tv_count.setText("");
            } else {
                this.tv_count.setText(String.valueOf(reactionCounts.get(str)));
            }
        }

        public void onClick(View view) {
            boolean z;
            String str = (String) ReactionDialogAdapter.this.reactionTypes.keySet().toArray()[getLayoutPosition()];
            Iterator<Reaction> it = ReactionDialogAdapter.this.message.getOwnReactions().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals(it.next().getType())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                deleteReaction(view, str);
            } else {
                sendReaction(view, str);
            }
        }

        private void sendReaction(View view, String str) {
            ReactionDialogAdapter.this.clickListener.onClick(view);
            Reaction reaction = new Reaction();
            reaction.setMessageId(ReactionDialogAdapter.this.message.getId());
            reaction.setType(str);
            if (!ReactionDialogAdapter.this.cid.equals("")) {
                ChatDomain.CC.instance().getUseCases().getSendReaction().invoke(ReactionDialogAdapter.this.cid, reaction, false).enqueue(C1682xe3334699.INSTANCE);
            }
        }

        private void deleteReaction(View view, String str) {
            ReactionDialogAdapter.this.clickListener.onClick(view);
            Reaction reaction = new Reaction();
            reaction.setMessageId(ReactionDialogAdapter.this.message.getId());
            reaction.setType(str);
            if (!ReactionDialogAdapter.this.cid.equals("")) {
                ChatDomain.CC.instance().getUseCases().getDeleteReaction().invoke(ReactionDialogAdapter.this.cid, reaction).enqueue(C1683xa20ccb93.INSTANCE);
            }
        }
    }
}
