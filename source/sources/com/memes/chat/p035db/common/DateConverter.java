package com.memes.chat.p035db.common;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Lcom/memes/chat/db/common/DateConverter;", "", "()V", "toDate", "Ljava/util/Date;", "timestamp", "", "toTimestamp", "date", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.common.DateConverter */
/* compiled from: DateConverter.kt */
public final class DateConverter {
    public final Date toDate(long j) {
        return new Date(j);
    }

    public final long toTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return date.getTime();
    }
}
