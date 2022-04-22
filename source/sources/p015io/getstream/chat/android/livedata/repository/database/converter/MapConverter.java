package p015io.getstream.chat.android.livedata.repository.database.converter;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.ChatDomainImplKt;
import p015io.getstream.chat.android.livedata.repository.domain.channel.member.MemberEntity;
import p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J \u0010\b\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0007J\u001e\u0010\n\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007J \u0010\r\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/converter/MapConverter;", "", "()V", "mapToString", "", "someObjects", "", "", "memberMapToString", "Lio/getstream/chat/android/livedata/repository/domain/channel/member/MemberEntity;", "readMapToString", "", "Lio/getstream/chat/android/livedata/repository/domain/channel/userread/ChannelUserReadEntity;", "stringMapToString", "stringToMap", "data", "stringToMemberMap", "stringToReadMap", "stringToStringMap", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.converter.MapConverter */
/* compiled from: MapConverter.kt */
public final class MapConverter {
    public final String readMapToString(Map<String, ChannelUserReadEntity> map) {
        String json = ChatDomainImplKt.getGson().toJson((Object) map);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }

    public final Map<String, ChannelUserReadEntity> stringToReadMap(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return new LinkedHashMap<>();
        }
        Object fromJson = ChatDomainImplKt.getGson().fromJson(str, new MapConverter$stringToReadMap$listType$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(\n         …       listType\n        )");
        return (Map) fromJson;
    }

    public final String memberMapToString(Map<String, MemberEntity> map) {
        return ChatDomainImplKt.getGson().toJson((Object) map);
    }

    public final Map<String, MemberEntity> stringToMemberMap(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return MapsKt.emptyMap();
        }
        return (Map) ChatDomainImplKt.getGson().fromJson(str, new MapConverter$stringToMemberMap$listType$1().getType());
    }

    public final Map<String, Integer> stringToMap(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return new LinkedHashMap<>();
        }
        Object fromJson = ChatDomainImplKt.getGson().fromJson(str, new MapConverter$stringToMap$mapType$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(\n         …        mapType\n        )");
        return (Map) fromJson;
    }

    public final String mapToString(Map<String, Integer> map) {
        return ChatDomainImplKt.getGson().toJson((Object) map);
    }

    public final Map<String, String> stringToStringMap(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return new LinkedHashMap<>();
        }
        return (Map) ChatDomainImplKt.getGson().fromJson(str, new MapConverter$stringToStringMap$mapType$1().getType());
    }

    public final String stringMapToString(Map<String, String> map) {
        return ChatDomainImplKt.getGson().toJson((Object) map);
    }
}
