package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ)\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionRepository;", "", "insertReaction", "", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Lio/getstream/chat/android/client/models/Reaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectReactionsSyncNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUserReactionsToMessage", "messageId", "", "userId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReactionsForMessageByDeletedDate", "deletedAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionRepository */
/* compiled from: ReactionRepository.kt */
public interface ReactionRepository {
    Object insertReaction(Reaction reaction, Continuation<? super Unit> continuation);

    Object selectReactionsSyncNeeded(Continuation<? super List<Reaction>> continuation);

    Object selectUserReactionsToMessage(String str, String str2, Continuation<? super List<Reaction>> continuation);

    Object updateReactionsForMessageByDeletedDate(String str, String str2, Date date, Continuation<? super Unit> continuation);
}
