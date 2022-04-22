package com.getstream.sdk.chat.view.messageinput;

import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.CaptureMediaContract;
import com.getstream.sdk.chat.SelectFilesContract;
import com.getstream.sdk.chat.adapter.CommandsAdapter;
import com.getstream.sdk.chat.adapter.FileAttachmentSelectedAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentSelectedAdapter;
import com.getstream.sdk.chat.adapter.MentionsAdapter;
import com.getstream.sdk.chat.databinding.StreamViewMessageInputBinding;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.GifEditText;
import com.getstream.sdk.chat.utils.GridSpacingItemDecoration;
import com.getstream.sdk.chat.utils.extensions.ViewKt;
import com.getstream.sdk.chat.view.messageinput.InputMode;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import p015io.getstream.chat.android.client.models.Command;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00105\u001a\u00020\t2\u0006\u00106\u001a\u000204J\b\u00107\u001a\u00020\tH\u0002J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0002J\b\u0010:\u001a\u00020\tH\u0002J\b\u0010;\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020\tH\u0002J\b\u0010=\u001a\u00020\tH\u0002J\u0014\u0010>\u001a\u00020\t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@03J\u0014\u0010A\u001a\u00020\t2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C03J\u001d\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020)H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020\tH\u0002J\r\u0010J\u001a\u00020\tH\u0000¢\u0006\u0002\bKJ\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\u0013H\u0002J\u0010\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u00020\tH\u0014J\b\u0010Q\u001a\u00020\tH\u0014J\b\u0010R\u001a\u00020\tH\u0002J\u000e\u0010S\u001a\u00020\t2\u0006\u00106\u001a\u000204J#\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020)2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W03H\u0000¢\u0006\u0002\bXJ\u0018\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0015H\u0002J\u0015\u0010]\u001a\u00020\t2\u0006\u0010U\u001a\u00020)H\u0000¢\u0006\u0002\b^J%\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020F2\u0006\u0010U\u001a\u00020)2\u0006\u0010a\u001a\u00020\u0013H\u0000¢\u0006\u0002\bbJ3\u0010c\u001a\u00020\t2\u0006\u0010`\u001a\u00020F2\u0006\u0010U\u001a\u00020)2\u0006\u0010a\u001a\u00020\u00132\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W03H\u0000¢\u0006\u0002\bdJ\u000e\u0010e\u001a\u00020\t2\u0006\u0010E\u001a\u00020FJ\u0010\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0013H\u0016J\b\u0010h\u001a\u00020\tH\u0002J\u0006\u0010i\u001a\u00020\tJ\u000e\u0010j\u001a\u00020\t2\u0006\u0010`\u001a\u00020FJ\r\u0010k\u001a\u00020\tH\u0000¢\u0006\u0002\blJ\r\u0010m\u001a\u00020\tH\u0000¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020\u0013H\u0000¢\u0006\u0002\bqJ\r\u0010r\u001a\u00020\tH\u0000¢\u0006\u0002\bsJ\u0015\u0010t\u001a\u00020\t2\u0006\u0010p\u001a\u00020\u0013H\u0000¢\u0006\u0002\buJ\r\u0010v\u001a\u00020\tH\u0000¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020\t2\u0006\u0010p\u001a\u00020\u0013H\u0000¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020\t2\b\b\u0001\u0010{\u001a\u00020\u0015J\u0015\u0010|\u001a\u00020\t2\u0006\u0010p\u001a\u00020\u0013H\u0000¢\u0006\u0002\b}J\u0017\u0010~\u001a\u00020\t2\u0007\u0010\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u001d\u0010\u0001\u001a\u00020\t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@03H\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020\t2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000103H\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)8F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "binding", "Lcom/getstream/sdk/chat/databinding/StreamViewMessageInputBinding;", "commandsAdapter", "Lcom/getstream/sdk/chat/adapter/CommandsAdapter;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "gridSpacingItemDecoration", "Lcom/getstream/sdk/chat/utils/GridSpacingItemDecoration;", "isKeyboardEventListenerInitialized", "", "maxMessageLength", "", "getMaxMessageLength", "()I", "setMaxMessageLength", "(I)V", "mentionsAdapter", "Lcom/getstream/sdk/chat/adapter/MentionsAdapter;", "messageInputController", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;", "getMessageInputController", "()Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;", "messageInputController$delegate", "Lkotlin/Lazy;", "messageSendHandler", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$MessageSendHandler;", "getMessageSendHandler", "()Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$MessageSendHandler;", "setMessageSendHandler", "(Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$MessageSendHandler;)V", "text", "", "messageText", "getMessageText", "()Ljava/lang/String;", "setMessageText", "(Ljava/lang/String;)V", "selectFilesResultLauncher", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "typeListeners", "", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$TypeListener;", "addTypeListener", "typeListener", "applyStyle", "clearFocus", "configAttachmentUI", "configInputEditText", "configInputEditTextError", "configOnClickListener", "configSendButtonEnableState", "configureCommands", "commands", "Lio/getstream/chat/android/client/models/Command;", "configureMembers", "members", "Lio/getstream/chat/android/client/models/Member;", "editMessage", "oldMessage", "Lio/getstream/chat/android/client/models/Message;", "newMessageText", "editMessage$stream_chat_android_release", "handleSentMessage", "hideAttachmentsMenu", "hideAttachmentsMenu$stream_chat_android_release", "initSendMessage", "isMessageTooLong", "keyStroke", "inputMessage", "onAttachedToWindow", "onDetachedFromWindow", "onSendMessage", "removeTypeListener", "sendAttachments", "message", "attachmentFiles", "Ljava/io/File;", "sendAttachments$stream_chat_android_release", "sendGifFromKeyboard", "inputContentInfo", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "flags", "sendTextMessage", "sendTextMessage$stream_chat_android_release", "sendToThread", "parentMessage", "alsoSendToChannel", "sendToThread$stream_chat_android_release", "sendToThreadWithAttachments", "sendToThreadWithAttachments$stream_chat_android_release", "setEditMode", "setEnabled", "enabled", "setKeyboardEventListener", "setNormalMode", "setThreadMode", "showAttachmentsMenu", "showAttachmentsMenu$stream_chat_android_release", "showCameraOptions", "showCameraOptions$stream_chat_android_release", "showCameraPermissions", "shouldBeVisible", "showCameraPermissions$stream_chat_android_release", "showFileAttachments", "showFileAttachments$stream_chat_android_release", "showLoadingTotalAttachments", "showLoadingTotalAttachments$stream_chat_android_release", "showMediaAttachments", "showMediaAttachments$stream_chat_android_release", "showMediaPermissions", "showMediaPermissions$stream_chat_android_release", "showMessage", "messageResId", "showOpenAttachmentsMenuButton", "showOpenAttachmentsMenuButton$stream_chat_android_release", "showSelectedFileAttachments", "selectedFileAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/FileAttachmentSelectedAdapter;", "showSelectedFileAttachments$stream_chat_android_release", "showSelectedMediaAttachments", "selectedMediaAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter;", "showSelectedMediaAttachments$stream_chat_android_release", "showSuggestedCommand", "showSuggestedCommand$stream_chat_android_release", "showSuggestedMentions", "users", "Lio/getstream/chat/android/client/models/User;", "showSuggestedMentions$stream_chat_android_release", "showTotalMediaAttachments", "totalMediaAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter;", "showTotalMediaAttachments$stream_chat_android_release", "LauncherRequestsKeys", "MessageSendHandler", "TypeListener", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
public final class MessageInputView extends RelativeLayout {
    private ActivityResultLauncher<Unit> activityResultLauncher;
    /* access modifiers changed from: private */
    public final StreamViewMessageInputBinding binding;
    private final CommandsAdapter commandsAdapter;
    private final GridLayoutManager gridLayoutManager;
    private final GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(4, 2, false);
    /* access modifiers changed from: private */
    public boolean isKeyboardEventListenerInitialized;
    private int maxMessageLength = Integer.MAX_VALUE;
    private final MentionsAdapter mentionsAdapter;
    private final Lazy messageInputController$delegate;
    private MessageSendHandler messageSendHandler = new MessageInputView$messageSendHandler$1();
    /* access modifiers changed from: private */
    public ActivityResultLauncher<Unit> selectFilesResultLauncher;
    /* access modifiers changed from: private */
    public final MessageInputStyle style;
    /* access modifiers changed from: private */
    public List<? extends TypeListener> typeListeners;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J.\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¨\u0006\u0014"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$MessageSendHandler;", "", "editMessage", "", "oldMessage", "Lio/getstream/chat/android/client/models/Message;", "newMessageText", "", "sendMessage", "messageText", "sendMessageWithAttachments", "message", "attachmentsFiles", "", "Ljava/io/File;", "sendToThread", "parentMessage", "alsoSendToChannel", "", "sendToThreadWithAttachments", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputView.kt */
    public interface MessageSendHandler {
        void editMessage(Message message, String str);

