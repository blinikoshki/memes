package com.getstream.sdk.chat.utils.extensions;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, mo26107d2 = {"isInLastMinute", "", "Ljava/util/Date;", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Date.kt */
public final class DateKt {
    public static final boolean isInLastMinute(Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$isInLastMinute");
        return new Date().getTime() - ((long) 60000) < date.getTime();
    }
}
