package p015io.getstream.chat.android.client.models;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/UserEntity;", "", "user", "Lio/getstream/chat/android/client/models/User;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "setUser", "(Lio/getstream/chat/android/client/models/User;)V", "getUserId", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.UserEntity */
/* compiled from: UserEntity.kt */
public interface UserEntity {
    User getUser();

    String getUserId();

    void setUser(User user);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.models.UserEntity$DefaultImpls */
    /* compiled from: UserEntity.kt */
    public static final class DefaultImpls {
        public static String getUserId(UserEntity userEntity) {
            return userEntity.getUser().getId();
        }
    }
}