        void sendMessage(String str);

        void sendMessageWithAttachments(String str, List<? extends File> list);

        void sendToThread(Message message, String str, boolean z);

        void sendToThreadWithAttachments(Message message, String str, boolean z, List<? extends File> list);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$TypeListener;", "", "onKeystroke", "", "onStopTyping", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputView.kt */
    public interface TypeListener {
        void onKeystroke();

        void onStopTyping();
    }

    /* access modifiers changed from: private */
    public final MessageInputController getMessageInputController() {
        return (MessageInputController) this.messageInputController$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        StreamViewMessageInputBinding inflate = StreamViewMessageInputBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamViewMessageInputBi…rom(context), this, true)");
        this.binding = inflate;
        MessageInputStyle messageInputStyle = new MessageInputStyle(context, attributeSet);
        this.style = messageInputStyle;
        this.gridLayoutManager = new GridLayoutManager(context, 4, 1, false);
        CommandsAdapter commandsAdapter2 = new CommandsAdapter(messageInputStyle, new MessageInputView$commandsAdapter$1(this));
        this.commandsAdapter = commandsAdapter2;
        MentionsAdapter mentionsAdapter2 = new MentionsAdapter(messageInputStyle, new MessageInputView$mentionsAdapter$1(this));
        this.mentionsAdapter = mentionsAdapter2;
        this.typeListeners = CollectionsKt.emptyList();
        this.messageInputController$delegate = LazyKt.lazy(new MessageInputView$messageInputController$2(this));
        applyStyle();
        RecyclerView recyclerView = inflate.rvSuggestions;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvSuggestions");
        recyclerView.setAdapter(new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{commandsAdapter2, mentionsAdapter2}));
        ImageView imageView = inflate.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendButton");
        imageView.setVisibility(8);
        configOnClickListener();
        configInputEditText();
        configAttachmentUI();
    }

    public final String getMessageText() {
        GifEditText gifEditText = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
        return gifEditText.getText().toString();
    }

    public final void setMessageText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            this.binding.messageTextInput.requestFocus();
            this.binding.messageTextInput.setText(charSequence);
            GifEditText gifEditText = this.binding.messageTextInput;
            GifEditText gifEditText2 = this.binding.messageTextInput;
            Intrinsics.checkNotNullExpressionValue(gifEditText2, "binding.messageTextInput");
            gifEditText.setSelection(gifEditText2.getText().length());
        }
    }

    public final int getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public final void setMaxMessageLength(int i) {
        this.maxMessageLength = i;
    }

    public final MessageSendHandler getMessageSendHandler() {
        return this.messageSendHandler;
    }

    public final void setMessageSendHandler(MessageSendHandler messageSendHandler2) {
        Intrinsics.checkNotNullParameter(messageSendHandler2, "<set-?>");
        this.messageSendHandler = messageSendHandler2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$LauncherRequestsKeys;", "", "()V", "CAPTURE_MEDIA", "", "SELECT_FILES", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputView.kt */
    private static final class LauncherRequestsKeys {
        public static final String CAPTURE_MEDIA = "capture_media_request_key";
        public static final LauncherRequestsKeys INSTANCE = new LauncherRequestsKeys();
        public static final String SELECT_FILES = "select_files_request_key";

        private LauncherRequestsKeys() {
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppCompatActivity activity = ViewKt.getActivity(this);
        ActivityResultLauncher<Unit> activityResultLauncher2 = null;
        ActivityResultRegistry activityResultRegistry = activity != null ? activity.getActivityResultRegistry() : null;
        this.activityResultLauncher = activityResultRegistry != null ? activityResultRegistry.register(LauncherRequestsKeys.CAPTURE_MEDIA, new CaptureMediaContract(), new MessageInputView$onAttachedToWindow$1(this)) : null;
        if (activityResultRegistry != null) {
            activityResultLauncher2 = activityResultRegistry.register(LauncherRequestsKeys.SELECT_FILES, new SelectFilesContract(), new MessageInputView$onAttachedToWindow$2(this));
        }
        this.selectFilesResultLauncher = activityResultLauncher2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityResultLauncher<Unit> activityResultLauncher2 = this.activityResultLauncher;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.unregister();
        }
        ActivityResultLauncher<Unit> activityResultLauncher3 = this.selectFilesResultLauncher;
        if (activityResultLauncher3 != null) {
            activityResultLauncher3.unregister();
        }
    }

    public final void addTypeListener(TypeListener typeListener) {
        Intrinsics.checkNotNullParameter(typeListener, "typeListener");
        this.typeListeners = CollectionsKt.plus(this.typeListeners, typeListener);
    }

    public final void removeTypeListener(TypeListener typeListener) {
        Intrinsics.checkNotNullParameter(typeListener, "typeListener");
        this.typeListeners = CollectionsKt.minus(this.typeListeners, typeListener);
    }

    private final void applyStyle() {
        new ActivityResultContracts.GetContent();
        ImageView imageView = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivOpenAttach");
        imageView.setVisibility(this.style.isShowAttachmentButton() ? 0 : 8);
        this.binding.ivOpenAttach.setImageDrawable(this.style.getAttachmentButtonIcon(false));
        ImageView imageView2 = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivOpenAttach");
        imageView2.getLayoutParams().width = this.style.getAttachmentButtonWidth();
        ImageView imageView3 = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivOpenAttach");
        imageView3.getLayoutParams().height = this.style.getAttachmentButtonHeight();
        Button button = this.binding.btnClose;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnClose");
        button.setBackground(this.style.getAttachmentCloseButtonBackground());
        this.binding.sendButton.setImageDrawable(this.style.getInputButtonIcon(false));
        ImageView imageView4 = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.sendButton");
        imageView4.getLayoutParams().width = this.style.getInputButtonWidth();
        ImageView imageView5 = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.sendButton");
        imageView5.getLayoutParams().height = this.style.getInputButtonHeight();
        this.binding.cbSendAlsoToChannel.setTextColor(this.style.getInputSendAlsoToChannelTextColor());
        LinearLayout linearLayout = this.binding.llComposer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llComposer");
        linearLayout.setBackground(this.style.getInputBackground());
        TextStyle inputText = this.style.getInputText();
        GifEditText gifEditText = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
        inputText.apply(gifEditText);
        GifEditText gifEditText2 = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText2, "binding.messageTextInput");
        gifEditText2.setHint(this.style.getInputHint());
        GifEditText gifEditText3 = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText3, "binding.messageTextInput");
        gifEditText3.setVerticalScrollBarEnabled(this.style.getInputScrollbarEnabled());
        GifEditText gifEditText4 = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText4, "binding.messageTextInput");
        gifEditText4.setScrollbarFadingEnabled(this.style.getInputScrollbarFadingEnabled());
        TextStyle inputBackgroundText = this.style.getInputBackgroundText();
        TextView textView = this.binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTitle");
        inputBackgroundText.apply(textView);
        TextStyle inputBackgroundText2 = this.style.getInputBackgroundText();
        TextView textView2 = this.binding.tvCommand;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvCommand");
        inputBackgroundText2.apply(textView2);
        TextStyle inputBackgroundText3 = this.style.getInputBackgroundText();
        TextView textView3 = this.binding.tvUploadPhotoVideo;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvUploadPhotoVideo");
        inputBackgroundText3.apply(textView3);
        TextStyle inputBackgroundText4 = this.style.getInputBackgroundText();
        TextView textView4 = this.binding.tvUploadFile;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvUploadFile");
        inputBackgroundText4.apply(textView4);
        TextStyle inputBackgroundText5 = this.style.getInputBackgroundText();
        TextView textView5 = this.binding.tvUploadCamera;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvUploadCamera");
        inputBackgroundText5.apply(textView5);
        RecyclerView recyclerView = this.binding.rvMedia;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvMedia");
        recyclerView.setLayoutManager(this.gridLayoutManager);
        this.binding.rvMedia.addItemDecoration(this.gridSpacingItemDecoration);
        RecyclerView recyclerView2 = this.binding.rvSuggestions;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvSuggestions");
        recyclerView2.setBackground(this.style.getSuggestionsBackground());
    }

    private final void configOnClickListener() {
        this.binding.sendButton.setOnClickListener(new MessageInputView$configOnClickListener$1(this));
        this.binding.ivOpenAttach.setOnClickListener(new MessageInputView$configOnClickListener$2(this));
    }

    private final void configInputEditText() {
        GifEditText gifEditText = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
        gifEditText.setOnFocusChangeListener(new MessageInputView$configInputEditText$1(this));
        GifEditText gifEditText2 = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText2, "binding.messageTextInput");
        gifEditText2.addTextChangedListener(new C1750x90eda93f(this));
        this.binding.messageTextInput.setCallback(new MessageInputView$configInputEditText$3(this));
    }

    /* access modifiers changed from: private */
    public final void keyStroke(String str) {
        getMessageInputController().checkCommandsOrMentions$stream_chat_android_release(getMessageText());
        ImageView imageView = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendButton");
        View view = imageView;
        boolean z = !StringsKt.isBlank(str);
        if (z) {
            for (TypeListener onKeystroke : this.typeListeners) {
                onKeystroke.onKeystroke();
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!z) {
            for (TypeListener onStopTyping : this.typeListeners) {
                onStopTyping.onStopTyping();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        view.setVisibility(z ? 0 : 8);
        configSendButtonEnableState();
        configInputEditTextError();
    }

    private final void configInputEditTextError() {
        if (isMessageTooLong()) {
            GifEditText gifEditText = this.binding.messageTextInput;
            Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(C1673R.string.stream_message_length_exceeded_error);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ge_length_exceeded_error)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.maxMessageLength)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            gifEditText.setError(format);
            return;
        }
        GifEditText gifEditText2 = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText2, "binding.messageTextInput");
        gifEditText2.setError((CharSequence) null);
    }

    private final void configSendButtonEnableState() {
        Set<AttachmentMetaData> selectedAttachments = getMessageInputController().getSelectedAttachments();
        CharSequence messageText = getMessageText();
        int i = 0;
        boolean z = true;
        boolean z2 = !(messageText == null || StringsKt.isBlank(messageText)) || (selectedAttachments.isEmpty() ^ true);
        ImageView imageView = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendButton");
        View view = imageView;
        if (!z2 || isMessageTooLong()) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final boolean isMessageTooLong() {
        return getMessageText().length() > this.maxMessageLength;
    }

    private final void configAttachmentUI() {
        RecyclerView recyclerView = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mediaComposer");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
        this.binding.btnClose.setOnClickListener(new MessageInputView$configAttachmentUI$1(this));
        this.binding.selectMedia.setOnClickListener(new MessageInputView$configAttachmentUI$2(this));
        this.binding.selectCamera.setOnClickListener(new MessageInputView$configAttachmentUI$3(this));
        this.binding.selectFile.setOnClickListener(new MessageInputView$configAttachmentUI$4(this));
    }

    public final void showCameraOptions$stream_chat_android_release() {
        ActivityResultLauncher<Unit> activityResultLauncher2 = this.activityResultLauncher;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.launch(Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void setKeyboardEventListener() {
        KeyboardVisibilityEvent.setEventListener(ViewKt.getActivity(this), new MessageInputView$setKeyboardEventListener$1(this));
    }

    public void setEnabled(boolean z) {
        GifEditText gifEditText = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
        gifEditText.setEnabled(true);
    }

    public void clearFocus() {
        this.binding.messageTextInput.clearFocus();
    }

    public final void configureMembers(List<Member> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        getMessageInputController().setMembers$stream_chat_android_release(list);
    }

    public final void configureCommands(List<Command> list) {
        Intrinsics.checkNotNullParameter(list, "commands");
        getMessageInputController().setChannelCommands$stream_chat_android_release(list);
    }

    /* access modifiers changed from: private */
    public final void onSendMessage() {
        getMessageInputController().onSendMessageClick$stream_chat_android_release(getMessageText());
        handleSentMessage();
    }

    public final void sendTextMessage$stream_chat_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.messageSendHandler.sendMessage(str);
    }

    public final void sendAttachments$stream_chat_android_release(String str, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(list, "attachmentFiles");
        this.messageSendHandler.sendMessageWithAttachments(str, list);
    }

    public final void sendToThread$stream_chat_android_release(Message message, String str, boolean z) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.messageSendHandler.sendToThread(message, str, z);
    }

    public final void sendToThreadWithAttachments$stream_chat_android_release(Message message, String str, boolean z, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(list, "attachmentFiles");
        this.messageSendHandler.sendToThreadWithAttachments(message, str, z, list);
    }

    public final void editMessage$stream_chat_android_release(Message message, String str) {
        Intrinsics.checkNotNullParameter(message, "oldMessage");
        Intrinsics.checkNotNullParameter(str, "newMessageText");
        this.messageSendHandler.editMessage(message, str);
    }

    private final void handleSentMessage() {
        for (TypeListener onStopTyping : this.typeListeners) {
            onStopTyping.onStopTyping();
        }
        initSendMessage();
    }

    private final void initSendMessage() {
        getMessageInputController().initSendMessage$stream_chat_android_release();
        this.binding.messageTextInput.setText("");
        ImageView imageView = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendButton");
        imageView.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public final boolean sendGifFromKeyboard(InputContentInfoCompat inputContentInfoCompat, int i) {
        if (Build.VERSION.SDK_INT >= 29 && (i & 1) != 0) {
            try {
                inputContentInfoCompat.requestPermission();
            } catch (Exception unused) {
                return false;
            }
        }
        MessageInputController messageInputController = getMessageInputController();
        Uri contentUri = inputContentInfoCompat.getContentUri();
        ClipDescription description = inputContentInfoCompat.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "inputContentInfo.description");
        messageInputController.setSelectedAttachments(SetsKt.setOf(new AttachmentMetaData(contentUri, "image", "image/gif", description.getLabel().toString(), (File) null, 16, (DefaultConstructorMarker) null)));
        this.binding.messageTextInput.setText("");
        onSendMessage();
        return true;
    }

    public final void showSuggestedMentions$stream_chat_android_release(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        this.mentionsAdapter.submitList(list);
    }

    public final void showSuggestedCommand$stream_chat_android_release(List<Command> list) {
        Intrinsics.checkNotNullParameter(list, "commands");
        this.commandsAdapter.submitList(list);
    }

    public final void setNormalMode() {
        getMessageInputController().setInputMode$stream_chat_android_release(InputMode.Normal.INSTANCE);
    }

    public final void setThreadMode(Message message) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        getMessageInputController().setInputMode$stream_chat_android_release(new InputMode.Thread(message));
    }

    public final void setEditMode(Message message) {
        Intrinsics.checkNotNullParameter(message, "oldMessage");
        getMessageInputController().setInputMode$stream_chat_android_release(new InputMode.Edit(message));
    }

    public final void showSelectedMediaAttachments$stream_chat_android_release(MediaAttachmentSelectedAdapter mediaAttachmentSelectedAdapter) {
        Intrinsics.checkNotNullParameter(mediaAttachmentSelectedAdapter, "selectedMediaAttachmentAdapter");
        RecyclerView recyclerView = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mediaComposer");
        recyclerView.setAdapter(mediaAttachmentSelectedAdapter);
        RecyclerView recyclerView2 = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.mediaComposer");
        recyclerView2.setVisibility(0);
        ListView listView = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView, "binding.fileComposer");
        listView.setVisibility(8);
        ListView listView2 = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView2, "binding.fileComposer");
        listView2.setAdapter((ListAdapter) null);
    }

    public final void showSelectedFileAttachments$stream_chat_android_release(FileAttachmentSelectedAdapter fileAttachmentSelectedAdapter) {
        Intrinsics.checkNotNullParameter(fileAttachmentSelectedAdapter, "selectedFileAttachmentAdapter");
        ListView listView = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView, "binding.fileComposer");
        listView.setAdapter(fileAttachmentSelectedAdapter);
        ListView listView2 = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView2, "binding.fileComposer");
        listView2.setVisibility(0);
        RecyclerView recyclerView = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mediaComposer");
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.mediaComposer");
        recyclerView2.setAdapter((RecyclerView.Adapter) null);
    }

    public final void showTotalMediaAttachments$stream_chat_android_release(MediaAttachmentAdapter mediaAttachmentAdapter) {
        Intrinsics.checkNotNullParameter(mediaAttachmentAdapter, "totalMediaAttachmentAdapter");
        RecyclerView recyclerView = this.binding.rvMedia;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvMedia");
        recyclerView.setAdapter(mediaAttachmentAdapter);
    }

    public final void showMediaAttachments$stream_chat_android_release() {
        RecyclerView recyclerView = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mediaComposer");
        recyclerView.setVisibility(0);
        ListView listView = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView, "binding.fileComposer");
        listView.setVisibility(8);
    }

    public final void showFileAttachments$stream_chat_android_release() {
        RecyclerView recyclerView = this.binding.mediaComposer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mediaComposer");
        recyclerView.setVisibility(8);
        ListView listView = this.binding.fileComposer;
        Intrinsics.checkNotNullExpressionValue(listView, "binding.fileComposer");
        listView.setVisibility(0);
    }

    public final void showMediaPermissions$stream_chat_android_release(boolean z) {
        ImageView imageView = this.binding.ivMediaPermission;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivMediaPermission");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void showCameraPermissions$stream_chat_android_release(boolean z) {
        ImageView imageView = this.binding.ivCameraPermission;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCameraPermission");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void hideAttachmentsMenu$stream_chat_android_release() {
        ConstraintLayout constraintLayout = this.binding.clTitle;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clTitle");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.binding.clAddFile;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clAddFile");
        constraintLayout2.setVisibility(8);
        ConstraintLayout constraintLayout3 = this.binding.clSelectPhoto;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clSelectPhoto");
        constraintLayout3.setVisibility(8);
        this.binding.getRoot().setBackgroundResource(0);
    }

    public final void showAttachmentsMenu$stream_chat_android_release() {
        ConstraintLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.style.getAttachmentsMenuBackground());
        ConstraintLayout constraintLayout = this.binding.clTitle;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clTitle");
        constraintLayout.setVisibility(0);
        Button button = this.binding.btnClose;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnClose");
        button.setVisibility(0);
        ConstraintLayout constraintLayout2 = this.binding.clAddFile;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clAddFile");
        constraintLayout2.setVisibility(8);
        ConstraintLayout constraintLayout3 = this.binding.clSelectPhoto;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clSelectPhoto");
        constraintLayout3.setVisibility(8);
    }

    public final void showLoadingTotalAttachments$stream_chat_android_release(boolean z) {
        ProgressBar progressBar = this.binding.progressBarFileLoader;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBarFileLoader");
        progressBar.setVisibility(z ? 0 : 8);
    }

    public final void showOpenAttachmentsMenuButton$stream_chat_android_release(boolean z) {
        ImageView imageView = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivOpenAttach");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void showMessage(int i) {
        Toast.makeText(getContext(), i, 0).show();
    }
}
