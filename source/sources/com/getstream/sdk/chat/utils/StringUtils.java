package com.getstream.sdk.chat.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/StringUtils;", "", "()V", "removeTimePrefix", "", "attachmentName", "usedDateFormat", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StringUtils.kt */
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final String removeTimePrefix(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "usedDateFormat");
        Regex regex = new Regex("STREAM_\\S{" + (str2.length() + 1) + '}');
        if (str == null) {
            return str;
        }
        CharSequence charSequence = str;
        return regex.containsMatchIn(charSequence) ? regex.replaceFirst(charSequence, "") : str;
    }
}
