package p015io.getstream.chat.android.livedata.repository.domain.user;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H'J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H'\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/user/UserDao;", "", "insert", "", "userEntity", "Lio/getstream/chat/android/livedata/repository/domain/user/UserEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/user/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMany", "users", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "selectAllUser", "limit", "", "offset", "selectUsersLikeName", "searchString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserDao */
/* compiled from: UserDao.kt */
public interface UserDao {
    Object insert(UserEntity userEntity, Continuation<? super Unit> continuation);

    Object insertMany(List<UserEntity> list, Continuation<? super Unit> continuation);

    Object select(String str, Continuation<? super UserEntity> continuation);

    Object select(List<String> list, Continuation<? super List<UserEntity>> continuation);

    List<UserEntity> selectAllUser(int i, int i2);

    List<UserEntity> selectUsersLikeName(String str, int i, int i2);
}
