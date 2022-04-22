package com.getstream.sdk.chat.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.getstream.sdk.chat.databinding.StreamItemCommandBinding;
import com.getstream.sdk.chat.view.messageinput.MessageInputStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Command;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/CommandsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lio/getstream/chat/android/client/models/Command;", "Lcom/getstream/sdk/chat/adapter/CommandViewHolder;", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "onCommandSelected", "Lkotlin/Function1;", "", "(Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommandsAdapter.kt */
public final class CommandsAdapter extends ListAdapter<Command, CommandViewHolder> {
    private final Function1<Command, Unit> onCommandSelected;
    private final MessageInputStyle style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommandsAdapter(MessageInputStyle messageInputStyle, Function1<? super Command, Unit> function1) {
        super(new DiffUtil.ItemCallback<Command>() {
            public boolean areItemsTheSame(Command command, Command command2) {
                Intrinsics.checkNotNullParameter(command, "oldItem");
                Intrinsics.checkNotNullParameter(command2, "newItem");
                return Intrinsics.areEqual((Object) command.getName(), (Object) command2.getName());
            }

            public boolean areContentsTheSame(Command command, Command command2) {
                Intrinsics.checkNotNullParameter(command, "oldItem");
                Intrinsics.checkNotNullParameter(command2, "newItem");
                return Intrinsics.areEqual((Object) command, (Object) command2);
            }
        });
        Intrinsics.checkNotNullParameter(messageInputStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "onCommandSelected");
        this.style = messageInputStyle;
        this.onCommandSelected = function1;
    }

    public CommandViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        StreamItemCommandBinding inflate = StreamItemCommandBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamItemCommandBinding….context), parent, false)");
        return new CommandViewHolder(inflate, this.style, this.onCommandSelected);
    }

    public void onBindViewHolder(CommandViewHolder commandViewHolder, int i) {
        Intrinsics.checkNotNullParameter(commandViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        commandViewHolder.bind((Command) item);
    }
}
