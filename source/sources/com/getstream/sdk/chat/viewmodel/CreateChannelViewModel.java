package com.getstream.sdk.chat.viewmodel;

import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import editor.editor.equipment.core.CoreConfig;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel;", "Landroidx/lifecycle/ViewModel;", "domain", "Lio/getstream/chat/android/livedata/ChatDomain;", "client", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/livedata/ChatDomain;Lio/getstream/chat/android/client/ChatClient;)V", "state", "Landroidx/lifecycle/LiveData;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "getState", "()Landroidx/lifecycle/LiveData;", "stateMerger", "Landroidx/lifecycle/MediatorLiveData;", "onEvent", "", "event", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$Event;", "queryChannel", "channelName", "", "validateChannelName", "", "channelNameCandidate", "Event", "State", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CreateChannelViewModel.kt */
public final class CreateChannelViewModel extends ViewModel {
    private final ChatClient client;
    /* access modifiers changed from: private */
    public final ChatDomain domain;
    private final LiveData<State> state;
    /* access modifiers changed from: private */
    public final MediatorLiveData<State> stateMerger;

    public CreateChannelViewModel() {
        this((ChatDomain) null, (ChatClient) null, 3, (DefaultConstructorMarker) null);
    }

    public CreateChannelViewModel(ChatDomain chatDomain) {
        this(chatDomain, (ChatClient) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateChannelViewModel(ChatDomain chatDomain, ChatClient chatClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ChatDomain.Companion.instance() : chatDomain, (i & 2) != 0 ? ChatClient.Companion.instance() : chatClient);
    }

    public CreateChannelViewModel(ChatDomain chatDomain, ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatDomain, "domain");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        this.domain = chatDomain;
        this.client = chatClient;
        MediatorLiveData<State> mediatorLiveData = new MediatorLiveData<>();
        this.stateMerger = mediatorLiveData;
        this.state = mediatorLiveData;
    }

    public final LiveData<State> getState() {
        return this.state;
    }

    public final void onEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof Event.ChannelNameSubmitted) {
            String replace = new Regex(StringUtils.SPACE).replace((CharSequence) ((Event.ChannelNameSubmitted) event).getChannelName(), CoreConfig.ENTITY_TOKEN_PREFIX);
            Objects.requireNonNull(replace, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = replace.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (validateChannelName(lowerCase)) {
                this.stateMerger.postValue(State.Loading.INSTANCE);
                queryChannel(lowerCase);
                return;
            }
            this.stateMerger.postValue(State.ValidationError.INSTANCE);
        }
    }

    private final void queryChannel(String str) {
        String str2 = str;
        User currentUser = this.client.getCurrentUser();
        if (currentUser == null) {
            currentUser = new User((String) null, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65535, (DefaultConstructorMarker) null);
        }
        List listOf = CollectionsKt.listOf(new Member(currentUser, (String) null, (Date) null, (Date) null, (Boolean) null, (Date) null, (Date) null, false, 254, (DefaultConstructorMarker) null));
        Channel channel = r4;
        Channel channel2 = new Channel((String) null, (String) null, (String) null, 0, false, (Date) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, 0, (List) null, (List) null, (List) null, (List) null, (Config) null, (User) null, (Integer) null, (String) null, (Map) null, (Boolean) null, (Date) null, 0, (List) null, ViewCompat.MEASURED_SIZE_MASK, (DefaultConstructorMarker) null);
        Channel channel3 = channel;
        channel3.setCid("messaging:" + str2);
        channel3.setId(str2);
        channel3.setType("messaging");
        ContentUtils.setName(channel3, str2);
        channel3.setMembers(listOf);
        channel3.setCreatedBy(currentUser);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), DispatcherProvider.INSTANCE.getIO(), (CoroutineStart) null, new CreateChannelViewModel$queryChannel$1(this, channel3, (Continuation) null), 2, (Object) null);
    }

    private final boolean validateChannelName(String str) {
        CharSequence charSequence = str;
        return (charSequence.length() > 0) && CreateChannelViewModelKt.CHANNEL_NAME_REGEX.matches(charSequence);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "", "()V", "BackendError", "ChannelCreated", "Loading", "ValidationError", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$ChannelCreated;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$BackendError;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$ValidationError;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CreateChannelViewModel.kt */
    public static abstract class State {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelViewModel.kt */
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

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$ChannelCreated;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelViewModel.kt */
        public static final class ChannelCreated extends State {
            public static final ChannelCreated INSTANCE = new ChannelCreated();

            private ChannelCreated() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$BackendError;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelViewModel.kt */
        public static final class BackendError extends State {
            public static final BackendError INSTANCE = new BackendError();

            private BackendError() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State$ValidationError;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelViewModel.kt */
        public static final class ValidationError extends State {
            public static final ValidationError INSTANCE = new ValidationError();

            private ValidationError() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$Event;", "", "()V", "ChannelNameSubmitted", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$Event$ChannelNameSubmitted;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CreateChannelViewModel.kt */
    public static abstract class Event {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$Event$ChannelNameSubmitted;", "Lcom/getstream/sdk/chat/viewmodel/CreateChannelViewModel$Event;", "channelName", "", "(Ljava/lang/String;)V", "getChannelName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelViewModel.kt */
        public static final class ChannelNameSubmitted extends Event {
            private final String channelName;

            public static /* synthetic */ ChannelNameSubmitted copy$default(ChannelNameSubmitted channelNameSubmitted, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = channelNameSubmitted.channelName;
                }
                return channelNameSubmitted.copy(str);
            }

            public final String component1() {
                return this.channelName;
            }

            public final ChannelNameSubmitted copy(String str) {
                Intrinsics.checkNotNullParameter(str, "channelName");
                return new ChannelNameSubmitted(str);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ChannelNameSubmitted) && Intrinsics.areEqual((Object) this.channelName, (Object) ((ChannelNameSubmitted) obj).channelName);
                }
                return true;
            }

            public int hashCode() {
                String str = this.channelName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "ChannelNameSubmitted(channelName=" + this.channelName + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelNameSubmitted(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "channelName");
                this.channelName = str;
            }

            public final String getChannelName() {
                return this.channelName;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
