package com.getstream.sdk.chat.utils.exomedia.util;

import android.net.Uri;

public class MediaUtil {
    private MediaUtil() {
    }

    public static String getUriWithProtocol(String str) {
        if (str == null) {
            return "";
        }
        if (Uri.parse(str).getScheme() != null) {
            return str;
        }
        return "file://" + str;
    }
}
