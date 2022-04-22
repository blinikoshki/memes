package com.getstream.sdk.chat.utils.exomedia.util;

import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

public class TimeFormatUtil {
    private static StringBuilder formatBuilder = new StringBuilder();
    private static Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());

    public static String formatMs(long j) {
        if (j < 0) {
            return "--:--";
        }
        long j2 = (j % 60000) / 1000;
        long j3 = (j % DateUtils.MILLIS_PER_HOUR) / 60000;
        long j4 = (j % DateUtils.MILLIS_PER_DAY) / DateUtils.MILLIS_PER_HOUR;
        formatBuilder.setLength(0);
        if (j4 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}).toString();
    }
}
