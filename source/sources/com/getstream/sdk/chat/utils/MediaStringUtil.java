package com.getstream.sdk.chat.utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.commons.lang3.StringUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/MediaStringUtil;", "", "()V", "convertFileSizeByteCount", "", "bytes", "", "convertVideoLength", "videoLength", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaStringUtil.kt */
public final class MediaStringUtil {
    public static final MediaStringUtil INSTANCE = new MediaStringUtil();

    private MediaStringUtil() {
    }

    @JvmStatic
    public static final String convertVideoLength(long j) {
        long j2 = (long) 3600;
        long j3 = j / j2;
        long j4 = (long) 60;
        long j5 = (j % j2) / j4;
        long j6 = j % j4;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @JvmStatic
    public static final String convertFileSizeByteCount(long j) {
        if (j <= 0) {
            return "0 B";
        }
        if (j < ((long) 1000)) {
            return j + " B";
        }
        double d = (double) j;
        double d2 = (double) 1000;
        int log = (int) (Math.log(d) / Math.log(d2));
        String valueOf = String.valueOf("KMGTPE".charAt(log - 1));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return decimalFormat.format(d / Math.pow(d2, (double) log)) + StringUtils.SPACE + valueOf + "B";
    }
}
