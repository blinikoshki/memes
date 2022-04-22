package p015io.getstream.chat.android.livedata.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, mo26107d2 = {"validateCid", "", "cid", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.utils.ValidationKt */
/* compiled from: Validation.kt */
public final class ValidationKt {
    public static final String validateCid(String str) {
        Intrinsics.checkNotNullParameter(str, "cid");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            throw new IllegalArgumentException("cid can not be empty".toString());
        } else if (StringsKt.contains$default(charSequence, ':', false, 2, (Object) null)) {
            return str;
        } else {
            throw new IllegalArgumentException("cid needs to be in the format channelType:channelId. For example, messaging:123".toString());
        }
    }
}
