package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionDao;", "", "insert", "", "reactionEntity", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSyncNeeded", "", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "(Lio/getstream/chat/android/client/utils/SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUserReactionsToMessage", "messageId", "", "userId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeleteAt", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao */
/* compiled from: ReactionDao.kt */
public interface ReactionDao {
    Object insert(ReactionEntity reactionEntity, Continuation<? super Unit> continuation);

    Object selectSyncNeeded(SyncStatus syncStatus, Continuation<? super List<ReactionEntity>> continuation);

    Object selectUserReactionsToMessage(String str, String str2, Continuation<? super List<ReactionEntity>> continuation);

    Object setDeleteAt(String str, String str2, Date date, Continuation<? super Unit> continuation);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionDao$DefaultImpls */
    /* compiled from: ReactionDao.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object selectSyncNeeded$default(ReactionDao reactionDao, SyncStatus syncStatus, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    syncStatus = SyncStatus.SYNC_NEEDED;
                }
                return reactionDao.selectSyncNeeded(syncStatus, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSyncNeeded");
        }
    }
}
