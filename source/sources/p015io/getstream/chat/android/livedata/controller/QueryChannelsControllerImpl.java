package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsController;
import p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u001e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001b\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0016\u0010A\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\u001b\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020EH@ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ!\u0010H\u001a\u00020=2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020E0\u0018H@ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ1\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010QJ$\u0010R\u001a\u00020S2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020O2\b\b\u0002\u0010T\u001a\u00020OJ;\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020O2\b\b\u0002\u0010T\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020=H\u0002J\u000e\u0010X\u001a\u00020=2\u0006\u0010Y\u001a\u00020\u000fJ\u0016\u0010Z\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\u001b\u0010[\u001a\u00020=2\u0006\u0010\\\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b]\u0010^J%\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180M2\u0006\u0010`\u001a\u00020SH@ø\u0001\u0000¢\u0006\u0002\u0010aJ!\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00182\u0006\u0010`\u001a\u00020SH@ø\u0001\u0000¢\u0006\u0002\u0010aJ%\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180M2\u0006\u0010`\u001a\u00020SH@ø\u0001\u0000¢\u0006\u0002\u0010aJ\u0016\u0010d\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J+\u0010e\u001a\u00020=2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00182\u0006\u0010f\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ\u001e\u0010i\u001a\u00020=2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060j2\u0006\u0010f\u001a\u00020\u0014H\u0002R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u0011X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R,\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u0002\u0004\n\u0002\b\u0019¨\u0006k"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsControllerImpl;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "client", "Lio/getstream/chat/android/client/ChatClient;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/api/models/QuerySort;Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "_channels", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "_channelsState", "Lkotlinx/coroutines/flow/StateFlow;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "_endOfChannels", "", "_loading", "_loadingMore", "_sortedChannels", "", "channels", "Landroidx/lifecycle/LiveData;", "getChannels", "()Landroidx/lifecycle/LiveData;", "setChannels", "(Landroidx/lifecycle/LiveData;)V", "channelsState", "getChannelsState", "endOfChannels", "getEndOfChannels", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "loading", "getLoading", "loadingMore", "getLoadingMore", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "newChannelEventFilter", "Lkotlin/Function2;", "getNewChannelEventFilter", "()Lkotlin/jvm/functions/Function2;", "setNewChannelEventFilter", "(Lkotlin/jvm/functions/Function2;)V", "queryChannelsSpec", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "getQueryChannelsSpec", "()Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "recoveryNeeded", "getRecoveryNeeded", "()Z", "setRecoveryNeeded", "(Z)V", "getSort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "addChannelIfFilterMatches", "", "channel", "addChannelIfFilterMatches$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToQueryResult", "cIds", "handleEvent", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "handleEvent$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/events/ChatEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEvents", "events", "handleEvents$stream_chat_android_offline_release", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMore", "Lio/getstream/chat/android/client/utils/Result;", "channelLimit", "", "messageLimit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMoreRequest", "Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;", "memberLimit", "query", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshAllChannels", "refreshChannel", "cId", "refreshChannels", "removeChannel", "cid", "removeChannel$stream_chat_android_offline_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runQuery", "pagination", "(Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runQueryOffline", "runQueryOnline", "setQueryResult", "updateChannelsAndQueryResults", "isFirstPage", "updateChannelsAndQueryResults$stream_chat_android_offline_release", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQueryChannelsSpec", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl */
/* compiled from: QueryChannelsControllerImpl.kt */
public final class QueryChannelsControllerImpl implements QueryChannelsController {
    private final MutableStateFlow<Map<String, Channel>> _channels;
    private final StateFlow<QueryChannelsController.ChannelsState> _channelsState;
    private final MutableStateFlow<Boolean> _endOfChannels;
    private final MutableStateFlow<Boolean> _loading;
    private final MutableStateFlow<Boolean> _loadingMore;
    private final StateFlow<List<Channel>> _sortedChannels;
    private LiveData<List<Channel>> channels;
    private final LiveData<QueryChannelsController.ChannelsState> channelsState;
    private final ChatClient client;
    private final ChatDomainImpl domainImpl;
    private final LiveData<Boolean> endOfChannels;
    private final FilterObject filter;
    private final LiveData<Boolean> loading;
    private final LiveData<Boolean> loadingMore;
    private final TaggedLogger logger;
    private Function2<? super Channel, ? super FilterObject, Boolean> newChannelEventFilter = QueryChannelsControllerImpl$newChannelEventFilter$1.INSTANCE;
    private final QueryChannelsSpec queryChannelsSpec = new QueryChannelsSpec(getFilter(), getSort(), (List) null, 4, (DefaultConstructorMarker) null);
    private boolean recoveryNeeded;
    private final QuerySort<Channel> sort;

    public QueryChannelsControllerImpl(FilterObject filterObject, QuerySort<Channel> querySort, ChatClient chatClient, ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.filter = filterObject;
        this.sort = querySort;
        this.client = chatClient;
        this.domainImpl = chatDomainImpl;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._endOfChannels = MutableStateFlow;
        this.endOfChannels = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow, (CoroutineContext) null, 0, 3, (Object) null);
        MutableStateFlow<Map<String, Channel>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._channels = MutableStateFlow2;
        StateFlow<List<Channel>> stateIn = FlowKt.stateIn(new QueryChannelsControllerImpl$$special$$inlined$map$1(FlowKt.filterNotNull(MutableStateFlow2), this), chatDomainImpl.getScope$stream_chat_android_offline_release(), SharingStarted.Companion.getEagerly(), CollectionsKt.emptyList());
        this._sortedChannels = stateIn;
        this.channels = FlowLiveDataConversions.asLiveData$default((Flow) stateIn, (CoroutineContext) null, 0, 3, (Object) null);
        this.logger = ChatLogger.Companion.get("ChatDomain QueryChannelsController");
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._loading = MutableStateFlow3;
        this.loading = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow3, (CoroutineContext) null, 0, 3, (Object) null);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._loadingMore = MutableStateFlow4;
        this.loadingMore = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow4, (CoroutineContext) null, 0, 3, (Object) null);
        StateFlow<QueryChannelsController.ChannelsState> stateIn2 = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow3, stateIn, new QueryChannelsControllerImpl$_channelsState$1((Continuation) null)), chatDomainImpl.getScope$stream_chat_android_offline_release(), SharingStarted.Companion.getEagerly(), QueryChannelsController.ChannelsState.NoQueryActive.INSTANCE);
        this._channelsState = stateIn2;
        this.channelsState = FlowLiveDataConversions.asLiveData$default((Flow) stateIn2, (CoroutineContext) null, 0, 3, (Object) null);
    }

    public FilterObject getFilter() {
        return this.filter;
    }

    public QuerySort<Channel> getSort() {
        return this.sort;
    }

    public Function2<Channel, FilterObject, Boolean> getNewChannelEventFilter() {
        return this.newChannelEventFilter;
    }

    public void setNewChannelEventFilter(Function2<? super Channel, ? super FilterObject, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.newChannelEventFilter = function2;
    }

    public boolean getRecoveryNeeded() {
        return this.recoveryNeeded;
    }

    public void setRecoveryNeeded(boolean z) {
        this.recoveryNeeded = z;
    }

    public final QueryChannelsSpec getQueryChannelsSpec() {
        return this.queryChannelsSpec;
    }

    public LiveData<Boolean> getEndOfChannels() {
        return this.endOfChannels;
    }

    public LiveData<List<Channel>> getChannels() {
        return this.channels;
    }

    public void setChannels(LiveData<List<Channel>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.channels = liveData;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public LiveData<Boolean> getLoadingMore() {
        return this.loadingMore;
    }

    public LiveData<QueryChannelsController.ChannelsState> getChannelsState() {
        return this.channelsState;
    }

    public static /* synthetic */ QueryChannelsPaginationRequest loadMoreRequest$default(QueryChannelsControllerImpl queryChannelsControllerImpl, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 30;
        }
        if ((i4 & 2) != 0) {
            i2 = 10;
        }
        if ((i4 & 4) != 0) {
            i3 = 30;
        }
        return queryChannelsControllerImpl.loadMoreRequest(i, i2, i3);
    }

    public final QueryChannelsPaginationRequest loadMoreRequest(int i, int i2, int i3) {
        return new QueryChannelsPaginationRequest(getSort(), this._channels.getValue().size(), i, i2, i3);
    }

    public final Object addChannelIfFilterMatches$stream_chat_android_offline_release(Channel channel, Continuation<? super Unit> continuation) {
        if (getNewChannelEventFilter().invoke(channel, getFilter()).booleanValue()) {
            this.domainImpl.channel$stream_chat_android_offline_release(channel).updateLiveDataFromChannel(channel);
            addToQueryResult(CollectionsKt.listOf(channel.getCid()));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleEvents$stream_chat_android_offline_release(java.util.List<? extends p015io.getstream.chat.android.client.events.ChatEvent> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvents$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvents$1 r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvents$1 r0 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvents$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Iterator r5 = r5.iterator()
            r2 = r4
        L_0x0042:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005b
            java.lang.Object r6 = r5.next()
            io.getstream.chat.android.client.events.ChatEvent r6 = (p015io.getstream.chat.android.client.events.ChatEvent) r6
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.handleEvent$stream_chat_android_offline_release(r6, r0)
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x005b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.handleEvents$stream_chat_android_offline_release(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleEvent$stream_chat_android_offline_release(p015io.getstream.chat.android.client.events.ChatEvent r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$1 r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$1 r0 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r8 = r0.L$1
            io.getstream.chat.android.client.events.ChatEvent r8 = (p015io.getstream.chat.android.client.events.ChatEvent) r8
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0056
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8 instanceof p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent
            if (r9 == 0) goto L_0x0055
            r9 = r8
            io.getstream.chat.android.client.events.NotificationAddedToChannelEvent r9 = (p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r7.addChannelIfFilterMatches$stream_chat_android_offline_release(r9, r0)
            if (r9 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r0 = r7
        L_0x0056:
            boolean r9 = r8 instanceof p015io.getstream.chat.android.client.events.MarkAllReadEvent
            if (r9 == 0) goto L_0x005d
            r0.refreshAllChannels()
        L_0x005d:
            boolean r9 = r8 instanceof p015io.getstream.chat.android.client.events.CidEvent
            if (r9 == 0) goto L_0x009a
            boolean r9 = r8 instanceof p015io.getstream.chat.android.client.events.UserStartWatchingEvent
            if (r9 != 0) goto L_0x0097
            boolean r9 = r8 instanceof p015io.getstream.chat.android.client.events.UserStopWatchingEvent
            if (r9 == 0) goto L_0x006a
            goto L_0x0097
        L_0x006a:
            io.getstream.chat.android.client.logger.TaggedLogger r9 = r0.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "received channel event "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r9.logI(r1)
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r0.domainImpl
            kotlinx.coroutines.CoroutineScope r1 = r9.getScope$stream_chat_android_offline_release()
            r2 = 0
            r3 = 0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$2 r9 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$handleEvent$2
            r4 = 0
            r9.<init>(r0, r8, r4)
            r4 = r9
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
            goto L_0x009a
        L_0x0097:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x009a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.handleEvent$stream_chat_android_offline_release(io.getstream.chat.android.client.events.ChatEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object loadMore$default(QueryChannelsControllerImpl queryChannelsControllerImpl, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 30;
        }
        if ((i3 & 2) != 0) {
            i2 = 10;
        }
        return queryChannelsControllerImpl.loadMore(i, i2, continuation);
    }

    public final Object loadMore(int i, int i2, Continuation<? super Result<List<Channel>>> continuation) {
        return runQuery(loadMoreRequest$default(this, i, i2, 0, 4, (Object) null), continuation);
    }

    public static /* synthetic */ Object query$default(QueryChannelsControllerImpl queryChannelsControllerImpl, int i, int i2, int i3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 30;
        }
        if ((i4 & 2) != 0) {
            i2 = 10;
        }
        if ((i4 & 4) != 0) {
            i3 = 30;
        }
        return queryChannelsControllerImpl.query(i, i2, i3, continuation);
    }

    public final Object query(int i, int i2, int i3, Continuation<? super Result<List<Channel>>> continuation) {
        return runQuery(new QueryChannelsPaginationRequest(getSort(), 0, i, i2, i3), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runQueryOffline(p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r8, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOffline$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOffline$1 r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOffline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOffline$1 r0 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOffline$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r8 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0082
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$1
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r8 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r8
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r9
            r9 = r8
            r8 = r2
            r2 = r6
            goto L_0x0064
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r9)
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r9.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r2 = r7.queryChannelsSpec
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.selectQueryChannels(r2, r0)
            if (r9 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r2 = r9
            r9 = r8
            r8 = r7
        L_0x0064:
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r2 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec) r2
            r4 = 0
            if (r2 == 0) goto L_0x00a5
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r8.domainImpl
            java.util.List r2 = r2.getCids()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r0.L$0 = r8
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r9 = r5.selectAndEnrichChannels((java.util.List<java.lang.String>) r2, (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r9, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>>) r0)
            if (r9 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r0 = r9
            java.util.List r0 = (java.util.List) r0
            io.getstream.chat.android.client.logger.TaggedLogger r8 = r8.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "found "
            r1.append(r2)
            int r0 = r0.size()
            r1.append(r0)
            java.lang.String r0 = " channels in offline storage"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.logI(r0)
            return r9
        L_0x00a5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.runQueryOffline(io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0136 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runQueryOnline(p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r13, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.Channel>>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1 r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1 r0 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0064
            if (r2 == r6) goto L_0x004f
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x014c
        L_0x0036:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003e:
            java.lang.Object r13 = r0.L$2
            java.util.Set r13 = (java.util.Set) r13
            java.lang.Object r2 = r0.L$1
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0138
        L_0x004f:
            java.lang.Object r13 = r0.L$3
            java.util.Set r13 = (java.util.Set) r13
            java.lang.Object r2 = r0.L$2
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            java.lang.Object r6 = r0.L$1
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r6 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r6
            java.lang.Object r7 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r7 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r7
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f5
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r14)
            io.getstream.chat.android.client.utils.FilterObject r14 = r12.getFilter()
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r12.domainImpl
            boolean r2 = r2.getUserPresence()
            io.getstream.chat.android.client.api.models.QueryChannelsRequest r14 = p015io.getstream.chat.android.livedata.request.MapperKt.toQueryChannelsRequest(r13, r14, r2)
            io.getstream.chat.android.client.ChatClient r2 = r12.client
            io.getstream.chat.android.client.call.Call r14 = r2.queryChannels(r14)
            io.getstream.chat.android.client.utils.Result r2 = r14.execute()
            boolean r14 = r2.isSuccess()
            if (r14 == 0) goto L_0x014e
            r14 = 0
            r12.setRecoveryNeeded(r14)
            java.lang.Object r14 = r2.data()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Set r14 = kotlin.collections.CollectionsKt.toSet(r14)
            int r7 = r14.size()
            int r8 = r13.getChannelLimit()
            if (r7 >= r8) goto L_0x00a6
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r7 = r12._endOfChannels
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            r7.setValue(r8)
        L_0x00a6:
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r9)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ba:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00d7
            java.lang.Object r9 = r7.next()
            io.getstream.chat.android.client.models.Channel r9 = (p015io.getstream.chat.android.client.models.Channel) r9
            io.getstream.chat.android.livedata.model.ChannelConfig r10 = new io.getstream.chat.android.livedata.model.ChannelConfig
            java.lang.String r11 = r9.getType()
            io.getstream.chat.android.client.models.Config r9 = r9.getConfig()
            r10.<init>(r11, r9)
            r8.add(r10)
            goto L_0x00ba
        L_0x00d7:
            java.util.List r8 = (java.util.List) r8
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r12.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            java.util.Collection r8 = (java.util.Collection) r8
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r2
            r0.L$3 = r14
            r0.label = r6
            java.lang.Object r6 = r7.insertChannelConfigs(r8, r0)
            if (r6 != r1) goto L_0x00f2
            return r1
        L_0x00f2:
            r7 = r12
            r6 = r13
            r13 = r14
        L_0x00f5:
            io.getstream.chat.android.client.logger.TaggedLogger r14 = r7.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "api call returned "
            r8.append(r9)
            int r9 = r13.size()
            r8.append(r9)
            java.lang.String r9 = " channels"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r14.logI(r8)
            r14 = r13
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r6 = r6.isFirstPage()
            r7.updateQueryChannelsSpec(r14, r6)
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r14 = r14.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r6 = r7.queryChannelsSpec
            r0.L$0 = r7
            r0.L$1 = r2
            r0.L$2 = r13
            r0.L$3 = r5
            r0.label = r4
            java.lang.Object r14 = r14.insertQueryChannels(r6, r0)
            if (r14 != r1) goto L_0x0137
            return r1
        L_0x0137:
            r4 = r7
        L_0x0138:
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r4.domainImpl
            java.util.Collection r13 = (java.util.Collection) r13
            r0.L$0 = r2
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r13 = r14.storeStateForChannels(r13, r0)
            if (r13 != r1) goto L_0x014b
            return r1
        L_0x014b:
            r13 = r2
        L_0x014c:
            r2 = r13
            goto L_0x0179
        L_0x014e:
            io.getstream.chat.android.client.logger.TaggedLogger r13 = r12.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Query with filter "
            r14.append(r0)
            io.getstream.chat.android.client.utils.FilterObject r0 = r12.getFilter()
            r14.append(r0)
            java.lang.String r0 = " failed, marking it as recovery needed"
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            r13.logI(r14)
            r12.setRecoveryNeeded(r6)
            io.getstream.chat.android.livedata.ChatDomainImpl r13 = r12.domainImpl
            io.getstream.chat.android.client.errors.ChatError r14 = r2.error()
            r13.addError(r14)
        L_0x0179:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.runQueryOnline(io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateQueryChannelsSpec(Collection<Channel> collection, boolean z) {
        Iterable<Channel> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Channel cid : iterable) {
            arrayList.add(cid.getCid());
        }
        List list = (List) arrayList;
        QueryChannelsSpec queryChannelsSpec2 = this.queryChannelsSpec;
        if (!z) {
            list = CollectionsKt.distinct(CollectionsKt.plus(queryChannelsSpec2.getCids(), list));
        }
        queryChannelsSpec2.setCids(list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0153 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runQuery(p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r19, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.Channel>>> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$1 r3 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$1 r3 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x0096
            if (r5 == r9) goto L_0x007d
            if (r5 == r8) goto L_0x0060
            if (r5 == r7) goto L_0x004b
            if (r5 != r6) goto L_0x0043
            java.lang.Object r1 = r3.L$1
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.flow.MutableStateFlow r3 = (kotlinx.coroutines.flow.MutableStateFlow) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x017b
        L_0x0043:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004b:
            java.lang.Object r1 = r3.L$3
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$2
            kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
            java.lang.Object r7 = r3.L$1
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r7 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r7
            java.lang.Object r8 = r3.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r8 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r8
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0156
        L_0x0060:
            java.lang.Object r1 = r3.L$5
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$4
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r8 = r3.L$3
            kotlinx.coroutines.Deferred r8 = (kotlinx.coroutines.Deferred) r8
            java.lang.Object r9 = r3.L$2
            kotlinx.coroutines.flow.MutableStateFlow r9 = (kotlinx.coroutines.flow.MutableStateFlow) r9
            java.lang.Object r11 = r3.L$1
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r11 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r11
            java.lang.Object r12 = r3.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r12 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x012c
        L_0x007d:
            java.lang.Object r1 = r3.L$3
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            java.lang.Object r5 = r3.L$2
            kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
            java.lang.Object r9 = r3.L$1
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r9 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r9
            java.lang.Object r11 = r3.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r11 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r11
            r11 = r1
            r1 = r9
            r9 = r5
            goto L_0x010b
        L_0x0096:
            kotlin.ResultKt.throwOnFailure(r2)
            boolean r2 = r19.isFirstPage()
            if (r2 == 0) goto L_0x00a2
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._loading
            goto L_0x00a4
        L_0x00a2:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._loadingMore
        L_0x00a4:
            java.lang.Object r5 = r2.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00c2
            io.getstream.chat.android.client.logger.TaggedLogger r1 = r0.logger
            java.lang.String r2 = "Another query channels request is in progress. Ignoring this request."
            r1.logI(r2)
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r3 = new io.getstream.chat.android.client.errors.ChatError
            r3.<init>(r2, r10, r8, r10)
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r3)
            return r1
        L_0x00c2:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            r2.setValue(r5)
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.domainImpl
            kotlinx.coroutines.CoroutineScope r11 = r5.getScope$stream_chat_android_offline_release()
            r12 = 0
            r13 = 0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOfflineJob$1 r5 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOfflineJob$1
            r5.<init>(r0, r1, r10)
            r14 = r5
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 3
            r16 = 0
            kotlinx.coroutines.Deferred r5 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r11, r12, r13, r14, r15, r16)
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r0.domainImpl
            kotlinx.coroutines.CoroutineScope r12 = r11.getScope$stream_chat_android_offline_release()
            r14 = 0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOnlineJob$1 r11 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOnlineJob$1
            r11.<init>(r0, r1, r10)
            r15 = r11
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r16 = 3
            r17 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r12, r13, r14, r15, r16, r17)
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r11
            r3.label = r9
            java.lang.Object r5 = r5.await(r3)
            if (r5 != r4) goto L_0x0108
            return r4
        L_0x0108:
            r12 = r0
            r9 = r2
            r2 = r5
        L_0x010b:
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x013b
            boolean r5 = r1.isFirstPage()
            r3.L$0 = r12
            r3.L$1 = r1
            r3.L$2 = r9
            r3.L$3 = r11
            r3.L$4 = r2
            r3.L$5 = r2
            r3.label = r8
            java.lang.Object r5 = r12.mo69295x48a9403b(r2, r5, r3)
            if (r5 != r4) goto L_0x0128
            return r4
        L_0x0128:
            r5 = r2
            r8 = r11
            r11 = r1
            r1 = r5
        L_0x012c:
            boolean r1 = r1.isEmpty()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r9.setValue(r1)
            r1 = r5
            r2 = r8
            r8 = r12
            goto L_0x013f
        L_0x013b:
            r2 = r11
            r8 = r12
            r11 = r1
            r1 = r10
        L_0x013f:
            r3.L$0 = r8
            r3.L$1 = r11
            r3.L$2 = r9
            r3.L$3 = r1
            r3.L$4 = r10
            r3.L$5 = r10
            r3.label = r7
            java.lang.Object r2 = r2.await(r3)
            if (r2 != r4) goto L_0x0154
            return r4
        L_0x0154:
            r5 = r9
            r7 = r11
        L_0x0156:
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            boolean r9 = r2.isSuccess()
            if (r9 == 0) goto L_0x017d
            java.lang.Object r1 = r2.data()
            java.util.List r1 = (java.util.List) r1
            boolean r7 = r7.isFirstPage()
            r3.L$0 = r5
            r3.L$1 = r2
            r3.L$2 = r10
            r3.L$3 = r10
            r3.label = r6
            java.lang.Object r1 = r8.mo69295x48a9403b(r1, r7, r3)
            if (r1 != r4) goto L_0x0179
            return r4
        L_0x0179:
            r1 = r2
            r3 = r5
        L_0x017b:
            r5 = r3
            goto L_0x0185
        L_0x017d:
            if (r1 == 0) goto L_0x0184
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            r2.<init>(r1)
        L_0x0184:
            r1 = r2
        L_0x0185:
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r5.setValue(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.runQuery(io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: updateChannelsAndQueryResults$stream_chat_android_offline_release */
    public final Object mo69295x48a9403b(List<Channel> list, boolean z, Continuation<? super Unit> continuation) {
        if (list != null) {
            Iterable<Channel> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Channel cid : iterable) {
                arrayList.add(cid.getCid());
            }
            List list2 = (List) arrayList;
            for (Channel next : list) {
                this.domainImpl.channel$stream_chat_android_offline_release(next).updateLiveDataFromChannel(next);
            }
            if (z) {
                setQueryResult(list2);
            } else {
                addToQueryResult(list2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeChannel$stream_chat_android_offline_release(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1 r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1 r0 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0091
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007d
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r7 = r5.queryChannelsSpec
            java.util.List r7 = r7.getCids()
            boolean r7 = r7.contains(r6)
            if (r7 == 0) goto L_0x00a0
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r7 = r5.queryChannelsSpec
            java.util.List r2 = r7.getCids()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.minus(r2, r6)
            r7.setCids(r2)
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r2 = r5.queryChannelsSpec
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.insertQueryChannels(r2, r0)
            if (r7 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r2 = r5
        L_0x007d:
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r2.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r7.deleteChannel(r6, r0)
            if (r7 != r1) goto L_0x0090
            return r1
        L_0x0090:
            r0 = r2
        L_0x0091:
            kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, io.getstream.chat.android.client.models.Channel>> r7 = r0._channels
            java.lang.Object r0 = r7.getValue()
            java.util.Map r0 = (java.util.Map) r0
            java.util.Map r6 = kotlin.collections.MapsKt.minus(r0, r6)
            r7.setValue(r6)
        L_0x00a0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl.removeChannel$stream_chat_android_offline_release(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void refreshChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "cId");
        refreshChannels(CollectionsKt.listOf(str));
    }

    private final void refreshAllChannels() {
        refreshChannels(this.queryChannelsSpec.getCids());
    }

    private final void refreshChannels(List<String> list) {
        Iterable<String> intersect = CollectionsKt.intersect(this.queryChannelsSpec.getCids(), list);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intersect, 10));
        for (String channel$stream_chat_android_offline_release : intersect) {
            arrayList.add(this.domainImpl.channel$stream_chat_android_offline_release(channel$stream_chat_android_offline_release).toChannel());
        }
        Map mutableMap = MapsKt.toMutableMap(this._channels.getValue());
        for (Channel channel : (List) arrayList) {
            mutableMap.put(channel.getCid(), channel);
        }
        this._channels.setValue(mutableMap);
    }

    private final void addToQueryResult(List<String> list) {
        QueryChannelsSpec queryChannelsSpec2 = this.queryChannelsSpec;
        queryChannelsSpec2.setCids(CollectionsKt.distinct(CollectionsKt.plus(queryChannelsSpec2.getCids(), list)));
        refreshChannels(list);
    }

    private final void setQueryResult(List<String> list) {
        this.queryChannelsSpec.setCids(list);
        refreshChannels(list);
    }
}
