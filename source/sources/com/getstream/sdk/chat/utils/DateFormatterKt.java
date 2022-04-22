package com.getstream.sdk.chat.utils;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0006"}, mo26107d2 = {"formatDate", "", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "date", "Ljava/util/Date;", "formatTime", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: DateFormatter.kt */
public final class DateFormatterKt {
    @InternalStreamChatApi
    public static final String formatDate(DateFormatter dateFormatter, Date date) {
        Intrinsics.checkNotNullParameter(dateFormatter, "$this$formatDate");
        return dateFormatter.formatDate(date != null ? DateConverter.INSTANCE.toLocalDateTime(date) : null);
    }

    @InternalStreamChatApi
    public static final String formatTime(DateFormatter dateFormatter, Date date) {
        Intrinsics.checkNotNullParameter(dateFormatter, "$this$formatTime");
        return dateFormatter.formatTime(date != null ? DateConverter.INSTANCE.toLocalTime(date) : null);
    }
}
