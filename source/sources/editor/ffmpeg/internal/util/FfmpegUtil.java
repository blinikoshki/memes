package editor.ffmpeg.internal.util;

import editor.ffmpeg.api.FfmpegCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, mo26107d2 = {"Leditor/ffmpeg/internal/util/FfmpegUtil;", "", "()V", "concatenateStringArrays", "", "", "a", "b", "([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "convertInputStreamToString", "inputStream", "Ljava/io/InputStream;", "whoKnows", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegUtil.kt */
public final class FfmpegUtil {
    public static final FfmpegUtil INSTANCE = new FfmpegUtil();

    private FfmpegUtil() {
    }

    public final String convertInputStreamToString(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            Timber.m305e(e, "error converting input stream to string", new Object[0]);
            return null;
        }
    }

    public final String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, FfmpegCommand.AUDIO_STREAM);
        Intrinsics.checkNotNullParameter(strArr2, "b");
        int length = strArr.length;
        int length2 = strArr2.length;
        int i = length + length2;
        String[] strArr3 = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr3[i2] = "";
        }
        System.arraycopy(strArr, 0, strArr3, 0, length);
        System.arraycopy(strArr2, 0, strArr3, length, length2);
        return strArr3;
    }

    public final boolean whoKnows() {
        return Random.Default.nextBoolean();
    }
}
