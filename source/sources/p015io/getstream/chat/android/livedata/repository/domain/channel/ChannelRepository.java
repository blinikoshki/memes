package p015io.getstream.chat.android.livedata.repository.domain.channel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010!J'\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelRepository;", "", "deleteChannel", "", "cid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannel", "channel", "Lio/getstream/chat/android/client/models/Channel;", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannels", "channels", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelWithoutMessages", "selectChannels", "", "channelCIDs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelsSyncNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMembersForChannel", "Lio/getstream/chat/android/client/models/Member;", "setChannelDeletedAt", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHiddenForChannel", "hidden", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideMessagesBefore", "(Ljava/lang/String;ZLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMembersForChannel", "members", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepository */
/* compiled from: ChannelRepository.kt */
public interface ChannelRepository {
    Object deleteChannel(String str, Continuation<? super Unit> continuation);

    Object insertChannel(Channel channel, Continuation<? super Unit> continuation);

    Object insertChannels(Collection<Channel> collection, Continuation<? super Unit> continuation);

    Object selectChannelWithoutMessages(String str, Continuation<? super Channel> continuation);

    Object selectChannels(List<String> list, Continuation<? super List<Channel>> continuation);

    Object selectChannelsSyncNeeded(Continuation<? super List<Channel>> continuation);

    Object selectMembersForChannel(String str, Continuation<? super List<Member>> continuation);

    Object setChannelDeletedAt(String str, Date date, Continuation<? super Unit> continuation);

    Object setHiddenForChannel(String str, boolean z, Date date, Continuation<? super Unit> continuation);

    Object setHiddenForChannel(String str, boolean z, Continuation<? super Unit> continuation);

    Object updateMembersForChannel(String str, List<Member> list, Continuation<? super Unit> continuation);
}
