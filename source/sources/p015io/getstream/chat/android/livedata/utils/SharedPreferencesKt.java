package p015io.getstream.chat.android.livedata.utils;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\b¨\u0006\u0005"}, mo26107d2 = {"getNonNullString", "", "Landroid/content/SharedPreferences;", "key", "defaultValue", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.utils.SharedPreferencesKt */
/* compiled from: SharedPreferences.kt */
public final class SharedPreferencesKt {
    public static final String getNonNullString(SharedPreferences sharedPreferences, String str, String str2) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "$this$getNonNullString");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        String string = sharedPreferences.getString(str, str2);
        Intrinsics.checkNotNull(string);
        return string;
    }
}
