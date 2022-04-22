package com.google.android.gms.common.util;

import com.memes.eventtracker.util.Util;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(Util.EVENT_ID_SEPARATOR);
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append("\"");
            sb.append(next);
            sb.append("\":");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str);
                sb.append("\"");
            }
        }
        sb.append("}");
    }
}
