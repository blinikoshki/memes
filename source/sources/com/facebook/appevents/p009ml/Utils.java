package com.facebook.appevents.p009ml;

import android.text.TextUtils;
import com.facebook.FacebookSdk;
import java.io.File;
import java.nio.charset.Charset;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.facebook.appevents.ml.Utils */
public class Utils {
    private static final String DIR_NAME = "facebook_ml/";

    static int[] vectorize(String str, int i) {
        int[] iArr = new int[i];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName("UTF-8"));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < bytes.length) {
                iArr[i2] = bytes[i2] & 255;
            } else {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }

    static String normalizeString(String str) {
        return TextUtils.join(StringUtils.SPACE, str.trim().split("\\s+"));
    }

    public static File getMlDir() {
        File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
