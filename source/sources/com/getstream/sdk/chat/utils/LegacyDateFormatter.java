package com.getstream.sdk.chat.utils;

import java.util.Date;
import kotlin.Metadata;
import org.threeten.p022bp.LocalDateTime;
import org.threeten.p022bp.LocalTime;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/LegacyDateFormatter;", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "()V", "formatDate", "", "date", "Ljava/util/Date;", "localDateTime", "Lorg/threeten/bp/LocalDateTime;", "formatTime", "time", "localTime", "Lorg/threeten/bp/LocalTime;", "toTime", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LegacyDateFormatter.kt */
public abstract class LegacyDateFormatter implements DateFormatter {
    public abstract String formatDate(Date date);

    public abstract String formatTime(Date date);

    public final String formatDate(LocalDateTime localDateTime) {
        return formatDate(localDateTime != null ? DateConverter.INSTANCE.toDate(localDateTime) : null);
    }

    private final Date toTime(LocalTime localTime) {
        Date date = new Date(0);
        date.setHours(localTime.getHour());
        date.setMinutes(localTime.getMinute());
        date.setSeconds(localTime.getSecond());
        return date;
    }

    public final String formatTime(LocalTime localTime) {
        return formatTime(localTime != null ? toTime(localTime) : null);
    }
}
