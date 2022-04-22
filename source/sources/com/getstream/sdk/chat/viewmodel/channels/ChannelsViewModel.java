package com.getstream.sdk.chat.viewmodel.channels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.ChatDomain;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsController;
import p015io.getstream.chat.android.livedata.usecase.QueryChannels;
import p015io.getstream.chat.android.livedata.usecase.QueryChannelsLoadMore;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0004()*+B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001bH\u0002J!\u0010$\u001a\u00020\u001b2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0&¢\u0006\u0002\b'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010¨\u0006,"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel;", "Landroidx/lifecycle/ViewModel;", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "limit", "", "(Lio/getstream/chat/android/livedata/ChatDomain;Lio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/api/models/QuerySort;I)V", "paginationState", "Landroidx/lifecycle/LiveData;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$PaginationState;", "getPaginationState", "()Landroidx/lifecycle/LiveData;", "paginationStateMerger", "Landroidx/lifecycle/MediatorLiveData;", "state", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "getState", "stateMerger", "typingEvents", "Lio/getstream/chat/android/client/models/TypingEvent;", "getTypingEvents", "deleteChannel", "", "channel", "hideChannel", "leaveChannel", "markAllRead", "onEvent", "event", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event;", "requestMoreChannels", "setPaginationState", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Companion", "Event", "PaginationState", "State", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsViewModel.kt */
public final class ChannelsViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final QuerySort<Channel> DEFAULT_SORT = new QuerySort().desc("last_updated", Reflection.getOrCreateKotlinClass(Channel.class));
    private final ChatDomain chatDomain;
    private final FilterObject filter;
    private final int limit;
    private final LiveData<PaginationState> paginationState;
    /* access modifiers changed from: private */
    public final MediatorLiveData<PaginationState> paginationStateMerger;
    private final QuerySort<Channel> sort;
    private final LiveData<State> state;
    /* access modifiers changed from: private */
    public final MediatorLiveData<State> stateMerger;

    public ChannelsViewModel() {
        this((ChatDomain) null, (FilterObject) null, (QuerySort) null, 0, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelsViewModel(p015io.getstream.chat.android.livedata.ChatDomain r3, p015io.getstream.chat.android.client.utils.FilterObject r4, p015io.getstream.chat.android.client.api.models.QuerySort<p015io.getstream.chat.android.client.models.Channel> r5, int r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r2 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L_0x000a
            io.getstream.chat.android.livedata.ChatDomain$Companion r3 = p015io.getstream.chat.android.livedata.ChatDomain.Companion
            io.getstream.chat.android.livedata.ChatDomain r3 = r3.instance()
        L_0x000a:
            r8 = r7 & 2
            if (r8 == 0) goto L_0x0043
            r4 = 3
            io.getstream.chat.android.client.utils.FilterObject[] r4 = new p015io.getstream.chat.android.client.utils.FilterObject[r4]
            r8 = 0
            java.lang.String r0 = "type"
            java.lang.String r1 = "messaging"
            io.getstream.chat.android.client.utils.FilterObject r0 = p015io.getstream.chat.android.client.models.Filters.m1007eq(r0, r1)
            r4[r8] = r0
            io.getstream.chat.android.client.models.User r8 = r3.getCurrentUser()
            java.lang.String r8 = r8.getId()
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r8)
            java.lang.String r0 = "members"
            io.getstream.chat.android.client.utils.FilterObject r8 = p015io.getstream.chat.android.client.models.Filters.m1008in((java.lang.String) r0, (java.util.List<?>) r8)
            r0 = 1
            r4[r0] = r8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = "draft"
            io.getstream.chat.android.client.utils.FilterObject r8 = p015io.getstream.chat.android.client.models.Filters.m1011ne(r0, r8)
            r0 = 2
            r4[r0] = r8
            io.getstream.chat.android.client.utils.FilterObject r4 = p015io.getstream.chat.android.client.models.Filters.and(r4)
        L_0x0043:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x0049
            io.getstream.chat.android.client.api.models.QuerySort<io.getstream.chat.android.client.models.Channel> r5 = DEFAULT_SORT
        L_0x0049:
            r7 = r7 & 8
            if (r7 == 0) goto L_0x004f
            r6 = 30
        L_0x004f:
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel.<init>(io.getstream.chat.android.livedata.ChatDomain, io.getstream.chat.android.client.utils.FilterObject, io.getstream.chat.android.client.api.models.QuerySort, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ChannelsViewModel(ChatDomain chatDomain2, FilterObject filterObject, QuerySort<Channel> querySort, int i) {
        Intrinsics.checkNotNullParameter(chatDomain2, "chatDomain");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        this.chatDomain = chatDomain2;
        this.filter = filterObject;
        this.sort = querySort;
        this.limit = i;
        MediatorLiveData<State> mediatorLiveData = new MediatorLiveData<>();
        this.stateMerger = mediatorLiveData;
        this.state = mediatorLiveData;
        MediatorLiveData<PaginationState> mediatorLiveData2 = new MediatorLiveData<>();
        this.paginationStateMerger = mediatorLiveData2;
        LiveData<PaginationState> distinctUntilChanged = Transformations.distinctUntilChanged(mediatorLiveData2);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinct…ed(paginationStateMerger)");
        this.paginationState = distinctUntilChanged;
        mediatorLiveData.setValue(State.Loading.INSTANCE);
        QueryChannels.DefaultImpls.invoke$default(chatDomain2.getUseCases().getQueryChannels(), filterObject, querySort, i, 0, 8, (Object) null).enqueue(new Call.Callback<QueryChannelsController>(this) {
            final /* synthetic */ ChannelsViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onResult(Result<QueryChannelsController> result) {
                Intrinsics.checkNotNullParameter(result, "queryChannelsControllerResult");
                if (result.isSuccess()) {
                    QueryChannelsController data = result.data();
                    this.this$0.stateMerger.addSource(Transformations.map(data.getChannelsState(), C17641.INSTANCE), new Observer<State>(this) {
                        final /* synthetic */ C17631 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(State state) {
                            this.this$0.this$0.stateMerger.setValue(state);
                        }
                    });
                    this.this$0.paginationStateMerger.addSource(data.getLoadingMore(), new Observer<Boolean>(this) {
                        final /* synthetic */ C17631 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(final Boolean bool) {
                            this.this$0.this$0.setPaginationState(new Function1<PaginationState, PaginationState>() {
                                public final PaginationState invoke(PaginationState paginationState) {
                                    Intrinsics.checkNotNullParameter(paginationState, "$receiver");
                                    Boolean bool = bool;
                                    Intrinsics.checkNotNullExpressionValue(bool, "loadingMore");
                                    return PaginationState.copy$default(paginationState, bool.booleanValue(), false, 2, (Object) null);
                                }
                            });
                        }
                    });
                    this.this$0.paginationStateMerger.addSource(data.getEndOfChannels(), new Observer<Boolean>(this) {
                        final /* synthetic */ C17631 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onChanged(final Boolean bool) {
                            this.this$0.this$0.setPaginationState(new Function1<PaginationState, PaginationState>() {
                                public final PaginationState invoke(PaginationState paginationState) {
                                    Intrinsics.checkNotNullParameter(paginationState, "$receiver");
                                    Boolean bool = bool;
                                    Intrinsics.checkNotNullExpressionValue(bool, "endOfChannels");
                                    return PaginationState.copy$default(paginationState, false, bool.booleanValue(), 1, (Object) null);
                                }
                            });
                        }
                    });
                    return;
                }
                this.this$0.stateMerger.postValue(State.NoChannelsAvailable.INSTANCE);
            }
        });
    }

    public final LiveData<State> getState() {
        return this.state;
    }

    public final LiveData<TypingEvent> getTypingEvents() {
        return this.chatDomain.getTypingUpdates();
    }

    public final LiveData<PaginationState> getPaginationState() {
        return this.paginationState;
    }

    public final void onEvent(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof Event.ReachedEndOfList) {
            requestMoreChannels();
            Unit unit = Unit.INSTANCE;
        } else if (event instanceof Event.LogoutClicked) {
            ChatClient.Companion.instance().disconnect();
            this.stateMerger.postValue(State.NavigateToLoginScreen.INSTANCE);
            Unit unit2 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void leaveChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.chatDomain.getUseCases().getLeaveChannel().invoke(channel.getCid()).enqueue();
    }

    public final void deleteChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.chatDomain.getUseCases().getDeleteChannel().invoke(channel.getCid()).enqueue();
    }

    public final void hideChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.chatDomain.getUseCases().getHideChannel().invoke(channel.getCid(), true).enqueue();
    }

    public final void markAllRead() {
        this.chatDomain.getUseCases().getMarkAllRead().invoke().enqueue();
    }

    private final void requestMoreChannels() {
        QueryChannelsLoadMore.DefaultImpls.invoke$default(this.chatDomain.getUseCases().getQueryChannelsLoadMore(), this.filter, this.sort, 0, 0, 12, (Object) null).enqueue();
    }

    /* access modifiers changed from: private */
    public final void setPaginationState(Function1<? super PaginationState, PaginationState> function1) {
        MediatorLiveData<PaginationState> mediatorLiveData = this.paginationStateMerger;
        PaginationState value = mediatorLiveData.getValue();
        if (value == null) {
            value = new PaginationState(false, false, 3, (DefaultConstructorMarker) null);
        }
        Intrinsics.checkNotNullExpressionValue(value, "paginationStateMerger.value ?: PaginationState()");
        mediatorLiveData.setValue(function1.invoke(value));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "", "()V", "Loading", "NavigateToLoginScreen", "NoChannelsAvailable", "Result", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$Result;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$NoChannelsAvailable;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$NavigateToLoginScreen;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelsViewModel.kt */
    public static abstract class State {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$Loading;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
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

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$Result;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "channels", "", "Lio/getstream/chat/android/client/models/Channel;", "(Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
        public static final class Result extends State {
            private final List<Channel> channels;

            public static /* synthetic */ Result copy$default(Result result, List<Channel> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = result.channels;
                }
                return result.copy(list);
            }

            public final List<Channel> component1() {
                return this.channels;
            }

            public final Result copy(List<Channel> list) {
                Intrinsics.checkNotNullParameter(list, "channels");
                return new Result(list);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Result) && Intrinsics.areEqual((Object) this.channels, (Object) ((Result) obj).channels);
                }
                return true;
            }

            public int hashCode() {
                List<Channel> list = this.channels;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Result(channels=" + this.channels + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Result(List<Channel> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "channels");
                this.channels = list;
            }

            public final List<Channel> getChannels() {
                return this.channels;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$NoChannelsAvailable;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
        public static final class NoChannelsAvailable extends State {
            public static final NoChannelsAvailable INSTANCE = new NoChannelsAvailable();

            private NoChannelsAvailable() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State$NavigateToLoginScreen;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$State;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
        public static final class NavigateToLoginScreen extends State {
            public static final NavigateToLoginScreen INSTANCE = new NavigateToLoginScreen();

            private NavigateToLoginScreen() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$PaginationState;", "", "loadingMore", "", "endOfChannels", "(ZZ)V", "getEndOfChannels", "()Z", "getLoadingMore", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelsViewModel.kt */
    public static final class PaginationState {
        private final boolean endOfChannels;
        private final boolean loadingMore;

        public PaginationState() {
            this(false, false, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaginationState copy$default(PaginationState paginationState, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = paginationState.loadingMore;
            }
            if ((i & 2) != 0) {
                z2 = paginationState.endOfChannels;
            }
            return paginationState.copy(z, z2);
        }

        public final boolean component1() {
            return this.loadingMore;
        }

        public final boolean component2() {
            return this.endOfChannels;
        }

        public final PaginationState copy(boolean z, boolean z2) {
            return new PaginationState(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaginationState)) {
                return false;
            }
            PaginationState paginationState = (PaginationState) obj;
            return this.loadingMore == paginationState.loadingMore && this.endOfChannels == paginationState.endOfChannels;
        }

        public int hashCode() {
            boolean z = this.loadingMore;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            boolean z3 = this.endOfChannels;
            if (!z3) {
                z2 = z3;
            }
            return i + (z2 ? 1 : 0);
        }

        public String toString() {
            return "PaginationState(loadingMore=" + this.loadingMore + ", endOfChannels=" + this.endOfChannels + ")";
        }

        public PaginationState(boolean z, boolean z2) {
            this.loadingMore = z;
            this.endOfChannels = z2;
        }

        public final boolean getLoadingMore() {
            return this.loadingMore;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaginationState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean getEndOfChannels() {
            return this.endOfChannels;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event;", "", "()V", "LogoutClicked", "ReachedEndOfList", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event$ReachedEndOfList;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event$LogoutClicked;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelsViewModel.kt */
    public static abstract class Event {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event$ReachedEndOfList;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
        public static final class ReachedEndOfList extends Event {
            public static final ReachedEndOfList INSTANCE = new ReachedEndOfList();

            private ReachedEndOfList() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event$LogoutClicked;", "Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Event;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ChannelsViewModel.kt */
        public static final class LogoutClicked extends Event {
            public static final LogoutClicked INSTANCE = new LogoutClicked();

            private LogoutClicked() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/channels/ChannelsViewModel$Companion;", "", "()V", "DEFAULT_SORT", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        QuerySort.Companion companion = QuerySort.Companion;
    }
}
