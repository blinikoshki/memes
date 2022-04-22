package com.getstream.sdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.getstream.sdk.chat.databinding.StreamItemMentionBinding;
import com.getstream.sdk.chat.view.messageinput.MessageInputStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/MentionsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lio/getstream/chat/android/client/models/User;", "Lcom/getstream/sdk/chat/adapter/MentionViewHolder;", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "onMentionSelected", "Lkotlin/Function1;", "", "(Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MentionsAdapter.kt */
public final class MentionsAdapter extends ListAdapter<User, MentionViewHolder> {
    private final Function1<User, Unit> onMentionSelected;
    private final MessageInputStyle style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MentionsAdapter(MessageInputStyle messageInputStyle, Function1<? super User, Unit> function1) {
        super(new DiffUtil.ItemCallback<User>() {
            public boolean areItemsTheSame(User user, User user2) {
                Intrinsics.checkNotNullParameter(user, "oldItem");
                Intrinsics.checkNotNullParameter(user2, "newItem");
                return Intrinsics.areEqual((Object) user.getId(), (Object) user2.getId());
            }

            public boolean areContentsTheSame(User user, User user2) {
                Intrinsics.checkNotNullParameter(user, "oldItem");
                Intrinsics.checkNotNullParameter(user2, "newItem");
                return Intrinsics.areEqual((Object) user, (Object) user2);
            }
        });
        Intrinsics.checkNotNullParameter(messageInputStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "onMentionSelected");
        this.style = messageInputStyle;
        this.onMentionSelected = function1;
    }

    public MentionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        StreamItemMentionBinding inflate = StreamItemMentionBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamItemMentionBinding….context), parent, false)");
        return new MentionViewHolder(inflate, this.style, this.onMentionSelected);
    }

    public void onBindViewHolder(MentionViewHolder mentionViewHolder, int i) {
        Intrinsics.checkNotNullParameter(mentionViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        mentionViewHolder.bind((User) item);
    }
}
