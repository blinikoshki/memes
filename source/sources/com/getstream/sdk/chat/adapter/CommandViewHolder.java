package com.getstream.sdk.chat.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.databinding.StreamItemCommandBinding;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.messageinput.MessageInputStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Command;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/CommandViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamItemCommandBinding;", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "onCommandClicked", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/models/Command;", "", "(Lcom/getstream/sdk/chat/databinding/StreamItemCommandBinding;Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;Lkotlin/jvm/functions/Function1;)V", "bind", "command", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CommandsAdapter.kt */
public final class CommandViewHolder extends RecyclerView.ViewHolder {
    private final StreamItemCommandBinding binding;
    /* access modifiers changed from: private */
    public final Function1<Command, Unit> onCommandClicked;
    private final MessageInputStyle style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommandViewHolder(StreamItemCommandBinding streamItemCommandBinding, MessageInputStyle messageInputStyle, Function1<? super Command, Unit> function1) {
        super(streamItemCommandBinding.getRoot());
        Intrinsics.checkNotNullParameter(streamItemCommandBinding, "binding");
        Intrinsics.checkNotNullParameter(messageInputStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "onCommandClicked");
        this.binding = streamItemCommandBinding;
        this.style = messageInputStyle;
        this.onCommandClicked = function1;
    }

    public final void bind(Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        TextView textView = this.binding.tvCommand;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCommand");
        textView.setText(command.getName());
        TextView textView2 = this.binding.tvArg;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvArg");
        textView2.setText(command.getArgs());
        TextView textView3 = this.binding.tvDes;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvDes");
        textView3.setText(command.getDescription());
        TextStyle inputBackgroundText = this.style.getInputBackgroundText();
        TextView textView4 = this.binding.tvCommand;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvCommand");
        inputBackgroundText.apply(textView4);
        TextView textView5 = this.binding.tvDes;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvDes");
        inputBackgroundText.apply(textView5);
        TextView textView6 = this.binding.tvArg;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvArg");
        inputBackgroundText.apply(textView6);
        this.binding.getRoot().setOnClickListener(new CommandViewHolder$bind$2(this, command));
    }
}
