package com.snapchat.kit.sdk.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ZonedDateUtils {

    /* renamed from: a */
    private final TimeZone f1413a;

    public ZonedDateUtils(TimeZone timeZone) {
        this.f1413a = timeZone;
    }

    /* renamed from: a */
    public final long mo61835a(Date date) {
        Calendar instance = Calendar.getInstance(this.f1413a);
        instance.setTime(date);
        return (long) instance.get(5);
    }

    /* renamed from: b */
    public final long mo61836b(Date date) {
        Calendar instance = Calendar.getInstance(this.f1413a);
        instance.setTime(date);
        return (long) (instance.get(2) + 1);
    }

    /* renamed from: c */
    public final long mo61837c(Date date) {
        Calendar instance = Calendar.getInstance(this.f1413a);
        instance.setTime(date);
        return (long) instance.get(1);
    }
}
