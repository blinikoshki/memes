package com.memes.commons.util;

import androidx.work.WorkRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/commons/util/PrettyTime;", "", "()V", "DAY_MILLIS", "", "HALF_YEAR_MILLIS", "HOUR_MILLIS", "MINUTE_MILLIS", "SECOND_MILLIS", "YEAR_MILLIS", "getConciseTimeAgoString", "", "time", "(Ljava/lang/Long;)Ljava/lang/String;", "getTimeAgoString", "timeMillis", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PrettyTime.kt */
public final class PrettyTime {
    private static final long DAY_MILLIS = 86400000;
    private static final long HALF_YEAR_MILLIS = 15552000000L;
    private static final long HOUR_MILLIS = 3600000;
    public static final PrettyTime INSTANCE = new PrettyTime();
    private static final long MINUTE_MILLIS = 60000;
    private static final long SECOND_MILLIS = 1000;
    private static final long YEAR_MILLIS = 31536000000L;

    private PrettyTime() {
    }

    public final String getTimeAgoString(Long l) {
        if (l == null) {
            return null;
        }
        if (l.longValue() < 1000000000000L) {
            l = Long.valueOf(l.longValue() * ((long) 1000));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (l.longValue() > currentTimeMillis || l.longValue() <= 0) {
            return null;
        }
        long longValue = currentTimeMillis - l.longValue();
        if (longValue < 60000) {
            return "Just now";
        }
        if (longValue < 120000) {
            return "a minute ago";
        }
        if (longValue < 3600000) {
            return (longValue / 60000) + " minutes ago";
        } else if (longValue < 5400000) {
            return "an hour ago";
        } else {
            if (longValue < 7200000) {
                return "more than an hour ago";
            }
            if (longValue < 86400000) {
                return (longValue / 3600000) + " hours ago";
            } else if (longValue < 172800000) {
                return "yesterday";
            } else {
                if (longValue < 29376000000L) {
                    return (longValue / 86400000) + " days ago";
                } else if (longValue < 94176000000L) {
                    return "a year ago";
                } else {
                    if (longValue < 31104000000L) {
                        return "more than a year ago";
                    }
                    return (longValue / YEAR_MILLIS) + " years ago";
                }
            }
        }
    }

    public final String getConciseTimeAgoString(Long l) {
        if (l == null) {
            return null;
        }
        if (l.longValue() < 1000000000000L) {
            l = Long.valueOf(l.longValue() * ((long) 1000));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (l.longValue() > currentTimeMillis || l.longValue() <= 0) {
            return null;
        }
        long longValue = currentTimeMillis - l.longValue();
        int i = (longValue > WorkRequest.MIN_BACKOFF_MILLIS ? 1 : (longValue == WorkRequest.MIN_BACKOFF_MILLIS ? 0 : -1));
        if (i < 0) {
            return "just now";
        }
        if (i > 0 && longValue < 60000) {
            StringBuilder sb = new StringBuilder();
            sb.append(longValue / 1000);
            sb.append('s');
            return sb.toString();
        } else if (longValue < 120000) {
            return "1m";
        } else {
            if (longValue < 3600000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(longValue / 60000);
                sb2.append('m');
                return sb2.toString();
            } else if (longValue < 5400000 || longValue < 7200000) {
                return "1h";
            } else {
                if (longValue < 86400000) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(longValue / 3600000);
                    sb3.append('h');
                    return sb3.toString();
                } else if (longValue < 172800000) {
                    return "1d";
                } else {
                    if (longValue < 29376000000L) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(longValue / 86400000);
                        sb4.append('d');
                        return sb4.toString();
                    } else if (longValue < 94176000000L || longValue < 31104000000L) {
                        return "1y";
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(longValue / YEAR_MILLIS);
                        sb5.append('y');
                        return sb5.toString();
                    }
                }
            }
        }
    }
}
