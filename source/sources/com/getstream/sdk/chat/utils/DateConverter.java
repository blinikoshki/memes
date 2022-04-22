package com.getstream.sdk.chat.utils;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.p022bp.Instant;
import org.threeten.p022bp.LocalDateTime;
import org.threeten.p022bp.LocalTime;
import org.threeten.p022bp.ZoneId;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DateConverter;", "", "()V", "toDate", "Ljava/util/Date;", "localDateTime", "Lorg/threeten/bp/LocalDateTime;", "toLocalDateTime", "date", "toLocalTime", "Lorg/threeten/bp/LocalTime;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DateConverter.kt */
public final class DateConverter {
    public static final DateConverter INSTANCE = new DateConverter();

    private DateConverter() {
    }

    public final LocalDateTime toLocalDateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        LocalDateTime localDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "Instant.ofEpochMilli(dat…       .toLocalDateTime()");
        return localDateTime;
    }

    public final LocalTime toLocalTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        LocalTime localTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "Instant.ofEpochMilli(dat…           .toLocalTime()");
        return localTime;
    }

    public final Date toDate(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        return new Date(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
