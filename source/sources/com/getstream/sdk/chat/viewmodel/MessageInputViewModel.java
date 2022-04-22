package com.getstream.sdk.chat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.utils.extensions.ChannelKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.Command;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.ChatDomain;
import p015io.getstream.chat.android.livedata.controller.ChannelController;
import p015io.getstream.chat.android.livedata.usecase.SendMessage;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020'J\u000e\u0010\u0019\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014J\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020'J)\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00032\u0019\b\u0002\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020'0/¢\u0006\u0002\b0J7\u00101\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\t2\u0019\b\u0002\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020'0/¢\u0006\u0002\b0J\u000e\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u0014J\u0006\u00106\u001a\u00020'R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00067"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/MessageInputViewModel;", "Landroidx/lifecycle/ViewModel;", "cid", "", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/ChatDomain;)V", "_commands", "Landroidx/lifecycle/MutableLiveData;", "", "Lio/getstream/chat/android/client/models/Command;", "_isDirectMessage", "", "_maxMessageLength", "", "kotlin.jvm.PlatformType", "_members", "Landroidx/lifecycle/MediatorLiveData;", "Lio/getstream/chat/android/client/models/Member;", "activeThread", "Lio/getstream/chat/android/client/models/Message;", "commands", "Landroidx/lifecycle/LiveData;", "getCommands", "()Landroidx/lifecycle/LiveData;", "editMessage", "getEditMessage", "()Landroidx/lifecycle/MutableLiveData;", "isDirectMessage", "isThread", "()Z", "maxMessageLength", "getMaxMessageLength", "members", "getMembers", "repliedMessage", "getRepliedMessage", "()Landroidx/lifecycle/MediatorLiveData;", "dismissReply", "", "message", "getActiveThread", "keystroke", "resetThread", "sendMessage", "messageText", "messageTransformer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "sendMessageWithAttachments", "attachmentFiles", "Ljava/io/File;", "setActiveThread", "parentMessage", "stopTyping", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputViewModel.kt */
public final class MessageInputViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Command>> _commands;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _isDirectMessage;
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> _maxMessageLength;
    /* access modifiers changed from: private */
    public final MediatorLiveData<List<Member>> _members;
    private MutableLiveData<Message> activeThread;
    private final ChatDomain chatDomain;
    private final String cid;
    private final LiveData<List<Command>> commands;
    private final MutableLiveData<Message> editMessage;
    private final LiveData<Boolean> isDirectMessage;
    private final LiveData<Integer> maxMessageLength;
    private final LiveData<List<Member>> members;
    private final MediatorLiveData<Message> repliedMessage;

    public MessageInputViewModel(String str) {
        this(str, (ChatDomain) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageInputViewModel(String str, ChatDomain chatDomain2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ChatDomain.Companion.instance() : chatDomain2);
    }

    public MessageInputViewModel(String str, ChatDomain chatDomain2) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(chatDomain2, "chatDomain");
        this.cid = str;
        this.chatDomain = chatDomain2;
        this.activeThread = new MutableLiveData<>();
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(Integer.MAX_VALUE);
        this._maxMessageLength = mutableLiveData;
        MutableLiveData<List<Command>> mutableLiveData2 = new MutableLiveData<>(CollectionsKt.emptyList());
        this._commands = mutableLiveData2;
        MediatorLiveData<List<Member>> mediatorLiveData = new MediatorLiveData<>();
        this._members = mediatorLiveData;
        this.maxMessageLength = mutableLiveData;
        this.commands = mutableLiveData2;
        this.members = mediatorLiveData;
        this.editMessage = new MutableLiveData<>();
        this.repliedMessage = new MediatorLiveData<>();
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._isDirectMessage = mutableLiveData3;
        this.isDirectMessage = mutableLiveData3;
        chatDomain2.getUseCases().getWatchChannel().invoke(str, 0).enqueue(new Call.Callback<ChannelController>(this) {
            final /* synthetic */ MessageInputViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onResult(Result<ChannelController> result) {
                Intrinsics.checkNotNullParameter(result, "channelControllerResult");
                if (result.isSuccess()) {
                    ChannelController data = result.data();
                    Channel channel = data.toChannel();
                    this.this$0._maxMessageLength.setValue(Integer.valueOf(channel.getConfig().getMaxMessageLength()));
                    this.this$0._commands.setValue(channel.getConfig().getCommands());
                    this.this$0._members.addSource(data.getMembers(), new Observer<List<? extends Member>>(this) {
                        final /* synthetic */ C17591 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(List<Member> list) {
                            this.this$0.this$0._members.setValue(list);
                        }
                    });
                    this.this$0._isDirectMessage.setValue(Boolean.valueOf(ChannelKt.isDirectMessaging(channel)));
                    this.this$0.getRepliedMessage().addSource(data.getRepliedMessage(), new Observer<Message>(this) {
                        final /* synthetic */ C17591 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(Message message) {
                            this.this$0.this$0.getRepliedMessage().setValue(message);
                        }
                    });
                }
            }
        });
    }

    public final LiveData<Integer> getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public final LiveData<List<Command>> getCommands() {
        return this.commands;
    }

    public final LiveData<List<Member>> getMembers() {
        return this.members;
    }

    public final MutableLiveData<Message> getEditMessage() {
        return this.editMessage;
    }

    public final MediatorLiveData<Message> getRepliedMessage() {
        return this.repliedMessage;
    }

    public final LiveData<Boolean> isDirectMessage() {
        return this.isDirectMessage;
    }

    public final void setActiveThread(Message message) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        this.activeThread.postValue(message);
    }

    public final LiveData<Message> getActiveThread() {
        return this.activeThread;
    }

    private final boolean isThread() {
        return this.activeThread.getValue() != null;
    }

    public final void resetThread() {
        this.activeThread.postValue(null);
    }

    public static /* synthetic */ void sendMessage$default(MessageInputViewModel messageInputViewModel, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = MessageInputViewModel$sendMessage$1.INSTANCE;
        }
        messageInputViewModel.sendMessage(str, function1);
    }

    public final void sendMessage(String str, Function1<? super Message, Unit> function1) {
        Message message;
        Function1<? super Message, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(str, "messageText");
        Intrinsics.checkNotNullParameter(function12, "messageTransformer");
        Message message2 = r2;
        Message message3 = new Message((String) null, this.cid, str, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -7, 7, (DefaultConstructorMarker) null);
        Message value = this.activeThread.getValue();
        if (value != null) {
            message = message2;
            message.setParentId(value.getId());
        } else {
            message = message2;
        }
        stopTyping();
        SendMessage sendMessage = this.chatDomain.getUseCases().getSendMessage();
        function12.invoke(message);
        sendMessage.invoke(message).enqueue();
    }

    public static /* synthetic */ void sendMessageWithAttachments$default(MessageInputViewModel messageInputViewModel, String str, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = MessageInputViewModel$sendMessageWithAttachments$1.INSTANCE;
        }
        messageInputViewModel.sendMessageWithAttachments(str, list, function1);
    }

    public final void sendMessageWithAttachments(String str, List<? extends File> list, Function1<? super Message, Unit> function1) {
        List<? extends File> list2 = list;
        Function1<? super Message, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(str, "messageText");
        Intrinsics.checkNotNullParameter(list2, "attachmentFiles");
        Intrinsics.checkNotNullParameter(function12, "messageTransformer");
        Iterable<File> iterable = list2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (File attachment : iterable) {
            arrayList.add(new Attachment((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, attachment, (Attachment.UploadState) null, (Map) null, 229375, (DefaultConstructorMarker) null));
        }
        Message message = new Message((String) null, this.cid, str, (String) null, (String) null, (String) null, CollectionsKt.toMutableList((List) arrayList), (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -71, 7, (DefaultConstructorMarker) null);
        function12.invoke(message);
        this.chatDomain.getUseCases().getSendMessage().invoke(message).enqueue();
    }

    public final void editMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        stopTyping();
        this.chatDomain.getUseCases().getEditMessage().invoke(message).enqueue();
    }

    public final synchronized void keystroke() {
        Message value = this.activeThread.getValue();
        this.chatDomain.getUseCases().getKeystroke().invoke(this.cid, value != null ? value.getId() : null).enqueue();
    }

    public final void stopTyping() {
        Message value = this.activeThread.getValue();
        this.chatDomain.getUseCases().getStopTyping().invoke(this.cid, value != null ? value.getId() : null).enqueue();
    }

    public final void dismissReply() {
        if (this.repliedMessage.getValue() != null) {
            this.chatDomain.getUseCases().getSetMessageForReply().invoke(this.cid, (Message) null).enqueue();
        }
    }
}
