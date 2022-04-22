package com.getstream.sdk.chat.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.ReactionDialogAdapter;
import com.getstream.sdk.chat.databinding.StreamDialogMessageMoreactionBinding;
import com.getstream.sdk.chat.model.ModelType;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import top.defaults.drawabletoolbox.DrawableBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B¹\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\r\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\r\u0012!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\r\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R)\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/dialog/MessageMoreActionDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "message", "Lio/getstream/chat/android/client/models/Message;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "onMessageEditHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "onMessageDeleteHandler", "onStartThreadHandler", "onMessageFlagHandler", "(Landroid/content/Context;Lio/getstream/chat/android/client/models/Channel;Lio/getstream/chat/android/client/models/Message;Lio/getstream/chat/android/client/models/User;Lcom/getstream/sdk/chat/view/MessageListViewStyle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applyButtonsIconTint", "binding", "Lcom/getstream/sdk/chat/databinding/StreamDialogMessageMoreactionBinding;", "applyButtonsTextStyle", "canCopyOnMessage", "", "canReactOnMessage", "canThreadOnMessage", "isMessageNotCreatedByCurrentUser", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setupMessageActions", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageMoreActionDialog.kt */
public final class MessageMoreActionDialog extends Dialog {
    private final Channel channel;
    private final User currentUser;
    /* access modifiers changed from: private */
    public final Message message;
    /* access modifiers changed from: private */
    public final Function1<Message, Unit> onMessageDeleteHandler;
    /* access modifiers changed from: private */
    public final Function1<Message, Unit> onMessageEditHandler;
    /* access modifiers changed from: private */
    public final Function1<Message, Unit> onMessageFlagHandler;
    /* access modifiers changed from: private */
    public final Function1<Message, Unit> onStartThreadHandler;
    private final MessageListViewStyle style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageMoreActionDialog(Context context, Channel channel2, Message message2, User user, MessageListViewStyle messageListViewStyle, Function1<? super Message, Unit> function1, Function1<? super Message, Unit> function12, Function1<? super Message, Unit> function13, Function1<? super Message, Unit> function14) {
        super(context, C1673R.C1680style.DialogTheme);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(user, "currentUser");
        Intrinsics.checkNotNullParameter(messageListViewStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "onMessageEditHandler");
        Intrinsics.checkNotNullParameter(function12, "onMessageDeleteHandler");
        Intrinsics.checkNotNullParameter(function13, "onStartThreadHandler");
        Intrinsics.checkNotNullParameter(function14, "onMessageFlagHandler");
        this.channel = channel2;
        this.message = message2;
        this.currentUser = user;
        this.style = messageListViewStyle;
        this.onMessageEditHandler = function1;
        this.onMessageDeleteHandler = function12;
        this.onStartThreadHandler = function13;
        this.onMessageFlagHandler = function14;
        Utils.hideSoftKeyboard(context);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(32, 32);
            window.setFlags(262144, 262144);
        }
        setupMessageActions();
    }

    private final void setupMessageActions() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
        StreamDialogMessageMoreactionBinding inflate = StreamDialogMessageMoreactionBinding.inflate(from);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        applyButtonsTextStyle(inflate);
        applyButtonsIconTint(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamDialogMessageMorea…onsIconTint(it)\n        }");
        Drawable messageActionButtonsBackground = this.style.getMessageActionButtonsBackground();
        if (messageActionButtonsBackground != null) {
            LinearLayout linearLayout = inflate.messageActionButtons;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.messageActionButtons");
            linearLayout.setBackground(messageActionButtonsBackground);
        }
        setContentView(inflate.getRoot());
        setCanceledOnTouchOutside(true);
        LinearLayout linearLayout2 = inflate.startThreadButton;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.startThreadButton");
        int i = 0;
        linearLayout2.setVisibility(canThreadOnMessage() ? 0 : 8);
        LinearLayout linearLayout3 = inflate.copyMessageButton;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.copyMessageButton");
        linearLayout3.setVisibility(canCopyOnMessage() ? 0 : 8);
        if (isMessageNotCreatedByCurrentUser()) {
            LinearLayout linearLayout4 = inflate.editMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.editMessageButton");
            linearLayout4.setVisibility(8);
            LinearLayout linearLayout5 = inflate.deleteMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.deleteMessageButton");
            linearLayout5.setVisibility(8);
            inflate.flagMessageButton.setOnClickListener(new MessageMoreActionDialog$setupMessageActions$2(this));
            LinearLayout linearLayout6 = inflate.flagMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.flagMessageButton");
            linearLayout6.setVisibility(this.style.getFlagMessageActionEnabled() ? 0 : 8);
        } else {
            LinearLayout linearLayout7 = inflate.flagMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.flagMessageButton");
            linearLayout7.setVisibility(8);
            inflate.editMessageButton.setOnClickListener(new MessageMoreActionDialog$setupMessageActions$3(this));
            inflate.deleteMessageButton.setOnClickListener(new MessageMoreActionDialog$setupMessageActions$4(this));
            LinearLayout linearLayout8 = inflate.editMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.editMessageButton");
            linearLayout8.setVisibility(this.style.getEditMessageActionEnabled() ? 0 : 8);
            LinearLayout linearLayout9 = inflate.deleteMessageButton;
            Intrinsics.checkNotNullExpressionValue(linearLayout9, "binding.deleteMessageButton");
            linearLayout9.setVisibility(this.style.getDeleteMessageActionEnabled() ? 0 : 8);
        }
        if (canReactOnMessage()) {
            RelativeLayout relativeLayout = inflate.reactionsContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.reactionsContainer");
            DrawableBuilder solidColor = new DrawableBuilder().rectangle().solidColor(this.style.getReactionInputBgColor());
            RelativeLayout relativeLayout2 = inflate.reactionsContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.reactionsContainer");
            RelativeLayout relativeLayout3 = inflate.reactionsContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.reactionsContainer");
            relativeLayout.setBackground(solidColor.cornerRadii(relativeLayout2.getHeight() / 2, relativeLayout3.getHeight() / 2, 0, 0).build());
            RecyclerView recyclerView = inflate.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            ReactionDialogAdapter reactionDialogAdapter = new ReactionDialogAdapter(this.message, this.style, new MessageMoreActionDialog$setupMessageActions$reactionAdapter$1(this));
            RecyclerView recyclerView2 = inflate.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
            recyclerView2.setAdapter(reactionDialogAdapter);
        } else {
            RelativeLayout relativeLayout4 = inflate.reactionsContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.reactionsContainer");
            relativeLayout4.setVisibility(8);
        }
        LinearLayout linearLayout10 = inflate.startThreadButton;
        boolean startThreadMessageActionEnabled = this.style.getStartThreadMessageActionEnabled();
        linearLayout10.setVisibility(startThreadMessageActionEnabled ? 0 : 8);
        if (startThreadMessageActionEnabled) {
            linearLayout10.setOnClickListener(new C1745x538801ac(this));
        }
        LinearLayout linearLayout11 = inflate.copyMessageButton;
        boolean copyMessageActionEnabled = this.style.getCopyMessageActionEnabled();
        View view = linearLayout11;
        if (!copyMessageActionEnabled) {
            i = 8;
        }
        view.setVisibility(i);
        if (copyMessageActionEnabled) {
            linearLayout11.setOnClickListener(new C1746x538801ad(linearLayout11, this));
        }
    }

    private final void applyButtonsTextStyle(StreamDialogMessageMoreactionBinding streamDialogMessageMoreactionBinding) {
        TextStyle messageActionButtonsTextStyle = this.style.getMessageActionButtonsTextStyle();
        TextView textView = streamDialogMessageMoreactionBinding.startThreadButtonTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "startThreadButtonTextView");
        messageActionButtonsTextStyle.apply(textView);
        TextView textView2 = streamDialogMessageMoreactionBinding.copyMessageButtonTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "copyMessageButtonTextView");
        messageActionButtonsTextStyle.apply(textView2);
        TextView textView3 = streamDialogMessageMoreactionBinding.flagMessageButtonTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "flagMessageButtonTextView");
        messageActionButtonsTextStyle.apply(textView3);
        TextView textView4 = streamDialogMessageMoreactionBinding.editMessageButtonTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "editMessageButtonTextView");
        messageActionButtonsTextStyle.apply(textView4);
        TextView textView5 = streamDialogMessageMoreactionBinding.deleteMessageButtonTextView;
        Intrinsics.checkNotNullExpressionValue(textView5, "deleteMessageButtonTextView");
        messageActionButtonsTextStyle.apply(textView5);
    }

    private final void applyButtonsIconTint(StreamDialogMessageMoreactionBinding streamDialogMessageMoreactionBinding) {
        ColorStateList messageActionButtonsIconTint = this.style.getMessageActionButtonsIconTint();
        ImageView imageView = streamDialogMessageMoreactionBinding.startThreadButtonImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "startThreadButtonImageView");
        imageView.setImageTintList(messageActionButtonsIconTint);
        ImageView imageView2 = streamDialogMessageMoreactionBinding.copyMessageButtonImageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "copyMessageButtonImageView");
        imageView2.setImageTintList(messageActionButtonsIconTint);
        ImageView imageView3 = streamDialogMessageMoreactionBinding.flagMessageButtonImageView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "flagMessageButtonImageView");
        imageView3.setImageTintList(messageActionButtonsIconTint);
        ImageView imageView4 = streamDialogMessageMoreactionBinding.editMessageButtonImageView;
        Intrinsics.checkNotNullExpressionValue(imageView4, "editMessageButtonImageView");
        imageView4.setImageTintList(messageActionButtonsIconTint);
        ImageView imageView5 = streamDialogMessageMoreactionBinding.deleteMessageButtonImageView;
        Intrinsics.checkNotNullExpressionValue(imageView5, "deleteMessageButtonImageView");
        imageView5.setImageTintList(messageActionButtonsIconTint);
    }

    private final boolean isMessageNotCreatedByCurrentUser() {
        return !Intrinsics.areEqual((Object) this.message.getUser().getId(), (Object) this.currentUser.getId());
    }

    private final boolean canCopyOnMessage() {
        return this.message.getDeletedAt() == null && !Intrinsics.areEqual((Object) this.message.getType(), (Object) "error") && !Intrinsics.areEqual((Object) this.message.getType(), (Object) ModelType.message_ephemeral) && !TextUtils.isEmpty(this.message.getText());
    }

    private final boolean canThreadOnMessage() {
        return this.style.isThreadEnabled() && this.channel.getConfig().isRepliesEnabled() && this.message.getParentId() == null;
    }

    private final boolean canReactOnMessage() {
        return this.style.isReactionEnabled() && this.channel.getConfig().isReactionsEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        dismiss();
        return true;
    }
}
