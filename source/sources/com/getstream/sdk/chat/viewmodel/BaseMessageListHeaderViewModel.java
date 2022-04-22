package com.getstream.sdk.chat.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.livedata.ChannelData;
import p015io.getstream.chat.android.livedata.ChatDomain;
import p015io.getstream.chat.android.livedata.controller.ChannelController;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\tR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u0006&"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/BaseMessageListHeaderViewModel;", "Landroidx/lifecycle/ViewModel;", "cid", "", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/ChatDomain;)V", "_activeThread", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/Message;", "_anyOtherUsersOnline", "Landroidx/lifecycle/MediatorLiveData;", "", "_channelState", "Lio/getstream/chat/android/client/models/Channel;", "_members", "", "Lio/getstream/chat/android/client/models/Member;", "_typingUsers", "Lio/getstream/chat/android/client/models/User;", "activeThread", "Landroidx/lifecycle/LiveData;", "getActiveThread", "()Landroidx/lifecycle/LiveData;", "anyOtherUsersOnline", "getAnyOtherUsersOnline", "channelState", "getChannelState", "members", "getMembers", "online", "getOnline", "typingUsers", "getTypingUsers", "resetThread", "", "setActiveThread", "message", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseMessageListHeaderViewModel.kt */
public abstract class BaseMessageListHeaderViewModel extends ViewModel {
    private final MutableLiveData<Message> _activeThread;
    /* access modifiers changed from: private */
    public final MediatorLiveData<Boolean> _anyOtherUsersOnline;
    /* access modifiers changed from: private */
    public final MediatorLiveData<Channel> _channelState;
    /* access modifiers changed from: private */
    public final MediatorLiveData<List<Member>> _members;
    /* access modifiers changed from: private */
    public final MediatorLiveData<List<User>> _typingUsers;
    private final LiveData<Message> activeThread;
    private final LiveData<Boolean> anyOtherUsersOnline;
    private final LiveData<Channel> channelState;
    /* access modifiers changed from: private */
    public final ChatDomain chatDomain;
    private final LiveData<List<Member>> members;
    private final LiveData<Boolean> online;
    private final LiveData<List<User>> typingUsers;

    public BaseMessageListHeaderViewModel(String str, ChatDomain chatDomain2) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(chatDomain2, "chatDomain");
        this.chatDomain = chatDomain2;
        MutableLiveData<Message> mutableLiveData = new MutableLiveData<>();
        this._activeThread = mutableLiveData;
        MediatorLiveData<List<Member>> mediatorLiveData = new MediatorLiveData<>();
        this._members = mediatorLiveData;
        MediatorLiveData<Channel> mediatorLiveData2 = new MediatorLiveData<>();
        this._channelState = mediatorLiveData2;
        MediatorLiveData<Boolean> mediatorLiveData3 = new MediatorLiveData<>();
        this._anyOtherUsersOnline = mediatorLiveData3;
        MediatorLiveData<List<User>> mediatorLiveData4 = new MediatorLiveData<>();
        this._typingUsers = mediatorLiveData4;
        this.activeThread = mutableLiveData;
        this.members = mediatorLiveData;
        this.channelState = mediatorLiveData2;
        this.anyOtherUsersOnline = mediatorLiveData3;
        this.online = chatDomain2.getOnline();
        this.typingUsers = mediatorLiveData4;
        chatDomain2.getUseCases().getWatchChannel().invoke(str, 0).enqueue(new Call.Callback<ChannelController>(this) {
            final /* synthetic */ BaseMessageListHeaderViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onResult(Result<ChannelController> result) {
                Intrinsics.checkNotNullParameter(result, "channelControllerResult");
                if (result.isSuccess()) {
                    final ChannelController data = result.data();
                    this.this$0._members.addSource(data.getMembers(), new Observer<List<? extends Member>>(this) {
                        final /* synthetic */ C17511 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(List<Member> list) {
                            this.this$0.this$0._members.setValue(list);
                        }
                    });
                    this.this$0._channelState.addSource(Transformations.map(data.getChannelData(), new Function<ChannelData, Channel>() {
                        public final Channel apply(ChannelData channelData) {
                            return data.toChannel();
                        }
                    }), new Observer<Channel>(this) {
                        final /* synthetic */ C17511 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(Channel channel) {
                            this.this$0.this$0._channelState.setValue(channel);
                        }
                    });
                    this.this$0._anyOtherUsersOnline.addSource(Transformations.map(data.getMembers(), new Function<List<? extends Member>, Boolean>(this) {
                        final /* synthetic */ C17511 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final Boolean apply(List<Member> list) {
                            boolean z;
                            Intrinsics.checkNotNullExpressionValue(list, ModelFields.MEMBERS);
                            Iterator it = SequencesKt.filter(CollectionsKt.asSequence(list), new Function1<Member, Boolean>(this) {
                                final /* synthetic */ C17554 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return Boolean.valueOf(invoke((Member) obj));
                                }

                                public final boolean invoke(Member member) {
                                    Intrinsics.checkNotNullParameter(member, "it");
                                    return !Intrinsics.areEqual((Object) member.getUser(), (Object) this.this$0.this$0.this$0.chatDomain.getCurrentUser());
                                }
                            }).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((Member) it.next()).getUser().getOnline()) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            return Boolean.valueOf(z);
                        }
                    }), new Observer<Boolean>(this) {
                        final /* synthetic */ C17511 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(Boolean bool) {
                            this.this$0.this$0._anyOtherUsersOnline.setValue(bool);
                        }
                    });
                    this.this$0._typingUsers.addSource(data.getTyping(), new Observer<TypingEvent>(this) {
                        final /* synthetic */ C17511 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(TypingEvent typingEvent) {
                            this.this$0.this$0._typingUsers.setValue(typingEvent.getUsers());
                        }
                    });
                }
            }
        });
    }

    public final LiveData<Message> getActiveThread() {
        return this.activeThread;
    }

    public final LiveData<List<Member>> getMembers() {
        return this.members;
    }

    public final LiveData<Channel> getChannelState() {
        return this.channelState;
    }

    public final LiveData<Boolean> getAnyOtherUsersOnline() {
        return this.anyOtherUsersOnline;
    }

    public final LiveData<Boolean> getOnline() {
        return this.online;
    }

    public final LiveData<List<User>> getTypingUsers() {
        return this.typingUsers;
    }

    public final void setActiveThread(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this._activeThread.postValue(message);
    }

    public final void resetThread() {
        this._activeThread.postValue(null);
    }
}
