package p015io.getstream.chat.android.livedata.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec;
import p015io.getstream.chat.android.livedata.model.ChannelConfig;
import p015io.getstream.chat.android.livedata.model.SyncState;
import p015io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository;
import p015io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepository;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository;
import p015io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepository;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepository;
import p015io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateRepository;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserRepository;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u001e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007BM\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0015HAø\u0001\u0000¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0015H\u0001J\u0019\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eHAø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"HAø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*HAø\u0001\u0000¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.HAø\u0001\u0000¢\u0006\u0002\u0010/J\u001f\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020&0.H@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0019\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204HAø\u0001\u0000¢\u0006\u0002\u00105J#\u00106\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00107\u001a\u000208HAø\u0001\u0000¢\u0006\u0002\u00109J)\u0010:\u001a\u00020\u00152\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0<2\b\b\u0002\u00107\u001a\u000208HAø\u0001\u0000¢\u0006\u0002\u0010=J\u0019\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@HAø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020DHAø\u0001\u0000¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020HHAø\u0001\u0000¢\u0006\u0002\u0010IJ\u0019\u0010J\u001a\u00020\u00152\u0006\u00103\u001a\u000204HAø\u0001\u0000¢\u0006\u0002\u00105J\u001f\u0010K\u001a\u00020\u00152\f\u0010L\u001a\b\u0012\u0004\u0012\u0002040.HAø\u0001\u0000¢\u0006\u0002\u0010/J'\u0010M\u001a\b\u0012\u0004\u0012\u0002040<2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OHAø\u0001\u0000¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u0004\u0018\u00010@2\u0006\u0010S\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010T\u001a\u0004\u0018\u00010*2\u0006\u0010U\u001a\u00020\u001aH\u0001J\u001b\u0010V\u001a\u0004\u0018\u00010&2\u0006\u0010\u0019\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010W\u001a\b\u0012\u0004\u0012\u00020&0<2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0<H@ø\u0001\u0000¢\u0006\u0002\u0010YJ1\u0010W\u001a\b\u0012\u0004\u0012\u00020&0<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0<2\b\u0010[\u001a\u0004\u0018\u00010\\H@ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020&0<HAø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010`\u001a\u0004\u0018\u000104HAø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0<2\u0006\u0010\u0019\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010c\u001a\u0004\u0018\u00010\u001e2\u0006\u0010d\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001e0<2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u001a0<HAø\u0001\u0000¢\u0006\u0002\u0010YJ)\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0<2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010[\u001a\u0004\u0018\u00010\\HAø\u0001\u0000¢\u0006\u0002\u0010hJ\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001e0<HAø\u0001\u0000¢\u0006\u0002\u0010\u0016J%\u0010j\u001a\b\u0012\u0004\u0012\u00020@0<2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001a0<HAø\u0001\u0000¢\u0006\u0002\u0010YJ\u001b\u0010l\u001a\u0004\u0018\u00010@2\u0006\u0010?\u001a\u00020@HAø\u0001\u0000¢\u0006\u0002\u0010AJ\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020D0<HAø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001b\u0010n\u001a\u0004\u0018\u00010H2\u0006\u0010o\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010p\u001a\u0004\u0018\u0001042\u0006\u0010o\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010\u001bJ+\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002040r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001a0<HAø\u0001\u0000¢\u0006\u0002\u0010YJ'\u0010t\u001a\b\u0012\u0004\u0012\u00020D0<2\u0006\u0010d\u001a\u00020\u001a2\u0006\u0010o\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u0010uJ%\u0010v\u001a\b\u0012\u0004\u0012\u0002040<2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001a0<HAø\u0001\u0000¢\u0006\u0002\u0010YJ/\u0010w\u001a\b\u0012\u0004\u0012\u0002040<2\u0006\u0010x\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OHAø\u0001\u0000¢\u0006\u0002\u0010yJ!\u0010z\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\"HAø\u0001\u0000¢\u0006\u0002\u0010#J!\u0010|\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010}\u001a\u000208HAø\u0001\u0000¢\u0006\u0002\u0010~J)\u0010|\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010}\u001a\u0002082\u0006\u0010!\u001a\u00020\"HAø\u0001\u0000¢\u0006\u0002\u0010J]\u0010\u0001\u001a\u00020\u00152\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010.2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002040<2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&0.2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0<2\t\b\u0002\u0010\u0001\u001a\u000208H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J*\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020b0<HAø\u0001\u0000¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\"HAø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u00020\u0015*\u00020&2\u0019\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0<0r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0003\b\u0001R\u000e\u0010\n\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/RepositoryFacade;", "Lio/getstream/chat/android/livedata/repository/domain/user/UserRepository;", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepository;", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepository;", "Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepository;", "userRepository", "configsRepository", "channelsRepository", "queryChannelsRepository", "messageRepository", "reactionsRepository", "syncStateRepository", "scope", "Lkotlinx/coroutines/CoroutineScope;", "defaultConfig", "Lio/getstream/chat/android/client/models/Config;", "(Lio/getstream/chat/android/livedata/repository/domain/user/UserRepository;Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepository;Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepository;Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateRepository;Lkotlinx/coroutines/CoroutineScope;Lio/getstream/chat/android/client/models/Config;)V", "cacheChannelConfigs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearChannelConfigsCache", "deleteChannel", "cid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChannelMessage", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChannelMessagesBefore", "hideMessagesBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannel", "channel", "Lio/getstream/chat/android/client/models/Channel;", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannelConfig", "config", "Lio/getstream/chat/android/livedata/model/ChannelConfig;", "(Lio/getstream/chat/android/livedata/model/ChannelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannelConfigs", "configs", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannels", "channels", "insertCurrentUser", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessage", "cache", "", "(Lio/getstream/chat/android/client/models/Message;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessages", "messages", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertQueryChannels", "queryChannelsSpec", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "(Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReaction", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Lio/getstream/chat/android/client/models/Reaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSyncState", "syncState", "Lio/getstream/chat/android/livedata/model/SyncState;", "(Lio/getstream/chat/android/livedata/model/SyncState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "insertUsers", "users", "selectAllUsers", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectById", "id", "selectChannelConfig", "channelType", "selectChannelWithoutMessages", "selectChannels", "channelCIDs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelIds", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "selectChannels$stream_chat_android_offline_release", "(Ljava/util/List;Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelsSyncNeeded", "selectCurrentUser", "selectMembersForChannel", "Lio/getstream/chat/android/client/models/Member;", "selectMessage", "messageId", "selectMessages", "messageIds", "selectMessagesForChannel", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessagesSyncNeeded", "selectQueriesChannelsByIds", "ids", "selectQueryChannels", "selectReactionsSyncNeeded", "selectSyncState", "userId", "selectUser", "selectUserMap", "", "userIds", "selectUserReactionsToMessage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUsers", "selectUsersLikeName", "searchString", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setChannelDeletedAt", "deletedAt", "setHiddenForChannel", "hidden", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;ZLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeStateForChannels", "cacheForMessages", "storeStateForChannels$stream_chat_android_offline_release", "(Ljava/util/Collection;Ljava/util/List;Ljava/util/Collection;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastMessageForChannel", "lastMessage", "updateLastMessageForChannel$stream_chat_android_offline_release", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMembersForChannel", "members", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReactionsForMessageByDeletedDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrichChannel", "messageMap", "enrichChannel$stream_chat_android_offline_release", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.RepositoryFacade */
/* compiled from: RepositoryFacade.kt */
public final class RepositoryFacade implements UserRepository, ChannelRepository, ReactionRepository, MessageRepository, ChannelConfigRepository, QueryChannelsRepository, SyncStateRepository {
    private final /* synthetic */ UserRepository $$delegate_0;
    private final /* synthetic */ ReactionRepository $$delegate_2;
    private final /* synthetic */ MessageRepository $$delegate_3;
    private final /* synthetic */ ChannelConfigRepository $$delegate_4;
    private final /* synthetic */ QueryChannelsRepository $$delegate_5;
    private final /* synthetic */ SyncStateRepository $$delegate_6;
    private final ChannelRepository channelsRepository;
    private final Config defaultConfig;
    private final CoroutineScope scope;

    public Object cacheChannelConfigs(Continuation<? super Unit> continuation) {
        return this.$$delegate_4.cacheChannelConfigs(continuation);
    }

    public void clearChannelConfigsCache() {
        this.$$delegate_4.clearChannelConfigsCache();
    }

    public Object deleteChannel(String str, Continuation<? super Unit> continuation) {
        return this.channelsRepository.deleteChannel(str, continuation);
    }

    public Object deleteChannelMessage(Message message, Continuation<? super Unit> continuation) {
        return this.$$delegate_3.deleteChannelMessage(message, continuation);
    }

    public Object deleteChannelMessagesBefore(String str, Date date, Continuation<? super Unit> continuation) {
        return this.$$delegate_3.deleteChannelMessagesBefore(str, date, continuation);
    }

    public Object insertChannelConfig(ChannelConfig channelConfig, Continuation<? super Unit> continuation) {
        return this.$$delegate_4.insertChannelConfig(channelConfig, continuation);
    }

    public Object insertChannelConfigs(Collection<ChannelConfig> collection, Continuation<? super Unit> continuation) {
        return this.$$delegate_4.insertChannelConfigs(collection, continuation);
    }

    public Object insertCurrentUser(User user, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.insertCurrentUser(user, continuation);
    }

    public Object insertMessage(Message message, boolean z, Continuation<? super Unit> continuation) {
        return this.$$delegate_3.insertMessage(message, z, continuation);
    }

    public Object insertMessages(List<Message> list, boolean z, Continuation<? super Unit> continuation) {
        return this.$$delegate_3.insertMessages(list, z, continuation);
    }

    public Object insertQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super Unit> continuation) {
        return this.$$delegate_5.insertQueryChannels(queryChannelsSpec, continuation);
    }

    public Object insertReaction(Reaction reaction, Continuation<? super Unit> continuation) {
        return this.$$delegate_2.insertReaction(reaction, continuation);
    }

    public Object insertSyncState(SyncState syncState, Continuation<? super Unit> continuation) {
        return this.$$delegate_6.insertSyncState(syncState, continuation);
    }

    public Object insertUser(User user, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.insertUser(user, continuation);
    }

    public Object insertUsers(Collection<User> collection, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.insertUsers(collection, continuation);
    }

    public Object selectAllUsers(int i, int i2, Continuation<? super List<User>> continuation) {
        return this.$$delegate_0.selectAllUsers(i, i2, continuation);
    }

    public Object selectById(String str, Continuation<? super QueryChannelsSpec> continuation) {
        return this.$$delegate_5.selectById(str, continuation);
    }

    public ChannelConfig selectChannelConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        return this.$$delegate_4.selectChannelConfig(str);
    }

    public Object selectChannelWithoutMessages(String str, Continuation<? super Channel> continuation) {
        return this.channelsRepository.selectChannelWithoutMessages(str, continuation);
    }

    public Object selectChannelsSyncNeeded(Continuation<? super List<Channel>> continuation) {
        return this.channelsRepository.selectChannelsSyncNeeded(continuation);
    }

    public Object selectCurrentUser(Continuation<? super User> continuation) {
        return this.$$delegate_0.selectCurrentUser(continuation);
    }

    public Object selectMembersForChannel(String str, Continuation<? super List<Member>> continuation) {
        return this.channelsRepository.selectMembersForChannel(str, continuation);
    }

    public Object selectMessage(String str, Continuation<? super Message> continuation) {
        return this.$$delegate_3.selectMessage(str, continuation);
    }

    public Object selectMessages(List<String> list, Continuation<? super List<Message>> continuation) {
        return this.$$delegate_3.selectMessages(list, continuation);
    }

    public Object selectMessagesForChannel(String str, AnyChannelPaginationRequest anyChannelPaginationRequest, Continuation<? super List<Message>> continuation) {
        return this.$$delegate_3.selectMessagesForChannel(str, anyChannelPaginationRequest, continuation);
    }

    public Object selectMessagesSyncNeeded(Continuation<? super List<Message>> continuation) {
        return this.$$delegate_3.selectMessagesSyncNeeded(continuation);
    }

    public Object selectQueriesChannelsByIds(List<String> list, Continuation<? super List<QueryChannelsSpec>> continuation) {
        return this.$$delegate_5.selectQueriesChannelsByIds(list, continuation);
    }

    public Object selectQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super QueryChannelsSpec> continuation) {
        return this.$$delegate_5.selectQueryChannels(queryChannelsSpec, continuation);
    }

    public Object selectReactionsSyncNeeded(Continuation<? super List<Reaction>> continuation) {
        return this.$$delegate_2.selectReactionsSyncNeeded(continuation);
    }

    public Object selectSyncState(String str, Continuation<? super SyncState> continuation) {
        return this.$$delegate_6.selectSyncState(str, continuation);
    }

    public Object selectUser(String str, Continuation<? super User> continuation) {
        return this.$$delegate_0.selectUser(str, continuation);
    }

    public Object selectUserMap(List<String> list, Continuation<? super Map<String, User>> continuation) {
        return this.$$delegate_0.selectUserMap(list, continuation);
    }

    public Object selectUserReactionsToMessage(String str, String str2, Continuation<? super List<Reaction>> continuation) {
        return this.$$delegate_2.selectUserReactionsToMessage(str, str2, continuation);
    }

    public Object selectUsers(List<String> list, Continuation<? super List<User>> continuation) {
        return this.$$delegate_0.selectUsers(list, continuation);
    }

    public Object selectUsersLikeName(String str, int i, int i2, Continuation<? super List<User>> continuation) {
        return this.$$delegate_0.selectUsersLikeName(str, i, i2, continuation);
    }

    public Object setChannelDeletedAt(String str, Date date, Continuation<? super Unit> continuation) {
        return this.channelsRepository.setChannelDeletedAt(str, date, continuation);
    }

    public Object setHiddenForChannel(String str, boolean z, Date date, Continuation<? super Unit> continuation) {
        return this.channelsRepository.setHiddenForChannel(str, z, date, continuation);
    }

    public Object setHiddenForChannel(String str, boolean z, Continuation<? super Unit> continuation) {
        return this.channelsRepository.setHiddenForChannel(str, z, continuation);
    }

    public Object updateMembersForChannel(String str, List<Member> list, Continuation<? super Unit> continuation) {
        return this.channelsRepository.updateMembersForChannel(str, list, continuation);
    }

    public Object updateReactionsForMessageByDeletedDate(String str, String str2, Date date, Continuation<? super Unit> continuation) {
        return this.$$delegate_2.updateReactionsForMessageByDeletedDate(str, str2, date, continuation);
    }

    public RepositoryFacade(UserRepository userRepository, ChannelConfigRepository channelConfigRepository, ChannelRepository channelRepository, QueryChannelsRepository queryChannelsRepository, MessageRepository messageRepository, ReactionRepository reactionRepository, SyncStateRepository syncStateRepository, CoroutineScope coroutineScope, Config config) {
        Intrinsics.checkNotNullParameter(userRepository, "userRepository");
        Intrinsics.checkNotNullParameter(channelConfigRepository, "configsRepository");
        Intrinsics.checkNotNullParameter(channelRepository, "channelsRepository");
        Intrinsics.checkNotNullParameter(queryChannelsRepository, "queryChannelsRepository");
        Intrinsics.checkNotNullParameter(messageRepository, "messageRepository");
        Intrinsics.checkNotNullParameter(reactionRepository, "reactionsRepository");
        Intrinsics.checkNotNullParameter(syncStateRepository, "syncStateRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(config, "defaultConfig");
        this.$$delegate_0 = userRepository;
        this.$$delegate_2 = reactionRepository;
        this.$$delegate_3 = messageRepository;
        this.$$delegate_4 = channelConfigRepository;
        this.$$delegate_5 = queryChannelsRepository;
        this.$$delegate_6 = syncStateRepository;
        this.channelsRepository = channelRepository;
        this.scope = coroutineScope;
        this.defaultConfig = config;
    }

    public Object selectChannels(List<String> list, Continuation<? super List<Channel>> continuation) {
        return selectChannels$stream_chat_android_offline_release(list, (AnyChannelPaginationRequest) null, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e7 A[LOOP:1: B:33:0x00e1->B:35:0x00e7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object selectChannels$stream_chat_android_offline_release(java.util.List<java.lang.String> r19, p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r20, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2 r3 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2 r3 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0059
            if (r5 == r7) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r1 = r3.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r3 = r3.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00cf
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            java.lang.Object r1 = r3.L$2
            io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r1 = (p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest) r1
            java.lang.Object r5 = r3.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r7 = r3.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r5
            r5 = r1
            r1 = r17
            goto L_0x0070
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r2)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository r2 = r0.channelsRepository
            r3.L$0 = r0
            r3.L$1 = r1
            r5 = r20
            r3.L$2 = r5
            r3.label = r7
            java.lang.Object r2 = r2.selectChannels(r1, r3)
            if (r2 != r4) goto L_0x006f
            return r4
        L_0x006f:
            r7 = r0
        L_0x0070:
            java.util.List r2 = (java.util.List) r2
            if (r5 == 0) goto L_0x0080
            boolean r8 = p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequestKt.isRequestingMoreThanLastMessage(r5)
            if (r8 == 0) goto L_0x007b
            goto L_0x0080
        L_0x007b:
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x00db
        L_0x0080:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r9)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r1 = r1.iterator()
        L_0x0093:
            boolean r9 = r1.hasNext()
            r10 = 0
            if (r9 == 0) goto L_0x00b6
            java.lang.Object r9 = r1.next()
            java.lang.String r9 = (java.lang.String) r9
            kotlinx.coroutines.CoroutineScope r11 = r7.scope
            r12 = 0
            r13 = 0
            io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$$inlined$map$lambda$1 r14 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$$inlined$map$lambda$1
            r14.<init>(r9, r10, r7, r5)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 3
            r16 = 0
            kotlinx.coroutines.Deferred r9 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r11, r12, r13, r14, r15, r16)
            r8.add(r9)
            goto L_0x0093
        L_0x00b6:
            java.util.List r8 = (java.util.List) r8
            java.util.Collection r8 = (java.util.Collection) r8
            r3.L$0 = r7
            r3.L$1 = r2
            r3.L$2 = r10
            r3.label = r6
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.awaitAll(r8, r3)
            if (r1 != r4) goto L_0x00c9
            return r4
        L_0x00c9:
            r3 = r7
            r17 = r2
            r2 = r1
            r1 = r17
        L_0x00cf:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Map r2 = kotlin.collections.MapsKt.toMap(r2)
            r7 = r3
            r17 = r2
            r2 = r1
            r1 = r17
        L_0x00db:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r3 = r2.iterator()
        L_0x00e1:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00f3
            java.lang.Object r4 = r3.next()
            io.getstream.chat.android.client.models.Channel r4 = (p015io.getstream.chat.android.client.models.Channel) r4
            io.getstream.chat.android.client.models.Config r5 = r7.defaultConfig
            r7.enrichChannel$stream_chat_android_offline_release(r4, r1, r5)
            goto L_0x00e1
        L_0x00f3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.RepositoryFacade.selectChannels$stream_chat_android_offline_release(java.util.List, io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void enrichChannel$stream_chat_android_offline_release(Channel channel, Map<String, ? extends List<Message>> map, Config config) {
        List<Message> list;
        Config config2;
        Intrinsics.checkNotNullParameter(channel, "$this$enrichChannel");
        Intrinsics.checkNotNullParameter(map, "messageMap");
        Intrinsics.checkNotNullParameter(config, "defaultConfig");
        ChannelConfig selectChannelConfig = selectChannelConfig(channel.getType());
        if (!(selectChannelConfig == null || (config2 = selectChannelConfig.getConfig()) == null)) {
            config = config2;
        }
        channel.setConfig(config);
        if (map.containsKey(channel.getCid())) {
            List list2 = (List) map.get(channel.getCid());
            if (list2 != null) {
                list = CollectionsKt.distinct(CollectionsKt.plus(list2, channel.getMessages()));
            } else {
                throw new IllegalStateException("Messages must be in the map".toString());
            }
        } else {
            list = channel.getMessages();
        }
        channel.setMessages(list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object insertChannel(p015io.getstream.chat.android.client.models.Channel r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannel$1 r0 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannel$1 r0 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannel$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            io.getstream.chat.android.client.models.Channel r6 = (p015io.getstream.chat.android.client.models.Channel) r6
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository r7 = r5.channelsRepository
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.insertChannel(r6, r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r5
        L_0x0054:
            java.util.List r6 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.users((p015io.getstream.chat.android.client.models.Channel) r6)
            java.util.Collection r6 = (java.util.Collection) r6
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r2.insertUsers(r6, r0)
            if (r6 != r1) goto L_0x0068
            return r1
        L_0x0068:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.RepositoryFacade.insertChannel(io.getstream.chat.android.client.models.Channel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067 A[LOOP:0: B:19:0x0061->B:21:0x0067, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object insertChannels(java.util.Collection<p015io.getstream.chat.android.client.models.Channel> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1 r0 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1 r0 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0089
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository r7 = r5.channelsRepository
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.insertChannels(r6, r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r5
        L_0x0054:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x0061:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r6.next()
            io.getstream.chat.android.client.models.Channel r4 = (p015io.getstream.chat.android.client.models.Channel) r4
            java.util.List r4 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.users((p015io.getstream.chat.android.client.models.Channel) r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.collections.CollectionsKt.addAll(r7, r4)
            goto L_0x0061
        L_0x0077:
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r2.insertUsers(r7, r0)
            if (r6 != r1) goto L_0x0089
            return r1
        L_0x0089:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.RepositoryFacade.insertChannels(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object storeStateForChannels$stream_chat_android_offline_release(java.util.Collection<p015io.getstream.chat.android.livedata.model.ChannelConfig> r10, java.util.List<p015io.getstream.chat.android.client.models.User> r11, java.util.Collection<p015io.getstream.chat.android.client.models.Channel> r12, java.util.List<p015io.getstream.chat.android.client.models.Message> r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof p015io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1 r0 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1 r0 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1
            r0.<init>(r9, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007a
            if (r2 == r6) goto L_0x0061
            if (r2 == r5) goto L_0x004c
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ca
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003d:
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r12 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00bd
        L_0x004c:
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$1
            java.util.Collection r12 = (java.util.Collection) r12
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r13 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r13
            kotlin.ResultKt.throwOnFailure(r15)
            r8 = r13
            r13 = r12
            r12 = r8
            goto L_0x00ac
        L_0x0061:
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$3
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r0.L$2
            java.util.Collection r12 = (java.util.Collection) r12
            java.lang.Object r13 = r0.L$1
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r14 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r8 = r13
            r13 = r11
            r11 = r8
            goto L_0x0094
        L_0x007a:
            kotlin.ResultKt.throwOnFailure(r15)
            if (r10 == 0) goto L_0x0092
            r0.L$0 = r9
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.Z$0 = r14
            r0.label = r6
            java.lang.Object r10 = r9.insertChannelConfigs(r10, r0)
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r10 = r14
            r14 = r9
        L_0x0094:
            java.util.Collection r11 = (java.util.Collection) r11
            r0.L$0 = r14
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r7
            r0.Z$0 = r10
            r0.label = r5
            java.lang.Object r11 = r14.insertUsers(r11, r0)
            if (r11 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r11 = r13
            r13 = r12
            r12 = r14
        L_0x00ac:
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r7
            r0.Z$0 = r10
            r0.label = r4
            java.lang.Object r13 = r12.insertChannels(r13, r0)
            if (r13 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r10 = r12.insertMessages(r11, r10, r0)
            if (r10 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.RepositoryFacade.storeStateForChannels$stream_chat_android_offline_release(java.util.Collection, java.util.List, java.util.Collection, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: storeStateForChannels$stream_chat_android_offline_release$default */
    public static /* synthetic */ Object m1016xb6c4b435(RepositoryFacade repositoryFacade, Collection collection, List list, Collection collection2, List list2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = null;
        }
        return repositoryFacade.storeStateForChannels$stream_chat_android_offline_release(collection, list, collection2, list2, (i & 16) != 0 ? false : z, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: io.getstream.chat.android.client.models.Message} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateLastMessageForChannel$stream_chat_android_offline_release(java.lang.String r8, p015io.getstream.chat.android.client.models.Message r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.repository.RepositoryFacade$updateLastMessageForChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.repository.RepositoryFacade$updateLastMessageForChannel$1 r0 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade$updateLastMessageForChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.RepositoryFacade$updateLastMessageForChannel$1 r0 = new io.getstream.chat.android.livedata.repository.RepositoryFacade$updateLastMessageForChannel$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.L$1
            io.getstream.chat.android.client.models.Channel r8 = (p015io.getstream.chat.android.client.models.Channel) r8
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.client.models.Channel r8 = (p015io.getstream.chat.android.client.models.Channel) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00bc
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            io.getstream.chat.android.client.models.Message r9 = (p015io.getstream.chat.android.client.models.Message) r9
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r8 = (p015io.getstream.chat.android.livedata.repository.RepositoryFacade) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r7.selectChannelWithoutMessages(r8, r0)
            if (r10 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r8 = r7
        L_0x005c:
            io.getstream.chat.android.client.models.Channel r10 = (p015io.getstream.chat.android.client.models.Channel) r10
            if (r10 == 0) goto L_0x00bc
            java.util.Date r2 = r9.getCreatedAt()
            if (r2 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            java.util.Date r2 = r9.getCreatedLocallyAt()
        L_0x006b:
            if (r2 == 0) goto L_0x00ae
            io.getstream.chat.android.client.models.Message r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.getLastMessage(r10)
            if (r5 == 0) goto L_0x0093
            java.lang.String r6 = r9.getId()
            java.lang.String r5 = r5.getId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0093
            java.util.Date r5 = r10.getLastMessageAt()
            if (r5 == 0) goto L_0x0093
            java.util.Date r5 = r10.getLastMessageAt()
            boolean r5 = r2.after(r5)
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r4 = 0
        L_0x0093:
            if (r4 == 0) goto L_0x00bc
            r10.setLastMessageAt(r2)
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r9)
            r10.setMessages(r9)
            io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository r8 = r8.channelsRepository
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r8 = r8.insertChannel(r10, r0)
            if (r8 != r1) goto L_0x00bc
            return r1
        L_0x00ae:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "created at cant be null, be sure to set message.createdAt"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x00bc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.RepositoryFacade.updateLastMessageForChannel$stream_chat_android_offline_release(java.lang.String, io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
