package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.adapter.FileAttachmentSelectedAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentSelectedAdapter;
import com.getstream.sdk.chat.databinding.StreamViewMessageInputBinding;
import com.getstream.sdk.chat.enums.MessageInputType;
import com.getstream.sdk.chat.enums.MessageInputTypeKt;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.GifEditText;
import com.getstream.sdk.chat.utils.PermissionChecker;
import com.getstream.sdk.chat.utils.StorageHelper;
import com.getstream.sdk.chat.view.PreviewMessageView;
import com.getstream.sdk.chat.view.messageinput.InputMode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Command;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020&H\u0002J\r\u0010+\u001a\u00020&H\u0000¢\u0006\u0002\b,J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\u0018\u00102\u001a\u00020&2\u0006\u0010.\u001a\u00020/2\u0006\u00103\u001a\u00020(H\u0002J\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\r\u00107\u001a\u00020&H\u0000¢\u0006\u0002\b8J\u0006\u00109\u001a\u00020&J\r\u0010:\u001a\u00020&H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\"H\u0000¢\u0006\u0002\b>J\u0006\u0010?\u001a\u00020&J\u0015\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020\u000fH\u0000¢\u0006\u0002\bBJ\u001d\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bHJ\u001b\u0010I\u001a\u00020&2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000eH\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020&2\u0006\u0010.\u001a\u00020(H\u0000¢\u0006\u0002\bNJ\u001d\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020RH\u0000¢\u0006\u0002\bSJ\u0010\u0010T\u001a\u00020&2\u0006\u0010.\u001a\u00020(H\u0002J\u0018\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020/2\u0006\u0010.\u001a\u00020(H\u0002J\u0014\u0010W\u001a\u00020&2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020605R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158@@@X\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;", "", "binding", "Lcom/getstream/sdk/chat/databinding/StreamViewMessageInputBinding;", "view", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;", "style", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "(Lcom/getstream/sdk/chat/databinding/StreamViewMessageInputBinding;Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;)V", "attachmentsController", "Lcom/getstream/sdk/chat/view/messageinput/AttachmentsController;", "getAttachmentsController$stream_chat_android_release", "()Lcom/getstream/sdk/chat/view/messageinput/AttachmentsController;", "channelCommands", "", "Lio/getstream/chat/android/client/models/Command;", "getChannelCommands$stream_chat_android_release", "()Ljava/util/List;", "setChannelCommands$stream_chat_android_release", "(Ljava/util/List;)V", "<set-?>", "Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "inputMode", "getInputMode$stream_chat_android_release", "()Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "setInputMode$stream_chat_android_release", "(Lcom/getstream/sdk/chat/view/messageinput/InputMode;)V", "inputMode$delegate", "Lkotlin/properties/ReadWriteProperty;", "members", "Lio/getstream/chat/android/client/models/Member;", "getMembers$stream_chat_android_release", "setMembers$stream_chat_android_release", "messageInputType", "Lcom/getstream/sdk/chat/enums/MessageInputType;", "storageHelper", "Lcom/getstream/sdk/chat/utils/StorageHelper;", "checkCommandsOrMentions", "", "inputMessage", "", "checkCommandsOrMentions$stream_chat_android_release", "cleanSuggestion", "configSendButtonEnableState", "configSendButtonEnableState$stream_chat_android_release", "configureEditInputMode", "message", "Lio/getstream/chat/android/client/models/Message;", "configureNormalInputMode", "configureThreadInputMode", "editMessage", "messageText", "getSelectedAttachments", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "initSendMessage", "initSendMessage$stream_chat_android_release", "onCameraClick", "onClickCloseAttachmentSelectionMenu", "onClickCloseAttachmentSelectionMenu$stream_chat_android_release", "onClickOpenAttachmentSelectionMenu", "type", "onClickOpenAttachmentSelectionMenu$stream_chat_android_release", "onClickOpenMediaSelectView", "onCommandSelected", "command", "onCommandSelected$stream_chat_android_release", "onFileCaptured", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "onFileCaptured$stream_chat_android_release", "onFilesSelected", "uriList", "Landroid/net/Uri;", "onFilesSelected$stream_chat_android_release", "onSendMessageClick", "onSendMessageClick$stream_chat_android_release", "onUserSelected", "currentMessage", "user", "Lio/getstream/chat/android/client/models/User;", "onUserSelected$stream_chat_android_release", "sendNormalMessage", "sendToThread", "parentMessage", "setSelectedAttachments", "attachments", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputController.kt */
public final class MessageInputController {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MessageInputController.class, "inputMode", "getInputMode$stream_chat_android_release()Lcom/getstream/sdk/chat/view/messageinput/InputMode;", 0))};
    private final AttachmentsController attachmentsController;
    /* access modifiers changed from: private */
    public final StreamViewMessageInputBinding binding;
    private List<Command> channelCommands = CollectionsKt.emptyList();
    private final ReadWriteProperty inputMode$delegate;
    private List<Member> members = CollectionsKt.emptyList();
    private MessageInputType messageInputType;
    private final StorageHelper storageHelper;
    private final MessageInputStyle style;
    private final MessageInputView view;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageInputType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageInputType.EDIT_MESSAGE.ordinal()] = 1;
            iArr[MessageInputType.ADD_FILE.ordinal()] = 2;
            iArr[MessageInputType.UPLOAD_MEDIA.ordinal()] = 3;
            iArr[MessageInputType.UPLOAD_FILE.ordinal()] = 4;
            iArr[MessageInputType.COMMAND.ordinal()] = 5;
            iArr[MessageInputType.MENTION.ordinal()] = 6;
        }
    }

    public final InputMode getInputMode$stream_chat_android_release() {
        return (InputMode) this.inputMode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setInputMode$stream_chat_android_release(InputMode inputMode) {
        Intrinsics.checkNotNullParameter(inputMode, "<set-?>");
        this.inputMode$delegate.setValue(this, $$delegatedProperties[0], inputMode);
    }

    public MessageInputController(StreamViewMessageInputBinding streamViewMessageInputBinding, MessageInputView messageInputView, MessageInputStyle messageInputStyle) {
        StreamViewMessageInputBinding streamViewMessageInputBinding2 = streamViewMessageInputBinding;
        MessageInputView messageInputView2 = messageInputView;
        MessageInputStyle messageInputStyle2 = messageInputStyle;
        Intrinsics.checkNotNullParameter(streamViewMessageInputBinding2, "binding");
        Intrinsics.checkNotNullParameter(messageInputView2, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(messageInputStyle2, "style");
        this.binding = streamViewMessageInputBinding2;
        this.view = messageInputView2;
        this.style = messageInputStyle2;
        StorageHelper storageHelper2 = new StorageHelper();
        this.storageHelper = storageHelper2;
        this.attachmentsController = new AttachmentsController(this, new PermissionChecker(), storageHelper2, messageInputView2, new MediaAttachmentAdapter((List) null, (Function1) null, 3, (DefaultConstructorMarker) null), new MediaAttachmentSelectedAdapter((List) null, (Function1) null, 3, (DefaultConstructorMarker) null), new FileAttachmentSelectedAdapter(CollectionsKt.emptyList(), true, (Function1) null, 4, (DefaultConstructorMarker) null), messageInputStyle.isShowAttachmentButton());
        Delegates delegates = Delegates.INSTANCE;
        InputMode.Normal normal = InputMode.Normal.INSTANCE;
        Objects.requireNonNull(normal, "null cannot be cast to non-null type com.getstream.sdk.chat.view.messageinput.InputMode");
        InputMode inputMode = normal;
        this.inputMode$delegate = new MessageInputController$$special$$inlined$observable$1(inputMode, inputMode, this);
    }

    public final AttachmentsController getAttachmentsController$stream_chat_android_release() {
        return this.attachmentsController;
    }

    public final List<Member> getMembers$stream_chat_android_release() {
        return this.members;
    }

    public final void setMembers$stream_chat_android_release(List<Member> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.members = list;
    }

    public final List<Command> getChannelCommands$stream_chat_android_release() {
        return this.channelCommands;
    }

    public final void setChannelCommands$stream_chat_android_release(List<Command> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.channelCommands = list;
    }

    /* access modifiers changed from: private */
    public final void configureThreadInputMode() {
        PreviewMessageView previewMessageView = this.binding.vPreviewMessage;
        Intrinsics.checkNotNullExpressionValue(previewMessageView, "binding.vPreviewMessage");
        int i = 8;
        previewMessageView.setVisibility(8);
        ImageView imageView = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivOpenAttach");
        imageView.setVisibility(this.style.isShowAttachmentButton() ? 0 : 8);
        CheckBox checkBox = this.binding.cbSendAlsoToChannel;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.cbSendAlsoToChannel");
        View view2 = checkBox;
        if (this.style.getSendAlsoToChannelCheckboxEnabled()) {
            i = 0;
        }
        view2.setVisibility(i);
        CheckBox checkBox2 = this.binding.cbSendAlsoToChannel;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.cbSendAlsoToChannel");
        checkBox2.setChecked(false);
    }

    /* access modifiers changed from: private */
    public final void configureNormalInputMode() {
        PreviewMessageView previewMessageView = this.binding.vPreviewMessage;
        Intrinsics.checkNotNullExpressionValue(previewMessageView, "binding.vPreviewMessage");
        previewMessageView.setVisibility(8);
        ImageView imageView = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivOpenAttach");
        imageView.setVisibility(this.style.isShowAttachmentButton() ? 0 : 8);
        CheckBox checkBox = this.binding.cbSendAlsoToChannel;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.cbSendAlsoToChannel");
        checkBox.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void configureEditInputMode(Message message) {
        this.binding.vPreviewMessage.setMessage(message, PreviewMessageView.Mode.EDIT);
        this.binding.vPreviewMessage.setOnCloseClick(new MessageInputController$configureEditInputMode$1(this));
        this.binding.messageTextInput.setText(message.getText());
        PreviewMessageView previewMessageView = this.binding.vPreviewMessage;
        Intrinsics.checkNotNullExpressionValue(previewMessageView, "binding.vPreviewMessage");
        previewMessageView.setVisibility(0);
        ImageView imageView = this.binding.ivOpenAttach;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivOpenAttach");
        imageView.setVisibility(8);
        CheckBox checkBox = this.binding.cbSendAlsoToChannel;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.cbSendAlsoToChannel");
        checkBox.setVisibility(8);
    }

    public final void onSendMessageClick$stream_chat_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        InputMode inputMode$stream_chat_android_release = getInputMode$stream_chat_android_release();
        if (inputMode$stream_chat_android_release instanceof InputMode.Normal) {
            sendNormalMessage(str);
        } else if (inputMode$stream_chat_android_release instanceof InputMode.Thread) {
            sendToThread(((InputMode.Thread) inputMode$stream_chat_android_release).getParentMessage(), str);
        } else if (inputMode$stream_chat_android_release instanceof InputMode.Edit) {
            editMessage(((InputMode.Edit) inputMode$stream_chat_android_release).getOldMessage(), str);
            Unit unit = Unit.INSTANCE;
            setInputMode$stream_chat_android_release(InputMode.Normal.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void sendNormalMessage(String str) {
        boolean isEmpty = this.attachmentsController.getSelectedAttachments$stream_chat_android_release().isEmpty();
        if (isEmpty) {
            this.view.sendTextMessage$stream_chat_android_release(str);
        } else if (!isEmpty) {
            MessageInputView messageInputView = this.view;
            Iterable<AttachmentMetaData> selectedAttachments$stream_chat_android_release = this.attachmentsController.getSelectedAttachments$stream_chat_android_release();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedAttachments$stream_chat_android_release, 10));
            for (AttachmentMetaData cachedFileFromUri : selectedAttachments$stream_chat_android_release) {
                StorageHelper storageHelper2 = this.storageHelper;
                Context context = this.view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                arrayList.add(storageHelper2.getCachedFileFromUri(context, cachedFileFromUri));
            }
            messageInputView.sendAttachments$stream_chat_android_release(str, (List) arrayList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void sendToThread(Message message, String str) {
        boolean isEmpty = this.attachmentsController.getSelectedAttachments$stream_chat_android_release().isEmpty();
        if (isEmpty) {
            MessageInputView messageInputView = this.view;
            CheckBox checkBox = this.binding.cbSendAlsoToChannel;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.cbSendAlsoToChannel");
            messageInputView.sendToThread$stream_chat_android_release(message, str, checkBox.isChecked());
        } else if (!isEmpty) {
            MessageInputView messageInputView2 = this.view;
            CheckBox checkBox2 = this.binding.cbSendAlsoToChannel;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.cbSendAlsoToChannel");
            boolean isChecked = checkBox2.isChecked();
            Iterable<AttachmentMetaData> selectedAttachments$stream_chat_android_release = this.attachmentsController.getSelectedAttachments$stream_chat_android_release();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedAttachments$stream_chat_android_release, 10));
            for (AttachmentMetaData cachedFileFromUri : selectedAttachments$stream_chat_android_release) {
                StorageHelper storageHelper2 = this.storageHelper;
                Context context = this.view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                arrayList.add(storageHelper2.getCachedFileFromUri(context, cachedFileFromUri));
            }
            messageInputView2.sendToThreadWithAttachments$stream_chat_android_release(message, str, isChecked, (List) arrayList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void editMessage(Message message, String str) {
        this.view.editMessage$stream_chat_android_release(message, str);
    }

    public final void onClickCloseAttachmentSelectionMenu$stream_chat_android_release() {
        this.messageInputType = null;
        this.attachmentsController.onClickCloseAttachmentSelectionMenu$stream_chat_android_release();
    }

    public final void onClickOpenAttachmentSelectionMenu$stream_chat_android_release(MessageInputType messageInputType2) {
        Intrinsics.checkNotNullParameter(messageInputType2, "type");
        this.attachmentsController.onClickOpenAttachmentSelectionMenu();
        int i = WhenMappings.$EnumSwitchMapping$0[messageInputType2.ordinal()];
        if (i == 2) {
            ConstraintLayout constraintLayout = this.binding.clAddFile;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clAddFile");
            constraintLayout.setVisibility(0);
        } else if (i == 3 || i == 4) {
            ConstraintLayout constraintLayout2 = this.binding.clSelectPhoto;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clSelectPhoto");
            constraintLayout2.setVisibility(0);
            this.attachmentsController.configAttachmentButtonVisible$stream_chat_android_release(false);
        } else if (i == 5 || i == 6) {
            Button button = this.binding.btnClose;
            Intrinsics.checkNotNullExpressionValue(button, "binding.btnClose");
            button.setVisibility(8);
        }
        TextView textView = this.binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTitle");
        textView.setText(MessageInputTypeKt.getLabel(messageInputType2));
    }

    public final void configSendButtonEnableState$stream_chat_android_release() {
        GifEditText gifEditText = this.binding.messageTextInput;
        Intrinsics.checkNotNullExpressionValue(gifEditText, "binding.messageTextInput");
        int i = 0;
        if (!StringsKt.isBlank(gifEditText.getText().toString())) {
            ImageView imageView = this.binding.sendButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.sendButton");
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.binding.sendButton;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.sendButton");
        View view2 = imageView2;
        if (!(!this.attachmentsController.getSelectedAttachments$stream_chat_android_release().isEmpty())) {
            i = 8;
        }
        view2.setVisibility(i);
    }

    public final void initSendMessage$stream_chat_android_release() {
        this.binding.messageTextInput.setText("");
        this.attachmentsController.clearState$stream_chat_android_release();
        onClickCloseAttachmentSelectionMenu$stream_chat_android_release();
    }

    public final void onFileCaptured$stream_chat_android_release(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.attachmentsController.selectAttachmentFromCamera$stream_chat_android_release(new AttachmentMetaData(context, file));
    }

    public final void onFilesSelected$stream_chat_android_release(List<? extends Uri> list) {
        Intrinsics.checkNotNullParameter(list, "uriList");
        this.attachmentsController.selectAttachmentsFromUriList$stream_chat_android_release(list);
    }

    public final void checkCommandsOrMentions$stream_chat_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "inputMessage");
        if (MessageInputControllerKt.isCommandMessage(str)) {
            this.view.showSuggestedCommand$stream_chat_android_release(MessageInputControllerKt.matchName(this.channelCommands, StringsKt.removePrefix(str, (CharSequence) "/")));
        } else if (MessageInputControllerKt.isMentionMessage(str)) {
            this.view.showSuggestedMentions$stream_chat_android_release(MessageInputControllerKt.matchUserName(this.members, StringsKt.substringAfterLast$default(str, "@", (String) null, 2, (Object) null)));
        } else {
            cleanSuggestion();
        }
    }

    private final void cleanSuggestion() {
        this.view.showSuggestedMentions$stream_chat_android_release(CollectionsKt.emptyList());
        this.view.showSuggestedCommand$stream_chat_android_release(CollectionsKt.emptyList());
    }

    public final void onCommandSelected$stream_chat_android_release(Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        MessageInputView messageInputView = this.view;
        messageInputView.setMessageText('/' + command.getName() + ' ');
    }

    public final void onUserSelected$stream_chat_android_release(String str, User user) {
        Intrinsics.checkNotNullParameter(str, "currentMessage");
        Intrinsics.checkNotNullParameter(user, "user");
        MessageInputView messageInputView = this.view;
        messageInputView.setMessageText(StringsKt.substringBeforeLast$default(str, "@", (String) null, 2, (Object) null) + '@' + ContentUtils.getName(user) + ' ');
    }

    public final Set<AttachmentMetaData> getSelectedAttachments() {
        return this.attachmentsController.getSelectedAttachments$stream_chat_android_release();
    }

    public final void onClickOpenMediaSelectView() {
        MessageInputType messageInputType2 = MessageInputType.UPLOAD_MEDIA;
        this.messageInputType = messageInputType2;
        AttachmentsController attachmentsController2 = this.attachmentsController;
        Intrinsics.checkNotNull(messageInputType2);
        attachmentsController2.onClickOpenMediaSelectView$stream_chat_android_release(messageInputType2);
        MessageInputType messageInputType3 = this.messageInputType;
        Intrinsics.checkNotNull(messageInputType3);
        onClickOpenAttachmentSelectionMenu$stream_chat_android_release(messageInputType3);
    }

    public final void onCameraClick() {
        this.attachmentsController.onCameraClick$stream_chat_android_release();
    }

    public final void setSelectedAttachments(Set<AttachmentMetaData> set) {
        Intrinsics.checkNotNullParameter(set, "attachments");
        this.attachmentsController.setSelectedAttachments$stream_chat_android_release(set);
    }
}
