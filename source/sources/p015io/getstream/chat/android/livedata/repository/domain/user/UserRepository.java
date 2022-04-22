package p015io.getstream.chat.android.livedata.repository.domain.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ/\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/user/UserRepository;", "", "insertCurrentUser", "", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "insertUsers", "users", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAllUsers", "", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUser", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUserMap", "", "userIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUsers", "selectUsersLikeName", "searchString", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserRepository */
/* compiled from: UserRepository.kt */
public interface UserRepository {
    Object insertCurrentUser(User user, Continuation<? super Unit> continuation);

    Object insertUser(User user, Continuation<? super Unit> continuation);

    Object insertUsers(Collection<User> collection, Continuation<? super Unit> continuation);

    Object selectAllUsers(int i, int i2, Continuation<? super List<User>> continuation);

    Object selectCurrentUser(Continuation<? super User> continuation);

    Object selectUser(String str, Continuation<? super User> continuation);

    Object selectUserMap(List<String> list, Continuation<? super Map<String, User>> continuation);

    Object selectUsers(List<String> list, Continuation<? super List<User>> continuation);

    Object selectUsersLikeName(String str, int i, int i2, Continuation<? super List<User>> continuation);
}
