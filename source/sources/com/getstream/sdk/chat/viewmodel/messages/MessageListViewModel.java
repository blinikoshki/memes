package com.getstream.sdk.chat.viewmodel.messages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.enums.GiphyAction;
import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import com.google.firebase.messaging.Constants;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.ChatDomain;
import p015io.getstream.chat.android.livedata.controller.ChannelController;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 L2\u00020\u0001:\u0005LMNOPB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0002J\u000e\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020?H\u0002J \u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u000eH\u0002J\b\u0010D\u001a\u000209H\u0002J\u0010\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u0014H\u0002J\b\u0010G\u001a\u000209H\u0002J\u0010\u0010H\u001a\u0002092\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010I\u001a\u0002092\b\u00106\u001a\u0004\u0018\u00010'J\u001c\u0010J\u001a\u0002092\u0012\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\u0016H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8B@BX\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0016X\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0018R\u0010\u00106\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel;", "Landroidx/lifecycle/ViewModel;", "cid", "", "messageId", "domain", "Lio/getstream/chat/android/livedata/ChatDomain;", "client", "Lio/getstream/chat/android/client/ChatClient;", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/livedata/ChatDomain;Lio/getstream/chat/android/client/ChatClient;)V", "_channel", "Landroidx/lifecycle/MediatorLiveData;", "Lio/getstream/chat/android/client/models/Channel;", "_loadMoreLiveData", "", "_reads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "_targetMessage", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/Message;", "channel", "Landroidx/lifecycle/LiveData;", "getChannel", "()Landroidx/lifecycle/LiveData;", "<set-?>", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "currentMode", "getCurrentMode", "()Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "setCurrentMode", "(Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;)V", "currentMode$delegate", "Lkotlin/properties/ReadWriteProperty;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "getCurrentUser", "()Lio/getstream/chat/android/client/models/User;", "dateSeparatorHandler", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$DateSeparatorHandler;", "loadMoreLiveData", "getLoadMoreLiveData", "messageListData", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListItemLiveData;", "mode", "getMode", "()Landroidx/lifecycle/MutableLiveData;", "reads", "state", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "getState", "stateMerger", "targetMessage", "getTargetMessage", "threadDateSeparatorHandler", "threadListData", "onBackButtonPressed", "", "onEndRegionReached", "onEvent", "event", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "onGiphyActionSelected", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$GiphyActionSelected;", "onMessageReaction", "message", "reactionType", "enforceUnique", "onNormalModeEntered", "onThreadModeEntered", "parentMessage", "resetThread", "setDateSeparatorHandler", "setThreadDateSeparatorHandler", "setThreadMessages", "threadMessages", "Companion", "DateSeparatorHandler", "Event", "Mode", "State", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
public final class MessageListViewModel extends ViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MessageListViewModel.class, "currentMode", "getCurrentMode()Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MESSAGES_LIMIT = 30;
    /* access modifiers changed from: private */
    public final MediatorLiveData<Channel> _channel;
    /* access modifiers changed from: private */
    public final MediatorLiveData<Boolean> _loadMoreLiveData;
    /* access modifiers changed from: private */
    public final MediatorLiveData<List<ChannelUserRead>> _reads;
    /* access modifiers changed from: private */
    public final MutableLiveData<Message> _targetMessage;
    private final LiveData<Channel> channel;
    /* access modifiers changed from: private */
    public final String cid;
    private final ChatClient client;
    private final ReadWriteProperty currentMode$delegate;
    private final User currentUser;
    /* access modifiers changed from: private */
    public DateSeparatorHandler dateSeparatorHandler;
    /* access modifiers changed from: private */
    public final ChatDomain domain;
    private final LiveData<Boolean> loadMoreLiveData;
    /* access modifiers changed from: private */
    public final String messageId;
    /* access modifiers changed from: private */
    public MessageListItemLiveData messageListData;
    private final MutableLiveData<Mode> mode;
    private final LiveData<List<ChannelUserRead>> reads;
    private final LiveData<State> state;
    /* access modifiers changed from: private */
    public final MediatorLiveData<State> stateMerger;
    private final LiveData<Message> targetMessage;
    private DateSeparatorHandler threadDateSeparatorHandler;
    /* access modifiers changed from: private */
    public MessageListItemLiveData threadListData;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$DateSeparatorHandler;", "", "shouldAddDateSeparator", "", "previousMessage", "Lio/getstream/chat/android/client/models/Message;", "message", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListViewModel.kt */
    public interface DateSeparatorHandler {
        boolean shouldAddDateSeparator(Message message, Message message2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GiphyAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GiphyAction.SEND.ordinal()] = 1;
            iArr[GiphyAction.SHUFFLE.ordinal()] = 2;
            iArr[GiphyAction.CANCEL.ordinal()] = 3;
        }
    }

    public MessageListViewModel(String str) {
        this(str, (String) null, (ChatDomain) null, (ChatClient) null, 14, (DefaultConstructorMarker) null);
    }

    public MessageListViewModel(String str, String str2) {
        this(str, str2, (ChatDomain) null, (ChatClient) null, 12, (DefaultConstructorMarker) null);
    }

    public MessageListViewModel(String str, String str2, ChatDomain chatDomain) {
        this(str, str2, chatDomain, (ChatClient) null, 8, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final Mode getCurrentMode() {
        return (Mode) this.currentMode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setCurrentMode(Mode mode2) {
        this.currentMode$delegate.setValue(this, $$delegatedProperties[0], mode2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageListViewModel(String str, String str2, ChatDomain chatDomain, ChatClient chatClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? ChatDomain.Companion.instance() : chatDomain, (i & 8) != 0 ? ChatClient.Companion.instance() : chatClient);
    }

    public MessageListViewModel(String str, String str2, ChatDomain chatDomain, ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(chatDomain, "domain");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        this.cid = str;
        this.messageId = str2;
        this.domain = chatDomain;
        this.client = chatClient;
        MediatorLiveData<State> mediatorLiveData = new MediatorLiveData<>();
        this.stateMerger = mediatorLiveData;
        Delegates delegates = Delegates.INSTANCE;
        Mode.Normal normal = Mode.Normal.INSTANCE;
        Objects.requireNonNull(normal, "null cannot be cast to non-null type com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel.Mode");
        Mode mode2 = normal;
        this.currentMode$delegate = new MessageListViewModel$$special$$inlined$observable$1(mode2, mode2, this);
        MediatorLiveData<List<ChannelUserRead>> mediatorLiveData2 = new MediatorLiveData<>();
        this._reads = mediatorLiveData2;
        this.reads = mediatorLiveData2;
        MediatorLiveData<Boolean> mediatorLiveData3 = new MediatorLiveData<>();
        this._loadMoreLiveData = mediatorLiveData3;
        this.loadMoreLiveData = mediatorLiveData3;
        MediatorLiveData<Channel> mediatorLiveData4 = new MediatorLiveData<>();
        this._channel = mediatorLiveData4;
        this.channel = mediatorLiveData4;
        MutableLiveData<Message> mutableLiveData = new MutableLiveData<>();
        this._targetMessage = mutableLiveData;
        this.targetMessage = mutableLiveData;
        this.mode = new MutableLiveData<>(getCurrentMode());
        this.state = mediatorLiveData;
        this.currentUser = chatDomain.getCurrentUser();
        this.dateSeparatorHandler = MessageListViewModel$dateSeparatorHandler$1.INSTANCE;
        this.threadDateSeparatorHandler = MessageListViewModel$threadDateSeparatorHandler$1.INSTANCE;
        mediatorLiveData.addSource(new MutableLiveData(State.Loading.INSTANCE), new Observer<State.Loading>(this) {
            final /* synthetic */ MessageListViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(State.Loading loading) {
                this.this$0.stateMerger.setValue(loading);
            }
        });
        chatDomain.getUseCases().getWatchChannel().invoke(str, 30).enqueue(new Call.Callback<ChannelController>(this) {
            final /* synthetic */ MessageListViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onResult(Result<ChannelController> result) {
                Intrinsics.checkNotNullParameter(result, "channelControllerResult");
                if (result.isSuccess()) {
                    ChannelController data = result.data();
                    this.this$0._channel.addSource(new MutableLiveData(data.toChannel()), new Observer<Channel>(this) {
                        final /* synthetic */ C17742 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(Channel channel) {
                            this.this$0.this$0._channel.setValue(channel);
                        }
                    });
                    LiveData<Y> map = Transformations.map(data.getTyping(), MessageListViewModel$2$typingIds$1.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(chan…{ (_, idList) -> idList }");
                    MessageListViewModel messageListViewModel = this.this$0;
                    messageListViewModel.messageListData = new MessageListItemLiveData(messageListViewModel.getCurrentUser(), data.getMessages(), data.getReads(), map, false, this.this$0.dateSeparatorHandler);
                    this.this$0._reads.addSource(data.getReads(), new Observer<List<? extends ChannelUserRead>>(this) {
                        final /* synthetic */ C17742 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(List<ChannelUserRead> list) {
                            this.this$0.this$0._reads.setValue(list);
                        }
                    });
                    this.this$0._loadMoreLiveData.addSource(data.getLoadingOlderMessages(), new Observer<Boolean>(this) {
                        final /* synthetic */ C17742 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(Boolean bool) {
                            this.this$0.this$0._loadMoreLiveData.setValue(bool);
                        }
                    });
                    CharSequence access$getMessageId$p = this.this$0.messageId;
                    if (access$getMessageId$p == null || access$getMessageId$p.length() == 0) {
                        MediatorLiveData access$getStateMerger$p = this.this$0.stateMerger;
                        access$getStateMerger$p.addSource(data.getMessagesState(), new MessageListViewModel$2$$special$$inlined$apply$lambda$1(access$getStateMerger$p, this, data));
                        return;
                    }
                    this.this$0.domain.getUseCases().getLoadMessageById().invoke(this.this$0.cid, this.this$0.messageId, 30, 30).enqueue(new Call.Callback<Message>(this) {
                        final /* synthetic */ C17742 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onResult(Result<Message> result) {
                            Intrinsics.checkNotNullParameter(result, "it");
                            if (result.isSuccess()) {
                                this.this$0.this$0._targetMessage.setValue(result.data());
                                this.this$0.this$0.onNormalModeEntered();
                                return;
                            }
                            this.this$0.this$0.stateMerger.setValue(new State.Result(new MessageListItemWrapper((List) null, false, false, false, 15, (DefaultConstructorMarker) null)));
                        }
                    });
                }
            }
        });
    }

    public final LiveData<Boolean> getLoadMoreLiveData() {
        return this.loadMoreLiveData;
    }

    public final LiveData<Channel> getChannel() {
        return this.channel;
    }

    public final LiveData<Message> getTargetMessage() {
        return this.targetMessage;
    }

    public final MutableLiveData<Mode> getMode() {
        return this.mode;
    }

    public final LiveData<State> getState() {
        return this.state;
    }

    public final User getCurrentUser() {
        return this.currentUser;
    }

    /* access modifiers changed from: private */
    public final void setThreadMessages(LiveData<List<Message>> liveData) {
        MessageListItemLiveData messageListItemLiveData;
        MessageListItemLiveData messageListItemLiveData2 = new MessageListItemLiveData(this.currentUser, liveData, this.reads, (LiveData<List<User>>) null, true, this.threadDateSeparatorHandler);
        this.threadListData = messageListItemLiveData2;
        if (messageListItemLiveData2 != null && (messageListItemLiveData = this.messageListData) != null) {
            MediatorLiveData<State> mediatorLiveData = this.stateMerger;
            mediatorLiveData.removeSource(messageListItemLiveData);
            mediatorLiveData.addSource(messageListItemLiveData2, new MessageListViewModel$setThreadMessages$1$1$1$1(mediatorLiveData));
        }
    }

    private final void resetThread() {
        MessageListItemLiveData messageListItemLiveData = this.threadListData;
        if (messageListItemLiveData != null) {
            this.stateMerger.removeSource(messageListItemLiveData);
        }
        MessageListItemLiveData messageListItemLiveData2 = this.messageListData;
        if (messageListItemLiveData2 != null) {
            this.stateMerger.addSource(messageListItemLiveData2, new MessageListViewModel$resetThread$$inlined$let$lambda$1(this));
        }
    }

    public final void onEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof Event.EndRegionReached) {
            onEndRegionReached();
            Unit unit = Unit.INSTANCE;
        } else if (event instanceof Event.LastMessageRead) {
            this.domain.getUseCases().getMarkRead().invoke(this.cid).enqueue();
            Unit unit2 = Unit.INSTANCE;
        } else if (event instanceof Event.ThreadModeEntered) {
            onThreadModeEntered(((Event.ThreadModeEntered) event).getParentMessage());
            Unit unit3 = Unit.INSTANCE;
        } else if (event instanceof Event.BackButtonPressed) {
            onBackButtonPressed();
            Unit unit4 = Unit.INSTANCE;
        } else if (event instanceof Event.DeleteMessage) {
            this.domain.getUseCases().getDeleteMessage().invoke(((Event.DeleteMessage) event).getMessage()).enqueue();
            Unit unit5 = Unit.INSTANCE;
        } else if (event instanceof Event.FlagMessage) {
            this.client.flagMessage(((Event.FlagMessage) event).getMessage().getId()).enqueue();
            Unit unit6 = Unit.INSTANCE;
        } else if (event instanceof Event.GiphyActionSelected) {
            onGiphyActionSelected((Event.GiphyActionSelected) event);
            Unit unit7 = Unit.INSTANCE;
        } else if (event instanceof Event.RetryMessage) {
            this.domain.getUseCases().getSendMessage().invoke(((Event.RetryMessage) event).getMessage()).enqueue();
            Unit unit8 = Unit.INSTANCE;
        } else if (event instanceof Event.MessageReaction) {
            Event.MessageReaction messageReaction = (Event.MessageReaction) event;
            onMessageReaction(messageReaction.getMessage(), messageReaction.getReactionType(), messageReaction.getEnforceUnique());
            Unit unit9 = Unit.INSTANCE;
        } else if (event instanceof Event.MuteUser) {
            this.client.muteUser(((Event.MuteUser) event).getUser().getId()).enqueue();
            Unit unit10 = Unit.INSTANCE;
        } else if (event instanceof Event.BlockUser) {
            this.client.channel(this.cid).shadowBanUser(((Event.BlockUser) event).getUser().getId(), (String) null, (Integer) null).enqueue();
            Unit unit11 = Unit.INSTANCE;
        } else if (event instanceof Event.ReplyMessage) {
            Event.ReplyMessage replyMessage = (Event.ReplyMessage) event;
            this.domain.getUseCases().getSetMessageForReply().invoke(replyMessage.getCid(), replyMessage.getRepliedMessage()).enqueue();
            Unit unit12 = Unit.INSTANCE;
        } else if (event instanceof Event.DownloadAttachment) {
            this.domain.getUseCases().getDownloadAttachment().invoke(((Event.DownloadAttachment) event).getAttachment()).enqueue();
            Unit unit13 = Unit.INSTANCE;
        } else if (event instanceof Event.AttachmentDownload) {
            this.domain.getUseCases().getDownloadAttachment().invoke(((Event.AttachmentDownload) event).getAttachment()).enqueue();
            Unit unit14 = Unit.INSTANCE;
        } else if (event instanceof Event.ShowMessage) {
            this.domain.getUseCases().getLoadMessageById().invoke(this.cid, ((Event.ShowMessage) event).getMessageId(), 30, 30).enqueue(new MessageListViewModel$onEvent$1(this));
            Unit unit15 = Unit.INSTANCE;
        } else if (event instanceof Event.RemoveAttachment) {
            Event.RemoveAttachment removeAttachment = (Event.RemoveAttachment) event;
            this.domain.getUseCases().getLoadMessageById().invoke(this.cid, removeAttachment.getMessageId(), 30, 30).enqueue(new MessageListViewModel$onEvent$2(this, removeAttachment.getAttachment()));
            Unit unit16 = Unit.INSTANCE;
        } else if (event instanceof Event.ReplyAttachment) {
            Event.ReplyAttachment replyAttachment = (Event.ReplyAttachment) event;
            String repliedMessageId = replyAttachment.getRepliedMessageId();
            String cid2 = replyAttachment.getCid();
            this.domain.getUseCases().getLoadMessageById().invoke(cid2, repliedMessageId, 30, 30).enqueue(new MessageListViewModel$onEvent$3(this, cid2));
            Unit unit17 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setDateSeparatorHandler(DateSeparatorHandler dateSeparatorHandler2) {
        this.dateSeparatorHandler = dateSeparatorHandler2;
    }

    public final void setThreadDateSeparatorHandler(DateSeparatorHandler dateSeparatorHandler2) {
        this.threadDateSeparatorHandler = dateSeparatorHandler2;
    }

    private final void onGiphyActionSelected(Event.GiphyActionSelected giphyActionSelected) {
        int i = WhenMappings.$EnumSwitchMapping$0[giphyActionSelected.getAction().ordinal()];
        if (i == 1) {
            this.domain.getUseCases().getSendGiphy().invoke(giphyActionSelected.getMessage()).enqueue();
            Unit unit = Unit.INSTANCE;
        } else if (i == 2) {
            this.domain.getUseCases().getShuffleGiphy().invoke(giphyActionSelected.getMessage()).enqueue();
            Unit unit2 = Unit.INSTANCE;
        } else if (i == 3) {
            this.domain.getUseCases().getCancelMessage().invoke(giphyActionSelected.getMessage()).enqueue();
            Unit unit3 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void onEndRegionReached() {
        Mode currentMode = getCurrentMode();
        if (currentMode instanceof Mode.Normal) {
            MessageListItemLiveData messageListItemLiveData = this.messageListData;
            if (messageListItemLiveData != null) {
                messageListItemLiveData.loadingMoreChanged$stream_chat_android_ui_common_release(true);
            }
            this.domain.getUseCases().getLoadOlderMessages().invoke(this.cid, 30).enqueue(new MessageListViewModel$onEndRegionReached$$inlined$run$lambda$1(this));
            Unit unit = Unit.INSTANCE;
        } else if (currentMode instanceof Mode.Thread) {
            MessageListItemLiveData messageListItemLiveData2 = this.threadListData;
            if (messageListItemLiveData2 != null) {
                messageListItemLiveData2.loadingMoreChanged$stream_chat_android_ui_common_release(true);
            }
            this.domain.getUseCases().getThreadLoadMore().invoke(this.cid, ((Mode.Thread) currentMode).getParentMessage().getId(), 30).enqueue(new MessageListViewModel$onEndRegionReached$$inlined$run$lambda$2(this));
            Unit unit2 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void onBackButtonPressed() {
        Mode currentMode = getCurrentMode();
        if (currentMode instanceof Mode.Normal) {
            this.stateMerger.postValue(State.NavigateUp.INSTANCE);
            Unit unit = Unit.INSTANCE;
        } else if (currentMode instanceof Mode.Thread) {
            onNormalModeEntered();
            Unit unit2 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void onThreadModeEntered(Message message) {
        String id = message.getId();
        this.domain.getUseCases().getGetThread().invoke(this.cid, id).enqueue(new MessageListViewModel$onThreadModeEntered$1(this, message, id));
    }

    private final void onMessageReaction(Message message, String str, boolean z) {
        String str2 = str;
        Reaction reaction = r2;
        Reaction reaction2 = new Reaction((String) null, (String) null, 0, (User) null, (String) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, (Map) null, false, 2047, (DefaultConstructorMarker) null);
        reaction.setMessageId(message.getId());
        reaction.setType(str2);
        boolean z2 = true;
        reaction.setScore(1);
        Iterable ownReactions = message.getOwnReactions();
        if (!(ownReactions instanceof Collection) || !((Collection) ownReactions).isEmpty()) {
            Iterator it = ownReactions.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual((Object) ((Reaction) it.next()).getType(), (Object) str2)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            Reaction reaction3 = reaction;
            this.domain.getUseCases().getDeleteReaction().invoke(this.cid, reaction3).enqueue();
            return;
        }
        Reaction reaction4 = reaction;
        this.domain.getUseCases().getSendReaction().invoke(this.cid, reaction4, z).enqueue();
    }

    /* access modifiers changed from: private */
    public final void onNormalModeEntered() {
        setCurrentMode(Mode.Normal.INSTANCE);
        resetThread();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "", "()V", "Loading", "NavigateUp", "Result", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$Result;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$NavigateUp;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListViewModel.kt */
    public static abstract class State {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super((DefaultConstructorMarker) null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$Result;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "messageListItem", "Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "(Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;)V", "getMessageListItem", "()Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class Result extends State {
            private final MessageListItemWrapper messageListItem;

            public static /* synthetic */ Result copy$default(Result result, MessageListItemWrapper messageListItemWrapper, int i, Object obj) {
                if ((i & 1) != 0) {
                    messageListItemWrapper = result.messageListItem;
                }
                return result.copy(messageListItemWrapper);
            }

            public final MessageListItemWrapper component1() {
                return this.messageListItem;
            }

            public final Result copy(MessageListItemWrapper messageListItemWrapper) {
                Intrinsics.checkNotNullParameter(messageListItemWrapper, "messageListItem");
                return new Result(messageListItemWrapper);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Result) && Intrinsics.areEqual((Object) this.messageListItem, (Object) ((Result) obj).messageListItem);
                }
                return true;
            }

            public int hashCode() {
                MessageListItemWrapper messageListItemWrapper = this.messageListItem;
                if (messageListItemWrapper != null) {
                    return messageListItemWrapper.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Result(messageListItem=" + this.messageListItem + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Result(MessageListItemWrapper messageListItemWrapper) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(messageListItemWrapper, "messageListItem");
                this.messageListItem = messageListItemWrapper;
            }

            public final MessageListItemWrapper getMessageListItem() {
                return this.messageListItem;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State$NavigateUp;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$State;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class NavigateUp extends State {
            public static final NavigateUp INSTANCE = new NavigateUp();

            private NavigateUp() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0011\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "", "()V", "AttachmentDownload", "BackButtonPressed", "BlockUser", "DeleteMessage", "DownloadAttachment", "EndRegionReached", "FlagMessage", "GiphyActionSelected", "LastMessageRead", "MessageReaction", "MuteUser", "RemoveAttachment", "ReplyAttachment", "ReplyMessage", "RetryMessage", "ShowMessage", "ThreadModeEntered", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$BackButtonPressed;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$EndRegionReached;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$LastMessageRead;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ThreadModeEntered;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$DeleteMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$FlagMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$GiphyActionSelected;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$RetryMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$MessageReaction;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$MuteUser;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$BlockUser;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ReplyMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ReplyAttachment;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$DownloadAttachment;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$AttachmentDownload;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ShowMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$RemoveAttachment;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListViewModel.kt */
    public static abstract class Event {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$BackButtonPressed;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class BackButtonPressed extends Event {
            public static final BackButtonPressed INSTANCE = new BackButtonPressed();

            private BackButtonPressed() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$EndRegionReached;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class EndRegionReached extends Event {
            public static final EndRegionReached INSTANCE = new EndRegionReached();

            private EndRegionReached() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$LastMessageRead;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class LastMessageRead extends Event {
            public static final LastMessageRead INSTANCE = new LastMessageRead();

            private LastMessageRead() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ThreadModeEntered;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "parentMessage", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getParentMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class ThreadModeEntered extends Event {
            private final Message parentMessage;

            public static /* synthetic */ ThreadModeEntered copy$default(ThreadModeEntered threadModeEntered, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = threadModeEntered.parentMessage;
                }
                return threadModeEntered.copy(message);
            }

            public final Message component1() {
                return this.parentMessage;
            }

            public final ThreadModeEntered copy(Message message) {
                Intrinsics.checkNotNullParameter(message, "parentMessage");
                return new ThreadModeEntered(message);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ThreadModeEntered) && Intrinsics.areEqual((Object) this.parentMessage, (Object) ((ThreadModeEntered) obj).parentMessage);
                }
                return true;
            }

            public int hashCode() {
                Message message = this.parentMessage;
                if (message != null) {
                    return message.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "ThreadModeEntered(parentMessage=" + this.parentMessage + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ThreadModeEntered(Message message) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message, "parentMessage");
                this.parentMessage = message;
            }

            public final Message getParentMessage() {
                return this.parentMessage;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$DeleteMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class DeleteMessage extends Event {
            private final Message message;

            public static /* synthetic */ DeleteMessage copy$default(DeleteMessage deleteMessage, Message message2, int i, Object obj) {
                if ((i & 1) != 0) {
                    message2 = deleteMessage.message;
                }
                return deleteMessage.copy(message2);
            }

            public final Message component1() {
                return this.message;
            }

            public final DeleteMessage copy(Message message2) {
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                return new DeleteMessage(message2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof DeleteMessage) && Intrinsics.areEqual((Object) this.message, (Object) ((DeleteMessage) obj).message);
                }
                return true;
            }

            public int hashCode() {
                Message message2 = this.message;
                if (message2 != null) {
                    return message2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "DeleteMessage(message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeleteMessage(Message message2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                this.message = message2;
            }

            public final Message getMessage() {
                return this.message;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$FlagMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class FlagMessage extends Event {
            private final Message message;

            public static /* synthetic */ FlagMessage copy$default(FlagMessage flagMessage, Message message2, int i, Object obj) {
                if ((i & 1) != 0) {
                    message2 = flagMessage.message;
                }
                return flagMessage.copy(message2);
            }

            public final Message component1() {
                return this.message;
            }

            public final FlagMessage copy(Message message2) {
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                return new FlagMessage(message2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof FlagMessage) && Intrinsics.areEqual((Object) this.message, (Object) ((FlagMessage) obj).message);
                }
                return true;
            }

            public int hashCode() {
                Message message2 = this.message;
                if (message2 != null) {
                    return message2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "FlagMessage(message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FlagMessage(Message message2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                this.message = message2;
            }

            public final Message getMessage() {
                return this.message;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$GiphyActionSelected;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "message", "Lio/getstream/chat/android/client/models/Message;", "action", "Lcom/getstream/sdk/chat/enums/GiphyAction;", "(Lio/getstream/chat/android/client/models/Message;Lcom/getstream/sdk/chat/enums/GiphyAction;)V", "getAction", "()Lcom/getstream/sdk/chat/enums/GiphyAction;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class GiphyActionSelected extends Event {
            private final GiphyAction action;
            private final Message message;

            public static /* synthetic */ GiphyActionSelected copy$default(GiphyActionSelected giphyActionSelected, Message message2, GiphyAction giphyAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    message2 = giphyActionSelected.message;
                }
                if ((i & 2) != 0) {
                    giphyAction = giphyActionSelected.action;
                }
                return giphyActionSelected.copy(message2, giphyAction);
            }

            public final Message component1() {
                return this.message;
            }

            public final GiphyAction component2() {
                return this.action;
            }

            public final GiphyActionSelected copy(Message message2, GiphyAction giphyAction) {
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(giphyAction, NativeProtocol.WEB_DIALOG_ACTION);
                return new GiphyActionSelected(message2, giphyAction);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GiphyActionSelected)) {
                    return false;
                }
                GiphyActionSelected giphyActionSelected = (GiphyActionSelected) obj;
                return Intrinsics.areEqual((Object) this.message, (Object) giphyActionSelected.message) && Intrinsics.areEqual((Object) this.action, (Object) giphyActionSelected.action);
            }

            public int hashCode() {
                Message message2 = this.message;
                int i = 0;
                int hashCode = (message2 != null ? message2.hashCode() : 0) * 31;
                GiphyAction giphyAction = this.action;
                if (giphyAction != null) {
                    i = giphyAction.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "GiphyActionSelected(message=" + this.message + ", action=" + this.action + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GiphyActionSelected(Message message2, GiphyAction giphyAction) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(giphyAction, NativeProtocol.WEB_DIALOG_ACTION);
                this.message = message2;
                this.action = giphyAction;
            }

            public final GiphyAction getAction() {
                return this.action;
            }

            public final Message getMessage() {
                return this.message;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$RetryMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class RetryMessage extends Event {
            private final Message message;

            public static /* synthetic */ RetryMessage copy$default(RetryMessage retryMessage, Message message2, int i, Object obj) {
                if ((i & 1) != 0) {
                    message2 = retryMessage.message;
                }
                return retryMessage.copy(message2);
            }

            public final Message component1() {
                return this.message;
            }

            public final RetryMessage copy(Message message2) {
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                return new RetryMessage(message2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof RetryMessage) && Intrinsics.areEqual((Object) this.message, (Object) ((RetryMessage) obj).message);
                }
                return true;
            }

            public int hashCode() {
                Message message2 = this.message;
                if (message2 != null) {
                    return message2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "RetryMessage(message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RetryMessage(Message message2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                this.message = message2;
            }

            public final Message getMessage() {
                return this.message;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$MessageReaction;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "message", "Lio/getstream/chat/android/client/models/Message;", "reactionType", "", "enforceUnique", "", "(Lio/getstream/chat/android/client/models/Message;Ljava/lang/String;Z)V", "getEnforceUnique", "()Z", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "getReactionType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class MessageReaction extends Event {
            private final boolean enforceUnique;
            private final Message message;
            private final String reactionType;

            public static /* synthetic */ MessageReaction copy$default(MessageReaction messageReaction, Message message2, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    message2 = messageReaction.message;
                }
                if ((i & 2) != 0) {
                    str = messageReaction.reactionType;
                }
                if ((i & 4) != 0) {
                    z = messageReaction.enforceUnique;
                }
                return messageReaction.copy(message2, str, z);
            }

            public final Message component1() {
                return this.message;
            }

            public final String component2() {
                return this.reactionType;
            }

            public final boolean component3() {
                return this.enforceUnique;
            }

            public final MessageReaction copy(Message message2, String str, boolean z) {
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(str, "reactionType");
                return new MessageReaction(message2, str, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageReaction)) {
                    return false;
                }
                MessageReaction messageReaction = (MessageReaction) obj;
                return Intrinsics.areEqual((Object) this.message, (Object) messageReaction.message) && Intrinsics.areEqual((Object) this.reactionType, (Object) messageReaction.reactionType) && this.enforceUnique == messageReaction.enforceUnique;
            }

            public int hashCode() {
                Message message2 = this.message;
                int i = 0;
                int hashCode = (message2 != null ? message2.hashCode() : 0) * 31;
                String str = this.reactionType;
                if (str != null) {
                    i = str.hashCode();
                }
                int i2 = (hashCode + i) * 31;
                boolean z = this.enforceUnique;
                if (z) {
                    z = true;
                }
                return i2 + (z ? 1 : 0);
            }

            public String toString() {
                return "MessageReaction(message=" + this.message + ", reactionType=" + this.reactionType + ", enforceUnique=" + this.enforceUnique + ")";
            }

            public final Message getMessage() {
                return this.message;
            }

            public final String getReactionType() {
                return this.reactionType;
            }

            public final boolean getEnforceUnique() {
                return this.enforceUnique;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageReaction(Message message2, String str, boolean z) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(str, "reactionType");
                this.message = message2;
                this.reactionType = str;
                this.enforceUnique = z;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$MuteUser;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;)V", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class MuteUser extends Event {
            private final User user;

            public static /* synthetic */ MuteUser copy$default(MuteUser muteUser, User user2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user2 = muteUser.user;
                }
                return muteUser.copy(user2);
            }

            public final User component1() {
                return this.user;
            }

            public final MuteUser copy(User user2) {
                Intrinsics.checkNotNullParameter(user2, "user");
                return new MuteUser(user2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof MuteUser) && Intrinsics.areEqual((Object) this.user, (Object) ((MuteUser) obj).user);
                }
                return true;
            }

            public int hashCode() {
                User user2 = this.user;
                if (user2 != null) {
                    return user2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "MuteUser(user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MuteUser(User user2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user2, "user");
                this.user = user2;
            }

            public final User getUser() {
                return this.user;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$BlockUser;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "user", "Lio/getstream/chat/android/client/models/User;", "cid", "", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getCid", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class BlockUser extends Event {
            private final String cid;
            private final User user;

            public static /* synthetic */ BlockUser copy$default(BlockUser blockUser, User user2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    user2 = blockUser.user;
                }
                if ((i & 2) != 0) {
                    str = blockUser.cid;
                }
                return blockUser.copy(user2, str);
            }

            public final User component1() {
                return this.user;
            }

            public final String component2() {
                return this.cid;
            }

            public final BlockUser copy(User user2, String str) {
                Intrinsics.checkNotNullParameter(user2, "user");
                Intrinsics.checkNotNullParameter(str, "cid");
                return new BlockUser(user2, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof BlockUser)) {
                    return false;
                }
                BlockUser blockUser = (BlockUser) obj;
                return Intrinsics.areEqual((Object) this.user, (Object) blockUser.user) && Intrinsics.areEqual((Object) this.cid, (Object) blockUser.cid);
            }

            public int hashCode() {
                User user2 = this.user;
                int i = 0;
                int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
                String str = this.cid;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "BlockUser(user=" + this.user + ", cid=" + this.cid + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BlockUser(User user2, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user2, "user");
                Intrinsics.checkNotNullParameter(str, "cid");
                this.user = user2;
                this.cid = str;
            }

            public final String getCid() {
                return this.cid;
            }

            public final User getUser() {
                return this.user;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ReplyMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "cid", "", "repliedMessage", "Lio/getstream/chat/android/client/models/Message;", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/Message;)V", "getCid", "()Ljava/lang/String;", "getRepliedMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class ReplyMessage extends Event {
            private final String cid;
            private final Message repliedMessage;

            public static /* synthetic */ ReplyMessage copy$default(ReplyMessage replyMessage, String str, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = replyMessage.cid;
                }
                if ((i & 2) != 0) {
                    message = replyMessage.repliedMessage;
                }
                return replyMessage.copy(str, message);
            }

            public final String component1() {
                return this.cid;
            }

            public final Message component2() {
                return this.repliedMessage;
            }

            public final ReplyMessage copy(String str, Message message) {
                Intrinsics.checkNotNullParameter(str, "cid");
                Intrinsics.checkNotNullParameter(message, "repliedMessage");
                return new ReplyMessage(str, message);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReplyMessage)) {
                    return false;
                }
                ReplyMessage replyMessage = (ReplyMessage) obj;
                return Intrinsics.areEqual((Object) this.cid, (Object) replyMessage.cid) && Intrinsics.areEqual((Object) this.repliedMessage, (Object) replyMessage.repliedMessage);
            }

            public int hashCode() {
                String str = this.cid;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                Message message = this.repliedMessage;
                if (message != null) {
                    i = message.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "ReplyMessage(cid=" + this.cid + ", repliedMessage=" + this.repliedMessage + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReplyMessage(String str, Message message) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "cid");
                Intrinsics.checkNotNullParameter(message, "repliedMessage");
                this.cid = str;
                this.repliedMessage = message;
            }

            public final String getCid() {
                return this.cid;
            }

            public final Message getRepliedMessage() {
                return this.repliedMessage;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ReplyAttachment;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "cid", "", "repliedMessageId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCid", "()Ljava/lang/String;", "getRepliedMessageId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class ReplyAttachment extends Event {
            private final String cid;
            private final String repliedMessageId;

            public static /* synthetic */ ReplyAttachment copy$default(ReplyAttachment replyAttachment, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = replyAttachment.cid;
                }
                if ((i & 2) != 0) {
                    str2 = replyAttachment.repliedMessageId;
                }
                return replyAttachment.copy(str, str2);
            }

            public final String component1() {
                return this.cid;
            }

            public final String component2() {
                return this.repliedMessageId;
            }

            public final ReplyAttachment copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "cid");
                Intrinsics.checkNotNullParameter(str2, "repliedMessageId");
                return new ReplyAttachment(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReplyAttachment)) {
                    return false;
                }
                ReplyAttachment replyAttachment = (ReplyAttachment) obj;
                return Intrinsics.areEqual((Object) this.cid, (Object) replyAttachment.cid) && Intrinsics.areEqual((Object) this.repliedMessageId, (Object) replyAttachment.repliedMessageId);
            }

            public int hashCode() {
                String str = this.cid;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.repliedMessageId;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "ReplyAttachment(cid=" + this.cid + ", repliedMessageId=" + this.repliedMessageId + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReplyAttachment(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "cid");
                Intrinsics.checkNotNullParameter(str2, "repliedMessageId");
                this.cid = str;
                this.repliedMessageId = str2;
            }

            public final String getCid() {
                return this.cid;
            }

            public final String getRepliedMessageId() {
                return this.repliedMessageId;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$DownloadAttachment;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "(Lio/getstream/chat/android/client/models/Attachment;)V", "getAttachment", "()Lio/getstream/chat/android/client/models/Attachment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class DownloadAttachment extends Event {
            private final Attachment attachment;

            public static /* synthetic */ DownloadAttachment copy$default(DownloadAttachment downloadAttachment, Attachment attachment2, int i, Object obj) {
                if ((i & 1) != 0) {
                    attachment2 = downloadAttachment.attachment;
                }
                return downloadAttachment.copy(attachment2);
            }

            public final Attachment component1() {
                return this.attachment;
            }

            public final DownloadAttachment copy(Attachment attachment2) {
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                return new DownloadAttachment(attachment2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof DownloadAttachment) && Intrinsics.areEqual((Object) this.attachment, (Object) ((DownloadAttachment) obj).attachment);
                }
                return true;
            }

            public int hashCode() {
                Attachment attachment2 = this.attachment;
                if (attachment2 != null) {
                    return attachment2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "DownloadAttachment(attachment=" + this.attachment + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DownloadAttachment(Attachment attachment2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                this.attachment = attachment2;
            }

            public final Attachment getAttachment() {
                return this.attachment;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$AttachmentDownload;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "(Lio/getstream/chat/android/client/models/Attachment;)V", "getAttachment", "()Lio/getstream/chat/android/client/models/Attachment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        @Deprecated(message = "Deprecated class.", replaceWith = @ReplaceWith(expression = "DownloadAttachment", imports = {}))
        /* compiled from: MessageListViewModel.kt */
        public static final class AttachmentDownload extends Event {
            private final Attachment attachment;

            public static /* synthetic */ AttachmentDownload copy$default(AttachmentDownload attachmentDownload, Attachment attachment2, int i, Object obj) {
                if ((i & 1) != 0) {
                    attachment2 = attachmentDownload.attachment;
                }
                return attachmentDownload.copy(attachment2);
            }

            public final Attachment component1() {
                return this.attachment;
            }

            public final AttachmentDownload copy(Attachment attachment2) {
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                return new AttachmentDownload(attachment2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof AttachmentDownload) && Intrinsics.areEqual((Object) this.attachment, (Object) ((AttachmentDownload) obj).attachment);
                }
                return true;
            }

            public int hashCode() {
                Attachment attachment2 = this.attachment;
                if (attachment2 != null) {
                    return attachment2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "AttachmentDownload(attachment=" + this.attachment + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AttachmentDownload(Attachment attachment2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                this.attachment = attachment2;
            }

            public final Attachment getAttachment() {
                return this.attachment;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$ShowMessage;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "messageId", "", "(Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class ShowMessage extends Event {
            private final String messageId;

            public static /* synthetic */ ShowMessage copy$default(ShowMessage showMessage, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showMessage.messageId;
                }
                return showMessage.copy(str);
            }

            public final String component1() {
                return this.messageId;
            }

            public final ShowMessage copy(String str) {
                Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                return new ShowMessage(str);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ShowMessage) && Intrinsics.areEqual((Object) this.messageId, (Object) ((ShowMessage) obj).messageId);
                }
                return true;
            }

            public int hashCode() {
                String str = this.messageId;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "ShowMessage(messageId=" + this.messageId + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowMessage(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                this.messageId = str;
            }

            public final String getMessageId() {
                return this.messageId;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event$RemoveAttachment;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Event;", "messageId", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/Attachment;)V", "getAttachment", "()Lio/getstream/chat/android/client/models/Attachment;", "getMessageId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class RemoveAttachment extends Event {
            private final Attachment attachment;
            private final String messageId;

            public static /* synthetic */ RemoveAttachment copy$default(RemoveAttachment removeAttachment, String str, Attachment attachment2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = removeAttachment.messageId;
                }
                if ((i & 2) != 0) {
                    attachment2 = removeAttachment.attachment;
                }
                return removeAttachment.copy(str, attachment2);
            }

            public final String component1() {
                return this.messageId;
            }

            public final Attachment component2() {
                return this.attachment;
            }

            public final RemoveAttachment copy(String str, Attachment attachment2) {
                Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                return new RemoveAttachment(str, attachment2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RemoveAttachment)) {
                    return false;
                }
                RemoveAttachment removeAttachment = (RemoveAttachment) obj;
                return Intrinsics.areEqual((Object) this.messageId, (Object) removeAttachment.messageId) && Intrinsics.areEqual((Object) this.attachment, (Object) removeAttachment.attachment);
            }

            public int hashCode() {
                String str = this.messageId;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                Attachment attachment2 = this.attachment;
                if (attachment2 != null) {
                    i = attachment2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "RemoveAttachment(messageId=" + this.messageId + ", attachment=" + this.attachment + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RemoveAttachment(String str, Attachment attachment2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
                Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
                this.messageId = str;
                this.attachment = attachment2;
            }

            public final Attachment getAttachment() {
                return this.attachment;
            }

            public final String getMessageId() {
                return this.messageId;
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "", "()V", "Normal", "Thread", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode$Thread;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode$Normal;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListViewModel.kt */
    public static abstract class Mode {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode$Thread;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "parentMessage", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getParentMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class Thread extends Mode {
            private final Message parentMessage;

            public static /* synthetic */ Thread copy$default(Thread thread, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = thread.parentMessage;
                }
                return thread.copy(message);
            }

            public final Message component1() {
                return this.parentMessage;
            }

            public final Thread copy(Message message) {
                Intrinsics.checkNotNullParameter(message, "parentMessage");
                return new Thread(message);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Thread) && Intrinsics.areEqual((Object) this.parentMessage, (Object) ((Thread) obj).parentMessage);
                }
                return true;
            }

            public int hashCode() {
                Message message = this.parentMessage;
                if (message != null) {
                    return message.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Thread(parentMessage=" + this.parentMessage + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Thread(Message message) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(message, "parentMessage");
                this.parentMessage = message;
            }

            public final Message getParentMessage() {
                return this.parentMessage;
            }
        }

        private Mode() {
        }

        public /* synthetic */ Mode(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode$Normal;", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Mode;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListViewModel.kt */
        public static final class Normal extends Mode {
            public static final Normal INSTANCE = new Normal();

            private Normal() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel$Companion;", "", "()V", "MESSAGES_LIMIT", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
