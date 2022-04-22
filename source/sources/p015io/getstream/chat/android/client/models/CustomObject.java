package p015io.getstream.chat.android.client.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u0002H\nH\u0016¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001H\u0016R$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/CustomObject;", "", "extraData", "", "", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getExtraValue", "T", "key", "default", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putExtraValue", "", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.CustomObject */
/* compiled from: CustomObject.kt */
public interface CustomObject {
    Map<String, Object> getExtraData();

    <T> T getExtraValue(String str, T t);

    void putExtraValue(String str, Object obj);

    void setExtraData(Map<String, Object> map);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.models.CustomObject$DefaultImpls */
    /* compiled from: CustomObject.kt */
    public static final class DefaultImpls {
        public static <T> T getExtraValue(CustomObject customObject, String str, T t) {
            Intrinsics.checkNotNullParameter(str, "key");
            return customObject.getExtraData().containsKey(str) ? customObject.getExtraData().get(str) : t;
        }

        public static void putExtraValue(CustomObject customObject, String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(obj, "value");
            customObject.getExtraData().put(str, obj);
        }
    }
}
