package p015io.getstream.chat.android.livedata.repository.database.converter;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.ChatDomainImplKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/database/converter/SetConverter;", "", "()V", "sortedSetToString", "", "someObjects", "", "stringToSortedSet", "data", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.converter.SetConverter */
/* compiled from: SetConverter.kt */
public final class SetConverter {
    public final Set<String> stringToSortedSet(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "null")) {
            return new LinkedHashSet<>();
        }
        Object fromJson = ChatDomainImplKt.getGson().fromJson(str, new SetConverter$stringToSortedSet$sortedSetType$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(\n         …  sortedSetType\n        )");
        return (Set) fromJson;
    }

    public final String sortedSetToString(Set<String> set) {
        String json = ChatDomainImplKt.getGson().toJson((Object) set);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(someObjects)");
        return json;
    }
}
