package p015io.getstream.chat.android.livedata.repository.database.converter;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.ChatDomainImplKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007J\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/converter/ExtraDataConverter;", "", "()V", "mapToString", "", "someObjects", "", "stringToMap", "data", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.converter.ExtraDataConverter */
/* compiled from: ExtraDataConverter.kt */
public final class ExtraDataConverter {
    public final Map<String, Object> stringToMap(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return new LinkedHashMap<>();
        }
        Object fromJson = ChatDomainImplKt.getGson().fromJson(str, new ExtraDataConverter$stringToMap$mapType$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(\n         …        mapType\n        )");
        return (Map) fromJson;
    }

    public final String mapToString(Map<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        String json = ChatDomainImplKt.getGson().toJson((Object) map);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }
}
