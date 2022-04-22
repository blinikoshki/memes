package p015io.getstream.chat.android.livedata.repository.domain.channel;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ)\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelDao;", "", "delete", "", "cid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "channelEntity", "Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/channel/ChannelEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMany", "channelEntities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "cids", "selectSyncNeeded", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "(Lio/getstream/chat/android/client/utils/SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeletedAt", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHidden", "hidden", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideMessagesBefore", "(Ljava/lang/String;ZLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao */
/* compiled from: ChannelDao.kt */
public interface ChannelDao {
    Object delete(String str, Continuation<? super Unit> continuation);

    Object insert(ChannelEntity channelEntity, Continuation<? super Unit> continuation);

    Object insertMany(List<ChannelEntity> list, Continuation<? super Unit> continuation);

    Object select(String str, Continuation<? super ChannelEntity> continuation);

    Object select(List<String> list, Continuation<? super List<ChannelEntity>> continuation);

    Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<ChannelEntity>> continuation);

    Object setDeletedAt(String str, Date date, Continuation<? super Unit> continuation);

    Object setHidden(String str, boolean z, Date date, Continuation<? super Unit> continuation);

    Object setHidden(String str, boolean z, Continuation<? super Unit> continuation);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelDao$DefaultImpls */
    /* compiled from: ChannelDao.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object selectSyncNeeded$default(ChannelDao channelDao, SyncStatus syncStatus, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    syncStatus = SyncStatus.SYNC_NEEDED;
                }
                return channelDao.selectSyncNeeded(syncStatus, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSyncNeeded");
        }
    }
}
