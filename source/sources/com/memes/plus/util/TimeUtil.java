package com.memes.plus.util;

import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/util/TimeUtil;", "", "()V", "DAY_MILLIS", "", "HOUR_MILLIS", "MINUTE_MILLIS", "MONTH_MILLIS", "", "SECOND_MILLIS", "WEEK_MILLIS", "YEAR_MILLIS", "calculateMessageTime", "", "timeMillis", "getTimeAgo", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "There is already similar alternative available by the name of PrettyTime.")
/* compiled from: TimeUtil.kt */
public final class TimeUtil {
    private static final int DAY_MILLIS = 86400000;
    private static final int HOUR_MILLIS = 3600000;
    public static final TimeUtil INSTANCE = new TimeUtil();
    private static final int MINUTE_MILLIS = 60000;
    private static final long MONTH_MILLIS = 2419200000L;
    private static final int SECOND_MILLIS = 1000;
    private static final int WEEK_MILLIS = 604800000;
    private static final long YEAR_MILLIS = 29030400000L;

    private TimeUtil() {
    }

    public final String calculateMessageTime(long j) {
        try {
            Date date = new Date(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            String format = simpleDateFormat.format(date);
            Intrinsics.checkNotNullExpressionValue(format, "sdf.format(date)");
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            Date parse = simpleDateFormat.parse(format);
            Intrinsics.checkNotNullExpressionValue(parse, "sdf.parse(agoTime)");
            CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(parse.getTime(), System.currentTimeMillis(), 60000);
            Intrinsics.checkNotNullExpressionValue(relativeTimeSpanString, "DateUtils.getRelativeTim…teUtils.MINUTE_IN_MILLIS)");
            return relativeTimeSpanString.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final String getTimeAgo(long j) {
        if (j < 1000000000000L) {
            j *= (long) 1000;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < ((long) 2000)) {
            return "Just now";
        }
        long j2 = (long) MINUTE_MILLIS;
        if (currentTimeMillis < j2) {
            return String.valueOf(currentTimeMillis / ((long) 1000)) + " sec ago";
        } else if (currentTimeMillis < ((long) 120000)) {
            return "1 min ago";
        } else {
            if (currentTimeMillis < ((long) 3000000)) {
                return String.valueOf(currentTimeMillis / j2) + " min ago";
            } else if (currentTimeMillis < ((long) 5400000)) {
                return "an hour ago";
            } else {
                long j3 = (long) DAY_MILLIS;
                if (currentTimeMillis < j3) {
                    return String.valueOf(currentTimeMillis / ((long) HOUR_MILLIS)) + " hours ago";
                } else if (currentTimeMillis < ((long) 172800000)) {
                    return "1 day ago";
                } else {
                    long j4 = (long) WEEK_MILLIS;
                    if (currentTimeMillis < j4) {
                        return String.valueOf(currentTimeMillis / j3) + " days ago";
                    } else if (currentTimeMillis < 1209600000) {
                        return "1 wk ago";
                    } else {
                        if (currentTimeMillis < MONTH_MILLIS) {
                            return String.valueOf(currentTimeMillis / j4) + " wk ago";
                        } else if (currentTimeMillis < 4838400000L) {
                            return "1 mo ago";
                        } else {
                            if (currentTimeMillis < YEAR_MILLIS) {
                                return String.valueOf(currentTimeMillis / MONTH_MILLIS) + " mo ago";
                            } else if (currentTimeMillis < 58060800000L) {
                                return "a year ago";
                            } else {
                                return String.valueOf(currentTimeMillis / YEAR_MILLIS) + " years ago";
                            }
                        }
                    }
                }
            }
        }
    }
}
